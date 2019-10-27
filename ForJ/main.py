import argparse
import logging
import paramiko
import os
import chardet
import codecs

REMOTE_PATH = "/home/serveradmin/nee_temp"
LOCAL_PATH = "E:\\temp"
sftp_client = None
ssh_client = None

def connect(server, username, password):
    global ssh_client
    global sftp_client
    ssh_client = paramiko.SSHClient()
    known_host = paramiko.AutoAddPolicy()
    ssh_client.set_missing_host_key_policy(known_host)
    try:
        ssh_client.connect(hostname=server, port=22, username=username, password=password)
    except paramiko.SSHException:
        # logger.error("Connection error with server:{}, username:{}".format(server, username))
        exit(-1)
    client = paramiko.Transport((server, 22))
    client.connect(username=username, password=password)
    sftp_client = paramiko.SFTPClient.from_transport(client)

def list_dir(path):
    cmd = "ls --file-type " + path
    stdin, stdout, stderr = ssh_client.exec_command(cmd)
    result = stdout.read()
    return result.decode().split("\n")

def save_to_local(remote_path, name):
    try:
        save_path = LOCAL_PATH
        if not os.path.exists(save_path):
            os.makedirs(save_path)
        save_file_path = os.path.join(save_path, name)
        sftp_client.get(remote_path + "/" + name, save_file_path)

        # cmd = "cat " + os.path.join(remote_path + "/" + name)
        # stdin, stdout, stderr = ssh_client.exec_command(cmd)
        # result = stdout.read()
        # with open(save_file_path, "wb") as fd:
        #     fd.write(result)
        #     logger.info("Saving file:" + save_file_path)
    except:
        print("error")

def traverse_dir(root_path):
    nodes = list(item for item in list_dir(root_path) if len(item) > 0)
    for node in nodes:
        if node.endswith("/"):
            traverse_dir(root_path + '/' + node)
        elif node.endswith(".csv"):
            save_to_local(root_path, node)


def get_encoding(file):
    # 二进制方式读取，获取字节数据，检测类型
    with open(file, 'rb') as f:
        return chardet.detect(f.read())['encoding']

def convert_code(file_path, origin_code, to_code):
    origin_code = origin_code.upper()
    to_code = to_code.upper()
    try:
        print("convert [ " + file_path.split('\\')[-1] + " ].....From " + origin_code + " --> " + to_code)
        f = codecs.open(file_path, 'r', origin_code)
        new_content = f.read()
        codecs.open(file_path, 'w', to_code).write(new_content)
    # print (f.read())
    except IOError as err:
        print("I/O error: {0}".format(err))

def transcode(path):
    for file in os.listdir(path):
        file_path = os.path.join(path, file)
        if not os.path.isdir(file_path):
            with open(file_path, "rb") as f:
                data = f.read()
                # code_type = chardet.detect(data)['encoding']
                convert_code(file_path, "shift-jis", 'UTF-8')

if __name__ == "__main__":
    ap = argparse.ArgumentParser()
    ap.add_argument("-s", "--server", required=True, type=str, help="SSH ip")
    ap.add_argument("-p", "--port", default=22, required=False, type=str, help="SSH port")
    ap.add_argument("-u", "--username", required=True, type=str, help="SSH username")
    ap.add_argument("-pw", "--password", required=True, type=str, help="SSH password")
    args = vars(ap.parse_args())

    # connect(args["server"], args["username"], args["password"])
    # if ssh_client is None:
    #     exit(-1)
    #
    # traverse_dir(REMOTE_PATH)
    # sftp_client.close()
    # ssh_client.close()

    transcode(LOCAL_PATH)


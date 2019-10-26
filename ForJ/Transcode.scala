import java.io._
import java.util._
import org.apache.commons.io._

object Transcode {
  def mkFileOrDir(base: String, name: String, isFile: Boolean): String = {
    val path = base + File.separator + name
    val f = new File(path)
    if (!f.exists() && !f.isDirectory && !isFile) {
      f.mkdir()
    } else if (!f.exists() && !f.isFile && isFile) {
      f.createNewFile()
    }
    path
  }

  def formatTime(time: Integer): String = {
    var str = String.valueOf(time)
    if (str.length() == 1) {
      str = "0" + str
    }
    str
  }

  def main(args:Array[String]) {
    val IN_DIR = "D:\\Program\\Scala"
    val OUT_DIR = "D:\\Program\\Scala\\output"
    val OUT_ENCODE = "utf-8-sig"

    val calendar = Calendar.getInstance()
    val year = formatTime(calendar.get(Calendar.YEAR))
    val month = formatTime(calendar.get(Calendar.MONTH) + 1)
    val date = formatTime(calendar.get(Calendar.DATE))

    val inFileName =  year + month + date + "_BT_TRD_EXCE1.csv"
    println(inFileName)
    val inFile = new File(IN_DIR + File.separator + year + File.separator + month + File.separator + inFileName)
    if (!inFile.exists()) {
      return
    }
    val originEncode = EncodingDetect.getJavaEncode(inFileName)
    val fileContent = FileUtils.readFileToString(inFile, originEncode)

    val out_file_name = month + ".csv"
    var path = mkFileOrDir(OUT_DIR, year, isFile = false)
    path = mkFileOrDir(path, out_file_name, isFile = true)

    val outputFile = new File(out_file_name)
    FileUtils.write(outputFile, fileContent, OUT_ENCODE, true)
    println("test")
  }
}
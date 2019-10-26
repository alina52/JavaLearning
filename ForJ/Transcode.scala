import java.io._
import java.util._ 
import org.apache.commons.io._

object Transcode {
  def mkFileOrDir(base: String, name: String, isFile: Boolean): String = {
    var path = base + File.separator + name
    var f = new File(path)
    if (!f.exists() && !f.isDirectory() && !isFile) {
      f.mkdir()
    } else if (!f.exists() && !f.isFile() && isFile) {
      f.createNewFile()
    }
    path
  }
  
  def formatTime(time: Integer): String = {
    var str = time.toString()
    if (str.length() == 1) {
      str = "0" + str
    }
    str
  }
  
  def main(args:Array[String]) {
    var IN_DIR = "D:\\Temp\\ScalaTest2"
    var OUT_DIR = "D:\\Temp\\ScalaTest2\\output"
    var fold = new File(IN_DIR).list()
    
    var calendar = Calendar.getInstance()
    var year = formatTime(calendar.get(Calendar.YEAR))
    var month = formatTime(calendar.get(Calendar.MONTH) + 1)
    var date = formatTime(calendar.get(Calendar.DATE))
    
    var inFileName =  year + month + date + "_BT_TRD_EXCE1.csv"
    var inFilePath = IN_DIR + File.separator + year + File.separator + month + File.separator + inFileName
    var inFile = new File(inFilePath)
    if (!inFile.exists()) {
      print(1)
      return
    }
    var out_file_name = month + ".csv"
    var path = mkFileOrDir(OUT_DIR, year, false) 
    println(path)
    println("")
    path = mkFileOrDir(path, out_file_name, true)
    
    var originEncode = EncodingDetect.getJavaEncode(inFilePath)
    var fileContent = FileUtils.readFileToString(inFile, originEncode)

    println(fileContent)
    print("test")
  }
}
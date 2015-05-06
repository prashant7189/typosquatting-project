import java.io.PrintWriter

val pw = new PrintWriter("/usr/local/spark/typooutput/typo2output.txt")
var url = "www.google.com"

var len = url.length()

println(len)



for(i<- 1 to 10000)
{
var r = new scala.util.Random
var j = new scala.util.Random

var pos = r.nextInt(len-1)
var ch = j.nextPrintableChar
var n = url.take(pos-1) ++ ch.toString ++ url.drop(pos-1)
pw.println(n)

}
pw.close

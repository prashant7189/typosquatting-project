import java.io.PrintWriter

val pw = new PrintWriter("/usr/local/spark/typooutput/typo4output.txt")
var url = "www.google.com"

var len = url.length()

println(len)



for(i<- 1 to 10000)
{
var ty4 = new scala.util.Random
var ty41 = new scala.util.Random

var pos = ty4.nextInt(len)
var ch = ty41.nextPrintableChar
if (pos==0) pos=pos+1
var n = url.take(pos-1) ++ ch.toString ++ url.drop(pos)
if (n.length>len) println(pos)
pw.println(n)

}
pw.close

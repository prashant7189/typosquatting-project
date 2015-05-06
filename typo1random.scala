import java.io.PrintWriter

val pw = new PrintWriter("/usr/local/spark/typooutput/typo1output.txt")

var url = "www.google.com"
var f = ""

var len = url.length()

println(len)



for(i<- 1 to 10000)
{
var r = new scala.util.Random

var pos = r.nextInt(len-1)
pos = pos+1
var n = url.take(pos-1)++url.drop(pos)

pw.println(n)

}

pw.close

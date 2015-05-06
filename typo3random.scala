import java.io.PrintWriter

val pw = new PrintWriter("/usr/local/spark/typooutput/typo3output.txt")


var url = "www.google.com"

var len = url.length()

println(len)

var n=""

for(i <- 1 to 10000)
{
var r = new scala.util.Random
var r1 = new scala.util.Random

var pos = r.nextInt(len-1)
var pos1 = r1.nextInt(len-1)
var ch = url.charAt(pos)
var ch1= url.charAt(pos1)
var chs = ch.toString
var ch1s = ch1.toString

if (pos==pos1)n=url

else if (pos < pos1) 
{
var part1 = url.take(pos)
var part2 = url.take(pos1).drop(pos+1)
var part3 = url.drop(pos1+1)

n = part1 ++ ch1s ++ part2 ++ chs ++ part3
}

else if  (pos > pos1)
{
var par1 = url.take(pos1)
var par2 = url.take(pos).drop(pos1+1)
var par3 = url.drop(pos+1)

n= par1 ++ chs ++ par2 ++ ch1s ++ par3

}
pw.println(n)

}

pw.close

// Accepting inputs from files
import scala.io.Source

var ty1= "/usr/local/spark/typooutput/typo1output.txt" // list of typo1
var ty2= "/usr/local/spark/typooutput/typo2output.txt"// list of typo2
var ty3= "/usr/local/spark/typooutput/typo3output.txt"// list of typo3
var ty4= "/usr/local/spark/typooutput/typo4output.txt"// list of typo4

val typo1 = Source.fromFile(ty1).getLines.toList  
val typo2 = Source.fromFile(ty2).getLines.toList
val typo3 = Source.fromFile(ty3).getLines.toList
val typo4 = Source.fromFile(ty4).getLines.toList

println(typo1.length)
println(typo2.length)
println(typo3.length)
println(typo4.length)


// 25% typo1 + 25% typo2 + 10% typo3 + 40% typo4



import scala.util.Random

var shuffletypo1 = Random.shuffle(typo1).take(2200)
var shuffletypo2 = Random.shuffle(typo2).take(2800)
var shuffletypo3 = Random.shuffle(typo3).take(900)
var shuffletypo4 = Random.shuffle(typo4).take(4100)


// checking whether typo 3 and 4 contains google.com
var ty3 = shuffletypo3.exists(s=>s=="www.google.com")
var ty4 = shuffletypo4.exists(s=>s=="www.google.com")
println("In case of ty3" + ty3)
println("In the case of ty4"+ ty4)

var finallist = Random.shuffle(shuffletypo1++shuffletypo2++shuffletypo3++shuffletypo4)


println(shuffletypo1.length)
println(shuffletypo2.length)
println(shuffletypo3.length)
println(shuffletypo4.length)
println(finallist.length)

import java.io.PrintWriter
val pw = new PrintWriter("/usr/local/spark/randomdataset.txt")
val tygen = new PrintWriter("/usr/local/spark/tygen.txt")

for(i<- 1 to 4099)
{
tygen.println(shuffletypo4(i))
}

tygen.close
for (i<- 0 to finallist.length-1)
{
pw.println(finallist(i))
}
pw.close

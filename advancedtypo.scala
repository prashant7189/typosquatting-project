// Function to calculate sum of ascii values of all the characters in a string
 def ascii(list: String): Int = {

        var sum = 0
        list.foreach(x => sum = sum + x.toInt)
        return sum}





// function for calculating typo-3
def typo3(a:String, b:String):Int =      
{   

   
   if (ascii(a)==ascii(b)) return 1
   else return 0
}





// function for calculating typo-2
def typo2(x:String,y:String):Int ={

var urllen= x.length
var c = 0
var f = 0
var i = 0 
var foundIt = false 
while (i<= urllen-1 && !foundIt){

if (y(c).toInt != x(i).toInt)
{  
  c = c+1
  f = f+1

}
if (f==2) foundIt = true
c = c+1
i = i+1
}

if (f>1) return 0 else return 1
}





// function for calculating typo-1
def typo1(x:String,y:String):Int={
var typolen = y.length
var c = 0
var f = 0
var i = 0 
var foundIt = false 
while (i<= typolen-1 && !foundIt){

if (y(i).toInt != x(c).toInt)
{  
  c = c+1
  f = f+1

}
if (f==2) foundIt = true
c = c+1
i = i+1
}

if (f>1) return 0 else return 1
}







// Accepting inputs from files
import scala.io.Source

var urllist = "/usr/local/spark/urllist.txt" // list of URLs whose typos have to be checked
var listurl = "/usr/local/spark/randomdataset.txt"// list URLs to check against
var listtypo= "/usr/local/spark/listtypo.txt"// list of type of typos that needs to be found out

// Specifying the files where the output needs to be written

import java.io.PrintWriter

val pw = new PrintWriter("/usr/local/spark/typooutput.txt")


// converting the entries from the file into lists

val url = Source.fromFile(urllist).getLines.toList  
val typo = Source.fromFile(listurl).getLines.toList
val typotype = Source.fromFile(listtypo).getLines.toList

val gh = url.length
println(url)

val fh = typo.length
println(typo)

// Checking for the types of typos to be found out

var t1 = typotype.exists(s=>s=="typo1")
var t2 = typotype.exists(s=>s=="typo2")
var t3 = typotype.exists(s=>s=="typo3")


//The main program Starts
for (i<- 0 to gh-1)
{

var ty3 = ""::Nil
var ty2 = ""::Nil
var ty1 = ""::Nil
  for (j<- 0 to fh-1)
   {

// typo3 starts 
   if (t3==true){
   var x = typo3 (url(i),typo(j))
   if (x==1){

   var k = typo(j)::Nil
   ty3 = ty3:::k  
   }
   }
// typo3 ends

// typo2 starts
if (t2==true)
{ 
if (typo(j).length==url(i).length+1)
{ var y= typo2(url(i),typo(j))
    if (y==1){
var l = typo(j)::Nil
ty2 = ty2:::l
}
}
}      
// typo2 ends

// typo1 starts
if (t1==true)
{
if (typo(j).length==url(i).length-1)
{var z = typo1(url(i),typo(j))
   if (z==1){
var m = typo(j)::Nil
ty1 = ty1:::m

}
}
}
  }

// printing the results to file typooutput
if (t3==true)pw.println("The List of Typo-3 for "+url(i)+ " is "+ty3.drop(1))
pw.println("")   
println(ty3.drop(1).length)
if (t2==true)pw.println("The List of Typo-2 for "+url(i)+ " is "+ty2.drop(1))
pw.println("")   
println(ty2.drop(1).length)
if (t1==true)pw.println("The List of Typo-1 for "+url(i)+ " is "+ty1.drop(1))
println(ty1.drop(1).length)
pw.println("")   
pw.println("")   
pw.println("")   
if (i==gh-1)pw.close // closing the file in the last iteration
}








    
  

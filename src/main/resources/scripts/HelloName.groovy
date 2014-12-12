package scripts

def outString = "Hello there $name"
println "It's interesting how we can call this script - not a Groovy class"

File file = new File("$base/$outputFile")
file.write(outString)

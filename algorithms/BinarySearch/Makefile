JFLAGS = -g
JC = javac
JVM = java
FILE =
.SUFFIXES: .java .class
.java.class:
	        $(JC) $(JFLAGS) $*.java
CLASSES = \
					BinarySearch.java

MAIN = BinarySearch

default: classes
				$(JVM) $(MAIN)

classes: $(CLASSES:.java=.class)

clean:
	        $(RM) *.class

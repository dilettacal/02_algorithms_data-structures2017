# make -p -f /dev/null | less
# find -name "*.class" -delete
# find -name "*.java" >> Makefile
# find -name "Test*" >> Makfefile
# sudo apt-get install junit
# sudo find / -name junit*  

# Compile and run (JUNIT 4)
# javac -cp /usr/share/java/junit.jar $(SOURCES) ./src/test/TestStudent.java
# JUNIT 3 java -cp /usr/share/java/junit.jar:. junit.textui.TestRunner ./src/test/TestStudent.java

# Compile and run (JUNIT 4)
# javac -cp /usr/share/java/junit4.jar
# JUNIT 4 java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore ./src/test/TestStudent.java 
JCFLAGS=-g
JC=javac

#Added on 26th June
.SUFFIXES: .java .class
	$(JC) $(JFLAGS) $*.java

BINDIR=bin

JDOC=javadoc
DOCDIR=java-doc

JAVA=java

SOURCES=\
	src/main/Main.java \
	src/list/Listable.java \
	src/list/SinglyLinkedList$$Node.java \
	src/list/DoublyLinkedList$$Node.java \
	src/list/sort/BubbleSort.java \
	src/list/sort/Comparator.java \
	src/list/sort/DegreeComparator.java \
	src/list/sort/GenderComparator.java \
	src/list/sort/MatriculationNumberComparator.java \
	src/list/sort/NameComparator.java \
	src/list/sort/PrenameComparator.java \
	src/list/sort/SelectionSort.java \
	src/list/sort/Sortable.java \
	src/list/search/ElemToSearch.java \
	src/list/search/LinearSearch.java \
	src/list/search/Searchable.java \
	src/data/DataType.java \
	src/data/Degree.java \
	src/data/Student.java \
	src/data/Gender.java \
	src/test/TestListen.java \

TESTS=\
	src/test/TestStudent.java \

CLASSPATHS=bin:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

# Wichtig Pfad zur Klasse mit der public void static main Funktion. Bei mir liegt diese im Package main/Main.java 
MAIN=main.Main

TESTMAIN=test.TestStudent

default:
	mkdir -p $(BINDIR)
	$(JC) $(JCFLAGS) -cp $(CLASSPATHS) $(SOURCES) -d $(BINDIR)

run:
	$(JAVA) -cp $(CLASSPATHS) $(MAIN)

run-test: default
	$(JAVA) -cp $(CLASSPATHS) org.junit.runner.JUnitCore $(TESTMAIN)
doc:
	$(JDOC) -version -author -d $(DOCDIR) $(SOURCES)


clean:
	rm -rf $(BINDIR)

distclean: clean
	rm -rf $(DOCDIR)


students:
	@echo "Hello World"
	cd ~/Development; echo $(shell pwd)


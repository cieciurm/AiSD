#
# AiSD, cwiczenie 3
# Mateusz Cieciura, GR1
#

COMPILER = javac
JVM = java

start: ListPQueue.class TestListPQueue.class
	$(JVM) TestListPQueue

ListPQueue.class: ListPQueue.java
	$(COMPILER) $(FLAGS) $<

TestListPQueue.class: TestListPQueue.java
	$(COMPILER) $(FLAGS) $<

time: TestTime.class
	$(JVM) TestTime

TestTime.class: TestTime.java
	$(COMPILER) $<

clean:
	rm *.class

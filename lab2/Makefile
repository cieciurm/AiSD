#
# AiSD, cwiczenie 2
# Mateusz Cieciura, GR1
#

COMPILER = javac
JVM = java
FLAGS = -Xlint:unchecked

start: HeapPQueue.class TestHeapPQueue.class
	$(JVM) TestHeapPQueue

HeapPQueue.class: HeapPQueue.java
	$(COMPILER) $(FLAGS) $<

TestHeapPQueue.class: TestHeapPQueue.java
	$(COMPILER) $(FLAGS) $<

clean:
	rm *.class

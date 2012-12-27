JVM = java
COMP = javac
JSCHEDULER = src.scheduler.JScheduler

JScheduler.class: 
	$(COMP) -sourcepath $(CURDIR) src/scheduler/JScheduler.java

info: JScheduler.class
	$(JVM) -classpath $(CURDIR) $(JSCHEDULER)

test1: JScheduler.class
	$(JVM) -classpath $(CURDIR) $(JSCHEDULER) -f test/test1

test2: JScheduler.class
	$(JVM) -classpath $(CURDIR) $(JSCHEDULER) -f test/test2

test3: JScheduler.class
	$(JVM) -classpath $(CURDIR) $(JSCHEDULER) -f test/test3

clean:
	cd src/scheduler && rm *.class 

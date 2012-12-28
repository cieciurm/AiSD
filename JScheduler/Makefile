JVM = java
COMP = javac
JSCHEDULER = scheduler.JScheduler
SRCDIR = $(CURDIR)/src

JScheduler.class: 
	$(COMP) -sourcepath $(SRCDIR) src/scheduler/JScheduler.java

info: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER)

test1: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test1

test2: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test2

test3: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test3

clean:
	cd src/scheduler && rm *.class 

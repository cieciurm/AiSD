JVM = java
COMP = javac

test1: 
	$(JVM) -classpath $(CURDIR) src.scheduler.JScheduler -f test2.lol

JScheduler: JScheduler.class
	$(JVM) -classpath $(CURDIR) src.scheduler.JScheduler

JScheduler.class: 
	$(COMP) -sourcepath $(CURDIR) src/scheduler/JScheduler.java

clean:
	cd src/scheduler && rm *.class 

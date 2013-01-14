JVM = java
COMP = javac
JSCHEDULER = scheduler.JScheduler
SRCDIR = src/:
CPDIR = src/:vendor/jamon-2.73.jar
JAMONDIR = vendor/jamon-2.73.jar

default: JScheduler.class
	echo -e "#\n# Usage:\n# java -cp src/:vendor/jamon-2.73.jar scheduler.JScheduler [-f <file_with_orders>]\n#"

JScheduler.class: 
	$(COMP) -sourcepath $(SRCDIR) -cp $(JAMONDIR) src/scheduler/JScheduler.java

test1: JScheduler.class
	$(JVM) -cp $(CPDIR) $(JSCHEDULER) -f test/test1

test2: JScheduler.class
	$(JVM) -cp $(CPDIR) $(JSCHEDULER) -f test/test2

test3: JScheduler.class
	$(JVM) -cp $(CPDIR) $(JSCHEDULER) -f test/test3

stats: StatsGenerator.class
	java -cp $(CPDIR) scheduler.StatsGenerator 10 100

StatsGenerator.class:
	javac -sourcepath $(SRCDIR) -cp $(JAMONDIR) src/scheduler/StatsGenerator.java

clean:
	cd src/scheduler && rm *.class 

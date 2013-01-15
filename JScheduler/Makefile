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

stats: StatsGenerator.class
	$(JVM) -cp $(CPDIR) scheduler.StatsGenerator 10 100

StatsGenerator.class:
	$(COMP) -sourcepath $(SRCDIR) -cp $(JAMONDIR) src/scheduler/StatsGenerator.java

clean:
	cd src/scheduler && rm *.class 

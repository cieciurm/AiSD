JVM = java
COMP = javac
JSCHEDULER = scheduler.JScheduler
#SRCDIR = $(CURDIR)/src
SRCDIR = src/

talk: JScheduler.class
	echo "#\n# Usage:\n# java -classpath <current_dirrectory> src.scheduler.JScheduler -f <file_with_orders>\n#"

JScheduler.class: 
	$(COMP) -sourcepath $(SRCDIR) src/scheduler/JScheduler.java

test1: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test1

test2: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test2

test3: JScheduler.class
	$(JVM) -classpath $(SRCDIR) $(JSCHEDULER) -f test/test3

stats:
	javac -sourcepath src/ -cp vendor/jamon-2.73.jar src/scheduler/TestJScheduler.java
	java -cp src/:vendor/jamon-2.73.jar scheduler.TestJScheduler 1000 # here enter the number of jobs

clean:
	cd src/scheduler && rm *.class 

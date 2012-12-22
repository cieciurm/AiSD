package scheduler;

public class JScheduler {
	//private SchedulerHeap sh;
	//private Parser p;

	private static void help() {
		System.out.println ("# ");
		System.out.println ("# Usage:");
		System.out.println ("# java JScheduler -f file_with_orders");
		System.out.println ("# ");
	}

	public static void main(String [] args) {
		if (args.length <= 1) {
			System.out.println ("# Error! Too less parameters!");
			help();
			return;
		}

		if (!args[0].equals("-f")) 
			System.out.println ("# Error! Unknown parameter (required -f)!");
			help();
			return;
	}
}

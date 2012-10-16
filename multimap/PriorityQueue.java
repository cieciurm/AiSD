import java.util.Map;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

public class PriorityQueue {
	private Multimap<Integer, String> map;
				
	public PriorityQueue () {
		this.map = TreeMultimap.create();
	}
			
	public void insert (int key, String value) {
		this.map.put(key, value);
	}
						
	public void remove () {
		int keyOfMaxValue = 1;
						
		for (Map.Entry<Integer, String> entry : this.map.entries())
		    keyOfMaxValue = entry.getKey();

		this.map.removeAll( keyOfMaxValue );
	}															}
							
	public static void main (String [] args) {
		PriorityQueue pq = new PriorityQueue();
												
		pq.insert(666, "norril");
		pq.insert(1, "marcin");
		pq.insert(7, "mateusz");
		pq.insert(13, "jarek");
																					
		System.out.println ( pq.map );
																							
		while ( !pq.map.isEmpty() ) {
			pq.remove();
			System.out.println ( pq.map );
		}
	}
}


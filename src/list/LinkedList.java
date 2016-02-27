package list;

public class LinkedList<T> 
{
	private class Node
	{
				T 		val;
		public 	Node 	next;
		
		/**
		 * Just a constructor for a Node
		 * @param value	:	the value that the node will hold
		 */
		public Node( T value)
		{
			val = value;
		}
		
		/**
		 * get the nodes value
		 * @return the value of the node
		 */
		public T getVal()
		{
			return val;
		}
	}//END OF THE NODE PRIVATE CLASS ~~~~~~~~~~~~
	
	Node	first;
	Node 	last;
	int		nodeCount;
	
	/**
	 * @param val
	 */
	public void push_front( T val )		
	{
		Node node = new Node( val );		//A `new` node to be
		if ( last == null ) {				
			last = node;					//The `new node` is now the `last node` in the list if the list is empty
		}
		if ( first != null ) {
			node.next = first;		//if the list has some items in it, then the old first node is now the next node of the new node
		}
		first = node;				//This new node is now the first node in the list
		nodeCount++;	
	}
	
	/**
	 * add a node to the back of the list
	 * @param val the value a new node will hold
	 */
	public void push_back( T val )
	{
		Node node = new Node( val );	//A node to be
		if ( first == null) {		
			first = node;				//If the first node is null, then it means the list is empty. So, we need to set the first node to that
		}
		if( last != null ) {
			last.next = node;		//if the list has some items in it, then the old last nodes next node is the new node
		}
		last = node;
		nodeCount++;
	}
	
	/**
	 * inserts an item somewhere in the list
	 * @param where	:	where to insert the item
	 * @param val	;	a value that a new node will hold
	 */
	public void insert( int where, T val )
	{
		if ( where < 0 || where > nodeCount ) return; 	//Check for OOB
		if ( where == 0 ) {
			push_front ( val );		//Pushing into the the front is special case
			return;
		}
		if ( where == nodeCount - 1) {
			push_back ( val );		//As is the back
			return;
		}
		
		Node conductor = first;					//The "conductor" that will iterate through the list
		Node node = new Node( val );			//The node that is going to be inserted
		for (int i = 0; i < where - 1 ; i++ ) {	 //Conductor points to the node before "where" now
			conductor = conductor.next;
		}
		node.next = conductor.next;			
		conductor.next = node;
		
		nodeCount++;
	}
	
	/**
	 * @param where
	 */
	public void erase( int where )
	{
		if ( where < 0 || where > nodeCount) return;
		
		if ( where == 0 ) {		//Removing the first item in the list is a special case
			nodeCount--;
			first = first.next;
			return;
		}
		
		Node conductor = first;					 //Conductor node will be used to iterate through the list
		for ( int i = 0; i < where - 1  ; i++ )
		{
			conductor = conductor.next;
		}
		conductor.next = conductor.next.next;	 //Remove that reference by skipping over it. Node to be erased is implicitly deleted because of this
		
		if ( where == nodeCount - 1 ) {			 //If "where" happens to be the final node
            last = conductor;
        }
		nodeCount--;
	}
	
	/**
	 * clear the entire list
	 */
	public void clear()
	{
		while ( first != null ) {
			erase ( 0 );
		}
	}
	
	/**
	 * @param where
	 * @return	the wanted nodes value
	 */
	public T get( int where )
	{
		Node conductor = first;
		
		for ( int i = 0; i < where  ; i++ )
		{
			conductor = conductor.next;
		}
		return conductor.getVal();
	}
	
	/**
	 * @return the size of the list ( number of nodes )
	 */
	public int size()
	{
		return nodeCount;
	}
}
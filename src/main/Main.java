package main;

import list.LinkedList;

public class Main {

	public static void main(String[] args)
	{
		LinkedList<Integer> integerList = new LinkedList<Integer>();
		
	    integerList.push_back   ( 1 );
	    integerList.push_back   ( 2 );
	    integerList.push_back   ( 3 );
	    integerList.push_back   ( 4 );
	    integerList.push_back   ( 5 );

	    integerList.erase       ( 4 );

	    integerList.push_back   ( 6 );
	    integerList.push_front  ( 0 );
	    integerList.insert      (0, -1);
		
		
		
		for ( int i = 0; i < integerList.size(); i++ ) {
			System.out.println( integerList.get( i ) ); 	 //Prints: -1, 0, 1, 2, 3, 4, 6
		}
	}

}

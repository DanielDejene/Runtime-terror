/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

/**
 *
 * @author Runtime terror
 */

public class Node {

	String FilePath; 
       
	Node next , prev ;

	public Node (Node prev ,Node next , String filePath) {
		this.prev =prev;
		this.next =next;
		this.FilePath=filePath ;
	}

	public Node (String FilePath){
		this(null, null, FilePath);
	}
}
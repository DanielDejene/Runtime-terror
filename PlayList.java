/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Runtime terror
 */
public class PlayList {
	Node head ,tail ;
        
        FileInputStream file ;
        javazoom.jl.player.Player player ;
        

	public PlayList (){
		this.head = this.tail=null;
	}
        
        
        public void  topEl() throws FileNotFoundException, JavaLayerException {
        // TODO code application logic here
        
       
        FileInputStream file = new FileInputStream (this.head.FilePath);
        
         player = new javazoom.jl.player.Player (file);
        
        for(int j=1; j>0; j++)
        
        player.play();
         
        
    }
        
        public void stopp (){
                player.close();
        }
        
	public boolean isEmpty(){
		return this.head == null ;
	}

	public void addToEnd(String FilePath){

		Node node = new Node (FilePath);

		if(!isEmpty()){
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
		}

		else{
			this.head = this.tail = node;
		}
	}

	public void printList(){
		for(Node temp = this.head; temp!=null; temp = temp.next){
			System.out.println(temp.FilePath);
		}
          
                        
	}

 
}
package mp3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;

public class MainFrame extends JFrame implements ActionListener {
	
	
	JButton shufflebtn = new JButton ("shuffle") ;
	JButton prevbtn = new JButton ("prvies ") ;
	JButton playbtn = new JButton ("play");
	JButton nextbtn = new JButton ("next");
	JButton loopbtn =new JButton ("loop");
	JButton insertbtn = new JButton ("insert");
        JButton closebtn=new JButton("close");
	PlayList playlist = new PlayList();
	
	public MainFrame () {
		
		ImageIcon image = new ImageIcon("MainIcon.png");
		
		this.setSize(900,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Group Project");	
		this.setIconImage(image.getImage());
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		
		
		closebtn.addActionListener(this);
                playbtn.addActionListener(this);
		insertbtn.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		
		panel1.add(shufflebtn); 
		panel1.add(prevbtn);
		panel1.add(playbtn);
		panel1.add(nextbtn);
		panel1.add(shufflebtn);
		panel1.add(loopbtn);
		panel1.add(insertbtn);
		panel1.add(closebtn);
		panel1.setBounds(0,0,240,200);
		
		
		this.add(panel1);
                
		playbtn.setBackground(Color.WHITE);
                shufflebtn.setBackground(Color.BLUE);
                nextbtn.setBackground(Color.RED);
                prevbtn.setBackground(Color.ORANGE);
                loopbtn.setBackground(Color.GREEN);
                closebtn.setBackground(Color.GRAY);
                insertbtn.setBackground(Color.BLACK);
                
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playbtn) { 
                    try {
                        playlist.topEl();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
                
                else if (e.getSource() == closebtn){
                
                               playlist.stopp();
                }
		else if (e.getSource()== insertbtn) {
                    
			JFileChooser fc = new JFileChooser();
			fc.setMultiSelectionEnabled(true);
                        
			FileNameExtensionFilter filter = new FileNameExtensionFilter( "mp3 & wav audio Files . ", "mp3", "wav");
			fc.setFileFilter(filter);
			fc.setPreferredSize(new Dimension(800,500));
			
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File[] files = fc.getSelectedFiles();
				for(File file : files) {
				    String absolutePath = file.getAbsolutePath();
				   
				    playlist.addToEnd(absolutePath);
				   
				    
				}
				
			}
			
		}
	}
	
}


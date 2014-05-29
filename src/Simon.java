import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 *
 * @author alex
 */

public class Simon{
	
	JFrame frame;

	//Vector en la que almacenaremos las imagenes de Simon Dice
	BufferedImage[] _SimonDice;
	
	//Label con las imagenes de Simon Dice
    JLabel picLabel = new JLabel();        

	//Bottones que representan los botones de Simon Dice
	JButton _b1,_b2,_b3,_b4;
	
	//Botton que representa el inicio de Simon Dice
	JButton _start;
	int _startP = 0;
	int _count = 0;
	int _countin = 0;
	
	//Secuencia de entrada (in) y de salida (out) de Simon Dice
	int [] _out;
	int [] _in;
	
	
    public Simon() throws IOException, InterruptedException {
    	_SimonDice = new BufferedImage[5];
    	for(int i = 4 ; i>=0;i--){
        	_SimonDice[i] = ImageIO.read(new File("photos/"+i+".jpg"));
    	}
        picLabel.setHorizontalAlignment(JLabel.CENTER);
        picLabel.setVerticalAlignment(JLabel.CENTER);
        picLabel.setIcon(new ImageIcon(_SimonDice[_count%5]));
	    	frame = new JFrame("SimonDice");
	    	_b1 = new JButton();
	    	_b1.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent event){
	    			if(_startP==-1){
	    				_in[_countin] = 1;
	    				if(_in[_countin]!=_out[_countin*2]){
	    					try {
								new FrameError();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    					_countin=0;
	    					_startP = 0;
	    				}
	    				else{
	    					if(_countin*2==_out.length){
	    						try {
									new FrameGood();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    						_countin=0;
	    						_startP = 0;
	    					}
	    				}
	    				_countin++;
	    			}
	    		}
	    	});
	        _b2 = new JButton(); 
	        _b2.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent event){
	    			if(_startP==-1){
	    				_in[_countin] = 2;
	    				if(_in[_countin]!=_out[_countin*2]){
	    					try {
								new FrameError();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    					_countin=0;
	    					_startP = 0;
	    				}
	    				else{
	    					if(_countin*2==_out.length){
	    						try {
									new FrameGood();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    						_countin=0;
	    						_startP = 0;
	    					}
	    				}
	    				_countin++;
	    			}
	    		}
	    	});
	        _b3 = new JButton();
	        _b3.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent event){
	    			if(_startP==-1){
	    				_in[_countin] = 3;
	    				if(_in[_countin]!=_out[_countin*2]){
	    					try {
								new FrameError();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    					_countin=0;
	    					_startP = 0;
	    				}
	    				else{
	    					if(_countin*2==_out.length){
	    						try {
									new FrameGood();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    						_countin=0;
	    						_startP = 0;
	    					}
	    				}
	    				_countin++;
	    			}
	    		}
	    	});
	        _b4 = new JButton();
	        _b4.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent event){
	    			if(_startP==-1){
	    				_in[_countin] = 4;
	    				if(_in[_countin]!=_out[_countin*2]){
	    					try {
								new FrameError();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    					_countin=0;
	    					_startP = 0;
	    				}
	    				else{
	    					if(_countin*2==_out.length){
	    						try {
									new FrameGood();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    						_countin=0;
	    						_startP = 0;
	    					}
	    				}
	    				_countin++;	    				
	    			}
	    		}
	    	});
	        _start = new JButton();
	        _start.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					if(_startP==0){
						_startP = 1;
		        		int random = (int)(Math.round(Math.random()*12)+3);
		        		_in = new int[random];
		        		_out = new int[random*2];
		        		for(int i=0;i<random*2;i++){
		        			if(i%2==0){
		        				int random2 = (int)(Math.random()*4)+1;
		        				_out[i] = random2;
		        			}
		        			else
		        				_out[i] = 0;
		        		} 
					}
		    }
			});
	        ActionListener actionListener = new ActionListener() {
		            public void actionPerformed(ActionEvent actionEvent) {
		            	if(_startP==1){
		            		if(_count<_out.length){
		            		picLabel.setIcon(new ImageIcon(_SimonDice[_out[_count]]));
		            		_count++;
		            		}	
		            		else{
		            			_count=0;
		            			_startP=-1;
		            		}
		            	}
		            	
		            }
		    };
		    Timer timer = new Timer( 500, actionListener );
		    timer.setRepeats(true);
		    timer.start();
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize(); 
	        int w = frame.getSize().width;
			int h = frame.getSize().height;
			int x = (dim.width-w)/2;
			int y = (dim.height-h)/2;
	        _start.setSize(25, 25);
	        _start.setLocation(316, 288);
	        _start.setBackground(new Color(1f,1f,1f,1f));
	        _start.setBorderPainted(true);
	        _start.setOpaque(true);
	        _start.setContentAreaFilled(true);
	        
	        _b1.setLocation(150,95);
	        _b1.setSize(80, 80);
	        _b1.setBackground(new Color(1f,1f,1f,0f));
	        _b1.setBorderPainted(false);
	        _b1.setOpaque(false);
	        _b1.setContentAreaFilled(false);


	        _b2.setLocation(365,95);
	        _b2.setSize(80, 80);
	        _b2.setBackground(new Color(1f,1f,1f,0f));
	        _b2.setBorderPainted(false);
	        _b2.setOpaque(false);
	        _b2.setContentAreaFilled(false);

	        
	        _b3.setLocation(385,340);
	        _b3.setSize(80, 80);
	        _b3.setBackground(new Color(1f,1f,1f,0f));
	        _b3.setBorderPainted(false);
	        _b3.setOpaque(false);
	        _b3.setContentAreaFilled(false);

	        
	        _b4.setLocation(145,350);
	        _b4.setSize(80, 80);
	        _b4.setBackground(new Color(1f,1f,1f,0f));
	        _b4.setBorderPainted(false);
	        _b4.setOpaque(false);
	        _b4.setContentAreaFilled(false);
	        
	        picLabel.setLocation(x, y);
	        frame.setSize(600, 600);
	        frame.add(_b1);
	        frame.add(_b2);
	        frame.add(_b3);
	        frame.add(_b4);
			frame.add(_start);
			frame.add(picLabel);
	        frame.setLocationRelativeTo(null);
	 		frame.setLocation(x/2, y/2);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
        }

    class FrameError {
    	public FrameError() throws IOException{
    			JFrame fram = new JFrame("Error");
    		    JLabel label = new JLabel();       
        		label.setIcon(new ImageIcon(ImageIO.read(new File("photos/bad.jpeg"))));
				Dimension dim=Toolkit.getDefaultToolkit().getScreenSize(); 
				int w = fram.getSize().width;
				int h = fram.getSize().height;
				int x = (dim.width-w)/2;
				int y = (dim.height-h)/2;
				fram.add(label);
		 		fram.setLocation(x, y);
		 		fram.setSize(225, 225);
				fram.setResizable(false);
		 		fram.setVisible(true);
    	}
    }
    class FrameGood {
    	public FrameGood() throws IOException{
    			JFrame fram = new JFrame("Good");
    		    JLabel label = new JLabel();  
        		label.setIcon(new ImageIcon(ImageIO.read(new File("photos/good.jpeg"))));
				Dimension dim=Toolkit.getDefaultToolkit().getScreenSize(); 
				int w = fram.getSize().width;
				int h = fram.getSize().height;
				int x = (dim.width-w)/2;
				int y = (dim.height-h)/2;
				fram.add(label);
		 		fram.setLocation(x, y);
		 		fram.setSize(200, 200);
				fram.setResizable(false);
		 		fram.setVisible(true);
    	}
    }

    public static void main(String args[]) throws IOException, InterruptedException {
    	new Simon();
    }
}

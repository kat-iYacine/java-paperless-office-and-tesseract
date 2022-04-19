

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.sourceforge.tess4j.TesseractException;

public class ImageRecon extends JFrame {
	
	private ImageIcon image;
	private JLabel label,pathLabel;
	private JPanel panel,p0,p1;
	private JScrollPane scroll;
	private GridLayout grid;
	private JButton openFile_button;
	Point startDrag;
	Point endDrag;
	String path = "img/eurotext.png";

	public ImageRecon() {
		
		setVisible(true);
		setSize(320, 240);
		setTitle("Image");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		image = new ImageIcon(getClass().getResource(path));		
		label = new JLabel(image);
		
		p0 = new JPanel();
		p1 = new JPanel();
		panel = new JPanel(new BorderLayout());
		
		scroll = new JScrollPane(p0);
		p0.add(label);
		
		openFile_button = new JButton("Open");
		pathLabel = new JLabel("Hello");	
		
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.add(openFile_button);
		p1.add(pathLabel);
	
		panel.add(scroll, BorderLayout.WEST);
		panel.add(p1, BorderLayout.EAST);
		
		add(panel);
		pack();
		
	}
	
	public void getCoord() throws TesseractException {
		label.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				startDrag = e.getPoint();
				
				System.out.println("X = " + startDrag.x);
				System.out.println("Y = " + startDrag.y);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				endDrag = e.getPoint();
				
	System.out.println("Width = " + (endDrag.x - startDrag.x));
	System.out.println("Height = " + (endDrag.y - startDrag.y));
				
	try {
                 Test.recon(startDrag.x,
                            startDrag.y,
                            endDrag.x - startDrag.x,
	                       endDrag.y - startDrag.y,
					 path);
				} 

       catch (TesseractException e1) {					
					System.out.println(e1.getMessage());
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}

}

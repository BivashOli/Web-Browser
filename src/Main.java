import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Main {

	private JFrame frame;
	private JTextField addressBar;
	private JEditorPane display;
	private ScrollPane scrollPane;
	 
	public Main() {
		init();
		window();
	}

	private void init() {
		frame = new JFrame("Browser");
		addressBar = new JTextField("Enter URL");
		addressBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPage(addressBar.getText());
			}
		});
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					loadPage(e.getURL().toString()); 
				}
			}
		});
		scrollPane = new ScrollPane();
		scrollPane.add(display);
	}

	private void window() {
		frame.add(addressBar, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 
	}

	private void loadPage(String url) {
		try{
			display.setPage(url); 
			
		}catch(Exception e){
			System.out.println("Not a url");  
		}
	}
	
	public static void main(String args[]){
		new Main();
	}
}

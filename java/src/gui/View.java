package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class View extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	
    Model model;
    
    View(Model model) throws IOException {
    	
    	super();
        this.model = model;
        this.setBackground(Color.WHITE);

        
    }
    
    public void update(Observable obs, Object arg) {
    
		if(arg == null) return;
		
        if(arg == "rotatedRight"){
        	
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	
    }
}
    
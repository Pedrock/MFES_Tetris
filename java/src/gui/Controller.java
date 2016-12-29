package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Controller extends JFrame  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel buttonPanel = new JPanel();
    JButton rotateRightButton;

    Model model;
    View view;
    public static TetrisControl tetris; 

    public Controller() {
    	// Allow Overture to do a controlled shutdown 
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	this.model = new Model();
    	
    	//add buttons
    	rotateRightButton = new JButton("Rotate Right");
    	
    	setSize(350,150);  
        init();
        setVisible(true);  
    }

    public void init() {
    	try {
    		view = new View(model);
    	} catch (IOException ex) {
    		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	attachListenersToComponents();
    	layOutComponents();
    	// Connect model and view
    	model.addObserver(view);
    }

    private void attachListenersToComponents() {

    	rotateRightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tetris.RotateRight();
            }
        });
    }
    
    private void layOutComponents() {
        setLayout(new BorderLayout());
        this.add(BorderLayout.SOUTH, buttonPanel);
        buttonPanel.add(rotateRightButton);
    	this.add(BorderLayout.CENTER, view);
    	
		this.setVisible(true);
    }

    
    public void DisableButtons()
    { 	
    	rotateRightButton.setEnabled(false);
    }
    
    public void EnableButtons()
    {
    	rotateRightButton.setEnabled(true);
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }
    
    /**
     * Notify the smoke controller that the JFrame is going down
     */
    @Override
    public void dispose()
    {
    	tetris.finish();
    }
}

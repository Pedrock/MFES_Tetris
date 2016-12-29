package gui;

import org.overture.interpreter.debug.RemoteControl;
import org.overture.interpreter.debug.RemoteInterpreter;

public class TetrisRemote implements RemoteControl {

	RemoteInterpreter interpreter;
	@Override
	public void run(RemoteInterpreter intrprtr) throws Exception {
	
		interpreter = intrprtr;
		TetrisControl ctrl = new TetrisControl(interpreter);

		ctrl.init();
		
		Controller.tetris = ctrl;
		new Controller();
	}
}

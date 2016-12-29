package gui;

import java.io.Serializable;

import org.overture.interpreter.values.Value;
import org.overture.interpreter.values.VoidValue;

public class Graphics implements Serializable  {

	private static final long serialVersionUID = 1L;
	transient Controller ctrl;
	Model model;
	public Value init() {
		try {
			ctrl = new Controller();
			model = ctrl.getModel();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return new VoidValue();
	}

	public Value rotatedRight()  {

		model.rotatedRight();
		return new VoidValue();
	}

}
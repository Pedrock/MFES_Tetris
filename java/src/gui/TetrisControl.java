package gui;

import org.overture.interpreter.debug.RemoteInterpreter;
import org.overture.interpreter.values.Value;

public class TetrisControl
{

	private RemoteInterpreter interpreter;

	public TetrisControl(RemoteInterpreter intrprtr)
	{
		interpreter = intrprtr;
		Controller.tetris = this;
	}

	public void init()
	{
		try
		{
			execute("create t := new Tetris()");
			execute("t.begin()");	
			Value t = execute("t");
			System.out.println(t);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void RotateRight()
	{
		try
		{
			execute("t.rotateRight()");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private Value execute(String arguments) throws Exception
	{
		String cmd = arguments;
		if (cmd.toLowerCase().startsWith("create"))
		{
			cmd = cmd.substring(cmd.indexOf(" "));
			cmd = cmd.trim();
			String name = cmd.substring(0, cmd.indexOf(" "));
			String exp = cmd.substring(cmd.indexOf(":=") + 2);
			System.out.println("CREATE:  var: " + name + " exp: " + exp);
			interpreter.create(name, exp);
			return null;
		} else if (cmd.toLowerCase().startsWith("debug")
				|| cmd.toLowerCase().startsWith("print"))
		{
			cmd = /* "p" + */cmd.substring(cmd.indexOf(" "));

			cmd = cmd.trim();
		}

		try
		{
			System.out.println("Calling VDMJ with: " + cmd);
			Value result = interpreter.valueExecute(cmd);
			return result;
		} catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * Notifies Overture that the remote interface is being disposed and that interpretation is finished. After this
	 * Overture is allowed to terminate the current process.
	 */
	public void finish()
	{
		this.interpreter.finish();
	}
}

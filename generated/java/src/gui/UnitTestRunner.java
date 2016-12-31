package gui;

import java.util.*;
import org.overture.codegen.runtime.*;

import junit.textui.TestRunner;
import vdmtetris.UnitTests;

@SuppressWarnings("all")
public class UnitTestRunner {
	
	public static void main(String[] args) {
		new TestRunner().run(UnitTests.class);
	}
	
}

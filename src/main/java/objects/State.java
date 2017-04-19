package objects;

import java.util.HashMap;
import java.util.Map;

public class State {
	String name;
	String basetax;
	String maxsurtax;
	Map<String, String> cattax;
	
	public State(String name, String basetax, String maxsurtax){
		this.name = name;
		this.basetax = basetax;
		this.maxsurtax = maxsurtax;
		cattax = new HashMap<String, String>();
		cattax.put("groceries", "");
		cattax.put("preparedfood", "");
		cattax.put("prescriptiondrug", "");
		cattax.put("nonprescriptiondrug", "");
		cattax.put("clothing", "");
	}
}

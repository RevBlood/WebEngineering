package exercise1;

import java.util.List;

public class TableAsXML {
	
	String XML = "";

	
	public TableAsXML(List<String> Names) {
		this.XML += "<table>\n";
		for (String name : Names) {
			this.XML += "<T>\n<Name>" + name + "</Name>\n</T>\n";
		}
		this.XML += "</table>";
	}
	
	public String getXML() {
		return XML;
	}
}

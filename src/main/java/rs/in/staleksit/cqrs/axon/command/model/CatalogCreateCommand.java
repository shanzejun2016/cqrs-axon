package rs.in.staleksit.cqrs.axon.command.model;

import java.io.Serializable;

public class CatalogCreateCommand implements Serializable {
	private static final long serialVersionUID = 5131904219752209738L;
	
	private final String catalogName;
	
	public CatalogCreateCommand(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public String getCatalogName() {
		return catalogName;
	}

}

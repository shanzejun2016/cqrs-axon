package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class CatalogCommand implements Serializable {
	
	private final String catalogName;

	public CatalogCommand(String name) {
		this.catalogName = name;
	}
	
	public String getCatalogName() {
		return catalogName;
	}

}

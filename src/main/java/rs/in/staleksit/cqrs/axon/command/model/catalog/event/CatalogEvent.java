package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class CatalogEvent implements Serializable {
	
	private final String catalogName;
	
	public CatalogEvent(String name) {
		this.catalogName = name;
	}

	public String getCatalogName() {
		return catalogName;
	}

}

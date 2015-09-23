package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class CatalogEvent implements Serializable {
	
	private final String catalogId;
	
	public CatalogEvent(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogId() {
		return catalogId;
	}
	

}

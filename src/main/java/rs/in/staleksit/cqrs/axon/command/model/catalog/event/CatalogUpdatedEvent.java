package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

public class CatalogUpdatedEvent extends CatalogEvent {
	private static final long serialVersionUID = 6315794683074936844L;
	
	private final String catalogName;
	
	public CatalogUpdatedEvent(String catalogId, String catalogName) {
		super(catalogId);
		this.catalogName = catalogName;
	}
	
	public String getCatalogName() {
		return catalogName;
	}

}

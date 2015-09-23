package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

public class CatalogDeletedEvent extends CatalogEvent {
	private static final long serialVersionUID = 9204204378345382678L;
	
	public CatalogDeletedEvent(String catalogId) {
		super(catalogId);
	}
	
}

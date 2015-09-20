package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

public class CatalogDeletedEvent extends CatalogEvent {
	private static final long serialVersionUID = 9204204378345382678L;
	
	private Integer catalogId;

	public CatalogDeletedEvent(Integer id, String name) {
		super(name);
		this.catalogId = id;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}

}

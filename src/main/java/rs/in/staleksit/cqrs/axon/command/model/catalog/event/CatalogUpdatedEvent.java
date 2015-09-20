package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

public class CatalogUpdatedEvent extends CatalogEvent {
	private static final long serialVersionUID = 6315794683074936844L;
	
	private Integer catalogId;

	public CatalogUpdatedEvent(Integer catalogId, String name) {
		super(name);
		this.catalogId = catalogId;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}

}

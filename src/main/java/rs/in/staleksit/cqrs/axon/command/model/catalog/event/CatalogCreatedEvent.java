/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

public class CatalogCreatedEvent extends CatalogEvent {
	private static final long serialVersionUID = -6639673893915680467L;
	
	private final String catalogName;

	public CatalogCreatedEvent(String catalogId, String catalogName) {
		super(catalogId);
		this.catalogName = catalogName;
	}
	
	public String getCatalogName() {
		return catalogName;
	}
	
}

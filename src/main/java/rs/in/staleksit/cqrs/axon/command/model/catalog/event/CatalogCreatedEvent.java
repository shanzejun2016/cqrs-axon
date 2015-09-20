/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.catalog.event;

/**
 *
 */
public class CatalogCreatedEvent extends CatalogEvent {
	private static final long serialVersionUID = -6639673893915680467L;

	public CatalogCreatedEvent(String name) {
		super(name);
	}

	
}

/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model;

import java.io.Serializable;

/**
 *
 */
public class CatalogCreatedEvent implements Serializable {
	private static final long serialVersionUID = -6639673893915680467L;
	
	private final String catalogName;
	
	public CatalogCreatedEvent(String name) {
		this.catalogName = name;
	}

	public String getCatalogName() {
		return catalogName;
	}
	
}

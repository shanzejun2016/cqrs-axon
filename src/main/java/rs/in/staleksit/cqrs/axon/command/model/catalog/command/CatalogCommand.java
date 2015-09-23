package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

import java.io.Serializable;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

@SuppressWarnings("serial")
public abstract class CatalogCommand implements Serializable {
	
	@TargetAggregateIdentifier
	private final String catalogId;

	public CatalogCommand(String catalogId) {
		this.catalogId = catalogId;
	}
	
	public String getCatalogId() {
		return catalogId;
	}

}

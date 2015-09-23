package rs.in.staleksit.cqrs.axon.command.model.catalog;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogCreateCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogDeleteCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogUpdateCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogCreatedEvent;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogDeletedEvent;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogUpdatedEvent;

public class CatalogItem extends AbstractAnnotatedAggregateRoot<String>{
	private static final long serialVersionUID = 3499110356966221166L;
	
	@AggregateIdentifier
	private String catalogId;
	
	private String catalogName;
	
	public CatalogItem() {
		
	}
	
	// CREATE
	@CommandHandler
	public CatalogItem(CatalogCreateCommand command) {
		apply(new CatalogCreatedEvent(command.getCatalogId(), command.getCatalogName()));
	}
	
	@EventHandler
    public void onCatalogCreated(CatalogCreatedEvent event) {
        this.catalogId = event.getCatalogId();
        this.catalogName = event.getCatalogName();
    }
	
	// UPDATE
	@CommandHandler
	public void catalogUpdated(CatalogUpdateCommand command) {
		apply(new CatalogUpdatedEvent(command.getCatalogId(), command.getCatalogName()));
	}
	
	@EventHandler
    public void onCatalogUpdated(CatalogUpdatedEvent event) {
        this.catalogId = event.getCatalogId();
        this.catalogName = event.getCatalogName();
    }

	// DELETE
	@CommandHandler
	public void catalogDeleted(CatalogDeleteCommand command) {
		apply(new CatalogDeletedEvent(command.getCatalogId()));
	}
	
	public String getCatalogName() {
		return catalogName;
	}
		
}

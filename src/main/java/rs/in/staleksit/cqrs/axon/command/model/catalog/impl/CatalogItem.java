package rs.in.staleksit.cqrs.axon.command.model.catalog.impl;

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
	private String id;
		
	public CatalogItem() {
		
	}
	
	// CREATE
	@CommandHandler
	public CatalogItem(CatalogCreateCommand command) {
		apply(new CatalogCreatedEvent(command.getCatalogName()));
	}
	
	@EventHandler
    public void on(CatalogCreatedEvent event) {
        this.id = event.getCatalogName();
    }
	
	// UPDATE
	@CommandHandler
	public CatalogItem(CatalogUpdateCommand command) {
		apply(new CatalogUpdatedEvent(command.getCatalogId(), command.getCatalogName()));
	}

	@EventHandler
    public void on(CatalogUpdatedEvent event) {
        this.id = event.getCatalogName();
    }
	
	// DELETE
	@CommandHandler
	public CatalogItem(CatalogDeleteCommand command) {
		apply(new CatalogDeletedEvent(command.getCatalogId(), command.getCatalogName()));
	}

	@EventHandler
    public void on(CatalogDeletedEvent event) {
        this.id = event.getCatalogName();
    }
	
}

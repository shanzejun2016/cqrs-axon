package rs.in.staleksit.cqrs.axon.command.model;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class CatalogItem extends AbstractAnnotatedAggregateRoot<String>{
	private static final long serialVersionUID = 3499110356966221166L;
	
	@AggregateIdentifier
	private String id;
		
	public CatalogItem() {
		
	}
	
	@CommandHandler
	public CatalogItem(CatalogCreateCommand command) {
		apply(new CatalogCreatedEvent(command.getCatalogName()));
	}
	
	@EventHandler
    public void on(CatalogCreatedEvent event) {
        this.id = event.getCatalogName();
    }

}

package rs.in.staleksit.cqrs.axon.command.model.catalog;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.domain.MetaData;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogCreatedEvent;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogDeletedEvent;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogUpdatedEvent;

public class CatalogItem extends AbstractAnnotatedAggregateRoot<String>{
	private static final long serialVersionUID = 3499110356966221166L;
	
	@AggregateIdentifier
	private String catalogId;
	
	private String catalogName;
	
	public CatalogItem() {
		// needed by framework
	}
	
	/**
	 * default constructor
	 * @param catalogId
	 * @param catalogName
	 */
	public CatalogItem(String catalogId, String catalogName) {
		apply(new CatalogCreatedEvent(catalogId, catalogName));
	}
	
	@EventHandler
    public void onCatalogCreated(CatalogCreatedEvent event) {
        this.catalogId = event.getCatalogId();
        this.catalogName = event.getCatalogName();
    }
	
	public void update(String catalogId, String newCatalogName) {
		Map<String, String> someUsefullInformation = new HashMap<String, String>();
		someUsefullInformation.put("IP-Address", "127.0.0.1");

		apply(new CatalogUpdatedEvent(catalogId, newCatalogName), MetaData.from(someUsefullInformation));
	}
	
	@EventHandler
    public void onCatalogUpdated(CatalogUpdatedEvent event) {
        this.catalogId = event.getCatalogId();
        this.catalogName = event.getCatalogName();
    }
	
	public void delete(String catalogId) {
		apply(new CatalogDeletedEvent(catalogId));
	}
	
	public String getCatalogName() {
		return catalogName;
	}
		
}

package rs.in.staleksit.cqrs.axon.eventhandler.catalog;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.in.staleksit.cqrs.axon.command.model.catalog.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogDeletedEvent;
import rs.in.staleksit.cqrs.axon.command.service.catalog.CatalogService;

@Component
public class CatalogDeletedEventHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CatalogDeletedEventHandler.class);
	
	@Autowired
	private CatalogService catalogService;
	
	@EventHandler
	public void handle(CatalogDeletedEvent event) {
		Catalog catalogToDelete = catalogService.findOneById(event.getCatalogId());
		catalogService.delete(catalogToDelete);
		LOG.info("System deleted Catalog with [id: {}, name: {}]", event.getCatalogId(), event.getCatalogName());
	}

}

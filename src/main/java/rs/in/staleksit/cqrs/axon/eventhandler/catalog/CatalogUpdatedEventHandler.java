package rs.in.staleksit.cqrs.axon.eventhandler.catalog;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogUpdatedEvent;
import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;
import rs.in.staleksit.cqrs.axon.query.service.catalog.CatalogService;

@Component
public class CatalogUpdatedEventHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CatalogUpdatedEventHandler.class);
	
	@Autowired
	private CatalogService catalogService;
	
	@EventHandler
	public void handle(CatalogUpdatedEvent event) {
		CatalogDTO dto = catalogService.update(event.getCatalogId(), event.getCatalogName());
		LOG.info("System updated Catalog with [id: {}, name: {}]", dto.getId(), dto.getName());
	}

}

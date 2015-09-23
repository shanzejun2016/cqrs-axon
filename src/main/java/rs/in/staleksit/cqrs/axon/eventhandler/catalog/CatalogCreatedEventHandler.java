package rs.in.staleksit.cqrs.axon.eventhandler.catalog;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.in.staleksit.cqrs.axon.command.model.catalog.event.CatalogCreatedEvent;
import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;
import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.CatalogImpl;
import rs.in.staleksit.cqrs.axon.query.service.catalog.CatalogService;

@Component
public class CatalogCreatedEventHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CatalogCreatedEventHandler.class);
	
	@Autowired
	private CatalogService catalogService;
	
	@EventHandler
	public void handle(CatalogCreatedEvent event) {
		CatalogDTO dto = catalogService.save(new CatalogImpl(event.getCatalogId(), event.getCatalogName()));
		LOG.info("System persisted new Catalog with [id: {}, name: {}]", dto.getId(), dto.getName());
	}
	

}

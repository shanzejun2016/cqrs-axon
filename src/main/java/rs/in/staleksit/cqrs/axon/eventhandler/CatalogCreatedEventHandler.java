package rs.in.staleksit.cqrs.axon.eventhandler;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.in.staleksit.cqrs.axon.command.model.CatalogCreatedEvent;
import rs.in.staleksit.cqrs.axon.command.model.dto.CatalogDTO;
import rs.in.staleksit.cqrs.axon.command.model.impl.CatalogImpl;
import rs.in.staleksit.cqrs.axon.command.service.CatalogService;

@Component
public class CatalogCreatedEventHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CatalogCreatedEventHandler.class);
	
	@Autowired
	private CatalogService catalogService;
	
	@EventHandler
	public void handle(CatalogCreatedEvent event) {
		CatalogDTO dto = catalogService.save(new CatalogImpl(event.getCatalogName()));
		LOG.info("System persisted new Catalog with [id: {}, name: {}]", dto.getId(), dto.getName());
	}
	

}

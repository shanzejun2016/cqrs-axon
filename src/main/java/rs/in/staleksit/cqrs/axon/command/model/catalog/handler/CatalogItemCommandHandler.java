/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.catalog.handler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import rs.in.staleksit.cqrs.axon.command.model.catalog.CatalogItem;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogCreateCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogDeleteCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogUpdateCommand;

/**
 *
 */
@Component
public class CatalogItemCommandHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogItemCommandHandler.class);

	@Autowired
	@Qualifier("catalogEventRepository")
	private Repository<CatalogItem> catalogItemRepository;

	// CREATE
	@CommandHandler
	public void handle(final CatalogCreateCommand command, UnitOfWork unitOfWork) {
		LOG.info("handling catalogCreate: command: {}", command);
		CatalogItem catalogItem = new CatalogItem(command.getCatalogId(), command.getCatalogName());
		catalogItemRepository.add(catalogItem);
	}
	
	// UPDATE
	@CommandHandler
	public void catalogUpdated(CatalogUpdateCommand command) {
		LOG.info("handling catalogUpdate: command: {}", command);
		CatalogItem catalogItemToUpdate = catalogItemRepository.load(command.getCatalogId());
		catalogItemToUpdate.update(command.getCatalogId(), command.getCatalogName());
	}
	
	// DELETE
	@CommandHandler
	public void catalogDeleted(CatalogDeleteCommand command) {
		LOG.info("handling catalogDelete: command: {}", command);
		CatalogItem catalogItemToDelete = catalogItemRepository.load(command.getCatalogId());
		catalogItemToDelete.delete(catalogItemToDelete.getIdentifier());
	}
	
	

}

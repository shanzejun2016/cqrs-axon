package rs.in.staleksit.cqrs.axon.command.service.catalog;

import rs.in.staleksit.cqrs.axon.command.model.catalog.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;

public interface CatalogService {
	
	Catalog findOneById(Integer id);
	
	CatalogDTO save(Catalog catalog);
	
	CatalogDTO update(Integer id, String newCatalogName);
	
	void delete(Catalog catalog);
	

}

package rs.in.staleksit.cqrs.axon.query.service.catalog;

import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;
import rs.in.staleksit.cqrs.axon.query.model.catalog.Catalog;

public interface CatalogService {
	
	Catalog findByName(String name);
	
	CatalogDTO save(Catalog catalog);
	
	CatalogDTO update(String id, String newCatalogName);
	
	void delete(String id);
	

}

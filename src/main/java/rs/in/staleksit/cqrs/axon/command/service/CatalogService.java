package rs.in.staleksit.cqrs.axon.command.service;

import rs.in.staleksit.cqrs.axon.command.model.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.dto.CatalogDTO;

public interface CatalogService {
	
	Catalog findOneById(Integer id);
	
	CatalogDTO save(Catalog catalog);
	

}

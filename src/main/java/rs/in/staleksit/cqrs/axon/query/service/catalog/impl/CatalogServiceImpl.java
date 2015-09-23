package rs.in.staleksit.cqrs.axon.query.service.catalog.impl;


import org.jtransfo.JTransfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;
import rs.in.staleksit.cqrs.axon.query.model.catalog.Catalog;
import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.CatalogImpl;
import rs.in.staleksit.cqrs.axon.query.repository.CatalogRepository;
import rs.in.staleksit.cqrs.axon.query.service.catalog.CatalogService;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	private JTransfo jTransfo;

	@Transactional
	public CatalogDTO save(Catalog catalog) {
		CatalogImpl catalogImpl = catalogRepository.save((CatalogImpl) catalog);
		return jTransfo.convert(catalogImpl, new CatalogDTO());
	}

	@Transactional
	public CatalogDTO update(String id, String newCatalogName) {
		CatalogImpl catalogToUpdate = catalogRepository.findOne(id);
		if (catalogToUpdate != null) {
			catalogToUpdate.setName(newCatalogName);
		}
		return jTransfo.convert(catalogToUpdate, new CatalogDTO());
	}

	@Transactional
	public void delete(String id) {
		CatalogImpl catalogToDelete = catalogRepository.findOne(id);
		if (catalogToDelete != null) {
			catalogRepository.delete(catalogToDelete);
		}
	}

	public Catalog findByName(String name) {
		return catalogRepository.findByName(name);
	}
	
}

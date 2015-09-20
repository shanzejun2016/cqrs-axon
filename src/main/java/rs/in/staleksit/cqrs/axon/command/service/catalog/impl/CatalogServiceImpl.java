package rs.in.staleksit.cqrs.axon.command.service.catalog.impl;


import org.jtransfo.JTransfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.in.staleksit.cqrs.axon.command.model.catalog.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.catalog.impl.CatalogImpl;
import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.CatalogDTO;
import rs.in.staleksit.cqrs.axon.command.repository.catalog.CatalogRepository;
import rs.in.staleksit.cqrs.axon.command.service.catalog.CatalogService;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	private JTransfo jTransfo;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Catalog findOneById(Integer id) {
		CatalogImpl catalogItem = catalogRepository.findOne(id);
		return catalogItem;
	}

	@Transactional
	public CatalogDTO save(Catalog catalog) {
		CatalogImpl catalogImpl = catalogRepository.save((CatalogImpl) catalog);
		return jTransfo.convert(catalogImpl, new CatalogDTO());
	}

	@Transactional
	public CatalogDTO update(Integer id, String newCatalogName) {
		CatalogImpl catalogToUpdate = catalogRepository.findOne(id);
		if (catalogToUpdate != null) {
			catalogToUpdate.setName(newCatalogName);
		}
		return jTransfo.convert(catalogToUpdate, new CatalogDTO());
	}

	@Transactional
	public void delete(Catalog catalog) {
		catalogRepository.delete((CatalogImpl) catalog);
	}
	
}

package rs.in.staleksit.cqrs.axon.command.service.impl;

import org.jtransfo.JTransfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.in.staleksit.cqrs.axon.command.model.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.dto.CatalogDTO;
import rs.in.staleksit.cqrs.axon.command.model.impl.CatalogImpl;
import rs.in.staleksit.cqrs.axon.command.repository.CatalogRepository;
import rs.in.staleksit.cqrs.axon.command.service.CatalogService;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	private JTransfo jTransfo;

	public Catalog findOneById(Integer id) {
		CatalogImpl catalogItem = catalogRepository.findOne(id);
		return catalogItem;
	}

	public CatalogDTO save(Catalog catalog) {
		CatalogImpl catalogImpl = catalogRepository.save((CatalogImpl) catalog);
		return jTransfo.convert(catalogImpl, new CatalogDTO());
	}

}

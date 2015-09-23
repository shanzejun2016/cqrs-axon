package rs.in.staleksit.cqrs.axon.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.CatalogImpl;

public interface CatalogRepository extends JpaRepository<CatalogImpl, String> {
	
	CatalogImpl findByName(String name);

}

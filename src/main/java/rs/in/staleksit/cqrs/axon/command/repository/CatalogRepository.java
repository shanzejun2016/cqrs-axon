package rs.in.staleksit.cqrs.axon.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.in.staleksit.cqrs.axon.command.model.impl.CatalogImpl;

public interface CatalogRepository extends JpaRepository<CatalogImpl, Integer> {

}

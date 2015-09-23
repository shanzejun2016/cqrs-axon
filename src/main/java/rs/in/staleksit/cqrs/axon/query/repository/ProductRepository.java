package rs.in.staleksit.cqrs.axon.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.ProductImpl;

public interface ProductRepository extends JpaRepository<ProductImpl, String> {

}

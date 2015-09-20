package rs.in.staleksit.cqrs.axon.command.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.in.staleksit.cqrs.axon.command.model.catalog.impl.ProductImpl;

public interface ProductRepository extends JpaRepository<ProductImpl, Integer> {

}

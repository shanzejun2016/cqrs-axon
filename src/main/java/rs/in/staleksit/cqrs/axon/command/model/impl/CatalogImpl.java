package rs.in.staleksit.cqrs.axon.command.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import rs.in.staleksit.cqrs.axon.command.model.Catalog;

/**
 * `ca_catalog` cqrs-axon catalog/ (ca) catalog 
 */
@Entity
@Table(name = "ca_catalog")
public class CatalogImpl extends AbstractPersistable<Integer> implements Catalog {
	private static final long serialVersionUID = -2814560779495636277L;

	@Column(name = "name", nullable = false)
	private String name;
	
	CatalogImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public CatalogImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

package rs.in.staleksit.cqrs.axon.query.model.catalog.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import rs.in.staleksit.cqrs.axon.query.model.catalog.Catalog;
import rs.in.staleksit.cqrs.axon.query.model.catalog.Product;

@Entity
@Table(name = "ca_product")
public class ProductImpl extends AbstractPersistable<String>implements Product {
	private static final long serialVersionUID = -3132333333312483806L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "archived")
	private boolean archived;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "model")
	private String model;
	
	@ManyToOne(targetEntity = CatalogImpl.class)
	@JoinColumn(name = "catalog_id")
	private Catalog catalog;
	
	/**
	 * 
	 */
	ProductImpl() {
		
		this.archived = false;
	}
	
	/**
	 * 
	 * @param name
	 */
	public ProductImpl(String name) {
		this.name = name;
		this.archived = false;
	}
	
	/**
	 * 
	 * @param name
	 * @param archived
	 * @param manufacturer
	 * @param model
	 * @param catalog
	 */
	public ProductImpl(String name, boolean archived, String manufacturer, String model, Catalog catalog) {
		this.name = name;
		this.archived = archived;
		this.manufacturer = manufacturer;
		this.model = model;
		this.catalog = catalog;
	}
	
	public String getName() {
		return name;
	}

	public boolean isArchived() {
		return archived;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public Catalog getCatalog() {
		return catalog;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
	
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}
	

}

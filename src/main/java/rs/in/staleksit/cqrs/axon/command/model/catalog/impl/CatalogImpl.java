package rs.in.staleksit.cqrs.axon.command.model.catalog.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import rs.in.staleksit.cqrs.axon.command.model.catalog.Catalog;

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
		// Intentionally blank for JPA
	}
	
	public CatalogImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.dto.catalog;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jtransfo.DomainClass;
import org.jtransfo.MappedBy;

import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.ProductImpl;

/**
 *
 */
@DomainClass(domainClass = ProductImpl.class)
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 4295027659398421336L;
	
	private String id;
	private String name;
	private boolean archived;
	private String manufacturer;
	private String model;
	@MappedBy(path = "catalog", field = "id")
	private Integer catalogId;
	@MappedBy(path = "catalog", field = "name")
	private String catalogName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isArchived() {
		return archived;
	}
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
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

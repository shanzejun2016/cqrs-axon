package rs.in.staleksit.cqrs.axon.command.model.dto.catalog;

import java.io.Serializable;

import org.jtransfo.DomainClass;

import rs.in.staleksit.cqrs.axon.query.model.catalog.impl.CatalogImpl;

@DomainClass(domainClass = CatalogImpl.class)
public class CatalogDTO implements Serializable {
	private static final long serialVersionUID = -4202878689954310977L;
	
	private String id;
	private String name;
	
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

}

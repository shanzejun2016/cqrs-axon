package rs.in.staleksit.cqrs.axon.command.model.catalog;

public interface Product {
	
	Integer getId();
	
	String getName();
	
	boolean isArchived();
	
	String getManufacturer();
	
	String getModel();
	
	Catalog getCatalog();

}

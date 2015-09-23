package rs.in.staleksit.cqrs.axon.query.model.catalog;

public interface Product {
	
	String getId();
	
	String getName();
	
	boolean isArchived();
	
	String getManufacturer();
	
	String getModel();
	
	Catalog getCatalog();

}

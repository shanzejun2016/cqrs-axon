package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

public class CatalogDeleteCommand extends CatalogCommand {
	private static final long serialVersionUID = 5279434019805931557L;
	
	private Integer catalogId;

	public CatalogDeleteCommand(Integer catalogId, String name) {
		super(name);
		this.catalogId =  catalogId;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}

}

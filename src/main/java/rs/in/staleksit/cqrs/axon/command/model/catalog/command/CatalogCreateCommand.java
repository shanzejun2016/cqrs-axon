package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

public class CatalogCreateCommand extends CatalogCommand {
	private static final long serialVersionUID = 493910051945479994L;
	
	private final String catalogName;

	public CatalogCreateCommand(String catalogId, String catalogName) {
		super(catalogId);
		this.catalogName = catalogName;
	}
	
	public String getCatalogName() {
		return catalogName;
	}

}

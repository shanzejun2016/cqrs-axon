package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

public class CatalogDeleteCommand extends CatalogCommand {
	private static final long serialVersionUID = 5279434019805931557L;
	
	public CatalogDeleteCommand(String catalogId) {
		super(catalogId);
	}
}

package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

public class CatalogCreateCommand extends CatalogCommand {
	private static final long serialVersionUID = 493910051945479994L;

	public CatalogCreateCommand(String name) {
		super(name);
	}

}

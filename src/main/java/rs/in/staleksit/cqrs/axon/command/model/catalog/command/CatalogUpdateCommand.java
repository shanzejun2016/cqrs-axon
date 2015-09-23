/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

public class CatalogUpdateCommand extends CatalogCommand {
	private static final long serialVersionUID = 1327610280406160984L;
	
	private final String catalogName;
	
	public CatalogUpdateCommand(String catalogId, String catalogName) {
		super(catalogId);
		this.catalogName = catalogName;
	}
	
	public String getCatalogName() {
		return catalogName;
	}
	
}

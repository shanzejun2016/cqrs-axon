/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.model.catalog.command;

/**
 *
 */
public class CatalogUpdateCommand extends CatalogCommand {
	private static final long serialVersionUID = 1327610280406160984L;

	private Integer catalogId;
	
	public CatalogUpdateCommand(Integer catalogId, String name) {
		super(name);
		this.catalogId = catalogId;
	}

	public Integer getCatalogId() {
		return catalogId;
	}
	
}

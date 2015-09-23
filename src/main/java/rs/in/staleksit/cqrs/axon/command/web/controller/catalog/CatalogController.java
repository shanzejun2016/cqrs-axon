/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.web.controller.catalog;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import rs.in.staleksit.cqrs.axon.api.catalog.CatalogCommandAPI;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogCreateCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogDeleteCommand;
import rs.in.staleksit.cqrs.axon.command.model.catalog.command.CatalogUpdateCommand;

/**
 *
 */
@RestController
@Api(value = "/catalog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController implements CatalogCommandAPI {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CommandGateway commandGateway;

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalogs", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Creating Catalog accepted."), 
			@ApiResponse(code = 400, message = "Invalid catalogName supplied")})
	public ResponseEntity<String> handleCreateCatalog(@ApiParam(value = "Name of catalog to be created", required = true) @RequestBody String catalogName) {
		LOG.info("catalogName: {}", catalogName);
		if (!StringUtils.isBlank(catalogName)) {
			String catalogId = UUID.randomUUID().toString();
			LOG.debug("catalogId: {}", catalogId);
			commandGateway.send(new CatalogCreateCommand(catalogId, catalogName));
			return new ResponseEntity<String>(catalogId, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Updates Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Catalog has been updated"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog and/or new catalog name not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})	
	public ResponseEntity<String> handleUpdateCatalog(@ApiParam(value = "Unique identifier of catalog to be updated", required = true) @PathVariable("catalogId") String catalogId, 
			@ApiParam(value = "New provided catalog name", required = true) @RequestBody String newCatalogName) {
		LOG.info("catalogId: {}, newCatalogName: {}", catalogId, newCatalogName);
		
		if (StringUtils.isBlank(newCatalogName)) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		commandGateway.send(new CatalogUpdateCommand(catalogId, newCatalogName));
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Delete Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Catalog delete has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})
	public ResponseEntity<String> handleDeleteCatalog(@ApiParam(value = "Unique identifier of catalog", required = true) @PathVariable("catalogId") String catalogId) {
		LOG.info("catalogId: {}", catalogId);
		if (StringUtils.isNotBlank(catalogId)) {
			LOG.debug("Deleting catalog with id: {}", catalogId);
			commandGateway.send(new CatalogDeleteCommand(catalogId));
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}

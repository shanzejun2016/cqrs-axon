/**
 * 
 */
package rs.in.staleksit.cqrs.axon.command.web.controller;

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
import rs.in.staleksit.cqrs.axon.command.model.Catalog;
import rs.in.staleksit.cqrs.axon.command.model.CatalogCreateCommand;
import rs.in.staleksit.cqrs.axon.command.service.CatalogService;

/**
 *
 */
@RestController
@Api(value = "/catalog", description = "Operations about catalogs")
public class CatalogController {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CatalogService catalogService;

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalogs", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Creating Catalog accepted."), 
			@ApiResponse(code = 400, message = "Invalid catalogName supplied")})
	public ResponseEntity<String> handleCreateCatalog(@ApiParam(value = "Name of catalog to be created", required = true) @RequestBody String catalogName) {
		LOG.info("catalogName: {}", catalogName);
		if (!StringUtils.isBlank(catalogName)) {
			commandGateway.send(new CatalogCreateCommand(catalogName));
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalog/{id}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Updates Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Catalog has been updated"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog and/or new catalog name not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})	
	public ResponseEntity<String> handleUpdateCatalog(@ApiParam(value = "Unique identifier of catalog to be updated", required = true) @PathVariable("id") Integer id, 
			@ApiParam(value = "New provided catalog name", required = true) @RequestBody String catalogName) {
		LOG.info("id: {}, catalogName: {}", id, catalogName);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalog/{id}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Delete Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Catalog delete has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})
	public ResponseEntity<String> handleDeleteCatalog(@ApiParam(value = "Unique identifier of catalog", required = true) @PathVariable("id") Integer id) {
		LOG.info("id: {}", id);
		if (id != null) {
			Catalog existingCatalog = catalogService.findOneById(id);
			if (existingCatalog != null) {
				LOG.info("Deleting catalog with id: {}", id);
				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}

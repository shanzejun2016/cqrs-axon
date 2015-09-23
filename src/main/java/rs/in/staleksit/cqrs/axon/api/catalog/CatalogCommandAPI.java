package rs.in.staleksit.cqrs.axon.api.catalog;

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

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "/catalog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface CatalogCommandAPI {
	
	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/catalogs", method = RequestMethod.POST, 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Creating Catalog accepted."), 
			@ApiResponse(code = 400, message = "Invalid catalogName supplied")})
	public ResponseEntity<String> handleCreateCatalog(@ApiParam(value = "Name of catalog to be created", required = true) @RequestBody String catalogName);
	
	
	/**
	 * 
	 * @param catalogId
	 * @param newCatalogName
	 * @return
	 */
	@RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.PUT, 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Updates Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Catalog update request has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog and/or new catalog name not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})	
	public ResponseEntity<String> handleUpdateCatalog(@ApiParam(value = "Unique identifier of catalog to be updated", required = true) @PathVariable("catalogId") String catalogId, 
			@ApiParam(value = "New provided catalog name", required = true) @RequestBody String newCatalogName);
	
	
	/**
	 * 
	 * @param catalogId
	 * @return
	 */
	@RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.DELETE, 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Delete Catalog", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Catalog delete has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Catalog not supplied"),
			@ApiResponse(code = 404, message = "Catalog with such identifier not known in system")
			})
	public ResponseEntity<String> handleDeleteCatalog(@ApiParam(value = "Unique identifier of catalog", required = true) @PathVariable("catalogId") String catalogId);

	

}

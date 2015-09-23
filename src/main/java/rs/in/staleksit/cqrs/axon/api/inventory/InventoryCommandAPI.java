package rs.in.staleksit.cqrs.axon.api.inventory;

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
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "/inventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface InventoryCommandAPI {
	
	
	/**
	 * 
	 * @param inventoryId
	 * @return
	 */
	@RequestMapping(value = "/inventories", method = RequestMethod.POST)
	@ApiOperation(value = "Create Inventory record", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Creating Inventory record accepted."), 
			@ApiResponse(code = 400, message = "Invalid request supplied")})
	public ResponseEntity<String> handleCreateInventory(@ApiParam(value = "Identifier of inventory", required = true) @RequestBody String inventoryId);
	
	
	/**
	 * 
	 * @param inventoryId
	 * @param numberOfUnits
	 * @return
	 */
	@RequestMapping(value = "/inventory/{inventoryId}/update", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates Inventory", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Inventory update request has been accepted"),
			@ApiResponse(code = 400, message = "Client bad request"),
			@ApiResponse(code = 404, message = "Inventory with such identifier not known in system")
			})	
	public ResponseEntity<String> handleUpdateInventory(@ApiParam(value = "Unique identifier to be updated", required = true) @PathVariable("inventoryId") String inventoryId, 
			@ApiParam(value = "number of units to add", required = true) @RequestBody Integer numberOfUnits);


}

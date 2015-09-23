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
import rs.in.staleksit.cqrs.axon.api.catalog.dto.ProductDTO;

@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProductCommandAPI {
	
	/**
	 * 
	 * @param catalogName
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ApiOperation(value = "Create Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Creating Product accepted."), 
			@ApiResponse(code = 400, message = "Invalid Product supplied")})
	public ResponseEntity<String> handleCreateProduct(@ApiParam(value = "Product to be created", required = true) @RequestBody ProductDTO productDTO);
	
	
	/**
	 * 
	 * @param catalogId
	 * @param newCatalogName
	 * @return
	 */
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Product update request has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Product and/or new catalog name not supplied"),
			@ApiResponse(code = 404, message = "Product with such identifier not known in system")
			})	
	public ResponseEntity<ProductDTO> handleUpdateProduct(@ApiParam(value = "Unique identifier of product to be updated", required = true) @PathVariable("productId") String productId, 
			@ApiParam(value = "New provided product", required = true) @RequestBody ProductDTO productDTO);
	
	
	/**
	 * 
	 * @param catalogId
	 * @return
	 */
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Product delete has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Product not supplied"),
			@ApiResponse(code = 404, message = "Product with such identifier not known in system")
			})
	public ResponseEntity<String> handleDeleteProduct(@ApiParam(value = "Unique identifier of product", required = true) @PathVariable("productId") String productId);
	

}

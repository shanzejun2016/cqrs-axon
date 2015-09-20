package rs.in.staleksit.cqrs.axon.command.web.controller.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import rs.in.staleksit.cqrs.axon.command.model.dto.catalog.ProductDTO;

@RestController
@Api(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ApiOperation(value = "Create Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Creating Product accepted."), 
			@ApiResponse(code = 400, message = "Invalid request supplied")})	
	public ResponseEntity<String> handleCreateProduct(@RequestBody ProductDTO productDTO) {
		LOG.info("request: {}", productDTO);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "Product update has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Product and/or request not supplied"),
			@ApiResponse(code = 404, message = "Product with such identifier not known in system")
			})	
	public ResponseEntity<ProductDTO> handleUpdateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO productDTO) {
		LOG.info("id:{}, request: {}", id, productDTO);
		return new ResponseEntity<ProductDTO>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Product", response = ResponseEntity.class, authorizations = {
			@Authorization(value = "api_key") })
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Product delete has been accepted"),
			@ApiResponse(code = 400, message = "Unique identifier of Product not supplied"),
			@ApiResponse(code = 404, message = "Product with such identifier not known in system")
			})	
	public ResponseEntity<String> handleDeleteProduct(@PathVariable("id") Integer id) {
		LOG.info("id: {}", id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}

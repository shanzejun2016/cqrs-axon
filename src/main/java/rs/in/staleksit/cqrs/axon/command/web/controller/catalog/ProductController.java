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

import rs.in.staleksit.cqrs.axon.api.catalog.ProductCommandAPI;
import rs.in.staleksit.cqrs.axon.api.catalog.dto.ProductDTO;

@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductController implements ProductCommandAPI {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<String> handleCreateProduct(@RequestBody ProductDTO productDTO) {
		LOG.info("request: {}", productDTO);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<ProductDTO> handleUpdateProduct(@PathVariable("productId") String productId, @RequestBody ProductDTO productDTO) {
		LOG.info("productId:{}, request: {}", productId, productDTO);
		return new ResponseEntity<ProductDTO>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> handleDeleteProduct(@PathVariable("productId") String productId) {
		LOG.info("productId: {}", productId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}

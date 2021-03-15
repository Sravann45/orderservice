package sravan.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sravan.java.models.TransactionRequest;
import sravan.java.models.TransactionResponse;
import sravan.java.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping("/bookOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest request) {
		return service.saveOrder(request);
	}
}

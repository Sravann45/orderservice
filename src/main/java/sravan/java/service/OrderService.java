package sravan.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sravan.java.models.Payment;
import sravan.java.models.TransactionRequest;
import sravan.java.models.TransactionResponse;
import sravan.java.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo repo;
	@Autowired
	private RestTemplate template;
	
	String message = "";
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		// TODO Auto-generated method stub
		Payment payment = request.getPayment();
		payment.setOrderId(request.getOrder().getId());
		payment.setAmount(request.getOrder().getPrice());
		
		//rest call
		
		//Payment paymentResponse = template.postForObject("http://localhost:8082/payment", payment, Payment.class);
		//passing Applcation name in the url of the microservice call as below
		Payment paymentResponse = template.postForObject("http://Payment-Service/payment/doPayment", payment, Payment.class);
		message = paymentResponse.getStatus().equals("success")?"payment processing successfull and order placed":"payment failed and order has been added to cart";
		repo.save(request.getOrder());
		return new TransactionResponse(request.getOrder(),paymentResponse.getAmount(),paymentResponse.getTxnId(),message);
	}

}

package sravan.java.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	private Integer paymentId;
	private String txnId;
	private String status;
	private int orderId;
	private double amount;
}

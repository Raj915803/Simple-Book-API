package payloads;

public class UpdateOrderRequest {

	private String customerName;

	public UpdateOrderRequest() {
	}

	public UpdateOrderRequest(String customerName) {

		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}
}
package payloads;

public class OrderRequest {

	private int bookId;
	private String customerName;

	public OrderRequest() {
	}

	public OrderRequest(int bookId, String customerName) {

		this.bookId = bookId;
		this.customerName = customerName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getCustomerName() {
		return customerName;
	}
}
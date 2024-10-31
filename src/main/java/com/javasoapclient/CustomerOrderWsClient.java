package com.javasoapclient;

import com.lwazi.ws.trainings.CustomerOrdersPortType;
import com.lwazi.ws.trainings.GetOrdersRequest;
import com.lwazi.ws.trainings.GetOrdersResponse;
import com.lwazi.ws.trainings.Order;
import com.lwazi.ws.trainings.Product;
import wsldfirstwebservice.CustomerOrdersWsImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8081/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();

		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Number of orders for the customer are:" + orders.size());
		for (Order order: orders) {
			for (Product product: order.getProduct()) {
				System.out.println("product:" + product.getDescription());
			}
		}

	}

}

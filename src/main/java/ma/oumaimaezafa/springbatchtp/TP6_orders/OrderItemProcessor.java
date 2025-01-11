package ma.oumaimaezafa.springbatchtp.TP6_orders;

import org.springframework.batch.item.ItemProcessor;


public class OrderItemProcessor implements ItemProcessor<Order, Order> {

    @Override
    public Order process(Order order) throws Exception {
        double discountedAmount = order.amount() * 0.9;
        return new Order(order.orderId(), order.customerName(), discountedAmount);
    }
}

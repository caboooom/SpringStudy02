package hello_2303.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

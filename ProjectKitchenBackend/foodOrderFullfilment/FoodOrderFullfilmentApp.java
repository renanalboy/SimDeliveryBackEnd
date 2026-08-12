import controller.*;
import model.Order;
import java.util.Random;

public class FoodOrderFullfilmentApp {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int draw = rand.nextInt(100) + 1; // 1..100
            int freshness = Math.max(0, 100 - draw);
            Order order = new Order("Order - " + i, "Food " + i, (i % 2 == 0) ? "hot" : "cold", freshness);
            controller.receiveOrder(order);
        }

        //controller.printActions();
    }
}


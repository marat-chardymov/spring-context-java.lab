package org.shop;


import org.shop.api.OrderService;
import org.shop.config.RootAppConfig;
import org.shop.data.Item;
import org.shop.data.User;
import org.shop.repository.ItemRepository;
import org.shop.repository.OrderRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */

public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RootAppConfig.class);
        OrderRepository orderMapRepository = (OrderRepository) context.getBean("orderMapRepository"); // by name
        ProductRepository productRepository = (ProductRepository) context.getBean(ProductRepository.class); // by type
        OrderRepository orderMapRepositoryByAlias = (OrderRepository) context.getBean("orderMapRepositoryAlias"); // by alias
        OrderService orderService = (OrderService) context.getBean(OrderService.class); // make order
        UserRepository userRepository = (UserRepository) context.getBean(UserRepository.class);
        Long userId = userRepository.createUser(new User());
        User user = userRepository.getUserById(userId);
        ItemRepository itemRepository = (ItemRepository) context.getBean(ItemRepository.class);
        Item item = new Item();
        itemRepository.createItem(item);
        orderService.createOrder(user, item);
    }
}

package ua.com.alevel.service;

import org.junit.jupiter.api.*;

import ua.com.alevel.entity.Access;
import ua.com.alevel.entity.Client;
import ua.com.alevel.entity.Order;
import ua.com.alevel.service.impl.AccessServiceImpl;
import ua.com.alevel.service.impl.ClientServiceImpl;
import ua.com.alevel.service.impl.OrderServiceImpl;

import java.util.Random;

import static ua.com.alevel.service.AccessGenerationUtil.generateAccess;
import static ua.com.alevel.service.ClientGenerationUtil.generateClient;
import static ua.com.alevel.service.OrderGenerationUtil.generateOrder;

public class OrderServiceTest {

    private final static AccessServiceImpl accessService = new AccessServiceImpl();
    private final static ClientServiceImpl clientService = new ClientServiceImpl();
    private final static OrderServiceImpl orderService = new OrderServiceImpl();
    private final static int ACCESS_SIZE = 10;
    private final static int CLIENT_SIZE = 10;
    private final static int ORDER_SIZE = 10;
    private final static Random random = new Random();

    private final static String[] loginArray = {"Alex", "Dmitriy", "Peter", "Sam", "Evgeniy"};
    private final static String[] passwordArray = {"111", "222", "333", "444", "555"};
    private final static String[] firstNamesArray = {"Alex", "Dmitriy", "Peter", "Sam", "Evgeniy"};
    private final static String[] lastNamesArray = {"Filinov", "Timonow", "Ivanov", "Smith", "Miller"};
    private final static String[] colorsArray = {"Black", "Cyan", "Yellow", "Brown", "White"};
    private final static String[] typesArray = {"sds", "storsan", "multi"};


    @BeforeAll
    @Test
    public static void setUpAccesses() {
        for (int i = 0; i < ACCESS_SIZE; i++) {
            Access access = AccessGenerationUtil.generateAccess(loginArray[random.nextInt(5)], passwordArray[random.nextInt(5)]);
            accessService.create(access);
        }

        Assertions.assertEquals(ACCESS_SIZE, accessService.sizeOf());
        Access[] accesses = accessService.findAll();

        for (int i = 0; i < CLIENT_SIZE; i++) {
            Client client = generateClient(accesses[i].getId(), firstNamesArray[random.nextInt(5)], lastNamesArray[random.nextInt(5)], String.valueOf(i), String.valueOf(i));
            clientService.update(client);
        }

        Assertions.assertEquals(CLIENT_SIZE, clientService.sizeOf());
        for (int i = 0; i < ORDER_SIZE; i++) {
            Order order = generateOrder(firstNamesArray[random.nextInt(5)], lastNamesArray[random.nextInt(5)], (i * 10), (i * 15), colorsArray[random.nextInt(5)], typesArray[random.nextInt(3)]);
            order.setId(accesses[i].getId());
            orderService.create(order);
        }

        Assertions.assertEquals(ORDER_SIZE, clientService.sizeOf());
    }

    @org.junit.jupiter.api.Order(1)
    @Test
    public void shouldBeCreateAccessWheLoginIsEmpty() {
        accessService.create(generateAccess(null, "a"));
        verifyAccessesWhenAccessesNotEmpty(11);
        verifyClientsWhenClientsNotEmpty(11);
    }

    @org.junit.jupiter.api.Order(2)
    @Test
    public void shouldBeDeleteAccess() {
        String id = getRandomIdFromAccesses();
        accessService.delete(id);
        verifyAccessesWhenAccessesNotEmpty(10);
        verifyClientsWhenClientsNotEmpty(10);
    }

    @org.junit.jupiter.api.Order(3)
    @Test
    public void shouldBeFindAccessWhenIdIsRandom() {
        Access access = accessService.findById(getRandomIdFromAccesses());
        Assertions.assertNotNull(access);
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    public void shouldBeUpdateAccess() {
        String id = getRandomIdFromAccesses();
        Access access = accessService.findById(id);
        access.setLogin("LoginExample");
        accessService.update(access);

        access = accessService.findById(id);

        Assertions.assertEquals("LoginExample", access.getLogin());
    }

    @org.junit.jupiter.api.Order(5)
    @Test
    public void shouldBeUpdateClient() {
        String id = getRandomIdFromClients();
        Client client = clientService.findById(id);
        client.setLastName("Sol");
        clientService.update(client);
        client = clientService.findById(id);
        Assertions.assertEquals("Sol", client.getLastName());
    }

    @org.junit.jupiter.api.Order(6)
    @Test
    public void shouldBeCreateOrderWhenNameIsEmpty() {
        orderService.create(generateOrder(null, "a", 20, 40, "black", "sds"));
        verifyOrdersWhenOrdersNotEmpty(11);
    }

    @org.junit.jupiter.api.Order(7)
    @Test
    public void shouldBeDeleteOrder() {
        String id = getRandomIdFromOrders();
        orderService.delete(id);
        verifyOrdersWhenOrdersNotEmpty(10);
    }

    @org.junit.jupiter.api.Order(8)
    @Test
    public void shouldBeFindOrderWhenIdIsRandom() {
        Order order = orderService.findById(getRandomIdFromOrders());
        Assertions.assertNotNull(order);
    }

    @org.junit.jupiter.api.Order(9)
    @Test
    public void shouldBeUpdateOrder() {
        String id = getRandomIdFromOrders();
        Order order = orderService.findById(id);
        order.setLastName("Sol");
        orderService.update(order);
        order = orderService.findById(id);
        Assertions.assertEquals("Sol", order.getLastName());
    }

    private void verifyClientsWhenClientsNotEmpty(int size) {
        Assertions.assertTrue(clientService.sizeOf() > 0);
        Assertions.assertEquals(size, clientService.sizeOf());
    }

    private String getRandomIdFromClients() {
        Client[] clients = clientService.findAll();
        Client client = clients[(int) (1 + (Math.random() * clientService.sizeOf() - 1))];

        return client.getId();
    }

    private void verifyAccessesWhenAccessesNotEmpty(int size) {
        Assertions.assertTrue(accessService.sizeOf() > 0);
        Assertions.assertEquals(size, accessService.sizeOf());
    }

    private String getRandomIdFromAccesses() {
        Access[] accesses = accessService.findAll();

        return accesses[(int) Math.random() * accessService.sizeOf()].getId();
    }

    private void verifyOrdersWhenOrdersNotEmpty(int size) {
        Assertions.assertTrue(orderService.sizeOf() > 0);
        Assertions.assertEquals(size, orderService.sizeOf());
    }

    private String getRandomIdFromOrders() {
        Order[] orders = orderService.findAll();

        return orders[(int) (Math.random() * orderService.sizeOf())].getOrderId();
    }

}

package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Access;
import ua.com.alevel.entity.Client;
import ua.com.alevel.service.impl.AccessServiceImpl;
import ua.com.alevel.service.impl.ClientServiceImpl;

import java.util.Random;

import static ua.com.alevel.service.AccessGenerationUtil.generateAccess;
import static ua.com.alevel.service.ClientGenerationUtil.generateClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccessAndClientServiceTest {

    private final static AccessServiceImpl accessService = new AccessServiceImpl();
    private final static ClientServiceImpl clientService = new ClientServiceImpl();
    private final static int ACCESS_SIZE = 10;
    private final static int CLIENT_SIZE = 10;
    private final static Random random = new Random();

    private final static String[] loginArray = {"Alex", "Dmitriy", "Peter", "Sam", "Evgeniy"};
    private final static String[] passwordArray = {"111", "222", "333", "444", "555"};
    private final static String[] firstNamesArray = {"Alex", "Dmitriy", "Peter", "Sam", "Evgeniy"};
    private final static String[] lastNamesArray = {"Filinov", "Timonow", "Ivanov", "Smith", "Miller"};

    @BeforeAll
    public static void setUpAccesses() {
        for (int i = 0; i < ACCESS_SIZE; i++) {
            Access access = generateAccess(loginArray[random.nextInt(5)], passwordArray[random.nextInt(5)]);
            accessService.create(access);
        }

        Assertions.assertEquals(ACCESS_SIZE, accessService.sizeOf());
        Access[] accesses = accessService.findAll();

        for (int i = 0; i < CLIENT_SIZE; i++) {
            Client client = generateClient(accesses[i].getId(), firstNamesArray[random.nextInt(5)], lastNamesArray[random.nextInt(5)], String.valueOf(i), String.valueOf(i));
            clientService.update(client);
        }

        Assertions.assertEquals(CLIENT_SIZE, clientService.sizeOf());
    }

    @Order(1)
    @Test
    public void shouldBeCreateAccessWhenLoginIsEmpty() {
        accessService.create(generateAccess(null, "a"));
        verifyAccessesWhenAccessesNotEmpty(11);
        verifyClientsWhenClientsNotEmpty(11);
    }

    @Order(2)
    @Test
    public void shouldBeDeleteAccess() {
        String id = getRandomIdFromAccesses();
        accessService.delete(id);
        verifyAccessesWhenAccessesNotEmpty(10);
        verifyClientsWhenClientsNotEmpty(10);
    }

    @Order(3)
    @Test
    public void shouldBeFindAccessWhenIdIsRandom() {
        Access access = accessService.findById(getRandomIdFromAccesses());

        Assertions.assertNotNull(access);
    }

    @Order(4)
    @Test
    public void shouldBeUpdateAccess() {
        String id = getRandomIdFromAccesses();
        Access access = accessService.findById(id);
        access.setLogin("LoginExample");
        accessService.update(access);
        access = accessService.findById(id);

        Assertions.assertEquals("LoginExample", access.getLogin());
    }

    @Order(5)
    @Test
    public void shouldBeFindClientWhenIdIsRandom() {
        Client client = clientService.findById(getRandomIdFromClients());

        Assertions.assertNotNull(client);
    }

    @Order(6)
    @Test
    public void shouldBeUpdateClient() {
        String id = getRandomIdFromClients();
        Client client = clientService.findById(id);
        client.setLastName("Sol");
        clientService.update(client);
        client = clientService.findById(id);

        Assertions.assertEquals("Sol", client.getLastName());
    }
    @Order(7)
    @Test
    public void shouldBeDeleteAllAccessAndClients() {
        Access[] accesses = accessService.findAll();

        while (accessService.sizeOf() != 0) {
            accessService.delete(accesses[0].getId());
        }

        Assertions.assertEquals(0, accessService.sizeOf());
        Assertions.assertEquals(0, clientService.sizeOf());
    }


    private String getRandomIdFromClients() {
        Client[] clients = clientService.findAll();

        return clients[(int)(Math.random() * clientService.sizeOf() - 1)].getId();
    }

    private void verifyAccessesWhenAccessesNotEmpty(int size) {
        Assertions.assertTrue(accessService.sizeOf() > 0);
        Assertions.assertEquals(size, accessService.sizeOf());
    }

    private void verifyClientsWhenClientsNotEmpty(int size) {
        Assertions.assertTrue(clientService.sizeOf() > 0);
        Assertions.assertEquals(size, clientService.sizeOf());
    }

    private String getRandomIdFromAccesses() {
        Access[] accesses = accessService.findAll();

        return accesses[(int)(Math.random() * accessService.sizeOf())].getId();
    }
}

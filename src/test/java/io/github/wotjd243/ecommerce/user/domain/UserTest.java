package io.github.wotjd243.ecommerce.user.domain;

public class UserTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_ANOTHER_ID = "TEST_ANTHER";
    private final static String TEST_PRODUCT_NAME = "TEST_PRODUCT";

    User user = new User(TEST_USER_ID);
    User anotherSeller = new User(TEST_ANOTHER_ID);

//    @Test
//    public void 판매자가_물품을_등록() {
//        Item item = createItem(100.7);
//        user.registerItems(product, item);
//
//        List<Item> items = user.retrieve(product);
//        assertThat(items.get(0)).isEqualTo(item);
//    }
//
//    @Test
//    public void 판매자별로_물품의_가격을_다르게_설정() {
//        double firstPrice = 100.8;
//        double secondPrice = 25.8;
//        user.registerItems(product, createItem(firstPrice));
//        anotherSeller.registerItems(product, createItem(secondPrice));
//        List<Item> items = product.getItems();
//
//        assertThat(items.get(0).isSamePrice(secondPrice)).isFalse();
//    }
}
package com.company.repository;

import com.company.bean.Product;
import com.company.enums.Category;
import com.company.interfaces.MapInterface;
import com.company.logger.Loggers;
import com.company.menuString.MenuString;
import com.company.service.MenuService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class EmbeddedProductDataBase extends HashMap<Long, Product> implements MapInterface {

    Product[] product = new Product[50];
    static private int productNumber, number = 0;
    static Long productCountLong = 0l;
    static Loggers loggers = new Loggers(EmbeddedProductDataBase.class.getName());

    @Override
    public void addProduct(Long id, String name) {
        productMap.put(id, name);
    }

    @Override
    public void updateProduct() {
        while (true) {
            loggers.log.info(MenuString.CHOOSE_TYPE_CHANGE);
            switch (MenuService.returnInt()) {
                case 1:
                    changeName();
                    break;
                case 2:
                    changePrice();
                    break;
                case 3:
                    changeDiscount();
                    break;
                case 4:
                    changeDescription();
                    break;
                case 5:
                    return;
                default:
                    loggers.log.warn(MenuString.WRONG_TYPE);
            }
        }
    }

    @Override
    public void readProduct() {
        loggers.log.info("Product ID:" + productMap.keySet() + "\nProduct's name" + productMap.values());
    }

    @Override
    public void deleteProduct() {
        productMap.remove(enterId());
        loggers.log.info(MenuString.SUCCESSFULLY_DELETED);
    }

    @Override
    public void findProduct() {
        takeProduct(Math.toIntExact(enterId()));
    }

    public void takeProduct(int num){
        BigDecimal actualPrice;
        MathContext mc = new MathContext(2);
        BigDecimal discountAmount = new BigDecimal(String.valueOf(product[num].getPrice()
                .multiply(product[num].getDiscount(), mc)));
        actualPrice = new BigDecimal(String.valueOf(product[num].getPrice().subtract(discountAmount)));
        setAndPrint(num, actualPrice);
    }

    public void setAndPrint(int num, BigDecimal actualPrice){
        loggers.log.info("Name: " + product[num].getName());
        loggers.log.info("ID: " + product[num].getId());
        loggers.log.info("Price: " + product[num].getPrice());
        loggers.log.info("Discount: " + product[num].getDiscount());
        loggers.log.info("Description: " + product[num].getDescription());
        loggers.log.info("Actual price: " + actualPrice);
        loggers.log.info("Category: " + product[num].getCategoryList() + "\n");
    }

    public void enterProduct() {
        product[productNumber] = new Product();
        product[productNumber].setName(enterName());
        product[productNumber].setId(productNumber);
        product[productNumber].setPrice(enterPrice());
        product[productNumber].setDiscount(enterDiscount());
        product[productNumber].setDescription(enterDescription());
        product[productNumber].setCategoryList(enterCategory());
        addProduct(productCountLong, product[productNumber].getName());
        productNumber++;
        productCountLong++;
        loggers.log.info(MenuString.PRODUCT_SUCCESSFULLY_ADDED);
    }

    public void filtration(int typeOfFiltration) {
        switch (typeOfFiltration) {
            case 1:
                System.out.println("Id|Name");
                productMap.entrySet().stream()
                        .sorted(Map.Entry.<Long, String>comparingByKey())
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.println("Id|Name");
                productMap.entrySet().stream()
                        .sorted(Map.Entry.<Long, String>comparingByValue())
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.println("Id|Name");
                productMap.entrySet().stream()
                        .sorted(Map.Entry.<Long, String>comparingByKey().reversed())
                        .forEach(System.out::println);
                break;
            case 4:
                System.out.println("Id|Name");
                productMap.entrySet().stream()
                        .sorted(Map.Entry.<Long, String>comparingByValue().reversed())
                        .forEach(System.out::println);
                break;
            case 5:
                return;
            default:
                loggers.log.info("Choose number between 1-4");
                break;
        }
    }

    public void changeName() {
        product[enterId()].setName(enterName());
        productMap.replace((long) number, product[number].getName());
        loggers.log.info(MenuString.SUCCESSFULLY_CHANGES);
    }

    public void changePrice() {
        product[enterId()].setPrice(enterPrice());
        loggers.log.info(MenuString.SUCCESSFULLY_CHANGES);
    }

    public void changeDiscount() {
        product[enterId()].setDiscount(enterDiscount());
        loggers.log.info(MenuString.SUCCESSFULLY_CHANGES);
    }

    public void changeDescription() {
        product[enterId()].setDescription(enterDescription());
        loggers.log.info(MenuString.SUCCESSFULLY_CHANGES);
    }

    public void findProductByCategory(){
        for (int i = 0; i <productMap.size() ; i++) {
            if(product[i].getCategoryList().equals(enterCategory())){
            takeProduct(i);
            }
        }
    }

    public void setDiscountToCategory(){
        showCategoryList();
        number = MenuService.returnInt();
        for (int i = 0; i <productMap.size() ; i++) {
            if(product[i].getCategoryList().equals(Category.chooseCategory(enterId()))){
                product[i].setDiscount(enterDiscount());
            }
        }
        loggers.log.info(MenuString.SUCCESSFULLY_CHANGES);
    }

    public void showCategoryList(){
        System.out.println(MenuString.ENTER_CATEGORY);
        Category.showCategoryList();
    }

    public int enterId(){
        loggers.log.info(MenuString.ENTER_ID);
        return MenuService.returnInt();
    }

    public String enterDescription(){
        loggers.log.info(MenuString.ENTER_DESCRIPTION);
        return MenuService.returnDescription();
    }

    public String enterName(){
        loggers.log.info(MenuString.ENTER_NAME);
        return MenuService.returnName();
    }

    public BigDecimal enterPrice(){
        loggers.log.info(MenuString.ENTER_PRICE);
        return MenuService.returnPrice();
    }

    public BigDecimal enterDiscount(){
        loggers.log.info(MenuString.ENTER_DISCOUNT);
        return MenuService.returnDiscount();
    }

    public int enterCategory(){
        showCategoryList();
        return (MenuService.returnInt());
    }
}

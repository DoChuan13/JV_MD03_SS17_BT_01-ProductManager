package app.view;

import app.config.InputConfig;
import app.controller.ProductController;
import app.model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getAllProduct();

    public void showAllProduct() {
        if (productList.size() == 0) {
            System.out.println("Product List is Empty");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
        InputConfig.pressAnyKey();
        new Main();
    }

    public void createNewProduct() {
        System.out.println("Create a New Product!!!");
        int id = generateId();
        System.out.print("Input Product Name: ");
        String productName = InputConfig.getString();
        System.out.print("Input Manufacture: ");
        String manufacture = InputConfig.getString();
        System.out.print("Input Price: ");
        float price = InputConfig.getFloat();
        System.out.print("Input Description: ");
        String description = InputConfig.getString();
        Product product = new Product(id, productName, manufacture, price, description);
        productController.createNewProduct(product);
        InputConfig.pressAnyKey();
        new Main();
    }

    public void findProductById() {
        System.out.println("Input Id");
        int id = InputConfig.getInteger();
        Product product = productController.findProductById(id);
        if (product == null) {
            System.err.println("Not Product!!!!");
        } else
            System.out.println(product);
        InputConfig.pressAnyKey();
        new Main();
    }

    private int generateId() {
        int id = 0;
        if (productList.size() != 0) {
            for (Product product : productList) {
                if (product.getId() > id) id = product.getId();
            }
        }
        return ++id;
    }

    public void deleteProduct() {
        System.out.println("Input Id");
        int id = InputConfig.getInteger();
        Product product = productController.findProductById(id);
        if (product == null) {
            System.err.println("Not Product!!!!");
        } else {
            System.out.println("Deleted Successfully");
            productController.deleteProduct(id);
        }
        InputConfig.pressAnyKey();
        new Main();
    }

    public void updateProductInfo() {
        System.out.println("Input Id");
        int id = InputConfig.getInteger();
        Product product = productController.findProductById(id);
        if (product == null) {
            System.err.println("Not Product!!!!");
        } else {
            System.out.println("Update Product!!!");
            System.out.printf("Input Product Name (current: %s): ", product.getProductName());
            String productName = InputConfig.getString();
            System.out.printf("Input Manufacture (current %s): ", product.getManufacture());
            String manufacture = InputConfig.getString();
            System.out.printf("Input Price (current: %f): ", product.getPrice());
            float price = InputConfig.getFloat();
            System.out.printf("Input Description (current: %s): ", product.getDescription());
            String description = InputConfig.getString();
            product = new Product(id, productName, manufacture, price, description);
            productController.updateProductInfo(product);
            System.out.println("Updated Successfully");
        }
        InputConfig.pressAnyKey();
        new Main();
    }
}

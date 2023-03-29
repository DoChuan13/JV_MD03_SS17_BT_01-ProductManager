package app.view;

import app.config.InputConfig;

public class Main {

    public Main() {
        System.out.println("------------------------Product Menu------------------------\n" +
                "1. Show Product List\n" +
                "2. Create New Product\n" +
                "3. Find Product By Id\n" +
                "4. Update Product\n" +
                "5. Delete Product\n" +
                "0. Exit!");
        System.out.println("Choose a option:  ");
        byte option = InputConfig.getByte();
        switch (option) {
            case 1:
                new ProductView().showAllProduct();
                break;
            case 2:
                new ProductView().createNewProduct();
                break;
            case 3:
                new ProductView().findProductById();
                break;
            case 4:
                new ProductView().updateProductInfo();
                break;
            case 5:
                new ProductView().deleteProduct();
                break;
            case 0:
                System.out.println("Application will exit");
                System.exit(0);
            default:

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

package app.controller;

import app.model.Product;
import app.service.ProductServiceIPLM;

import java.util.List;

public class ProductController {
    ProductServiceIPLM productServiceIPLM = new ProductServiceIPLM();

    public List<Product> getAllProduct() {
        return productServiceIPLM.findAll();
    }

    public void createNewProduct(Product product) {
        productServiceIPLM.save(product);
    }

    public void updateProductInfo(Product product) {
        productServiceIPLM.save(product);
    }

    public Product findProductById(int id) {
        return productServiceIPLM.findById(id);
    }

    public void deleteProduct(int id) {
        productServiceIPLM.delete(id);
    }
}

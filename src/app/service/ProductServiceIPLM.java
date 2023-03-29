package app.service;

import app.config.FileBinaryConfig;
import app.model.Product;
import database.DataBase;

import java.util.List;

public class ProductServiceIPLM implements IGenericService<Product> {
    List<Product> productList = new FileBinaryConfig<Product>().readFile(DataBase.PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        Product resultProduct = findById(product.getId());
        if (resultProduct == null) {
            productList.add(product);
        } else {
            int index = productList.indexOf(resultProduct);
            productList.set(index, product);
        }
        updateDatabase();
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                productList.remove(i);
                updateDatabase();
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateDatabase() {
        new FileBinaryConfig<Product>().writeFile(DataBase.PATH_PRODUCT, false, productList);
    }
}

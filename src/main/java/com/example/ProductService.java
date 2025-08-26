package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 产品服务类
 */
public class ProductService {
    
    private List<Product> products = new ArrayList<>();
    
    public ProductService() {
        // 初始化一些示例数据
        products.add(new Product(1L, "产品A", "这是产品A的描述", 99.99));
        products.add(new Product(2L, "产品B", "这是产品B的描述", 199.99));
        products.add(new Product(3L, "产品C", "这是产品C的描述", 299.99));
    }
    
    /**
     * 获取所有产品
     * @return 产品列表
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    /**
     * 根据ID查找产品
     * @param id 产品ID
     * @return 产品对象，如果未找到则返回null
     */
    public Product findProductById(Long id) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return product.orElse(null);
    }
    
    /**
     * 添加新产品
     * @param product 要添加的产品
     * @return 添加成功返回true，否则返回false
     */
    public boolean addProduct(Product product) {
        if (product.getId() == null) {
            return false;
        }
        
        // 检查是否已存在相同ID的产品
        if (findProductById(product.getId()) != null) {
            return false;
        }
        
        return products.add(product);
    }
    
    /**
     * 更新产品信息
     * @param product 要更新的产品
     * @return 更新成功返回true，否则返回false
     */
    public boolean updateProduct(Product product) {
        if (product.getId() == null) {
            return false;
        }
        
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 删除产品
     * @param id 要删除的产品ID
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
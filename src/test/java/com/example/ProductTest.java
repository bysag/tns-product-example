package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Product类的单元测试
 */
public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product(1L, "测试产品", "这是一个测试产品", 99.99);
        
        assertEquals(Long.valueOf(1L), product.getId());
        assertEquals("测试产品", product.getName());
        assertEquals("这是一个测试产品", product.getDescription());
        assertEquals(Double.valueOf(99.99), product.getPrice());
    }

    @Test
    public void testProductSetters() {
        Product product = new Product();
        
        product.setId(2L);
        product.setName("Setter测试产品");
        product.setDescription("通过setter方法设置的产品");
        product.setPrice(199.99);
        
        assertEquals(Long.valueOf(2L), product.getId());
        assertEquals("Setter测试产品", product.getName());
        assertEquals("通过setter方法设置的产品", product.getDescription());
        assertEquals(Double.valueOf(199.99), product.getPrice());
    }
}
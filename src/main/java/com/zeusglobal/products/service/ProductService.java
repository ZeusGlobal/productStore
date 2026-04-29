package com.zeusglobal.products.service;

import com.zeusglobal.products.dto.ProductDTO;
import com.zeusglobal.products.model.Product;
import com.zeusglobal.products.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return modelMapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO,Product.class));
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO,Product.class));
        return productDTO;
    }
}

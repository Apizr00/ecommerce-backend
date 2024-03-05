package com.baluchi.ecommerce.ecommerce.services.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.ProductDetailDto;
import com.baluchi.ecommerce.ecommerce.dto.ProductDto;
import com.baluchi.ecommerce.ecommerce.entity.FAQ;
import com.baluchi.ecommerce.ecommerce.entity.Product;
import com.baluchi.ecommerce.ecommerce.entity.Review;
import com.baluchi.ecommerce.ecommerce.repository.FAQRepository;
import com.baluchi.ecommerce.ecommerce.repository.ProductRepository;
import com.baluchi.ecommerce.ecommerce.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    private final FAQRepository faqRepository;
    
    private final ReviewRepository reviewRepository;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> searchProductByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public ProductDetailDto getProductDetailById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            List<FAQ> faqList = faqRepository.findAllByProductId(productId);
            List<Review> reviewList = reviewRepository.findAllByProductId(productId);

            ProductDetailDto productDetailDto = new ProductDetailDto();

            productDetailDto.setProductDto(optionalProduct.get().getDto());
            productDetailDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
            productDetailDto.setReviewDtoList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));

            return productDetailDto;
        }
        return null;
    }
}

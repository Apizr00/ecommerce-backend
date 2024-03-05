package com.baluchi.ecommerce.ecommerce.services.admin.faq;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.FAQDto;
import com.baluchi.ecommerce.ecommerce.entity.FAQ;
import com.baluchi.ecommerce.ecommerce.entity.Product;
import com.baluchi.ecommerce.ecommerce.repository.FAQRepository;
import com.baluchi.ecommerce.ecommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQRepository faqRepository;

    private final ProductRepository productRepository;

    public FAQDto postFAQ(Long productId, FAQDto faqDto) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            FAQ faq = new FAQ();

            faq.setQuestion(faqDto.getQuestion());
            faq.setAnswer(faqDto.getAnswer());
            faq.setProduct(optionalProduct.get());

            return faqRepository.save(faq).getFAQDto();
        }
        return null;
    }
}

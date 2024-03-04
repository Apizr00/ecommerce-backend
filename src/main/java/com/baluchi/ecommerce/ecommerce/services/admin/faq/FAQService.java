package com.baluchi.ecommerce.ecommerce.services.admin.faq;

import com.baluchi.ecommerce.ecommerce.dto.FAQDto;

public interface FAQService {
    
    FAQDto postFAQ(Long productId, FAQDto faqDto);
}

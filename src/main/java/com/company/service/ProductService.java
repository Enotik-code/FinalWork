package com.company.service;

import com.company.exception.ProductException;
import com.company.logger.Loggers;
import com.company.ranges.Ranges;

import java.math.BigDecimal;

public class ProductService {

    static Loggers logger = new Loggers(ProductService.class.getName());

    public boolean validateDiscount(BigDecimal number) {
        try {
            if (!Ranges.discountRange.contains(number))
                throw new ProductException("The min id is 0");
            return true;
        } catch (ProductException ex) {
            logger.log.warn(ex.getMessage());
            return false;
        }
    }

    public boolean validatePrice(BigDecimal number) {
        try {
            if (!Ranges.priceRange.contains(number))
                throw new ProductException("The min id is 0");
            return true;
        } catch (ProductException ex) {
            logger.log.warn(ex.getMessage());
            return false;
        }
    }

    public boolean validateId(Long number) {
        try {
        if (!Ranges.idRange.contains(number))
            throw new ProductException("The min id is 0");
        return true;
    } catch (ProductException ex) {
        logger.log.warn(ex.getMessage());
        return false;
    }
}

}

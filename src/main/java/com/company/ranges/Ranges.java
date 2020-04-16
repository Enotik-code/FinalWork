package com.company.ranges;

import org.apache.commons.lang3.Range;
import java.math.BigDecimal;

public class Ranges {
    public static Range<BigDecimal> discountRange = Range.between(BigDecimal.valueOf(0.0), BigDecimal.valueOf(1));
    public static Range<BigDecimal> priceRange = Range.between(BigDecimal.valueOf(0), BigDecimal.valueOf(1000));
    public static Range<Long> idRange = Range.between(Long.valueOf(0), Long.valueOf(1000));
}

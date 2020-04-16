package com.company.bean;

import com.company.enums.Category;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product implements Serializable {
    private String name;
    private long id;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private Category categoryList;

    public void setCategoryList(int categoryList) {
    this.categoryList = Category.chooseCategory(categoryList);
    }
}

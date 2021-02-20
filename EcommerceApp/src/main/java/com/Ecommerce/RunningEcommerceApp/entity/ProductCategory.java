package com.Ecommerce.RunningEcommerceApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product_category")
// @Data -- known bug
//@Getter
//@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
	@Column(name = "category_name")
    private String categoryName;
	
	

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + "]";
	}


	public ProductCategory(Long id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	
	}
public ProductCategory()
{
	
}
    
    
}







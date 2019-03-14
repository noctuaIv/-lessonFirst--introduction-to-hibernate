package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "product")
public class Product extends Model {

	private static final long serialVersionUID = -7881391014358935700L;
	
	@Max(3)
	@NotEmpty
	@Column(name="title")
	private String title;
	
	@Pattern(regexp="")
	@NotNull(message="Field title is null")
	@Size(min=4, max=16, message="gggg")
	@Column(name="description")
	private String description;
	@Column(name="price  ")
	private BigDecimal price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_category_id", referencedColumnName="id")
	private ProductCategory productCategory;

	public Product() {

	}

	public Product(int id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	@Override
	public String toString(){
		return super.getId() + " - " + title + " - " + description + " - ";
	}

}

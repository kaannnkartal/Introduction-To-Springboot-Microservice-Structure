package kodlamaio.northwind.entites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

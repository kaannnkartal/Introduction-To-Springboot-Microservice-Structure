package kodlamaio.northwind.entites.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products") // Hangi tabloya ekleneceğini soyledik.
public class Product {

    @Id  // Veritabanı icin primary key olacağını soyledik.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bu değerin auto_increment +1 olacağını soyledik.
    @Column(name = "product_id") // Attributeların hangi columnlara tekabul ettiğini soyledik.
    private int id;

    //@Column(name = "category_id")
    //private int categoryId;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;


}
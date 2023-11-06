package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entites.concretes.Category;
import kodlamaio.northwind.entites.concretes.Product;
import kodlamaio.northwind.entites.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    // Generic yapının parametreleri entity ve primary key türü.

    Product getByProductName(String productName);

    // int categoryId yerine Category category eklendi.
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName , int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    // ****** //
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List <Product> getByNameAndCategory_CategoryId(String productName, int categoryId);


    @Query("Select new kodlamaio.northwind.entites.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails(); // Select * from Category c inner join Product p on c.categoryId = p.categoryId

}

package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entites.concretes.Category;
import kodlamaio.northwind.entites.concretes.Product;
import kodlamaio.northwind.entites.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSorted();
    Result add (Product product);


    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName , int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    // ****** //
    DataResult<List <Product>> getByNameAndCategory_CategoryId(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}

package uk.ac.westminster.products_api;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    {
        addProduct(new DigitalProduct(1L ,"Ebook", 50.0, "/home/folder", 12.1));
        addProduct(new PhysicalProduct(2L ,"Monitor", 120.0, 20, "27x12"));
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }




}

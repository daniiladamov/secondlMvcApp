package com.example.buycell.controllers;

import com.example.buycell.models.Product;
import com.example.buycell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name ="title", required = false) String title, Model model) {
model.addAttribute("products",productService.listProducts(title));
    return "products";
    }

    @PostMapping("/product/create")
    public  String createProduct(@RequestParam("file1") MultipartFile file1,
                                 @RequestParam("file2") MultipartFile file2,
                                 @RequestParam("file3") MultipartFile file3,
                                 Product product) throws IOException {
productService.saveProduct(product, file1, file2, file3);
return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Product product=productService.getProductByID(id);
model.addAttribute("product", productService.getProductByID(id));
model.addAttribute("images", product.getImages());
        return "product-info";
    }
}

package com.shopping.agro.controlllers;

import com.google.gson.Gson;
import com.shopping.agro.Constants;
import com.shopping.agro.entities.*;
import com.shopping.agro.exceptions.UnknownRepositoryException;
import com.shopping.agro.models.Product;
import com.shopping.agro.models.UserModel;
import com.shopping.agro.models.UserRegResponse;
import com.shopping.agro.services.*;
import com.shopping.agro.utility.AgroUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserDetails userDetails;
    @Autowired
    private Gson gson;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductDetailsService productDetailsService;
    @Autowired
    private CartService cartService;
    @PostMapping(value = "/registerUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody UserModel user) throws UnknownRepositoryException {
        System.out.println(user);
        UserRegResponse userRegResponse = new UserRegResponse();
        if(AgroUtility.validateUser(user, userDetails)){
            logger.debug("save");
            User userEntity = user.mapToEntity();
            Optional<User> optionalUser = userDetails.save(userEntity);
            if(AgroUtility.createUser(user, userDetails)){
                userRegResponse.setStatus(Constants.SUCCESS);
                userRegResponse.setMessage("Wooh !! you have successfully registered with us. please <a href='/login'>Click</a> here to login.");
            }else {
                AgroUtility.rollbackUser(optionalUser, userDetails);
                userRegResponse.setStatus(Constants.FAILED);
                userRegResponse.setMessage("Oops !! Something went wrong. Do retry after sometime.");
            }

        }else {
            logger.debug("else block executed");
            userRegResponse.setStatus(Constants.FAILED);
            userRegResponse.setMessage("Oops !! You have already registered with us. please <a href='/login'>Click</a> here to login.");
        }
        return gson.toJson(userRegResponse);
    }

    public String addToCart(){
        return null;
    }

    /*@GetMapping("/fetchProducts")
    public String fetchProducts(){
        FetchProductResponse response = new FetchProductResponse();
        List<Product> productList = new ArrayList<>();
        List<String> productNameList = Arrays.asList("Pizza", "Mobile", "Television", "Watch","Cloths", "Earphones", "Charger", "Powerbanks", "Food", "Laptops");

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setProductCode("Product_" + i);
            product.setProductDescription("Not available");
            product.setProductName(productNameList.get(i));
            product.setProductPrice("20.00$");
            product.setProductImageUrl("http://localhost:8088/images/p101");
            productList.add(product);
        }
        response.setProductList(productList);
        response.setErrorCode(0);
        response.setStatus(Constants.SUCCESS);
        return gson.toJson(response);
    }*/



    @GetMapping(
            value = "product/images/{imageName}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
    )
    public @ResponseBody byte[] loadProductImage(@PathVariable(name = "imageName") String fileName) throws IOException {
        if(AgroUtility.validateImageName(fileName)){
            String imageCode = fileName.split(Constants.PRODUCT_CODE_APPENDER)[1];
            Optional<ProductImages> productImages = productImageService.loadImage(Long.valueOf(imageCode));
            if(productImages.isPresent()){
                return productImages.get().getContent();
            }
        }
        return null;
    }

    @PostMapping(value = "/addItemToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addItemToCart(@RequestBody Product product){
        UserRegResponse userRegResponse = new UserRegResponse();
        Map<String, String> resultMap = AgroUtility.setLoggedInUserDetails();
        Optional<UserModel> userModel = userDetails.findByUserName(resultMap.get("username"));
        if(userModel.isPresent()){
            Cart cart = new Cart();
            User user = userModel.get().mapToEntity();
            cart.setUser(user);
            ProductDetails productDetails = new ProductDetails();
            ProductDTO productDTO = product.mapToDTO();
            productDetails.setProduct(productDTO);
            productDetails.setQuantity(1);
            Set<ProductDetails> productDetailsSet = new HashSet<>();
            productDetailsSet.add(productDetails);
            cart.setProductDetailsSet(productDetailsSet);
            userDetails.save(user);
            productService.add(productDTO);
            productDetailsService.add(productDetails);
            cartService.add(cart);
            userRegResponse.setMessage("Added successfully");
            userRegResponse.setStatus(Constants.SUCCESS);
            return gson.toJson(userRegResponse);
        }
        userRegResponse.setStatus(Constants.FAILED);
        return gson.toJson(userRegResponse);
    }

    @GetMapping(value = "/fetchAllCartItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String fetchAllCartItems(@RequestParam(name = "username") String username){

        return "";
    }

}

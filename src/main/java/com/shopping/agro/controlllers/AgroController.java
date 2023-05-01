package com.shopping.agro.controlllers;

import com.shopping.agro.Constants;
import com.shopping.agro.entities.ProductDTO;
import com.shopping.agro.entities.ProductImages;
import com.shopping.agro.models.Product;
import com.shopping.agro.services.ProductImageService;
import com.shopping.agro.services.ProductService;
import com.shopping.agro.utility.AgroUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class AgroController {
    private static final Logger logger = LoggerFactory.getLogger(AgroController.class);
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @GetMapping({"/login"})
    public String login(ModelMap modelMap, @RequestParam(defaultValue = "false", name = "error") boolean error,
                        @RequestParam(defaultValue = "false", name = "logout") boolean logout) {
        logger.debug("enterd in index");
        if (error) {
            modelMap.addAttribute("message", "Invalid Credentials !! Please enter correct details.");
        } else if (logout) {
            modelMap.addAttribute("message", "Thanks for visiting with us !! You have successfully logged out.");
        }
        logger.debug(modelMap.toString());
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap map) {
        logger.debug("enterd in register");
        return "register";
    }

    @GetMapping("/accessdenied")
    public String accessdenied(ModelMap modelMap) {
        logger.debug("enterd in accessdenied");
        return "accessdenied";
    }

    @GetMapping("/logout")
    public String logout(ModelMap modelMap) {
        logger.debug("enterd in logout");
        return "logout";
    }

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION, Constants.ACTION_SHOPPING);
        logger.debug(modelMap.toString());
        return "index";
    }

    @GetMapping("/cart")
    public String cart(ModelMap modelMap){
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION,Constants.ACTION_CART);
        return "index";
    }

    @GetMapping("/about")
    public String about(ModelMap modelMap){
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION, Constants.ACTION_ABOUT);
        return "index";
    }
    @GetMapping("/updateItem")
    public String updateItem(ModelMap modelMap){
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION, Constants.ACTION_UPDATE_ITEM);
        return "index";
    }
    @GetMapping("/deleteItem")
    public String deleteItem(ModelMap modelMap){
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION, Constants.ACTION_DELETE_ITEM);
        return "index";
    }

    @GetMapping("/addItem")
    public String addItem(@RequestParam(name = "itemAdded", defaultValue = "false") boolean itemAdded, ModelMap modelMap){
        AgroUtility.setLoggedInUserDetails(modelMap);
        modelMap.addAttribute(Constants.ACTION, Constants.ACTION_ADD_ITEM);
        return "index";
    }
    @PostMapping(value = "/addItem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addItem(@ModelAttribute Product product, ModelMap modelMap) throws IOException {
        AgroUtility.setLoggedInUserDetails(modelMap);
        logger.debug("product : "+ product);
        MultipartFile multipartFile = product.getMultipartFile();
        ProductImages images = new ProductImages();
        images.setContent(multipartFile.getBytes());
        images.setProductName("pName");
        Optional<ProductImages> add = productImageService.add(images);
        modelMap.addAttribute("addItemCalled", true);
        if(add.isPresent()){
            product.setProductCode(Constants.PRODUCT_CODE_APPENDER + add.get().getId());
            ProductDTO dto = product.mapToDTO();
            Optional<ProductDTO> productDTOResponse = productService.add(dto);
            if(productDTOResponse.isPresent()){
                modelMap.addAttribute("status", "SUCCESS");
                modelMap.addAttribute("message", "You have successfully added the item.");
            }
        }
        return "index";
    }


}

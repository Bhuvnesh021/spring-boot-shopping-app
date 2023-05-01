package com.shopping.agro.utility;

import com.google.gson.Gson;
import com.shopping.agro.Constants;
import com.shopping.agro.entities.Authority;
import com.shopping.agro.entities.User;
import com.shopping.agro.entities.UserCredentials;
import com.shopping.agro.exceptions.UnknownRepositoryException;
import com.shopping.agro.models.FetchProductResponse;
import com.shopping.agro.models.Product;
import com.shopping.agro.models.UserModel;
import com.shopping.agro.services.UserDetails;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

import java.util.*;

public class AgroUtility {


    public static boolean validateUser(UserModel user, UserDetails userDetails) throws UnknownRepositoryException {
        Optional<User> byUserName = userDetails.findByUserName(user);
        if(byUserName.isPresent()) return false;
        System.out.println("returing true");
        return true;
    }

    public static boolean createUser(UserModel user, UserDetails userDetails) {
        UserCredentials credentials = user.mapToUserCredentialsEntity();
        for(Authority authority : credentials.getRoles()){
            userDetails.save(authority);
        }
        Optional<UserCredentials> save = userDetails.save(credentials);
        return save.isPresent();
    }

    public static void rollbackUser(Optional<User> optionalUser, UserDetails userDetails) {
        userDetails.rollback(optionalUser.get());
    }

    public static void setLoggedInUserDetails(ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Iterator<? extends GrantedAuthority> iterator = authentication.getAuthorities().iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()){
            builder.append(iterator.next());
        }
        modelMap.addAttribute("username", currentPrincipalName);
        modelMap.addAttribute("role",builder.toString());
    }
    public static Map<String, String> setLoggedInUserDetails(){
        Map<String, String> resultMap = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Iterator<? extends GrantedAuthority> iterator = authentication.getAuthorities().iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()){
            builder.append(iterator.next());
        }
        resultMap.put("username", currentPrincipalName);
        resultMap.put("role",builder.toString());
        return resultMap;
    }
    public static boolean validateImageName(String fileName) {
        if(fileName.contains(Constants.PRODUCT_CODE_APPENDER)){
            return true;
        }
        return false;
    }
}

package com.shopping.agro;

import org.springframework.beans.factory.annotation.Value;

public class Constants {
    public static final String YES = "YES";
    public static final String SUCCESS = "SUCCESS";
    public static final String HOST = "localhost";
    public static final String PORT = "8089";
    public static final String BASE_URL = String.format("http://%s:%s", HOST, PORT);
    public static final String PRODUCT_IMAGE_URL = "/product/images/";
    public static final String FAILED = "FAIL";
    public static final String ACTION = "action";
    public static final String ACTION_SHOPPING = "shopping";
    public static final String ACTION_CART = "cart";
    public static final String ACTION_ABOUT = "about";
    public static final String ACTION_ADD_ITEM = "addItem";
    public static final String ACTION_UPDATE_ITEM = "updateItem";
    public static final String ACTION_DELETE_ITEM = "deleteItem";
    public static final String PRODUCT_CODE_APPENDER = "Product_";



    private Constants(){

    }
    public static String NO_OP_SECURITY = "{noop}";
}

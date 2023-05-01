<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/images/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />

       <link rel="stylesheet" href="/css/fontawesome.min.css" />
       <link rel="stylesheet" href="/css/jquery-ui.min.css" type="text/css" />
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/css/templatemo-style.css">
        <!--<link rel="stylesheet" href="/css/add-item.css">-->
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>


    <body onload = "onload();">
        <c:set var = "addItemAction" scope = "session" value = "addItem"/>
        <!-- navigation -->
        <%@include file = "navigation.html" %>
        <c:if test = "${addItemAction != action}">
            <!-- Header Section -->
            <%@include file ="header.html" %>
        </c:if>

        <!-- Section-->
        <c:set var = "shoppingAction" scope = "session" value = "shopping"/>
        <c:if test = "${shoppingAction == action}">
            <%@include file = "shopping-view.html" %>
        </c:if>

        <c:set var = "cartAction" scope = "session" value = "cart"/>
        <c:if test = "${cartAction == action}">
            <%@include file = "cart.html" %>
        </c:if>

        <c:set var = "aboutAction" scope = "session" value = "about"/>
        <c:if test = "${aboutAction == action}">
            <%@include file = "about.html" %>
        </c:if>


        <c:if test = "${addItemAction == action || not empty addItemCalled}">
            <%@include file = "add-item.html" %>
        </c:if>

        <c:set var = "deleteAction" scope = "session" value = "deleteItem"/>
        <c:if test = "${deleteAction == action}">
            <%@include file = "delete-item.html" %>
        </c:if>

        <c:set var = "updateAction" scope = "session" value = "updateItem"/>
        <c:if test = "${updateAction == action}">
            <%@include file = "update-item.html" %>
        </c:if>
        <!-- Footer Page -->
        <%@include file = "footer.html" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/js/scripts.js"></script>
        <script>
            $("#expire_date").datepicker();
            function addToCartClicked(product){
                console.log("add to cart clicked");
                var requestJSON = JSON.stringify(product);
                console.log("product : "+ requestJSON);
                $.ajax({
                            type: "POST",
                            contentType:"application/json",
                            url: "addItemToCart",
                            data: requestJSON,
                            timeout: 600000,
                            success: function (data) {
                                console.log("success");
                                if(data.status == 'FAIL'){
                                    alert("Operation failed. Please do retry");
                                }
                                if(data.status == 'SUCCESS'){
                                    var counter = document.getElementById("number_of_cart_items");
                                    var cart_count = parseInt(counter.textContent);
                                    cart_count = cart_count + 1;
                                    console.log("cart_count : "+ cart_count);
                                    counter.innerHTML = cart_count;
                                }
                            },
                            error: function (e) {
                                console.log("failed");
                            }
                  		 });
            }

            function onload(){
                console.log("page loaded..");
                $.ajax({
                            type: "GET",
                            contentType:"application/json",
                            url: "loadProducts",
                            timeout: 600000,
                            success: function (data) {
                                console.log("success");
                                var product_list = data;
                                console.log(product_list.length);
                                for (i = 0; i < product_list.length; i++) {
                                   var product =  product_list[i];
                                   document.getElementById("products-view").innerHTML += "<div class='col mb-5'><div class='card h-100'> <!-- Sale badge--><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>" + product.status + "</div><!-- Product image--><img class='card-img-top' src=" + product.productImageUrl + " alt='...' /><!-- Product details--><div class='card-body p-4'><div class='text-center'><!-- Product name--><h5 class='fw-bolder'>" + product.productName + "</h5><!-- Product reviews--><div class='d-flex justify-content-center small text-warning mb-2'><div class='bi-star-fill'></div><div class='bi-star-fill'></div><div class='bi-star-fill'></div><div class='bi-star-fill'></div><div class='bi-star-fill'></div></div><!-- Product price--><span class='text-muted text-decoration-line-through'></span>Rs. " + product.productPrice + "</div></div><!-- Product actions--><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'><div class='text-center'><button type = 'submit' class='btn btn-outline-dark mt-auto' onclick='addToCartClicked("+JSON.stringify(product)+");'>Add to cart</button></div></div></div></div>";
                                }
                            },
                            error: function (e) {
                                console.log("failed");
                            }
                  		 });
                console.log(${products});

            }
        </script>
    </body>
</html>

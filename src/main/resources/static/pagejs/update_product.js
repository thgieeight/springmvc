function updateProduct(productId){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/product-detail",
        dataType: "json",   //expect json to be returned
        data : {productId :productId},
        success: function(data){
            console.log(data);
             $("#productId").val(data.productId);
             $("#productName").val(data.productName);
           getCategoryDropDownWithSelected(data.category.categoryId);
            if(data.status==1){
                $('#productStatus').attr('checked', true);
            }else{
                $('#productStatus').attr('checked', false);
            }
            console.log("success getting product details");
            $('#updateProduct').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
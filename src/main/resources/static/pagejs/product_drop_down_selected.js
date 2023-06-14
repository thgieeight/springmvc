function getProductDropDownWithSelected(selectedProduct){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/enabled-product",
        dataType: "json",   //expect json to be returned
        success: function(data){
            $('#updateProductId').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['product_name']);
                $('#updateProductId').append($('<option>', {
                    value:value['product_id'],
                    text:value['product_name']
                }));

                if(value['product_id']==selectedProduct){
                    $("#updateProductId").val(value['product_id']).change();
                }

            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
function updateCategory(catId){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/category-detail",
        dataType: "json",   //expect json to be returned
        data : {categoryId :catId},
        success: function(data){
            console.log(data);
             $("#categoryId").val(data.categoryId);
             $("#categroyName").val(data.categoryName);
            if(data.status==1){
                $('#categoryStatus').attr('checked', true);
            }else{
                $('#categoryStatus').attr('checked', false);
            }
            console.log("success getting category details");
            $('#updateCategory').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
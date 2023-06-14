function getCategoryDropDownWithSelected(selectedCategory){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/enabled-category",
        dataType: "json",   //expect json to be returned
        success: function(data){
                    $('#updateCategoryId').find('option').remove();

            $.each(data, function(key, value) {
                console.log(value['category_name']);
                $('#updateCategoryId').append($('<option>', {
                    value:value['category_id'],
                    text:value['category_name']
                }));
                if(value['category_id']==selectedCategory){
                    $("#updateCategoryId").val(value['category_id']).change();
                }

            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
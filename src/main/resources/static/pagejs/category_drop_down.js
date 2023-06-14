function getCategoryDropDown(){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/enabled-category",
        dataType: "json",   //expect json to be returned
        success: function(data){
                                $('#categoryId').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['category_name']);
                $('#categoryId').append($('<option>', {
                    value:value['category_id'],
                    text:value['category_name']
                }));
            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
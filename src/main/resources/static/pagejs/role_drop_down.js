function getRolesDropDown(){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/enabled-roles",
        dataType: "json",   //expect json to be returned
        success: function(data){
                                $('#id').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['name']);
                $('#id').append($('<option>', {
                    value:value['id'],
                    text:value['name']
                }));
            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
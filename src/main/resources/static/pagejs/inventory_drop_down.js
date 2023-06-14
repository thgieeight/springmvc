function getInventoryDropDown(){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/enabled-inventory",
        dataType: "json",   //expect json to be returned
        success: function(data){
                                $('#inventoryId').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['inventory_name']);
                $('#inventoryId').append($('<option>', {
                    value:value['inventory_id'],
                    text:value['inventory_name']
                }));
            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
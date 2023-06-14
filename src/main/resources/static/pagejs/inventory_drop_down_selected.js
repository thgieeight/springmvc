function getInventoryDropDownWithSelected(selectedInventory){
    $.ajax({    //create an ajax request to get inventory details
        type: "POST",
        url: "/invmgtsys/enabled-inventory",
        dataType: "json",   //expect json to be returned
        success: function(data){
            $('#updateInventoryId').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['inventory_name']);
                $('#updateInventoryId').append($('<option>', {
                    value:value['inventory_id'],
                    text:value['inventory_name']
                }));

                if(value['inventory_id']==selectedInventory){
                    $("#updateInventoryId").val(value['inventory_id']).change();
                }

            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
function updateSells(sellsId){
    $.ajax({    //create an ajax request to get sells details
        type: "POST",
        url: "/invmgtsys/sells-detail",
        dataType: "json",   //expect json to be returned
        data : {sellsId :sellsId},
        success: function(data){
            console.log(data);
             $("#sellsId").val(data.sellsId);
             $("#updateCustomerSellsName").val(data.customerName);
             $("#updateQuantity").val(data.sellQty);
             $("#updatestatus").val(data.status);
             $("#updatedescriptionName").val(data.descriptionName);
         getInventoryDropDownWithSelected(data.inventory.inventoryId);
            if(data.status==1){
                $('#updateSellsStatus').attr('checked', true);
            }else{
                $('#updateSellsStatus').attr('checked', false);
            }
            console.log("success getting sells details");
            $('#updateSells').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
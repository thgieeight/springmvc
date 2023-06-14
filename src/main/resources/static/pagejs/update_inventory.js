function updateInventory(proId){
    $.ajax({    //create an ajax request to get inventory details
        type: "POST",
        url: "/invmgtsys/inventory-detail",
        dataType: "json",   //expect json to be returned
        data : {inventoryId :proId},
        success: function(data){
            console.log(data);
             $("#inventoryId").val(data.inventoryId);
             $("#updateInventoryName").val(data.inventoryName);
             $("#updateQuantity").val(data.quantity);
             $("#updateCostPrice").val(data.costPrice);
             $("#updateSellPrice").val(data.sellPrice);
             getProductDropDownWithSelected(data.product.productId);
            if(data.status==1){
                $('#updateInventoryStatus').attr('checked', true);
            }else{
                $('#updateInventoryStatus').attr('checked', false);
            }
            console.log("success getting inventory details");
            $('#updateInventory').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
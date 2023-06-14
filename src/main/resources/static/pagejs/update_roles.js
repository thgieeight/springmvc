function updateRole(rolId){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/role-detail",
        dataType: "json",   //expect json to be returned
        data : {roleId :rolId},
        success: function(data){
            console.log(data);
             $("#id").val(data.id);
             $("#name").val(data.name);
            if(data.status==1){
                $('#roleStatus').attr('checked', true);
            }else{
                $('#roleStatus').attr('checked', false);
            }
            console.log("success getting role details");
            $('#updateRo').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
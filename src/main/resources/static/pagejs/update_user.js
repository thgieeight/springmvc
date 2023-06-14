function updateUser(userId){
    $.ajax({    //create an ajax request to get product details
        type: "POST",
        url: "/invmgtsys/user-detail",
        dataType: "json",   //expect json to be returned
        data : {userId :userId},
        success: function(data){
            console.log(data);
             $("#id").val(data.id);
             $("#firstName").val(data.firstName);
             $("#lastName").val(data.lastName);
             $("#email").val(data.email);
             $("#status").val(data.status);
            getRolesDropDownWithSelected(selectedRoles);
            if(data.status==1){
                $('#userStatus').attr('checked', true);
            }else{
                $('#userStatus').attr('checked', false);
            }
            console.log("success getting user details");

            $('#updateUser').modal('show');

        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }

    });
}
function getRolesDropDownWithSelected(selectedRoles){
    $.ajax({    //create an ajax request to get roles details
        type: "POST",
        url: "/invmgtsys/enabled-roles",
        dataType: "json",   //expect json to be returned
        success: function(data){
            $('#updateRo').find('option').remove();
            $.each(data, function(key, value) {

                console.log(value['roles_name']);
                $('#updateRo').append($('<option>', {
                    value:value['id'],
                    text:value['name']
                }));

                if(value['roles_id']==selectedRoles){
                    $("#updateRo").val(value['id']).change();
                }

            });
        },
        error: function(response) {

            console.log('ERROR BLOCK');
            console.log(response);
        }


    });
}
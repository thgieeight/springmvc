package com.inventory.invmgtsys.startup;

import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.repo.RolesRepo;
import org.springframework.stereotype.Component;

@Component
public class RolesLoader {
    RolesRepo rolesRepo;
    public RolesLoader(RolesRepo rolesRepo){
        this.rolesRepo=rolesRepo;
    }

    public void LoadDefaultRoles() {
        if (rolesRepo.findRoleByName("ADMIN") == null) {
            Roles admin = new Roles().
                    builder().name("ADMIN").build();
            rolesRepo.save(admin);
        }
        if (rolesRepo.findRoleByName("MANAGER") == null) {
            Roles manager = new Roles().
                    builder().name("MANAGER").build();
            rolesRepo.save(manager);
        }
        if (rolesRepo.findRoleByName("USER") == null) {
            Roles user = new Roles().
                    builder().name("USER").build();
            rolesRepo.save(user);
        }
    }
}
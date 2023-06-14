package com.inventory.invmgtsys.startup;

import com.inventory.invmgtsys.config.DefaultPasswordEncoderFactories;
import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.model.User;
import com.inventory.invmgtsys.repo.RolesRepo;
import com.inventory.invmgtsys.repo.UserRepo;
import com.inventory.invmgtsys.service.InvUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialLoad {
    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    InvUserRoleService invUserRoleService;

    @PostConstruct
    public void loadAdminUser() {
        RolesLoader roleLoader = new RolesLoader(this.rolesRepo);
        roleLoader.LoadDefaultRoles();


        Roles admin = rolesRepo.findRoleByName("ADMIN");
        List<Roles> roles = new ArrayList<>();
        roles.add(admin);

        System.out.println("initial loading");
        System.out.println("roles"+admin.getName());

//        Roles adminRoles = invUserRoleService.findRolesById(admin.getId());
//        List<Roles> userRoles = new ArrayList<>();
//        userRoles.add(adminRoles);

        User adminUser = new User()
                .builder()
                .username("admin")
                .firstName("admin")
                .lastName("admin")
                .email("admin@gmail.com")
                .enabled(true)
                .password(DefaultPasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin123"))
                .roles(roles)
                .build();
        /**
         * Check is user already exists or not
         */
        if (userRepo.findInventoryUserByUsername("admin") == null) {
            userRepo.save(adminUser);
        }

    }
}

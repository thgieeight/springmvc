package com.inventory.invmgtsys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String subject;
    private String message;
    private String receiver;
    //private String attachmentName;
    //private MultipartFile image;

}
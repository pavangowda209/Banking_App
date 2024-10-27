package com.main_project.Bankig.app.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String AccountHolderName;
    private Double Balance;
}

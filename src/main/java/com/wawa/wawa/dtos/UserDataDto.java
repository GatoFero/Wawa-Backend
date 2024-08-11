package com.wawa.wawa.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDataDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
}

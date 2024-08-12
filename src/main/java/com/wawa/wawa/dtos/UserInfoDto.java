package com.wawa.wawa.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoDto {

    private Integer id;
    private String username;
    private String email;
    private boolean vip;
    private Integer level;
    private Integer top;
}

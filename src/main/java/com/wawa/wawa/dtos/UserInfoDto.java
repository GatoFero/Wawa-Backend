package com.wawa.wawa.dtos;

import com.wawa.wawa.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoDto {

    private Integer id;
    private String username;
    private boolean vip;
    private Integer level;
    private Integer top;
    private List<ProgressDto> progress = new ArrayList<>();
}

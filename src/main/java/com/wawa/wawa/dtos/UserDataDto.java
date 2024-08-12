package com.wawa.wawa.dtos;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDataDto {

    private UserInfoDto userInfo;
    private List<ProgressDto> progress;
}

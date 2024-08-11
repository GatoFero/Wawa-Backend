package com.wawa.wawa.utiles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargeData {

    private Integer id;
    private List<Integer> charge;
    private String typeMaterial;
    public final static String COURSE = "course";
}

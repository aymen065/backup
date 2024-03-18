package com.ads.library.auth.dto;

import com.ads.library.auth.models.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {
    private Integer id;
    private ERole name;
    public RoleDTO(ERole name) {
        this.name = name;
    }
}

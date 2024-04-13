package com.github.fabio2g.stocksync.dto;

import com.github.fabio2g.stocksync.enums.RoleEnum;

public record UserDTO(
        Long id,
        String name,
        String login,
        String password,
        String registration,
        RoleEnum role,
        Boolean isDeleted
) {
}

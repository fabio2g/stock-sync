package com.github.fabio2g.stocksync.dto;

public record UserDTO(
        Long id,
        String name,
        String login,
        String password,
        String registration,
        String role
) {
}

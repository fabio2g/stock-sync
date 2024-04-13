package com.github.fabio2g.stocksync.controller;

import com.github.fabio2g.stocksync.dto.UserDTO;
import com.github.fabio2g.stocksync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity save(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.save(userDTO);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/search/one/{id}")
    private ResponseEntity findByAll(@PathVariable Long id) {
        UserDTO user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("search/all")
    private ResponseEntity<List<UserDTO>> findAll() {

        List<UserDTO> userDTOs = userService.findAll();

        return ResponseEntity.ok().body(userDTOs);
    }

    @GetMapping("delete/{id}")
    private ResponseEntity<Map<String, Object>> delete(@PathVariable long id) {
        boolean deleted = userService.delete(id);

        Map<String, Object> json = new LinkedHashMap<>();

        if (!deleted) {
            json.put("status", "failed");
            json.put("message", "Usuário com ID " + id + " não encontrado ou não pôde ser excluído.");
            return ResponseEntity.badRequest().body(json);
        }

        json.put("status", "success");
        json.put("message", "Usuário com ID " + id + " excluído com sucesso.");
        return ResponseEntity.ok().body(json);
    }
}


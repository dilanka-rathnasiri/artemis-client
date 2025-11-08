package com.example.client.controllers;

import com.example.client.services.MsgServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MsgControllers {
    private final MsgServices msgServices;

    @PostMapping("/message")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody final Map<String, String> reqBody) {
        Map<String, String> resp = new HashMap<>();
        try {
            String msg = reqBody.get("message");
            msgServices.sendMsg(msg);
            resp.put("message", "Message sent successfully");
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp.put("error", e.getMessage());
            return ResponseEntity.internalServerError()
                    .body(resp);
        }
    }
}

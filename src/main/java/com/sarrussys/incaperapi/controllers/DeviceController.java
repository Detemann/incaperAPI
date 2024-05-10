package com.sarrussys.incaperapi.controllers;

import com.sarrussys.incaperapi.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
@CrossOrigin(origins = "*")
public class DeviceController {

    private DeviceService deviceService;
    @GetMapping
    public ResponseEntity<Object> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAll());
    }
}

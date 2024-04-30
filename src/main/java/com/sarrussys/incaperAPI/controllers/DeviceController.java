package com.sarrussys.incaperAPI.controllers;

import com.sarrussys.incaperAPI.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {

    private DeviceService deviceService;
    @GetMapping
    public ResponseEntity getAllDevices() {
        return ResponseEntity.ok(deviceService.getAll());
    }
}
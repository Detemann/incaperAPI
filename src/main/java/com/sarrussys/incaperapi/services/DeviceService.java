package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.device.Device;
import com.sarrussys.incaperapi.model.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }
}

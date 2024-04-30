package com.sarrussys.incaperAPI.services;

import com.sarrussys.incaperAPI.Model.device.Device;
import com.sarrussys.incaperAPI.Model.device.DeviceRepository;
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

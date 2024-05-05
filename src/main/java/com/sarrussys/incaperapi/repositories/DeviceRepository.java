package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> { }

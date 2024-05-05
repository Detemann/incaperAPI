package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.device.Device;
import com.sarrussys.incaperapi.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAll() {
        List<Device> device = deviceRepository.findAll();
        if (device.isEmpty()) throw new NoSuchElementException("Dados sobre dispositivos não encontrados");
        return device;
    }

    public Device getById(Integer id) {
        if (Objects.isNull(id)) throw new NullPointerException("Campo ID não pode ser nulo");
        Optional<Device> device = deviceRepository.findById(id);
        return device.orElseGet(() -> {
            throw new NoSuchElementException("Dados do dispositivo com id {" + id + "} não encontrado");
        });
    }


}

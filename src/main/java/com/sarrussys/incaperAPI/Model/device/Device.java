package com.sarrussys.incaperAPI.Model.device;

import com.sarrussys.incaperAPI.Model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "device_data")
@Entity(name = "device")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    private int deviceId;
    @Column(name = "last_log")
    private Date lastLog;
    @ManyToOne
    @JoinColumn(name = "ownedDevices")
    private User owner;

    public Device(RequestDevice device) throws ParseException {
        this.deviceId = device.id();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.lastLog = dateFormat.parse(device.lastLog());
    }
}


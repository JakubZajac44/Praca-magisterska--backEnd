package com.ar.backend.backeend.controller;

import com.ar.backend.backeend.model.device.Device;
import com.ar.backend.backeend.model.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/allDevice")
@CrossOrigin(origins = "http://192.0.0.4")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(method = POST)
    public void addDevice(@RequestBody Device device) {
        deviceRepository.save(device);
    }

    @RequestMapping(method = GET)
    public List<Device> getDevices() throws IOException {
        return deviceRepository.findAll();
    }


}

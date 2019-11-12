package com.ar.backend.backeend;

import com.ar.backend.backeend.model.device.Device;
import com.ar.backend.backeend.model.device.DeviceRepository;
import com.ar.backend.backeend.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeed implements CommandLineRunner {
    private DeviceRepository deviceRepository;

    @Autowired
    public UserRepository userRepository;

    public DbSeed(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

        Device termometr1 = new Device(
                1,
                "Termometr ",
                "13 C",
                49.986692,
                19.422955,
                date
        );

        Device termometr2 = new Device(
                2,
                "Termometr ",
                "12 C",
                49.919094,
                20.274134,
                date
        );

        Device termometr3 = new Device(
                3,
                "Termometr ",
                "8 C",
                50.080020,
                20.519401,
                date
        );

        Device termometr4 = new Device(
                4,
                "Termometr ",
                "13 C",
                52.843523,
                16.862168,
                date
        );

        Device termometr5 = new Device(
                11,
                "Termometr ",
                "14.5 C",
                52.378214,
                21.015000,
                date
        );

        Device barometr1 = new Device(
                5,
                "Barometr ",
                "998 hPa",
                52.330746,
                20.848852,
                date
        );

        Device barometr2 = new Device(
                6,
                "Barometr ",
                "992 hPa",
                52.104784,
                20.714757,
                date
        );
        Device barometr3 = new Device(
                7,
                "Barometr ",
                "986 hPa",
                52.630662,
                16.235948,
                date
        );

        Device pow1 = new Device(
                8,
                "Czujnik powietrza ",
                "180%",
                52.297946,
                21.032325,
                date
        );

        Device pow2 = new Device(
                9,
                "Czujnik powietrza ",
                "83%",
                52.190316,
                21.0379017,
                date
        );

        Device pow3 = new Device(
                10,
                "Czujnik powietrza ",
                "132%",
                53.377692,
                16.005235,
                date
        );
//userRepository.del/eteAll();
        this.deviceRepository.deleteAll();

        List<Device> hotels = Arrays.asList(termometr1, termometr2,termometr3, termometr4,termometr5, barometr1,barometr2,barometr3,pow1,pow2,pow3);
        this.deviceRepository.insert(hotels);
    }
}

package com.bosch.example;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bosch.example.device.DeviceManagementService;
import com.bosch.example.device.model.Device;
import com.bosch.example.device.model.DeviceTag;

/**
 * @author Michael Hirsch
 *
 */
@Component
public class DeviceInitializer {

    private static int amount = 100;

    private static final String[] HW_REVISIONS = new String[] { "1.0", "1.1", "2.0" };

    private static final String[] TAGS = new String[] { "SmartHome", "Vehicle", "Test" };

    @Autowired
    private DeviceManagementService deviceManagementService;

    @PostConstruct
    public void createDemoData() {
        final Random rnd = new Random();

        for (final String tag : TAGS) {
            deviceManagementService.addTag(DeviceTag.builder().color(255, 0, 0).description("description").name(tag)
                    .build());
        }

        for (int i = 0; i < amount; i++) {
            final String deviceId = UUID.randomUUID().toString();
            deviceManagementService.addDevice(Device.builder().id(deviceId).createdAt(randomTimestamp())
                    .metadata("hwrevision", HW_REVISIONS[rnd.nextInt(HW_REVISIONS.length - 1)]).build());

            final int randomTagIndex = rnd.nextInt(TAGS.length + 7);
            if (randomTagIndex < TAGS.length) {
                deviceManagementService.assignTag(TAGS[randomTagIndex], deviceId);
            }
        }
    }

    private long randomTimestamp() {
        final long offset = LocalDateTime.of(2012, 1, 1, 0, 0).toInstant(ZoneOffset.UTC).toEpochMilli();
        final long end = LocalDateTime.of(2013, 1, 1, 0, 0).toInstant(ZoneOffset.UTC).toEpochMilli();
        final long diff = end - offset + 1;
        return offset + (long) (Math.random() * diff);
    }

}

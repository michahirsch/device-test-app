/**
 * Copyright (c) 2011-2015 Bosch Software Innovations GmbH, Germany. All rights reserved.
 */
package com.bosch.example.device;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bosch.example.device.model.DeviceTag;
import com.google.common.collect.Multimap;

/**
 * @author Michael Hirsch
 *
 */
public class DeviceTagFilter {

    private String deviceId;

    public static DeviceTagFilter emptyFilter() {
        return new DeviceTagFilter();
    }

    public DeviceTagFilter device(final String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public List<DeviceTag> apply(final Map<String, DeviceTag> tags, final Multimap<String, String> deviceTag) {
        return deviceTag.entries().stream().filter(entry -> entry.getValue().equals(deviceId))
                .map(entry -> tags.get(entry.getKey())).collect(Collectors.toList());
    }
}

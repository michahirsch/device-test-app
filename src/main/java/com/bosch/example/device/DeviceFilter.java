/**
 * Copyright (c) 2011-2015 Bosch Software Innovations GmbH, Germany. All rights reserved.
 */
package com.bosch.example.device;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bosch.example.device.model.Device;
import com.bosch.example.device.model.DeviceTag;
import com.google.common.collect.Multimap;

/**
 * @author Michael Hirsch
 *
 */
public class DeviceFilter {

    private String like;
    private DeviceTag tag;

    public static DeviceFilter emptyFilter() {
        return new DeviceFilter();
    }

    public DeviceFilter tag(final DeviceTag tag) {
        this.tag = tag;
        return this;
    }

    public DeviceFilter like(final String like) {
        this.like = like;
        return this;
    }

    public List<Device> apply(final List<Device> devices, final Multimap<String, String> deviceTag) {
        List<Device> retDevices = new ArrayList<>(devices);
        if (like != null) {
            retDevices = retDevices.stream().filter(new Predicate<Device>() {
                @Override
                public boolean test(final Device t) {
                    return t.getId().toLowerCase().contains(like.toLowerCase());
                }
            }).collect(Collectors.toList());
        }
        if (tag != null) {
            retDevices.stream().filter(new Predicate<Device>() {
                @Override
                public boolean test(final Device t) {
                    return deviceTag.get(tag.getName()).stream().filter(d -> d.equals(t.getId())).findFirst()
                            .isPresent();
                }
            });
        }
        return retDevices;
    }
}

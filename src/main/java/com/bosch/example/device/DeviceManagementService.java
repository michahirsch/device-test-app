package com.bosch.example.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bosch.example.device.model.Device;
import com.bosch.example.device.model.DeviceTag;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Michael Hirsch
 *
 */
@Service
public class DeviceManagementService {

    private final Map<String, Device> devices = new HashMap<>();
    private final Map<String, DeviceTag> tags = new HashMap<>();
    private final Multimap<String, String> deviceTag = ArrayListMultimap.create();

    /**
     * Adds a device.
     * 
     * @param device
     *            the device to add.
     */
    public void addDevice(final Device device) {
        devices.put(device.getId(), device);
    }

    /**
     * Deletes a device
     * 
     * @param id
     *            the ID of the device to delete
     */
    public void deleteDevice(final String id) {
        devices.remove(id);
    }

    /**
     * Returns a device based on the given ID.
     * 
     * @param id
     *            the ID of the device to retrieve
     * @return the device by the given ID or {@code null} in case no device
     *         exists for the ID
     */
    public Device getDevice(final String id) {
        return devices.get(id);
    }

    /**
     * Returns a list of devices based on the given filter. An
     * {@link DeviceFilter#emptyFilter()} will return all devices.
     * 
     * @param filter
     *            the filter to apply on the list of the devices to return,
     *            never {@code null}
     * @return a list of devices never {@code null}
     */
    public List<Device> getDevices(final DeviceFilter filter) {
        return filter.apply(devices.values().parallelStream().collect(Collectors.toList()), deviceTag);
    }

    /**
     * Adds a tag.
     * 
     * @param tag
     *            the tag to add
     */
    public void addTag(final DeviceTag tag) {
        tags.put(tag.getName(), tag);
    }

    /**
     * Deletes a tag.
     * 
     * @param tagName
     *            the name of the tag to delete
     */
    public void deleteTag(final String tagName) {
        tags.remove(tagName);
    }

    /**
     * Returns a list of devicetags based on the given filter. An
     * {@link DeviceTagFilter#emptyFilter()} will return all devicetags.
     * 
     * @param filter
     *            the filter to apply on the list of the devicetags to return,
     *            never {@code null}
     * @return a list of devicetags never {@code null}
     */
    public List<DeviceTag> getTags(final DeviceTagFilter filter) {
        return filter.apply(tags, deviceTag);
    }

    /**
     * Assigns a tag to a device.
     * 
     * @param tagName
     *            the name of the tag to assign to the device
     * @param deviceId
     *            the ID of the device to assign to the tag
     */
    public void assignTag(final String tagName, final String deviceId) {
        deviceTag.put(tagName, deviceId);
    }

    /**
     * Un-assigns a tag to a device.
     * 
     * @param tagName
     *            the name of the tag to un-assign to the device
     * @param deviceId
     *            the Id of the device to un-assign to the tag
     */
    public void unassignTag(final String tagName, final String deviceId) {
        deviceTag.remove(tagName, deviceId);
    }
}

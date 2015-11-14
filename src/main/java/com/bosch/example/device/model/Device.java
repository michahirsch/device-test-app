package com.bosch.example.device.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hirsch
 *
 */
public class Device {
    private final String id;
    private final long createdAt;
    private Map<String, String> metadata = new HashMap<>();

    /**
     * @param id
     *            the ID of the Device
     * @param createdAt
     *            the time when the device has been created
     * @param metadata
     *            meta data information e.g. hardware revision number etc.
     */
    public Device(final String id, final long createdAt, final Map<String, String> metadata) {
        this.id = id;
        this.createdAt = createdAt;
        this.metadata = metadata;
    }

    /**
     * Returns a builder to build a {@link Device}.
     * 
     * @return a new {@link DeviceBuilder}
     */
    public static DeviceBuilder builder() {
        return new DeviceBuilder();
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            the metadata to set
     */
    public void setMetadata(final Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @author Michael Hirsch
     *
     */
    public static class DeviceBuilder {
        private String id;
        private long createdAt;
        private final Map<String, String> metadata = new HashMap<>();

        /**
         * Builds the device.
         * 
         * @return the device
         */
        public Device build() {
            return new Device(id, createdAt, metadata);
        }

        /**
         * Sets the ID of the device to the builder.
         * 
         * @param id
         *            the ID of the device
         * @return the builder itself
         */
        public DeviceBuilder id(final String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the createdAt timestamp to this builder.
         * 
         * @param timestamp
         *            the timestamp of the createdAt
         * @return the builder itself
         */
        public DeviceBuilder createdAt(final long timestamp) {
            this.createdAt = timestamp;
            return this;
        }

        /**
         * Adds metadata.
         * 
         * @param metadata
         *            the metdata to add
         * @return the builder itself
         */
        public DeviceBuilder metadata(final Map<String, String> metadata) {
            metadata.putAll(metadata);
            return this;
        }

        /**
         * Adds a single key value pair to the metadata.
         * 
         * @param key
         *            the key of the metadata
         * @param value
         *            the value of the metadata
         * @return the builder itself
         */
        public DeviceBuilder metadata(final String key, final String value) {
            metadata.put(key, value);
            return this;
        }
    }
}
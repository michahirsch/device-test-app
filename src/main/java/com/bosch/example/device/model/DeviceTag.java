/**
 * Copyright (c) 2011-2015 Bosch Software Innovations GmbH, Germany. All rights reserved.
 */
package com.bosch.example.device.model;

/**
 * @author Michael Hirsch
 *
 */
public class DeviceTag {

    private final String name;
    private final String description;
    private final Color color;

    /**
     * @param name
     *            the name of the tag.
     * @param description
     *            the description of the tag
     */
    public DeviceTag(final String name, final String description, final Color color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**
     * Returns a new builder to build a {@link DeviceTag}.
     * 
     * @return a new {@link TagBuilder}
     */
    public static TagBuilder builder() {
        return new TagBuilder();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeviceTag [name=" + name + "]";
    }

    public static class TagBuilder {
        private String name;
        private String description;
        private Color color;

        /**
         * Builds the {@link DeviceTag}.
         * 
         * @return the built {@link DeviceTag}
         */
        public DeviceTag build() {
            return new DeviceTag(name, description, color);
        }

        /**
         * Sets the name of the tag to this builder.
         * 
         * @param name
         *            the name of the tag
         * @return the builder itself
         */
        public TagBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the description of the tag to this builder.
         * 
         * @param description
         *            the description of the tag
         * @return the builder itself
         */
        public TagBuilder description(final String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the color of the tag to this builder.
         * 
         * @param r
         *            the red value 0-255
         * @param g
         *            the green value 0-255
         * @param b
         *            the blue value 0-255
         * @return the builder itself
         */
        public TagBuilder color(final int r, final int g, final int b) {
            this.color = new Color(r, g, b);
            return this;
        }
    }

    /**
     * 
     * @author Michael Hirsch
     *
     */
    public static class Color {
        private final int r;
        private final int g;
        private final int b;

        /**
         * @param r
         *            the red value between 0-255
         * @param g
         *            the green value between 0-255
         * @param b
         *            the blue value between 0-255
         */
        public Color(final int r, final int g, final int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}

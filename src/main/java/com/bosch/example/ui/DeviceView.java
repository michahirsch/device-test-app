package com.bosch.example.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.device.DeviceFilter;
import com.bosch.example.device.DeviceManagementService;
import com.bosch.example.device.DeviceTagFilter;
import com.bosch.example.device.model.Device;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Michael Hirsch
 *
 */
@SpringView(name = "")
public class DeviceView extends VerticalLayout implements View {

    private static final long serialVersionUID = 1L;

    @Autowired
    private DeviceManagementService deviceManagement;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener
     * .ViewChangeEvent)
     */
    @Override
    public void enter(final ViewChangeEvent event) {
        final List<Device> devices = deviceManagement.getDevices(DeviceFilter.emptyFilter());
        // TODO: do it better ;)
        devices.forEach(device -> {
            addDeviceDetails(device);
        });
    }

    private void addDeviceDetails(final Device device) {
        final Label deviceLbl = new Label(device + "  --- "
                + deviceManagement.getTags(DeviceTagFilter.emptyFilter().device(device.getId())));
        deviceLbl.addStyleName("test-Label");
        addComponent(deviceLbl);
    }
}

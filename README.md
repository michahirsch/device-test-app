# The simplest device management app

This is a really easy and simple device management application.
All devices gets randomly created at startup and are hold in-memory.

Devices can be assigned to tags. Tags are a way to group devices together and find devices again by these tags. 
All functionality of adding, deleting and listing devices and tags and assign and un-assign tags is provided by the _DeviceManagementService_ bean.

# How to start the application
1. Checkout the GIT project
2. Import it into your IDE workspace (eclipse configure as maven-project)
3. Start the main method of the _com.bosch.example.DemoAppApplication_
4. Open the browser and go to _http://localhost:8080_

# The simple UI
The UI is really easy and simple as well. It just shows all device IDs in a list of labels with the assigned tags. This design and especially the UX must be improved.
![alt text](/src/images/device-ui.png?raw=true "Device UI")

## There is definitely something to improve.
The simple UI only list the devices and their assigned tags in a very simple way. 
The UI does not offer any possibility to manage devices and tags. 
There is no way of creating or deleting new devices or tags as well as no way to assign and un-assign tags to devices. 
There is also no search text field to search for a specific device or tags.

**Improvements**

* Nicer representation of devices and tags
* Support creation of devices and tags
* Support deletion of devices and tags
* Support assign and un-assign tags from devices
* Support searching for devices by a text-field using the _DeviceFilter#like(String like)_

In the _DeviceView_ class you'll the the right place to improve the UI.
```java
@Override
public void enter(final ViewChangeEvent event) {
    final List<Device> devices = deviceManagement.getDevices(DeviceFilter.emptyFilter());
    // TODO: do it better ;)
    devices.forEach(device -> {
        addComponent(new Label(device + "  --- "
                + deviceManagement.getTags(DeviceTagFilter.emptyFilter().device(device.getId()))));
    });
}
```
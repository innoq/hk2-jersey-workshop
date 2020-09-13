package com.innoq.hk2_extras.config;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.configuration.api.ConfigurationUtilities;
import org.glassfish.hk2.configuration.persistence.properties.PropertyFileBean;
import org.glassfish.hk2.configuration.persistence.properties.PropertyFileHandle;
import org.glassfish.hk2.configuration.persistence.properties.PropertyFileService;
import org.glassfish.hk2.configuration.persistence.properties.PropertyFileUtilities;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigurationMain {
    public static void main(String[] args) throws IOException {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("config");
        // hk2-configuration-integration
        ConfigurationUtilities.enableConfigurationSystem(locator);

        // hk2-propertyfile
        PropertyFileUtilities.enablePropertyFileService(locator);
        PropertyFileBean props = new PropertyFileBean();
        props.addTypeMapping("MyBean", MyBean.class);
        locator.getService(PropertyFileService.class).addPropertyFileBean(props);

        ServiceLocatorUtilities.addClasses(locator, MyServiceImpl.class);

        URL configUrl = ConfigurationMain.class.getClassLoader().getResource("config.properties");
        Properties p = new Properties();
        try (InputStream i = configUrl.openStream()) {
            p.load(i);
        }
        PropertyFileHandle hnd = locator.getService(PropertyFileService.class).createPropertyHandleOfAnyType();
        hnd.readProperties(p);

        MyService myService = locator.getService(MyService.class);
        System.out.println(myService.whoAreYou());
    }
}

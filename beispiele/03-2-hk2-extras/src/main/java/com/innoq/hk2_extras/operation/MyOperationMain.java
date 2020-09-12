package com.innoq.hk2_extras.operation;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.extras.ExtrasUtilities;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class MyOperationMain {
    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("operation");
        ServiceLocatorUtilities.addClasses(locator, MyOperationContext.class, MyOperationUser.class, MyOperationBean.class);
        ExtrasUtilities.enableOperations(locator);

        MyOperationUser user = locator.getService(MyOperationUser.class);

        System.err.println("Mit Operation");
        user.mitOperation();
        System.err.println("Ohne Operation");
        user.ohneOperation();
    }
}

package com.innoq.hk2_extras.operation;

import org.glassfish.hk2.extras.operation.OperationHandle;
import org.glassfish.hk2.extras.operation.OperationManager;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class MyOperationUser {
    private final OperationManager opManager;
    private final MyOperationBean bean;

    @Inject
    public MyOperationUser(OperationManager opManager, MyOperationBean bean) {
        this.opManager = opManager;
        this.bean = bean;
    }

    public void mitOperation() {
        OperationHandle<MyOperationScope> currentOp = opManager.createAndStartOperation(MyOperationScopeLiteral.INSTANCE);
        try {
            System.err.println(bean.toString());
        } finally {
            currentOp.closeOperation();
        }
    }

    public void ohneOperation() {
        System.out.println(bean.toString());
    }

}

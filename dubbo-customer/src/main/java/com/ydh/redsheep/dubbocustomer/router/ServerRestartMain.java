package com.ydh.redsheep.dubbocustomer.router;

import com.ydh.redsheep.self_router.router.ReadyRestartInstances;

public class ServerRestartMain {
    public static void main(String[] args) throws  Exception {
        ReadyRestartInstances.create().addRestartingInstance("dubbo-provider","192.168.120.22", 20880);
//        ReadyRestartInstances.create().removeRestartingInstance("dubbo-provider","192.168.120.22", 20880);
    }
}

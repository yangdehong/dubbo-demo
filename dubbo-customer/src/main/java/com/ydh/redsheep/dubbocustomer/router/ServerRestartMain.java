package com.ydh.redsheep.dubbocustomer.router;

import com.ydh.redsheep.self_router.router.ReadyRestartInstances;

public class ServerRestartMain {
    public static void main(String[] args) throws  Exception {
        ReadyRestartInstances.create().addRestartingInstance("service-provider","192.168.20.1");
//        ReadyRestartInstances.create().removeRestartingInstance("service-provider","192.168.20.1");
    }
}

/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.devicerole;

import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;

class DeviceRoleManagerEvo$1
implements Runnable {
    private final /* synthetic */ DeviceRoleInfo val$primaryDeviceInfo;
    private final /* synthetic */ DeviceRoleManagerEvo this$0;

    DeviceRoleManagerEvo$1(DeviceRoleManagerEvo deviceRoleManagerEvo, DeviceRoleInfo deviceRoleInfo) {
        this.this$0 = deviceRoleManagerEvo;
        this.val$primaryDeviceInfo = deviceRoleInfo;
    }

    @Override
    public void run() {
        DeviceRoleManagerEvo.access$102(this.this$0, this.val$primaryDeviceInfo);
        DeviceRoleManagerEvo.access$200(this.this$0);
    }
}


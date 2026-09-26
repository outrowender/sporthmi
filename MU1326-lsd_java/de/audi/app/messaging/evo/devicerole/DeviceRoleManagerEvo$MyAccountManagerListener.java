/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.devicerole;

import de.audi.app.messaging.core.accounts.IAccountManagerListener$DefaultAccountManagerListener;
import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo;
import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo$1;

class DeviceRoleManagerEvo$MyAccountManagerListener
extends IAccountManagerListener$DefaultAccountManagerListener {
    private final /* synthetic */ DeviceRoleManagerEvo this$0;

    private DeviceRoleManagerEvo$MyAccountManagerListener(DeviceRoleManagerEvo deviceRoleManagerEvo) {
        this.this$0 = deviceRoleManagerEvo;
    }

    @Override
    public void selectedAccountChanged() {
        DeviceRoleManagerEvo.access$200(this.this$0);
    }

    /* synthetic */ DeviceRoleManagerEvo$MyAccountManagerListener(DeviceRoleManagerEvo deviceRoleManagerEvo, DeviceRoleManagerEvo$1 deviceRoleManagerEvo$1) {
        this(deviceRoleManagerEvo);
    }
}


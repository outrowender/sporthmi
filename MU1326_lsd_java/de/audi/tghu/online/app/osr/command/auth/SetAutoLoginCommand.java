/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class SetAutoLoginCommand
extends AbstractOSRCommand {
    private OSRUser user;
    private SetAutoLoginCommandResponseListener listener;
    private OSRDevice[] devices;

    public SetAutoLoginCommand(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, SetAutoLoginCommandResponseListener setAutoLoginCommandResponseListener) {
        this.user = oSRUser;
        this.devices = oSRDeviceArray;
        this.listener = setAutoLoginCommandResponseListener;
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.user == null) {
            this.logger.log(10000, "SetAutoLoginCommand#execute() no user to log in... do nothing");
            return;
        }
        if (this.devices == null || this.devices.length == 0) {
            this.logger.log(10000, "SetAutoLoginCommand#execute()no devices to connect with autoLogin ... do nothing");
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "SetAutoLoginCommand#execute() no dsi");
            return;
        }
        this.logger.log(1000000, "SetAutoLoginCommand#execute() for user " + this.user.getName() + " deviceCount: " + this.devices.length);
        dSIOnlineServiceRegistration.setAutoLogin(this.user, this.devices);
    }

    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        if (this.listener != null) {
            this.listener.setAutoLoginResponse(oSRUser, nArray);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface SetAutoLoginCommandResponseListener {
        public void setAutoLoginResponse(OSRUser var1, int[] var2);
    }
}


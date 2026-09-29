/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.IRemoteHMIConnectedDevices;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.ArrayUtilities;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$3
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$3(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Object object2;
        this.this$0.logChannel.log(-2137614336, "RemoteHMIService#indicateCommand (STATE_UPDATE_SERVICE_DISCOVERY_DEVICES)");
        String[] stringArray = new String[]{};
        String[] stringArray2 = new String[]{};
        boolean[] blArray = new boolean[]{};
        if (object != null && !(object instanceof IRemoteHMIConnectedDevices)) {
            this.this$0.logChannel.log(-1601830656, "RemoteHMIService#indicateCommand (STATE_UPDATE_SERVICE_DISCOVERY_DEVICES): error in payload for updating connected devices");
            return;
        }
        if (object instanceof IRemoteHMIConnectedDevices) {
            object2 = (IRemoteHMIConnectedDevices)object;
            stringArray = object2.getConnectedDevices();
            stringArray2 = object2.getMACAddresses();
            blArray = object2.getActivationStates();
            if (stringArray == null || stringArray2 == null || blArray == null) {
                this.this$0.logChannel.log(-1601830656, "RemoteHMIService#indicateCommand (STATE_UPDATE_SERVICE_DISCOVERY_DEVICES): error in connected device info, not sending update");
                return;
            }
        }
        this.this$0.getOnlineServiceProvider().updateDeviceAppInfo(stringArray);
        if (this.this$0.connectivityStateListener == null) {
            this.this$0.logChannel.log(-1601830656, "RemoteHMIService#indicateCommand (STATE_UPDATE_SERVICE_DISCOVERY_DEVICES): connectivityStateListener is null");
            return;
        }
        this.this$0.logChannel.log(1078071040, "RemoteHMIHandlerImpl#indicateCommand (STATE_UPDATE_SERVICE_DISCOVERY_DEVICES) sending update");
        this.this$0.connectivityStateListener.updateRHMIServerList(stringArray, stringArray2, blArray);
        object2 = "";
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (!blArray[i2]) continue;
            object2 = ArrayUtilities.getSafeArrayValue(stringArray, i2);
            break;
        }
        this.this$0.getDiagnosisComponent().update(object2, 4);
    }
}


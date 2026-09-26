/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.GList;

class DeviceManager$SMIControllerListener$7
implements Predicate {
    private final /* synthetic */ String val$deviceAddress;
    private final /* synthetic */ GList val$types;
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$7(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener, String string, GList gList) {
        this.this$1 = deviceManager$SMIControllerListener;
        this.val$deviceAddress = string;
        this.val$types = gList;
    }

    public boolean apply(TMDeviceID tMDeviceID) {
        return tMDeviceID.address.equals(this.val$deviceAddress) && this.val$types.contains((Object)tMDeviceID.smartphoneType);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDeviceID)object);
    }
}


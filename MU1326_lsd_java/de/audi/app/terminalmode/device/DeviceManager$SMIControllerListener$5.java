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

class DeviceManager$SMIControllerListener$5
implements Predicate {
    private final /* synthetic */ GList val$connectedIds;
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$5(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener, GList gList) {
        this.this$1 = deviceManager$SMIControllerListener;
        this.val$connectedIds = gList;
    }

    public boolean apply(TMDeviceID tMDeviceID) {
        return !this.val$connectedIds.contains((Object)tMDeviceID);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDeviceID)object);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.smartphoneintegration.Device;

class SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ Device[] val$devices;
    private final /* synthetic */ SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener this$1;

    SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener$1(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener, String string, Device[] deviceArray) {
        this.this$1 = smartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
        this.val$devices = deviceArray;
        super(string);
    }

    @Override
    public void run() {
        GList gList = Generics.newArrayList((Object[])this.val$devices);
        SmartphoneIntegrationDSILifecycleController.access$1500(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).log(1078071040, "<- [%1.updateDiscoveredDevices] %2", (Object)"SmartphoneIntegrationDSIListener", (Object)gList.toString());
        SmartphoneIntegrationDSILifecycleController.access$700(SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener.access$1400(this.this$1)).updateDiscoveredDevices(gList);
    }
}


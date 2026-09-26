/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent;
import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent$DCElementSelectionEntry;
import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent$DisplayConfigurationArrayHandler;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;

public class AbstractDisplayConfigurationComponent$DisplayConfigurationController {
    private final Object mutex = new Object();
    protected final AbstractDisplayConfigurationComponent$DisplayConfigurationArrayHandler arrayHandler = new AbstractDisplayConfigurationComponent$DisplayConfigurationArrayHandler(this.this$0);
    private final /* synthetic */ AbstractDisplayConfigurationComponent this$0;

    protected AbstractDisplayConfigurationComponent$DisplayConfigurationController(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        this.this$0 = abstractDisplayConfigurationComponent;
    }

    public AbstractDisplayConfigurationComponent$DCElementSelectionEntry getDCElementSelectionFromArray(int n, int n2) {
        AbstractDisplayConfigurationComponent$DCElementSelectionEntry abstractDisplayConfigurationComponent$DCElementSelectionEntry = null;
        DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = this.arrayHandler.getCurrentArray();
        if (null != dCElementContentSelectionListRA1Array) {
            for (int i2 = 0; i2 < dCElementContentSelectionListRA1Array.length; ++i2) {
                if (null == dCElementContentSelectionListRA1Array[i2] || dCElementContentSelectionListRA1Array[i2].getDisplay() != n || dCElementContentSelectionListRA1Array[i2].getElement() != n2) continue;
                abstractDisplayConfigurationComponent$DCElementSelectionEntry = new AbstractDisplayConfigurationComponent$DCElementSelectionEntry("", n, dCElementContentSelectionListRA1Array[i2].getElementContent());
                abstractDisplayConfigurationComponent$DCElementSelectionEntry.setAvailable(true);
                abstractDisplayConfigurationComponent$DCElementSelectionEntry.setSelection(true);
                break;
            }
        }
        return abstractDisplayConfigurationComponent$DCElementSelectionEntry;
    }

    public void dsiSetDisplayConfiguration(int n, AbstractDisplayConfigurationComponent$DCElementSelectionEntry[] abstractDisplayConfigurationComponent$DCElementSelectionEntryArray) {
        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = new DCElementContentSelectionListUpdateInfo();
        dCElementContentSelectionListUpdateInfo.asgID = 1;
        dCElementContentSelectionListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
        dCElementContentSelectionListUpdateInfo.recordContent = 1;
        dCElementContentSelectionListUpdateInfo.arrayContent = 1;
        dCElementContentSelectionListUpdateInfo.startElement = 0;
        dCElementContentSelectionListUpdateInfo.numOfElements = abstractDisplayConfigurationComponent$DCElementSelectionEntryArray.length;
        DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = new DCElementContentSelectionListRA1[abstractDisplayConfigurationComponent$DCElementSelectionEntryArray.length];
        for (int i2 = 0; i2 < abstractDisplayConfigurationComponent$DCElementSelectionEntryArray.length; ++i2) {
            dCElementContentSelectionListRA1Array[i2] = new DCElementContentSelectionListRA1();
            dCElementContentSelectionListRA1Array[i2].pos = i2;
            dCElementContentSelectionListRA1Array[i2].display = n;
            dCElementContentSelectionListRA1Array[i2].additionalInfo = 1;
            dCElementContentSelectionListRA1Array[i2].element = i2 + 1;
            dCElementContentSelectionListRA1Array[i2].elementContent = abstractDisplayConfigurationComponent$DCElementSelectionEntryArray[i2].getContentNameID();
        }
        this.arrayHandler.sendSetGetArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
    }

    public void dsiSetDisplayMainSelection(int n, DCMainItems dCMainItems) {
        switch (n) {
            case 1: {
                this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setDCDisplay1MainSelection(%1)", (Object)dCMainItems);
                this.this$0.getDSI().setDCDisplay1MainSelection(dCMainItems);
                break;
            }
            case 2: {
                this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setDCDisplay2MainSelection(%1)", (Object)dCMainItems);
                this.this$0.getDSI().setDCDisplay2MainSelection(dCMainItems);
                break;
            }
            case 3: {
                this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setDCDisplay3MainSelection(%1)", (Object)dCMainItems);
                this.this$0.getDSI().setDCDisplay3MainSelection(dCMainItems);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(10000, "[AbstractDisplayConfigurationComponent#dsiSetDisplayMainSelection] dsiDisplayID='%1' not supported.", (long)n);
            }
        }
    }

    public void dsiSetBrightness(int n) {
        this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setDCBrightness(%1)", (long)n);
        this.this$0.getDSI().setDCBrightness(n);
    }

    public void dsiSetVolume(int n) {
        this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setDCVolume(%1)", (long)n);
        this.this$0.getDSI().setDCVolume(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTotalNumberOfElements(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#updateTotalNumberOfElements] called.");
            }
            this.arrayHandler.setTotalNumberOfElements(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#responseDCElementContentSelectionList] called.");
            }
            this.arrayHandler.receivedStatusArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#responseDCElementContentSelectionList] called.");
            }
            this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#responseDCElementContentSelectionList] Not implemented yet.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#updateDCElementContentSelectionListUpdateInfo] called.");
            }
            this.arrayHandler.receivedChangedArray(dCElementContentSelectionListUpdateInfo, nArray);
        }
    }
}


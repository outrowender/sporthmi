/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.AbstractComfortInterappControlComponent;
import de.audi.atip.interapp.navcar.ILGIServiceListener;
import org.dsi.ifc.tmc.LocalHazardInformation;

class AbstractComfortInterappControlComponent$1
implements ILGIServiceListener {
    private final /* synthetic */ AbstractComfortInterappControlComponent this$0;

    AbstractComfortInterappControlComponent$1(AbstractComfortInterappControlComponent abstractComfortInterappControlComponent) {
        this.this$0 = abstractComfortInterappControlComponent;
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] called.");
        if (null == localHazardInformationArray) {
            this.this$0.getLogChannel().log(10000, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] Invalid parameter set.");
            return;
        }
        if (null == AbstractComfortInterappControlComponent.access$000(this.this$0)) {
            this.this$0.getLogChannel().log(10000, "[AbstractComfortInterappControlComponent.ILGIServiceListener#updateLocalHazardInformation] Dispatcher not yet initialized.");
            return;
        }
        LocalHazardInformation[] localHazardInformationArray2 = AbstractComfortInterappControlComponent.access$100(this.this$0, localHazardInformationArray);
        if (0 == localHazardInformationArray2.length) {
            AbstractComfortInterappControlComponent.access$000(this.this$0).updateRGSLocalHazardInformation(AbstractComfortInterappControlComponent.access$200(this.this$0));
            return;
        }
        AbstractComfortInterappControlComponent.access$000(this.this$0).updateRGSLocalHazardInformation(AbstractComfortInterappControlComponent.access$300(this.this$0, localHazardInformationArray2));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class HomeAddressHandler$4
implements Runnable {
    private final /* synthetic */ NavLocation val$homeAddress;
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$4(HomeAddressHandler homeAddressHandler, NavLocation navLocation) {
        this.this$0 = homeAddressHandler;
        this.val$homeAddress = navLocation;
    }

    @Override
    public void run() {
        this.this$0.logger.log(-2137614336, "HomeAddressHandler#setPersistetHomeAddress() - homeAddress: %1", (Object)LocationFormatter.formatLocationShort(this.val$homeAddress));
        byte[] byArray = this.val$homeAddress != null ? HomeAddressHandler.access$200(this.this$0).locationToStream(this.val$homeAddress) : new byte[]{};
        HomeAddressHandler.access$000(this.this$0).savePersistentState(byArray);
    }
}


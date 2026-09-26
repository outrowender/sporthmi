/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.remotehmi.util.DeepCloneable;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon;
import org.dsi.ifc.global.NavLocationWgs84;

public class ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi
implements DeepCloneable {
    public NavLocationWgs84 navLocation;
    public String url;
    public String zip;
    public String city;
    public String street;
    public String phone;
    public String name;
    private final /* synthetic */ ConciergeCallModelHandlerPorscheCommon this$0;

    public ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi(ConciergeCallModelHandlerPorscheCommon conciergeCallModelHandlerPorscheCommon) {
        this.this$0 = conciergeCallModelHandlerPorscheCommon;
    }

    public String toString() {
        return new StringBuffer().append("ConciergeResultPoi [navLocation=").append(this.navLocation).append(", url=").append(this.url).append(", zip=").append(this.zip).append(", city=").append(this.city).append(", street=").append(this.street).append(", phone=").append(this.phone).append(", name=").append(this.name).append("]").toString();
    }

    @Override
    public Object clone(boolean bl) {
        ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi = new ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi(this.this$0);
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name = this.name;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.phone = this.phone;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.street = this.street;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.city = this.city;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.zip = this.zip;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.url = this.url;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.navLocation = new NavLocationWgs84(this.navLocation.longitude, this.navLocation.latitude);
        return conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi;
    }
}


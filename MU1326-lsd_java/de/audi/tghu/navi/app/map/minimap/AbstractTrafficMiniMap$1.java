/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.base.DSIBase;

class AbstractTrafficMiniMap$1
implements IDSIClient {
    private final /* synthetic */ AbstractTrafficMiniMap this$0;

    AbstractTrafficMiniMap$1(AbstractTrafficMiniMap abstractTrafficMiniMap) {
        this.this$0 = abstractTrafficMiniMap;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.this$0.logChannel.log(1078071040, "TrafficMiniMap#getDSIActivator#setDSI dsi = (%1)", (Object)dSIBase);
        AbstractTrafficMiniMap.access$002(this.this$0, (DSIAsiaTrafficInfoMenu)dSIBase);
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{1, 2};
    }
}


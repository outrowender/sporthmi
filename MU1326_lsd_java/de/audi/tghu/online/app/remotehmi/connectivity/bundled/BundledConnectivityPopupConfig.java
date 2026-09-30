/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.connectivity.bundled;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.IBundledConnectivityPopupConfig;
import java.util.HashMap;
import java.util.Map;

public class BundledConnectivityPopupConfig
implements IBundledConnectivityPopupConfig {
    private LogChannel logChannel;
    private Map popupIds = new HashMap();
    private Map conditionModelIds = new HashMap();
    private int buyNewDataPlanButtonModelId = -1;
    private int showDashboardButtonModelId = -1;

    public BundledConnectivityPopupConfig(LogChannel logChannel, int n, int n2) {
        this.logChannel = logChannel;
        this.buyNewDataPlanButtonModelId = n;
        this.showDashboardButtonModelId = n2;
    }

    public void registerPopupIdToType(int n, int n2) {
        this.registerElementIdToType(this.popupIds, n, n2);
    }

    private void registerElementIdToType(Map map, int n, int n2) {
        Object object = map.put(new Integer(n), new Integer(n2));
        if (object != null) {
            this.logChannel.log(100000, "BundledConnectivityPopupConfig#registerPopupIdToType replaced popup ID %1 with popup ID %2 for popup type %3", object, (Object)new Integer(n2), (Object)new Integer(n));
        }
    }

    public int getPopupId(int n) {
        return this.getElementId(this.popupIds, n, -1);
    }

    public int getElementId(Map map, int n, int n2) {
        Object object = map.get(new Integer(n));
        int n3 = n2;
        if (object instanceof Integer) {
            n3 = (Integer)object;
        }
        return n3;
    }

    public void registerConditionModelIdToPopupType(int n, int n2) {
        this.registerElementIdToType(this.conditionModelIds, n, n2);
    }

    public int getConditionModelId(int n) {
        return this.getElementId(this.conditionModelIds, n, -1);
    }

    public int getBuyNewDataPlanButtonModelId() {
        return this.buyNewDataPlanButtonModelId;
    }

    public int getShowDashboardButtonModelId() {
        return this.showDashboardButtonModelId;
    }
}


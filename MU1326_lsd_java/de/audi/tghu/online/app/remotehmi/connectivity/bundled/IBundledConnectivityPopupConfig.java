/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.connectivity.bundled;

public interface IBundledConnectivityPopupConfig {
    public static final int POPUP_ID_DEFAULT = -1;
    public static final int MODEL_ID_DEFAULT = -1;

    public void registerPopupIdToType(int var1, int var2);

    public int getPopupId(int var1);

    public void registerConditionModelIdToPopupType(int var1, int var2);

    public int getConditionModelId(int var1);

    public int getBuyNewDataPlanButtonModelId();

    public int getShowDashboardButtonModelId();
}


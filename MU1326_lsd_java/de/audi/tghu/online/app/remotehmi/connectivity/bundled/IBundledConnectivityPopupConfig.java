/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.connectivity.bundled;

public interface IBundledConnectivityPopupConfig {
    public static final int POPUP_ID_DEFAULT;
    public static final int MODEL_ID_DEFAULT;

    default public void registerPopupIdToType(int n, int n2) {
    }

    default public int getPopupId(int n) {
    }

    default public void registerConditionModelIdToPopupType(int n, int n2) {
    }

    default public int getConditionModelId(int n) {
    }

    default public int getBuyNewDataPlanButtonModelId() {
    }

    default public int getShowDashboardButtonModelId() {
    }
}


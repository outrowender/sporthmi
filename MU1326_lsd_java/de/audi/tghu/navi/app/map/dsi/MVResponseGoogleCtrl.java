/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.dsi.MVResponseControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public final class MVResponseGoogleCtrl
extends MVResponseControl
implements DSIMapViewerGoogleCtrlListener {
    private String[] mAvailableLanguages = null;
    private LayerProperty[] mAvailableLayers = null;
    private String mCurrentLanguage = "";
    private boolean[] mLoadKmls = null;
    private int mGoogleDataStatus = -1;
    private int[] mVisibleLayers = null;

    public MVResponseGoogleCtrl(int n, LogChannel logChannel) {
        super(n, logChannel);
    }

    @Override
    public String getName() {
        return "MVResponseGoogleCtrl";
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateAvailableLanguages(): availableLanguages[0] = %1", (Object)stringArray[0]);
            this.mAvailableLanguages = stringArray;
            this.naviMap.getActiveContext().updateAvailableLanguages(stringArray);
        }
    }

    public String[] getAvailableLanguages() {
        return this.mAvailableLanguages;
    }

    @Override
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateAvailableLayers() - length: %1", layerPropertyArray == null ? 0L : (long)layerPropertyArray.length);
            this.mAvailableLayers = layerPropertyArray;
            this.naviMap.getActiveContext().updateAvailableLayers(layerPropertyArray);
        }
    }

    public LayerProperty[] getAvailableLayers() {
        return this.mAvailableLayers;
    }

    @Override
    public void updateCurrentLanguage(String string, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateCurrentLanguage(): currentLanguage = %1", (Object)string);
            this.mCurrentLanguage = string;
            this.naviMap.getActiveContext().updateCurrentLanguage(string);
        }
    }

    public String getCurrentLanguage() {
        return this.mCurrentLanguage;
    }

    public void updateLoadKml(boolean[] blArray, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateLoadKml(): loadKml = %1", (Object)blArray);
            this.mLoadKmls = blArray;
            this.naviMap.getActiveContext().updateLoadKml(blArray);
        }
    }

    public boolean[] getLoadKmls() {
        return this.mLoadKmls;
    }

    @Override
    public void updateGoogleDataStatus(int n, int n2) {
        if (n2 == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateGoogleDataStatus(): googleDataStatus = %1", (long)n);
            this.mGoogleDataStatus = n;
            this.naviMap.getActiveContext().updateGoogleDataStatus(n);
            if (this.listener != null) {
                this.listener.updateGoogleDataStatus(n);
            }
        }
    }

    public int getGoogleDataStatus() {
        return this.mGoogleDataStatus;
    }

    @Override
    public void updateVisibleLayers(int[] nArray, int n) {
        if (n == 1) {
            this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#updateVisibleLayers( %1 )", (Object)nArray);
            this.mVisibleLayers = nArray;
            this.naviMap.getActiveContext().updateVisibleLayers(nArray);
        }
    }

    public int[] getVisibleLayers() {
        return this.mVisibleLayers;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogger().log(10000, "MVResponseGoogleCtrl#asyncException(): code = %2, msg = %1, type = %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void resetMemberVariables() {
        super.resetMemberVariables();
        this.getLogger().log(-2137614336, "MVResponseGoogleCtrl#resetMemberVariables() ");
        this.mAvailableLanguages = null;
        this.mAvailableLayers = null;
        this.mCurrentLanguage = "";
        this.mLoadKmls = null;
        this.mGoogleDataStatus = -1;
        this.mVisibleLayers = null;
    }

    @Override
    public void updateCopyrightPosition(Rect rect, int n, int n2, int n3) {
    }
}


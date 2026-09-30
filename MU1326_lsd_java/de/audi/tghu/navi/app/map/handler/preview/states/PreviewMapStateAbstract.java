/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import org.dsi.ifc.global.NavLocation;

public abstract class PreviewMapStateAbstract {
    private PreviewMapHandlerAbstract previewMapHandler;
    protected LogChannel logger;
    protected GuiModelAccessForPreviewMapDetailScreen guiModelAccess;
    protected GuiTooltipInformationContainer guiTooltipInformationContainer;
    private int previewMapClientId = -1;

    protected PreviewMapStateAbstract(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.previewMapHandler = previewMapHandlerAbstract;
        this.logger = previewMapHandlerAbstract.getLogChannel();
        this.guiModelAccess = guiModelAccessForPreviewMapDetailScreen;
        if (guiModelAccessForPreviewMapDetailScreen == null) {
            this.guiModelAccess = previewMapHandlerAbstract.getGuiModelAccessForPreviewMapDetailScreenDefault();
        }
        this.guiTooltipInformationContainer = guiTooltipInformationContainer;
    }

    protected PreviewMapHandlerAbstract getPreviewMapHandler() {
        return this.previewMapHandler;
    }

    protected AbstractMap getMapForPreview() {
        return this.getPreviewMapHandler().getMapForPreview();
    }

    protected AbstractMap getMapForFullScreen() {
        return this.getPreviewMapHandler().getMapForFullScreen();
    }

    public abstract void applyToScreenDetail();

    public abstract void applyToScreenDetailModels();

    public abstract void applyToScreenFullMap();

    public void releaseApplyToScreenDetail() {
    }

    public void releaseApplyToScreenFullMap() {
    }

    public abstract NavLocation getNavLocationForEnterInMap();

    public void setPreviewMapClientId(int n) {
        this.previewMapClientId = n;
    }

    public int getPreviewMapClientId() {
        return this.previewMapClientId;
    }

    public boolean isRefreshRequiredOnUpdateRgActive() {
        return false;
    }

    public boolean isPreviewMapItemArea() {
        return false;
    }
}


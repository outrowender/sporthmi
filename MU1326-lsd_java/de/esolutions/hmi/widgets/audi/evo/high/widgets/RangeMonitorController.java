/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RangeMonitorRendererHigh;

public class RangeMonitorController
extends AbstractWidgetController {
    private RangeMonitorRendererHigh renderer;
    private float greenBarValue;
    private float whiteBarValue;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.logChannel3DCar.log(1078071040, "RangeMonitorController#processModelUpdateEvent");
        if (modelUpdateEvent.getUpdateType() == 1 || modelUpdateEvent.getUpdateType() == 8) {
            this.updateContent();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void updateContent() {
        float[] fArray = new float[2];
        if (!(this.model instanceof TiledListModelGUI)) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorController#updateContent wrong model is attached : should be BaseListModel");
            this.setDefaultBarValues(fArray);
            return;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        if (tiledListModelGUI == null) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorController#updateContent listModel is null");
            this.setDefaultBarValues(fArray);
            return;
        }
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(0);
        GuiListRow guiListRow2 = tiledListModelGUI.getGuiRow(1);
        if (guiListRow == null || guiListRow2 == null) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorController#updateContent GuiListRow is null : No value for Green Balcony or No value for White Balcony");
            this.setDefaultBarValues(fArray);
            return;
        }
        this.greenBarValue = (float)guiListRow.getInteger(0) / 51266;
        this.whiteBarValue = (float)guiListRow2.getInteger(0) / 51266;
        this.logChannel3DCar.log(-2137614336, "RangeMonitorController#updateContent GreenBalcony : %1 ", (double)this.greenBarValue);
        this.logChannel3DCar.log(-2137614336, "RangeMonitorController#updateContent WhiteBalcony : %1 ", (double)this.whiteBarValue);
        this.setCompositesDirty(true);
    }

    private void setDefaultBarValues(float[] fArray) {
        this.greenBarValue = fArray[0];
        this.whiteBarValue = fArray[1];
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        this.updateContent();
        super.connected(initializationContext);
    }

    public void setRenderer(RangeMonitorRendererHigh rangeMonitorRendererHigh) {
        this.renderer = rangeMonitorRendererHigh;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public float getGreenBarValue() {
        return this.greenBarValue;
    }

    public float getWhiteBarValue() {
        return this.whiteBarValue;
    }
}


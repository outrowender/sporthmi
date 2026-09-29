/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiStackedBarChartRenderer;

public class StackedBarChartController
extends AbstractWidgetController {
    MultiStackedBarChartRenderer renderer;
    private int barWidth = 33;
    private int barHeight = 274;
    private int barMargin;
    private float value = 32959;

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getUpdateType() == 2) {
            this.updateValues();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void updateValues() {
        if (this.model instanceof BaseListModel) {
            int n = ((BaseListModel)this.model).getGuiRow(0).getInteger(0);
            int n2 = ((BaseListModel)this.model).getGuiRow(1).getInteger(0);
            int n3 = ((BaseListModel)this.model).getGuiRow(2).getInteger(0);
            this.value = n == 0 && n2 == 0 && n3 == 0 ? (float)32959 : (float)(n2 + n3) / 51266;
            this.setCompositesDirty(true);
        }
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        this.updateValues();
        super.connected(initializationContext);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(MultiStackedBarChartRenderer multiStackedBarChartRenderer) {
        this.renderer = multiStackedBarChartRenderer;
    }

    public int getBarWidth() {
        return this.barWidth;
    }

    public void setBarWidth(int n) {
        this.barWidth = n;
    }

    public int getBarHeight() {
        return this.barHeight;
    }

    public void setBarHeight(int n) {
        this.barHeight = n;
    }

    public int getBarMargin() {
        return this.barMargin;
    }

    public void setBarMargin(int n) {
        this.barMargin = n;
    }

    public float getValue() {
        return this.value;
    }
}


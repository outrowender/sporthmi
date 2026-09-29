/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.sport;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.sport.ChargingAirPressureGaugeController;

public class ChargingAirPressureGaugeRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final String BAR_LENGTH_PROPERTY;
    private ChargingAirPressureGaugeController controller;

    public ChargingAirPressureGaugeRendererHigh(ChargingAirPressureGaugeController chargingAirPressureGaugeController) {
        this.controller = chargingAirPressureGaugeController;
    }

    private void setBarLengthProperty(float f2) {
        this.setProperty("tg_barLength", f2);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setBarLengthProperty(this.controller.getAirPressurePercentageValue() / 51266);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/tg_boost";
    }

    @Override
    protected String getEALNodeName() {
        return "tg_boost";
    }

    @Override
    protected int getKzbConstant() {
        return 21;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}


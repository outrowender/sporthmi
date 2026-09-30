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
    private static final String TEMPLATE_NODE_PATH = "Prefabs/tg_boost";
    private static final String EAL_NODE_NAME = "tg_boost";
    private static final String BAR_LENGTH_PROPERTY = "tg_barLength";
    private ChargingAirPressureGaugeController controller;

    public ChargingAirPressureGaugeRendererHigh(ChargingAirPressureGaugeController chargingAirPressureGaugeController) {
        this.controller = chargingAirPressureGaugeController;
    }

    private void setBarLengthProperty(float f2) {
        this.setProperty(BAR_LENGTH_PROPERTY, f2);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setBarLengthProperty(this.controller.getAirPressurePercentageValue() / 100.0f);
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbConstant() {
        return 21;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}


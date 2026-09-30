/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.sport;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.sport.OilTemperatureGaugeController;

public class OilTemperatureGaugeRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/tg_temp";
    private static final String EAL_NODE_NAME = "tg_temp";
    private static final float KZB_FAHRENHEIT_UNIT = 0.0f;
    private static final float FAHRENHEIT_MIN_TEMPERATURE = 115.0f;
    private static final float FAHRENHEIT_MAX_TEMPERATURE = 315.0f;
    private static final float KZB_CELSIUS_UNIT = 1.0f;
    private static final float CELSIUS_MIN_TEMPERATURE = 45.0f;
    private static final float CELSIUS_MAX_TEMPERATURE = 165.0f;
    private static final String TEMPERATURE_UNIT_PROPERTY = "eg_bc_degreeUnit";
    private static final String BAR_LENGTH_PROPERTY = "tg_barLength";
    private OilTemperatureGaugeController controller;

    public OilTemperatureGaugeRendererHigh(OilTemperatureGaugeController oilTemperatureGaugeController) {
        this.controller = oilTemperatureGaugeController;
    }

    private void setBarLengthProperty(float f2) {
        this.setProperty(BAR_LENGTH_PROPERTY, f2);
    }

    private void setTemperatureUnitProperty(float f2) {
        this.setProperty(TEMPERATURE_UNIT_PROPERTY, f2);
    }

    private static float computeBarLength(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2;
        float f3;
        float f4;
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        switch (this.controller.getTemperatureUnit()) {
            case 2: {
                f4 = 0.0f;
                f3 = 115.0f;
                f2 = 315.0f;
                break;
            }
            case 1: {
                f4 = 1.0f;
                f3 = 45.0f;
                f2 = 165.0f;
                break;
            }
            default: {
                logChannel.log(100000, "OilTemperatureGaugeRendererHigh#applyProperties: unknown temperature unit: %1", (long)this.controller.getTemperatureUnit());
                return;
            }
        }
        this.setTemperatureUnitProperty(f4);
        float f5 = this.controller.getTemperature();
        if (f5 < f3 || f5 > f2) {
            logChannel.log(100000, "OilTemperatureGaugeRendererHigh#applyProperties: Oil temperature of %1 degrees out of displayable range between %2 and %3", (double)f5, (double)f3, (double)f2);
            f5 = Math.min(Math.max(f5, f3), f2);
        }
        this.setBarLengthProperty(OilTemperatureGaugeRendererHigh.computeBarLength(f3, f2, f5));
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


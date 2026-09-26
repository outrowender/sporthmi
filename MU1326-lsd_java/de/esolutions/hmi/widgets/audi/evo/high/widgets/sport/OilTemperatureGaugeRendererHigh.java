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
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final float KZB_FAHRENHEIT_UNIT;
    private static final float FAHRENHEIT_MIN_TEMPERATURE;
    private static final float FAHRENHEIT_MAX_TEMPERATURE;
    private static final float KZB_CELSIUS_UNIT;
    private static final float CELSIUS_MIN_TEMPERATURE;
    private static final float CELSIUS_MAX_TEMPERATURE;
    private static final String TEMPERATURE_UNIT_PROPERTY;
    private static final String BAR_LENGTH_PROPERTY;
    private OilTemperatureGaugeController controller;

    public OilTemperatureGaugeRendererHigh(OilTemperatureGaugeController oilTemperatureGaugeController) {
        this.controller = oilTemperatureGaugeController;
    }

    private void setBarLengthProperty(float f2) {
        this.setProperty("tg_barLength", f2);
    }

    private void setTemperatureUnitProperty(float f2) {
        this.setProperty("eg_bc_degreeUnit", f2);
    }

    private static float computeBarLength(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2;
        float f2;
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        switch (this.controller.getTemperatureUnit()) {
            case 2: {
                f2 = 0.0f;
                n2 = 58946;
                n = 8428867;
                break;
            }
            case 1: {
                f2 = 1.0f;
                n2 = 13378;
                n = 9539;
                break;
            }
            default: {
                logChannel.log(-1601830656, "OilTemperatureGaugeRendererHigh#applyProperties: unknown temperature unit: %1", (long)this.controller.getTemperatureUnit());
                return;
            }
        }
        this.setTemperatureUnitProperty(f2);
        float f3 = this.controller.getTemperature();
        if (f3 < n2 || f3 > n) {
            logChannel.log(-1601830656, "OilTemperatureGaugeRendererHigh#applyProperties: Oil temperature of %1 degrees out of displayable range between %2 and %3", (double)f3, (double)n2, (double)n);
            f3 = Math.min(Math.max(f3, (float)n2), (float)n);
        }
        this.setBarLengthProperty(OilTemperatureGaugeRendererHigh.computeBarLength(n2, n, f3));
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/tg_temp";
    }

    @Override
    protected String getEALNodeName() {
        return "tg_temp";
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PHEVLoadingController;

public class PHEVLoadingRedererHigh
extends AbstractKanziTemplateRenderer {
    private static final String PROPERTY_CHARGING_PROGRESS = "phev_charging_progress";
    private static final String PROPERTY_CHARGING_STATE = "phev_charging_state";
    private static final String PROPERTY_CABLE_PLUGSTATE = "phev_charging_plugState";
    private static final String PROPERTY_CABLE_PLUGCOLOR = "phev_charging_plugColor";
    private static final String PROPERTY_CLIMATE_STATE = "phev_climate_state";
    private static final String TEMPLATE_NODE_PATH = "Prefabs/phev_loading_car";
    private static final String TEMPLATE_NODE_GB_PATH = "Prefabs/phev_gb_loading_car";
    private static final String EAL_NODE_NAME = "PHEV_loading_car";
    private PHEVLoadingController controller;

    public PHEVLoadingRedererHigh(PHEVLoadingController pHEVLoadingController) {
        this.controller = pHEVLoadingController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setOpacity(this.controller.getRenderOpacity());
        boolean bl = this.getEALManager().isLTR();
        float f2 = this.controller.getX();
        if (!bl) {
            f2 = this.controller.getX() - this.controller.getWidth() + this.controller.getArabicXOffset();
        }
        this.node.setPosition(f2, this.controller.getY(), 0.0f);
        this.setProperty(PROPERTY_CHARGING_PROGRESS, this.controller.getPhevBatteryLevel());
        this.setProperty(PROPERTY_CHARGING_STATE, this.controller.getPhevBatteryState());
        this.setProperty(PROPERTY_CABLE_PLUGSTATE, this.controller.getPhevCablePlugState());
        this.setProperty(PROPERTY_CABLE_PLUGCOLOR, this.controller.getPhevCableColor());
        this.setProperty(PROPERTY_CLIMATE_STATE, this.controller.getClimateState());
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected String getTemplateNodePath() {
        if (this.controller.getMode() == 0) {
            return TEMPLATE_NODE_PATH;
        }
        return TEMPLATE_NODE_GB_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbId(int n) {
        return 0;
    }

    protected int getKzbConstant() {
        return 3;
    }
}


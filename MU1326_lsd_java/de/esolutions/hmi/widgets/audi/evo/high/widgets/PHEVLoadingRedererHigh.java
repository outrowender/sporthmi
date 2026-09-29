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
    private static final String PROPERTY_CHARGING_PROGRESS;
    private static final String PROPERTY_CHARGING_STATE;
    private static final String PROPERTY_CABLE_PLUGSTATE;
    private static final String PROPERTY_CABLE_PLUGCOLOR;
    private static final String PROPERTY_CLIMATE_STATE;
    private static final String TEMPLATE_NODE_PATH;
    private static final String TEMPLATE_NODE_GB_PATH;
    private static final String EAL_NODE_NAME;
    private PHEVLoadingController controller;

    public PHEVLoadingRedererHigh(PHEVLoadingController pHEVLoadingController) {
        this.controller = pHEVLoadingController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setOpacity(this.controller.getRenderOpacity());
        boolean bl = this.getEALManager().isLTR();
        float f2 = this.controller.getX();
        if (!bl) {
            f2 = this.controller.getX() - this.controller.getWidth() + this.controller.getArabicXOffset();
        }
        this.node.setPosition(f2, this.controller.getY(), 0.0f);
        this.setProperty("phev_charging_progress", this.controller.getPhevBatteryLevel());
        this.setProperty("phev_charging_state", this.controller.getPhevBatteryState());
        this.setProperty("phev_charging_plugState", this.controller.getPhevCablePlugState());
        this.setProperty("phev_charging_plugColor", this.controller.getPhevCableColor());
        this.setProperty("phev_climate_state", this.controller.getClimateState());
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected String getTemplateNodePath() {
        if (this.controller.getMode() == 0) {
            return "Prefabs/phev_loading_car";
        }
        return "Prefabs/phev_gb_loading_car";
    }

    @Override
    protected String getEALNodeName() {
        return "PHEV_loading_car";
    }

    protected int getKzbId(int n) {
        return 0;
    }

    @Override
    protected int getKzbConstant() {
        return 3;
    }
}


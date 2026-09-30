/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;

public class OptionDrawerGlassplateRendererHigh
extends GlassplateRendererHigh {
    private static final String EAL_NODE_NAME = "optionDrawerGlassPlate";
    private static final float DEFAULT_REFRACT_HOLE_X = 130.0f;
    private static final float DEFAULT_REFRACT_HOLE_Y = 180.0f;

    public OptionDrawerGlassplateRendererHigh(GlassplateController glassplateController) {
        super(glassplateController);
    }

    protected String getTemplateNodePath() {
        return "Prefabs/generic_glassPlate_optionsDrawer";
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.getEALManager().getBackgroundTexture() != null) {
            this.setProperty("gp_refractHoleX", 130.0f);
            this.setProperty("gp_refractHoleY", 180.0f);
        } else {
            this.setProperty("gp_refractHoleX", 0.0f);
            this.setProperty("gp_refractHoleY", 0.0f);
        }
    }
}


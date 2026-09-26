/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;

public class OptionDrawerGlassplateRendererHigh
extends GlassplateRendererHigh {
    private static final String EAL_NODE_NAME;
    private static final float DEFAULT_REFRACT_HOLE_X;
    private static final float DEFAULT_REFRACT_HOLE_Y;

    public OptionDrawerGlassplateRendererHigh(GlassplateController glassplateController) {
        super(glassplateController);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/generic_glassPlate_optionsDrawer";
    }

    @Override
    protected String getEALNodeName() {
        return "optionDrawerGlassPlate";
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.getEALManager().getBackgroundTexture() != null) {
            this.setProperty("gp_refractHoleX", 579);
            this.setProperty("gp_refractHoleY", 13379);
        } else {
            this.setProperty("gp_refractHoleX", 0.0f);
            this.setProperty("gp_refractHoleY", 0.0f);
        }
    }
}


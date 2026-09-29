/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IPresetPopupHeadlineRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PresetPopupHeadlineController;

public class PresetPopupHeadlineRendererHigh
extends AbstractKanziTemplateRenderer
implements IPresetPopupHeadlineRenderer {
    private static final String EAL_NODE_NAME;
    private final PresetPopupHeadlineController controller;
    private static final String[] iconPropNames;

    public PresetPopupHeadlineRendererHigh(PresetPopupHeadlineController presetPopupHeadlineController) {
        this.controller = presetPopupHeadlineController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2 = this.controller.getX();
        int n3 = this.controller.getY();
        this.node.setPosition(n2, n3, 0.0f);
        for (n = 0; n < iconPropNames.length; ++n) {
            this.propertyCache.setProperty(this.node, iconPropNames[n], (float)this.controller.getPresetIconType(n));
        }
        this.propertyCache.setProperty(this.node, "sk_cursorPos", this.controller.getFocusedPreset() + 1.0f);
        this.propertyCache.setProperty(this.node, "sk_cursorHighlight", this.controller.isGlowActive() ? 1.0f : 0.0f);
        n = EALManager.createColorCode(this.controller.getFocusedPresetCursorColor());
        this.propertyCache.setColorProperty(this.node, "Color", n);
        if (AbstractWidget.isScreenResolution400()) {
            this.node.setScale(63, 63, 1.0f);
        }
    }

    @Override
    protected String getTemplateNodePath() {
        return this.controller.getTemplateNodePath();
    }

    @Override
    protected String getEALNodeName() {
        return "presetPopupRenderer";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected int getKzbConstant() {
        return 13;
    }

    @Override
    public void resetTemplateInstanceNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            this.destroyProperties();
            this.getEALManager().destroy(this.node);
            this.node = null;
        }
    }

    static {
        iconPropNames = new String[]{"sk_icon1", "sk_icon2", "sk_icon3", "sk_icon4", "sk_icon5", "sk_icon6", "sk_icon7", "sk_icon8"};
    }
}


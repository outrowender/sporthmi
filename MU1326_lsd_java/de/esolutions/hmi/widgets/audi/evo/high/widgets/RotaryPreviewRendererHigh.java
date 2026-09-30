/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRotaryRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryRenderer;

public class RotaryPreviewRendererHigh
extends AbstractRotaryRendererHigh
implements RotaryRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/rotator_small_prefab";
    private static final String EAL_NODE_NAME = "rotaryPreview";

    public RotaryPreviewRendererHigh(RotaryController rotaryController) {
        super(rotaryController);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        if (AbstractWidget.framework.getScreenRes() == 0) {
            n -= 2;
        } else {
            n2 -= 8;
            n -= 8;
        }
        this.node.setPosition(n, n2, 0.0f);
        float f2 = this.calculateAngle(this.controller.getValue());
        this.setProperty("generic_rotator_small_angle", f2);
        this.setProperty("itemDisabled", this.controller.isEnabled() ? 0.0f : 1.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public int getPreferredWidth() {
        return this.getPreferredWidth(this.getTerminal());
    }

    public int getPreferredWidth(HMITerminalImpl hMITerminalImpl) {
        return this.getConstant(hMITerminalImpl, 128);
    }

    private int getConstant(HMITerminalImpl hMITerminalImpl, int n) {
        if (hMITerminalImpl != null && hMITerminalImpl.getLayout() != null) {
            return hMITerminalImpl.getLayout().getIntegerConstant(n);
        }
        return -1;
    }

    public int getPreferredHeight() {
        return this.getPreferredHeight(this.getTerminal());
    }

    public int getPreferredHeight(HMITerminalImpl hMITerminalImpl) {
        return this.getConstant(hMITerminalImpl, 129);
    }
}


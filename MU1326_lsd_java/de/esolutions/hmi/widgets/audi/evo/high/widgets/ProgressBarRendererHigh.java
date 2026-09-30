/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarRenderer;

public class ProgressBarRendererHigh
extends AbstractKanziTemplateRenderer
implements ProgressBarRenderer {
    public static final int PREFERRED_WIDTH = 263;
    public static final int PREFERRED_HEIGHT = 10;
    private static final String TEMPLATE_NODE_PATH = "Prefabs/progressBar";
    private static final String EAL_NODE_NAME = "progressBar";
    private float renderOpacity = -1.0f;
    private final ProgressBarController controller;
    private int cachedColor;
    private int cachedColorEAL;

    public ProgressBarRendererHigh(ProgressBarController progressBarController) {
        this.controller = progressBarController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        if (this.renderOpacity != this.controller.getRenderOpacity()) {
            this.renderOpacity = this.controller.getRenderOpacity();
            this.node.setOpacity(this.renderOpacity);
        }
        this.setProperty("pb_width", this.controller.getWidth());
        this.setProperty("pb_progress", this.controller.getProgress());
        this.setProperty("pb_buffer", this.controller.getBufferProgress());
        this.setColorProperty("Color", this.getColor(redrawContextHigh));
    }

    private int getColor(RedrawContextHigh redrawContextHigh) {
        int n = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        if (this.cachedColor == n) {
            return this.cachedColorEAL;
        }
        this.cachedColorEAL = EALManager.createColorCode(n);
        this.cachedColor = n;
        return this.cachedColorEAL;
    }

    public void disconnect() {
        super.disconnect();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public int getPreferredWidth() {
        return 263;
    }

    public int getPreferredHeight() {
        return 10;
    }

    protected int getKzbConstant() {
        return 6;
    }
}


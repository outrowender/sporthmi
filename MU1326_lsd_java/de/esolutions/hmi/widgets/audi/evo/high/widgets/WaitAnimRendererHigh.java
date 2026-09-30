/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IWaitAnimRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;

public class WaitAnimRendererHigh
extends AbstractKanziTemplateRenderer
implements IWaitAnimRenderer {
    public static final int PREFAB_DEFAULT = 0;
    public static final int PREFAB_GOOGLE = 1;
    private static final String TEMPLATE_NODE_PATH = "Prefabs/waiting_icon";
    private static final String TEMPLATE_NODE_PATH_GOOGLE = "Prefabs/waiting_icon_google";
    private static final String EAL_NODE_NAME = "WaitAnimation";
    private static final String KZB_PROGRESS_PROP_NAME = "waitingAnimation";
    private static final String KZB_BACKGROUND_PROP_NAME = "waitingBackground";
    private int prefab = 0;
    private int currentX;
    private int currentY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private WaitAnimController controller;

    public WaitAnimRendererHigh(WaitAnimController waitAnimController) {
        this.controller = waitAnimController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.currentX != this.controller.getX() || this.currentY != this.controller.getY()) {
            this.currentX = this.controller.getX();
            this.currentY = this.controller.getY();
            this.node.setPosition(this.currentX, this.currentY, 0.0f);
        }
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(this.controller.shouldRender());
        this.node.setScale(this.scaleX, this.scaleY, 1.0f);
        this.propertyCache.setProperty(this.node, KZB_PROGRESS_PROP_NAME, this.controller.getProgress());
        this.propertyCache.setProperty(this.node, KZB_BACKGROUND_PROP_NAME, this.controller.showWaitAnimationBackground());
    }

    public void disconnect() {
        super.disconnect();
        this.currentX = -1;
        this.currentY = -1;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredHeight() {
        return this.controller.getTerminalImpl().getLayout().getDistance(193);
    }

    public int getPreferredWidth() {
        return this.controller.getTerminalImpl().getLayout().getDistance(192);
    }

    public void setScaleFactor(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
    }

    public void setPrefab(int n) {
        logAnimation.log(10000, "WaitAnimationRenderer#setPrefab prefab: %1", (long)n);
        if (n == 0 || n == 1) {
            this.prefab = n;
        }
    }

    protected String getTemplateNodePath() {
        return this.selectedPrefab();
    }

    private String selectedPrefab() {
        if (this.prefab == 1) {
            return TEMPLATE_NODE_PATH_GOOGLE;
        }
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbConstant() {
        return 6;
    }
}


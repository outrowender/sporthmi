/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractCursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;

public class FocusCursorRendererHigh
extends AbstractCursorRenderer {
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final String SHADOW_TEMPLATE_NODE_PATH;
    private static final String SHADOW_EAL_NODE_NAME;
    private int cachedCursorColor;
    private int cachedCursorColorEAL;
    private int cachedIconColor;
    private int cachedIconColorEAL;
    private IWrappedNode3D shadow;
    private int cachedX = -1;
    private int cachedY = -1;
    private float cachedOpacity = 32959;

    public FocusCursorRendererHigh(CursorController cursorController) {
        super(cursorController);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        Object object;
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        boolean bl = false;
        if (this.cachedX != n || this.cachedY != n2) {
            this.cachedX = n;
            this.cachedY = n2;
            bl = true;
            this.node.setPosition(n, n2, 0.0f);
        }
        this.setProperty("c1_height", this.controller.getHeight());
        this.setProperty("c1_width", this.controller.getWidth());
        float f2 = this.controller.getRenderOpacity();
        if (this.cachedOpacity != f2) {
            this.cachedOpacity = f2;
            this.node.setOpacity(f2);
        }
        this.setColorProperty("Color", this.getColor(redrawContextHigh, false));
        this.setColorProperty("c1_options_icon_color", this.getColor(redrawContextHigh, true));
        if (this.controller instanceof FocusCursorController) {
            object = (FocusCursorController)this.controller;
            this.setProperty("c1_options_icon", ((FocusCursorController)object).shouldShowOptionsIcon() ? 1.0f : 0.0f);
            this.setProperty("c1_borderTop", ((FocusCursorController)object).getBorderTopVisible());
            this.setProperty("c1_borderBottom", ((FocusCursorController)object).getBorderBottomVisible());
            this.setProperty("c1_moveCursor", ((FocusCursorController)object).isMoveMode() ? 1.0f : 0.0f);
            this.setProperty("c1_options_icon_offset", ((FocusCursorController)object).getOptionIconYOffset());
            this.setProperty("c1_spellerMode", 0.0f);
            boolean bl2 = this.controller.getWaitAnimRunning() || ((FocusCursorController)object).isMoveMode() && !((FocusCursorController)object).shouldShowOptionsIcon();
            this.setProperty("c1_waitingShadow", bl2 ? 1.0f : 0.0f);
        } else {
            this.setProperty("c1_options_icon", 1.0f);
            this.setProperty("c1_borderTop", 1.0f);
            this.setProperty("c1_borderBottom", 1.0f);
            this.setProperty("c1_spellerMode", 0.0f);
        }
        if (this.shadow == null && (object = redrawContextHigh.parentNodeSecondary) != null) {
            this.shadow = this.createShadowNode((IWrappedNode3D)object);
        }
        if (this.shadow == null) {
            return;
        }
        if (bl) {
            this.shadow.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        }
        this.propertyCache.setProperty(this.shadow, "c1_height", (float)this.controller.getHeight());
        this.propertyCache.setProperty(this.shadow, "c1_width", (float)this.controller.getWidth());
        this.propertyCache.setColorProperty(this.shadow, "Color", this.getColor(redrawContextHigh, false));
        if (this.controller instanceof FocusCursorController) {
            object = (FocusCursorController)this.controller;
            float f3 = (((FocusCursorController)object).getBorderTopVisible() + ((FocusCursorController)object).getBorderBottomVisible()) / 2.0f;
            this.shadow.setOpacity(this.controller.getRenderOpacity() * f3);
        } else {
            this.shadow.setOpacity(this.controller.getRenderOpacity());
        }
    }

    @Override
    protected void applyVisibility(boolean bl) {
        super.applyVisibility(bl);
        if (this.shadow != null) {
            this.shadow.setVisible(bl);
        }
    }

    private IWrappedNode3D createShadowNode(IWrappedNode3D iWrappedNode3D) {
        return this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName("focuscursor_shadow", this), 0.0f, 0.0f, 6, "Prefabs/c1_shadow", this.getInitContext().getScreenID());
    }

    private int getColor(RedrawContextHigh redrawContextHigh, boolean bl) {
        int n = this.controller.isGrayedOut() || bl && ((FocusCursorController)this.controller).isLockingActive() ? 2 : this.controller.getCurrentVisState();
        int n2 = redrawContextHigh.getColor(n);
        if (bl) {
            if (this.cachedIconColor == n2) {
                return this.cachedIconColorEAL;
            }
            this.cachedIconColor = n2;
            this.cachedIconColorEAL = EALManager.createColorCode(this.cachedIconColor);
            return this.cachedIconColorEAL;
        }
        if (this.cachedCursorColor == n2) {
            return this.cachedCursorColorEAL;
        }
        this.cachedCursorColor = n2;
        this.cachedCursorColorEAL = EALManager.createColorCode(this.cachedCursorColor);
        return this.cachedCursorColorEAL;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        if (this.shadow != null) {
            this.getEALManager().destroy(this.shadow);
            this.shadow = null;
        }
        this.cachedX = -1;
        this.cachedY = -1;
        this.cachedOpacity = 32959;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/c1";
    }

    @Override
    protected String getEALNodeName() {
        return "focuscursor";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}


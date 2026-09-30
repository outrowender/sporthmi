/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractCursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionCursorController;

public class SelectionCursorRendererHigh
extends AbstractCursorRenderer {
    private static final String EAL_NODE_NAME = "selectioncursor";
    private int cachedColor;
    private int cachedColorEAL;
    private int backgroundKZB = 0;
    private static final int BACKGROUND_STANDARD = 0;
    private static final int BACKGROUND_2CALL = 1;
    private static final String KZB_PATH_STANDARD_BACKGROUND = "Prefabs/c2";
    private static final String KZB_PATH_2CALL_BACKGROUND = "Prefabs/c2_activeItem";

    public SelectionCursorRendererHigh(CursorController cursorController) {
        super(cursorController);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        boolean bl;
        this.node.setPosition(this.controller.getX() + 0, this.controller.getY() + 0, 0.0f);
        this.setProperty("c2_width", this.controller.getWidth());
        this.setProperty("c2_height", this.controller.getHeight());
        if (this.controller instanceof SelectionCursorController) {
            SelectionCursorController selectionCursorController = (SelectionCursorController)this.controller;
            bl = selectionCursorController.isDimmed();
            if (this.backgroundKZB == 1) {
                this.setProperty("c2_separatorOn", 1.0f);
            } else {
                this.setProperty("c2_separatorOn", selectionCursorController.isSeparatorVisible() ? 1.0f : 0.0f);
                this.setProperty("c2_separatorPos", selectionCursorController.getSeparatorPosition());
                this.setProperty("c2_separatorWidth", selectionCursorController.getSeparatorWidth());
            }
        } else {
            this.setProperty("c2_separatorOn", 0.0f);
            bl = false;
        }
        this.setProperty("c2_active", bl ? 0.0f : 1.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
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

    protected String getTemplateNodePath() {
        return this.backgroundKZB == 1 ? KZB_PATH_2CALL_BACKGROUND : KZB_PATH_STANDARD_BACKGROUND;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setBackgroundMode(int n) {
        this.backgroundKZB = n == 1 ? 1 : 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class PartialPopupGlassplateController
extends AbstractWidgetController {
    private IRenderer renderer;
    private int separatorYPosition = 0;
    private boolean separatorVisible = false;
    private float scale = 1.0f;
    private float glassplateOpacity = 1.0f;

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int getSeparatorYPosition() {
        return this.separatorYPosition;
    }

    public void setSeparatorYPosition(int n) {
        this.separatorYPosition = n;
    }

    public boolean getSeparatorVisible() {
        return this.separatorVisible;
    }

    public void setSeparatorVisible(boolean bl) {
        this.separatorVisible = bl;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public float getScale() {
        return this.scale;
    }

    public float getGlassplateOpacity() {
        return this.glassplateOpacity;
    }

    public void setGlassplateOpacity(float f2) {
        this.glassplateOpacity = f2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class SeparatingHeadlineController
extends AbstractWidgetController {
    private float separatorPos = 0.0f;
    private float separatorGap = 0.0f;
    private IRenderer renderer = null;

    public float getSeparatorPos() {
        return this.separatorPos;
    }

    public void setSeparatorPos(float f2) {
        this.separatorPos = f2;
    }

    public float getSeparatorGap() {
        return this.separatorGap;
    }

    public void setSeparatorGap(float f2) {
        this.separatorGap = f2;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }
}


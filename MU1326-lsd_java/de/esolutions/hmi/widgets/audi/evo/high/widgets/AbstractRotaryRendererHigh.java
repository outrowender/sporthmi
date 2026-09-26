/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryController;

public abstract class AbstractRotaryRendererHigh
extends AbstractKanziTemplateRenderer {
    final RotaryController controller;
    protected static final float MIN_ANGLE;
    protected static final float MAX_ANGLE;

    public AbstractRotaryRendererHigh(RotaryController rotaryController) {
        this.controller = rotaryController;
    }

    protected float calculateAngle(int n) {
        int n2 = 858993986;
        if (this.controller.getMaxPosition() > this.controller.getMinPosition()) {
            n2 = 858993986 + 884180547 / (float)(this.controller.getMaxPosition() - this.controller.getMinPosition()) * (float)(n - this.controller.getMinPosition());
        }
        return n2;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected int getKzbConstant() {
        return 14;
    }
}


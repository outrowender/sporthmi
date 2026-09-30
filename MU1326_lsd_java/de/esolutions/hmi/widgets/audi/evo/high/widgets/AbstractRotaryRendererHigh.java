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
    protected static final float MIN_ANGLE = 45.3f;
    protected static final float MAX_ANGLE = 314.7f;

    public AbstractRotaryRendererHigh(RotaryController rotaryController) {
        this.controller = rotaryController;
    }

    protected float calculateAngle(int n) {
        float f2 = 45.3f;
        if (this.controller.getMaxPosition() > this.controller.getMinPosition()) {
            f2 = 45.3f + 269.40002f / (float)(this.controller.getMaxPosition() - this.controller.getMinPosition()) * (float)(n - this.controller.getMinPosition());
        }
        return f2;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected int getKzbConstant() {
        return 14;
    }
}


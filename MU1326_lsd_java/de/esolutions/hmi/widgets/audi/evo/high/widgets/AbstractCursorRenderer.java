/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.WaitAnimRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;

public abstract class AbstractCursorRenderer
extends AbstractKanziTemplateRenderer
implements CursorRenderer {
    protected final CursorController controller;
    protected WaitAnimController waitAnimationController;

    public AbstractCursorRenderer(CursorController cursorController) {
        this.controller = cursorController;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        if (this.controller != null) {
            this.waitAnimationController = this.controller.getWaitAnimationController();
            if (this.waitAnimationController != null && this.waitAnimationController.getRenderer() == null) {
                WaitAnimRendererHigh waitAnimRendererHigh = new WaitAnimRendererHigh(this.waitAnimationController);
                this.waitAnimationController.setRenderer(waitAnimRendererHigh);
            }
        }
    }

    protected int getKzbConstant() {
        return 6;
    }
}


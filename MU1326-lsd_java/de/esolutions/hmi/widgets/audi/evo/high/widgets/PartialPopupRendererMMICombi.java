/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupControllerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;

public class PartialPopupRendererMMICombi
extends AbstractRendererHigh {
    private final PartialPopupControllerMMICombi controller;

    public PartialPopupRendererMMICombi(PartialPopupControllerMMICombi partialPopupControllerMMICombi) {
        this.controller = partialPopupControllerMMICombi;
    }

    @Override
    public void render(RedrawContext redrawContext) {
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListItemController2$1;

class MixedListItemController2$CellInstance {
    Object widget;
    boolean isPrimaryCell;
    MixedListItemController2$CellInstance[] grid;

    private MixedListItemController2$CellInstance() {
    }

    public AbstractWidgetController getWidget() {
        return (AbstractWidgetController)this.widget;
    }

    /* synthetic */ MixedListItemController2$CellInstance(MixedListItemController2$1 mixedListItemController2$1) {
        this();
    }
}


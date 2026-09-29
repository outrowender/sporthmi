/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;

public class StatusbarGridLayout
extends GridLayout {
    public StatusbarGridLayout(int n, int n2) {
        super(n, n2);
    }

    @Override
    protected void setBounds(Object object, int n, int n2, int n3, int n4) {
        if (object instanceof AbstractWidget) {
            AbstractWidget abstractWidget = (AbstractWidget)object;
            abstractWidget.setBounds(this.xOffset + n, this.yOffset + n2, n3, n4);
        } else if (object instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout)object;
            gridLayout.xOffset = n;
            gridLayout.yOffset = n2;
            gridLayout.layoutInternal(n3, n4);
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown grid cell: ").append(object).toString());
        }
    }

    @Override
    protected boolean isWidgetVisible(Object object) {
        if (object != null && object instanceof AbstractWidgetController) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object;
            return abstractWidgetController.isVisible() && abstractWidgetController.isVisibleOnCurrentStage() && abstractWidgetController.isOnScreen();
        }
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$GridCell;

class NavMapInfoTextWidget$WidgetGridCell
extends NavMapInfoTextWidget$GridCell {
    AbstractWidgetController widget;

    @Override
    public int getDesiredWidth() {
        if (this.widget != null && this.widget.isVisible()) {
            return this.desiredWidth;
        }
        return 0;
    }

    public NavMapInfoTextWidget$WidgetGridCell(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController != null) {
            this.widget = abstractWidgetController;
            this.desiredWidth = abstractWidgetController.getPreferredWidth();
        }
    }

    public NavMapInfoTextWidget$WidgetGridCell(AbstractWidgetController abstractWidgetController, int n) {
        this.widget = abstractWidgetController;
        this.desiredWidth = n;
    }

    public NavMapInfoTextWidget$WidgetGridCell(AbstractWidgetController abstractWidgetController, int n, int n2) {
        this.widget = abstractWidgetController;
        this.desiredWidth = n;
        this.alignment = n2;
    }

    @Override
    public void setAvailableWidth(int n) {
        this.availableWidth = n;
        if (this.widget != null) {
            this.widget.setWidth(n);
        }
    }

    @Override
    public void setXPosition(int n) {
        if (this.widget != null) {
            int n2 = 0;
            switch (this.alignment) {
                case 2: {
                    int n3 = this.getAvailableWidth();
                    int n4 = this.widget.getPreferredWidth();
                    n2 = (n3 - n4) / 2;
                    break;
                }
            }
            this.widget.setX(n2 + n);
        }
    }
}


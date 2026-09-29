/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$GridCell;

class NavMapInfoTextWidget$DoubleLineGridCell
extends NavMapInfoTextWidget$GridCell {
    NavMapInfoTextWidget$GridCell line1;
    NavMapInfoTextWidget$GridCell line2;

    NavMapInfoTextWidget$DoubleLineGridCell() {
    }

    @Override
    public int getAvailableWidth() {
        return this.availableWidth;
    }

    @Override
    public int getDesiredWidth() {
        return Math.max(this.line1.getDesiredWidth(), this.line2.getDesiredWidth());
    }

    @Override
    public void setAvailableWidth(int n) {
        this.availableWidth = n;
        this.line1.setAvailableWidth(n);
        this.line2.setAvailableWidth(n);
    }

    @Override
    public void setXPosition(int n) {
        this.line1.setXPosition(n);
        this.line2.setXPosition(n);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

class NavMapInfoTextWidget$GridCell {
    String name = "";
    int desiredWidth;
    int availableWidth = -1;
    int alignment = 1;

    NavMapInfoTextWidget$GridCell() {
    }

    public int getAvailableWidth() {
        return this.availableWidth;
    }

    public int getDesiredWidth() {
        return this.desiredWidth;
    }

    public void setAvailableWidth(int n) {
        this.availableWidth = n;
    }

    public void setXPosition(int n) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;

public class SelectionCursorController
extends CursorController {
    private boolean separatorVisible = false;
    private int separatorPosition;
    private int separatorWidth;
    private boolean dimmed = false;

    public boolean isSeparatorVisible() {
        return this.separatorVisible;
    }

    public void setSeparatorVisible(boolean bl) {
        this.separatorVisible = bl;
    }

    public int getSeparatorPosition() {
        return this.separatorPosition;
    }

    public void setSeparatorPosition(int n) {
        this.separatorPosition = n;
    }

    public int getSeparatorWidth() {
        return this.separatorWidth;
    }

    public void setSeparatorWidth(int n) {
        this.separatorWidth = n;
    }

    public boolean isDimmed() {
        return this.dimmed;
    }

    public void setDimmed(boolean bl) {
        this.dimmed = bl;
    }
}


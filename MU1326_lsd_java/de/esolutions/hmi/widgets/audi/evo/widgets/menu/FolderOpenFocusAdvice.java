/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;

public class FolderOpenFocusAdvice
extends WidgetFocusAdvice {
    private final int newItemsHeight;

    public FolderOpenFocusAdvice(int n, int n2, boolean bl) {
        super("FolderOpen", n2, bl);
        this.newItemsHeight = n;
    }

    public int getNewItemsHeight() {
        return this.newItemsHeight;
    }

    public String toString() {
        String string = this.isTopAligned() ? "top" : "bottom";
        return "FolderOpenFocusAdvice [Pixel:" + this.getPixel() + ", " + string + ", newItemsHeight:" + this.newItemsHeight + "]";
    }
}


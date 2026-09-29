/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu.focus;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;

public class WidgetFocusAdvice
extends FocusAdvice {
    private final int pixel;
    private final boolean topAligned;

    public WidgetFocusAdvice(int n, boolean bl) {
        super("KeepPixel");
        this.pixel = n;
        this.topAligned = bl;
    }

    protected WidgetFocusAdvice(String string, int n, boolean bl) {
        super(string);
        this.pixel = n;
        this.topAligned = bl;
    }

    public int getPixel() {
        return this.pixel;
    }

    public boolean isTopAligned() {
        return this.topAligned;
    }

    @Override
    public String toString() {
        String string = this.topAligned ? "top" : "bottom";
        return new StringBuffer().append("WidgetFocusAdvice [").append(this.pixel).append(", ").append(string).append("]").toString();
    }
}


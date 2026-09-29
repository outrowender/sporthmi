/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.icon;

import de.audi.atip.interapp.icon.RenderingInfo;

public class ExtRenderingInfo
extends RenderingInfo {
    private int fontReference;
    private int fontSize;
    private int fontColor;
    private int deltaX;
    private int deltaY;

    public ExtRenderingInfo(int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        super(n, bl);
        this.fontReference = n2;
        this.fontSize = n3;
        this.fontColor = n4;
        this.deltaX = n5;
        this.deltaY = n6;
    }

    public int getDeltaX() {
        return this.deltaX;
    }

    public int getDeltaY() {
        return this.deltaY;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public int getFontReference() {
        return this.fontReference;
    }

    public int getFontSize() {
        return this.fontSize;
    }
}


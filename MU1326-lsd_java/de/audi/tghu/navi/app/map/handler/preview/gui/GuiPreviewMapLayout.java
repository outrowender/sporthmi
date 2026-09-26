/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.gui;

import org.dsi.ifc.map.Rect;

public class GuiPreviewMapLayout {
    public int width;
    public int height;
    public int xOffset;
    public int yOffset;

    public GuiPreviewMapLayout(int n, int n2, int n3, int n4) {
        this.width = n;
        this.height = n2;
        this.xOffset = n3;
        this.yOffset = n4;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof GuiPreviewMapLayout) {
            GuiPreviewMapLayout guiPreviewMapLayout = (GuiPreviewMapLayout)object;
            return this.width == guiPreviewMapLayout.width && this.height == guiPreviewMapLayout.height && this.xOffset == guiPreviewMapLayout.xOffset && this.yOffset == guiPreviewMapLayout.yOffset;
        }
        return super.equals(object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.width;
        n = 31 * n + this.height;
        n = 31 * n + this.xOffset;
        n = 31 * n + this.yOffset;
        return n;
    }

    public Rect getVisibleArea() {
        return new Rect(this.xOffset, this.yOffset, this.width, this.height);
    }
}


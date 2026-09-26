/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;

public final class RedrawContextHigh
implements Cloneable,
RedrawContext {
    public IWrappedNode3D parentNode;
    public IWrappedNode3D parentNodeSecondary;
    public IWrappedLayer offscreenLayer;
    private IWrappedFont[] fonts;
    private int fontIndex;
    private int[] colorIndices = null;
    private int[] activeColorPlate = null;
    private int screenID = -1;
    private int nodeIndex;

    private int getColorFromPalette(int n) {
        try {
            return this.activeColorPlate[this.colorIndices[n]];
        }
        catch (Exception exception) {
            if (this.colorIndices == null) {
                AbstractWidget.logChannel.log(10000, "RedrawContext#getColor: no colorIndices set at RedrawContext, returning default color");
            } else if (this.colorIndices.length <= n) {
                AbstractWidget.logChannel.log(10000, "RedrawContext#getColor: colorIndices to short for index %1", (long)n);
            } else if (this.activeColorPlate == null) {
                AbstractWidget.logChannel.log(10000, "RedrawContext#getColor: no active color plate set at RedrawContext, returning default color");
            } else if (this.activeColorPlate.length <= this.colorIndices[n]) {
                AbstractWidget.logChannel.log(10000, "RedrawContext#getColor: active color is not long enough for index %1", (long)this.colorIndices[n]);
            }
            return -65281;
        }
    }

    @Override
    public int getColor(int n) {
        return this.getColorFromPalette(n);
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public int getScreenID() {
        return this.screenID;
    }

    @Override
    public void setScreenID(int n) {
        this.screenID = n;
    }

    public int[] getColorIndices() {
        return this.colorIndices;
    }

    @Override
    public int[] setColorIndices(int[] nArray) {
        int[] nArray2 = this.colorIndices;
        this.colorIndices = nArray;
        return nArray2;
    }

    @Override
    public int[] getActiveColorPlate() {
        return this.activeColorPlate;
    }

    @Override
    public void setActiveColorPlate(int[] nArray) {
        this.activeColorPlate = nArray;
    }

    @Override
    public int getNodeIndex() {
        return this.nodeIndex;
    }

    @Override
    public void setNodeIndex(int n) {
        this.nodeIndex = n;
    }

    @Override
    public int getCalculatedNodeIndex(int n) {
        if (n != 0) {
            return n;
        }
        return this.getNodeIndex();
    }

    public void setFont(int n) {
        if (this.hasFont(n)) {
            this.fontIndex = n;
        }
    }

    public int getFontIndex() {
        return this.fontIndex;
    }

    public IWrappedFont getCurrentFont() {
        return this.getFont(this.fontIndex);
    }

    public IWrappedFont[] getFonts() {
        return this.fonts;
    }

    public IWrappedFont getFont(int n) {
        if (this.hasFont(n)) {
            return this.fonts[n];
        }
        if (n != 0) {
            AbstractWidget.logChannel.log(-1601830656, "RedrawContext#getFont no font available for index %1 trying to get font for index 0", (long)n);
            return this.getFont(0);
        }
        AbstractWidget.logChannel.log(10000, "RedrawContext#getFont no font available for index 0 available - no fonts available ");
        return null;
    }

    private boolean hasFont(int n) {
        return this.fonts != null && n >= 0 && n < this.fonts.length && this.fonts[n] != null;
    }

    public IWrappedFont[] setFonts(IWrappedFont[] iWrappedFontArray) {
        IWrappedFont[] iWrappedFontArray2 = this.fonts;
        this.fonts = iWrappedFontArray;
        return iWrappedFontArray2;
    }
}


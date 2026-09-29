/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public class WrappedFont
implements IWrappedFont {
    private final int size;
    private IFontGroup fontGroup;
    private ITextLayout layout;

    public WrappedFont(int n, IFontGroup iFontGroup) {
        this.size = n;
        this.fontGroup = iFontGroup;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public IFontGroup getFontGroup() {
        return this.fontGroup;
    }

    @Override
    public ITextLayout getLayout() {
        if (this.layout == null) {
            this.layout = this.createLayout();
        }
        return this.layout;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.fontGroup == null ? 0 : this.fontGroup.hashCode());
        n = 31 * n + (this.layout == null ? 0 : this.layout.hashCode());
        n = 31 * n + this.size;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof WrappedFont)) {
            return false;
        }
        WrappedFont wrappedFont = (WrappedFont)object;
        if (this.fontGroup == null ? wrappedFont.fontGroup != null : !this.fontGroup.equals(wrappedFont.fontGroup)) {
            return false;
        }
        if (this.layout == null ? wrappedFont.layout != null : !this.layout.equals(wrappedFont.layout)) {
            return false;
        }
        return this.size == wrappedFont.size;
    }

    @Override
    public ITextLayout createLayout() {
        this.getFontGroup().activate();
        return new ITextLayout(this.getSize());
    }
}


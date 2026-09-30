/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.ITextLayout;

public interface IWrappedFont {
    public int getSize();

    public IFontGroup getFontGroup();

    public ITextLayout getLayout();

    public ITextLayout createLayout();
}


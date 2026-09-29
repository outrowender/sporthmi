/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.ITextLayout;

public interface IWrappedFont {
    default public int getSize() {
    }

    default public IFontGroup getFontGroup() {
    }

    default public ITextLayout getLayout() {
    }

    default public ITextLayout createLayout() {
    }
}


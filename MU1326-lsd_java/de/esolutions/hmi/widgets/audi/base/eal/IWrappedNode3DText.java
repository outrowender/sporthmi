/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public interface IWrappedNode3DText
extends IBaseWrappedNode3DText {
    public static final int ABBREVIATE_WIDTH_UNLIMITED;

    default public void setText(String string, IWrappedFont iWrappedFont) {
    }

    default public void setText(String string, IWrappedFont iWrappedFont, int n, EALManager eALManager) {
    }

    default public void setColor(int n) {
    }

    default public IWrappedFont getFont() {
    }

    default public int getAbbreviateWidth() {
    }
}


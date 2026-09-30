/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public interface IWrappedNode3DText
extends IBaseWrappedNode3DText {
    public static final int ABBREVIATE_WIDTH_UNLIMITED = 10000;

    public void setText(String var1, IWrappedFont var2);

    public void setText(String var1, IWrappedFont var2, int var3, EALManager var4);

    public void setColor(int var1);

    public IWrappedFont getFont();

    public int getAbbreviateWidth();
}


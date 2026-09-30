/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import java.util.Iterator;

public interface IFontLoader {
    public static final int STYLE_PLAIN = 0;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_LIGHT = 2;
    public static final int STYLE_ITALIC = 3;

    public Object getFont(String var1, int var2, int var3);

    public Object getFont(int var1, int var2);

    public Iterator getAllFonts();

    public void destroyFont(Object var1);

    public void clearFontCache();
}


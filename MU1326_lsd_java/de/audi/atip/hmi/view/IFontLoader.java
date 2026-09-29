/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import java.util.Iterator;

public interface IFontLoader {
    public static final int STYLE_PLAIN;
    public static final int STYLE_BOLD;
    public static final int STYLE_LIGHT;
    public static final int STYLE_ITALIC;

    default public Object getFont(String string, int n, int n2) {
    }

    default public Object getFont(int n, int n2) {
    }

    default public Iterator getAllFonts() {
    }

    default public void destroyFont(Object object) {
    }

    default public void clearFontCache() {
    }
}


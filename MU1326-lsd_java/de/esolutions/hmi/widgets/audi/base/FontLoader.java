/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.IFontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;

public abstract class FontLoader
implements IFontLoader {
    public static String STANDARD_FONT_PLAIN;
    public static String STANDARD_FONT_BOLD;
    public static String STANDARD_FONT_LIGHT;
    public static String STANDARD_FONT_BASE;
    protected final HMITerminalImpl terminal;

    public FontLoader(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
        STANDARD_FONT_PLAIN = hMITerminalImpl.getLayout().getFontName(0);
        STANDARD_FONT_BOLD = hMITerminalImpl.getLayout().getFontName(1);
        STANDARD_FONT_LIGHT = hMITerminalImpl.getLayout().getFontName(2);
        STANDARD_FONT_BASE = hMITerminalImpl.getLayout().getFontName(3);
    }
}


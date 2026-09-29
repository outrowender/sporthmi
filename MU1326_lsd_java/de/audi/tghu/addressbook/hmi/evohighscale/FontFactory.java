/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IFontLoader;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public class FontFactory {
    private static IFontLoader fontLoader;
    private static IWrappedFont[][] fontArrays;

    public static IWrappedFont[] getFonts(int n, int n2, IFrameworkAccess iFrameworkAccess) {
        if (fontArrays[n] != null) {
            return fontArrays[n];
        }
        if (fontLoader == null) {
            fontLoader = ((HMITerminalImpl)iFrameworkAccess.getHMIService().getHMITerminal(n2)).getFontLoader();
        }
        switch (n) {
            case 0: {
                FontFactory.fontArrays[0] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29)};
                break;
            }
            case 1: {
                FontFactory.fontArrays[1] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23)};
                break;
            }
            case 2: {
                FontFactory.fontArrays[2] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 25), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 28)};
                break;
            }
            case 3: {
                FontFactory.fontArrays[3] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 33), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26)};
                break;
            }
            case 4: {
                FontFactory.fontArrays[4] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 29)};
                break;
            }
            case 5: {
                FontFactory.fontArrays[5] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29)};
                break;
            }
            default: {
                iFrameworkAccess.getLogChannel("FontFactory").log(10000, new StringBuffer().append("Invalid font array id ").append(n).append(".").toString());
            }
        }
        return fontArrays[n];
    }

    static {
        fontArrays = new IWrappedFont[6][];
    }
}


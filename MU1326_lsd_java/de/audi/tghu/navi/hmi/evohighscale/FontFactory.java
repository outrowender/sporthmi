/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

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
                FontFactory.fontArrays[1] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 27)};
                break;
            }
            case 2: {
                FontFactory.fontArrays[2] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23)};
                break;
            }
            case 3: {
                FontFactory.fontArrays[3] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 29)};
                break;
            }
            case 4: {
                FontFactory.fontArrays[4] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 25), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 28)};
                break;
            }
            case 5: {
                FontFactory.fontArrays[5] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 33), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26)};
                break;
            }
            case 6: {
                FontFactory.fontArrays[6] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 21)};
                break;
            }
            case 7: {
                FontFactory.fontArrays[7] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29)};
                break;
            }
            case 8: {
                FontFactory.fontArrays[8] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26)};
                break;
            }
            case 9: {
                FontFactory.fontArrays[9] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 13)};
                break;
            }
            case 10: {
                FontFactory.fontArrays[10] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 12)};
                break;
            }
            case 11: {
                FontFactory.fontArrays[11] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18)};
                break;
            }
            case 12: {
                FontFactory.fontArrays[12] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 21), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18)};
                break;
            }
            case 13: {
                FontFactory.fontArrays[13] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18)};
                break;
            }
            case 14: {
                FontFactory.fontArrays[14] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 13)};
                break;
            }
            case 15: {
                FontFactory.fontArrays[15] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 24), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 13)};
                break;
            }
            case 16: {
                FontFactory.fontArrays[16] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 15)};
                break;
            }
            case 17: {
                FontFactory.fontArrays[17] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 20)};
                break;
            }
            default: {
                iFrameworkAccess.getLogChannel("FontFactory").log(10000, "Invalid font array id " + n + ".");
            }
        }
        return fontArrays[n];
    }

    static {
        fontArrays = new IWrappedFont[18][];
    }
}


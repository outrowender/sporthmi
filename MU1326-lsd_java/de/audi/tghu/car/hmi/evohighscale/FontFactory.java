/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

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
            case 6: {
                FontFactory.fontArrays[6] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 28)};
                break;
            }
            case 7: {
                FontFactory.fontArrays[7] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 74)};
                break;
            }
            case 8: {
                FontFactory.fontArrays[8] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 32)};
                break;
            }
            case 9: {
                FontFactory.fontArrays[9] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 23)};
                break;
            }
            case 10: {
                FontFactory.fontArrays[10] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 26)};
                break;
            }
            case 11: {
                FontFactory.fontArrays[11] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 19)};
                break;
            }
            case 12: {
                FontFactory.fontArrays[12] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 31)};
                break;
            }
            case 13: {
                FontFactory.fontArrays[13] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 50)};
                break;
            }
            case 14: {
                FontFactory.fontArrays[14] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 29), (IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 16)};
                break;
            }
            case 15: {
                FontFactory.fontArrays[15] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 17)};
                break;
            }
            case 16: {
                FontFactory.fontArrays[16] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 27)};
                break;
            }
            case 17: {
                FontFactory.fontArrays[17] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 24)};
                break;
            }
            case 18: {
                FontFactory.fontArrays[18] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 23)};
                break;
            }
            case 19: {
                FontFactory.fontArrays[19] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, 20)};
                break;
            }
            case 20: {
                FontFactory.fontArrays[20] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 15)};
                break;
            }
            case 21: {
                FontFactory.fontArrays[21] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 16)};
                break;
            }
            case 22: {
                FontFactory.fontArrays[22] = new IWrappedFont[]{(IWrappedFont)fontLoader.getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 18)};
                break;
            }
            default: {
                iFrameworkAccess.getLogChannel("FontFactory").log(10000, new StringBuffer().append("Invalid font array id ").append(n).append(".").toString());
            }
        }
        return fontArrays[n];
    }

    static {
        fontArrays = new IWrappedFont[23][];
    }
}


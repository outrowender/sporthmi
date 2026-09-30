/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.FontLoaderEAL;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedFont;
import java.io.File;
import java.util.HashMap;

public class FontLoaderEvoHigh
extends FontLoaderEAL {
    private static final String FONT_DEFAULT = "AudiTypeDisplayHigh-Normal_13.ttf";
    private static final String FONT_ESO_SPECIAL = "EsoSpecial.ttf";
    private static final String FONT_PLAIN = "AudiTypeDisplayHigh-Normal_13.ttf";
    private static final String FONT_BOLD = "AudiTypeDisplayHigh-Bold_7.ttf";
    private static final String FONT_ARABIC = "LT_Univers440_88perc_Arabic.ttf";
    private static final String FONT_KOREAN = "LTUnivers_Korean_20080609.ttf";
    private static final String FONT_JAPANESE = "LTUnivers_Japanese_20100301.ttf";
    private static final String FONT_CHINESE = "ZYHei_GB18030_c(20131128).ttf";
    private static final String LUR_EU_PLAIN = "variant_EU_plain.lur";
    private static final String LUR_EU_BOLD = "variant_EU_bold.lur";
    private static final String LUR_JP_PLAIN = "variant_JP_plain.lur";
    private static final String LUR_JP_BOLD = "variant_JP_bold.lur";
    private static final String LUR_KR_PLAIN = "variant_KR_plain.lur";
    private static final String LUR_KR_BOLD = "variant_KR_bold.lur";
    private static final String LUR_CN_PLAIN = "variant_CN_plain.lur";
    private static final String LUR_CN_BOLD = "variant_CN_bold.lur";
    private HashMap fontGroups = new HashMap();
    private SysConstModel regionInfoModel = (SysConstModel)AbstractWidget.framework.getHMIService().getModel(442);
    private String fontPathSlashEnding;
    private boolean isSomethingMissing;
    private static final boolean LOAD_ALL_FONTS_FOR_STANDARD = SystemProperties.getBoolean("loadAllFontsForStandard", false);

    public FontLoaderEvoHigh(HMITerminalImpl hMITerminalImpl) {
        super(hMITerminalImpl);
        if (this.regionInfoModel != null) {
            logHybridCalls.log(10000000, "FontLoaderEvoHigh#FontLoaderEvoHigh created. Path is %1, Region is %2", (Object)this.fontPath, (long)this.regionInfoModel.getValue());
        } else {
            logHybridCalls.log(10000, "FontLoaderEvoHigh#FontLoaderEvoHigh Region not available.");
        }
        this.fontPathSlashEnding = FontLoaderEvoHigh.concat(this.fontPath, "/");
        int n = this.getRegion();
        int n2 = 14;
        if (n == 0) {
            n2 = 15;
        }
        String[] stringArray = new String[n2];
        stringArray[0] = FONT_ARABIC;
        stringArray[1] = FONT_KOREAN;
        stringArray[2] = FONT_CHINESE;
        stringArray[3] = FONT_JAPANESE;
        stringArray[4] = LUR_EU_PLAIN;
        stringArray[5] = LUR_EU_BOLD;
        stringArray[6] = LUR_CN_PLAIN;
        stringArray[7] = LUR_CN_BOLD;
        stringArray[8] = LUR_JP_PLAIN;
        stringArray[9] = LUR_JP_BOLD;
        stringArray[10] = LUR_KR_PLAIN;
        stringArray[11] = LUR_KR_BOLD;
        stringArray[12] = "AudiTypeDisplayHigh-Normal_13.ttf";
        stringArray[13] = FONT_BOLD;
        if (n == 0) {
            stringArray[14] = FONT_ESO_SPECIAL;
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            File file = new File(FontLoaderEvoHigh.concat(this.fontPathSlashEnding, stringArray[i2]));
            if (file.exists()) continue;
            this.isSomethingMissing = true;
            logHybridCalls.log(10000, "FontLoaderEvoHigh#FontLoaderEvoHigh File %1 is missing.", (Object)stringArray[i2]);
        }
    }

    public Object getFont(String string, int n, int n2) {
        WrappedFont wrappedFont = null;
        int n3 = this.getRegion();
        String string2 = new Buffer(string.length() + 4).append(string).append(n2).append(n).append(n3).toString();
        Object object = this.fonts.get(string2);
        if (object == null) {
            wrappedFont = new WrappedFont(n2, this.getFontGroup(n, n3));
            if (wrappedFont != null) {
                this.fonts.put(string2, wrappedFont);
            }
        } else {
            wrappedFont = (WrappedFont)object;
        }
        return wrappedFont;
    }

    private IFontGroup getFontGroup(int n, int n2) {
        String string = Integer.toString(n2) + Integer.toString(n);
        IFontGroup iFontGroup = null;
        Object object = this.fontGroups.get(string);
        if (object == null) {
            if (this.isSomethingMissing) {
                iFontGroup = new IFontGroup(EALManager.getManager());
                this.addFont(iFontGroup, "AudiTypeDisplayHigh-Normal_13.ttf");
            } else {
                block0 : switch (n) {
                    default: {
                        switch (n2) {
                            case 3: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, "AudiTypeDisplayHigh-Normal_13.ttf");
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_JP_PLAIN);
                                break block0;
                            }
                            case 4: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, "AudiTypeDisplayHigh-Normal_13.ttf");
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_KR_PLAIN);
                                break block0;
                            }
                            case 2: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, "AudiTypeDisplayHigh-Normal_13.ttf");
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_CN_PLAIN);
                                break block0;
                            }
                        }
                        iFontGroup = new IFontGroup(EALManager.getManager());
                        this.addFont(iFontGroup, FONT_ESO_SPECIAL);
                        this.addFont(iFontGroup, "AudiTypeDisplayHigh-Normal_13.ttf");
                        this.addFont(iFontGroup, FONT_ARABIC);
                        if (this.shouldLoadAdditionalFonts()) {
                            this.addFont(iFontGroup, FONT_CHINESE);
                            this.addFont(iFontGroup, FONT_KOREAN);
                            this.addFont(iFontGroup, FONT_JAPANESE);
                        }
                        this.linkUnicodeRanges(iFontGroup, LUR_EU_PLAIN);
                        break;
                    }
                    case 1: {
                        switch (n2) {
                            case 3: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, FONT_BOLD);
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_JP_BOLD);
                                break block0;
                            }
                            case 4: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, FONT_BOLD);
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_KR_BOLD);
                                break block0;
                            }
                            case 2: {
                                iFontGroup = new IFontGroup(EALManager.getManager());
                                this.addFont(iFontGroup, FONT_BOLD);
                                this.addFont(iFontGroup, FONT_CHINESE);
                                this.addFont(iFontGroup, FONT_KOREAN);
                                this.addFont(iFontGroup, FONT_JAPANESE);
                                this.addFont(iFontGroup, FONT_ARABIC);
                                this.linkUnicodeRanges(iFontGroup, LUR_CN_BOLD);
                                break block0;
                            }
                        }
                        iFontGroup = new IFontGroup(EALManager.getManager());
                        this.addFont(iFontGroup, FONT_ESO_SPECIAL);
                        this.addFont(iFontGroup, FONT_BOLD);
                        this.addFont(iFontGroup, FONT_ARABIC);
                        if (this.shouldLoadAdditionalFonts()) {
                            this.addFont(iFontGroup, FONT_CHINESE);
                            this.addFont(iFontGroup, FONT_KOREAN);
                            this.addFont(iFontGroup, FONT_JAPANESE);
                        }
                        this.linkUnicodeRanges(iFontGroup, LUR_EU_BOLD);
                    }
                }
            }
            if (iFontGroup != null) {
                IWidgetLogChannel.logBenchmark.log(10000000, "FontloaderEvoHigh#getFontGroup created style=%1, region=%2", (long)n, (long)n2);
                this.fontGroups.put(string, iFontGroup);
            }
        } else {
            iFontGroup = (IFontGroup)object;
        }
        return iFontGroup;
    }

    private boolean shouldLoadAdditionalFonts() {
        if (AbstractWidget.isVariantStd()) {
            return LOAD_ALL_FONTS_FOR_STANDARD;
        }
        return true;
    }

    private int getRegion() {
        int n = 0;
        if (this.regionInfoModel != null) {
            n = this.regionInfoModel.getValue();
        }
        return n;
    }

    private void addFont(IFontGroup iFontGroup, String string) {
        IWidgetLogChannel.logBenchmark.log(10000000, "FontloaderEvoHigh#addFont font=%1", (Object)string);
        iFontGroup.addFont(FontLoaderEvoHigh.concat(this.fontPathSlashEnding, string));
    }

    private void linkUnicodeRanges(IFontGroup iFontGroup, String string) {
        IWidgetLogChannel.logBenchmark.log(10000000, "FontloaderEvoHigh#linkUnicodeRanges lur=%1", (Object)string);
        iFontGroup.linkUnicodeRanges(FontLoaderEvoHigh.concat(this.fontPathSlashEnding, string));
    }

    private static String concat(String string, String string2) {
        return StringUtility.concatenate(string, string2);
    }
}


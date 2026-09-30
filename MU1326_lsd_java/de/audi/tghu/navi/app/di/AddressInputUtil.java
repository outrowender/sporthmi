/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class AddressInputUtil {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$di$AddressInputUtil == null ? (class$de$audi$tghu$navi$app$di$AddressInputUtil = AddressInputUtil.class$("de.audi.tghu.navi.app.di.AddressInputUtil")) : class$de$audi$tghu$navi$app$di$AddressInputUtil);
    public static final int NEW_SEARCH_AREA_CONTEXT_STATUS_LOCATION_INCOMPLETE = 0;
    public static final int NEW_SEARCH_AREA_CONTEXT_STATUS_LOCATION_COMPLETE = 1;
    public static final int NEW_SEARCH_AREA_CONTEXT_POI = 0;
    public static final int NEW_SEARCH_AREA_CONTEXT_ONLINE_POI = 1;
    public static final int NEW_SEARCH_AREA_CONTEXT_REMOTE_HMI = 2;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$di$AddressInputUtil;

    public static boolean useHousenumberFreetextSpeller(NavigationEnv navigationEnv) {
        boolean bl = false;
        if (navigationEnv != null) {
            bl = navigationEnv.getContainer().refinementCriterionAvailable(136);
            navigationEnv.getAddressInputLogChannel().log(10000000, "%1#useHousenumberFreetextSpeller - useFreetextSpeller=%2", (Object)CLASS_NAME, (Object)Boolean.toString(bl));
        }
        return bl;
    }

    public static String getLatestCharFromCommandList(CommandList commandList, NavigationEnv navigationEnv) {
        Object object = commandList.get("directWritingChar");
        String string = "";
        if (object instanceof Character) {
            string = object.toString();
        }
        if (navigationEnv != null) {
            navigationEnv.getAddressInputLogChannel().log(10000000, "%1#getLatestCharFromCommandList - extractedChar=%2", (Object)CLASS_NAME, (Object)string);
        }
        return string;
    }

    public static void setNewSearchAreaContextChoiceStatus(NavigationEnv navigationEnv, int n) {
        if (navigationEnv != null) {
            if (n == 0 || n == 1) {
                navigationEnv.getChoiceModel(401908).setStatus(n);
            } else {
                navigationEnv.getAddressInputLogChannel().log(100000, "%1#setNewSearchAreaContextChoiceStatus - received invalid status=%2", (Object)CLASS_NAME, (long)n);
            }
        }
    }

    public static void setNewSearchAreaContextChoiceValue(NavigationEnv navigationEnv, int n) {
        if (navigationEnv != null) {
            if (n == 0 || n == 1 || n == 2) {
                navigationEnv.getChoiceModel(401908).setValue(n);
            } else {
                navigationEnv.getAddressInputLogChannel().log(100000, "%1#setNewSearchAreaContextChoiceValue - received invalid value=%2", (Object)CLASS_NAME, (long)n);
            }
        }
    }

    public static int getNewSearchAreaContextChoiceValue(NavigationEnv navigationEnv) {
        if (navigationEnv != null) {
            return navigationEnv.getChoiceModel(401908).getValue();
        }
        return -1;
    }

    public static String getCurrentLanguageCode(NavigationEnv navigationEnv) {
        return navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode();
    }

    public static String formatCompleteCityNameAsiaForPoiSearchAreaLabel(NavigationEnv navigationEnv, NavLocation navLocation) {
        return AddressInputUtil.formatCompleteCityNameAsia(navigationEnv, navLocation);
    }

    public static String formatCompleteCityNameAsia(NavigationEnv navigationEnv, NavLocation navLocation) {
        LogChannel logChannel = navigationEnv.getAddressInputLogChannel();
        String string = AddressInputUtil.getCurrentLanguageCode(navigationEnv);
        String string2 = null;
        if (Util.isHURegionCN() || Util.isHURegionTW()) {
            logChannel.log(10000000, "%1#formatCompleteCityNameAsia - Region is CN/TW", (Object)CLASS_NAME);
            string2 = AddressInputUtil.formatCompleteCityNameCn(navigationEnv, navLocation, string, logChannel);
        } else if (Util.isHURegionJP()) {
            logChannel.log(10000000, "%1#formatCompleteCityNameAsia - Region is JP", (Object)CLASS_NAME);
            string2 = AddressInputUtil.formatCompleteCityNameJp(navigationEnv, navLocation, string, logChannel);
        } else if (Util.isHURegionKR()) {
            logChannel.log(10000000, "%1#formatCompleteCityNameAsia - Region is KR", (Object)CLASS_NAME);
            string2 = AddressInputUtil.formatCompleteCityNameKr(navigationEnv, navLocation, string, logChannel);
        } else {
            logChannel.log(100000, "%1#formatCompleteCityNameAsia - no valid HU region found!", (Object)CLASS_NAME);
        }
        logChannel.log(10000000, "%1#formatCompleteCityNameAsia - returning '%2'", (Object)CLASS_NAME, (Object)string2);
        return string2;
    }

    private static String formatCompleteCityNameCn(NavigationEnv navigationEnv, NavLocation navLocation, String string, LogChannel logChannel) {
        logChannel.log(10000000, "%1#formatCompleteCityName - currentLanguageCode=%2", (Object)CLASS_NAME, (Object)string);
        if ("zh_CN".equals(string) || "zh_HK".equals(string) || "zh_TW".equals(string)) {
            return AddressInputUtil.formatCompleteCityNameForChineseLanguage(navLocation, logChannel);
        }
        return AddressInputUtil.formatCompleteCityNameForCnEnglishLanguage(navLocation, logChannel);
    }

    private static String formatCompleteCityNameForChineseLanguage(NavLocation navLocation, LogChannel logChannel) {
        String string;
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string2 = iMyLocationAccessor.getTown();
        String string3 = iMyLocationAccessor.getTownRefinement();
        String string4 = iMyLocationAccessor.getState();
        boolean bl = iMyLocationAccessor.isTownOrder9();
        int n = iMyLocationAccessor.getAdditionalFlags();
        logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#formatCompleteCityNameForChineseLanguage - values -> town=%1, townRefinement=%2, state=%3, isTownOrder9=%4").toString(), (Object)string2, (Object)string3, (Object)string4, (Object)Boolean.toString(bl));
        logChannel.log(10000000, "%1#formatCompleteCityNameForChineseLanguage - additionalFlags=%2", (Object)CLASS_NAME, (long)n);
        if (!bl && n == 0x2000000) {
            string = string2;
        } else {
            Buffer buffer = new Buffer();
            if (!Util.isEmpty(string2)) {
                buffer.append(string2);
                if (!Util.isEmpty(string4)) {
                    buffer.append("(").append(string4);
                    if (!Util.isEmpty(string3) && !string3.equals(string4)) {
                        buffer.append(string3);
                    }
                    buffer.append(")");
                }
            }
            string = buffer.toString();
        }
        logChannel.log(10000000, "%1#formatCompleteCityNameForChineseLanguage - returning '%2'", (Object)CLASS_NAME, (Object)string);
        return string;
    }

    private static String formatCompleteCityNameForCnEnglishLanguage(NavLocation navLocation, LogChannel logChannel) {
        String string;
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string2 = iMyLocationAccessor.getTown();
        String string3 = iMyLocationAccessor.getTownRefinement();
        String string4 = iMyLocationAccessor.getState();
        boolean bl = iMyLocationAccessor.isTownOrder9();
        int n = iMyLocationAccessor.getAdditionalFlags();
        logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#formatCompleteCityNameForCnEnglishLanguage - values -> town=%1, townRefinement=%2, state=%3, isTownOrder9=%4").toString(), (Object)string2, (Object)string3, (Object)string4, (Object)Boolean.toString(bl));
        logChannel.log(10000000, "%1#formatCompleteCityNameForCnEnglishLanguage - additionalFlags=%2", (Object)CLASS_NAME, (long)n);
        if (!bl && n == 0x2000000) {
            string = string2;
        } else {
            Buffer buffer = new Buffer();
            if (!Util.isEmpty(string2)) {
                buffer.append(string2);
                if (!Util.isEmpty(string4)) {
                    buffer.append("(");
                    if (!Util.isEmpty(string3) && !string3.equals(string4)) {
                        buffer.append(string3).append(", ");
                    }
                    buffer.append(string4).append(")");
                }
            }
            string = buffer.toString();
        }
        logChannel.log(10000000, "%1#formatCompleteCityNameForCnEnglishLanguage - returning '%2'", (Object)CLASS_NAME, (Object)string);
        return string;
    }

    private static String formatCompleteCityNameJp(NavigationEnv navigationEnv, NavLocation navLocation, String string, LogChannel logChannel) {
        logChannel.log(10000000, "%1#formatCompleteCityNameJp - currentLanguageCode=%2", (Object)CLASS_NAME, (Object)string);
        return AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText();
    }

    private static String formatCompleteCityNameForJapaneseLanguage(NavLocation navLocation, LogChannel logChannel, NavigationEnv navigationEnv) {
        return AddressInputUtil.formatCompleteCityNameForJpEnglishLanguage(navLocation, logChannel, navigationEnv);
    }

    private static String formatCompleteCityNameForJpEnglishLanguage(NavLocation navLocation, LogChannel logChannel, NavigationEnv navigationEnv) {
        return AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText();
    }

    private static String formatCompleteCityNameKr(NavigationEnv navigationEnv, NavLocation navLocation, String string, LogChannel logChannel) {
        logChannel.log(10000000, "%1#formatCompleteCityNameKr - currentLanguageCode=%2", (Object)CLASS_NAME, (Object)string);
        return AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText();
    }

    private static String formatCompleteCityNameForKoreanLanguage(NavLocation navLocation, LogChannel logChannel, NavigationEnv navigationEnv) {
        return AddressInputUtil.formatCompleteCityNameForKrEnglishLanguage(navLocation, logChannel, navigationEnv);
    }

    private static String formatCompleteCityNameForKrEnglishLanguage(NavLocation navLocation, LogChannel logChannel, NavigationEnv navigationEnv) {
        return AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


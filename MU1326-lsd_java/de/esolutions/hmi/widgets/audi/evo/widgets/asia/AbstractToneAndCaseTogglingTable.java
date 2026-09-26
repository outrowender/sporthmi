/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractToneAndCaseTogglingTable {
    public static final int CHARACTER_STATUS_MAIN;
    public static final int CHARACTER_STATUS_TONE1;
    public static final int CHARACTER_STATUS_TONE2;
    public static final int CHARACTER_STATUS_LOWERCASE;
    private static final Map JP_CHARACTER_MAP;

    public static boolean hasToneOrCaseVariance(String string) {
        return JP_CHARACTER_MAP.containsKey(string);
    }

    public static AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase getCharWithToneAndCaseForJPLang(String string) {
        if (AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string)) {
            return (AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase)JP_CHARACTER_MAP.get(string);
        }
        IWidgetLogChannel.spellerLogChannel.log(1078071040, "ToneAndCaseTogglingTable#getCharWithToneAndCaseForJPLang : No mapping data for charater %1 available!", (Object)string);
        return null;
    }

    public static String appendMainCharacterForVariance(String string) {
        if (string != null && string.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer(string.length());
            for (int i2 = 0; i2 < string.length(); ++i2) {
                AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(String.valueOf(string.charAt(i2)));
                if (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase != null && abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatus() != 0) {
                    stringBuffer.append(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getMainChar());
                }
                stringBuffer.append(string.charAt(i2));
            }
            return stringBuffer.toString();
        }
        return string;
    }

    public static boolean hasCaseVariance(String string) {
        return AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string) && AbstractToneAndCaseTogglingTable.hasCase(string);
    }

    private static boolean hasCase(String string) {
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        if (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatus() == 3) {
            return true;
        }
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2 = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase;
        abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.getNextCharWithStatus();
        while (!abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.equals(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2)) {
            if (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatus() == 3) {
                return true;
            }
            abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
        }
        return false;
    }

    public static String getOppositeCaseCharacterAsString(String string) {
        if (!AbstractToneAndCaseTogglingTable.hasCaseVariance(string)) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "ToneAndCaseTogglingTable#getOppositeCaseCharacterAsString: No mapping data for character %1 available!", (Object)string);
            return "";
        }
        if (AbstractToneAndCaseTogglingTable.isCapitalCase(string)) {
            return AbstractToneAndCaseTogglingTable.getLowCaseLetter(string);
        }
        return AbstractToneAndCaseTogglingTable.getCapitalCaseLetter(string);
    }

    public static boolean isCapitalCase(String string) {
        if (!AbstractToneAndCaseTogglingTable.hasCaseVariance(string)) {
            IWidgetLogChannel.spellerLogChannel.log(1078071040, "ToneAndCaseTogglingTable#isCapitalCase: No mapping data for character %1 available!", (Object)string);
            return false;
        }
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        return string.charAt(0) == abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getMainChar();
    }

    public static boolean isLowCase(String string) {
        if (!AbstractToneAndCaseTogglingTable.hasCaseVariance(string)) {
            IWidgetLogChannel.spellerLogChannel.log(1078071040, "ToneAndCaseTogglingTable#isLowCase: No mapping data character %1 available!", (Object)string);
            return false;
        }
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        while (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatus() != 3) {
            abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
        }
        return string.charAt(0) == abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar();
    }

    private static String getLowCaseLetter(String string) {
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        while (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatus() != 3) {
            abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
        }
        return String.valueOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar());
    }

    private static String getCapitalCaseLetter(String string) {
        return String.valueOf(AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string).getMainChar());
    }

    public static boolean isEnabledWithNVCFilter(String string, String string2) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return false;
        }
        if (string2 == null) {
            return true;
        }
        if (string2.indexOf(string) >= 0) {
            return true;
        }
        if (AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string)) {
            AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
            AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2 = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
            while (!abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.equals(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase)) {
                if (string2.indexOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.getCurrentStatusChar()) >= 0) {
                    return true;
                }
                abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2 = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.getNextCharWithStatus();
            }
            return false;
        }
        return false;
    }

    public static String getNextValidToneOrCaseCharForJPLanguageWithNVCFilter(String string, String string2) {
        boolean bl = AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string, string2);
        if (bl) {
            AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
            if (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase != null) {
                AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2 = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase;
                abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.getNextCharWithStatus();
                while (!abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.equals(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2) && string2.indexOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar()) < 0) {
                    abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
                }
            }
            return abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase != null ? String.valueOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar()) : null;
        }
        IWidgetLogChannel.spellerLogChannel.log(1078071040, "ToneAndCaseTogglingTable#getNextValidToneOrCaseCharForJPLanguageWithNVCFilter No valid data for character %1 available with NVC criteria[%2]!", (Object)string, (Object)string2);
        return null;
    }

    public static String getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter(String string, String string2) {
        List list = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLangWithNVCFilter(string, string2);
        if (!list.isEmpty()) {
            return String.valueOf(((AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase)list.get(0)).getCurrentStatusChar());
        }
        IWidgetLogChannel.spellerLogChannel.log(1078071040, "ToneAndCaseTogglingTable#getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter : No valid data for character %1 available with NVC criteria[%2]!", (Object)string, (Object)string2);
        return null;
    }

    public static boolean hasToneOrCaseVariance(String string, String string2) {
        List list = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLangWithNVCFilter(string, string2);
        return list.size() > 1;
    }

    private static List getCharWithToneAndCaseForJPLangWithNVCFilter(String string, String string2) {
        ArrayList arrayList = new ArrayList();
        AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        if (abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase != null && string2 != null) {
            if (string2.indexOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar()) >= 0) {
                arrayList.add(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase);
            }
            AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2 = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase;
            abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2.getNextCharWithStatus();
            while (!abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.equals(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase2)) {
                if (string2.indexOf(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getCurrentStatusChar()) >= 0) {
                    arrayList.add(abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase);
                }
                abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase = abstractToneAndCaseTogglingTable$ICharacterWithToneAndCase.getNextCharWithStatus();
            }
        }
        return arrayList;
    }

    private static AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus createJPCharacterWrapperWithStatus(char c2, char c3, char c4, char c5) {
        AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus;
        AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2;
        AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3 = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2 = new AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(c2, 0, null);
        if (c3 != '\u0000') {
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = new AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(c3, 1, null);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$102(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$202(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3 = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus;
        }
        if (c4 != '\u0000') {
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = new AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(c4, 2, null);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$102(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$202(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3 = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus;
        }
        if (c5 != '\u0000') {
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = new AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(c5, 3, null);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$102(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2);
            AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$202(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
            abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3 = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus;
        }
        AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$202(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus3, abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2);
        return abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2;
    }

    static {
        JP_CHARACTER_MAP = new HashMap();
        AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3046', '\u3094', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3046", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3094", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304b', '\u304c', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304b", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u304c", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304d', '\u304e', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304d", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u304e", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304f', '\u3050', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304f", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3050", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3051', '\u3052', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3051", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3052", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3053', '\u3054', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3053", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3054", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3055', '\u3056', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3055", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3056", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3057', '\u3058', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3057", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3058", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3059', '\u305a', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3059", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305a", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305b', '\u305c', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305b", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305c", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305d', '\u305e', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305d", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305e", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305f', '\u3060', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305f", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3060", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3061', '\u3062', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3061", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3062", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3064', '\u3065', '\u0000', '\u3063');
        JP_CHARACTER_MAP.put("\u3064", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3065", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u3063", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3068', '\u3069', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3068", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3069", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u306f', '\u3070', '\u3071', '\u0000');
        JP_CHARACTER_MAP.put("\u306f", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3070", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u3071", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3072', '\u3073', '\u3074', '\u0000');
        JP_CHARACTER_MAP.put("\u3072", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3073", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u3074", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3075', '\u3076', '\u3077', '\u0000');
        JP_CHARACTER_MAP.put("\u3075", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3076", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u3077", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3078', '\u3079', '\u307a', '\u0000');
        JP_CHARACTER_MAP.put("\u3078", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3079", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u307a", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u307b', '\u307c', '\u307d', '\u0000');
        JP_CHARACTER_MAP.put("\u307b", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u307c", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        JP_CHARACTER_MAP.put("\u307d", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus)));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3084', '\u0000', '\u0000', '\u3083');
        JP_CHARACTER_MAP.put("\u3084", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3083", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3086', '\u0000', '\u0000', '\u3085');
        JP_CHARACTER_MAP.put("\u3086", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3085", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3088', '\u0000', '\u0000', '\u3087');
        JP_CHARACTER_MAP.put("\u3088", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3087", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a2', '\u0000', '\u0000', '\u30a1');
        JP_CHARACTER_MAP.put("\u30a2", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a1", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a4', '\u0000', '\u0000', '\u30a3');
        JP_CHARACTER_MAP.put("\u30a4", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a3", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a6', '\u0000', '\u0000', '\u30a5');
        JP_CHARACTER_MAP.put("\u30a6", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a5", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a8', '\u0000', '\u0000', '\u30a7');
        JP_CHARACTER_MAP.put("\u30a8", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a7", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30aa', '\u0000', '\u0000', '\u30a9');
        JP_CHARACTER_MAP.put("\u30aa", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a9", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30c4', '\u0000', '\u0000', '\u30c3');
        JP_CHARACTER_MAP.put("\u30c4", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30c3", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e4', '\u0000', '\u0000', '\u30e3');
        JP_CHARACTER_MAP.put("\u30e4", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e3", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e6', '\u0000', '\u0000', '\u30e5');
        JP_CHARACTER_MAP.put("\u30e6", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e5", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e8', '\u0000', '\u0000', '\u30e7');
        JP_CHARACTER_MAP.put("\u30e8", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e7", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30ef', '\u0000', '\u0000', '\u30ee');
        JP_CHARACTER_MAP.put("\u30ef", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30ee", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3066', '\u3067', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3066", abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3067", AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.access$200(abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus));
    }
}


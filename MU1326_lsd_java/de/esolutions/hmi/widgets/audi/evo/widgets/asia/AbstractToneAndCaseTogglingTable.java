/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractToneAndCaseTogglingTable {
    public static final int CHARACTER_STATUS_MAIN = 0;
    public static final int CHARACTER_STATUS_TONE1 = 1;
    public static final int CHARACTER_STATUS_TONE2 = 2;
    public static final int CHARACTER_STATUS_LOWERCASE = 3;
    private static final Map JP_CHARACTER_MAP = new HashMap();

    public static boolean hasToneOrCaseVariance(String string) {
        return JP_CHARACTER_MAP.containsKey(string);
    }

    public static ICharacterWithToneAndCase getCharWithToneAndCaseForJPLang(String string) {
        if (AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string)) {
            return (ICharacterWithToneAndCase)JP_CHARACTER_MAP.get(string);
        }
        IWidgetLogChannel.spellerLogChannel.log(1000000, "ToneAndCaseTogglingTable#getCharWithToneAndCaseForJPLang : No mapping data for charater %1 available!", (Object)string);
        return null;
    }

    public static String appendMainCharacterForVariance(String string) {
        if (string != null && string.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer(string.length());
            for (int i2 = 0; i2 < string.length(); ++i2) {
                ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(String.valueOf(string.charAt(i2)));
                if (iCharacterWithToneAndCase != null && iCharacterWithToneAndCase.getCurrentStatus() != 0) {
                    stringBuffer.append(iCharacterWithToneAndCase.getMainChar());
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
        ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        if (iCharacterWithToneAndCase.getCurrentStatus() == 3) {
            return true;
        }
        ICharacterWithToneAndCase iCharacterWithToneAndCase2 = iCharacterWithToneAndCase;
        iCharacterWithToneAndCase = iCharacterWithToneAndCase2.getNextCharWithStatus();
        while (!iCharacterWithToneAndCase.equals(iCharacterWithToneAndCase2)) {
            if (iCharacterWithToneAndCase.getCurrentStatus() == 3) {
                return true;
            }
            iCharacterWithToneAndCase = iCharacterWithToneAndCase.getNextCharWithStatus();
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
            IWidgetLogChannel.spellerLogChannel.log(1000000, "ToneAndCaseTogglingTable#isCapitalCase: No mapping data for character %1 available!", (Object)string);
            return false;
        }
        ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        return string.charAt(0) == iCharacterWithToneAndCase.getMainChar();
    }

    public static boolean isLowCase(String string) {
        if (!AbstractToneAndCaseTogglingTable.hasCaseVariance(string)) {
            IWidgetLogChannel.spellerLogChannel.log(1000000, "ToneAndCaseTogglingTable#isLowCase: No mapping data character %1 available!", (Object)string);
            return false;
        }
        ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        while (iCharacterWithToneAndCase.getCurrentStatus() != 3) {
            iCharacterWithToneAndCase = iCharacterWithToneAndCase.getNextCharWithStatus();
        }
        return string.charAt(0) == iCharacterWithToneAndCase.getCurrentStatusChar();
    }

    private static String getLowCaseLetter(String string) {
        ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        while (iCharacterWithToneAndCase.getCurrentStatus() != 3) {
            iCharacterWithToneAndCase = iCharacterWithToneAndCase.getNextCharWithStatus();
        }
        return String.valueOf(iCharacterWithToneAndCase.getCurrentStatusChar());
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
            ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
            ICharacterWithToneAndCase iCharacterWithToneAndCase2 = iCharacterWithToneAndCase.getNextCharWithStatus();
            while (!iCharacterWithToneAndCase2.equals(iCharacterWithToneAndCase)) {
                if (string2.indexOf(iCharacterWithToneAndCase2.getCurrentStatusChar()) >= 0) {
                    return true;
                }
                iCharacterWithToneAndCase2 = iCharacterWithToneAndCase2.getNextCharWithStatus();
            }
            return false;
        }
        return false;
    }

    public static String getNextValidToneOrCaseCharForJPLanguageWithNVCFilter(String string, String string2) {
        boolean bl = AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string, string2);
        if (bl) {
            ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
            if (iCharacterWithToneAndCase != null) {
                ICharacterWithToneAndCase iCharacterWithToneAndCase2 = iCharacterWithToneAndCase;
                iCharacterWithToneAndCase = iCharacterWithToneAndCase2.getNextCharWithStatus();
                while (!iCharacterWithToneAndCase.equals(iCharacterWithToneAndCase2) && string2.indexOf(iCharacterWithToneAndCase.getCurrentStatusChar()) < 0) {
                    iCharacterWithToneAndCase = iCharacterWithToneAndCase.getNextCharWithStatus();
                }
            }
            return iCharacterWithToneAndCase != null ? String.valueOf(iCharacterWithToneAndCase.getCurrentStatusChar()) : null;
        }
        IWidgetLogChannel.spellerLogChannel.log(1000000, "ToneAndCaseTogglingTable#getNextValidToneOrCaseCharForJPLanguageWithNVCFilter No valid data for character %1 available with NVC criteria[%2]!", (Object)string, (Object)string2);
        return null;
    }

    public static String getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter(String string, String string2) {
        List list = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLangWithNVCFilter(string, string2);
        if (!list.isEmpty()) {
            return String.valueOf(((ICharacterWithToneAndCase)list.get(0)).getCurrentStatusChar());
        }
        IWidgetLogChannel.spellerLogChannel.log(1000000, "ToneAndCaseTogglingTable#getFirstValidToneOrCaseCharForJPLanguageWithNVCFilter : No valid data for character %1 available with NVC criteria[%2]!", (Object)string, (Object)string2);
        return null;
    }

    public static boolean hasToneOrCaseVariance(String string, String string2) {
        List list = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLangWithNVCFilter(string, string2);
        return list.size() > 1;
    }

    private static List getCharWithToneAndCaseForJPLangWithNVCFilter(String string, String string2) {
        ArrayList arrayList = new ArrayList();
        ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string);
        if (iCharacterWithToneAndCase != null && string2 != null) {
            if (string2.indexOf(iCharacterWithToneAndCase.getCurrentStatusChar()) >= 0) {
                arrayList.add(iCharacterWithToneAndCase);
            }
            ICharacterWithToneAndCase iCharacterWithToneAndCase2 = iCharacterWithToneAndCase;
            iCharacterWithToneAndCase = iCharacterWithToneAndCase2.getNextCharWithStatus();
            while (!iCharacterWithToneAndCase.equals(iCharacterWithToneAndCase2)) {
                if (string2.indexOf(iCharacterWithToneAndCase.getCurrentStatusChar()) >= 0) {
                    arrayList.add(iCharacterWithToneAndCase);
                }
                iCharacterWithToneAndCase = iCharacterWithToneAndCase.getNextCharWithStatus();
            }
        }
        return arrayList;
    }

    private static JPCharacterWrapperWithStatus createJPCharacterWrapperWithStatus(char c2, char c3, char c4, char c5) {
        JPCharacterWrapperWithStatus jPCharacterWrapperWithStatus;
        JPCharacterWrapperWithStatus jPCharacterWrapperWithStatus2;
        JPCharacterWrapperWithStatus jPCharacterWrapperWithStatus3 = jPCharacterWrapperWithStatus2 = new JPCharacterWrapperWithStatus(c2, 0);
        if (c3 != '\u0000') {
            jPCharacterWrapperWithStatus = new JPCharacterWrapperWithStatus(c3, 1);
            jPCharacterWrapperWithStatus.mainCharWithStatus = jPCharacterWrapperWithStatus2;
            jPCharacterWrapperWithStatus3.nextCharWithStatus = jPCharacterWrapperWithStatus;
            jPCharacterWrapperWithStatus3 = jPCharacterWrapperWithStatus;
        }
        if (c4 != '\u0000') {
            jPCharacterWrapperWithStatus = new JPCharacterWrapperWithStatus(c4, 2);
            jPCharacterWrapperWithStatus.mainCharWithStatus = jPCharacterWrapperWithStatus2;
            jPCharacterWrapperWithStatus3.nextCharWithStatus = jPCharacterWrapperWithStatus;
            jPCharacterWrapperWithStatus3 = jPCharacterWrapperWithStatus;
        }
        if (c5 != '\u0000') {
            jPCharacterWrapperWithStatus = new JPCharacterWrapperWithStatus(c5, 3);
            jPCharacterWrapperWithStatus.mainCharWithStatus = jPCharacterWrapperWithStatus2;
            jPCharacterWrapperWithStatus3.nextCharWithStatus = jPCharacterWrapperWithStatus;
            jPCharacterWrapperWithStatus3 = jPCharacterWrapperWithStatus;
        }
        jPCharacterWrapperWithStatus3.nextCharWithStatus = jPCharacterWrapperWithStatus2;
        return jPCharacterWrapperWithStatus2;
    }

    static {
        JPCharacterWrapperWithStatus jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3046', '\u3094', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3046", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3094", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304b', '\u304c', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304b", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u304c", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304d', '\u304e', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304d", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u304e", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u304f', '\u3050', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u304f", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3050", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3051', '\u3052', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3051", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3052", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3053', '\u3054', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3053", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3054", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3055', '\u3056', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3055", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3056", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3057', '\u3058', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3057", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3058", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3059', '\u305a', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3059", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305a", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305b', '\u305c', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305b", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305c", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305d', '\u305e', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305d", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u305e", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u305f', '\u3060', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u305f", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3060", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3061', '\u3062', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3061", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3062", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3064', '\u3065', '\u0000', '\u3063');
        JP_CHARACTER_MAP.put("\u3064", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3065", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u3063", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3068', '\u3069', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3068", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3069", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u306f', '\u3070', '\u3071', '\u0000');
        JP_CHARACTER_MAP.put("\u306f", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3070", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u3071", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3072', '\u3073', '\u3074', '\u0000');
        JP_CHARACTER_MAP.put("\u3072", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3073", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u3074", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3075', '\u3076', '\u3077', '\u0000');
        JP_CHARACTER_MAP.put("\u3075", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3076", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u3077", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3078', '\u3079', '\u307a', '\u0000');
        JP_CHARACTER_MAP.put("\u3078", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3079", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u307a", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u307b', '\u307c', '\u307d', '\u0000');
        JP_CHARACTER_MAP.put("\u307b", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u307c", jPCharacterWrapperWithStatus.nextCharWithStatus);
        JP_CHARACTER_MAP.put("\u307d", jPCharacterWrapperWithStatus.nextCharWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3084', '\u0000', '\u0000', '\u3083');
        JP_CHARACTER_MAP.put("\u3084", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3083", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3086', '\u0000', '\u0000', '\u3085');
        JP_CHARACTER_MAP.put("\u3086", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3085", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3088', '\u0000', '\u0000', '\u3087');
        JP_CHARACTER_MAP.put("\u3088", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3087", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a2', '\u0000', '\u0000', '\u30a1');
        JP_CHARACTER_MAP.put("\u30a2", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a1", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a4', '\u0000', '\u0000', '\u30a3');
        JP_CHARACTER_MAP.put("\u30a4", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a3", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a6', '\u0000', '\u0000', '\u30a5');
        JP_CHARACTER_MAP.put("\u30a6", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a5", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30a8', '\u0000', '\u0000', '\u30a7');
        JP_CHARACTER_MAP.put("\u30a8", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a7", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30aa', '\u0000', '\u0000', '\u30a9');
        JP_CHARACTER_MAP.put("\u30aa", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30a9", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30c4', '\u0000', '\u0000', '\u30c3');
        JP_CHARACTER_MAP.put("\u30c4", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30c3", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e4', '\u0000', '\u0000', '\u30e3');
        JP_CHARACTER_MAP.put("\u30e4", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e3", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e6', '\u0000', '\u0000', '\u30e5');
        JP_CHARACTER_MAP.put("\u30e6", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e5", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30e8', '\u0000', '\u0000', '\u30e7');
        JP_CHARACTER_MAP.put("\u30e8", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30e7", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u30ef', '\u0000', '\u0000', '\u30ee');
        JP_CHARACTER_MAP.put("\u30ef", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u30ee", jPCharacterWrapperWithStatus.nextCharWithStatus);
        jPCharacterWrapperWithStatus = AbstractToneAndCaseTogglingTable.createJPCharacterWrapperWithStatus('\u3066', '\u3067', '\u0000', '\u0000');
        JP_CHARACTER_MAP.put("\u3066", jPCharacterWrapperWithStatus);
        JP_CHARACTER_MAP.put("\u3067", jPCharacterWrapperWithStatus.nextCharWithStatus);
    }

    public static interface ICharacterWithToneAndCase {
        public int getCurrentStatus();

        public ICharacterWithToneAndCase getNextCharWithStatus();

        public ICharacterWithToneAndCase getMainCharWithStatus();

        public char getCurrentStatusChar();

        public char getMainChar();
    }

    private static class JPCharacterWrapperWithStatus
    implements ICharacterWithToneAndCase {
        private final char charValue;
        private final int status;
        private JPCharacterWrapperWithStatus mainCharWithStatus;
        private JPCharacterWrapperWithStatus nextCharWithStatus;

        private JPCharacterWrapperWithStatus(char c2, int n) {
            this.charValue = c2;
            this.status = n;
        }

        public int getCurrentStatus() {
            return this.status;
        }

        public ICharacterWithToneAndCase getNextCharWithStatus() {
            return this.nextCharWithStatus;
        }

        public char getCurrentStatusChar() {
            return this.charValue;
        }

        public char getMainChar() {
            if (null == this.mainCharWithStatus) {
                this.mainCharWithStatus = this;
            }
            return this.mainCharWithStatus.charValue;
        }

        public ICharacterWithToneAndCase getMainCharWithStatus() {
            return this.mainCharWithStatus;
        }
    }
}


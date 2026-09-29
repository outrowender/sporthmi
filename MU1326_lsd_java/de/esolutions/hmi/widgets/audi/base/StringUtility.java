/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class StringUtility
implements Alignment {
    public static final int MAX_CHARACTER_PER_LINE;
    private static final char REPLACE_TOKEN;
    public static final char AUTO_COUNT_TOKEN;
    private static final char AUTO_COUNT_ZERO;
    private static final char AUTO_COUNT_ONE;
    private static final char AUTO_COUNT_ZERO_ZERO;
    private static final char AUTO_COUNT_ZERO_ONE;
    private static final int MAX_CHARS;
    public static final char ELLIPSIS;
    public static final char EMPTY_SPACE;
    public static final String SPACE;
    public static final char ESO_LTR_SPACE;
    public static final char ESO_RTL_SPACE;
    public static final char LA_CHAR_1;
    public static final char LA_CHAR_2;
    public static final char LA_CHAR_3;
    public static final char LA_CHAR_4;
    public static final String LA_STRING_1;
    public static final String LA_STRING_2;
    public static final String LA_STRING_3;
    public static final String LA_STRING_4;
    public static final char HYPHEN;
    public static final char COMMA;
    public static final char SLASH;
    public static final char BACKSLASH;
    public static final char DOT;
    public static final char COLON;
    public static final char SEMICOLON;
    public static final char UNDERLINE;
    public static final char NEW_LINE;
    public static final char BACKSPACE;
    public static final char CARRIAGE_RETURN;
    public static final char CONDENSED_CHAR_OFFSET;
    public static final char NULL_CHAR;
    public static final char BULLET;
    public static final char FULL_WIDTH_FULL_STOP;
    public static final int WRAP_MODE_STANDARD;
    public static final int WRAP_MODE_SDS;
    public static final int WRAP_MODE_FREETEXT_INPUT;
    private static final Buffer REUSED_CONCAT_BUFFER;
    public static final String LTR_MARK;
    public static final char LTR_MARK_CHAR;
    public static final String RTL_MARK;
    public static final char RTL_MARK_CHAR;
    public static final String RTL_AND_LTR_MARK;
    public static final int ORIENTATION_HINT_NONE;
    public static final int ORIENTATION_HINT_LTR;
    public static final int ORIENTATION_HINT_RTL;
    public static final int ORIENTATION_HINT_LTR_IN_LTR_CONTEXT;
    public static final int ORIENTATION_HINT_LTR_IN_RTL_CONTEXT;
    public static final int ORIENTATION_HINT_RTL_IN_LTR_CONTEXT;
    public static final int ORIENTATION_HINT_RTL_IN_RTL_CONTEXT;
    public static final int ORIENTATION_HINT_RTL_IN_RTL_CONTEXT_WITHOUT_REPLACEMENTS;
    public static final int CONTEXT_TYPE_NONE;
    public static final int CONTEXT_TYPE_ARABIC;
    public static final int CONTEXT_TYPE_LATIN;
    public static final int CONTEXT_TYPE_DIGIT;
    public static final int ORIENTATION_HINT_CURRENT;
    public static final int ORIENTATION_HINT_OPPOSITE_TO_CURRENT;
    public static final int ORIENTATION_HINT_RTL_AND_LTR_IN_RTL_CONTEXT;
    protected Buffer strBuffer = new Buffer(128);
    private final char[] currentString = new char[257];
    protected HMITerminalImpl terminal;

    protected StringUtility(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    public String abbreviateTextEllipsis(String string, int n, boolean bl) {
        return this.abbreviateText(string, n, bl, true);
    }

    public String abbreviateText(String string, int n, boolean bl, boolean bl2) {
        int n2;
        if (this.getStringWidth(string) <= n) {
            return string;
        }
        String string2 = null;
        int n3 = string.length();
        if (n3 < 256) {
            string.getChars(0, n3, this.currentString, 0);
        } else {
            string.getChars(0, 256, this.currentString, 0);
            n3 = 256;
        }
        int n4 = this.getCharWidth('\u2026');
        int n5 = n2 = n3;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        if (!bl) {
            if (n <= n4) {
                n2 = 0;
            } else {
                for (int i2 = 0; i2 < 50; ++i2) {
                    int n9 = this.getStringWidth(this.currentString, 0, n2);
                    if (n9 + n4 <= n) {
                        n7 = n2;
                    } else {
                        n5 = n2;
                    }
                    n2 = (n5 + n7) / 2;
                    if (n7 == n8 && n5 == n6) {
                        n2 = n7;
                        break;
                    }
                    n6 = n5;
                    n8 = n7;
                }
                if (bl2) {
                    this.currentString[n2++] = 8230;
                }
            }
            string2 = new String(this.currentString, 0, n2);
        } else {
            int n10 = 0;
            if (n <= n4) {
                n3 = 0;
            } else {
                for (int i3 = 0; i3 < 50; ++i3) {
                    int n11 = this.getStringWidth(this.currentString, n10, n3 - n10);
                    if (n11 + n4 <= n) {
                        n5 = n10;
                    } else {
                        n7 = n10;
                    }
                    n10 = (n5 + n7) / 2;
                    if (n7 == n8 && n5 == n6) {
                        n10 = n7;
                        break;
                    }
                    n6 = n5;
                    n8 = n7;
                }
                if (bl2) {
                    this.currentString[n10] = 8230;
                }
            }
            string2 = new String(this.currentString, n10, n3 - n10);
        }
        return string2;
    }

    public abstract int getCharWidth(char c2) {
    }

    public abstract int getStringWidth(String string) {
    }

    protected abstract int getStringWidth(char[] cArray, int n, int n2) {
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray, int n) {
        return this.processTextReplacement(string, hMIService, nArray, null, n, null, null, true);
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray) {
        return this.processTextReplacement(string, hMIService, nArray, null, 0, null, null, true);
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray, int[] nArray2, int n) {
        return this.processTextReplacement(string, hMIService, nArray, nArray2, n, null, null, true);
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray, int[] nArray2, int n, int[] nArray3, int[] nArray4, boolean bl) {
        return this.processTextReplacement(string, hMIService, nArray, nArray2, null, n, nArray3, nArray4, bl);
    }

    public String processTextReplacement(String string, HMIService hMIService, int[] nArray, int[] nArray2, int n, int[] nArray3, boolean bl) {
        return this.processTextReplacement(string, hMIService, nArray, nArray2, n, null, nArray3, bl);
    }

    private String processTextReplacement(String string, HMIService hMIService, int[] nArray, int[] nArray2, int[] nArray3, int n, int[] nArray4, int[] nArray5, boolean bl) {
        if (string == null) {
            return string;
        }
        this.strBuffer.clear();
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            int n4 = 0;
            if (c2 == '%') {
                this.strBuffer.append(string.substring(n2, i2));
                n2 = i2;
                n3 = 1;
                continue;
            }
            if (n3 == 1 && c2 == 'I') {
                n3 = 2;
                continue;
            }
            if (n3 == 1 && Character.isDigit(c2)) {
                int n5 = c2 - 48;
                if (nArray5 != null && ++n4 < nArray5.length) {
                    this.strBuffer.append(StringUtility.getTextOrientationHintString(nArray5[n4], bl));
                } else {
                    this.strBuffer.append(StringUtility.getTextOrientationHintString(6, bl));
                }
                this.appendTextReplacementByIndex(n5, hMIService, nArray, nArray2, nArray3, nArray4);
                n2 = i2 + 1;
                n3 = 0;
                continue;
            }
            if (n3 == 2 && Character.isDigit(c2)) {
                this.appendAutoCounter(n, c2);
                n2 = i2 + 1;
                n3 = 0;
                continue;
            }
            n3 = 0;
        }
        if (n2 == 0) {
            return string;
        }
        this.strBuffer.append(string.substring(n2));
        return this.strBuffer.toString();
    }

    public static boolean isArabicChar(char c2) {
        char c3 = c2;
        boolean bl = c2 == '\u200f' || c2 == '\u05f0' || c3 >= '\u0600' && c3 <= '\u06ff' || c3 >= '\u50fb0000' && c3 <= '\ufffd0000' || c3 >= '\u70fe0000' && c3 <= '\ufffe0000';
        return bl;
    }

    public static boolean isLatinChar(char c2) {
        return c2 == '\uf2f20000' || Character.isLetter(c2) && !StringUtility.isArabicChar(c2);
    }

    public static int[] getTextContext(String string) {
        int[] nArray = new int[]{0, 0};
        if (string.length() > 0) {
            for (int i2 = string.length() - 1; i2 >= 0; --i2) {
                char c2 = string.charAt(i2);
                if (Character.isLetter(c2)) {
                    nArray[0] = StringUtility.isArabicChar(c2) ? 1 : 2;
                    nArray[1] = i2;
                    break;
                }
                if (!Character.isDigit(c2)) continue;
                nArray[0] = 3;
                nArray[1] = i2;
                break;
            }
        }
        return nArray;
    }

    private void appendAutoCounter(int n, char c2) {
        switch (c2) {
            case '0': {
                this.strBuffer.append(n);
                break;
            }
            case '1': {
                this.strBuffer.append(n + 1);
                break;
            }
            case '2': {
                if (n < 10) {
                    this.strBuffer.append('0');
                }
                this.strBuffer.append(n);
                break;
            }
            case '3': {
                if (n < 10) {
                    this.strBuffer.append('0');
                }
                this.strBuffer.append(n + 1);
                break;
            }
            default: {
                AbstractWidget.logChannel.log(10000, "Default: %1", c2);
            }
        }
    }

    private void appendTextReplacementByIndex(int n, HMIService hMIService, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        if (hMIService == null) {
            if (nArray3 != null && nArray3.length > 0) {
                int n2 = n - 1;
                if (nArray3.length == 1 && n2 != 0) {
                    AbstractWidget.logChannel.log(-1601830656, "StringUtility#processString illegal replacementIndex %1 for single fixed value", (long)n2);
                    n2 = 0;
                }
                int n3 = nArray3[n2];
                this.strBuffer.append(n3);
            }
            return;
        }
        HMIModelGUI hMIModelGUI = null;
        if (0 <= n - 1 && n - 1 < nArray.length) {
            hMIModelGUI = hMIService.getModel(this.terminal.getTerminalID(), nArray[n - 1]);
        } else {
            AbstractWidget.logChannel.log(10000, "StringUtility#processString There's no model for placeholder with index: %1 present", (long)(n - 1));
        }
        if (hMIModelGUI != null) {
            switch (hMIModelGUI.getModelType()) {
                case 3: {
                    String string = ((LabelModelGUI)((Object)hMIModelGUI)).getText();
                    if (nArray4 != null) {
                        string = this.processReplacementMaxWidth(n - 1, string, nArray4);
                    }
                    if (string == null) break;
                    this.strBuffer.append(string);
                    break;
                }
                case 2: {
                    int n4 = ((ChoiceModelGUI)hMIModelGUI).getValue();
                    if (nArray2 != null) {
                        if (0 <= n4 && n4 < nArray2.length) {
                            String string = this.terminal.getViewSizeManager() != null ? hMIService.getText(nArray2[n4], this.terminal.getViewSizeManager().getCurrentViewSize()) : hMIService.getText(nArray2[n4]);
                            if (nArray4 != null) {
                                string = this.processReplacementMaxWidth(n - 1, string, nArray4);
                            }
                            if (string != null) {
                                this.strBuffer.append(string);
                                break;
                            }
                            AbstractWidget.logChannel.log(-1601830656, "StringUtility#processTextReplacement mapped choice model. textID is: %1 replacementText is null", (long)nArray2[n4]);
                            this.strBuffer.append(' ');
                            break;
                        }
                        AbstractWidget.logChannel.log(-1601830656, "StringUtility#processTextReplacement mapped choice model. index: %1 is out of range: 0..%2", (long)n4, (long)nArray2.length);
                        this.strBuffer.append(' ');
                        break;
                    }
                    this.replaceChoiceIndex(n4);
                    break;
                }
                case 5: {
                    this.strBuffer.append(((RangeModelGUI)hMIModelGUI).getValue());
                    break;
                }
                case 8: {
                    this.strBuffer.append(((TextfieldModelGUI)hMIModelGUI).getText1());
                    break;
                }
                case 9: {
                    AbstractMetrics abstractMetrics = ((MetricsModelGUI)((Object)hMIModelGUI)).getMetric();
                    if (abstractMetrics == null) break;
                    this.strBuffer.append(abstractMetrics.format());
                    break;
                }
                case 4: {
                    AbstractWidget.logChannel.log(10000, "TokenReplacer#processString - ListModel not supported at this time");
                    break;
                }
                default: {
                    AbstractWidget.logChannel.log(10000, "TokenReplacer#processString default part...");
                }
            }
        }
    }

    public String processTextReplacement(String string, int[] nArray) {
        return this.processTextReplacement(string, null, null, null, nArray, 0, null, null, true);
    }

    public String processTextReplacement(String string, int n) {
        return this.processTextReplacement(string, new int[]{n});
    }

    private String processReplacementMaxWidth(int n, String string, int[] nArray) {
        if (string != null) {
            if (0 <= n && n < nArray.length) {
                int n2 = nArray[n];
                string = this.abbreviateTextEllipsis(string, n2, false);
            } else if (nArray.length > 0) {
                AbstractWidget.logChannel.log(-1601830656, "StringUtility#processReplacementMaxWidth replacementMaxWidth array has insufficient length: %1 value for index %2 requested, taking value for index 0 instead", (long)nArray.length, (long)n);
                int n3 = nArray[0];
                string = this.abbreviateTextEllipsis(string, n3, false);
            } else {
                AbstractWidget.logChannel.log(10000, "StringUtility#processReplacementMaxWidth arrayIndex: %1", (long)n);
            }
        } else {
            AbstractWidget.logChannel.log(1078071040, "StringUtility#processReplacementMaxWidth modelText is null. modelText: %1", (Object)string);
        }
        return string;
    }

    public List wrapOnLineBreak(String string, char c2) {
        ArrayList arrayList = new ArrayList(5);
        if (string != null) {
            if (string.indexOf(c2) == -1) {
                arrayList.add(string);
            } else {
                boolean bl;
                int n = 0;
                int n2 = string.indexOf(c2, n);
                boolean bl2 = bl = c2 == '\n';
                while (n2 != -1) {
                    if (n == n2) {
                        arrayList.add("");
                    } else {
                        char c3;
                        String string2 = null;
                        int n3 = n2;
                        if (bl && n2 - n > 0 && (c3 = string.charAt(n2 - 1)) == '\r') {
                            n3 = n2 - 1;
                        }
                        string2 = string.substring(n, n3);
                        arrayList.add(string2);
                    }
                    for (n = n2 + 1; n < string.length() && string.charAt(n) == ' '; ++n) {
                    }
                    if (n >= string.length()) break;
                    n2 = string.indexOf(c2, n);
                }
                if (n < string.length()) {
                    arrayList.add(string.substring(n));
                }
            }
        } else {
            AbstractWidget.logChannel.log(10000, "StringUtility#wrapOnLineBreak text is null");
        }
        return arrayList;
    }

    public String[] wrapText(String string, int n, int n2, int n3) {
        if (!StringUtility.checkParameters(string, n)) {
            return new String[]{"Text could not be wrapped"};
        }
        List list = this.wrapOnLineBreak(string, '\n');
        int n4 = 0;
        this.wrapLine(list, n4, n, n2, n3);
        ++n4;
        while (n4 < list.size()) {
            this.wrapLine(list, n4, n2, n2, n3);
            ++n4;
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    private static boolean checkParameters(String string, int n) {
        if (string == null) {
            AbstractWidget.logChannel.log(10000, "StringUtility#wrapText text is null");
            return false;
        }
        if (n < 0) {
            AbstractWidget.logChannel.log(10000, "StringUtility#wrapText width for first row < 0");
            return false;
        }
        return true;
    }

    private int getLastFittingPosition(char[] cArray, int n) {
        int n2 = cArray.length;
        if (n2 > 1024) {
            n2 = 1024;
        }
        int n3 = -1;
        int n4 = n2 / 2;
        int n5 = n2;
        while (n4 > n3 && n4 < n2) {
            int n6 = this.getStringWidth(cArray, 0, n4 + 1);
            if (n6 > n) {
                n5 = n4;
                if (n4 - n3 > 1) {
                    n4 -= (n4 - n3) / 2;
                    continue;
                }
                --n4;
                continue;
            }
            n3 = n4;
            if (n5 - n4 > 1) {
                n4 += (n5 - n4) / 2;
                continue;
            }
            ++n4;
        }
        return n3;
    }

    private int getWrapPosition(char[] cArray, int n, int n2) {
        if (n2 == 1) {
            return StringUtility.getWrapPositionSDS(cArray, n);
        }
        if (this.isAsia()) {
            return StringUtility.getWrapPositionStandardAsia(cArray, n, n2);
        }
        return StringUtility.getWrapPositionStandard(cArray, n, n2);
    }

    private static int getWrapPositionStandardAsia(char[] cArray, int n, int n2) {
        for (int i2 = n; i2 > -1; --i2) {
            char c2 = cArray[i2];
            boolean bl = StringUtility.isValidTerm(c2);
            if (!bl) {
                boolean bl2;
                boolean bl3 = bl2 = cArray.length > i2 + 1 && cArray[i2 + 1] == ' ';
                if (n2 == 2 || !bl2) continue;
                return i2 + 1;
            }
            return i2;
        }
        if (cArray.length > 0 && cArray.length == n + 1) {
            return n;
        }
        return -1;
    }

    private static boolean isValidTerm(char c2) {
        if (c2 == ' ') {
            return true;
        }
        return StringUtility.isAsiaCharacter(c2);
    }

    public static boolean isAsiaCharacter(char c2) {
        return Character$UnicodeBlock.of(c2) == Character$UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || Character$UnicodeBlock.of(c2) == Character$UnicodeBlock.HIRAGANA || Character$UnicodeBlock.of(c2) == Character$UnicodeBlock.KATAKANA;
    }

    public static boolean isFullWidthAsiaCharacter(char c2) {
        return StringUtility.isAsiaCharacter(c2);
    }

    private static int getWrapPositionStandard(char[] cArray, int n, int n2) {
        for (int i2 = n; i2 > -1; --i2) {
            boolean bl;
            switch (cArray[i2]) {
                case ' ': {
                    return i2;
                }
                case '-': {
                    return i2;
                }
                case ',': {
                    return i2;
                }
                case '/': {
                    return i2;
                }
                case '\\': {
                    return i2;
                }
                case '.': {
                    return i2;
                }
                case ':': {
                    return i2;
                }
                case ';': {
                    return i2;
                }
            }
            boolean bl2 = bl = cArray.length > i2 + 1 && cArray[i2 + 1] == ' ';
            if (n2 == 2 || !bl) continue;
            return i2 + 1;
        }
        if (cArray.length > 0 && cArray.length == n + 1) {
            return n;
        }
        return -1;
    }

    private static int getWrapPositionSDS(char[] cArray, int n) {
        return -1;
    }

    private void wrapLine(List list, int n, int n2, int n3, int n4) {
        boolean bl;
        String string = (String)list.get(n);
        int n5 = string.length();
        if (n5 == 0) {
            return;
        }
        if (n5 > 90) {
            n5 = 90;
        }
        char[] cArray = new char[n5];
        string.getChars(0, n5, cArray, 0);
        int n6 = this.getStringWidth(cArray, 0, n5);
        if (n6 <= n2) {
            return;
        }
        int n7 = this.getLastFittingPosition(cArray, n2);
        boolean bl2 = bl = n3 > n2;
        if (n7 == -1) {
            if (bl) {
                list.add(n, "");
            } else {
                AbstractWidget.logChannel.log(10000, "StringUtility#wrapLine not enough space to show one character of text: %1", (Object)cArray);
            }
        } else {
            int n8 = this.getWrapPosition(cArray, n7, n4);
            if (n8 == -1) {
                if (bl && this.canWrap(cArray, n3, n4)) {
                    list.add(n, "");
                } else {
                    list.remove(n);
                    list.add(n, String.valueOf(cArray, 0, n7 + 1));
                    list.add(n + 1, string.substring(n7 + 1, string.length()));
                }
            } else {
                list.remove(n);
                if (n4 == 2) {
                    list.add(n, String.valueOf(cArray, 0, n8 + 1));
                    list.add(n + 1, string.substring(n8 + 1, string.length()));
                } else {
                    int n9;
                    for (n9 = n8; n9 > -1 && cArray[n9] == ' '; --n9) {
                    }
                    if (n9 == -1) {
                        list.add(n, "");
                    } else {
                        list.add(n, String.valueOf(cArray, 0, n9 + 1));
                    }
                    list.add(n + 1, string.substring(n8 + 1, string.length()));
                }
            }
        }
    }

    private boolean canWrap(char[] cArray, int n, int n2) {
        int n3 = this.getLastFittingPosition(cArray, n);
        if (n3 == -1) {
            return false;
        }
        int n4 = this.getWrapPosition(cArray, n3, n2);
        return n4 > 0;
    }

    protected void replaceChoiceIndex(int n) {
        this.strBuffer.append(n);
    }

    public int calculateBaselineY(int n, int n2) {
        int n3 = this.getFontBaseline();
        switch (n2) {
            case 6: {
                return n - 1;
            }
            case 5: {
                return Math.round((float)(n + n3) / 2.0f) - 1;
            }
            case 4: {
                return n3 - 1;
            }
        }
        AbstractWidget.logChannel.log(10000, "StringUtility#calculateBaseLineY: unssupported alignment typ: %1", (long)n2);
        return n3 - 1;
    }

    protected abstract int getFontBaseline() {
    }

    public static String sanitizeCharactersForLogging(String string) {
        Buffer buffer = new Buffer();
        if (StringUtilities.isNullOrEmpty(string)) {
            return buffer.toString();
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            buffer.append(StringUtility.sanitizeCharacterForLogging(string.charAt(i2)));
        }
        return buffer.toString();
    }

    public static boolean containsArabicChar(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (!StringUtility.isArabicChar(string.charAt(i2))) continue;
            return true;
        }
        return false;
    }

    public static String sanitizeCharacterForLogging(char c2) {
        switch (c2) {
            case '\b': {
                return "\\b";
            }
            case '\u0000': {
                return "\\0";
            }
        }
        return String.valueOf(c2);
    }

    public static void replaceByCondensed(Buffer buffer) {
        Buffer buffer2 = new Buffer(buffer.length());
        int n = buffer.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = buffer.charAt(i2);
            c2 = (char)(c2 + 0xE00000);
            buffer2.append(c2);
        }
        buffer.clear();
        buffer.append(buffer2);
    }

    public static boolean isBlankChar(char c2) {
        return c2 == ' ' || c2 == '\uf2f20000' || c2 == '\u05f0';
    }

    public static String concatenate(char c2, String string) {
        REUSED_CONCAT_BUFFER.clear();
        REUSED_CONCAT_BUFFER.append(c2);
        REUSED_CONCAT_BUFFER.append(string);
        return REUSED_CONCAT_BUFFER.toString();
    }

    public static String concatenate(String string, char c2) {
        REUSED_CONCAT_BUFFER.clear();
        REUSED_CONCAT_BUFFER.append(string);
        REUSED_CONCAT_BUFFER.append(c2);
        return REUSED_CONCAT_BUFFER.toString();
    }

    public static String concatenate(String string, String string2) {
        REUSED_CONCAT_BUFFER.clear();
        REUSED_CONCAT_BUFFER.append(string);
        REUSED_CONCAT_BUFFER.append(string2);
        return REUSED_CONCAT_BUFFER.toString();
    }

    public static String concatenate(String string, char c2, String string2) {
        REUSED_CONCAT_BUFFER.clear();
        REUSED_CONCAT_BUFFER.append(string);
        REUSED_CONCAT_BUFFER.append(c2);
        REUSED_CONCAT_BUFFER.append(string2);
        return REUSED_CONCAT_BUFFER.toString();
    }

    public static String[] charArrayToStringArray(char[] cArray) {
        String[] stringArray = new String[cArray.length];
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            stringArray[i2] = String.valueOf(cArray[i2]);
        }
        return stringArray;
    }

    public static boolean containsCharacter(String string, char c2) {
        return StringUtility.containsCharacter(string.toCharArray(), c2);
    }

    public static boolean containsCharacter(char[] cArray, char c2) {
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (cArray[i2] != c2) continue;
            return true;
        }
        return false;
    }

    public static boolean containsAny(String string, char[] cArray, boolean bl) {
        boolean bl2;
        block8: {
            bl2 = false;
            if (string == null || cArray == null || cArray.length <= 0 || string.length() <= 0) break block8;
            if (bl) {
                if (cArray.length % 3 != 0) {
                    throw new IllegalArgumentException("chars should looks like a-zA-Z");
                }
                bl2 = false;
                char[] cArray2 = string.toCharArray();
                int n = cArray.length / 3;
                for (int i2 = 0; i2 < cArray2.length; ++i2) {
                    for (int i3 = 0; i3 < n; ++i3) {
                        bl2 = cArray2[i2] >= cArray[i3 * 3];
                        bl2 &= cArray[i3 * 3 + 1] == '-';
                        if (!(bl2 &= cArray2[i2] <= cArray[i3 * 3 + 2])) {
                            continue;
                        }
                        break block8;
                    }
                }
            } else {
                int n;
                HashSet hashSet = new HashSet();
                char[] cArray3 = string.toCharArray();
                for (n = 0; n < cArray3.length; ++n) {
                    hashSet.add(new Character(cArray3[n]));
                }
                for (n = 0; n < cArray.length; ++n) {
                    if (!hashSet.contains(new Character(cArray[n]))) continue;
                    bl2 = true;
                    break;
                }
            }
        }
        return bl2;
    }

    protected boolean isAsia() {
        return AbstractWidget.isAsia();
    }

    public static String getTextOrientationHintString(int n, boolean bl) {
        if (!AbstractWidget.isArabia()) {
            return null;
        }
        switch (n) {
            case 0: {
                return null;
            }
            case 1: {
                return "\u200e";
            }
            case 2: {
                return "\u200f";
            }
            case 3: {
                if (bl) {
                    return "\u200e";
                }
                return null;
            }
            case 4: {
                if (!bl) {
                    return "\u200e";
                }
                return null;
            }
            case 5: {
                if (bl) {
                    return "\u200f";
                }
                return null;
            }
            case 6: {
                if (!bl) {
                    return "\u200f";
                }
                return null;
            }
            case 8: {
                if (bl) {
                    return "\u200e";
                }
                return "\u200f";
            }
            case 9: {
                if (bl) {
                    return "\u200f";
                }
                return "\u200e";
            }
            case 10: {
                if (!bl) {
                    return "\u200f\u200e";
                }
                return null;
            }
        }
        return null;
    }

    public static String filterNewLines(String string) {
        if (string == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        int n = string.length();
        int n2 = string.length() - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            if (string.charAt(i2) == '\r' && i2 < n2 && string.charAt(i2 + 1) == '\n') {
                buffer.append('\n');
                ++i2;
                continue;
            }
            if (string.charAt(i2) == '\n' && i2 < n2 && string.charAt(i2 + 1) == '\r') {
                buffer.append('\n');
                ++i2;
                continue;
            }
            if (string.charAt(i2) == '\r') {
                buffer.append('\n');
                continue;
            }
            buffer.append(string.charAt(i2));
        }
        return buffer.toString();
    }

    public static boolean shouldFixBracketsDirection(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) != ')') continue;
            if (i2 + 1 >= string.length() || !StringUtility.isArabicChar(string.charAt(i2 + 1))) break;
            return true;
        }
        return false;
    }

    public static String revertTextToArabicBlock(String string) {
        string = StringUtility.replaceAll(string, String.valueOf('\ufbfe0000'), "\u0644\u0627");
        string = StringUtility.replaceAll(string, String.valueOf('\uf5fe0000'), "\u0644\u0622");
        string = StringUtility.replaceAll(string, String.valueOf('\uf7fe0000'), "\u0644\u0623");
        string = StringUtility.replaceAll(string, String.valueOf('\uf9fe0000'), "\u0644\u0625");
        return string;
    }

    public static String replaceAll(String string, String string2, String string3) {
        int n = string.indexOf(string2);
        if (n == -1) {
            return string;
        }
        int n2 = string2.length();
        char[] cArray = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = 0;
        while (n != -1) {
            stringBuffer.append(cArray, n3, n - n3);
            stringBuffer.append(string3);
            n3 = n + n2;
            n = string.indexOf(string2, n3);
        }
        stringBuffer.append(cArray, n3, cArray.length - n3);
        return stringBuffer.toString();
    }

    static {
        REUSED_CONCAT_BUFFER = new Buffer();
    }
}


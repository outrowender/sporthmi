/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICaseBalancingStrategy;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FastDeleteHelper;

public class TouchInputDataArabia
extends TouchInputData
implements ITouchInputDataArabia,
FastDeleteHelper {
    private boolean isSystemLanguageArabic = true;
    private boolean isDeleteWithTouchPad = false;
    private boolean rightToLeft = true;
    private static final String SPECIAL_CHARS = "\u060c\u061b\u061f.,?!'-/_:;()\u20ac$&@\"#%*+<=>[\\]~\u00a1\u00a2\u00a3\u00a7\u00bf^{|}";

    public TouchInputDataArabia() {
    }

    public TouchInputDataArabia(ICaseBalancingStrategy iCaseBalancingStrategy) {
        super(iCaseBalancingStrategy);
    }

    public char insertString(String string, String[] stringArray, boolean bl) {
        if (string == null) {
            return this.insertString("", stringArray, bl);
        }
        if (this.isPasswordMode) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchController#stringEntered: hide already entered characters (if it's a Password field)");
            this.hideCharacters();
        }
        this.deleteIntoWordState = 1;
        if (stringArray == null) {
            int n;
            for (n = 0; n < string.length(); ++n) {
                String string2 = string.substring(n, n + 1);
                char c2 = string2.charAt(0);
                this.switchDirectionIfNeeded(c2, true);
                this.enteredCharsWithAlternatives.add(this.cursorPos, string2);
                this.caseInformation.add(this.cursorPos, 0);
                ++this.cursorPos;
            }
            if (this.isUpperCaseOnlyMode || this.caseBalancingStrategy.needRefreshDisplayTextAfterTextChange()) {
                this.refreshDisplayText();
            } else {
                n = Math.min(this.currentDisplayTextBuffer.length(), Math.max(this.cursorPos - 1, 0));
                this.currentDisplayTextBuffer.insert(n, string);
            }
            this.refreshStartOfWord();
        } else {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string3 = stringArray[i2].substring(i2, i2 + 1);
                char c3 = string3.charAt(0);
                this.switchDirectionIfNeeded(c3, true);
                this.enteredCharsWithAlternatives.add(this.cursorPos, stringArray[i2]);
                this.caseInformation.add(this.cursorPos, TouchInputDataArabia.determineCaseGroup(string.charAt(i2), stringArray[i2]));
                ++this.cursorPos;
            }
            this.refreshDisplayText();
            this.refreshStartOfWord();
        }
        if (this.isPasswordMode) {
            this.hiddenCharsBuffer.append(string);
            this.unHiddenLength += string.length();
        }
        this.notifyDataChange(bl);
        if (this.currentDisplayTextBuffer.length() > 0) {
            return this.currentDisplayTextBuffer.charAt(this.cursorPos - 1);
        }
        return '\u0000';
    }

    private void switchDirectionIfNeeded(char c2, boolean bl) {
        if (bl) {
            if (this.rightToLeft) {
                if (this.isArabicChar(c2) || this.isArabicSpecialChar(c2) || StringUtility.isBlankChar(c2)) {
                    return;
                }
                this.rightToLeft = false;
            } else {
                if (!this.isArabicChar(c2) && !this.isArabicSpecialChar(c2)) {
                    return;
                }
                this.rightToLeft = true;
            }
        } else {
            if (this.isDeleteWithTouchPad) {
                char c3;
                int n = this.cursorPos;
                c2 = c3 = n - 1 >= 0 ? this.currentDisplayTextBuffer.charAt(n - 1) : (char)'\u0000';
            }
            if (this.enteredCharsWithAlternatives.size() <= 1) {
                this.rightToLeft = TouchControllerArabia.isArabicCharSetActivated();
                return;
            }
            if (this.rightToLeft) {
                if (this.isArabicChar(c2) || this.isArabicSpecialChar(c2) || StringUtility.isBlankChar(c2)) {
                    return;
                }
                this.rightToLeft = false;
            } else {
                if (!this.isArabicChar(c2) && !this.isArabicSpecialChar(c2)) {
                    return;
                }
                this.rightToLeft = true;
            }
        }
    }

    public boolean isArabicSpecialChar(char c2) {
        return this.isSpecialChar(c2) && this.isSystemLanguageArabic && !TouchControllerArabia.isLatinOnlyField();
    }

    private boolean isSpecialChar(char c2) {
        return SPECIAL_CHARS.indexOf(c2) != -1;
    }

    private boolean isArabicChar(char c2) {
        return StringUtility.isArabicChar(c2);
    }

    public void insertAutoCompletion(String string) {
        int n;
        int n2 = this.getTextLength();
        for (n = this.startPosCurrentWord; n < this.cursorPos; ++n) {
            String string2 = (String)this.enteredCharsWithAlternatives.remove(this.startPosCurrentWord);
            this.caseInformation.remove(this.startPosCurrentWord);
            char c2 = string2.charAt(0);
            this.switchDirectionIfNeeded(c2, false);
        }
        for (n = 0; n < string.length(); ++n) {
            this.enteredCharsWithAlternatives.add(this.startPosCurrentWord + n, string.substring(n, n + 1));
            this.caseInformation.add(this.startPosCurrentWord + n, 0);
            this.switchDirectionIfNeeded(string.substring(n, n + 1).charAt(0), true);
        }
        this.cursorPos = this.getTextLength();
        if (n2 == 0) {
            this.currentDisplayTextBuffer.append(string);
        } else {
            this.refreshDisplayText();
        }
        this.refreshStartOfWord();
        this.notifyDataChange();
    }

    public boolean deleteOneChar() {
        int n;
        this.cursorPos = Math.max(this.cursorPos - 1, 0);
        char c2 = this.getCurrentText().charAt(this.cursorPos);
        this.switchDirectionIfNeeded(c2, false);
        String string = (String)this.enteredCharsWithAlternatives.remove(this.cursorPos);
        char c3 = string.charAt(0);
        this.caseInformation.remove(this.cursorPos);
        this.currentDisplayTextBuffer.deleteCharAt(this.cursorPos);
        char c4 = c3;
        if (this.isDeleteWithTouchPad) {
            char c5;
            n = this.cursorPos;
            c4 = c5 = n - 1 >= 0 ? this.currentDisplayTextBuffer.charAt(n - 1) : (char)' ';
        }
        if (!Character.isDigit(c4) && !this.isSpecialChar(c4) && c4 != ' ') {
            int n2 = n = StringUtility.isBlankChar(c4) && this.isSystemLanguageArabic ? 1 : 0;
            if (this.isArabicChar(c4) || n != 0) {
                this.notifyDataChange(2, false, null, null);
            } else {
                this.notifyDataChange(3, false, null, null);
            }
        }
        switch (this.deleteIntoWordState) {
            case 1: {
                if (c3 == ' ') break;
                this.deleteIntoWordState = 2;
                break;
            }
            case 2: {
                if (c3 != ' ') break;
                this.deleteIntoWordState = 3;
                break;
            }
            case 3: {
                if (c3 == ' ') break;
                this.showHint = true;
                this.deleteIntoWordState = 2;
                break;
            }
        }
        if (this.hiddenCharsBuffer != null) {
            this.hiddenCharsBuffer.deleteCharAt(this.hiddenCharsBuffer.length() - 1);
            --this.unHiddenLength;
            this.unHiddenLength = Math.max(0, this.unHiddenLength);
        }
        return this.refreshStartOfWord();
    }

    public boolean isRTL() {
        return this.rightToLeft;
    }

    public void setRTL(boolean bl) {
        char c2 = bl ? (char)'\u200f' : '\u200e';
        this.switchDirectionIfNeeded(c2, true);
    }

    public String toString() {
        return "TouchInputDataArabia";
    }

    public boolean isDeleteDirectionFromRightToLeft() {
        return this.isRTL();
    }

    public boolean isDeleteWithTouchPad() {
        return this.isDeleteWithTouchPad;
    }

    public void setDeleteWithTouchPad(boolean bl) {
        this.isDeleteWithTouchPad = bl;
    }

    public void setSystemLanguageArabic(boolean bl) {
        this.isSystemLanguageArabic = bl;
    }
}


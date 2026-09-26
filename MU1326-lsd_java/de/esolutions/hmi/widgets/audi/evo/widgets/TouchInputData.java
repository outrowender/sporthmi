/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.hmi.evo.BckSpaceGestureHandlerConfig;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.CaseBalancingStrategyEU;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICaseBalancingStrategy;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.BckSpaceGestureHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FastDeleteHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TouchInputData
implements ITouchInputData,
FastDeleteHelper {
    protected static final char PASSWORD_REPLACE_CHARACTER;
    protected static final int INITAL_CAPACITY;
    protected IntList caseInformation;
    protected Buffer currentDisplayTextBuffer;
    protected String oldDisplayText;
    protected List enteredCharsWithAlternatives;
    protected int cursorPos;
    protected int startPosCurrentWord;
    private int kbdType = 5;
    private BckSpaceGestureHandler fastDeleteHandler;
    private long lastDeleteTime = -1L;
    protected static final int DELETE_INTO_WORD_STATE_START;
    protected static final int DELETE_INTO_WORD_STATE_CHAR_DELETED;
    protected static final int DELETE_INTO_WORD_STATE_SPACE_DELETED;
    protected int deleteIntoWordState = 1;
    protected boolean showHint;
    protected boolean isPasswordMode = false;
    protected Buffer hiddenCharsBuffer;
    protected int unHiddenLength = 0;
    protected boolean hasCaseBalancing = false;
    protected boolean isUpperCaseOnlyMode = false;
    private List registeredDUListeners = new LinkedList();
    private int maximumTextLength = -129;
    private int minimumTextLength = 0;
    protected ICaseBalancingStrategy caseBalancingStrategy;

    public TouchInputData() {
        this(new CaseBalancingStrategyEU());
    }

    public TouchInputData(ICaseBalancingStrategy iCaseBalancingStrategy) {
        this.caseBalancingStrategy = iCaseBalancingStrategy;
        this.caseInformation = new IntList(32);
        this.enteredCharsWithAlternatives = new ArrayList(32);
        this.currentDisplayTextBuffer = new Buffer(32);
        this.oldDisplayText = this.currentDisplayTextBuffer.toString();
        this.startPosCurrentWord = 0;
        this.cursorPos = 0;
        this.fastDeleteHandler = new BckSpaceGestureHandler(BckSpaceGestureHandlerConfig.getTouchPadType(this.kbdType), this);
    }

    @Override
    public void setPasswordMode(boolean bl) {
        this.isPasswordMode = bl;
        if (bl) {
            this.hiddenCharsBuffer = new Buffer(32);
            this.unHiddenLength = 0;
        }
    }

    @Override
    public void clear(boolean bl) {
        boolean bl2 = this.isEmpty();
        this.startPosCurrentWord = 0;
        this.cursorPos = 0;
        this.enteredCharsWithAlternatives.clear();
        this.caseInformation.clear();
        this.currentDisplayTextBuffer.clear();
        this.deleteIntoWordState = 1;
        if (this.hiddenCharsBuffer != null) {
            this.hiddenCharsBuffer.delete(0, this.hiddenCharsBuffer.length());
            this.unHiddenLength = 0;
        }
        if (!bl2) {
            this.notifyDataChange(bl);
        }
    }

    protected boolean refreshStartOfWord() {
        int n = this.startPosCurrentWord;
        this.startPosCurrentWord = 0;
        if (this.getTextLength() == 0) {
            return false;
        }
        for (int i2 = this.getTextLength() - 1; i2 >= 0; --i2) {
            char c2 = ((String)this.enteredCharsWithAlternatives.get(i2)).charAt(0);
            if (!this.caseBalancingStrategy.isWordSeparator(c2)) continue;
            this.startPosCurrentWord = i2 + 1;
            break;
        }
        return n != this.startPosCurrentWord;
    }

    @Override
    public String buildModelString() {
        int n = this.enteredCharsWithAlternatives.size();
        Buffer buffer = new Buffer(n * 3);
        for (int i2 = 0; i2 < n; ++i2) {
            String string = TouchInputData.searchForSpace((String)this.enteredCharsWithAlternatives.get(i2));
            if (string.length() > 1) {
                buffer.append("[");
                buffer.append(string);
                buffer.append("]");
                continue;
            }
            buffer.append(string);
        }
        return buffer.toString();
    }

    protected static String searchForSpace(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string;
        if (string2.length() > 1) {
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                if (string2.charAt(i2) != ' ') continue;
                return " ";
            }
        }
        return string2;
    }

    @Override
    public boolean isEmpty() {
        return this.enteredCharsWithAlternatives.isEmpty();
    }

    @Override
    public boolean isStartOfText() {
        return this.cursorPos == 0;
    }

    @Override
    public boolean isStartOfWord() {
        return this.cursorPos - this.startPosCurrentWord == 0;
    }

    @Override
    public String getCurrentWord() {
        return this.currentDisplayTextBuffer.substring(this.startPosCurrentWord);
    }

    @Override
    public String getCurrentText() {
        return this.currentDisplayTextBuffer.toString();
    }

    @Override
    public String getCurrentDisplayString() {
        if (this.isPasswordMode) {
            return this.hiddenCharsBuffer.toString();
        }
        return this.getCurrentText();
    }

    protected void refreshDisplayText() {
        int n = this.getTextLength();
        if (this.isUpperCaseOnlyMode || !this.hasCaseBalancing) {
            int n2;
            if (this.cursorPos < n) {
                n2 = 0;
                this.currentDisplayTextBuffer.clear();
            } else {
                n2 = this.currentDisplayTextBuffer.length();
            }
            for (int i2 = n2; i2 < n; ++i2) {
                String string = (String)this.enteredCharsWithAlternatives.get(i2);
                char c2 = string.charAt(0);
                if (this.isUpperCaseOnlyMode) {
                    c2 = Character.toUpperCase(c2);
                }
                this.currentDisplayTextBuffer.append(c2);
            }
            return;
        }
        this.refreshDisplayCaseBalancingText();
    }

    protected void refreshDisplayCaseBalancingText() {
        int n = this.getTextLength();
        String string = this.caseBalancingStrategy.refreshForDisplayCaseBalancingText(this.startPosCurrentWord, n, this.caseInformation, this.enteredCharsWithAlternatives);
        String string2 = this.currentDisplayTextBuffer.substring(0, this.startPosCurrentWord);
        this.currentDisplayTextBuffer.clear();
        this.currentDisplayTextBuffer.append(string2);
        this.currentDisplayTextBuffer.append(string);
    }

    @Override
    public void moveCursor(int n) {
        this.cursorPos += n;
        this.cursorPos = Math.min(this.getTextLength(), this.cursorPos);
        this.cursorPos = Math.max(0, this.cursorPos);
    }

    @Override
    public int getCursorPos() {
        return this.cursorPos;
    }

    @Override
    public int getTextLength() {
        return this.enteredCharsWithAlternatives.size();
    }

    @Override
    public char insertString(String string, String[] stringArray, boolean bl) {
        if (string == null) {
            return this.insertString("", stringArray, bl);
        }
        if (this.isPasswordMode) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchController#stringEntered: hide already entered characters (if it's a Password field)");
            this.hideCharacters();
        }
        this.deleteIntoWordState = 1;
        if (stringArray == null) {
            int n = this.cursorPos;
            for (int i2 = 0; i2 < string.length(); ++i2) {
                String string2 = string.substring(i2, i2 + 1);
                this.enteredCharsWithAlternatives.add(this.cursorPos, string2);
                this.caseInformation.add(this.cursorPos, 0);
                ++this.cursorPos;
            }
            if (this.isUpperCaseOnlyMode || this.caseBalancingStrategy.needRefreshDisplayTextAfterTextChange()) {
                this.refreshDisplayText();
            } else {
                this.currentDisplayTextBuffer.insert(n, string);
            }
            this.refreshStartOfWord();
        } else {
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.enteredCharsWithAlternatives.add(this.cursorPos, stringArray[i3]);
                this.caseInformation.add(this.cursorPos, TouchInputData.determineCaseGroup(string.charAt(i3), stringArray[i3]));
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

    @Override
    public void hideCharacters() {
        if (this.hiddenCharsBuffer == null) {
            return;
        }
        this.hiddenCharsBuffer.delete(this.hiddenCharsBuffer.length() - this.unHiddenLength, this.hiddenCharsBuffer.length());
        for (int i2 = 0; i2 < this.unHiddenLength; ++i2) {
            this.hiddenCharsBuffer.append('*');
        }
        this.unHiddenLength = 0;
    }

    @Override
    public boolean delete(boolean bl) {
        long l = AbstractWidget.framework.getMonotonicTime();
        int n = 0;
        if (bl) {
            if (this.lastDeleteTime != -1L) {
                n = (int)(l - this.lastDeleteTime);
            }
        } else {
            n = -129;
        }
        this.lastDeleteTime = l;
        this.fastDeleteHandler.backspaceGesture(n);
        this.notifyDataChange();
        if (this.showHint) {
            this.showHint = false;
            return true;
        }
        return false;
    }

    @Override
    public void insertAutoCompletion(String string) {
        int n;
        int n2 = this.getTextLength();
        for (n = this.startPosCurrentWord; n < this.cursorPos; ++n) {
            this.enteredCharsWithAlternatives.remove(this.startPosCurrentWord);
            this.caseInformation.remove(this.startPosCurrentWord);
        }
        for (n = 0; n < string.length(); ++n) {
            this.enteredCharsWithAlternatives.add(this.startPosCurrentWord + n, string.substring(n, n + 1));
            this.caseInformation.add(this.startPosCurrentWord + n, 0);
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

    protected static int determineCaseGroup(char c2, String string) {
        if (c2 == '\u00df') {
            return 3;
        }
        if (Character.isUpperCase(c2)) {
            char c3;
            if (string != null && string.indexOf(c3 = Character.toLowerCase(c2)) > -1) {
                return 1;
            }
            return 0;
        }
        if (Character.isLowerCase(c2)) {
            char c4;
            if (string != null && string.indexOf(c4 = Character.toUpperCase(c2)) > -1) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    @Override
    public int getKeyboardType() {
        return this.kbdType;
    }

    @Override
    public void setKbdType(int n) {
        if (this.kbdType != n) {
            this.kbdType = n;
            this.fastDeleteHandler = new BckSpaceGestureHandler(BckSpaceGestureHandlerConfig.getTouchPadType(this.kbdType), this);
        }
    }

    @Override
    public int getWordLength() {
        return this.getTextLength();
    }

    @Override
    public boolean isEditMode() {
        return true;
    }

    @Override
    public boolean deleteOneChar() {
        this.cursorPos = Math.max(this.cursorPos - 1, 0);
        String string = (String)this.enteredCharsWithAlternatives.remove(this.cursorPos);
        char c2 = string.charAt(0);
        this.caseInformation.remove(this.cursorPos);
        this.currentDisplayTextBuffer.deleteCharAt(this.cursorPos);
        switch (this.deleteIntoWordState) {
            case 1: {
                if (c2 == ' ') break;
                this.deleteIntoWordState = 2;
                break;
            }
            case 2: {
                if (c2 != ' ') break;
                this.deleteIntoWordState = 3;
                break;
            }
            case 3: {
                if (c2 == ' ') break;
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

    @Override
    public void deleteWordIncludingPrecedingWhitespaces() {
    }

    @Override
    public boolean lock() {
        return true;
    }

    @Override
    public void unlock() {
    }

    @Override
    public void setCaseBalanced(boolean bl) {
        this.hasCaseBalancing = bl;
    }

    @Override
    public String doCaseBalancingForSuggestion(String string) {
        int n;
        boolean bl;
        if (StringUtilities.isNullOrEmpty(string)) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchInputData#doCaseBalancingForSuggestion: truffleSuggestion is \"%1\". Returning empty String.", (Object)string);
            return "";
        }
        if (this.isEmpty()) {
            return string;
        }
        int n2 = this.getTextLength();
        char c2 = this.currentDisplayTextBuffer.charAt(n2 - 1);
        boolean bl2 = n2 > 1;
        char c3 = bl2 ? this.currentDisplayTextBuffer.charAt(n2 - 2) : (char)'\u0000';
        boolean bl3 = bl = bl2 && this.caseBalancingStrategy.isWordSeparator(c3);
        if (bl || this.isCaseSensitiveStartCharacter()) {
            return string;
        }
        int n3 = n = Character.isUpperCase(c2) ? 2 : 1;
        if (n == 1) {
            return this.doConvertCompletion(string, false);
        }
        if (n == 2) {
            return this.doConvertCompletion(string, true);
        }
        return string;
    }

    private boolean isCaseSensitiveStartCharacter() {
        return this.caseInformation != null && this.caseInformation.size() == 1 && this.caseInformation.get(0) == 0;
    }

    protected String doConvertCompletion(String string, boolean bl) {
        Buffer buffer = new Buffer(string.length());
        buffer.append(string.substring(0, this.getTextLength()));
        for (int i2 = this.getTextLength(); i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (!bl && this.caseBalancingStrategy.isWordSeparator(c2)) {
                buffer.append(string.substring(i2, string.length()));
                break;
            }
            char c3 = bl ? Character.toUpperCase(c2) : Character.toLowerCase(c2);
            buffer.append(c3);
        }
        return buffer.toString();
    }

    @Override
    public final void registerDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
        this.registeredDUListeners.add(iTouchInputDataChangeHandler);
    }

    @Override
    public void unregisterDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
        Iterator iterator = this.registeredDUListeners.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != iTouchInputDataChangeHandler) continue;
            iterator.remove();
        }
    }

    public final void notifyDataChange(int n, boolean bl, String string, String string2) {
        Iterator iterator = this.registeredDUListeners.iterator();
        while (iterator.hasNext()) {
            ((ITouchInputDataChangeHandler)iterator.next()).touchInputDataChanged(n, bl, string, string2);
        }
    }

    protected final void notifyDataChange() {
        String string = this.currentDisplayTextBuffer.toString();
        this.notifyDataChange(1, true, this.oldDisplayText, string);
        this.oldDisplayText = string;
    }

    protected final void notifyDataChange(boolean bl) {
        String string = this.currentDisplayTextBuffer.toString();
        this.notifyDataChange(1, bl, this.oldDisplayText, string);
        this.oldDisplayText = string;
    }

    @Override
    public void setUpperCaseOnly(boolean bl) {
        this.isUpperCaseOnlyMode = bl;
    }

    @Override
    public void setMaximumTextLength(int n) {
        this.maximumTextLength = n;
    }

    @Override
    public int getMaximumTextLength() {
        return this.maximumTextLength;
    }

    @Override
    public void setMinimumTextLength(int n) {
        this.minimumTextLength = n;
    }

    @Override
    public int getMinimumTextLength() {
        return this.minimumTextLength;
    }

    public String toString() {
        return new Buffer("TouchInputData [text='").append(this.getCurrentText()).append("']").toString();
    }
}


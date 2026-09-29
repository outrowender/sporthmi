/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICaseBalancingStrategy;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.CaseBalancingStrategyAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public class TouchInputDataAsia
implements ITouchInputDataAsia {
    private final TouchInputData delegate;
    private Buffer fullTextBuffer;
    protected Buffer currentlyUnconvertedCharacters;
    private Buffer currentTouchResultPreviewCharacters;
    private ICharacterConversionPolicy conversionPolicy;
    private AsianInputMethod inputMethod;
    private boolean isHandWrittenModeActive;
    private IWordPredictionAccess wordPredictionAccess;
    private String suggestion;
    private boolean needPreviewDataUpdateToModel = false;
    private ICaseBalancingStrategy caseBalancingStrategy;

    public TouchInputDataAsia() {
        CaseBalancingStrategyAsia caseBalancingStrategyAsia = new CaseBalancingStrategyAsia();
        this.delegate = new TouchInputData(caseBalancingStrategyAsia);
        this.caseBalancingStrategy = caseBalancingStrategyAsia;
        this.wordPredictionAccess = IWordPredictionAccess.NULL;
        this.fullTextBuffer = new Buffer();
        this.currentlyUnconvertedCharacters = new Buffer(10);
        this.currentTouchResultPreviewCharacters = new Buffer(10);
        this.suggestion = "";
        this.inputMethod = AsianInputMethod.NO_CONVERSION;
        this.conversionPolicy = AsianInputMethod.NO_CONVERSION.getCharacterConversionPolicy();
        this.isHandWrittenModeActive = false;
    }

    @Override
    public void setInputMethod(AsianInputMethod asianInputMethod) {
        this.conversionPolicy.willChangeInputMethod(this);
        this.conversionPolicy = asianInputMethod.getCharacterConversionPolicy();
        this.inputMethod = asianInputMethod;
    }

    @Override
    public final IWordPredictionAccess getWordPredictionAccess() {
        return this.wordPredictionAccess;
    }

    @Override
    public final void setWordPredictionAccess(IWordPredictionAccess iWordPredictionAccess) {
        this.wordPredictionAccess = iWordPredictionAccess;
    }

    @Override
    public AsianInputMethod getInputMethod() {
        return this.inputMethod;
    }

    @Override
    public void longPressOnCharacterOccurred(String string) {
        if (this.inputMethod == AsianInputMethod.NO_CONVERSION) {
            this.appendRegularCharacters(string, true);
        } else {
            boolean bl = !this.conversionPolicy.doesLongPressTriggerConversion();
            this.appendUnconvertedCharacters(string, bl);
            this.conversionPolicy.longPressOnCharacterOccured(this);
        }
    }

    @Override
    public void spellerClosed() {
        this.conversionPolicy.spellerClosed(this);
        this.setHandWrittenModeIsActive(false);
    }

    @Override
    public void setHandWrittenModeIsActive(boolean bl) {
        if (!bl && this.hasTouchResultPreview()) {
            this.acceptTouchResultPreview();
        }
        if (bl && !this.isHandWrittenModeActive) {
            this.conversionPolicy.enteredHandWrittenMode(this);
        }
        this.isHandWrittenModeActive = bl;
        this.caseBalancingStrategy.setHandWrittenModeIsActive(this.isHandWrittenModeActive);
    }

    @Override
    public boolean isHandWrittenModeActive() {
        return this.isHandWrittenModeActive;
    }

    public void switchedSpellerBand() {
        this.conversionPolicy.willChangeInputMethod(this);
    }

    @Override
    public char insertString(String string, String[] stringArray, boolean bl) {
        char c2 = '\u0000';
        if ('\b' == TouchController.getMostPlausibleCharacter(string)) {
            if (this.hasTouchResultPreview()) {
                this.deleteTouchResultPreview();
            } else if (this.hasUnconvertedCharacters()) {
                this.deleteLastUnconvertedCharacter();
            } else {
                this.delegate.insertString(string, null, bl);
            }
            c2 = '\u0000';
        } else if (!this.isHandWrittenModeActive) {
            boolean bl2 = this.conversionPolicy.characterToBeInserted(this, string);
            if (bl2 && "*(-[[|]]Joker*:)".equals(string)) {
                string = TouchInputDataAsia.replaceSpecialMessageBackToChar(string);
            }
            if (bl2 && bl) {
                this.appendUnconvertedCharacters(string, bl);
                c2 = StringUtilities.isNullOrEmpty(string) ? (char)'\u0000' : string.charAt(string.length() - 1);
            } else {
                c2 = this.delegate.insertString(string, stringArray, bl);
            }
        } else {
            String string2 = null;
            if (this.hasTouchResultPreview() && (stringArray != null || " ".equals(string))) {
                string2 = this.getTouchResultPreview();
                this.acceptTouchResultPreview();
            } else {
                this.deleteTouchResultPreview(false);
            }
            if (!" ".equals(string2) || !" ".equals(string)) {
                c2 = this.delegate.insertString(string, stringArray, bl);
            }
        }
        return c2;
    }

    private static String replaceSpecialMessageBackToChar(String string) {
        String string2 = string;
        if ("*(-[[|]]Joker*:)".equals(string)) {
            string2 = "*";
        }
        return string2;
    }

    @Override
    public String getFullText() {
        this.fullTextBuffer.clear();
        String string = this.fullTextBuffer.append(this.getCurrentDisplayString()).append(this.getUnconvertedCharacters()).append(this.getTouchResultPreview()).toString();
        return string;
    }

    @Override
    public void appendRegularCharacters(String string, boolean bl) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            int n;
            String string2 = string;
            int n2 = this.getTextLength() + string.length();
            if (n2 > (n = this.getMaximumTextLength())) {
                string2 = string2.substring(0, n - this.getTextLength());
            }
            this.delegate.insertString(string2, null, bl);
        }
    }

    @Override
    public void appendUnconvertedCharacters(String string, boolean bl) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            String string2 = this.getUnconvertedCharacters();
            this.currentlyUnconvertedCharacters.append(string);
            this.notifyDataChange(3, bl, string2, this.getUnconvertedCharacters());
        }
    }

    @Override
    public String getUnconvertedCharacters() {
        return this.currentlyUnconvertedCharacters.toString();
    }

    @Override
    public boolean hasUnconvertedCharacters() {
        return this.currentlyUnconvertedCharacters.length() > 0;
    }

    @Override
    public void clearUnconvertedCharacters(boolean bl) {
        if (this.hasUnconvertedCharacters()) {
            String string = this.getUnconvertedCharacters();
            this.currentlyUnconvertedCharacters.clear();
            this.notifyDataChange(3, bl, string, "");
        }
    }

    protected void deleteLastUnconvertedCharacter() {
        if (this.hasUnconvertedCharacters()) {
            String string = this.getUnconvertedCharacters();
            this.currentlyUnconvertedCharacters.deleteCharAt(this.currentlyUnconvertedCharacters.length() - 1);
            this.notifyDataChange(3, string, this.getUnconvertedCharacters());
        }
    }

    private static String trimDelimiters(String string) {
        int n = string.length();
        Buffer buffer = new Buffer(n);
        for (int i2 = 0; i2 < n; ++i2) {
            if (string.charAt(i2) == '\'') continue;
            buffer.append(string.charAt(i2));
        }
        return buffer.toString();
    }

    @Override
    public void convertUnconvertedCharactersToRegularCharacters() {
        if (this.hasUnconvertedCharacters()) {
            String string = TouchInputDataAsia.trimDelimiters(this.getUnconvertedCharacters());
            this.clearUnconvertedCharacters(false);
            int n = this.getTextLength() + string.length();
            int n2 = this.getMaximumTextLength();
            if (n > n2) {
                string = string.substring(0, n2 - this.getTextLength());
            }
            this.delegate.insertString(string, null, true);
        }
    }

    @Override
    public void setTouchResultPreview(String string) {
        String string2 = this.getTouchResultPreview();
        if (!string2.equals(string)) {
            this.deleteTouchResultPreview(false);
            this.currentTouchResultPreviewCharacters.append(string);
            this.notifyDataChange(2, false, string2, this.getTouchResultPreview());
            if (this.needPreviewDataUpdateToModel) {
                this.notifyRegularTextChangeWithPreviewData(string);
            }
        }
    }

    @Override
    public String getTouchResultPreview() {
        return this.currentTouchResultPreviewCharacters.toString();
    }

    private String deleteTouchResultPreview(boolean bl) {
        if (!this.hasTouchResultPreview()) {
            return "";
        }
        String string = this.getTouchResultPreview();
        this.currentTouchResultPreviewCharacters.clear();
        this.notifyDataChange(2, false, string, "");
        if (bl && this.needPreviewDataUpdateToModel) {
            this.notifyRegularTextChangeWithPreviewData("");
        }
        return string;
    }

    @Override
    public String deleteTouchResultPreview() {
        return this.deleteTouchResultPreview(true);
    }

    private void notifyRegularTextChangeWithPreviewData(String string) {
        String string2 = this.getCurrentText();
        String string3 = StringUtility.concatenate(string2, string);
        this.notifyDataChange(1, true, string2, string3);
    }

    @Override
    public void acceptTouchResultPreview() {
        String string = this.deleteTouchResultPreview(false);
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.delegate.insertString(string, null, true);
        }
    }

    private void notifyDataChange(int n, String string, String string2) {
        this.delegate.notifyDataChange(n, true, string, string2);
    }

    protected void notifyDataChange(int n, boolean bl, String string, String string2) {
        this.delegate.notifyDataChange(n, bl, string, string2);
    }

    @Override
    public boolean hasTouchResultPreview() {
        return this.currentTouchResultPreviewCharacters.length() > 0;
    }

    @Override
    public boolean hasNonRegularCharacters() {
        return this.hasTouchResultPreview() || this.hasUnconvertedCharacters();
    }

    @Override
    public void setPasswordMode(boolean bl) {
        this.delegate.setPasswordMode(bl);
    }

    @Override
    public void clear(boolean bl) {
        this.clear(bl, false);
    }

    private void clear(boolean bl, boolean bl2) {
        this.delegate.clear(bl);
        this.clearUnconvertedCharacters(bl);
        if (!bl2) {
            this.deleteTouchResultPreview(bl);
        }
        this.deleteSuggestion(bl);
    }

    @Override
    public void clearModelTriggered() {
        this.clear(false, true);
    }

    private void deleteSuggestion(boolean bl) {
        if (!StringUtilities.isNullOrEmpty(this.suggestion)) {
            String string = this.suggestion;
            this.suggestion = "";
            this.notifyDataChange(4, false, string, this.suggestion);
        }
    }

    @Override
    public String buildModelString() {
        return this.delegate.buildModelString();
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.delegate.isEmpty() && !this.hasNonRegularCharacters();
        return bl;
    }

    @Override
    public boolean isStartOfText() {
        return this.isEmpty();
    }

    @Override
    public boolean isStartOfWord() {
        if (this.hasTouchResultPreview()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsia#isStartOfWord: handle preview text for word separator");
            String string = this.getTouchResultPreview();
            return this.caseBalancingStrategy.isWordSeparator(string.charAt(0));
        }
        if (this.hasUnconvertedCharacters()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsia#isStartOfWord: handle last unconverted character for word separator");
            if (this.getInputMethod() != AsianInputMethod.STROKE) {
                String string = this.getUnconvertedCharacters();
                return this.caseBalancingStrategy.isWordSeparator(string.charAt(string.length() - 1));
            }
        }
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsia#isStartOfWord: call TouchController#isStartOfWord");
        return this.delegate.isStartOfWord();
    }

    @Override
    public String getCurrentWord() {
        return this.delegate.getCurrentWord();
    }

    @Override
    public String getCurrentText() {
        return this.delegate.getCurrentText();
    }

    @Override
    public String getCurrentDisplayString() {
        return this.delegate.getCurrentDisplayString();
    }

    @Override
    public void moveCursor(int n) {
        this.delegate.moveCursor(n);
    }

    @Override
    public int getCursorPos() {
        if (this.hasUnconvertedCharacters()) {
            return this.delegate.getCursorPos() + this.currentlyUnconvertedCharacters.length();
        }
        if (this.hasTouchResultPreview()) {
            return this.delegate.getCursorPos() + this.currentTouchResultPreviewCharacters.length();
        }
        return this.delegate.getCursorPos();
    }

    @Override
    public int getTextLength() {
        return this.delegate.getTextLength();
    }

    @Override
    public void hideCharacters() {
        this.delegate.hideCharacters();
    }

    @Override
    public boolean delete(boolean bl) {
        return this.delegate.delete(bl);
    }

    public void deleteWordIncludingPrecedingWhitespaces() {
        this.delegate.deleteWordIncludingPrecedingWhitespaces();
    }

    @Override
    public void insertAutoCompletion(String string) {
        this.delegate.insertAutoCompletion(string);
    }

    @Override
    public int getKeyboardType() {
        return this.delegate.getKeyboardType();
    }

    @Override
    public void setKbdType(int n) {
        this.delegate.setKbdType(n);
    }

    public int getWordLength() {
        return this.delegate.getWordLength();
    }

    public boolean isEditMode() {
        return this.delegate.isEditMode();
    }

    public boolean lock() {
        return this.delegate.lock();
    }

    public void unlock() {
        this.delegate.unlock();
    }

    @Override
    public void setCaseBalanced(boolean bl) {
        this.delegate.setCaseBalanced(bl);
    }

    @Override
    public String doCaseBalancingForSuggestion(String string) {
        return this.delegate.doCaseBalancingForSuggestion(string);
    }

    public String toString() {
        return new Buffer("TouchInputDataAsia [regularText='").append(this.getCurrentText()).append("', unconverted='").append(this.getUnconvertedCharacters()).append("', touchResultPreview='").append(this.getTouchResultPreview()).append("']").toString();
    }

    @Override
    public void registerDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
        this.delegate.registerDataChangeListener(iTouchInputDataChangeHandler);
    }

    @Override
    public void unregisterDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
        this.delegate.unregisterDataChangeListener(iTouchInputDataChangeHandler);
    }

    @Override
    public void setUpperCaseOnly(boolean bl) {
        this.delegate.setUpperCaseOnly(bl);
    }

    @Override
    public void replaceLastUnconvertedCharacter(String string) {
        if (this.hasUnconvertedCharacters() && !StringUtilities.isNullOrEmpty(string)) {
            String string2 = this.getUnconvertedCharacters();
            this.currentlyUnconvertedCharacters.deleteCharAt(this.currentlyUnconvertedCharacters.length() - 1);
            this.currentlyUnconvertedCharacters.append(string);
            this.notifyDataChange(3, true, string2, this.getUnconvertedCharacters());
        }
    }

    @Override
    public void setUnconvertedCharacters(String string, boolean bl) {
        String string2 = this.getUnconvertedCharacters();
        if (string2.equals(string)) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchInputDataAsia#setUnconvertedCharacters: ignored '%1', because they don't differ from the current ones.", (Object)string);
            return;
        }
        this.currentlyUnconvertedCharacters.clear();
        this.currentlyUnconvertedCharacters.append(string);
        this.notifyDataChange(3, bl, string2, string);
    }

    @Override
    public void setNeedPreviewDataUpdateToModel(boolean bl) {
        this.needPreviewDataUpdateToModel = bl;
    }

    @Override
    public void setMaximumTextLength(int n) {
        this.delegate.setMaximumTextLength(n);
    }

    @Override
    public int getMaximumTextLength() {
        return this.delegate.getMaximumTextLength();
    }

    @Override
    public void setMinimumTextLength(int n) {
        this.delegate.setMinimumTextLength(n);
    }

    @Override
    public int getMinimumTextLength() {
        return this.delegate.getMinimumTextLength();
    }

    @Override
    public void onWordPredictionServiceRemoved() {
        this.inputMethod.getCharacterConversionPolicy().onWordPredictionServiceRemoved(this);
    }

    @Override
    public boolean isSuggestionValid() {
        if (this.hasNonRegularCharacters()) {
            return false;
        }
        if (!StringUtilities.isNullOrEmpty(this.suggestion)) {
            return this.suggestion.length() > this.getCurrentText().length() && this.suggestion.startsWith(this.getCurrentText());
        }
        return false;
    }

    @Override
    public void setSuggestion(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string;
        if (!this.suggestion.equals(string2)) {
            String string4 = this.suggestion;
            this.suggestion = string2;
            this.notifyDataChange(4, false, string4, string2);
        }
    }

    @Override
    public String getSuggestion() {
        return this.suggestion;
    }

    @Override
    public void acceptSuggestion(boolean bl) {
        String string = this.getSuggestion();
        this.clear(false);
        this.appendRegularCharacters(string, bl);
    }

    @Override
    public String getPredictionContextWithLastInputWord(String string, boolean bl) {
        String string2 = this.getCurrentText();
        String string3 = StringUtilities.isNullOrEmpty(string) ? TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(string2, bl) : ('\b' == string.charAt(0) ? (this.isEmpty() ? TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(string2, bl) : TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(string2.substring(0, string2.length() - 1), bl)) : TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(StringUtility.concatenate(string2, string), bl));
        return string3;
    }

    public static final String getCharsBeforeLastSpaceSeperator(String string, boolean bl) {
        char c2;
        if (StringUtilities.isNullOrEmpty(string)) {
            return "";
        }
        Buffer buffer = new Buffer();
        String string2 = bl ? string.trim() : string;
        for (int i2 = string2.length() - 1; i2 >= 0 && (c2 = string2.charAt(i2)) != ' '; --i2) {
            buffer.insert(0, c2);
        }
        return buffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.wordprediction.IInputTextInfoProviderAsia;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;

public interface ITouchInputDataAsia
extends ITouchInputData,
IInputTextInfoProviderAsia {
    public static final String STROKE_JOKER_INPUT_STRING_MESSAGE = "*(-[[|]]Joker*:)";
    public static final String STROKE_JOKER_STRING = "*";

    public void setInputMethod(AsianInputMethod var1);

    public AsianInputMethod getInputMethod();

    public IWordPredictionAccess getWordPredictionAccess();

    public void setWordPredictionAccess(IWordPredictionAccess var1);

    public void longPressOnCharacterOccurred(String var1);

    public void spellerClosed();

    public void setHandWrittenModeIsActive(boolean var1);

    public void appendUnconvertedCharacters(String var1, boolean var2);

    public String getUnconvertedCharacters();

    public boolean hasUnconvertedCharacters();

    public void clearUnconvertedCharacters(boolean var1);

    public void convertUnconvertedCharactersToRegularCharacters();

    public void setTouchResultPreview(String var1);

    public String getTouchResultPreview();

    public String deleteTouchResultPreview();

    public boolean hasTouchResultPreview();

    public boolean hasNonRegularCharacters();

    public String getFullText();

    public void appendRegularCharacters(String var1, boolean var2);

    public void acceptTouchResultPreview();

    public void replaceLastUnconvertedCharacter(String var1);

    public void setUnconvertedCharacters(String var1, boolean var2);

    public void setNeedPreviewDataUpdateToModel(boolean var1);

    public boolean isHandWrittenModeActive();

    public void onWordPredictionServiceRemoved();

    public boolean isSuggestionValid();

    public void setSuggestion(String var1);

    public String getSuggestion();

    public void acceptSuggestion(boolean var1);

    public String getPredictionContextWithLastInputWord(String var1, boolean var2);

    public void clearModelTriggered();
}


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
    public static final String STROKE_JOKER_INPUT_STRING_MESSAGE;
    public static final String STROKE_JOKER_STRING;

    default public void setInputMethod(AsianInputMethod asianInputMethod) {
    }

    default public AsianInputMethod getInputMethod() {
    }

    default public IWordPredictionAccess getWordPredictionAccess() {
    }

    default public void setWordPredictionAccess(IWordPredictionAccess iWordPredictionAccess) {
    }

    default public void longPressOnCharacterOccurred(String string) {
    }

    default public void spellerClosed() {
    }

    default public void setHandWrittenModeIsActive(boolean bl) {
    }

    default public void appendUnconvertedCharacters(String string, boolean bl) {
    }

    @Override
    default public String getUnconvertedCharacters() {
    }

    default public boolean hasUnconvertedCharacters() {
    }

    default public void clearUnconvertedCharacters(boolean bl) {
    }

    default public void convertUnconvertedCharactersToRegularCharacters() {
    }

    default public void setTouchResultPreview(String string) {
    }

    default public String getTouchResultPreview() {
    }

    default public String deleteTouchResultPreview() {
    }

    default public boolean hasTouchResultPreview() {
    }

    default public boolean hasNonRegularCharacters() {
    }

    default public String getFullText() {
    }

    default public void appendRegularCharacters(String string, boolean bl) {
    }

    default public void acceptTouchResultPreview() {
    }

    default public void replaceLastUnconvertedCharacter(String string) {
    }

    default public void setUnconvertedCharacters(String string, boolean bl) {
    }

    default public void setNeedPreviewDataUpdateToModel(boolean bl) {
    }

    default public boolean isHandWrittenModeActive() {
    }

    default public void onWordPredictionServiceRemoved() {
    }

    default public boolean isSuggestionValid() {
    }

    default public void setSuggestion(String string) {
    }

    default public String getSuggestion() {
    }

    default public void acceptSuggestion(boolean bl) {
    }

    default public String getPredictionContextWithLastInputWord(String string, boolean bl) {
    }

    default public void clearModelTriggered() {
    }
}


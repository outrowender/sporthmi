/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

final class AsianInputMethod$2
implements ICharacterConversionPolicy {
    AsianInputMethod$2() {
    }

    @Override
    public boolean doesLongPressTriggerConversion() {
        return true;
    }

    @Override
    public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        String string = iTouchInputDataAsia.getPredictionContextWithLastInputWord("", false);
        iTouchInputDataAsia.getWordPredictionAccess().startContextBasedPrediction(string, "", 20);
    }

    @Override
    public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
        if (AsianInputMethod.access$000(string)) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
            return false;
        }
        return true;
    }

    @Override
    public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
    }
}


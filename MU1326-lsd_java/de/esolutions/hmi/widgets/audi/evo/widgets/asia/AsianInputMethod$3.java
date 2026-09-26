/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

final class AsianInputMethod$3
implements ICharacterConversionPolicy {
    AsianInputMethod$3() {
    }

    @Override
    public boolean doesLongPressTriggerConversion() {
        return false;
    }

    @Override
    public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(true);
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(true);
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    @Override
    public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(true);
        iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
    }

    @Override
    public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
        if ("*(-[[|]]Joker*:)".equals(string)) {
            return true;
        }
        if (AsianInputMethod.access$000(string)) {
            iTouchInputDataAsia.clearUnconvertedCharacters(false);
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
            return false;
        }
        return true;
    }

    @Override
    public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(true);
    }
}


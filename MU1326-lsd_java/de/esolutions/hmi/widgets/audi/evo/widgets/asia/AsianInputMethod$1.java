/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

final class AsianInputMethod$1
implements ICharacterConversionPolicy {
    AsianInputMethod$1() {
    }

    @Override
    public boolean doesLongPressTriggerConversion() {
        return false;
    }

    @Override
    public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    @Override
    public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    @Override
    public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    @Override
    public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    @Override
    public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
        return false;
    }

    @Override
    public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
    }
}


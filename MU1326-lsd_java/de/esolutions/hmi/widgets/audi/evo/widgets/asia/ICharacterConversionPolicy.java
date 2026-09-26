/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public interface ICharacterConversionPolicy {
    default public boolean doesLongPressTriggerConversion() {
    }

    default public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    default public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    default public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    default public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    default public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
    }

    default public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
    }
}


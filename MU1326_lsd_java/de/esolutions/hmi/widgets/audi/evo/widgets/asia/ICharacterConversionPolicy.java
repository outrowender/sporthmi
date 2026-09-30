/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public interface ICharacterConversionPolicy {
    public boolean doesLongPressTriggerConversion();

    public void longPressOnCharacterOccured(ITouchInputDataAsia var1);

    public void spellerClosed(ITouchInputDataAsia var1);

    public void enteredHandWrittenMode(ITouchInputDataAsia var1);

    public void willChangeInputMethod(ITouchInputDataAsia var1);

    public void onWordPredictionServiceRemoved(ITouchInputDataAsia var1);

    public boolean characterToBeInserted(ITouchInputDataAsia var1, String var2);
}


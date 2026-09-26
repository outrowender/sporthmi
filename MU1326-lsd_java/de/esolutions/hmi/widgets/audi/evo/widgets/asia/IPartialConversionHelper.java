/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public interface IPartialConversionHelper {
    default public void setCurrentSelectedPredictionChars(String string) {
    }

    default public void setIsDeleteOperation(boolean bl) {
    }

    default public void handlePartialConversion(String string, ITouchInputDataAsia iTouchInputDataAsia, IWordPredictionAccess iWordPredictionAccess) {
    }

    default public String getConvertedChars() {
    }

    default public void reset() {
    }

    default public String getPartialConversion(String string) {
    }
}


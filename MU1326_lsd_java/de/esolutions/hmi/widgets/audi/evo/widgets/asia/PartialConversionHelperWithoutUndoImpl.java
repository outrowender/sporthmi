/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.PartialConversionHelperWithUndoImpl;

public class PartialConversionHelperWithoutUndoImpl
extends PartialConversionHelperWithUndoImpl {
    @Override
    public String getPartialConversion(String string) {
        return string;
    }

    @Override
    public void handlePartialConversion(String string, ITouchInputDataAsia iTouchInputDataAsia, IWordPredictionAccess iWordPredictionAccess) {
        if (!this.userSelectedConversions.isEmpty()) {
            for (int i2 = 0; i2 < this.userSelectedConversions.size(); ++i2) {
                iTouchInputDataAsia.appendRegularCharacters((String)this.userSelectedConversions.get(i2), true);
            }
        }
        super.handlePartialConversion(string, iTouchInputDataAsia, iWordPredictionAccess);
        this.userSelectedConversions.clear();
    }

    @Override
    protected void handleEmptySpelling(String string, ITouchInputDataAsia iTouchInputDataAsia) {
        iTouchInputDataAsia.clearUnconvertedCharacters(false);
    }
}


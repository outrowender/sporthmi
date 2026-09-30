/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;

public interface IPartialConversionHelper {
    public void setCurrentSelectedPredictionChars(String var1);

    public void setIsDeleteOperation(boolean var1);

    public void handlePartialConversion(String var1, ITouchInputDataAsia var2, IWordPredictionAccess var3);

    public String getConvertedChars();

    public void reset();

    public String getPartialConversion(String var1);
}


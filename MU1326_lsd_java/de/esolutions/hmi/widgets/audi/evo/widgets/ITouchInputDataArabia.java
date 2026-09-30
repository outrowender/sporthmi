/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputData;

public interface ITouchInputDataArabia
extends ITouchInputData {
    public boolean isRTL();

    public boolean isDeleteDirectionFromRightToLeft();

    public void setSystemLanguageArabic(boolean var1);

    public boolean isArabicSpecialChar(char var1);
}


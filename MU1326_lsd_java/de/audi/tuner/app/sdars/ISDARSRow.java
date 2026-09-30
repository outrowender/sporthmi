/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;

public interface ISDARSRow {
    public void setProgramData(SdarsRadioText var1, int var2);

    public void resetPdt();

    public StationInfoExt getStation();

    public void setSeekPossibility(AddToSeeksPossibilityEnum var1, AddToSeeksPossibilityEnum var2, AddToSeeksPossibilityEnum var3, AddToSeeksPossibilityEnum var4);
}


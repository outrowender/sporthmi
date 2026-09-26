/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;

public interface ISDARSRow {
    default public void setProgramData(SdarsRadioText sdarsRadioText, int n) {
    }

    default public void resetPdt() {
    }

    default public StationInfoExt getStation() {
    }

    default public void setSeekPossibility(AddToSeeksPossibilityEnum addToSeeksPossibilityEnum, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4) {
    }
}


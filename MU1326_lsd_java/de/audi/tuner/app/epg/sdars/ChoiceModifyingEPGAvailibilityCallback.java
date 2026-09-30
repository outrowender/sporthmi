/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.sdars.StationInfoExt;

public class ChoiceModifyingEPGAvailibilityCallback
implements IEPGAvailibiltyCallback {
    private final ChoiceModelApp choiceModelToModify;

    public ChoiceModifyingEPGAvailibilityCallback(ChoiceModelApp choiceModelApp) {
        this.choiceModelToModify = choiceModelApp;
    }

    public void epgAvailibiltyChanged(StationInfoExt stationInfoExt, boolean bl) {
        this.choiceModelToModify.setValue(bl ? 1 : 0);
    }

    public static ChoiceModifyingEPGAvailibilityCallback forSdarsFocussedChannelEPGAvailibilityChoice(TunerModels tunerModels) {
        return new ChoiceModifyingEPGAvailibilityCallback(tunerModels.getChoiceModel(100683));
    }
}


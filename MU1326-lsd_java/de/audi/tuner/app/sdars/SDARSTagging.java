/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.sdars.SDARSTagging$ButtonListener;
import de.audi.tuner.app.sdars.SDARSTagging$TaggingManagerListener;
import de.audi.tuner.app.sdars.SDARSWatch;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.TaggingData;
import de.audi.tuner.itunes.TaggingPossibilityEnum;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;

public class SDARSTagging
implements IDoTagging {
    private final TunerModels models;
    private ITaggingManager taggingMgr;
    private final SDARSWatch watch;
    private String iTunesSXMURL = "";
    private SdarsRadioText pdt = null;
    private StationInfoExt currentStation = new StationInfoExt();

    public SDARSTagging(TunerBasics tunerBasics, SDARSWatch sDARSWatch) {
        this.models = tunerBasics.getModels();
        this.watch = sDARSWatch;
        this.models.getButtonModel(1585905920).setButtonListener(new SDARSTagging$ButtonListener(this, null));
        this.models.getChoiceModel(1351090432).forceUpdate(true);
    }

    public void register(ITaggingManager iTaggingManager) {
        this.taggingMgr = iTaggingManager;
        this.taggingMgr.register(new SDARSTagging$TaggingManagerListener(this, null));
    }

    protected void setPdt(SdarsRadioText sdarsRadioText) {
        this.pdt = sdarsRadioText;
        this.adjustTaggingDependetModels();
    }

    public void setCurrentStation(StationInfoExt stationInfoExt) {
        this.currentStation = stationInfoExt;
    }

    void setStaticTaggingInfo(String string, String string2) {
        this.iTunesSXMURL = string;
    }

    @Override
    public void doTagging(int n, int n2) {
        TaggingPossibilityEnum taggingPossibilityEnum = this.doTaggingAndReturnSuccess();
        if (taggingPossibilityEnum.informUser) {
            this.models.getOptionModel(n).fireEvent(n2);
        }
    }

    private TaggingPossibilityEnum doTaggingAndReturnSuccess() {
        Object object;
        TaggingPossibilityEnum taggingPossibilityEnum = TaggingPossibilityEnum.forSdars(this.pdt, this.taggingMgr);
        int n = taggingPossibilityEnum.secondOrdinal;
        if (taggingPossibilityEnum.possible) {
            object = this.constructTagInformation();
            TaggingData taggingData = new TaggingData((TagInformation)object, null);
            n = this.taggingMgr.addTag(taggingData);
            this.pdt.setTaggingStatus(3);
            this.adjustTaggingDependetModels();
        }
        object = this.pdt != null ? this.pdt.getLongestAvailableProgramTitle() : "";
        this.models.getLabelModel(76087552).setText((String)object);
        this.models.getChoiceModel(1351090432).setValue(n);
        return taggingPossibilityEnum;
    }

    private void adjustTaggingDependetModels() {
        TaggingPossibilityEnum taggingPossibilityEnum = TaggingPossibilityEnum.IMPOSSIBLE_UNKNOWN_CAUSE;
        if (this.pdt != null) {
            taggingPossibilityEnum = TaggingPossibilityEnum.forSdars(this.pdt, this.taggingMgr);
        }
        this.models.getChoiceModel(25755904).setValue(taggingPossibilityEnum.possible ? 0 : 1);
        int n = taggingPossibilityEnum.possible || taggingPossibilityEnum == TaggingPossibilityEnum.IMPOSSIBLE_MEMORY_FULL ? 1 : 3;
        this.models.getButtonModel(1585905920).setStatus(n);
        if (!taggingPossibilityEnum.possible && this.models.getActiveTuner() == 7) {
            this.models.getChoiceModel(378077440).setValue(taggingPossibilityEnum.ordinal);
        }
        this.models.getChoiceModel(898236672).setValue(taggingPossibilityEnum.ordinal);
    }

    private TagInformation constructTagInformation() {
        return new TagInformation(false, true, this.pdt.getLongestAvailableProgramTitle(), this.pdt.getLongestAvailableArtistName(), String.valueOf(this.pdt.iTunesID), Utilities.getFormatedStationNumber(this.currentStation.stationNumber), this.currentStation.fullLabel, this.iTunesSXMURL, new DateTime(this.watch.getCurentTime()), "Jg8Ac3PqA8Y", "", 0, 0, "", "", 0);
    }

    static /* synthetic */ TaggingPossibilityEnum access$200(SDARSTagging sDARSTagging) {
        return sDARSTagging.doTaggingAndReturnSuccess();
    }

    static /* synthetic */ SdarsRadioText access$300(SDARSTagging sDARSTagging) {
        return sDARSTagging.pdt;
    }
}


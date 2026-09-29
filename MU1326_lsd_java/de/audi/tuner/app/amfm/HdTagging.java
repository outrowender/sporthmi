/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.amfm.HdTagging$ButtonListener;
import de.audi.tuner.app.amfm.HdTagging$DSIDownListener;
import de.audi.tuner.app.amfm.HdTagging$DsiUpListener;
import de.audi.tuner.app.amfm.HdTagging$TaggingManagerListener;
import de.audi.tuner.app.amfm.HdTagging$TimerListener;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.TaggingData;
import de.audi.tuner.itunes.TaggingPossibilityEnum;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;
import org.dsi.ifc.radio.HdStationInfo;

public class HdTagging
implements IDoTagging {
    private static final long TEN_SECONDS;
    final AMFMDsiUpInfo amfmDsiUpListener = new HdTagging$DsiUpListener(this, null);
    final AMFMDsiDownInfo dsiDownListener = new HdTagging$DSIDownListener(this, null);
    private final TunerModels models;
    private final Timer tagTimer = new Timer("tagTimer", 0, true, new HdTagging$TimerListener(this, null));
    private AMFMStation currentStation = new AMFMStation();
    private HdStationInfoExt actInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
    private HdStationInfoExt prevInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
    private volatile long actTime;
    private volatile long buttonTime;
    private ITaggingManager taggingMgr;
    private final LogChannel log;

    public HdTagging(TunerBasics tunerBasics) {
        this.models = tunerBasics.getModels();
        this.log = tunerBasics.getLogger().tagging;
        this.models.getButtonModel(1569128704).setButtonListener(new HdTagging$ButtonListener(this, null));
        this.models.getChoiceModel(1351090432).forceUpdate(true);
    }

    public void register(ITaggingManager iTaggingManager) {
        this.taggingMgr = iTaggingManager;
        this.taggingMgr.register(new HdTagging$TaggingManagerListener(this, null));
    }

    private void update(AMFMStation aMFMStation) {
        if (this.stationChanged(aMFMStation)) {
            if (this.tagTimer.cancel()) {
                this.finishTagging();
            }
            this.resetTaggingData();
        }
        this.currentStation = aMFMStation;
        this.storeSongInfo(aMFMStation.getHdInfo());
        this.adjustTaggingDependetModels();
    }

    private void storeSongInfo(HdStationInfoExt hdStationInfoExt) {
        if (this.actInfo.artistName.length() + this.actInfo.songTitle.length() == 0) {
            if (System.currentTimeMillis() - this.actTime > 0) {
                this.prevInfo = this.actInfo;
            }
            this.actInfo = hdStationInfoExt;
            this.actTime = System.currentTimeMillis();
            return;
        }
        boolean bl = this.actInfo.artistName.equals(hdStationInfoExt.artistName);
        boolean bl2 = this.actInfo.songTitle.equals(hdStationInfoExt.songTitle);
        if (hdStationInfoExt.songTitle.length() > 0 && this.actInfo.songTitle.length() == 0 || hdStationInfoExt.artistName.length() > 0 && this.actInfo.artistName.length() == 0 || bl && bl2) {
            this.actInfo = hdStationInfoExt;
            return;
        }
        this.prevInfo = this.actInfo;
        this.actInfo = hdStationInfoExt;
        this.actTime = System.currentTimeMillis();
    }

    private void resetTaggingData() {
        this.actInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
        this.prevInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
        this.adjustTaggingDependetModels();
    }

    private void finishTagging() {
        if (this.actTime < this.buttonTime) {
            if (this.buttonTime - this.actTime > 0) {
                this.addTag(this.actInfo, null, 0);
            } else {
                this.addTag(this.prevInfo, this.actInfo, 2);
            }
        } else {
            this.addTag(this.prevInfo, this.actInfo, 1);
        }
    }

    private void addTag(HdStationInfo hdStationInfo, HdStationInfo hdStationInfo2, int n) {
        TagInformation tagInformation = this.newTag(hdStationInfo);
        TagInformation tagInformation2 = this.newTag(hdStationInfo2);
        if (tagInformation == null && tagInformation2 != null) {
            tagInformation2.buttonPressed = true;
            this.taggingMgr.addTag(new TaggingData(tagInformation2, null));
        } else if (tagInformation != null && tagInformation2 == null) {
            tagInformation.buttonPressed = true;
            this.taggingMgr.addTag(new TaggingData(tagInformation, null));
        } else if (tagInformation != null && tagInformation2 != null) {
            tagInformation.ambiguousTag = true;
            tagInformation2.ambiguousTag = true;
            if (n == 1) {
                tagInformation.buttonPressed = true;
            } else {
                tagInformation2.buttonPressed = true;
            }
            this.taggingMgr.addTag(new TaggingData(tagInformation, tagInformation2));
        } else {
            this.log.log(10000, "[HdTagging.addTag] no tag info available");
        }
    }

    private TagInformation newTag(HdStationInfo hdStationInfo) {
        if (hdStationInfo == null || Utilities.isEmpty(hdStationInfo.artistName) && Utilities.isEmpty(hdStationInfo.songTitle)) {
            return null;
        }
        String string = hdStationInfo.stationURL;
        if (Utilities.isEmpty(string)) {
            string = hdStationInfo.contactURL;
        }
        return new TagInformation(false, false, hdStationInfo.songTitle, hdStationInfo.artistName, hdStationInfo.iTunesID, Utilities.kHzToMHz(this.currentStation.frequency), this.currentStation.shortNameHD, string, new DateTime(0L), hdStationInfo.affiliateID, hdStationInfo.albumTitle, hdStationInfo.iTunesFrontID, hdStationInfo.podcastFeedURL, hdStationInfo.genre, hdStationInfo.unknownData, this.currentStation.getProgramNr());
    }

    private boolean stationChanged(AMFMStation aMFMStation) {
        return aMFMStation.frequency != this.currentStation.frequency || aMFMStation.serviceId != this.currentStation.serviceId;
    }

    @Override
    public void doTagging(int n, int n2) {
        TaggingPossibilityEnum taggingPossibilityEnum = this.doTaggingAndReturnSuccess();
        if (taggingPossibilityEnum.informUser) {
            this.models.getOptionModel(n).fireEvent(n2);
        }
    }

    private TaggingPossibilityEnum doTaggingAndReturnSuccess() {
        TaggingPossibilityEnum taggingPossibilityEnum = TaggingPossibilityEnum.forHd(this.actInfo, this.taggingMgr);
        int n = taggingPossibilityEnum.secondOrdinal;
        if (taggingPossibilityEnum.possible) {
            if (this.tagTimer.cancel()) {
                this.finishTagging();
            }
            this.buttonTime = System.currentTimeMillis();
            this.actInfo.setTaggingStatus(3);
            this.adjustTaggingDependetModels();
            this.tagTimer.restart();
            n = this.taggingMgr.getExpectedTagResult();
        }
        this.models.getLabelModel(76087552).setText(this.actInfo.songTitle);
        this.models.getChoiceModel(1351090432).setValue(n);
        return taggingPossibilityEnum;
    }

    private void adjustTaggingDependetModels() {
        boolean bl;
        TaggingPossibilityEnum taggingPossibilityEnum = TaggingPossibilityEnum.IMPOSSIBLE_UNKNOWN_CAUSE;
        int n = 0;
        if (this.actInfo != null && this.actInfo != ISimpleTuner.EMPTY_HDSTATIONINFO) {
            taggingPossibilityEnum = TaggingPossibilityEnum.forHd(this.actInfo, this.taggingMgr);
            n = this.actInfo.getTaggingStatus();
        }
        this.models.getChoiceModel(42533120).setValue(taggingPossibilityEnum.possible ? 0 : 1);
        int n2 = n == 2 || n == 4 ? 1 : 3;
        this.models.getButtonModel(1569128704).setStatus(n2);
        int n3 = this.models.getActiveTuner();
        boolean bl2 = bl = n3 == 4 || n3 == 1;
        if (!taggingPossibilityEnum.possible && bl) {
            this.models.getChoiceModel(378077440).setValue(taggingPossibilityEnum.ordinal);
        }
        this.models.getChoiceModel(881459456).setValue(taggingPossibilityEnum.ordinal);
    }

    static /* synthetic */ TaggingPossibilityEnum access$500(HdTagging hdTagging) {
        return hdTagging.doTaggingAndReturnSuccess();
    }

    static /* synthetic */ void access$600(HdTagging hdTagging) {
        hdTagging.finishTagging();
    }

    static /* synthetic */ void access$700(HdTagging hdTagging, AMFMStation aMFMStation) {
        hdTagging.update(aMFMStation);
    }

    static /* synthetic */ void access$800(HdTagging hdTagging) {
        hdTagging.adjustTaggingDependetModels();
    }
}


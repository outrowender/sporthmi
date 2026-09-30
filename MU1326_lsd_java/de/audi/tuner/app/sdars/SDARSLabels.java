/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSTagging;
import de.audi.tuner.app.sdars.SDARSWatch;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.TeamSeekInformationEnum;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.change.ChangeEvent;
import de.audi.tuner.util.change.ChangeListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;
import org.dsi.ifc.sdars.StationDescription;

public class SDARSLabels
extends UpdateListenerHandler {
    private static final long GRACENOTE_COVERART_REQUEST_DELAY = 5000L;
    final SDARSDsiUpInfo dsiUpInfo = new DsiUpListener();
    final SDARSDsiDownInfo dsiDownInfo = new DsiDownListener();
    private final PdtListener pdtListener = new PdtListener();
    private final TunerModels models;
    private final PdtInfoHandler pdtHandler;
    private StationInfoExt activeStation = new StationInfoExt();
    private SdarsRadioText activePdt = null;
    private int listeningSId = -1;
    private final SDARSStationDescriptions sdarsStationDescriptions;
    private final SDARSTagging sdarsTaging;
    private final Timer delayedGracenoteCoverartRequestTimer;
    private final Object mutex = new Object();

    public SDARSLabels(TunerBasics tunerBasics, PdtInfoHandler pdtInfoHandler, SDARSWatch sDARSWatch, SDARSStationDescriptions sDARSStationDescriptions) {
        this.sdarsTaging = new SDARSTagging(tunerBasics, sDARSWatch);
        this.models = tunerBasics.getModels();
        this.pdtHandler = pdtInfoHandler;
        this.sdarsStationDescriptions = sDARSStationDescriptions;
        this.sdarsStationDescriptions.addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent changeEvent) {
                SDARSLabels.this.update(false);
            }
        });
        this.delayedGracenoteCoverartRequestTimer = new Timer("SDARSLabels.DelayedGracenoteCoverartRequestTimer", 5000L, true, DefaultTimerListener.DEFAULT_LISTENER);
    }

    public void register(ITaggingManager iTaggingManager) {
        this.sdarsTaging.register(iTaggingManager);
    }

    public TunerObjectContainer getActiveStation() {
        StationInfoExt stationInfoExt = new StationInfoExt(this.activeStation);
        stationInfoExt.setRadioText(this.activePdt);
        return new TunerObjectContainer(stationInfoExt);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(boolean bl) {
        Object object;
        this.sdarsTaging.setCurrentStation(this.activeStation);
        if (this.activeStation.sID != this.listeningSId || bl) {
            object = this.mutex;
            synchronized (object) {
                this.delayedGracenoteCoverartRequestTimer.cancel();
                this.pdtHandler.removeListener(this.listeningSId, this.pdtListener);
                this.listeningSId = this.activeStation.sID;
                this.pdtHandler.addListener(this.listeningSId, this.pdtListener, 0);
                this.delayedGracenoteCoverartRequestTimer.setTimerListener(new DelayedGracenoteCoverartRequestTimerListener(this.listeningSId));
                this.delayedGracenoteCoverartRequestTimer.start();
            }
        }
        this.models.getLabelModel(100167).setText(this.activeStation.fullLabel);
        this.models.getLabelModel(100927).setText(this.activeStation.shortLabel);
        this.models.getLabelModel(100168).setText(Utilities.getFormatedStationNumber(this.activeStation.stationNumber));
        this.models.getLabelModel(100152).setText(this.activeStation.getFullCategory());
        this.models.getLabelModel(100781).setText(this.activeStation.getShortCategory());
        this.models.getResourceLocatorModel(100159).setResourceLocator(this.activeStation.getStationArt());
        object = this.sdarsStationDescriptions.getStationDescriptionForSID(this.activeStation.sID);
        if (object != null) {
            String string = ((StationDescription)object).shortStationDescription;
            this.models.getLabelModel(100606).setText(string);
        } else {
            this.models.getLabelModel(100606).setText("");
        }
        this.propagateUpdatedActiveStation(7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void registerPDTInfoHandlerWithForcedGracenote(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.listeningSId == n) {
                boolean bl = n == this.activeStation.sID ? this.activeStation.isGraceNoteRequest() : false;
                this.pdtHandler.addListener(n, this.pdtListener, bl ? 2 : 0);
            }
        }
    }

    public IDoTagging getTagging() {
        return this.sdarsTaging;
    }

    public void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    public void reRequestCoverArt() {
        this.delayedGracenoteCoverartRequestTimer.start();
    }

    private class PdtListener
    implements IPdtListener {
        private PdtListener() {
        }

        public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
            SDARSLabels.this.sdarsTaging.setPdt(sdarsRadioText);
            if (n == ((SDARSLabels)SDARSLabels.this).activeStation.sID && sdarsRadioText != null) {
                SDARSLabels.this.activePdt = sdarsRadioText;
                SDARSLabels.this.models.getLabelModel(100349).setText(sdarsRadioText.longArtistName);
                SDARSLabels.this.models.getLabelModel(100351).setText(sdarsRadioText.longProgramTitle);
                SDARSLabels.this.models.getResourceLocatorModel(100883).setResourceLocator(sdarsRadioText.getCoverArt());
                Buffer buffer = new Buffer(200);
                buffer.append(sdarsRadioText.longArtistName).append("\n");
                buffer.append(sdarsRadioText.longProgramTitle).append("\n");
                buffer.append(sdarsRadioText.composer);
                String string = buffer.toString();
                SDARSLabels.this.models.getLabelModel(100156).setText(string);
            } else {
                SDARSLabels.this.activePdt = null;
                SDARSLabels.this.models.getLabelModel(100349).setText("");
                SDARSLabels.this.models.getLabelModel(100351).setText("");
                SDARSLabels.this.models.getResourceLocatorModel(100883).setResourceLocator(ISimpleTuner.EMPTY_RL);
                SDARSLabels.this.models.getLabelModel(100156).setText("");
            }
            SDARSLabels.this.propagateUpdatedActiveStation(7);
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSignalStatus(boolean bl) {
            SDARSLabels.this.models.getChoiceModel(100584).setValue(bl ? 1 : 0);
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            SDARSLabels.this.activeStation = stationInfoExt;
            SDARSLabels.this.update(false);
        }

        public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
            SDARSLabels.this.update(false);
        }

        public void updateStaticTaggingInfo(String string, String string2) {
            SDARSLabels.this.sdarsTaging.setStaticTaggingInfo(string, string2);
        }

        public void updateSeekPossibility(SeekPossibility seekPossibility) {
            Object object;
            String string = "";
            String string2 = "";
            int n = Integer.MIN_VALUE;
            int n2 = Integer.MIN_VALUE;
            if (seekPossibility.seekInformation != null) {
                for (int i2 = 0; i2 < seekPossibility.seekInformation.length; ++i2) {
                    object = seekPossibility.seekInformation[i2];
                    TeamSeekInformationEnum teamSeekInformationEnum = TeamSeekInformationEnum.forOrdinal(((SeekInformation)object).seekInfo);
                    if (teamSeekInformationEnum == null) continue;
                    if (teamSeekInformationEnum.isTeamA) {
                        if (!teamSeekInformationEnum.isMoreImportantThan(n)) continue;
                        n = teamSeekInformationEnum.importance;
                        string = ((SeekInformation)object).seekText;
                        continue;
                    }
                    if (!teamSeekInformationEnum.isMoreImportantThan(n2)) continue;
                    n2 = teamSeekInformationEnum.importance;
                    string2 = ((SeekInformation)object).seekText;
                }
            }
            LabelModelApp labelModelApp = SDARSLabels.this.models.getLabelModel(100192);
            string = Utilities.isEmpty(string) ? "" : string;
            labelModelApp.setText(string);
            object = SDARSLabels.this.models.getLabelModel(100194);
            string2 = Utilities.isEmpty(string2) ? "" : string2;
            object.setText(string2);
            int n3 = seekPossibility.getTypeOfContent() == 1 ? 3 : 0;
            int n4 = seekPossibility.getTypeOfContent() == 3 ? 3 : 0;
            int n5 = n3;
            int n6 = n3;
            int n7 = n4;
            int n8 = n4;
            if (seekPossibility.seekState != null) {
                block7: for (int i3 = 0; i3 < seekPossibility.seekState.length; ++i3) {
                    SeekState seekState = seekPossibility.seekState[i3];
                    switch (seekState.seekType) {
                        case 1: {
                            n6 = seekState.state == 1 ? 3 : 1;
                            continue block7;
                        }
                        case 2: {
                            n5 = seekState.state == 1 ? 3 : 1;
                            continue block7;
                        }
                        case 4: {
                            n7 = seekState.state == 1 ? 3 : 1;
                            continue block7;
                        }
                        case 5: {
                            n8 = seekState.state == 1 ? 3 : 1;
                            continue block7;
                        }
                    }
                }
            }
            SDARSLabels.this.models.getButtonModel(100646).setStatus(n5);
            SDARSLabels.this.models.getButtonModel(100647).setStatus(n6);
            SDARSLabels.this.models.getButtonModel(100645).setStatus(n7);
            SDARSLabels.this.models.getButtonModel(100648).setStatus(n8);
        }
    }

    private class DsiDownListener
    extends SDARSDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(StationInfoExt stationInfoExt) {
            SDARSLabels.this.activeStation = stationInfoExt;
            SDARSLabels.this.models.getLabelModel(100156).setText("");
            SDARSLabels.this.update(true);
        }
    }

    private class DelayedGracenoteCoverartRequestTimerListener
    extends DefaultTimerListener {
        private final int sIDForRegistration;

        public DelayedGracenoteCoverartRequestTimerListener(int n) {
            this.sIDForRegistration = n;
        }

        public void fireTimer(Timer timer) {
            SDARSLabels.this.registerPDTInfoHandlerWithForcedGracenote(this.sIDForRegistration);
        }
    }
}


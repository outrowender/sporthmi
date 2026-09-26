/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSLabels$1;
import de.audi.tuner.app.sdars.SDARSLabels$DelayedGracenoteCoverartRequestTimerListener;
import de.audi.tuner.app.sdars.SDARSLabels$DsiDownListener;
import de.audi.tuner.app.sdars.SDARSLabels$DsiUpListener;
import de.audi.tuner.app.sdars.SDARSLabels$PdtListener;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSTagging;
import de.audi.tuner.app.sdars.SDARSWatch;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.sds.UpdateListenerHandler;
import org.dsi.ifc.sdars.StationDescription;

public class SDARSLabels
extends UpdateListenerHandler {
    private static final long GRACENOTE_COVERART_REQUEST_DELAY;
    final SDARSDsiUpInfo dsiUpInfo = new SDARSLabels$DsiUpListener(this, null);
    final SDARSDsiDownInfo dsiDownInfo = new SDARSLabels$DsiDownListener(this, null);
    private final SDARSLabels$PdtListener pdtListener = new SDARSLabels$PdtListener(this, null);
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
        this.sdarsStationDescriptions.addChangeListener(new SDARSLabels$1(this));
        this.delayedGracenoteCoverartRequestTimer = new Timer("SDARSLabels.DelayedGracenoteCoverartRequestTimer", 0, true, DefaultTimerListener.DEFAULT_LISTENER);
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
                this.delayedGracenoteCoverartRequestTimer.setTimerListener(new SDARSLabels$DelayedGracenoteCoverartRequestTimerListener(this, this.listeningSId));
                this.delayedGracenoteCoverartRequestTimer.start();
            }
        }
        this.models.getLabelModel(1200029952).setText(this.activeStation.fullLabel);
        this.models.getLabelModel(1066008832).setText(this.activeStation.shortLabel);
        this.models.getLabelModel(1216807168).setText(Utilities.getFormatedStationNumber(this.activeStation.stationNumber));
        this.models.getLabelModel(948371712).setText(this.activeStation.getFullCategory());
        this.models.getLabelModel(-1383530240).setText(this.activeStation.getShortCategory());
        this.models.getResourceLocatorModel(1065812224).setResourceLocator(this.activeStation.getStationArt());
        object = this.sdarsStationDescriptions.getStationDescriptionForSID(this.activeStation.sID);
        if (object != null) {
            String string = ((StationDescription)object).shortStationDescription;
            this.models.getLabelModel(-24641280).setText(string);
        } else {
            this.models.getLabelModel(-24641280).setText("");
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

    static /* synthetic */ void access$300(SDARSLabels sDARSLabels, boolean bl) {
        sDARSLabels.update(bl);
    }

    static /* synthetic */ TunerModels access$400(SDARSLabels sDARSLabels) {
        return sDARSLabels.models;
    }

    static /* synthetic */ StationInfoExt access$502(SDARSLabels sDARSLabels, StationInfoExt stationInfoExt) {
        sDARSLabels.activeStation = stationInfoExt;
        return sDARSLabels.activeStation;
    }

    static /* synthetic */ SDARSTagging access$600(SDARSLabels sDARSLabels) {
        return sDARSLabels.sdarsTaging;
    }

    static /* synthetic */ StationInfoExt access$500(SDARSLabels sDARSLabels) {
        return sDARSLabels.activeStation;
    }

    static /* synthetic */ SdarsRadioText access$702(SDARSLabels sDARSLabels, SdarsRadioText sdarsRadioText) {
        sDARSLabels.activePdt = sdarsRadioText;
        return sDARSLabels.activePdt;
    }

    static /* synthetic */ void access$800(SDARSLabels sDARSLabels, int n) {
        sDARSLabels.registerPDTInfoHandlerWithForcedGracenote(n);
    }
}


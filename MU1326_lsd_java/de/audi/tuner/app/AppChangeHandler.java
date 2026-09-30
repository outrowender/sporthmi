/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ISimpleTuner;

class AppChangeHandler {
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final BandListHandler bandList;
    private final CombiBAPServiceHandler combiHandler;
    private final AnnouncementHandler announce;
    private final TunerAudioMgmt audio;
    private IRadioCmdManager cmdManager;

    AppChangeHandler(TunerBasics tunerBasics, BandListHandler bandListHandler, CombiBAPServiceHandler combiBAPServiceHandler, AnnouncementHandler announcementHandler, TunerAudioMgmt tunerAudioMgmt) {
        this.audio = tunerAudioMgmt;
        this.logger = tunerBasics.getLogger();
        this.status = tunerBasics.getStatus();
        this.models = tunerBasics.getModels();
        this.bandList = bandListHandler;
        this.combiHandler = combiBAPServiceHandler;
        this.announce = announcementHandler;
        this.cmdManager = new NullRadioCmdManager(tunerBasics);
    }

    void register(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    void appChangeToTuner(int n, int n2, TunerObjectContainer tunerObjectContainer, boolean bl) {
        this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToTuner] HT:%1 band:%2", (long)n, (long)n2);
        if (!this.status.hasAudioFocus(n)) {
            this.announce.abortAnnouncement();
        }
        boolean bl2 = false;
        if (!this.status.hasAudioFocus(n)) {
            this.status.setAudioFocus(true, n);
            bl2 = true;
        } else if (n != 0) {
            bl2 = true;
        }
        int n3 = this.models.getActiveTuner();
        if (n3 == n2 && tunerObjectContainer == null && (n != 0 && this.status.hasAudioFocus(0) || n == 0 && this.status.hasAudioFocus(3))) {
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdRequestConnection(n3, n));
            radioCommandList.add(this.cmdManager.cmdFadeToConnection(n3, n));
            this.cmdManager.enqueue(radioCommandList);
            return;
        }
        if (this.cmdManager.isBlocked()) {
            this.logger.audio.log(100000, "[AppChangeHandler.appChangeToTuner] CL queue is blocked!");
            this.audio.requestAudioChannel(Utilities.getConnectionByBand(n2, n), n);
        }
        this.audio.setStartup(bl);
        ISimpleTuner iSimpleTuner = TunerProxyManager.getInstance().getTuner(n2);
        int n4 = iSimpleTuner.init();
        if (n4 == 2) {
            this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToTuner] DSI of tuner missing");
            return;
        }
        boolean bl3 = iSimpleTuner.isDeviceInUse();
        if (n2 != this.models.getActiveTuner()) {
            this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToTuner] Switch band to %1", (long)n2);
            this.bandList.switchBand(n2, tunerObjectContainer, n);
        } else if (n4 == 0 && (bl2 || !bl3)) {
            this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToTuner] audioFocusSet:%1 targetTunerInUse:%2", bl2, bl3);
            switch (n2) {
                case 5: {
                    this.appChangeToDab(n, tunerObjectContainer);
                    break;
                }
                case 4: {
                    this.appChangeToAmFm(n, tunerObjectContainer);
                    break;
                }
                case 1: {
                    this.appChangeToAmFm(n, tunerObjectContainer);
                    break;
                }
                case 7: {
                    this.appChangeToSdars(n, tunerObjectContainer);
                    break;
                }
                case 10: {
                    this.appChangeToAmFm(n, tunerObjectContainer);
                    break;
                }
                case 11: {
                    this.appChangeToUni(n, tunerObjectContainer);
                    break;
                }
                default: {
                    this.logger.hmi.log(10000, "[AppChangeHandler.appChangeToTuner]", (Throwable)new IllegalStateException("Invalid band " + n2));
                    break;
                }
            }
        } else if (tunerObjectContainer != null) {
            TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n);
        } else {
            this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToTuner] target band %1 already active", (long)n2);
        }
        this.combiHandler.tunerActivated();
    }

    private void appChangeToSdars(int n, TunerObjectContainer tunerObjectContainer) {
        this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToSdars]");
        StationInfoExt stationInfoExt = tunerObjectContainer != null ? tunerObjectContainer.getSDARSService() : TunerProxyManager.getInstance().getSDARSTuner().getActiveStation();
        this.cmdManager.enqueue(this.cmdManager.clSwitchToSDARS(stationInfoExt, n));
    }

    private void appChangeToDab(int n, TunerObjectContainer tunerObjectContainer) {
        this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToDab]");
        DabStation dabStation = tunerObjectContainer != null ? tunerObjectContainer.getDABStation() : TunerProxyManager.getInstance().getDABTuner().getActiveStation();
        int n2 = dabStation.isService() ? 2 : 3;
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToDAB(n2, dabStation, n);
        this.cmdManager.enqueue(radioCommandList);
    }

    private void appChangeToUni(int n, TunerObjectContainer tunerObjectContainer) {
        this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToUni]");
        UnifiedStationExt unifiedStationExt = tunerObjectContainer != null ? tunerObjectContainer.getUniStation() : TunerProxyManager.getInstance().getUnifiedTuner().getActiveStation();
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToUni(unifiedStationExt, n);
        this.cmdManager.enqueue(radioCommandList);
    }

    private void appChangeToAmFm(int n, TunerObjectContainer tunerObjectContainer) {
        this.logger.hmi.log(10000000, "[AppChangeHandler.appChangeToAmFm] ");
        AMFMStation aMFMStation = tunerObjectContainer != null ? tunerObjectContainer.getAMFMService() : TunerProxyManager.getInstance().getAmFmTuner().getStationWanted();
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToAMFM(n, aMFMStation, false);
        this.cmdManager.enqueue(radioCommandList);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;

class AnnoncementVolumeChangeHandler {
    private int backupBand = -1;
    private boolean doResetAfterAnnEnded = false;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final AnnouncementHandler announce;
    private final TunerAudioMgmt audio;

    AnnoncementVolumeChangeHandler(TunerBasics tunerBasics, AnnouncementHandler announcementHandler, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.announce = announcementHandler;
        this.audio = tunerAudioMgmt;
    }

    void taVolumeAdjustmentActivated() {
        this.logger.announce.log(1000000, "[AnnoncementVolumeChangeHandler.taVolumeAdjustmentActivated]");
        this.status.setTaVolumeAdjustmentActive(true);
        this.backupBand = this.models.getActiveTuner();
        IRadioCmdManager iRadioCmdManager = TunerProxyManager.getInstance().getAmFmTuner().getCmdManager();
        RadioCommandList radioCommandList = iRadioCmdManager.createCmdList("AM/FM");
        if (this.backupBand == 1) {
            radioCommandList.add(iRadioCmdManager.cmdSwitchAMFMUsage(true));
            this.resetVolumeAdjustment();
        } else {
            AMFMStation aMFMStation = TunerProxyManager.getInstance().getAmFmTuner().getActiveStation(1);
            radioCommandList.add(iRadioCmdManager.cmdSwitchDABUsage(false));
            radioCommandList.add(iRadioCmdManager.cmdSwitchUniUsage(false));
            radioCommandList.add(iRadioCmdManager.cmdSwitchAMFMUsage(true));
            radioCommandList.add(iRadioCmdManager.cmdTuneAMFMStationBlock(aMFMStation, false, 0));
        }
        iRadioCmdManager.enqueue(radioCommandList);
    }

    void taVolumeAdjustmentDeactivated(int n) {
        this.logger.announce.log(1000000, "[AnnoncementVolumeChangeHandler.taVolumeAdjustmentDeactivated]");
        this.restoreBand(n);
        this.status.setTaVolumeAdjustmentActive(false);
    }

    private void restoreBand(int n) {
        if (this.backupBand != -1) {
            if (this.announce.getActiveAnnouncement() == 20) {
                switch (this.backupBand) {
                    case 4: {
                        TunerProxyManager.getInstance().getAmFmTuner().changeWaveband(4, null, n);
                        break;
                    }
                    case 5: {
                        if (!this.status.hasAudioFocus(n)) break;
                        this.audio.requestAudioChannel(26, n);
                        TunerProxyManager.getInstance().getAmFmTuner().setComponentUsage(false);
                        TunerProxyManager.getInstance().getDABTuner().setComponentUsage(true);
                        TunerProxyManager.getInstance().getDABTuner().dabSelected(null, n);
                        break;
                    }
                    case 11: {
                        if (!this.status.hasAudioFocus(n)) break;
                        this.audio.requestAudioChannel(26, n);
                        TunerProxyManager.getInstance().getAmFmTuner().setComponentUsage(false);
                        TunerProxyManager.getInstance().getUnifiedTuner().setComponentUsage(true);
                        TunerProxyManager.getInstance().getUnifiedTuner().uniSelected(null, n);
                        break;
                    }
                    case 7: {
                        if (!this.status.hasAudioFocus(n)) break;
                        this.audio.requestAudioChannel(28, n);
                        TunerProxyManager.getInstance().getAmFmTuner().setComponentUsage(false);
                        break;
                    }
                }
                this.resetVolumeAdjustment();
            } else {
                this.logger.audio.log(1000000, "[AnnoncementVolumeChangeHandler.restoreBand] Don't restore yet because Announcement active");
                this.doResetAfterAnnEnded = true;
            }
        }
    }

    void resetVolumeAdjustment() {
        this.backupBand = -1;
        this.doResetAfterAnnEnded = false;
    }

    void setActiveAnnouncement(int n) {
        if (this.doResetAfterAnnEnded && n == 20 && this.backupBand != -1) {
            this.logger.audio.log(1000000, "[AnnoncementVolumeChangeHandler.restoreBand] Announcement endet: restore bachuped band");
            this.restoreBand(0);
        }
    }
}


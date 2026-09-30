/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemStateSetCommand
extends AbstractSystemCallCommand {
    private static final int SYSTEM_STATE_PAUSE = 0;
    private static final int SYSTEM_STATE_POSTTRAINING = 1;
    private static final int SYSTEM_STATE_WAIT = 2;
    private final AppSDSManager sdsManager;
    private final SDSAppFactory factory;
    private final SpeechRecognitionHandler srHandler;
    private final int state;
    private final boolean actionStarted;
    private SDSHandlerService sdsAdapter;
    private SDSHMIListener sdsHmiListener;

    public SystemStateSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, SDSAppFactory sDSAppFactory, SDSHMIListener sDSHMIListener) {
        super(logChannel, string, sDSHandlerService);
        this.state = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.actionStarted = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1) == 1;
        this.sdsManager = appSDSManager;
        this.factory = sDSAppFactory;
        this.srHandler = speechRecognitionHandler;
        this.sdsAdapter = sDSHandlerService;
        this.sdsHmiListener = sDSHMIListener;
    }

    public void execute() {
        int n;
        boolean bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        String string = this.actionStarted ? "started" : "stopped";
        switch (this.state) {
            case 0: {
                this.logger.log(10000000, "%1#execute: Dialog pause is %2!", (Object)this.getName(), (Object)string);
                this.sdsManager.triggerSDSPauseState(this.actionStarted, false);
                this.sdsHandlerService.triggerPauseStateAbortTimer(this.actionStarted);
                this.handlePauseStateModelsAndTimers();
                bl2 = true;
                break;
            }
            case 1: {
                this.logger.log(10000000, "%1#execute: Posttraining is %2!", (Object)this.getName(), (Object)string);
                this.setPostTrainingActive(this.actionStarted);
                this.srHandler.triggerPosttraining(this.actionStarted, this.factory.getSDSHandlerADB().getProfileID());
                break;
            }
            case 2: {
                this.logger.log(10000000, "%1#execute: Waiting state is %2!", (Object)this.getName(), (Object)string);
                this.sdsManager.triggerSDSWaitState(this.actionStarted, false);
                if (this.actionStarted) {
                    SDSModelAccess.setSDSSystemStatus(this.state);
                    SDSModelAccess.setSmallCommandDisplayVisible(1);
                } else {
                    SDSModelAccess.setSDSSystemStatus(this.sdsManager.isSDSPauseStateActive() ? 0 : -1);
                    if (SDSModelAccess.getCommandScreen() == 0) {
                        SDSModelAccess.setSmallCommandDisplayVisible(0);
                    }
                }
                bl3 = true;
                this.sdsAdapter.setAbortWaitingStateOnCorrection(false);
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: Unhandled state %2!", (Object)this.getName(), (long)this.state);
                bl = false;
            }
        }
        int n2 = n = bl ? 3000 : 3001;
        if (bl2) {
            int n3 = n = bl ? 3002 : 3003;
        }
        if (bl3) {
            n = bl ? 3010 : 3011;
        }
        this.logger.log(10000000, "%1#execute: sdsResult=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    private void handlePauseStateModelsAndTimers() {
        if (this.actionStarted) {
            SDSModelAccess.setSDSSystemStatus(this.state);
            this.sdsHandlerService.triggerWaitStateAbortTimer(false);
            return;
        }
        if (this.sdsManager.isSDSWaitStateActive()) {
            this.sdsHmiListener.updateSDSStatusPause(true);
            SDSModelAccess.setSDSSystemStatus(2);
            SDSModelAccess.setSmallCommandDisplayVisible(1);
            this.sdsHandlerService.triggerWaitStateAbortTimer(true);
        } else {
            SDSModelAccess.setSDSSystemStatus(-1);
        }
    }

    private void setPostTrainingActive(boolean bl) {
        SDSModelAccess.setPosttrainingActiveValue(bl ? 1 : 0);
        if (!bl) {
            return;
        }
        this.logger.log(10000000, "AppSDSManager#setPostTrainingActive: Posttraining is started, resetting increment models!");
        this.sdsHmiListener.updateSDSRecogStatus(false, false);
        SDSModelAccess.setPosttrainingRecordCountValue(0);
        SDSModelAccess.setPosttrainingShowTextValue(0);
    }

    public byte getActionOnNewSystemCall(ISystemCall iSystemCall) {
        int n = iSystemCall.getId();
        if (n == 1000) {
            return 1;
        }
        return 0;
    }
}


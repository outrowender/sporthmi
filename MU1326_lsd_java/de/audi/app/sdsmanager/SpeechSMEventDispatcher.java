/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDS;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SpeechSMEventDispatcher
implements SDS {
    private final LogChannel lc = Logger.getHMILog();
    private final HMIService hmiService;
    private final ISDSPopupHelper popupHelper;
    private final AppSDSManager sdsManager;

    public SpeechSMEventDispatcher(HMIService hMIService, ISDSPopupHelper iSDSPopupHelper, AppSDSManager appSDSManager) {
        this.hmiService = hMIService;
        this.popupHelper = iSDSPopupHelper;
        this.sdsManager = appSDSManager;
    }

    @Override
    public boolean sendEvent(int n, boolean bl) {
        this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: eventID=%2, direct=%1", bl, (long)n);
        if (bl) {
            this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Firing SM event with ID %1!", (long)n);
            this.hmiService.fireSMEvent(6, n);
            return true;
        }
        int n2 = n;
        switch (n2) {
            case 2: {
                this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Pause event received, showing PAUSE popup on SPEECH terminal!");
                this.popupHelper.updateFurtherCommandsRemoved();
                this.popupHelper.triggerSpeechPopup(1, true);
                break;
            }
            case 3003: {
                this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Pause error event received, aborting pause!");
                this.sdsManager.triggerSDSPauseState(false, true);
                break;
            }
            case 3: 
            case 5: {
                this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Posttraining or other dialog starting event received!");
                this.startDialogPopup();
                return false;
            }
            case 1: {
                if (SDSModelAccess.getPosttrainingActiveValue() == 1) {
                    this.lc.log(-2137614336, "[SpeechSMEventDispatcher#sendEvent] Posttraining active, NOT showing speech dialog popup!");
                    break;
                }
                this.startDialogPopup();
                break;
            }
            case 4: {
                this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: VOLUME event received, showing VOLUME popup on SPEECH terminal!");
                this.popupHelper.triggerSpeechPopup(2, true);
                return false;
            }
            case 1001: 
            case 1002: 
            case 1004: {
                this.sdsManager.setAbortEventTriggered(true);
                break;
            }
            default: {
                this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Default case for eventID %1!", (long)n2);
            }
        }
        int n3 = SDSManagerBaseActivator.getMapping().getEventID(n2);
        if (n3 == -1) {
            this.lc.log(-1601830656, "SpeechSMEventDispatcher#sendEvent: No event ID found for mappingID %1!", (long)n2);
            return false;
        }
        this.lc.log(-2137614336, "SpeechSMEventDispatcher#sendEvent: Firing SM event with ID %1!", (long)n3);
        this.hmiService.fireSMEvent(6, n3);
        return true;
    }

    private void startDialogPopup() {
        this.lc.log(-2137614336, "SpeechSMEventDispatcher#startDialogPopup: -> show logical popup and speech popup!");
        this.popupHelper.triggerHapticalPopup(4, true);
        this.sdsManager.setSDSSpeechPopupActive(true);
        this.popupHelper.triggerSpeechPopup(0, true);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.SDSPopupUIService;
import de.audi.tghu.smi.SDSUIService;

public class SDSUIHandler {
    protected LogChannel logger;
    private State[] mainStateStack = new State[0];
    private SDSUIService sdsUIService;
    private SDSPopupUIService sdsPopupUIService;

    protected void updateMainStateStack(State[] stateArray, int n) {
        this.logger.log(1078071040, "[SDSUIHandler#updateMainStateStack] updating currently active state stack, size = '%1'.", (long)n);
        this.mainStateStack = new State[n];
        System.arraycopy((Object)stateArray, 0, (Object)this.mainStateStack, 0, n);
    }

    protected void sdsPopupRemoved(SDSPopupUIService sDSPopupUIService) {
        if (this.sdsUIService != null) {
            this.logger.log(1078071040, "[SDSUIHandler#sdsPopupRemoved] SDS-Popup has been removed. Reactivate state stack of main SDS-SM.");
            this.sdsUIService.activateUISDS(this.mainStateStack, this.mainStateStack.length);
            if (this.sdsPopupUIService == sDSPopupUIService) {
                this.logger.log(1078071040, "[SDSUIHandler#sdsPopupRemoved] Registered SDSPopupUIService is identical to removed SDS-Popup. Notifying TTSASR and removing SDSPopupUIService!");
                TTSASR tTSASR = this.sdsPopupUIService.getSDSService();
                if (tTSASR != null) {
                    tTSASR.sdsPopupRemoved();
                }
                this.sdsPopupUIService = null;
            } else {
                this.logger.log(1078071040, "[SDSUIHandler#sdsPopupRemoved] Registered SDSPopupUIService is NOT identical to removed SDS-Popup. SDSPopupUIService remains, no action is taken.");
            }
        } else {
            this.logger.log(1000, "[SDSUIHandler#sdsPopupRemoved] UIService for SDS Main SM is NULL!");
        }
    }

    protected State[] getMainStateStack() {
        return this.mainStateStack;
    }

    protected int getMainStateStackSize() {
        return this.mainStateStack.length;
    }

    protected void setLogger(LogChannel logChannel) {
        if (this.logger == null) {
            this.logger = logChannel;
        }
    }

    protected void setSDSUIService(SDSUIService sDSUIService) {
        if (this.sdsUIService == null) {
            this.logger.log(1078071040, "[SDSUIHandler#setSDSUIService] set UIService of SDS Main SM.");
            this.sdsUIService = sDSUIService;
        } else {
            this.logger.log(1000, "[SDSUIHandler#setSDSUIService] UIService of Main SM already set!");
        }
    }

    protected void setSDSPopupUIService(SDSPopupUIService sDSPopupUIService) {
        if (this.sdsPopupUIService == null) {
            this.logger.log(1078071040, "[SDSUIHandler#setSDSPopupUIService] set UISerivce of SDS Popup SM.");
            this.sdsPopupUIService = sDSPopupUIService;
        } else {
            this.logger.log(1078071040, "[SDSUIHandler#setSDSPopupUIService] UIService for SDS Popup SM already registered. Ignoring.");
        }
    }

    protected void retriggerActivateSDSPopupUIService() {
        this.logger.log(1078071040, "[SDSUIHandler#retriggerActivateSDSPopupUIService] Triggering the activateUI of SDSPopupUIService.");
        if (this.sdsPopupUIService == null) {
            this.logger.log(1000, "[SDSUIHandler#retriggerActivateSDSPopupUIService] UIService of Popup SM is null!");
        } else {
            this.sdsPopupUIService.reTriggerActivateUI();
        }
    }
}


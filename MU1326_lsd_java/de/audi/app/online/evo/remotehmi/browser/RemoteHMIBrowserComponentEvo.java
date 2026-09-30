/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.browser;

import de.audi.app.online.evo.remotehmi.browser.AbstractHMIViewBrowserListener;
import de.audi.app.online.evo.remotehmi.browser.HMIViewBrowserFullscreenListener;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;

public class RemoteHMIBrowserComponentEvo
extends RemoteHMIBrowserComponent {
    private boolean firstTimeEntered = true;

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        this.logChannel.log(1000000, "RemoteHMIBrowserComponentEvo#setBrowserHandler: receiving browser handler");
        if (iBrowserHandler != null) {
            VirtualButtonModelApp virtualButtonModelApp = (VirtualButtonModelApp)this.getModelBank().getModelApp(2301178);
            ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(2300027);
            RangeModelApp rangeModelApp = (RangeModelApp)this.getModelBank().getModelApp(2300068);
            LabelModelApp labelModelApp = null;
            ChoiceModelApp choiceModelApp2 = this.getModelBank().getChoiceModel(2300029);
            iBrowserHandler.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, null, null, 7);
            ChoiceModelApp choiceModelApp3 = this.getModelBank().getChoiceModel(2300062);
            iBrowserHandler.setBrowserSyncModel(choiceModelApp3);
            iBrowserHandler.setRangeModels(rangeModelApp);
            iBrowserHandler.setZoomLabel(labelModelApp);
            iBrowserHandler.setLabels(null);
            iBrowserHandler.setModels(null, null, null, null, null, null, null, null, null, null);
        }
        this.getViewBrowserListener().setBrowserHandler(iBrowserHandler);
    }

    public void setBrowserFullscreenHandler(IBrowserHandler iBrowserHandler) {
        this.logChannel.log(1000000, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() - receiving browser fullscreen handler");
        if (iBrowserHandler != null) {
            OnlineModelBankAccess onlineModelBankAccess = this.getModelBank();
            if (onlineModelBankAccess != null) {
                VirtualButtonModelApp virtualButtonModelApp = null;
                ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(2300031);
                RangeModelApp rangeModelApp = (RangeModelApp)this.getModelBank().getModelApp(2300045);
                LabelModelApp labelModelApp = this.getModelBank().getLabelModel(2300046);
                ChoiceModelApp choiceModelApp2 = this.getModelBank().getChoiceModel(2300033);
                iBrowserHandler.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, null, null, -1);
                iBrowserHandler.setRangeModels(rangeModelApp);
                iBrowserHandler.setZoomLabel(labelModelApp);
                iBrowserHandler.setLabels(null);
                ChoiceModelApp choiceModelApp3 = this.getModelBank().getChoiceModel(2300042);
                ButtonModelApp buttonModelApp = this.getModelBank().getButtonModel(2300035);
                ButtonModelApp buttonModelApp2 = this.getModelBank().getButtonModel(2300036);
                ButtonModelApp buttonModelApp3 = this.getModelBank().getButtonModel(2300034);
                iBrowserHandler.setModels(null, null, choiceModelApp3, buttonModelApp, buttonModelApp2, buttonModelApp3, null, null, null, null);
            } else {
                this.logChannel.log(10000, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() modelBank is null!");
            }
        }
        if (this.getViewBrowserFullscreenListener() != null) {
            this.getViewBrowserFullscreenListener().setBrowserHandler(iBrowserHandler);
        } else {
            this.logChannel.log(100000, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() ViewBrowserFullscreenListener is null!");
        }
    }

    public void sendMessageToBrowser(String string) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        AbstractHMIViewListener abstractHMIViewListener = remoteHMIContext.getViewListener();
        if (abstractHMIViewListener == this.getViewBrowserListener()) {
            this.logChannel.log(10000000, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): sending to browser", (Object)string);
            this.getViewBrowserListener().sendToBrowser(string);
        } else if (abstractHMIViewListener == this.getViewBrowserFullscreenListener()) {
            this.logChannel.log(10000000, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): sending to fullscreen browser", (Object)string);
            this.getViewBrowserFullscreenListener().sendToBrowser(string);
        } else {
            this.logChannel.log(100000, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): no browser is active", (Object)string);
        }
    }

    public void checkWakeup() {
        if (this.firstTimeEntered) {
            this.firstTimeEntered = false;
            if (this.getViewBrowserListener() != null) {
                this.getViewBrowserListener().wakeUp();
            }
        }
    }

    public AbstractHMIViewBrowserListener getViewBrowserListener() {
        return (AbstractHMIViewBrowserListener)this.remoteHmiService.getViewListener(3000);
    }

    public HMIViewBrowserFullscreenListener getViewBrowserFullscreenListener() {
        return (HMIViewBrowserFullscreenListener)this.remoteHmiService.getViewListener(3100);
    }

    public void remoteHmiBrowserLeft(int n) {
        this.getViewBrowserListener().browserLeft();
    }

    public void remoteHmiBrowserFullscreenLeft(int n) {
        this.getViewBrowserFullscreenListener().browserLeft();
    }

    public void resetToFactorySettings() {
        AbstractHMIViewBrowserListener abstractHMIViewBrowserListener = this.getViewBrowserListener();
        if (abstractHMIViewBrowserListener != null) {
            IBrowserHandler iBrowserHandler = abstractHMIViewBrowserListener.getBrowserHandler();
            if (iBrowserHandler != null) {
                iBrowserHandler.resetToFactorySettings();
            } else {
                this.logChannel.log(100000, "RemoteHMIBrowserComponentEvo.resetToFactorySettings() IBrowserHandler is null.");
            }
        } else {
            this.logChannel.log(100000, "RemoteHMIBrowserComponentEvo.resetToFactorySettings() AbstractHMIViewBrowserListener is null.");
        }
    }
}


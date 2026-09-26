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

    @Override
    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        this.logChannel.log(1078071040, "RemoteHMIBrowserComponentEvo#setBrowserHandler: receiving browser handler");
        if (iBrowserHandler != null) {
            VirtualButtonModelApp virtualButtonModelApp = (VirtualButtonModelApp)this.getModelBank().getModelApp(-98819328);
            ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(2065179392);
            RangeModelApp rangeModelApp = (RangeModelApp)this.getModelBank().getModelApp(-1541922048);
            LabelModelApp labelModelApp = null;
            ChoiceModelApp choiceModelApp2 = this.getModelBank().getChoiceModel(2098733824);
            iBrowserHandler.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, null, null, 7);
            ChoiceModelApp choiceModelApp3 = this.getModelBank().getChoiceModel(-1642585344);
            iBrowserHandler.setBrowserSyncModel(choiceModelApp3);
            iBrowserHandler.setRangeModels(rangeModelApp);
            iBrowserHandler.setZoomLabel(labelModelApp);
            iBrowserHandler.setLabels(null);
            iBrowserHandler.setModels(null, null, null, null, null, null, null, null, null, null);
        }
        this.getViewBrowserListener().setBrowserHandler(iBrowserHandler);
    }

    @Override
    public void setBrowserFullscreenHandler(IBrowserHandler iBrowserHandler) {
        this.logChannel.log(1078071040, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() - receiving browser fullscreen handler");
        if (iBrowserHandler != null) {
            OnlineModelBankAccess onlineModelBankAccess = this.getModelBank();
            if (onlineModelBankAccess != null) {
                VirtualButtonModelApp virtualButtonModelApp = null;
                ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(2132288256);
                RangeModelApp rangeModelApp = (RangeModelApp)this.getModelBank().getModelApp(-1927798016);
                LabelModelApp labelModelApp = this.getModelBank().getLabelModel(-1911020800);
                ChoiceModelApp choiceModelApp2 = this.getModelBank().getChoiceModel(-2129124608);
                iBrowserHandler.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, null, null, -1);
                iBrowserHandler.setRangeModels(rangeModelApp);
                iBrowserHandler.setZoomLabel(labelModelApp);
                iBrowserHandler.setLabels(null);
                ChoiceModelApp choiceModelApp3 = this.getModelBank().getChoiceModel(-1978129664);
                ButtonModelApp buttonModelApp = this.getModelBank().getButtonModel(-2095570176);
                ButtonModelApp buttonModelApp2 = this.getModelBank().getButtonModel(-2078792960);
                ButtonModelApp buttonModelApp3 = this.getModelBank().getButtonModel(-2112347392);
                iBrowserHandler.setModels(null, null, choiceModelApp3, buttonModelApp, buttonModelApp2, buttonModelApp3, null, null, null, null);
            } else {
                this.logChannel.log(10000, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() modelBank is null!");
            }
        }
        if (this.getViewBrowserFullscreenListener() != null) {
            this.getViewBrowserFullscreenListener().setBrowserHandler(iBrowserHandler);
        } else {
            this.logChannel.log(-1601830656, "RemoteHMIBrowserComponentEvo#setBrowserFullscreenHandler() ViewBrowserFullscreenListener is null!");
        }
    }

    @Override
    public void sendMessageToBrowser(String string) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        AbstractHMIViewListener abstractHMIViewListener = remoteHMIContext.getViewListener();
        if (abstractHMIViewListener == this.getViewBrowserListener()) {
            this.logChannel.log(-2137614336, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): sending to browser", (Object)string);
            this.getViewBrowserListener().sendToBrowser(string);
        } else if (abstractHMIViewListener == this.getViewBrowserFullscreenListener()) {
            this.logChannel.log(-2137614336, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): sending to fullscreen browser", (Object)string);
            this.getViewBrowserFullscreenListener().sendToBrowser(string);
        } else {
            this.logChannel.log(-1601830656, "RemoteHMIBrowserComponentEvo#sendMessageToBrowser(%1): no browser is active", (Object)string);
        }
    }

    @Override
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

    @Override
    public void remoteHmiBrowserLeft(int n) {
        this.getViewBrowserListener().browserLeft();
    }

    @Override
    public void remoteHmiBrowserFullscreenLeft(int n) {
        this.getViewBrowserFullscreenListener().browserLeft();
    }

    @Override
    public void resetToFactorySettings() {
        AbstractHMIViewBrowserListener abstractHMIViewBrowserListener = this.getViewBrowserListener();
        if (abstractHMIViewBrowserListener != null) {
            IBrowserHandler iBrowserHandler = abstractHMIViewBrowserListener.getBrowserHandler();
            if (iBrowserHandler != null) {
                iBrowserHandler.resetToFactorySettings();
            } else {
                this.logChannel.log(-1601830656, "RemoteHMIBrowserComponentEvo.resetToFactorySettings() IBrowserHandler is null.");
            }
        } else {
            this.logChannel.log(-1601830656, "RemoteHMIBrowserComponentEvo.resetToFactorySettings() AbstractHMIViewBrowserListener is null.");
        }
    }
}


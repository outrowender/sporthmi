/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.browser;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.browser.AbstractHMIViewBrowserListener;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

public class HMIViewBrowserFullscreenListener
extends AbstractHMIViewBrowserListener {
    private static final int DEFAULT_PAGE_HEIGHT = 367;
    private OnlineModelBankAccess modelBank;
    private static final int[] BROWSER_BUTTON_MODELS = new int[]{2300038, 2300037, 2300039, 2300040};

    public HMIViewBrowserFullscreenListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, (RangeModelApp)onlineModelBankAccess.getModelApp(2300041));
        this.modelBank = onlineModelBankAccess;
        this.mainModelGroup.add(onlineModelBankAccess.getModelApp(2300043));
        VirtualButtonModelApp virtualButtonModelApp = (VirtualButtonModelApp)onlineModelBankAccess.getModelApp(2300030);
        virtualButtonModelApp.setButtonListener(this);
    }

    private void toggleSidebar() {
        this.logChannel.log(10000000, "HMIViewBrowserFullscreenListener#toggleSidebar: buttonMenu");
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(2300042);
        int n = choiceModelApp.getValue();
        switch (n) {
            case 0: 
            case 3: {
                this.logChannel.log(10000000, "HMIViewBrowserFullscreenListener#toggleSidebar: opening sidebar");
                choiceModelApp.setValue(1);
                break;
            }
            case 1: 
            case 2: {
                this.logChannel.log(10000000, "HMIViewBrowserFullscreenListener#toggleSidebar: closing sidebar");
                choiceModelApp.setValue(3);
                break;
            }
        }
    }

    public synchronized void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.setTitles(2300043, 2300044, 0, 0, hMIProperties);
        this.setSoftkeys(null, 2300047, hMIProperties);
        boolean[] blArray = hMIProperties.getBooleanArray("softkeyEnabled");
        for (int i2 = 0; i2 < BROWSER_BUTTON_MODELS.length; ++i2) {
            ButtonModelApp buttonModelApp = this.modelBank.getButtonModel(BROWSER_BUTTON_MODELS[i2]);
            int n = 1;
            if (blArray != null && blArray.length > i2) {
                n = blArray[i2] ? 1 : 0;
            }
            buttonModelApp.setStatus(n);
        }
    }

    protected int getDefaultPageHeight() {
        return 367;
    }

    public int getViewID() {
        return 3100;
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == 2300030) {
            this.logChannel.log(10000000, "HMIViewBrowserFullscreenListener#keyTyped(REMOTE_HMI_BROWSER_FULLSCREEN_VIRTUAL_BUTTON): %1", (long)n2);
            if (n2 == 11) {
                ButtonModelApp buttonModelApp = this.modelBank.getButtonModel(2300037);
                if (buttonModelApp.getStatus() == 1) {
                    this.toggleSidebar();
                }
            } else if (n2 == 9) {
                this.invokeSoftkeyActionIfButtonEnabled(103, 9);
            } else if (n2 == 10) {
                this.invokeSoftkeyActionIfButtonEnabled(102, 10);
            } else if (n2 == 12) {
                this.invokeSoftkeyActionIfButtonEnabled(101, 12);
            }
        } else {
            super.keyPressed(n, n2, n3);
        }
    }

    private void invokeSoftkeyActionIfButtonEnabled(int n, int n2) {
        ButtonModelApp buttonModelApp = this.modelBank.getButtonModel(BROWSER_BUTTON_MODELS[n2]);
        if (buttonModelApp.getStatus() > 0) {
            String string = this.getSelectedSkID(n2);
            this.invokeSoftkeyAction(100, string);
        }
    }

    public String getSelectedSkID(int n) {
        return this.skIds[n];
    }

    public void indicateBoardbookAvailable(boolean bl) {
    }
}


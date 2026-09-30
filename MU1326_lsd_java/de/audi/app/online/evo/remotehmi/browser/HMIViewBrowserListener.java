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
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;

public class HMIViewBrowserListener
extends AbstractHMIViewBrowserListener
implements RemoteHMIDSIAccess.IRemoteHMIDSIListener {
    private static final int DEFAULT_PAGE_HEIGHT = 300;
    private static final int SCROLLBAR_TYPE_HMI = 0;
    private static final int SCROLLBAR_TYPE_BROWSER = 1;
    private static final int ARROWS_NONE = 0;
    private static final int ARROWS_UP = 1;
    private static final int ARROWS_DOWN = 2;
    private static final int ARROWS_BOTH = 3;
    private static final int WAITING_SCREEN_NOT_USED = 0;
    private static final int WAITING_SCREEN_USED = 1;
    private boolean useBrowserScrollbar = true;
    private ChoiceModelApp browserWaitModel;
    private ButtonModelApp browserWaitCancelButton;
    private boolean belowSpeedThreshold = true;

    public HMIViewBrowserListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, (RangeModelApp)onlineModelBankAccess.getModelApp(2300056));
        onlineModelBankAccess.getChoiceModel(2300057).setStatus(0);
        modelGroup.add(onlineModelBankAccess.getModelApp(2300063));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300060));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300061));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300047));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300051));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300049));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300053));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300055));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300054));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300052));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300050));
        modelGroup.add(onlineModelBankAccess.getModelApp(2300048));
        this.configureSoftkeyModels(new int[]{2300050, 2300048, 2300052, 2300054});
        this.browserWaitModel = onlineModelBankAccess.getChoiceModel(2300066);
        this.browserWaitModel.setValue(0);
        this.browserWaitCancelButton = onlineModelBankAccess.getButtonModel(2300067);
        this.browserWaitCancelButton.setButtonListener(this);
        this.remoteHmiService.getDsiAccess().addDSIListener(this);
    }

    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.setTitles(-1, -1, 2300060, 2300061, hMIProperties);
        this.setSoftkeys(new int[]{2300051, 2300049, 2300053, 2300055}, 2300047, hMIProperties);
        if (bl) {
            this.modelBank.getModelApp(2300057).setStatus(0);
        }
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(2300058);
        if (System.getProperty("RemoteHMIUseBrowserScrollbar") == null || Boolean.getBoolean("RemoteHMIUseBrowserScrollbar")) {
            this.logChannel.log(1000000, "HMIViewBrowserListener#updateViewProperties: using browser scrollbar");
            choiceModelApp.setValue(1);
            this.useBrowserScrollbar = true;
        } else {
            this.logChannel.log(1000000, "HMIViewBrowserListener#updateViewProperties: using HMI scrollbar");
            choiceModelApp.setValue(0);
            this.useBrowserScrollbar = false;
        }
        boolean bl2 = false;
        if (hMIProperties.contains("waitingScreen")) {
            bl2 = hMIProperties.getBoolean("waitingScreen");
            this.logChannel.log(1000000, "HMIViewBrowserListener#updateViewProperties: waiting screen: %1", bl2);
        }
        this.modelBank.getModelApp(2300029).setStatus(-1);
        this.browserWaitModel.setValue(bl2 ? 1 : 0);
        this.browserWaitModel.setStatus(1);
    }

    protected int getDefaultPageHeight() {
        return 300;
    }

    public synchronized void updateScrollbarY(int n, int n2, int n3, int n4) {
        int n5 = 0;
        if (this.pageHeight != n2) {
            this.pageHeight = n2;
            this.logChannel.log(10000000, "HMIViewBrowserListener#updateScrollbarY: setting pageHeight to %1)", (long)this.pageHeight);
        }
        n5 = n <= n2 ? 0 : (n3 + n2 >= n ? 1 : (n3 <= 0 ? 2 : 3));
        this.logChannel.log(10000000, "HMIViewBrowserListener#updateScrollbarY: - pageContentHeight: %1, scrollPositionY: %2, visibleAreaHeight: %3, arrowFlag: " + n5, (long)n, (long)n3, (long)n2);
        this.modelBank.getModelApp(2300057).setStatus(n5);
        if (!this.useBrowserScrollbar) {
            super.updateScrollbarY(n, n2, n3, n4);
        } else {
            this.logChannel.log(1000000, "HMIViewBrowserListener#updateScrollbarY: ignoring, because using browser scrollbar");
        }
    }

    public void belowLowerThreshold(int n) {
        this.logChannel.log(1000000, "HMIViewBrowserListener#belowLowerThreshold(%1)", (long)n);
        this.belowSpeedThreshold = true;
        RemoteHMIAction remoteHMIAction = this.getAction(451);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1000000, "HMIViewBrowserListener#exceedsUpperThreshold(%1)", (long)n);
        this.belowSpeedThreshold = false;
        RemoteHMIAction remoteHMIAction = this.getAction(450);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public int getViewID() {
        return 3000;
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2300067: {
                this.logChannel.log(1000000, "HMIViewBrowserListener#keyPressed(): sending HK_RETURN");
                this.invokeAction(this.getAction(104));
                break;
            }
            default: {
                super.keyPressed(n, n2, n3);
            }
        }
    }

    public void indicateBoardbookAvailable(boolean bl) {
    }

    public void remoteHmiDsiReady() {
        this.logChannel.log(1000000, "HMIViewBrowserListener#remoteHmiDsiReady(): updating speedThreshold status");
        if (this.belowSpeedThreshold) {
            this.belowLowerThreshold(0);
        } else {
            this.exceedsUpperThreshold(0);
        }
    }
}


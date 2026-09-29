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
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;

public class HMIViewBrowserListener
extends AbstractHMIViewBrowserListener
implements RemoteHMIDSIAccess$IRemoteHMIDSIListener {
    private static final int DEFAULT_PAGE_HEIGHT;
    private static final int SCROLLBAR_TYPE_HMI;
    private static final int SCROLLBAR_TYPE_BROWSER;
    private static final int ARROWS_NONE;
    private static final int ARROWS_UP;
    private static final int ARROWS_DOWN;
    private static final int ARROWS_BOTH;
    private static final int WAITING_SCREEN_NOT_USED;
    private static final int WAITING_SCREEN_USED;
    private boolean useBrowserScrollbar = true;
    private ChoiceModelApp browserWaitModel;
    private ButtonModelApp browserWaitCancelButton;
    private boolean belowSpeedThreshold = true;

    public HMIViewBrowserListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, (RangeModelApp)onlineModelBankAccess.getModelApp(-1743248640));
        onlineModelBankAccess.getChoiceModel(-1726471424).setStatus(0);
        modelGroup.add(onlineModelBankAccess.getModelApp(-1625808128));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1676139776));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1659362560));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1894243584));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1827134720));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1860689152));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1793580288));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1760025856));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1776803072));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1810357504));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1843911936));
        modelGroup.add(onlineModelBankAccess.getModelApp(-1877466368));
        this.configureSoftkeyModels(new int[]{-1843911936, -1877466368, -1810357504, -1776803072});
        this.browserWaitModel = onlineModelBankAccess.getChoiceModel(-1575476480);
        this.browserWaitModel.setValue(0);
        this.browserWaitCancelButton = onlineModelBankAccess.getButtonModel(-1558699264);
        this.browserWaitCancelButton.setButtonListener(this);
        this.remoteHmiService.getDsiAccess().addDSIListener(this);
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.setTitles(-1, -1, -1676139776, -1659362560, hMIProperties);
        this.setSoftkeys(new int[]{-1827134720, -1860689152, -1793580288, -1760025856}, -1894243584, hMIProperties);
        if (bl) {
            this.modelBank.getModelApp(-1726471424).setStatus(0);
        }
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(-1709694208);
        if (System.getProperty("RemoteHMIUseBrowserScrollbar") == null || Boolean.getBoolean("RemoteHMIUseBrowserScrollbar")) {
            this.logChannel.log(1078071040, "HMIViewBrowserListener#updateViewProperties: using browser scrollbar");
            choiceModelApp.setValue(1);
            this.useBrowserScrollbar = true;
        } else {
            this.logChannel.log(1078071040, "HMIViewBrowserListener#updateViewProperties: using HMI scrollbar");
            choiceModelApp.setValue(0);
            this.useBrowserScrollbar = false;
        }
        boolean bl2 = false;
        if (hMIProperties.contains("waitingScreen")) {
            bl2 = hMIProperties.getBoolean("waitingScreen");
            this.logChannel.log(1078071040, "HMIViewBrowserListener#updateViewProperties: waiting screen: %1", bl2);
        }
        this.modelBank.getModelApp(2098733824).setStatus(-1);
        this.browserWaitModel.setValue(bl2 ? 1 : 0);
        this.browserWaitModel.setStatus(1);
    }

    @Override
    protected int getDefaultPageHeight() {
        return 300;
    }

    @Override
    public synchronized void updateScrollbarY(int n, int n2, int n3, int n4) {
        int n5 = 0;
        if (this.pageHeight != n2) {
            this.pageHeight = n2;
            this.logChannel.log(-2137614336, "HMIViewBrowserListener#updateScrollbarY: setting pageHeight to %1)", (long)this.pageHeight);
        }
        n5 = n <= n2 ? 0 : (n3 + n2 >= n ? 1 : (n3 <= 0 ? 2 : 3));
        this.logChannel.log(-2137614336, new StringBuffer().append("HMIViewBrowserListener#updateScrollbarY: - pageContentHeight: %1, scrollPositionY: %2, visibleAreaHeight: %3, arrowFlag: ").append(n5).toString(), (long)n, (long)n3, (long)n2);
        this.modelBank.getModelApp(-1726471424).setStatus(n5);
        if (!this.useBrowserScrollbar) {
            super.updateScrollbarY(n, n2, n3, n4);
        } else {
            this.logChannel.log(1078071040, "HMIViewBrowserListener#updateScrollbarY: ignoring, because using browser scrollbar");
        }
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.logChannel.log(1078071040, "HMIViewBrowserListener#belowLowerThreshold(%1)", (long)n);
        this.belowSpeedThreshold = true;
        RemoteHMIAction remoteHMIAction = this.getAction(451);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1078071040, "HMIViewBrowserListener#exceedsUpperThreshold(%1)", (long)n);
        this.belowSpeedThreshold = false;
        RemoteHMIAction remoteHMIAction = this.getAction(450);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public int getViewID() {
        return 3000;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2300067: {
                this.logChannel.log(1078071040, "HMIViewBrowserListener#keyPressed(): sending HK_RETURN");
                this.invokeAction(this.getAction(104));
                break;
            }
            default: {
                super.keyPressed(n, n2, n3);
            }
        }
    }

    @Override
    public void indicateBoardbookAvailable(boolean bl) {
    }

    @Override
    public void remoteHmiDsiReady() {
        this.logChannel.log(1078071040, "HMIViewBrowserListener#remoteHmiDsiReady(): updating speedThreshold status");
        if (this.belowSpeedThreshold) {
            this.belowLowerThreshold(0);
        } else {
            this.exceedsUpperThreshold(0);
        }
    }
}


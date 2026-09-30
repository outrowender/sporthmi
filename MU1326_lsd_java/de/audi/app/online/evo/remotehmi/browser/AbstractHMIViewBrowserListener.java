/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.browser;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.ScrollMode;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

public abstract class AbstractHMIViewBrowserListener
extends AbstractHMIViewListenerEvo
implements IBrowserCallbackHandler {
    private static final int LOADING_SPINNER_VISIBLE = 1;
    private static final int LOADING_SPINNER_HIDDEN = 0;
    private ScrollMode scrollMode;
    private String lastUrl = "";
    private long lastUrlTimestamp = -1L;
    protected int pageHeight = this.getDefaultPageHeight();
    protected static final int VISIBLE_LINES_ON_ONE_SCREEN = 6;
    protected static final String EMPTY_PAGE_URL = "about:blank";
    protected final RangeModelApp scrollModel;
    protected final ChoiceModelApp browserSyncModel;
    private boolean browserSuspended = false;
    private boolean browserDeleteCache = false;
    private IBrowserHandler browserHandler = null;

    public AbstractHMIViewBrowserListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo, RangeModelApp rangeModelApp) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
        this.scrollModel = rangeModelApp;
        this.browserSyncModel = onlineModelBankAccess.getChoiceModel(2300065);
    }

    protected abstract int getDefaultPageHeight();

    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateViewProperties - loadURL :\n(%1)   \nold Url:\n(%2)", (Object)hMIProperties.getString("callUrl"), (Object)this.lastUrl);
        boolean bl2 = true;
        if (this.lastUrl != null && this.lastUrl.equals(hMIProperties.getString("callUrl"))) {
            bl2 = false;
        } else {
            this.lastUrl = hMIProperties.getString("callUrl");
            IBrowserHandler iBrowserHandler = this.getBrowserHandler();
            if (iBrowserHandler != null) {
                iBrowserHandler.setLastActiveUrl(this.lastUrl);
                this.lastUrlTimestamp = System.currentTimeMillis();
                iBrowserHandler.loadUrl(this.lastUrl, false);
            } else {
                this.logChannel.log(10000, "AbstractHMIViewBrowserListener#updateViewProperties - loadURL failed, because no browser is present");
            }
        }
        if (hMIProperties.contains("value")) {
            this.scrollModel.setLimits(0, hMIProperties.getInt("value") - 6, 1);
        } else if (bl2) {
            this.scrollModel.setLimits(0, 6, 1);
            this.scrollModel.setValue(0);
        }
        this.scrollMode = (ScrollMode)hMIProperties.get("scrollMode");
    }

    public boolean scrollDown(int n) {
        IBrowserHandler iBrowserHandler = this.getBrowserHandler();
        if (iBrowserHandler == null) {
            this.logChannel.log(10000, "AbstractHMIViewBrowserListener#scrollDown: browser handler is null");
            return false;
        }
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: scroll mode is %1", (Object)this.scrollMode);
        if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_FREE)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: Scrolling UP %1 Steps", (long)n);
            iBrowserHandler.nextFocus(n);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_PAGE_90_PERCENT)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_PAGE_90_PERCENT %1 (pageheight is %2)", (long)(this.pageHeight * 9 / 10), (long)this.pageHeight);
            iBrowserHandler.scroll(3, this.pageHeight * 9 / 10);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_5_STEPS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_5_STEPS %1", (long)(this.pageHeight * 5 / 6));
            iBrowserHandler.scroll(3, this.pageHeight * 5 / 6);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_6_STEPS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_6_STEPS %1", (long)this.pageHeight);
            iBrowserHandler.scroll(3, this.pageHeight);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_KEYS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_KEYS %1", (long)n);
            iBrowserHandler.keyboardInput("6");
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_NEXT_LINK)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_NEXT_LINK %1", (long)n);
            iBrowserHandler.nextFocus(n);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_PAGE)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_PAGE %1", (long)n);
            iBrowserHandler.scroll(3, this.pageHeight);
        }
        return true;
    }

    protected IBrowserHandler getBrowserHandler() {
        return this.browserHandler;
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        this.browserHandler = iBrowserHandler;
        if (iBrowserHandler != null) {
            this.browserHandler.setBrowserCallbackHandler(this);
        }
    }

    public boolean scrollUp(int n) {
        IBrowserHandler iBrowserHandler = this.getBrowserHandler();
        if (iBrowserHandler == null) {
            this.logChannel.log(10000, "AbstractHMIViewBrowserListener#scrollUp: browser handler is null");
            return false;
        }
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: scroll mode is %1", (Object)this.scrollMode);
        if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_FREE)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: Scrolling UP %1 Steps", (long)n);
            iBrowserHandler.prevFocus(n);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_PAGE_90_PERCENT)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: SCROLL_MODE_PAGE_90_PERCENT %1", (long)(this.pageHeight * 9 / 10));
            iBrowserHandler.scroll(2, this.pageHeight * 9 / 10);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_5_STEPS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: SCROLL_MODE_5_STEPS %1", (long)(this.pageHeight * 5 / 6));
            iBrowserHandler.scroll(2, this.pageHeight * 5 / 6);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_6_STEPS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollDown: SCROLL_MODE_6_STEPS %1", (long)this.pageHeight);
            iBrowserHandler.scroll(3, this.pageHeight);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_KEYS)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: SCROLL_MODE_KEYS %1", (long)n);
            iBrowserHandler.keyboardInput("4");
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_NEXT_LINK)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: SCROLL_MODE_NEXT_LINK %1", (long)n);
            iBrowserHandler.prevFocus(n);
        } else if (this.scrollMode.equals(ScrollMode.SCROLL_MODE_PAGE)) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#scrollUp: SCROLL_MODE_PAGE %1", (long)n);
            iBrowserHandler.scroll(2, this.pageHeight);
        }
        return true;
    }

    public void indicateBrowserStateNotFound() {
        if (this.remoteHmiService.getCurrentView() == this) {
            RemoteHMIAction remoteHMIAction = this.getAction(402);
            this.invokeAction(remoteHMIAction);
        } else {
            this.logChannel.log(1000000, "AbstractHMIViewBrowserListener#indicateBrowserStateNotFound: view not active");
        }
    }

    public void indicateBrowserStateComplete() {
        if (this.remoteHmiService.getCurrentView() == this) {
            RemoteHMIAction remoteHMIAction = this.getAction(403);
            this.invokeAction(remoteHMIAction);
        } else {
            this.logChannel.log(1000000, "AbstractHMIViewBrowserListener#indicateBrowserStateComplete: view not active");
        }
    }

    public void indicateBrowserStateTimeout() {
        if (this.remoteHmiService.getCurrentView() == this) {
            RemoteHMIAction remoteHMIAction = this.getAction(402);
            this.invokeAction(remoteHMIAction);
        } else {
            this.logChannel.log(1000000, "AbstractHMIViewBrowserListener#indicateBrowserStateTimeout: view not active");
        }
    }

    public void javascriptAlert(String string) {
        this.logChannel.log(1000000, "AbstractHMIViewBrowserListener#javascriptAlert %1", (Object)string);
        RemoteHMIAction remoteHMIAction = this.getAction(404);
        remoteHMIAction.getParameters().put("textInput", string);
        this.invokeAction(remoteHMIAction);
    }

    public boolean press() {
        if (this.scrollMode == ScrollMode.SCROLL_MODE_KEYS) {
            IBrowserHandler iBrowserHandler = this.getBrowserHandler();
            if (iBrowserHandler != null) {
                this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#press: SCROLL_MODE_KEYS key press");
                iBrowserHandler.keyboardInput("5");
            }
            RemoteHMIAction remoteHMIAction = this.getAction(401);
            this.invokeAction(remoteHMIAction);
            return true;
        }
        return false;
    }

    public void sendToBrowser(String string) {
        IBrowserHandler iBrowserHandler = this.getBrowserHandler();
        if (iBrowserHandler != null) {
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#sendToBrowser: sending text to browser %1", (Object)string);
            iBrowserHandler.keyboardInput(string);
        }
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateScrollbarY: pageContentHeight: %1, scrollPositionY: %2, visibleAreaHeight: %3", (long)n, (long)n3, (long)n2);
        int n5 = n / 60;
        this.scrollModel.setLimits(0, n5, 1);
        if (this.pageHeight != n2) {
            this.pageHeight = n2;
            this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateScrollbarY: setting pageHeight to %1", (long)this.pageHeight);
        }
        int n6 = n3;
        if (n != 0) {
            n6 += n2 * n3 / n;
        }
        this.scrollModel.setValue(n6 /= 60);
        if (n <= n2) {
            this.scrollModel.setStatus(0);
        } else {
            this.scrollModel.setStatus(1);
        }
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateScrollbarY - value is: %1, visible status is: %2", (long)n6, (long)this.scrollModel.getStatus());
        this.remoteHmiService.triggerFlushModelGroup("update-browser-scrollbar-y");
    }

    public void updateBrowserStateBusy(boolean bl) {
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateBrowserState - busy: %1", bl);
    }

    public void updateBrowserState(int n) {
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#updateBrowserState");
        if (n == 0) {
            this.browserSyncModel.setValue(1);
            this.remoteHmiService.triggerFlushModelGroup("update-browser-state");
        } else if (n == 4) {
            this.browserSyncModel.setValue(0);
            this.remoteHmiService.triggerFlushModelGroup("update-browser-state");
        }
    }

    public void onExit() {
        super.onExit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void browserLeft() {
        IBrowserHandler iBrowserHandler = this.getBrowserHandler();
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#browserLeft: Called");
        if (iBrowserHandler == null) {
            this.logChannel.log(10000, "AbstractHMIViewBrowserListener#browserLeft: browser not ready [browserHandler[RemoteHMI] == null]!");
            return;
        }
        iBrowserHandler.loadUrl(EMPTY_PAGE_URL, false);
        AbstractHMIViewBrowserListener abstractHMIViewBrowserListener = this;
        synchronized (abstractHMIViewBrowserListener) {
            this.lastUrl = EMPTY_PAGE_URL;
        }
    }

    public void wakeUp() {
        if (this.browserHandler != null) {
            this.logChannel.log(1000000, "AbstractHMIViewBrowserListener#wakeUp: waking up browser");
            this.browserHandler.wakeUp();
        } else {
            this.logChannel.log(100000, "AbstractHMIViewBrowserListener#wakeUp: no browser handler");
        }
    }

    public boolean indicateEfiUrl(String string) {
        this.logChannel.log(100000, "AbstractHMIViewBrowserListener#indicateEfiUrl(%1): forwarding EFI link to RemoteHMI handling", (Object)string);
        this.remoteHmiService.getEfiComponent().updateEfiLink(string);
        return true;
    }

    public void belowLowerThreshold(int n) {
    }

    public void exceedsUpperThreshold(int n) {
    }

    public boolean doLockModelGroup() {
        return true;
    }

    public void virtualButtonBack() {
        this.logChannel.log(10000000, "AbstractHMIViewBrowserListener#goBack called");
    }
}


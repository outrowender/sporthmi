/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.browser.app.AbstractBrowserHandler$1;
import de.audi.tghu.browser.app.AbstractBrowserHandler$2;
import de.audi.tghu.browser.app.BrowserHMIListener;
import de.audi.tghu.browser.app.BrowserModelHandler;
import java.util.Map;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.DSIBrowserListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public abstract class AbstractBrowserHandler
implements DSIBrowserListener,
IBrowserHandler,
SpeedThresholdListener,
I18NTarget {
    private static final int IDLE_TIMER_VALUE;
    public static final long SCROLLING_TIME;
    protected static final int AVAILABILITY_AVAILABLE;
    protected static final int AVAILABILITY_NOT_AVAILABLE;
    protected static final int AVAILABILITY_TEMP_NOT_AVAILABLE;
    protected static final int AVAILABILITY_NOT_ON_HDD;
    protected static final int AVAILABILITY_NOT_ON_HDD_NO_MEDIUM;
    Map browserStates = new AbstractBrowserHandler$1(this);
    volatile boolean boardBookConfigured = false;
    protected boolean contentOnHDD = false;
    private boolean lastActiveUrlOverrideActive = false;
    protected boolean languageWasChanged = false;
    protected boolean resetBrowser;
    protected boolean deleteCache;
    private boolean browserSuspended = true;
    protected DSIBrowser currentDSIBrowser = null;
    protected IFrameworkAccess framework;
    protected LogChannel logChannel;
    protected LogChannel logChannelDSI;
    private int[] browserAttributes = new int[]{3, 1, 2, 4, 10, 7};
    protected BrowserHMIListener browserListener;
    protected EfiUrlHandler efiUrlHandler;
    protected IBrowserCallbackHandler browserCallback;
    protected BrowserModelHandler modelHandler;
    private Object idleTimeoutTimerLock = new Object();
    protected int instance;
    private String lastActiveUrl = null;
    private boolean useIdleTimeout = false;
    private Timer idleTimeoutTimer = null;
    private static final String LOGCLASS;
    private static final long AUTO_HMI_LAYER_INTERVAL;
    static /* synthetic */ Class class$de$audi$tghu$browser$app$AbstractBrowserHandler;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBoardbook;

    public AbstractBrowserHandler(IFrameworkAccess iFrameworkAccess, int n, LogChannel logChannel, LogChannel logChannel2) {
        this.framework = iFrameworkAccess;
        this.logChannel = logChannel;
        this.logChannelDSI = logChannel2;
        this.instance = n;
        this.modelHandler = new BrowserModelHandler(logChannel2);
        this.browserListener = new BrowserHMIListener(this, this.instance, iFrameworkAccess, this.modelHandler, this.logChannel, this.logChannelDSI);
        this.modelHandler.setHMIListener(this.browserListener);
        if (this.modelHandler.getBrowserState() == null) {
            this.modelHandler.setBrowserState(iFrameworkAccess.getHmiServiceApp().getChoiceModel(32));
        }
        this.modelHandler.getBrowserState().setValue(-1);
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, RangeModelApp rangeModelApp, LabelModelApp labelModelApp, LabelModelApp labelModelApp2, ChoiceModelApp choiceModelApp8) {
        this.modelHandler.setVirtualButton(virtualButtonModelApp);
        this.modelHandler.setDisplayContextSwitchChoice(choiceModelApp);
        this.modelHandler.setBrowserAvailableChoice(choiceModelApp2);
        this.modelHandler.setVehicleSpeedChoice(choiceModelApp3);
        this.modelHandler.setBrowserSpeedChoice(choiceModelApp4);
        this.modelHandler.setChoiceNext(choiceModelApp5);
        this.modelHandler.setChoiceNextValue(0);
        this.modelHandler.setChoicePrev(choiceModelApp6);
        this.modelHandler.setChoicePrevValue(0);
        this.modelHandler.setChoiceSidebar(choiceModelApp7);
        this.modelHandler.setButtonCancel(buttonModelApp);
        this.modelHandler.setButtonReload(buttonModelApp2);
        this.modelHandler.setButtonBookmark(buttonModelApp3);
        this.modelHandler.setBrowserAvailableChoice(choiceModelApp2);
        this.modelHandler.setVehicleSpeedChoice(choiceModelApp3);
        this.modelHandler.setBrowserSpeedChoice(choiceModelApp4);
        this.setRangeModels(rangeModelApp);
        this.setZoomLabel(labelModelApp);
        this.setLabels(labelModelApp2);
        this.setBrowserSyncModel(choiceModelApp8);
        this.modelHandler.setBrowserSpeedChoiceValue(1);
        if (n != -1) {
            this.framework.getSysApp().registerSpeedThresholdListener(this, n);
        }
        this.startDSIBrowser(this.instance);
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3) {
        this.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, n, choiceModelApp5, choiceModelApp6, choiceModelApp7, buttonModelApp, buttonModelApp2, buttonModelApp3, null, null, null, null);
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n) {
        this.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, n, null, null, null, null, null, null);
    }

    @Override
    public void setModels(ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, ButtonModelApp buttonModelApp4, ButtonModelApp buttonModelApp5, ChoiceModelApp choiceModelApp4, ButtonModelApp buttonModelApp6) {
        this.modelHandler.setChoiceNext(choiceModelApp);
        this.modelHandler.setChoicePrev(choiceModelApp2);
        this.modelHandler.setChoiceSidebar(choiceModelApp3);
        this.modelHandler.setButtonCancel(buttonModelApp);
        this.modelHandler.setButtonReload(buttonModelApp2);
        this.modelHandler.setButtonBookmark(buttonModelApp3);
        this.modelHandler.setButtonHome(buttonModelApp4);
        this.modelHandler.setButtonIndex(buttonModelApp5);
        this.modelHandler.setKeyId(choiceModelApp4);
        this.modelHandler.setBackButton(buttonModelApp6);
    }

    public void startDSIBrowser(int n) {
        this.framework.startDSIService((class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = AbstractBrowserHandler.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser).getName(), n);
        if (n == 7) {
            this.framework.startDSIService((class$org$dsi$ifc$browser$DSIBrowserBoardbook == null ? (class$org$dsi$ifc$browser$DSIBrowserBoardbook = AbstractBrowserHandler.class$("org.dsi.ifc.browser.DSIBrowserBoardbook")) : class$org$dsi$ifc$browser$DSIBrowserBoardbook).getName(), 0);
        }
        this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#startDSIBrowser: %1").toString(), (long)n);
    }

    public void setDSIBrowser(DSIBrowser dSIBrowser) {
        if (dSIBrowser != null) {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#setDSIBrowser: %1").toString(), (Object)dSIBrowser);
            this.currentDSIBrowser = dSIBrowser;
            this.lastActiveUrlOverrideActive = false;
            this.setNotifications();
            this.setLanguageOnly(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode());
            this.modelHandler.setBrowserAvailableChoiceValue(1);
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#setDSIBrowser: setting browser to null").toString());
            this.currentDSIBrowser = null;
            this.lastActiveUrlOverrideActive = false;
            this.modelHandler.setBrowserAvailableChoiceValue(0);
        }
    }

    public BrowserHMIListener getHMIListener() {
        return this.browserListener;
    }

    void setAttributes(int[] nArray) {
        this.browserAttributes = nArray;
    }

    protected int[] getAttributes() {
        return this.browserAttributes;
    }

    @Override
    public void setRangeModels(RangeModelApp rangeModelApp) {
        this.modelHandler.setZoomer(rangeModelApp);
        this.modelHandler.setZoomerValues(10, 0, 20, 1);
    }

    @Override
    public void setZoomLabel(LabelModelApp labelModelApp) {
        this.modelHandler.setZoomLabel(labelModelApp);
        this.modelHandler.setZoomLabelText("100%");
    }

    @Override
    public void setLabels(LabelModelApp labelModelApp) {
        this.modelHandler.setLabelTitle(labelModelApp);
    }

    @Override
    public void setBrowserSyncModel(ChoiceModelApp choiceModelApp) {
        if (this.modelHandler != null) {
            this.modelHandler.setBrowserSync(choiceModelApp);
        }
    }

    @Override
    public ChoiceModelApp getBrowserSyncModel() {
        if (this.modelHandler != null) {
            return this.modelHandler.getBrowserSync();
        }
        return null;
    }

    @Override
    public void setSKAvailableChoice(ChoiceModelApp choiceModelApp) {
        this.modelHandler.setSkAvailableChoice(choiceModelApp);
        this.setCapabilityState(this.modelHandler.getSkAvailableChoice(), 2);
    }

    protected void setCapabilityState(ChoiceModelApp choiceModelApp, int n) {
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#setCapabilityState(state=%1, instance=%2)").toString(), (long)n, (long)this.instance);
        if (choiceModelApp != null) {
            switch (n) {
                case 1: {
                    choiceModelApp.setStatus(1);
                    choiceModelApp.setValue(1);
                    break;
                }
                case 2: {
                    choiceModelApp.setStatus(1);
                    choiceModelApp.setValue(-1);
                    break;
                }
                case 3: {
                    choiceModelApp.setStatus(0);
                    choiceModelApp.setValue(0);
                    break;
                }
                case 4: {
                    choiceModelApp.setStatus(2);
                    choiceModelApp.setValue(0);
                    break;
                }
                case 5: {
                    choiceModelApp.setStatus(2);
                    choiceModelApp.setValue(0);
                    break;
                }
            }
            this.modelHandler.setSkAvailableChoiceItemSelected(0, 0);
        }
    }

    @Override
    public void setEfiUrlHandler(EfiUrlHandler efiUrlHandler) {
        this.efiUrlHandler = efiUrlHandler;
    }

    protected void internalResumeBrowser() {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#internalResumeBrowser: internalResumeBrowser called!").toString());
        this.doResumeBrowser();
    }

    protected void doResumeBrowser() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler#doResumeBrowser: no DSI");
            return;
        }
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser()").toString());
        this.deleteCache = false;
        if (this.instance != 7 || this.instance == 7 && this.contentOnHDD) {
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: hiding browser layer").toString());
            this.modelHandler.setDisplayContextSwitchChoiceValue(0);
            if (this.lastActiveUrl == null && !this.lastActiveUrlOverrideActive) {
                if (this.lastActiveUrlOverrideActive) {
                    this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: last active URL is null, but override already active").toString());
                } else {
                    this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: last active URL is null, loading start page").toString());
                    this.lastActiveUrlOverrideActive = true;
                    this.currentDSIBrowser.deleteHistory();
                    if (this.efiUrlHandler != null) {
                        this.efiUrlHandler.gotoHomeURL();
                    } else {
                        this.logChannelDSI.log(-1601830656, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: no EFI URL handler, using DSIBrowser.gotoHomeUrl").toString());
                        this.currentDSIBrowser.gotoHomeUrl();
                    }
                }
            }
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: bring Browser to front").toString());
            this.currentDSIBrowser.bringToFront();
            if (this.browserSuspended) {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: dsiBrowser.resumeBrowser()").toString());
                this.currentDSIBrowser.resumeBrowser();
            } else {
                this.logChannelDSI.log(1078071040, "%1#doResumeBrowser: switch to HMI-BrowserContext", (Object)LOGCLASS);
                this.modelHandler.setDisplayContextSwitchChoiceValue(4);
            }
            this.modelHandler.getBrowserState().setValue(this.instance);
            if (this.instance == 7) {
                this.resetBrowser = true;
            }
        } else {
            this.logChannel.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#doResumeBrowser: no content on HDD, nothing to do").toString());
        }
    }

    @Override
    public void resumeBrowser() {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#resumeBrowser: ignoring resumeBrowser call").toString());
    }

    public void bringToFront() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "DefaultBrowserHandler.bringToFront: no DSI");
            return;
        }
        if (this.instance != 7 || this.instance == 7 && this.contentOnHDD) {
            if (this.modelHandler.getBrowserState().getValue() != this.instance) {
                this.logChannelDSI.log(1078071040, " %1#bringToFront(): dsiBrowser.bringToFront()", (Object)LOGCLASS);
                this.currentDSIBrowser.bringToFront();
                this.modelHandler.getBrowserState().setValue(this.instance);
                if (this.instance == 7) {
                    this.resetBrowser = true;
                }
            } else {
                this.logChannelDSI.log(1078071040, "%1#bringToFront(): no need to start Browser", (Object)LOGCLASS);
            }
        } else {
            this.logChannel.log(1078071040, "%1#bringToFront(): no content on HDD, nothing to do", (Object)LOGCLASS);
        }
    }

    @Override
    public void loadUrl(String string, boolean bl) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler.loadUrl url=%1: no DSI", (Object)string);
            return;
        }
        this.deleteCache = bl;
        this.setBrowserSyncStatus(0);
        if (string != null) {
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#loadUrl url=%1 and BrowserInstance %2").toString(), (Object)string, (long)this.instance);
            this.currentDSIBrowser.loadUrl(string);
        } else {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#loadUrl(..): no URL found").toString());
        }
        this.currentDSIBrowser.bringToFront();
        this.currentDSIBrowser.resumeBrowser();
        if (this.useIdleTimeout) {
            this.startIdleTimeoutTimer();
        }
    }

    @Override
    public void suspendBrowser() {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#suspendBrowser: ignoring suspendBrowser call").toString());
    }

    protected void internalSuspendBrowser() {
        this.logChannelDSI.log(1078071040, "%1#internalSuspendBrowser: internalSuspendBrowser called!", (Object)LOGCLASS);
        this.doSuspendBrowser();
    }

    protected void doSuspendBrowser() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler#internalSuspendBrowser: no DSI");
            return;
        }
        if (this.modelHandler.getBrowserState().getValue() == this.instance || this.modelHandler.getBrowserState().getValue() == -1) {
            this.logChannelDSI.log(1078071040, "%1#doSuspendBrowser: dsiBrowser.suspendBrowser()", (Object)LOGCLASS);
            this.currentDSIBrowser.suspendBrowser();
            this.modelHandler.setDisplayContextSwitchChoiceValue(0);
            this.modelHandler.getBrowserState().setValue(-1);
        } else {
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#doSuspendBrowser: ignore because instance is not active. active=%1, instance=%2").toString(), (long)this.modelHandler.getBrowserState().getValue(), (long)this.instance);
        }
    }

    @Override
    public void browserScreenEnteredByHistory() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler.browserScreenEnteredByHistory: no DSI");
            return;
        }
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#browserScreenEnteredByHistory()").toString());
        this.deleteCache = false;
        if (this.contentOnHDD) {
            if (this.modelHandler.getBrowserState().getValue() != this.instance) {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#browserScreenEnteredByHistory: hiding browser layer").toString());
                this.modelHandler.setDisplayContextSwitchChoiceValue(0);
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#browserScreenEnteredByHistory: dsiBrowser.startBrowser()").toString());
                this.currentDSIBrowser.bringToFront();
                if (this.browserSuspended) {
                    this.currentDSIBrowser.resumeBrowser();
                }
                this.modelHandler.getBrowserState().setValue(this.instance);
            } else {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#browserScreenEnteredByHistory: no need to start Browser").toString());
            }
        } else {
            this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#browserScreenEnteredByHistory(): no content on HDD, nothing to do").toString());
        }
    }

    @Override
    public void setLanguage(String string) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler.setLanguage: no DSI");
            return;
        }
        this.logChannelDSI.log(1078071040, "DefaultBrowserHandler: dsiBrowser.setLanguage(): %1", (Object)string);
        this.currentDSIBrowser.setLanguage(string);
        this.currentDSIBrowser.stopBrowser();
        this.languageWasChanged = true;
    }

    private void setLanguageOnly(String string) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler.setLanguage: no DSI");
            return;
        }
        this.logChannelDSI.log(1078071040, "DefaultBrowserHandler: dsiBrowser.setLanguage(): %1", (Object)string);
        this.currentDSIBrowser.setLanguage(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void stopIdleTimeoutTimer() {
        if (!this.useIdleTimeout) {
            return;
        }
        if (this.idleTimeoutTimer != null) {
            this.logChannel.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#stopIdleTimeoutTimer: cancelled IDLE timer").toString());
            Object object = this.idleTimeoutTimerLock;
            synchronized (object) {
                this.idleTimeoutTimer.cancel();
                this.idleTimeoutTimer = null;
            }
        } else {
            this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#stopIdleTimeoutTimer: no timer").toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startIdleTimeoutTimer() {
        if (!this.useIdleTimeout) {
            return;
        }
        Object object = this.idleTimeoutTimerLock;
        synchronized (object) {
            if (this.idleTimeoutTimer != null) {
                this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#startIdleTimeoutTimer: another timer is active, returning").toString());
                return;
            }
        }
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#startIdleTimeoutTimer: starting IDLE timer").toString());
        object = new Timer("DefaultBrowserHandler_IDLE", 0, true, new AbstractBrowserHandler$2(this));
        ((Timer)object).start();
        Object object2 = this.idleTimeoutTimerLock;
        synchronized (object2) {
            this.idleTimeoutTimer = object;
        }
    }

    protected void handleIdleTimeout() {
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#handleIdleTimeout: indicating error state").toString());
        this.setBrowserSyncStatus(2);
        this.indicateBrowserStateTimeout();
    }

    protected void indicateBrowserStateTimeout() {
        if (this.browserCallback != null) {
            this.browserCallback.indicateBrowserStateTimeout();
        }
    }

    protected void indicateBrowserStateNotFound() {
        if (this.browserCallback != null) {
            this.browserCallback.indicateBrowserStateNotFound();
        }
    }

    protected void indicateBrowserStateComplete() {
        if (this.browserCallback != null) {
            this.browserCallback.indicateBrowserStateComplete();
        }
    }

    protected void setBrowserSyncValue(int n) {
        if (this.modelHandler.getBrowserSync() != null) {
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#setBrowserSyncValue(%1)").toString(), (long)n);
            this.modelHandler.getBrowserSync().setValue(n);
        }
    }

    @Override
    public void setBrowserSyncStatus(int n) {
        if (this.modelHandler.getBrowserSync() != null) {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#setBrowserSyncStatus(%1)").toString(), (long)n);
            int n2 = this.modelHandler.getBrowserSync().getStatus();
            if (n2 != n) {
                this.modelHandler.getBrowserSync().setStatus(n);
            }
        }
    }

    @Override
    public void updatePageTitle(String string, int n) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updatePageTitle %1").toString(), (Object)string);
        if (n != 1) {
            this.logChannelDSI.log(1078071040, "updatePageTitle invalid");
            return;
        }
        if (this.modelHandler.getLabelTitle() != null) {
            this.modelHandler.getLabelTitle().setText(string);
        }
    }

    @Override
    public void updateActiveUrl(String string, int n) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateActiveUrl %1").toString(), (Object)string);
        if (this.efiUrlHandler != null) {
            this.efiUrlHandler.updateActiveUrl(string);
        }
        this.lastActiveUrl = string;
    }

    @Override
    public void updateZoomFactor(int n, int n2) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateZoomFactor %1").toString(), (long)n);
        if (n2 != 1) {
            this.logChannelDSI.log(1078071040, "updateZoomFactor invalid");
            return;
        }
        if (this.modelHandler.getZoomer() != null) {
            int n3 = n / 10;
            if (n3 < this.modelHandler.getZoomerMin()) {
                n3 = this.modelHandler.getZoomerMin();
            } else if (n3 > this.modelHandler.getZoomerMax()) {
                n3 = this.modelHandler.getZoomerMax();
            }
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateZoomFactor zoomer.setValue %1").toString(), (long)n3);
            this.modelHandler.setZoomerValue(n3);
        }
        this.modelHandler.setZoomLabelText(new StringBuffer().append(Integer.toString(n)).append("%").toString());
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#asyncException: msg=%1, code=%2, type=%3").toString(), (Object)string, (long)n, (long)n2);
    }

    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
        if (this.efiUrlHandler != null) {
            this.efiUrlHandler.showSpeller(string, string2, string3, bl, s);
        }
    }

    @Override
    public int reloadUrl() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#reloadUrl: no DSI").toString());
            return -1;
        }
        this.logChannelDSI.log(-2137614336, "Reload url");
        this.currentDSIBrowser.reloadUrl();
        return 0;
    }

    @Override
    public void resumeBrowserResult(int n) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#resumeBrowserResult %1").toString(), (long)n);
    }

    @Override
    public void indicateDownloadUrl(String string) {
    }

    @Override
    public void indicateEfiUrl(String string) {
        this.logChannel.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#indicateEfiUrl( %1 )").toString(), (Object)string);
        boolean bl = false;
        if (this.browserCallback != null) {
            this.logChannel.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#indicateEfiUrl(): forwarding URL to callback").toString());
            bl = this.browserCallback.indicateEfiUrl(string);
        }
        if (!bl && this.efiUrlHandler != null) {
            this.logChannel.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#indicateEfiUrl(): using browser EFI URL handling").toString());
            this.efiUrlHandler.updateEfiUrl(string);
        }
    }

    @Override
    public void javascriptAlert(String string) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#javascriptAlert: no DSI").toString());
            return;
        }
        if (this.browserCallback != null) {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#javascriptAlert: sending message %1 to callback").toString(), (Object)string);
            this.browserCallback.javascriptAlert(string);
        }
        this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#javascriptAlert: sending ACK").toString());
        this.currentDSIBrowser.javaScriptAlertAck();
    }

    @Override
    public void javascriptConfirm(String string) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#javascriptConfirm: no DSI").toString());
            return;
        }
        this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#javascriptConfirm: sending ACK").toString());
        this.currentDSIBrowser.javaScriptConfirmAck(true);
    }

    @Override
    public void javascriptPrompt(String string, String string2) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#javascriptConfirm: no DSI").toString());
            return;
        }
        this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#javascriptConfirm: sending ACK").toString());
        this.currentDSIBrowser.javaScriptPromptAck("", true);
    }

    @Override
    public void updateHasFocus(boolean bl, int n) {
    }

    @Override
    public void updateScrollbarX(int n, int n2, int n3, int n4) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateScrollbarX").toString());
        if (this.browserCallback != null) {
            this.browserCallback.updateScrollbarX(n, n2, n3, n4);
        }
    }

    @Override
    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateScrollbarY").toString());
        if (this.browserCallback != null) {
            this.browserCallback.updateScrollbarY(n, n2, n3, n4);
        }
    }

    @Override
    public void stopBrowser() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "ERR: DefaultBrowserHandler.stopBrowser: no DSI");
            return;
        }
        this.logChannelDSI.log(1078071040, "DefaultBrowserHandler: dsiBrowser.stopBrowser()");
        this.currentDSIBrowser.stopBrowser();
        this.modelHandler.getBrowserState().setValue(-1);
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#belowLowerThreshold(%1)").toString(), (long)n);
        this.modelHandler.setVehicleSpeedChoiceValue(1);
        if (this.browserCallback != null) {
            this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#belowLowerThreshold(%1) - forwarding to callback").toString(), (long)n);
            this.browserCallback.belowLowerThreshold(n);
        }
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#exceedsUpperThreshold(%1)").toString(), (long)n);
        this.modelHandler.setVehicleSpeedChoiceValue(0);
        if (this.browserCallback != null) {
            this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#exceedsUpperThreshold(%1) - forwarding to callback").toString(), (long)n);
            this.browserCallback.exceedsUpperThreshold(n);
        }
    }

    @Override
    public void setLanguage(Language language) {
        this.logChannel.log(1078071040, new StringBuffer().append(LOGCLASS).append("#setLanguage: setting language %1").toString(), (Object)language);
        this.setLanguage(language.getLanguageCode());
    }

    @Override
    public void setBrowserCallbackHandler(IBrowserCallbackHandler iBrowserCallbackHandler) {
        this.browserCallback = iBrowserCallbackHandler;
        if (this.browserListener != null) {
            this.browserListener.setCallbackHandler(iBrowserCallbackHandler);
        }
    }

    @Override
    public IBrowserCallbackHandler getBrowserCallBackHandler() {
        return this.browserCallback;
    }

    @Override
    public String getLastActiveUrl() {
        return this.lastActiveUrl;
    }

    @Override
    public void setLastActiveUrl(String string) {
        this.lastActiveUrl = string;
    }

    public void setUseTimeoutHandling(boolean bl) {
        this.useIdleTimeout = bl;
    }

    @Override
    public void updateButtonState(int n, int n2, int n3) {
        this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#updateButtonState %1 %2").toString(), (Object)String.valueOf(n), (Object)(n2 == 0 ? "Active" : "Inactive"));
        if (n3 != 1) {
            this.logChannelDSI.log(1078071040, "updateButtonState invalid");
            return;
        }
        switch (n) {
            case 2: {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState BUTTON_HOME called, ignored").toString());
                break;
            }
            case 1: {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState BUTTON_FORWARD called, setChoiceNextValue(%1)").toString(), n2 == 0 ? 1L : 0L);
                this.modelHandler.setChoiceNextValue(n2 == 0 ? 1 : 0);
                break;
            }
            case 0: {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState BUTTON_BACK called, setChoicePrevValue(%1)").toString(), n2 == 0 ? 1L : 0L);
                this.modelHandler.setChoicePrevValue(n2 == 0 ? 1 : 0);
                break;
            }
            case 3: {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState BUTTON_CANCEL called").toString());
                ChoiceModelApp choiceModelApp = this.modelHandler.getBrowserSync();
                if (choiceModelApp != null) {
                    this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState Setting BrowserSyncState to ERROR! ").toString());
                    break;
                }
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState browserSyncModel == NULL").toString());
                break;
            }
            case 4: {
                this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateButtonState BUTTON_RELOAD called, ignored").toString());
                break;
            }
        }
    }

    @Override
    public void updateBrowserState(int n, int n2) {
        this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("#updateBrowserState %1").toString(), this.browserStates.get(new Integer(n)));
        if (n2 != 1) {
            this.logChannelDSI.log(1078071040, new StringBuffer().append(LOGCLASS).append("updateBrowserState invalid").toString());
            return;
        }
        switch (n) {
            case 4: {
                this.browserSuspended = false;
                if (this.deleteCache) {
                    this.deleteHistory();
                    this.deleteCache = false;
                }
                this.setBrowserSyncStatus(1);
                this.indicateBrowserStateComplete();
                break;
            }
            case 6: {
                this.browserSuspended = false;
                this.modelHandler.setDisplayContextSwitchChoiceValue(4);
                this.stopIdleTimeoutTimer();
                break;
            }
            case 2: {
                this.browserSuspended = false;
                if (this.deleteCache) {
                    this.deleteHistory();
                    this.deleteCache = false;
                }
                this.setBrowserSyncStatus(2);
                this.indicateBrowserStateNotFound();
                this.stopIdleTimeoutTimer();
                break;
            }
            case 3: {
                this.stopIdleTimeoutTimer();
                this.browserSuspended = true;
                this.setBrowserSyncStatus(3);
                break;
            }
            case 1: {
                if (this.instance == 7 || this.instance == 2 || this.instance == 5) {
                    this.modelHandler.setDisplayContextSwitchChoiceValue(4);
                }
                this.browserSuspended = false;
                break;
            }
        }
        this.setBrowserSyncValue(n);
        if (this.browserCallback != null) {
            this.browserCallback.updateBrowserStateBusy(this.isBrowserLoading(n));
            this.browserCallback.updateBrowserState(n);
        }
    }

    private boolean isBrowserLoading(int n) {
        return n == 0 || n == 1 || n == 6;
    }

    @Override
    public void indicateUnknownMimeType(String string, String string2) {
    }

    @Override
    public void updateEncryption(boolean bl, int n) {
    }

    @Override
    public void indicateDownloadProgress(String string, String string2, int n) {
    }

    @Override
    public void indicatePopup(String string) {
    }

    @Override
    public void updateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) {
    }

    @Override
    public void updateVirtualKeyboardStatus(boolean bl, int n) {
    }

    @Override
    public void deleteHistory() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#deleteHistory: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#deleteHistory: calling DSI").toString());
            this.currentDSIBrowser.deleteHistory();
        }
    }

    @Override
    public void setNotifications() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#setNotification: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#setNotification: calling DSI").toString());
            this.currentDSIBrowser.setNotification(this.getAttributes(), (DSIListener)this);
        }
    }

    @Override
    public void keyboardInput(String string) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#keyboardInput: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#keyboardInput: sending %1").toString(), (Object)string);
            this.currentDSIBrowser.keyboardInput(string);
        }
    }

    @Override
    public void wakeUp() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#wakeUp: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#wakeUp: calling DSI").toString());
            this.currentDSIBrowser.loadUrl("about:blank");
        }
    }

    @Override
    public void cancelLoading() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#cancelLoading: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#cancelLoading: calling DSI").toString());
            this.currentDSIBrowser.cancelLoading();
        }
    }

    @Override
    public void followLink(boolean bl) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, "%1#followLink: no DSI", (Object)LOGCLASS);
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#followLink: newWindow(%1) calling DSI").toString(), bl);
            this.currentDSIBrowser.followLink(bl);
        }
    }

    @Override
    public void goForward() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#goForward: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#goForward: calling DSI").toString());
            this.currentDSIBrowser.goForward();
        }
    }

    @Override
    public void zoom(int n, boolean bl) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#zoom: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#zoom: factor(%1) calling DSI").toString(), (long)n);
            this.currentDSIBrowser.zoom(n, bl);
        }
    }

    @Override
    public void scroll(int n, int n2) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#scroll: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#scroll: dir(%1), steps(%2) (calling DSI)").toString());
            this.currentDSIBrowser.scroll(n, n2);
        }
    }

    @Override
    public void nextFocus(int n) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#nextFocus: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#nextFocus: steps(%1) calling DSI").toString(), (long)n);
            this.currentDSIBrowser.nextFocus(n);
        }
    }

    @Override
    public void prevFocus(int n) {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#prevFocus: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#prevFocus: steps(%1) calling DSI").toString(), (long)n);
            this.currentDSIBrowser.previousFocus(n);
        }
    }

    @Override
    public void goBack() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#goBack: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#goBack: calling DSI").toString());
            this.currentDSIBrowser.goBack();
        }
    }

    @Override
    public void gotoHomeUrl() {
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(10000, new StringBuffer().append(LOGCLASS).append("#gotoHomeUrl: no DSI").toString());
        } else {
            this.logChannelDSI.log(-2137614336, new StringBuffer().append(LOGCLASS).append("#gotoHomeUrl calling DSI").toString());
            this.currentDSIBrowser.gotoHomeUrl();
        }
    }

    @Override
    public void exportBrowserDataResult(int n) {
    }

    @Override
    public void importBrowserDataResult(int n) {
    }

    @Override
    public void getHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
    }

    @Override
    public void openBoardbookStartPage() {
    }

    @Override
    public void setBoardBookConfigured(boolean bl) {
    }

    @Override
    public void startBoardbook() {
    }

    @Override
    public void updateProgress(int n, int n2) {
    }

    @Override
    public void getPreferenceResult(int n, int n2, String string) {
    }

    @Override
    public void resetToFactorySettings() {
        this.logChannelDSI.log(-2137614336, "AbstractBrowserHandler#resetTofactorySettings()");
        if (this.currentDSIBrowser == null) {
            this.logChannelDSI.log(-1601830656, "AbstractBrowserHandler#resetTofactorySettings() no DSI");
        } else {
            this.currentDSIBrowser.resetToFactoryDefaults();
        }
    }

    @Override
    public void setBoardBookAvailableModel(ChoiceModelApp choiceModelApp) {
        this.modelHandler.setBoardbookAvailableChoice(choiceModelApp);
    }

    @Override
    public void touchScreenPressed(int n, int n2) {
        this.logChannelDSI.log(-2137614336, "AbstractBrowserHandler#touchScreenPressed x = %1 y = %2", (long)n, (long)n2);
        this.currentDSIBrowser.clickOnPosition(n, n2, false);
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4) {
        int n5 = n - n3;
        int n6 = n2 - n4;
        this.logChannelDSI.log(-2137614336, "AbstractBrowserHandler#touchScreenMoved x = %1 y = %2", (long)n5, (long)n6);
        this.currentDSIBrowser.touchScroll(n5, n6);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ String access$000() {
        return LOGCLASS;
    }

    static /* synthetic */ Object access$100(AbstractBrowserHandler abstractBrowserHandler) {
        return abstractBrowserHandler.idleTimeoutTimerLock;
    }

    static /* synthetic */ Timer access$202(AbstractBrowserHandler abstractBrowserHandler, Timer timer) {
        abstractBrowserHandler.idleTimeoutTimer = timer;
        return abstractBrowserHandler.idleTimeoutTimer;
    }

    static {
        LOGCLASS = (class$de$audi$tghu$browser$app$AbstractBrowserHandler == null ? (class$de$audi$tghu$browser$app$AbstractBrowserHandler = AbstractBrowserHandler.class$("de.audi.tghu.browser.app.AbstractBrowserHandler")) : class$de$audi$tghu$browser$app$AbstractBrowserHandler).getName();
    }
}


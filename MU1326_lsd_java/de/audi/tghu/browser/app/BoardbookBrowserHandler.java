/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.browser.app.AbstractBrowserHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.DSIBrowserBoardbook;
import org.dsi.ifc.browser.DSIBrowserBoardbookListener;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SearchHit;

public class BoardbookBrowserHandler
extends AbstractBrowserHandler
implements DSIBrowserBoardbookListener {
    private int[] browserBoardbookAttributes = new int[]{1};
    protected volatile DSIBrowserBoardbook dsiBrowserBoardbook;
    private boolean browserWasStarted;
    private SwDlObserver swDlObserver;
    private int previousBoardbookStatus = -1;
    private boolean statusReadyFirstTime = true;

    public BoardbookBrowserHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, 7, logChannel, logChannel2);
    }

    public void resumeBrowser() {
        if (this.dsiBrowserBoardbook == null) {
            this.logChannelDSI.log(10000, "BoardbookBrowserHandler.resumeBrowser: no DSIBrowserBoardbook");
            return;
        }
        if (this.languageWasChanged && this.browserWasStarted) {
            this.logChannelDSI.log(10000000, "BoardbookBrowserHandler.resumeBrowser: handling special case after language change");
            this.openBoardbookStartPage();
            super.doResumeBrowser();
            this.languageWasChanged = false;
        } else if (!this.browserWasStarted) {
            this.logChannelDSI.log(10000000, "BoardbookBrowserHandler.resumeBrowser: calling openPage");
            this.openBoardbookStartPage();
        } else {
            this.logChannelDSI.log(10000000, "BoardbookBrowserHandler.resumeBrowser: calling resumeBrowser");
            super.doResumeBrowser();
        }
    }

    public void suspendBrowser() {
        super.doSuspendBrowser();
    }

    public void startBoardbook() {
        if (this.dsiBrowserBoardbook == null) {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.startBoardbook(): no DSIBrowserBoardbook");
            return;
        }
        if (this.boardBookConfigured) {
            if ((this.modelHandler.getSkAvailableChoiceStatus() != 1 || this.modelHandler.getSkAvailableChoiceValue() != 1) && this.modelHandler.getSkAvailableChoiceStatus() != 2) {
                this.logChannel.log(1000000, "BoardbookBrowserHandler.startBoardbook(): Disabling boardbook button");
                this.setCapabilityState(this.modelHandler.getSkAvailableChoice(), 3);
            }
            this.logChannel.log(1000000, "BoardbookBrowserHandler.startBoardbook(): Calling startBoardbook DSI");
            this.dsiBrowserBoardbook.startBoardbook(7, this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode());
        } else {
            this.logChannel.log(1000000, "BoardbookBrowserHandler.startBoardbook(): Boardbook was not configured");
        }
    }

    private void startWaitingFowSwDl() {
        if (this.swDlObserver == null) {
            this.swDlObserver = new SwDlObserver(this.framework, this, this.modelHandler.getSkAvailableChoice(), this.logChannel);
        }
        this.swDlObserver.start();
    }

    public void setDSIBrowserBoardbook(DSIBrowserBoardbook dSIBrowserBoardbook) {
        if (dSIBrowserBoardbook == null) {
            this.logChannelDSI.log(10000, "ERR: BoardbookBrowserHandler.setNotifications: no DSIBrowserBoardbook");
            return;
        }
        this.dsiBrowserBoardbook = dSIBrowserBoardbook;
        this.logChannelDSI.log(10000000, "BoardbookBrowserHandler.setDSIBrowserBoardbook: %1", (Object)dSIBrowserBoardbook);
        dSIBrowserBoardbook.setNotification(this.browserBoardbookAttributes, (DSIListener)this);
        this.tryStartBoardbook();
    }

    private void tryStartBoardbook() {
        if (this.dsiBrowserBoardbook != null && this.currentDSIBrowser != null) {
            this.startBoardbook();
        } else {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.tryStartBoardbook(): both browser and boardbook DSI have to be present");
        }
    }

    public void setDSIBrowser(DSIBrowser dSIBrowser) {
        super.setDSIBrowser(dSIBrowser);
        this.logChannelDSI.log(10000000, "BoardbookBrowserHandler.setDSIBrowser: %1", (Object)dSIBrowser);
        if (dSIBrowser != null) {
            this.tryStartBoardbook();
        }
    }

    public void indicateSearchResults(String string, int n, SearchHit[] searchHitArray, int n2) {
    }

    public void setBoardBookConfigured(boolean bl) {
        this.boardBookConfigured = bl;
        if (this.dsiBrowserBoardbook != null && this.currentDSIBrowser != null) {
            this.startBoardbook();
        } else {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.setBoardBookConfigured(): both browser and boardbook DSI have to be present");
        }
    }

    public void updateBoardbookStatus(int n, int n2) {
        switch (n) {
            case 2: {
                this.contentOnHDD = true;
                this.logChannelDSI.log(1000000, "BoardbookBrowserHandler#updateBoardbookStatus(): BOARDBOOKSTATUS_READY");
                if (!this.statusReadyFirstTime && this.previousBoardbookStatus != n) {
                    this.openBoardbookStartPage();
                }
                this.statusReadyFirstTime = false;
                this.modelHandler.setBoardbookAvailableValue(1);
                this.modelHandler.setBoardbookAvailableStatus(1);
                this.browserCallback.indicateBoardbookAvailable(true);
                this.setCapabilityState(this.modelHandler.getSkAvailableChoice(), 1);
                break;
            }
            case 3: {
                this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.updateBoardbookStatus(): BOARDBOOKSTATUS_NOT_PRESENT");
                this.setCapabilityState(this.modelHandler.getSkAvailableChoice(), 4);
                this.modelHandler.setBoardbookAvailableValue(2);
                break;
            }
            case 4: {
                this.logChannelDSI.log(10000, "BoardbookBrowserHandler.updateBoardbookStatus(): BOARDBOOKSTATUS_ERROR");
                this.modelHandler.setBoardbookAvailableValue(2);
                break;
            }
        }
        this.previousBoardbookStatus = n;
    }

    public void setLanguage(String string) {
        super.setLanguage(string);
        if (this.dsiBrowserBoardbook != null) {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.setLanguage(%1): forwarding language change to boardbook", (Object)string);
            this.dsiBrowserBoardbook.setLanguage(string);
        }
    }

    public void openBoardbookStartPage() {
        if (this.dsiBrowserBoardbook != null) {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler#openBoardbookStartPage: loading start page");
            this.dsiBrowserBoardbook.openPage(2);
            this.bringToFront();
            this.browserWasStarted = true;
        }
    }

    public void openPage(int n) {
        if (this.dsiBrowserBoardbook == null) {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.openPage(): No DSI");
        } else {
            this.logChannelDSI.log(1000000, "BoardbookBrowserHandler.openPage(): boardBookPageIndex(%1)", (long)n);
            this.dsiBrowserBoardbook.openPage(n);
        }
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }

    private static class SwDlObserver
    implements TimerListener {
        private Timer timer = null;
        private IFrameworkAccess framework;
        private AbstractBrowserHandler browserHandler;
        private ChoiceModelApp skAvailableChoice;
        private LogChannel logChannel;

        SwDlObserver(IFrameworkAccess iFrameworkAccess, AbstractBrowserHandler abstractBrowserHandler, ChoiceModelApp choiceModelApp, LogChannel logChannel) {
            this.framework = iFrameworkAccess;
            this.browserHandler = abstractBrowserHandler;
            this.skAvailableChoice = choiceModelApp;
            this.logChannel = logChannel;
            this.timer = new Timer("SwDlObserver", 5000L, true, this);
        }

        public void start() {
            this.timer.restart();
            this.logChannel.log(1000000, "BoardbookBrowserHandler: SwDlObserver started");
        }

        public void fireTimer(Timer timer) {
            if (this.framework.isAppSwdlStarted()) {
                this.browserHandler.setCapabilityState(this.skAvailableChoice, 1);
                this.logChannel.log(1000000, "BoardbookBrowserHandler: SwDlObserver: SwDl found, SK Manual enabled");
            } else {
                timer.restart();
                this.logChannel.log(1000000, "BoardbookBrowserHandler: SwDlObserver restarted");
            }
        }

        public void cancelTimer(Timer timer) {
        }
    }
}


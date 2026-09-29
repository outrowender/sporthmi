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

class BoardbookBrowserHandler$SwDlObserver
implements TimerListener {
    private Timer timer = null;
    private IFrameworkAccess framework;
    private AbstractBrowserHandler browserHandler;
    private ChoiceModelApp skAvailableChoice;
    private LogChannel logChannel;

    BoardbookBrowserHandler$SwDlObserver(IFrameworkAccess iFrameworkAccess, AbstractBrowserHandler abstractBrowserHandler, ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.browserHandler = abstractBrowserHandler;
        this.skAvailableChoice = choiceModelApp;
        this.logChannel = logChannel;
        this.timer = new Timer("SwDlObserver", 0, true, this);
    }

    public void start() {
        this.timer.restart();
        this.logChannel.log(1078071040, "BoardbookBrowserHandler: SwDlObserver started");
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.framework.isAppSwdlStarted()) {
            this.browserHandler.setCapabilityState(this.skAvailableChoice, 1);
            this.logChannel.log(1078071040, "BoardbookBrowserHandler: SwDlObserver: SwDl found, SK Manual enabled");
        } else {
            timer.restart();
            this.logChannel.log(1078071040, "BoardbookBrowserHandler: SwDlObserver restarted");
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}


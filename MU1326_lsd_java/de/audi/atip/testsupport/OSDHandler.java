/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.atip.testsupport.ITestSupportSession;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public final class OSDHandler
implements ITestSupportDataProvider,
TimerListener {
    private final ITestSupportService testSupportService;
    private final ITestSupportSession testSupportSession;
    private final IOSDDataProvider data;
    private final Timer updateTimer;
    private volatile boolean visible = false;

    public OSDHandler(ITestSupportService iTestSupportService, IOSDDataProvider iOSDDataProvider, boolean bl) {
        this.testSupportService = iTestSupportService;
        if (iOSDDataProvider == null) {
            throw new IllegalArgumentException("\"IOSDDataProvider data\" must not be null!");
        }
        this.data = iOSDDataProvider;
        this.testSupportSession = iTestSupportService.registerDataProvider(this);
        this.testSupportSession.activateMenuEntry(true);
        iOSDDataProvider.setTestSupport(this.testSupportSession);
        this.updateTimer = bl ? new Timer("TemplateOnscreenStatistics", 1000L, false, this) : null;
    }

    public void cleanup() {
        if (this.updateTimer != null) {
            this.updateTimer.cancel();
        }
        this.data.setTestSupport(null);
        this.testSupportSession.activateMenuEntry(false);
        this.testSupportService.deRegisterDataProvider(this);
    }

    public synchronized void updateData() {
        if (this.visible) {
            this.testSupportSession.updateData(this.data.getData());
        }
    }

    public synchronized void updateStatus(int n) {
        this.visible = n == 2 || n == 3;
        this.updateData();
        if (this.visible) {
            if (this.updateTimer != null) {
                this.updateTimer.restart();
            }
        } else if (this.updateTimer != null) {
            this.updateTimer.cancel();
        }
    }

    public String getDataProviderName() {
        return this.data.getName();
    }

    public void fireTimer(Timer timer) {
        this.updateData();
    }

    public void cancelTimer(Timer timer) {
    }
}


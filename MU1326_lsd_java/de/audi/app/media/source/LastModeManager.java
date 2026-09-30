/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.persistence.IMediaPersistence;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.ISourceStartupListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class LastModeManager
extends AbstractMediaTerminalComponent
implements ISourceSlotListener,
TimerListener {
    private static final String LOGCLASS = "LastModeManager";
    private static final long TIMER_TIMEOUT = 5000L;
    private static final int MAX_TIMER_RETRIES_DEFAULT = 1;
    private static final int MAX_TIMER_RETRIES_AUX_USB = 2;
    private static final int MAX_TIMER_RETRIES_BT = 3;
    private static final int MAX_TIMER_RETRIES_WLAN = 8;
    private static final int MAX_TIMER_RETRIES_OPTICAL = 2;
    private static final int MAX_TIMER_RETRIES_ONLINE = 25;
    private final Timer startupTimer = new Timer("LastModeStartupTimer", 5, null, this, 5000L, true);
    private volatile ISource lastModeSource = null;
    private volatile int lastModeSlotIdx = 0;
    private ISourceStartupListener startupListener = null;
    private int timerRetries = 0;
    private volatile int maxTimerRetries = 1;
    private boolean started = false;

    public LastModeManager(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        int n = this.getTerminal().getConfiguration().getLastModeSource();
        if (n != -1) {
            this.logger.main().log(1000000, "[%1.init] use configuration", (Object)LOGCLASS);
            ISource iSource = this.getTerminal().getSourceController().getSource(n);
            if (iSource != null) {
                this.lastModeSource = iSource;
                this.lastModeSlotIdx = 0;
                return;
            }
            this.logger.main().log(1000000, "[%1.init] Source not exists", (Object)LOGCLASS);
        }
        int n2 = this.getTerminal().getConfiguration().isSourceInstalled(2) ? 2 : 0;
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_LAST_ACTIVE_SOURCE", 0, 13, n2);
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_LAST_ACTIVE_SLOT", 0, 6, 0);
        int n3 = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_LAST_ACTIVE_SOURCE");
        this.lastModeSlotIdx = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_LAST_ACTIVE_SLOT");
        this.logger.main().log(1000000, "[%1.init] '%2' (slotIdx='%3')", (Object)LOGCLASS, (Object)LogUtil.getSourceTypeStr(n3), (long)this.lastModeSlotIdx);
        this.lastModeSource = this.getTerminal().getSourceController().getSource(n3);
        if (this.lastModeSource == null) {
            this.logger.main().log(1000000, "[%1.init] Source not exist", (Object)LOGCLASS);
            for (int i2 = 0; i2 < 14; ++i2) {
                ISource iSource = this.getTerminal().getSourceController().getSource(i2);
                if (iSource == null) continue;
                this.logger.main().log(1000000, "[%1.init] Source '%2' found", (Object)LOGCLASS, (Object)iSource);
                this.lastModeSource = iSource;
                this.lastModeSlotIdx = 0;
                break;
            }
            if (this.lastModeSource == null) {
                throw new IllegalStateException("No media sources available.");
            }
        }
        switch (this.lastModeSource.getType()) {
            case 9: 
            case 10: {
                this.maxTimerRetries = 2;
                break;
            }
            case 11: {
                this.maxTimerRetries = 3;
                break;
            }
            case 12: {
                this.maxTimerRetries = 8;
                break;
            }
            case 13: {
                this.maxTimerRetries = 25;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.maxTimerRetries = 2;
                break;
            }
            default: {
                this.maxTimerRetries = 1;
            }
        }
        this.logger.main().log(1000000, "[%1.init] maxTimerRetries='%2'", (Object)LOGCLASS, (long)this.maxTimerRetries);
    }

    public ISource getLastSelectedSource() {
        return this.lastModeSource;
    }

    public int getLastSelectedSlotIdx() {
        return this.lastModeSlotIdx;
    }

    public void setLastSelectedSource(ISourceSlot iSourceSlot) {
        this.logger.main().log(1000000, "[%1.setLastSelectedSource] '%2' (slotIdx='%3')", (Object)LOGCLASS, (Object)iSourceSlot.getSource(), (long)iSourceSlot.getIndex());
        if (iSourceSlot.getSource().getType() == 4) {
            this.logger.main().log(1000000, "[%1.setLastSelectedSource] Not last mode relevant", (Object)LOGCLASS);
            return;
        }
        if (iSourceSlot.getSource().equals(this.lastModeSource) && iSourceSlot.getIndex() == this.lastModeSlotIdx) {
            this.logger.main().log(1000000, "[%1.setLastSelectedSource] Already set", (Object)LOGCLASS);
            return;
        }
        this.lastModeSource = iSourceSlot.getSource();
        this.lastModeSlotIdx = iSourceSlot.getIndex();
        IMediaPersistence iMediaPersistence = this.getTerminal().getMediaPersistence();
        iMediaPersistence.setGlobalIntProperty("GLOBAL_KEY_LAST_ACTIVE_SOURCE", this.lastModeSource.getType());
        iMediaPersistence.setGlobalIntProperty("GLOBAL_KEY_LAST_ACTIVE_SLOT", this.lastModeSlotIdx);
    }

    public void setStartupListener(ISourceStartupListener iSourceStartupListener) {
        this.logger.main().log(1000000, "[%1.setStartupListener] '%2'", (Object)LOGCLASS);
        this.startupListener = iSourceStartupListener;
    }

    public void startLastModeTracking() {
        this.logger.main().log(1000000, "[%1.startLastModeTracking]", (Object)LOGCLASS);
        if (this.started) {
            this.logger.main().log(1000000, "[%1.startLastModeTracking] Already started", (Object)LOGCLASS);
            return;
        }
        this.started = true;
        ISource iSource = this.getLastSelectedSource();
        iSource.addSlotListener(this, true);
    }

    public void stopLastModeTracking() {
        if (!this.started) {
            return;
        }
        this.logger.main().log(1000000, "[%1.stopLastModeTracking]", (Object)LOGCLASS);
        this.started = false;
        this.startupTimer.cancel();
        this.getLastSelectedSource().removeSlotListener(this);
    }

    private boolean isTracking() {
        return this.started;
    }

    private void startupFinished() {
        this.logger.main().log(1000000, "[%1.startupFinished]", (Object)LOGCLASS);
        if (!this.isTracking()) {
            this.logger.main().log(1000000, "[%1.startupFinished] Tracking not active. Ignore.", (Object)LOGCLASS);
            return;
        }
        ISourceStartupListener iSourceStartupListener = this.startupListener;
        this.stopLastModeTracking();
        iSourceStartupListener.sourceStartupFinished(this.getLastSelectedSource().getSlot(this.lastModeSlotIdx));
    }

    public void slotsChanged(ISource iSource) {
        if (!this.isTracking()) {
            this.logger.main().log(1000000, "[%1.slotChanged] No tracking", (Object)LOGCLASS);
            return;
        }
        ISourceSlot iSourceSlot = iSource.getSlot(this.lastModeSlotIdx);
        if (iSourceSlot != null) {
            this.logger.main().log(1000000, "[%1.slotsChanged] Last slot found.", (Object)LOGCLASS);
            if (iSource.isActivateable(iSourceSlot)) {
                this.logger.main().log(1000000, "[%1.slotsChanged] Last slot activateable.", (Object)LOGCLASS);
                this.startupFinished();
                return;
            }
            this.logger.main().log(1000000, "[%1.slotsChanged] Last slot not activateable.", (Object)LOGCLASS);
        } else {
            this.logger.main().log(1000000, "[%1.slotsChanged] Last slot not found.", (Object)LOGCLASS);
        }
        this.logger.main().log(1000000, "[%1.slotsChanged] Restart timer.", (Object)LOGCLASS);
        this.startupTimer.restart();
    }

    public void fireTimer(Timer timer) {
        if (this.timerRetries < this.maxTimerRetries) {
            this.logger.main().log(1000000, "[%1.fireTimer] Restart %2/%3", (Object)LOGCLASS, (long)this.timerRetries, (long)this.maxTimerRetries);
            ++this.timerRetries;
            this.startupTimer.restart();
            return;
        }
        this.logger.main().log(1000000, "[%1.fireTimer] Startup timed out. Propose startupFinish event.", (Object)LOGCLASS);
        this.getTerminal().getDispatcher().execute(new Runnable(){

            public void run() {
                LastModeManager.this.logger.main().log(1000000, "[%1.onStartupFinished]", (Object)LastModeManager.LOGCLASS);
                LastModeManager.this.startupFinished();
            }

            public String toString() {
                return "LastModeManager.onStartupFinished";
            }
        });
    }

    public void cancelTimer(Timer timer) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}


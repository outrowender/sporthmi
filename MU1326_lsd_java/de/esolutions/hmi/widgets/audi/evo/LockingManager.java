/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.LockingEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.audi.tghu.hmi.evo.ILockingManager;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockingManager
implements ILockingManager {
    static final int WARNING_THRESHOLD = 25;
    static final String VMOPTION_NHTSA_TIMER_DELAY = "NhtsaTimerDelay";
    static final int DEFAULT_DELAY = 5000;
    static boolean lockingActive = false;
    static List listeners = new ArrayList(5);
    static LockingTimer interruptionTimer;
    int timerDelay = Integer.getInteger("NhtsaTimerDelay", 5000);
    private static int countListenerInterestedOnTimerEvent;
    private static LockingManager instance;
    static LogChannel logChannel;

    protected LockingManager(LogChannel logChannel) {
        LockingManager.logChannel = logChannel;
        interruptionTimer = new LockingTimer(LockingManager.logChannel);
        countListenerInterestedOnTimerEvent = 0;
    }

    public static synchronized ILockingManager getInstance(LogChannel logChannel) {
        if (instance == null) {
            instance = new LockingManager(logChannel);
        }
        return instance;
    }

    public static void registerListener(ILockingListener iLockingListener) {
        if (listeners.contains(iLockingListener)) {
            logChannel.log(10000000, "LockingManager#registerAsListener already registered(%1)", (Object)iLockingListener);
        } else {
            if (iLockingListener.isInterestedOnTimerEvents()) {
                ++countListenerInterestedOnTimerEvent;
            }
            listeners.add(iLockingListener);
            logChannel.log(10000000, "LockingManager#registerAsListener add listener(%1), number of listener which are interested on timer events: %2", (Object)iLockingListener, (long)countListenerInterestedOnTimerEvent);
            LockingManager.checkSize();
        }
        LockingManager.notify(iLockingListener);
    }

    private static void checkSize() {
        if (listeners.size() > 25) {
            logChannel.log(100000, "LockingManager#checkSize number of listeners exceeded warning threshold(%1). Don't forget to deregister.", 25L);
            if (logChannel.isDebug()) {
                LockingManager.printListeners();
            }
        }
    }

    private static void printListeners() {
        int n = 0;
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            ILockingListener iLockingListener = (ILockingListener)iterator.next();
            logChannel.log(10000000, "LockingManager#printListeners listener %2: %1", (Object)iLockingListener, (long)(++n));
        }
    }

    private static void notify(ILockingListener iLockingListener) {
        iLockingListener.isLockingActive(lockingActive, !interruptionTimer.isTimerRunning());
        logChannel.log(10000000, "LockingManager#notify notify listener(%2) !interruptionTimer.isRunning()=%1", !interruptionTimer.isTimerRunning(), (Object)iLockingListener);
    }

    public static void deregisterListener(ILockingListener iLockingListener) {
        boolean bl = listeners.remove(iLockingListener);
        if (bl) {
            if (iLockingListener.isInterestedOnTimerEvents()) {
                --countListenerInterestedOnTimerEvent;
            }
            logChannel.log(10000000, "LockingManager#deregisterAsListener listener(%1) removed, number of listener which are interested on timer events: %2", (Object)iLockingListener, (long)countListenerInterestedOnTimerEvent);
        } else {
            logChannel.log(10000000, "LockingManager#deregisterAsListener listener(%1) was not registered", (Object)iLockingListener);
        }
    }

    public void processLockingEvent(LockingEvent lockingEvent) {
        boolean bl = lockingEvent.isLockingActive();
        logChannel.log(10000000, "LockingManager#processLockingEvent newStatus=%1, oldStatus=%2", bl, lockingActive);
        if (bl != lockingActive) {
            lockingActive = bl;
            LockingManager.notifyAllListeners();
        }
    }

    private static void notifyAllListeners() {
        ILockingListener iLockingListener = null;
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            iLockingListener = (ILockingListener)iterator.next();
            LockingManager.notify(iLockingListener);
        }
        LockingManager.triggerRepaint(iLockingListener);
    }

    private static void notifyListenersAboutTimerEvent() {
        ILockingListener iLockingListener = null;
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            iLockingListener = (ILockingListener)iterator.next();
            if (!iLockingListener.isInterestedOnTimerEvents()) continue;
            LockingManager.notify(iLockingListener);
        }
        LockingManager.triggerRepaint(iLockingListener);
    }

    private static void triggerRepaint(ILockingListener iLockingListener) {
        AbstractScreenWidget abstractScreenWidget;
        if (iLockingListener instanceof AbstractWidget) {
            ((AbstractWidget)((Object)iLockingListener)).triggerRepaint();
        } else if (iLockingListener instanceof DrawerFocusManager && (abstractScreenWidget = ((DrawerFocusManager)iLockingListener).getScreen()) != null) {
            abstractScreenWidget.triggerRepaint();
        }
    }

    public static void userInput() {
        logChannel.log(10000000, "LockingManager#userInput lockingActive=%1", lockingActive);
        if (lockingActive) {
            boolean bl = interruptionTimer.isTimerRunning();
            logChannel.log(10000000, "LockingManager#userInput was timer already running:%1, number of listeners interested on timer events:%2", bl, (long)countListenerInterestedOnTimerEvent);
            if (countListenerInterestedOnTimerEvent != 0) {
                interruptionTimer.restartTimer();
            }
            if (!bl) {
                LockingManager.notifyListenersAboutTimerEvent();
            }
        }
    }

    public static boolean isRegisteredListener(Object object) {
        return listeners.contains(object);
    }

    public static void requestCurrentLockingState(ILockingListener iLockingListener) {
        if (LockingManager.isRegisteredListener(iLockingListener)) {
            LockingManager.notify(iLockingListener);
        }
    }

    protected class LockingTimer
    extends AbstractIdleTimerController {
        public LockingTimer(LogChannel logChannel) {
            super(logChannel);
            this.fireWhenOptionDrawerOpen = true;
            this.fireWhenSelectionDrawerOpen = true;
            this.deactivateOnKeyReleased = false;
            this.idleTime = LockingManager.this.timerDelay;
        }

        protected void timerFired() {
            LockingManager.notifyListenersAboutTimerEvent();
        }

        public void restartTimer() {
            if (!this.isEnabled()) {
                logChannel.log(10000000, "%1#restartTimer: don't restart, because timer is disabled", (Object)this.logPrefix);
                return;
            }
            if (!this.active) {
                logChannel.log(10000000, "%1#restartTimer: timer is not active", (Object)this.logPrefix);
                return;
            }
            this.cancelTimer();
            if (this.idleTime > 0) {
                if (this.timerEvent == null) {
                    this.timerEvent = new TimerEvent(this);
                }
                logChannel.log(10000000, "%1#restartTimer with timeout: %2", (Object)this.logPrefix, (long)this.idleTime);
                this.timerJob = hmiService.getEventDispatcher().postEvent(this.timerEvent, this.idleTime);
            } else {
                logChannel.log(10000000, "%1#restartTimer - idleTime: %2 < 0, no timer is started", (Object)this.logPrefix, (long)this.idleTime);
            }
        }

        protected boolean shouldExecuteAction() {
            if (!this.isEnabled()) {
                this.lc.log(10000000, "%1#shouldExecuteAction: timer is disabled.", (Object)this.logPrefix);
                return false;
            }
            if (!this.active) {
                this.lc.log(10000000, "%1#shouldExecuteAction: timer is not active.", (Object)this.logPrefix);
                return false;
            }
            if (!this.fireWhenOptionDrawerOpen && this.isOptionDrawerOpen() && !this.isInOptionDrawer()) {
                this.lc.log(10000000, "%1#shouldExecuteAction: option drawer is open.", (Object)this.logPrefix);
                this.restartTimer();
                return false;
            }
            if (!this.fireWhenSelectionDrawerOpen && this.isSelectionDrawerOpen()) {
                this.lc.log(10000000, "%1#shouldExecuteAction: selection drawer is open.", (Object)this.logPrefix);
                this.restartTimer();
                return false;
            }
            return true;
        }
    }
}


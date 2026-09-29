/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.kbd.KeyMap;
import de.audi.kbd.dsi.KbdListener;
import de.audi.kbd.dsi.KbdScreenShotManager;
import de.esolutions.fw.util.commons.IntList;

final class ComboKeyDetector
implements TimerListener {
    private static final int STATE_INIT;
    private static final int STATE_BEGIN_COMBO;
    private static final int STATE_COMBO;
    private static int T_KEY_DELAY;
    private final int[][] tableCombo;
    private int comboState = 0;
    private int key1;
    private int key2;
    private int key1TerminalID;
    private int key2TerminalID;
    private final IFrameworkAccess framework;
    private final KbdListener kbdListener;
    private final LogChannel log;
    private final KbdScreenShotManager kbdScreenShotManager;
    private final Timer keydelayTimer;
    private final Timer keycomboTimer;
    private final IntList consumeReleaseKeyList;

    public ComboKeyDetector(IFrameworkAccess iFrameworkAccess, KbdListener kbdListener) {
        this.framework = iFrameworkAccess;
        this.kbdListener = kbdListener;
        this.log = iFrameworkAccess.getLogChannel("Fw.Kbd.ComboKeyDetector");
        this.kbdScreenShotManager = new KbdScreenShotManager(iFrameworkAccess);
        if (iFrameworkAccess.isPGen2()) {
            T_KEY_DELAY = 650;
        }
        this.keydelayTimer = new Timer("keydelay", 5, null, this, T_KEY_DELAY, true);
        this.keycomboTimer = new Timer("keycombo", 5, null, this, T_KEY_DELAY, true);
        this.consumeReleaseKeyList = new IntList(4);
        this.tableCombo = iFrameworkAccess.isBentley() ? KeyMap.getComboTableBentley() : (iFrameworkAccess.isPorsche() ? KeyMap.getComboTablePorsche() : (iFrameworkAccess.isPGen2() ? KeyMap.getComboTablePGen2() : KeyMap.getComboTableEvo()));
    }

    public synchronized boolean keyPressedConsumed(int n, int n2) {
        if (KeyMap.isComboIgnoreKey(n)) {
            this.log.log(-2137614336, "ComboKeyDetector.keyPressedConsumed: ignore key %1", (long)n);
            return false;
        }
        switch (this.comboState) {
            case 0: {
                if (!this.isComboKey1(n)) break;
                this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: The first key of a combo key pair has been detected! (keyCode=%1, terminalID=%2)", (long)n, (long)n2);
                this.comboState = 1;
                this.key1 = n;
                this.key1TerminalID = n2;
                if (this.isDoublePressKey(this.key1)) {
                    this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: DoublePressComboKey detected(keyCode=%1, terminalID=%2)", (long)n, (long)n2);
                    this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: ReleaseKey for DoublePressComboKey will be consumed");
                    this.consumeReleaseKeyList.add(this.key1);
                }
                this.keydelayTimer.restart();
                return true;
            }
            case 1: {
                if (this.isComboKeyCombination(this.key1, n)) {
                    this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: The second key of a combo key pair has been detected! (keyCode=%1, terminalID=%2)", (long)n, (long)n2);
                    this.comboState = 2;
                    this.key2 = n;
                    this.key2TerminalID = n2;
                    if (this.isDoublePressKey(this.key1) && this.key1 != n) {
                        this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: The second key of a combo key pair is not the same as the first one (keyCode=%1, terminalID=%2)", (long)n, (long)n2);
                        this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: consumeReleaseKeyList for key1:%1 will be removed", (long)this.key1);
                        this.consumeReleaseKeyList.removeElement(this.key1);
                    }
                    this.keydelayTimer.cancel();
                    this.keycomboTimer.setDelay(this.getComboTimerDelay(this.key1, this.key2));
                    this.keycomboTimer.restart();
                    return true;
                }
                this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: Abort combo key detection!");
                this.kbdListener.triggerKeyPressedEvent(this.key1, this.key1TerminalID);
                this.keydelayTimer.cancel();
                this.comboState = 0;
                break;
            }
            case 2: {
                this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: Abort combo key execution!");
                this.comboState = 0;
                this.kbdListener.triggerKeyPressedEvent(this.key1, this.key1TerminalID);
                if (this.key1 == this.key2) {
                    this.log.log(1078071040, "ComboKeyDetector.keyPressedConsumed: Abort combo key execution and send triggerKeyReleasedEvent for key1(%1) of DoubleKeyCombo!", (long)this.key1);
                    this.kbdListener.triggerKeyReleasedEvent(this.key1, this.key1TerminalID);
                }
                this.kbdListener.triggerKeyPressedEvent(this.key2, this.key2TerminalID);
                this.keycomboTimer.cancel();
            }
        }
        return false;
    }

    public synchronized boolean keyReleasedConsumed(int n, int n2) {
        if (this.consumeReleaseKeyList.contains(n)) {
            this.log.log(-2137614336, "ComboKeyDetector.keyReleasedConsumed: consume key %1", (long)n);
            this.consumeReleaseKeyList.removeElement(n);
            return true;
        }
        if (KeyMap.isComboIgnoreKey(n)) {
            this.log.log(-2137614336, "ComboKeyDetector.keyReleasedConsumed: ignore key %1", (long)n);
            return false;
        }
        switch (this.comboState) {
            case 0: {
                break;
            }
            case 1: {
                this.kbdListener.triggerKeyPressedEvent(this.key1, this.key1TerminalID);
                this.comboState = 0;
                break;
            }
            case 2: {
                this.kbdListener.triggerKeyPressedEvent(this.key1, this.key1TerminalID);
                this.kbdListener.triggerKeyPressedEvent(this.key2, this.key2TerminalID);
                this.comboState = 0;
                break;
            }
        }
        return false;
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        if (this.keydelayTimer.equals(timer)) {
            this.log.log(1078071040, "ComboKeyDetector.fireTimer: The key delay timer has been fired! (comboState=%1)", (long)this.comboState);
            if (this.comboState == 1) {
                this.kbdListener.triggerKeyPressedEvent(this.key1, this.key1TerminalID);
                if (this.isDoublePressKey(this.key1) && !this.consumeReleaseKeyList.removeElement(this.key1)) {
                    this.log.log(1078071040, "ComboKeyDetector.fireTimer: Also KeyReleasedEvent will be fired for key: %1 terminal: %2", (long)this.key1, (long)this.key1TerminalID);
                    this.kbdListener.triggerKeyReleasedEvent(this.key1, this.key1TerminalID);
                }
                this.comboState = 0;
            }
        } else if (this.keycomboTimer.equals(timer)) {
            this.log.log(1078071040, "ComboKeyDetector.fireTimer: The key combo timer has been fired! (comboState=%1)", (long)this.comboState);
            if (this.comboState == 2) {
                this.triggerComboKeyAction(this.key1, this.key2);
                this.comboState = 0;
                if (this.key1 != this.key2) {
                    this.log.log(-2137614336, "ComboKeyDetector.fireTimer: store keys to consume release: key1=%1", (long)this.key1);
                    this.consumeReleaseKeyList.add(this.key1);
                }
                this.log.log(-2137614336, "ComboKeyDetector.fireTimer: store keys to consume release: key2=%1", (long)this.key2);
                this.consumeReleaseKeyList.add(this.key2);
            }
        } else {
            ScreenDebugInfoEvent screenDebugInfoEvent = new ScreenDebugInfoEvent(this.getHMIService().getRootWindow(0), new String[0], 3);
            this.getHMIService().getEventDispatcher().postEvent(screenDebugInfoEvent);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    private final HMIService getHMIService() {
        return this.framework.getHMIService();
    }

    private final boolean isComboKey1(int n) {
        for (int i2 = 0; i2 < this.tableCombo.length; ++i2) {
            if (this.tableCombo[i2][0] != n) continue;
            return true;
        }
        return false;
    }

    private final boolean isDoublePressKey(int n) {
        for (int i2 = 0; i2 < this.tableCombo.length; ++i2) {
            if (this.tableCombo[i2][0] != n || this.tableCombo[i2][1] != n) continue;
            return true;
        }
        return false;
    }

    private int getComboKeyCombination(int n, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < this.tableCombo.length; ++i2) {
            if (this.tableCombo[i2][0] != n || this.tableCombo[i2][1] != n2) continue;
            n3 = this.tableCombo[i2][2];
            break;
        }
        if (this.framework.isPBuild() && (n3 == 7 || n3 == 8)) {
            n3 = 0;
        }
        if (!this.framework.isFrontMU() && n3 == 6) {
            n3 = 0;
        }
        return n3;
    }

    private boolean isComboKeyCombination(int n, int n2) {
        return 0 != this.getComboKeyCombination(n, n2);
    }

    private long getComboTimerDelay(int n, int n2) {
        int n3 = 2500;
        for (int i2 = 0; i2 < this.tableCombo.length; ++i2) {
            if (this.tableCombo[i2][0] != n || this.tableCombo[i2][1] != n2) continue;
            n3 = this.tableCombo[i2][3];
            break;
        }
        return n3;
    }

    private void triggerComboKeyAction(int n, int n2) {
        int n3 = this.getComboKeyCombination(n, n2);
        if (n3 == 1) {
            this.kbdListener.triggerHmiKeyPressedEvent(24, this.key1TerminalID);
        } else if (n3 == 2) {
            this.framework.getStartupMgr().requestStartBundle("AppDevelopment");
            this.kbdListener.triggerHmiKeyPressedEvent(25, this.key1TerminalID);
        } else if (n3 == 8) {
            if (!this.framework.isPBuild()) {
                this.kbdListener.triggerHmiKeyPressedEvent(26, this.key1TerminalID);
            }
        } else if (n3 == 4) {
            this.makeScreenshot();
        } else if (n3 == 6) {
            if (!this.framework.isPBuild()) {
                this.kbdListener.triggerKeyPressedEvent(50, this.key1TerminalID);
                this.kbdListener.triggerKeyReleasedEvent(50, this.key1TerminalID);
            }
        } else if (n3 == 7) {
            if (!this.framework.isPBuild()) {
                this.kbdListener.blinkInfo("#####   write error dump   #####");
                this.framework.getErrorMgr().handleError(null, "error dump triggered manually", 0, 0, 4);
            }
        } else if (n3 == 13) {
            this.kbdListener.blinkInfo("#####   IRC Backup triggered   #####");
            this.framework.getInfotainmentrecorder().backupTrigger();
        } else if (!this.framework.isPBuild() && this.framework.isPorsche()) {
            if (n3 == 9) {
                this.kbdListener.triggerHmiKeyPressedEvent(84, this.key1TerminalID);
            } else if (n3 == 10) {
                this.kbdListener.triggerHmiKeyPressedEvent(82, this.key1TerminalID);
            } else if (n3 == 11) {
                this.kbdListener.triggerHmiKeyPressedEvent(83, this.key1TerminalID);
            } else if (n3 == 12) {
                this.kbdListener.triggerHmiKeyPressedEvent(15, this.key1TerminalID);
            }
        }
    }

    void makeScreenshot() {
        this.kbdScreenShotManager.doScreenShot();
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
        }
        this.kbdListener.blinkScreen();
    }

    static {
        T_KEY_DELAY = 500;
    }
}


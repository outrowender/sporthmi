/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.app.combi.bap.fw.CombiCodingAccess;
import de.audi.app.combi.bap.fw.CombiModelAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyAction_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_StatusAck;

class MFLKeyHandler
implements MsgListener,
TimerListener {
    private final LogChannel logChannel;
    private final CombiModuleMFL moduleFsg;
    private static final int KEY_ACTION_IDLE_TIME = 1000;
    private static final int KEY_NOT_FUNCTIONAL_IDLE_TIME = 1000;
    private int keyAction1JokerKeyID = -1;
    private final Timer keyAction1IdleTimer;
    private final Timer keyAction2IdleTimer;
    private final Timer keyNotFunctionalIdleTimer;

    protected MFLKeyHandler(CombiModuleMFL combiModuleMFL) {
        this.moduleFsg = combiModuleMFL;
        this.logChannel = combiModuleMFL.getLogChannel();
        this.keyAction1IdleTimer = new Timer("KeyAction1IdleTimer", 1000L, true, this);
        this.keyAction2IdleTimer = new Timer("KeyAction2IdleTimer", 1000L, true, this);
        this.keyNotFunctionalIdleTimer = new Timer("KeyNotFunctionalIdleTimer", 1000L, true, this);
    }

    public void processMsg(int n) {
        switch (n) {
            case 60: {
                this.sendJokerKeyAction(1, 3);
                break;
            }
            case 61: {
                this.sendJokerKeyAction(1, 4);
                break;
            }
            case 62: {
                this.sendJokerKeyAction(1, 1);
                break;
            }
            case 63: {
                this.sendJokerKeyAction(1, 2);
                break;
            }
            case 65: {
                this.sendJokerKeyAction(1, 13);
                break;
            }
            case 64: {
                this.sendJokerKeyAction(1, 12);
                break;
            }
            case 66: {
                this.sendJokerKeyAction(1, 5);
                break;
            }
            case 67: {
                this.sendJokerKeyAction(1, 6);
                break;
            }
            case 69: {
                this.sendJokerKeyAction(1, 8);
                break;
            }
            case 70: {
                this.sendJokerKeyAction(1, 9);
                break;
            }
            case 71: {
                this.sendJokerKeyAction(1, 14);
                break;
            }
            case 72: {
                this.sendJokerKeyAction(1, 15);
                break;
            }
            case 73: {
                this.sendJokerKeyAction(1, 16);
                break;
            }
            case 104: {
                this.sendJokerKeyAction(1, 17);
                break;
            }
            case 105: {
                this.sendJokerKeyAction(1, 18);
                break;
            }
            case 106: {
                this.sendJokerKeyAction(1, 19);
                break;
            }
            case 74: {
                this.sendKeyNotFunctional(4);
                break;
            }
            case 75: {
                this.sendKeyNotFunctional(5);
                break;
            }
            case 76: {
                this.sendKeyNotFunctional(6);
                break;
            }
            case 77: {
                this.sendKeyNotFunctional(3);
                break;
            }
            case 59: {
                if (!CombiCodingAccess.isNaviPresent()) {
                    this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] iNav pressed, navi not present");
                    this.sendKeyNotFunctional(1);
                    break;
                }
                this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] iNav pressed, navi is operable");
                break;
            }
            case 58: {
                if (!CombiCodingAccess.isSDSPresent()) {
                    this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] PTT pressed, sds not present");
                    this.sendKeyNotFunctional(2);
                    break;
                }
                if (CombiModelAccess.isSDSDisabledForCurrentLanguage()) {
                    this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] PTT pressed, sds not available in this language");
                    break;
                }
                this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] PTT pressed, sds is operable");
                break;
            }
            default: {
                return;
            }
        }
        this.logChannel.log(10000000, "[MFLKeyHandler#processMessage] message with id %1 processed", (long)n);
    }

    private void sendJokerKeyAction(int n, int n2) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(18);
        KeyAction_Status keyAction_Status = (KeyAction_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (!this.keyAction1IdleTimer.isRunning() || n == this.keyAction1JokerKeyID) {
            keyAction_Status.fsgactionKey1 = n2;
            bAPFunctionPropertyFSG.sendStatus(keyAction_Status);
            this.keyAction1IdleTimer.restart();
            this.keyAction1JokerKeyID = n;
        } else {
            keyAction_Status.fsgactionKey2 = n2;
            bAPFunctionPropertyFSG.sendStatus(keyAction_Status);
            this.keyAction2IdleTimer.restart();
        }
    }

    private void sendKeyNotFunctional(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(18);
        KeyAction_Status keyAction_Status = (KeyAction_Status)bAPFunctionPropertyFSG.getLastStatus();
        keyAction_Status.fsgkeyNoFunc = n;
        bAPFunctionPropertyFSG.sendStatus(keyAction_Status);
        this.keyNotFunctionalIdleTimer.restart();
    }

    public void updateKeyConfiguration(int n, int n2) {
        boolean bl;
        this.logChannel.log(10000000, "[MFLKeyHandler#updateKeyConfiguration] jokerKeyID=%1, jokerKeyFunction=%2", (long)n, (long)n2);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(17);
        KeyConfiguration_StatusAck keyConfiguration_StatusAck = (KeyConfiguration_StatusAck)bAPFunctionPropertyFSG.getLastStatusAck();
        switch (n) {
            case 1: {
                bl = keyConfiguration_StatusAck.configKey1 != n2;
                keyConfiguration_StatusAck.configKey1 = n2;
                break;
            }
            case 2: {
                bl = keyConfiguration_StatusAck.configKey2 != n2;
                keyConfiguration_StatusAck.configKey2 = n2;
                break;
            }
            case 4: {
                bl = keyConfiguration_StatusAck.configKey3 != n2;
                keyConfiguration_StatusAck.configKey3 = n2;
                break;
            }
            case 8: {
                bl = keyConfiguration_StatusAck.configKey4 != n2;
                keyConfiguration_StatusAck.configKey4 = n2;
                break;
            }
            case 16: {
                bl = keyConfiguration_StatusAck.configKey5 != n2;
                keyConfiguration_StatusAck.configKey5 = n2;
                break;
            }
            default: {
                this.logChannel.log(10000, "[MFLKeyHandler#updateKeyConfiguration] unsupported joker key ID: %1", (long)n);
                return;
            }
        }
        if (bl || !bAPFunctionPropertyFSG.isDataValid()) {
            bAPFunctionPropertyFSG.sendStatusAck(keyConfiguration_StatusAck);
        } else {
            this.logChannel.log(10000000, "[AppConnectorMFL#updateKeyConfiguration] configuration didn't change ->no update sent");
        }
    }

    public void updateInstrumentClusterFunctions(int n) {
        this.logChannel.log(10000000, "[MFLKeyHandler#updateInstrumentClusterFunctions] availableFunctions=%1", (long)n);
        InstrumentClusterFunctions_Status instrumentClusterFunctions_Status = new InstrumentClusterFunctions_Status();
        instrumentClusterFunctions_Status.configurationOptions.screensaverOnOffAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 1);
        instrumentClusterFunctions_Status.configurationOptions.trafficSignsOnOffAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 2);
        instrumentClusterFunctions_Status.configurationOptions.contextSwitchToPhoneBookAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 4);
        instrumentClusterFunctions_Status.configurationOptions.contextSwitchToLastDestinationsListAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 8);
        instrumentClusterFunctions_Status.configurationOptions.contextSwitchToTrafficSignInformationAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 16);
        instrumentClusterFunctions_Status.configurationOptions.contextSwitchToDigitalSpeedAvailable = MFLKeyHandler.isInstrumentClusterFunctionAvailable(n, 32);
        this.moduleFsg.getBAPFunctionPropertyFSG(16).sendStatusIfChanged(instrumentClusterFunctions_Status);
    }

    private static boolean isInstrumentClusterFunctionAvailable(int n, int n2) {
        return (n & n2) == n2;
    }

    public void fireTimer(Timer timer) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(18);
        KeyAction_Status keyAction_Status = (KeyAction_Status)this.moduleFsg.createStatusSerializer(18);
        if (timer.equals(this.keyAction1IdleTimer)) {
            this.keyAction1JokerKeyID = -1;
            keyAction_Status.fsgactionKey1 = 0;
        } else if (timer.equals(this.keyAction2IdleTimer)) {
            this.keyAction1JokerKeyID = -1;
            keyAction_Status.fsgactionKey2 = 0;
        } else if (timer.equals(this.keyNotFunctionalIdleTimer)) {
            keyAction_Status.fsgkeyNoFunc = 0;
        } else {
            return;
        }
        bAPFunctionPropertyFSG.sendStatus(keyAction_Status);
    }

    public void cancelTimer(Timer timer) {
    }
}


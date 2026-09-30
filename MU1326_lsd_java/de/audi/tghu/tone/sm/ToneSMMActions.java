/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.PhoneActionProxy;
import de.audi.atip.statemachine.ap.ToneActionProxy;
import de.audi.atip.statemachine.ap.TopLevelScreenActionProxy;
import de.audi.atip.statemachine.ap.TunerActionProxy;
import java.util.NoSuchElementException;

public class ToneSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile FrameworkActionProxy ap0;
    private volatile TopLevelScreenActionProxy ap1;
    private volatile ToneActionProxy ap2;
    private volatile TunerActionProxy ap3;
    private volatile PhoneActionProxy ap4;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{4, 20, 19, 12, 27};

    protected ToneSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TunerActionProxy) {
            this.ap3 = null;
            this.logChannel.log(10000000, "TunerActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "ToneActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap4 = null;
            this.logChannel.log(10000000, "PhoneActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "TopLevelScreenActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(10000000, "FrameworkActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof TunerActionProxy) {
            this.ap3 = (TunerActionProxy)actionProxy;
            this.logChannel.log(10000000, "TunerActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap2 = (ToneActionProxy)actionProxy;
            this.logChannel.log(10000000, "ToneActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap4 = (PhoneActionProxy)actionProxy;
            this.logChannel.log(10000000, "PhoneActionProxy Action Proxy added");
            return this.ap4;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap1 = (TopLevelScreenActionProxy)actionProxy;
            this.logChannel.log(10000000, "TopLevelScreenActionProxy Action Proxy added");
            return this.ap1;
        }
        return null;
    }

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTunerActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TunerActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'TunerActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionToneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ToneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'ToneActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionPhoneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'PhoneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'PhoneActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTopLevelScreenActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TopLevelScreenActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'TopLevelScreenActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            case 1000029: {
                this.ap2_volumeRingtoneSelectionEntered_2107068339();
                return;
            }
            case 1000030: {
                this.ap2_volumeTelMsgEntered_2107068339();
                return;
            }
            case 1000032: {
                this.ap2_volumeTelEntered_2107068339();
                return;
            }
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap2_volumeHeartbeatLeft_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.volumeHeartbeatLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeHeartbeatLeft");
        }
    }

    private void ap2_balanceFaderLeft_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.balanceFaderLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "balanceFaderLeft");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 1000001: {
                sMServices.popDrawerIDs();
                return;
            }
            case 1000006: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.toneSettingsLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneSettingsLeft");
                }
                return;
            }
            case 1000007: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTouchpadLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTouchpadLeft");
                }
                return;
            }
            case 1000008: {
                TopLevelScreenActionProxy topLevelScreenActionProxy = this.ap1;
                try {
                    topLevelScreenActionProxy.setTopLevelScreen(this.smm.getTerminalID(), 0, false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTopLevelScreenActionProxy(topLevelScreenActionProxy, nullPointerException, "setTopLevelScreen");
                }
                return;
            }
            case 1000009: {
                this.ap2_volumeHeartbeatLeft_2107068339();
                return;
            }
            case 1000012: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeNavExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeNavExited");
                }
                return;
            }
            case 1000019: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeSDSExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeSDSExited");
                }
                return;
            }
            case 1000020: {
                this.ap2_balanceFaderLeft_2107068339();
                return;
            }
            case 1000027: {
                ActionProxy actionProxy = this.ap2;
                try {
                    actionProxy.volumeTPExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(actionProxy, nullPointerException, "volumeTPExited");
                }
                actionProxy = this.ap3;
                try {
                    actionProxy.taVolumeAdjustmentDeactivated(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(actionProxy, nullPointerException, "taVolumeAdjustmentDeactivated");
                }
                return;
            }
            case 1000029: {
                ActionProxy actionProxy = this.ap4;
                try {
                    actionProxy.cancelRingingTone(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "cancelRingingTone");
                }
                actionProxy = this.ap2;
                try {
                    actionProxy.volumeRingtoneSelectionLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(actionProxy, nullPointerException, "volumeRingtoneSelectionLeft");
                }
                return;
            }
            case 1000030: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTelMsgLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelMsgLeft");
                }
                return;
            }
            case 1000031: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTelMicLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelMicLeft");
                }
                return;
            }
            case 1000032: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTelExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelExited");
                }
                return;
            }
            case 1000065: {
                this.ap2_balanceFaderLeft_2107068339();
                return;
            }
            case 1000077: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeWCLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeWCLeft");
                }
                return;
            }
            case 1000079: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeInfoAnnouncementLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeInfoAnnouncementLeft");
                }
                return;
            }
            case 1000089: {
                this.ap2_volumeHeartbeatLeft_2107068339();
                return;
            }
            case 1000091: {
                sMServices.hidePartialPopup(1000074);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap2_toneSettingsEntered_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.toneSettingsEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneSettingsEntered");
        }
    }

    private void ap2_demute_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.demute(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "demute");
        }
    }

    private void ap2_volumeHeartbeatEntered_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.volumeHeartbeatEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeHeartbeatEntered");
        }
    }

    private void ap2_volumeRingtoneSelectionEntered_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.volumeRingtoneSelectionEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeRingtoneSelectionEntered");
        }
    }

    private void ap2_volumeTelMsgEntered_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.volumeTelMsgEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelMsgEntered");
        }
    }

    private void ap2_volumeTelEntered_2107068339() {
        ToneActionProxy toneActionProxy = this.ap2;
        try {
            toneActionProxy.volumeTelEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelEntered");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 1000001: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                sMServices.pushDrawerIDs(1000002L, 0L);
                actionProxy = this.ap1;
                try {
                    actionProxy.setTopLevelScreen(this.smm.getTerminalID(), 0, true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTopLevelScreenActionProxy(actionProxy, nullPointerException, "setTopLevelScreen");
                }
                sMServices.setColor(2);
                return;
            }
            case 1000004: {
                this.ap2_toneSettingsEntered_2107068339();
                return;
            }
            case 1000005: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000006: {
                this.ap2_toneSettingsEntered_2107068339();
                return;
            }
            case 1000007: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTouchpadEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTouchpadEntered");
                }
                sMServices.hidePartialPopup(1000074);
                return;
            }
            case 1000009: {
                this.ap2_volumeHeartbeatEntered_2107068339();
                return;
            }
            case 1000012: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeNavEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeNavEntered");
                }
                return;
            }
            case 1000019: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeSDSEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeSDSEntered");
                }
                return;
            }
            case 1000020: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000021: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000023: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000024: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000025: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000027: {
                ActionProxy actionProxy = this.ap2;
                try {
                    actionProxy.volumeTPEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(actionProxy, nullPointerException, "volumeTPEntered");
                }
                actionProxy = this.ap3;
                try {
                    actionProxy.taVolumeAdjustmentActivated(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTunerActionProxy(actionProxy, nullPointerException, "taVolumeAdjustmentActivated");
                }
                return;
            }
            case 1000029: {
                this.ap2_volumeRingtoneSelectionEntered_2107068339();
                return;
            }
            case 1000030: {
                this.ap2_volumeTelMsgEntered_2107068339();
                return;
            }
            case 1000031: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTelMicEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTelMicEntered");
                }
                return;
            }
            case 1000032: {
                this.ap2_volumeTelEntered_2107068339();
                return;
            }
            case 1000040: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.toneAnnouncementEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneAnnouncementEntered");
                }
                return;
            }
            case 1000041: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.toneNaviEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneNaviEntered");
                }
                return;
            }
            case 1000042: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.tonePhoneEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "tonePhoneEntered");
                }
                return;
            }
            case 1000044: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.toneParkingEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneParkingEntered");
                }
                return;
            }
            case 1000045: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.toneSpeechEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "toneSpeechEntered");
                }
                return;
            }
            case 1000065: {
                this.ap2_demute_2107068339();
                return;
            }
            case 1000073: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeTouchInitEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeTouchInitEntered");
                }
                return;
            }
            case 1000074: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.WCMenuEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "WCMenuEntered");
                }
                return;
            }
            case 1000077: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeWCEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeWCEntered");
                }
                return;
            }
            case 1000079: {
                ToneActionProxy toneActionProxy = this.ap2;
                try {
                    toneActionProxy.volumeInfoAnnouncementEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "volumeInfoAnnouncementEntered");
                }
                return;
            }
            case 1000089: {
                this.ap2_volumeHeartbeatEntered_2107068339();
                return;
            }
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 1000002: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000003: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000016: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000017: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000018: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000019: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000020: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000021: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000031: {
                PhoneActionProxy phoneActionProxy = this.ap4;
                try {
                    phoneActionProxy.phoneToneSetupEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "phoneToneSetupEntered");
                }
                return;
            }
            case 1000045: {
                sMServices.showPartialPopup(1000039);
                return;
            }
            case 1000070: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 1000071: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000073: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000074: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000075: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000076: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000078: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000079: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000080: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000081: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000082: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000083: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000084: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000085: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000086: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000087: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000088: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000089: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000090: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000091: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000092: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000093: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000094: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000095: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000096: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000097: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000098: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000099: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000100: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000102: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        sMServices.hidePartialPopup(1000074);
                        return;
                    }
                }
                return;
            }
            case 1000103: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000104: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000110: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000111: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000120: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000121: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000127: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000128: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000145: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000074);
                        return;
                    }
                }
                return;
            }
            case 1000146: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        sMServices.hidePartialPopup(1000074);
                        return;
                    }
                }
                return;
            }
            case 1000147: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000149: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000151: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000161: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000162: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000167: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1000043);
                        return;
                    }
                }
                return;
            }
            case 1000180: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 1000181: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000182: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000066);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1000043);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1000043);
                        sMServices.hidePartialPopup(1000066);
                        return;
                    }
                }
                return;
            }
            case 1000183: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1000074);
                        return;
                    }
                }
                return;
            }
            case 1000184: {
                sMServices.hidePartialPopup(1000074);
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}


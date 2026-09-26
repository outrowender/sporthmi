/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.sm;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.CarActionProxy;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.atip.statemachine.ap.EcallActionProxy;
import de.audi.atip.statemachine.ap.EngineeringActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.MMICombiActionProxy;
import de.audi.atip.statemachine.ap.MessagingActionProxy;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.PhoneActionProxy;
import de.audi.atip.statemachine.ap.ToneActionProxy;
import de.audi.atip.statemachine.ap.TrafficInfoJPActionProxy;

public class SystemSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile MMICombiActionProxy ap0;
    private volatile FrameworkActionProxy ap1;
    private volatile EcallActionProxy ap2;
    private volatile EntertainmentActionProxy ap3;
    private volatile EngineeringActionProxy ap4;
    private volatile ConnectivityActionProxy ap5;
    private volatile ToneActionProxy ap6;
    private volatile OnlineActionProxy ap7;
    private volatile NaviActionProxy ap8;
    private volatile PhoneActionProxy ap9;
    private volatile MessagingActionProxy ap10;
    private volatile CustDownloadActionProxy ap11;
    private volatile CarActionProxy ap12;
    private volatile TrafficInfoJPActionProxy ap13;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{21, 22, 8, 19, 12, 2, 25, 4, 30, 26, 23, 11, 10, 29};

    protected SystemSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EngineeringActionProxy) {
            this.ap4 = null;
            this.logChannel.log(-2137614336, "EngineeringActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap11 = null;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof MessagingActionProxy) {
            this.ap10 = null;
            this.logChannel.log(-2137614336, "MessagingActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap6 = null;
            this.logChannel.log(-2137614336, "ToneActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap9 = null;
            this.logChannel.log(-2137614336, "PhoneActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof CarActionProxy) {
            this.ap12 = null;
            this.logChannel.log(-2137614336, "CarActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap3 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap5 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap7 = null;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap8 = null;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TrafficInfoJPActionProxy) {
            this.ap13 = null;
            this.logChannel.log(-2137614336, "TrafficInfoJPActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EngineeringActionProxy) {
            this.ap4 = (EngineeringActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EngineeringActionProxy Action Proxy added");
            return this.ap4;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap11 = (CustDownloadActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy added");
            return this.ap11;
        }
        if (actionProxy instanceof MessagingActionProxy) {
            this.ap10 = (MessagingActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "MessagingActionProxy Action Proxy added");
            return this.ap10;
        }
        if (actionProxy instanceof ToneActionProxy) {
            this.ap6 = (ToneActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ToneActionProxy Action Proxy added");
            return this.ap6;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap9 = (PhoneActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "PhoneActionProxy Action Proxy added");
            return this.ap9;
        }
        if (actionProxy instanceof CarActionProxy) {
            this.ap12 = (CarActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CarActionProxy Action Proxy added");
            return this.ap12;
        }
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap3 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap1 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap2 = (EcallActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap5 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap5;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap0 = (MMICombiActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap7 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap7;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap8 = (NaviActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy added");
            return this.ap8;
        }
        if (actionProxy instanceof TrafficInfoJPActionProxy) {
            this.ap13 = (TrafficInfoJPActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TrafficInfoJPActionProxy Action Proxy added");
            return this.ap13;
        }
        return null;
    }

    private void catchActionExceptionEngineeringActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EngineeringActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EngineeringActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionCustDownloadActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CustDownloadActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'CustDownloadActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionMessagingActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'MessagingActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'MessagingActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionToneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ToneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ToneActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionPhoneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'PhoneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'PhoneActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionCarActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CarActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'CarActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionEntertainmentActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EntertainmentActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EntertainmentActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionEcallActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EcallActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EcallActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionMMICombiActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'MMICombiActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'MMICombiActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionNaviActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'NaviActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'NaviActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTrafficInfoJPActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TrafficInfoJPActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TrafficInfoJPActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap2_sysInitConnectLeft_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap2;
        try {
            ecallActionProxy.sysInitConnectLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "sysInitConnectLeft");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 36: {
                EcallActionProxy ecallActionProxy = this.ap2;
                try {
                    ecallActionProxy.sysInitPhoneLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "sysInitPhoneLeft");
                }
                return;
            }
            case 58: {
                EntertainmentActionProxy entertainmentActionProxy = this.ap3;
                try {
                    entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
                }
                return;
            }
            case 64: {
                this.ap2_sysInitConnectLeft_2107068339();
                return;
            }
            case 71: {
                EngineeringActionProxy engineeringActionProxy = this.ap4;
                try {
                    engineeringActionProxy.leaveREM(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEngineeringActionProxy(engineeringActionProxy, nullPointerException, "leaveREM");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 79: {
                sMServices.popDrawerIDs();
                return;
            }
            case 94: {
                sMServices.popDrawerIDs();
                return;
            }
            case 311: {
                sMServices.popDrawerIDs();
                return;
            }
            case 426: {
                ToneActionProxy toneActionProxy = this.ap6;
                try {
                    toneActionProxy.a2lsPopupMediaTunerAreaLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "a2lsPopupMediaTunerAreaLeft");
                }
                return;
            }
            case 442: {
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
                }
                return;
            }
            case 447: {
                sMServices.popDrawerIDs();
                return;
            }
            case 449: {
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), ((ChoiceModel)this.getModel(5535)).getValue());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
                }
                return;
            }
            case 477: {
                sMServices.popDrawerIDs();
                return;
            }
            case 489: {
                sMServices.popDrawerIDs();
                return;
            }
            case 490: {
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.navigationLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navigationLeft");
                }
                return;
            }
            case 492: {
                this.ap2_sysInitConnectLeft_2107068339();
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiExit");
                }
                return;
            }
            case 583: {
                sMServices.setScreenMode(1);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap1_mainApplicationWizardLastApplication_725899433() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
        }
    }

    private void ap1_activeApplication__1198502785() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 7);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap1_activeApplication_1501447227() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 5);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap1_activeApplication__700597809() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 2);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap0_setMMICombiContext_1028046213() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 75);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap1_mainApplicationWizardLastApplication_725899439() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 6);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
        }
    }

    private void ap1_activeApplication__177886808() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 22);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap2_sysInitConnectEntered_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap2;
        try {
            ecallActionProxy.sysInitConnectEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "sysInitConnectEntered");
        }
    }

    private void ap5_connectivityCoMaApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap5;
        try {
            connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 24: {
                sMServices.getKeyboardService().setHKIlluminationOff();
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 116);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.setColor(3);
                return;
            }
            case 25: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(4);
                return;
            }
            case 30: {
                sMServices.getKeyboardService().setHKIlluminationOff();
                this.ap1_mainApplicationWizardLastApplication_725899433();
                sMServices.setColor(1);
                return;
            }
            case 33: {
                this.ap0_setMMICombiContext_1804655728();
                sMServices.getKeyboardService().setHKIlluminationExclusive(7);
                this.ap1_mainApplicationWizardLastApplication_725899433();
                sMServices.setColor(1);
                this.ap1_activeApplication__1198502785();
                return;
            }
            case 34: {
                this.ap0_setMMICombiContext_1028046093();
                sMServices.getKeyboardService().setHKIlluminationExclusive(2);
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(2);
                return;
            }
            case 35: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(5);
                this.ap0_setMMICombiContext_1028046053();
                sMServices.setColor(3);
                this.ap1_activeApplication_1501447227();
                this.ap1_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 36: {
                this.ap0_setMMICombiContext_1028046123();
                sMServices.getKeyboardService().setHKIlluminationExclusive(4);
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(4);
                actionProxy = this.ap2;
                try {
                    actionProxy.sysInitPhoneEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEcallActionProxy(actionProxy, nullPointerException, "sysInitPhoneEntered");
                }
                return;
            }
            case 37: {
                this.ap0_setMMICombiContext_1028046239();
                sMServices.getKeyboardService().setHKIlluminationExclusive(35);
                sMServices.setScreenMode(1);
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 8);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(2);
                frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                return;
            }
            case 38: {
                this.ap0_setMMICombiContext_1028046090();
                sMServices.getKeyboardService().setHKIlluminationExclusive(1);
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(2);
                frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                return;
            }
            case 41: {
                this.ap1_activeApplication__700597809();
                return;
            }
            case 42: {
                this.ap1_activeApplication__700597809();
                return;
            }
            case 47: {
                sMServices.setColor(3);
                return;
            }
            case 58: {
                this.ap0_setMMICombiContext_1028046213();
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 60: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 62: {
                sMServices.setColor(0);
                sMServices.addContext(-239478427L);
                return;
            }
            case 63: {
                sMServices.getKeyboardService().setHKIlluminationOff();
                sMServices.setColor(3);
                return;
            }
            case 64: {
                this.ap0_setMMICombiContext_1804655691();
                sMServices.getKeyboardService().setHKIlluminationOff();
                this.ap1_mainApplicationWizardLastApplication_725899439();
                sMServices.setColor(3);
                this.ap1_activeApplication__177886808();
                this.ap2_sysInitConnectEntered_2107068339();
                return;
            }
            case 71: {
                this.ap0_setMMICombiContext_1028046213();
                sMServices.getKeyboardService().setHKIlluminationOff();
                sMServices.setColor(1);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 75: {
                this.ap0_setMMICombiContext_1028046240();
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(0);
                frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 10);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 79: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 176);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.pushDrawerIDs(0, 0);
                sMServices.getKeyboardService().setHKIlluminationExclusive(7);
                return;
            }
            case 88: {
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 91: {
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 94: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 98: {
                sMServices.setColor(0);
                return;
            }
            case 117: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(5);
                sMServices.setColor(3);
                return;
            }
            case 126: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 175);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 128: {
                sMServices.setColor(0);
                return;
            }
            case 130: {
                sMServices.setColor(0);
                return;
            }
            case 136: {
                sMServices.setColor(0);
                return;
            }
            case 141: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(2);
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 38);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                return;
            }
            case 148: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 149: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 153: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 240);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 162: {
                sMServices.setColor(1);
                this.ap1_activeApplication__1198502785();
                return;
            }
            case 173: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 185);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 178: {
                sMServices.setColor(3);
                return;
            }
            case 180: {
                sMServices.setColor(3);
                return;
            }
            case 190: {
                sMServices.setColor(0);
                return;
            }
            case 207: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(5);
                this.ap0_setMMICombiContext_1028046053();
                sMServices.setColor(3);
                this.ap1_activeApplication_1501447227();
                this.ap1_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 235: {
                sMServices.setColor(4);
                return;
            }
            case 237: {
                this.ap5_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 238: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 74);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 253: {
                ActionProxy actionProxy;
                if (((ChoiceModel)this.getModel(4239)).getValue() == 0) {
                    actionProxy = this.ap1;
                    try {
                        actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 18);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#4239) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(4239)).getValue() == 1) {
                    actionProxy = this.ap1;
                    try {
                        actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 16);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#4239) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(4239)).getValue() == 2) {
                    actionProxy = this.ap1;
                    try {
                        actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 17);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#4239) Value == 2' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(4239)).getValue() == 3) {
                    actionProxy = this.ap1;
                    try {
                        actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 19);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#4239) Value == 3' is not fullfilled, Action is not executed.");
                }
                sMServices.setColor(4);
                sMServices.getKeyboardService().setHKIlluminationOff();
                actionProxy = this.ap1;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 43);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                actionProxy = this.ap0;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 117);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 260: {
                this.ap5_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 264: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 182);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 265: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 174);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 268: {
                ConnectivityActionProxy connectivityActionProxy = this.ap5;
                try {
                    connectivityActionProxy.connectivityWlanInstanceEntered(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityWlanInstanceEntered");
                }
                this.ap5_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 277: {
                this.ap0_setMMICombiContext_1028046123();
                sMServices.setColor(4);
                ConnectivityActionProxy connectivityActionProxy = this.ap5;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 2, 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap5_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 278: {
                this.ap0_setMMICombiContext_1028046123();
                sMServices.setColor(4);
                ConnectivityActionProxy connectivityActionProxy = this.ap5;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 3, 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap5_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 289: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 13);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(4);
                this.ap1_activeApplication__177886808();
                actionProxy = this.ap0;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 62);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 297: {
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 21);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
                }
                frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.addScreenAnimation(1);
                return;
            }
            case 311: {
                sMServices.pushDrawerIDs(0, 0L);
                return;
            }
            case 394: {
                sMServices.setColor(0);
                return;
            }
            case 397: {
                sMServices.setColor(0);
                return;
            }
            case 400: {
                sMServices.setColor(0);
                return;
            }
            case 403: {
                sMServices.setColor(0);
                return;
            }
            case 404: {
                sMServices.setColor(0);
                return;
            }
            case 406: {
                sMServices.setColor(0);
                return;
            }
            case 408: {
                sMServices.setColor(0);
                return;
            }
            case 410: {
                sMServices.setColor(0);
                return;
            }
            case 412: {
                sMServices.setColor(0);
                return;
            }
            case 415: {
                sMServices.setColor(0);
                return;
            }
            case 417: {
                sMServices.setColor(0);
                return;
            }
            case 421: {
                this.ap0_setMMICombiContext_1804655909();
                sMServices.getKeyboardService().setHKIlluminationOff();
                return;
            }
            case 426: {
                ToneActionProxy toneActionProxy = this.ap6;
                try {
                    toneActionProxy.a2lsPopupMediaTunerAreaEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionToneActionProxy(toneActionProxy, nullPointerException, "a2lsPopupMediaTunerAreaEntered");
                }
                return;
            }
            case 442: {
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.startOperatorCall(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "startOperatorCall");
                }
                return;
            }
            case 443: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 12);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                sMServices.setColor(4);
                this.ap1_activeApplication__177886808();
                actionProxy = this.ap0;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 63);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 447: {
                sMServices.pushDrawerIDs(-1L, 0L);
                return;
            }
            case 477: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 0);
                this.ap7_myAudiAuthScreenType_725899433();
                return;
            }
            case 489: {
                sMServices.getKeyboardService().setHKIlluminationExclusive(5);
                this.ap0_setMMICombiContext_1028046053();
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 0L);
                this.ap1_activeApplication_1501447227();
                this.ap1_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 490: {
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.navigationEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navigationEntered");
                }
                return;
            }
            case 492: {
                this.ap0_setMMICombiContext_1804655691();
                sMServices.getKeyboardService().setHKIlluminationOff();
                this.ap1_mainApplicationWizardLastApplication_725899439();
                sMServices.setColor(3);
                this.ap1_activeApplication__177886808();
                this.ap2_sysInitConnectEntered_2107068339();
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiLayoutConstants(this.smm.getTerminalID(), 290, 245, 25);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiLayoutConstants");
                }
                onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiPrepare(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiPrepare");
                }
                onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
                }
                onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiEnter(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiEnter");
                }
                return;
            }
            case 583: {
                sMServices.setScreenMode(2);
                return;
            }
        }
    }

    private void ap9_HKTelPressed_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap9;
        try {
            phoneActionProxy.HKTelPressed(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "HKTelPressed");
        }
    }

    private void ap5_connectivityDataHkTelPressed_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap5;
        try {
            connectivityActionProxy.connectivityDataHkTelPressed(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataHkTelPressed");
        }
    }

    private void ap1_mainApplicationWizardLastApplication_725899437() {
        FrameworkActionProxy frameworkActionProxy = this.ap1;
        try {
            frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 4);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
        }
    }

    private void ap9_switchToTelIncomingCallAccepted_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap9;
        try {
            phoneActionProxy.switchToTelIncomingCallAccepted(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "switchToTelIncomingCallAccepted");
        }
    }

    private void ap11_swdlCustomerUpdateEntered_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap11;
        try {
            custDownloadActionProxy.swdlCustomerUpdateEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEntered");
        }
    }

    private void ap0_setMMICombiContext_1804656778() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 254);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1804655728() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 128);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046090() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 36);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046093() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 39);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046123() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 48);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046055() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 22);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046053() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 20);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1804655691() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 112);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap5_connectivityCoMaInstanceEnteredSetApplicationId_109835637() {
        ConnectivityActionProxy connectivityActionProxy = this.ap5;
        try {
            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 6);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
        }
    }

    private void ap0_setMMICombiContext_1028046239() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 80);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_setMMICombiContext_1028046240() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 81);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap5_connectivityCoMaInstanceEnteredSetApplicationId_109746264() {
        ConnectivityActionProxy connectivityActionProxy = this.ap5;
        try {
            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 6);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
        }
    }

    private void ap12_resetTruffleSelection_2107068339() {
        CarActionProxy carActionProxy = this.ap12;
        try {
            carActionProxy.resetTruffleSelection(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "resetTruffleSelection");
        }
    }

    private void ap9_switchToTelOutgoingCall_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap9;
        try {
            phoneActionProxy.switchToTelOutgoingCall(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "switchToTelOutgoingCall");
        }
    }

    private void ap11_leaveCustomerUpdate_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap11;
        try {
            custDownloadActionProxy.leaveCustomerUpdate(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "leaveCustomerUpdate");
        }
    }

    private void ap7_myAudiAuthScreenType_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap7;
        try {
            onlineActionProxy.myAudiAuthScreenType(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthScreenType");
        }
    }

    private void ap0_setMMICombiContext_1804655909() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 183);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 27: {
                sMServices.addScreenAnimation(1);
                sMServices.setColor(2);
                sMServices.setScreenMode(4);
                return;
            }
            case 29: {
                switch (n2) {
                    case 2: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 30: {
                switch (n2) {
                    case 2: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 51: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 53: {
                sMServices.addScreenAnimation(1);
                this.ap9_HKTelPressed_2107068339();
                this.ap5_connectivityDataHkTelPressed_2107068339();
                return;
            }
            case 54: {
                sMServices.addScreenAnimation(1);
                this.ap1_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 55: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 56: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 57: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 59: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 60: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 100: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 108: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 120: {
                this.ap9_switchToTelIncomingCallAccepted_2107068339();
                return;
            }
            case 121: {
                this.ap9_switchToTelIncomingCallAccepted_2107068339();
                return;
            }
            case 122: {
                this.ap9_switchToTelIncomingCallAccepted_2107068339();
                return;
            }
            case 128: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 129: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 130: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 131: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 133: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 134: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 135: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 136: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 137: {
                sMServices.addScreenAnimation(1);
                this.ap1_mainApplicationWizardLastApplication_725899437();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 138: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 139: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 149: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 156: {
                sMServices.setColor(0);
                return;
            }
            case 157: {
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.hkSetupDuringPowerPopup(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "hkSetupDuringPowerPopup");
                }
                return;
            }
            case 162: {
                sMServices.setColor(0);
                return;
            }
            case 166: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 173: {
                sMServices.addScreenAnimation(1);
                this.ap9_HKTelPressed_2107068339();
                this.ap5_connectivityDataHkTelPressed_2107068339();
                return;
            }
            case 187: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 188: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 193: {
                sMServices.addScreenAnimation(1);
                FrameworkActionProxy frameworkActionProxy = this.ap1;
                try {
                    frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 221: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 230: {
                sMServices.addScreenAnimation(1);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 235: {
                sMServices.setColor(4);
                MessagingActionProxy messagingActionProxy = this.ap10;
                try {
                    messagingActionProxy.officeEnteredFromMainWizard(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "officeEnteredFromMainWizard");
                }
                return;
            }
            case 277: {
                switch (n2) {
                    case 1: {
                        NaviActionProxy naviActionProxy = this.ap8;
                        try {
                            naviActionProxy.onlineSearchEnter(this.smm.getTerminalID(), 3);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlineSearchEnter");
                        }
                        return;
                    }
                    case 4: {
                        return;
                    }
                    case 5: {
                        this.ap11_swdlCustomerUpdateEntered_2107068339();
                        return;
                    }
                    case 6: {
                        if (((ChoiceModel)this.getModel(-1273289984)).getValue() == 10) {
                            OnlineActionProxy onlineActionProxy = this.ap7;
                            try {
                                onlineActionProxy.remotehmiOnlineTrafficEntered(this.smm.getTerminalID());
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remotehmiOnlineTrafficEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition '( ChoiceModel (MODELID#2300852) Value == 10 )' is not fullfilled, Action is not executed.");
                        }
                        return;
                    }
                    case 7: {
                        OnlineActionProxy onlineActionProxy;
                        if (((ChoiceModel)this.getModel(-1273289984)).getValue() == 12) {
                            onlineActionProxy = this.ap7;
                            try {
                                onlineActionProxy.remotehmiEmailEntered(this.smm.getTerminalID());
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remotehmiEmailEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2300852) Value == 12' is not fullfilled, Action is not executed.");
                        }
                        if (((ChoiceModel)this.getModel(-1273289984)).getValue() == 8) {
                            onlineActionProxy = this.ap7;
                            try {
                                onlineActionProxy.remotehmiSmsEntered(this.smm.getTerminalID());
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remotehmiSmsEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2300852) Value == 8' is not fullfilled, Action is not executed.");
                        }
                        return;
                    }
                    case 8: {
                        OnlineActionProxy onlineActionProxy = this.ap7;
                        try {
                            onlineActionProxy.remotehmiGoogleEarthEntered(this.smm.getTerminalID());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remotehmiGoogleEarthEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 280: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 298: {
                PhoneActionProxy phoneActionProxy = this.ap9;
                try {
                    phoneActionProxy.epmSwitchToPreviousContext(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "epmSwitchToPreviousContext");
                }
                return;
            }
            case 301: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 303: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 331: {
                return;
            }
            case 338: {
                return;
            }
            case 340: {
                this.ap11_swdlCustomerUpdateEntered_2107068339();
                return;
            }
            case 344: {
                return;
            }
            case 350: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap11;
                try {
                    custDownloadActionProxy.swdlCustomerUpdateEnteredFromNavi(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEnteredFromNavi");
                }
                return;
            }
            case 359: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                actionProxy = this.ap9;
                try {
                    actionProxy.TelAppEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "TelAppEntered");
                }
                sMServices.setColor(4);
                return;
            }
            case 360: {
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.onlineSearchEnter(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlineSearchEnter");
                }
                return;
            }
            case 361: {
                return;
            }
            case 362: {
                return;
            }
            case 371: {
                return;
            }
            case 375: {
                return;
            }
            case 376: {
                return;
            }
            case 377: {
                return;
            }
            case 378: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 382: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-65403392);
                        return;
                    }
                }
                return;
            }
            case 385: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-65403392);
                        return;
                    }
                }
                return;
            }
            case 390: {
                switch (n2) {
                    case 1: {
                        return;
                    }
                }
                return;
            }
            case 396: {
                PhoneActionProxy phoneActionProxy = this.ap9;
                try {
                    phoneActionProxy.resetSearchResult(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "resetSearchResult");
                }
                return;
            }
            case 402: {
                return;
            }
            case 403: {
                return;
            }
            case 409: {
                OnlineActionProxy onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.remoteHmiMarkForTopLevel(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMarkForTopLevel");
                }
                onlineActionProxy = this.ap7;
                try {
                    onlineActionProxy.myAudiAuthContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthContext");
                }
                return;
            }
            case 411: {
                return;
            }
            case 416: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 417: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 418: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 419: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 420: {
                return;
            }
            case 432: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                return;
            }
            case 436: {
                return;
            }
            case 448: {
                switch (n2) {
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 449: {
                switch (n2) {
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 453: {
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.enterDestSelectionContext(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestSelectionContext");
                }
                return;
            }
            case 473: {
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.enterPoiMainScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPoiMainScreen");
                }
                return;
            }
            case 495: {
                OnlineActionProxy onlineActionProxy;
                if (((ChoiceModel)this.getModel(-1273289984)).getValue() == 3) {
                    onlineActionProxy = this.ap7;
                    try {
                        onlineActionProxy.remoteHMICallMediaApp(this.smm.getTerminalID());
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHMICallMediaApp");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2300852) Value == 3' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(-1273289984)).getValue() == 13) {
                    onlineActionProxy = this.ap7;
                    try {
                        onlineActionProxy.remoteHMICallWifiPlayer(this.smm.getTerminalID());
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHMICallWifiPlayer");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2300852) Value == 13' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 509: {
                switch (n2) {
                    case 0: {
                        sMServices.setColor(1);
                        this.ap0_setMMICombiContext_1804655728();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 0);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 1: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046090();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 1);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 2: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046093();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 2);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 3: {
                        sMServices.setColor(4);
                        this.ap0_setMMICombiContext_1028046123();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 3);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 4: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1028046055();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 4);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 5: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1028046053();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 5);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 6: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1804655691();
                        this.ap5_connectivityCoMaInstanceEnteredSetApplicationId_109835637();
                        return;
                    }
                    case 7: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046239();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 8);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 8: {
                        sMServices.setColor(0);
                        this.ap0_setMMICombiContext_1028046240();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 9);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 9: {
                        this.ap5_connectivityCoMaInstanceEnteredSetApplicationId_109835637();
                        return;
                    }
                }
                return;
            }
            case 512: {
                return;
            }
            case 517: {
                return;
            }
            case 518: {
                sMServices.setColor(0);
                return;
            }
            case 545: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 551: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                NaviActionProxy naviActionProxy = this.ap8;
                try {
                    naviActionProxy.destExitStartGuidancePopup(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destExitStartGuidancePopup");
                }
                return;
            }
            case 554: {
                sMServices.setColor(0);
                return;
            }
            case 556: {
                switch (n2) {
                    case 0: {
                        sMServices.setColor(0);
                        this.ap0_setMMICombiContext_1028046240();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 9);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 1: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1804655691();
                        this.ap5_connectivityCoMaInstanceEnteredSetApplicationId_109746264();
                        return;
                    }
                    case 2: {
                        sMServices.setColor(4);
                        this.ap0_setMMICombiContext_1028046123();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 3);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 3: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046090();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 1);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 4: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1028046055();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 4);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 5: {
                        sMServices.setColor(3);
                        this.ap0_setMMICombiContext_1028046053();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 5);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 6: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046093();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 2);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 7: {
                        sMServices.setColor(2);
                        this.ap0_setMMICombiContext_1028046239();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 8);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 8: {
                        sMServices.setColor(1);
                        this.ap0_setMMICombiContext_1804655728();
                        ConnectivityActionProxy connectivityActionProxy = this.ap5;
                        try {
                            connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 1, 0);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                        }
                        return;
                    }
                    case 9: {
                        this.ap5_connectivityCoMaInstanceEnteredSetApplicationId_109746264();
                        return;
                    }
                }
                return;
            }
            case 559: {
                return;
            }
            case 567: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 568: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 569: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 570: {
                this.ap0_setMMICombiContext_1804656778();
                return;
            }
            case 579: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 580: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 581: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 582: {
                sMServices.addScreenAnimation(1);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 583: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 584: {
                sMServices.addScreenAnimation(1);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 585: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 586: {
                sMServices.addScreenAnimation(1);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 587: {
                return;
            }
            case 588: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 604: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 132);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 605: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 135);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 606: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 131);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 607: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 133);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 608: {
                sMServices.addScreenAnimation(1);
                this.ap12_resetTruffleSelection_2107068339();
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 136);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 609: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 134);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 610: {
                sMServices.addScreenAnimation(1);
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 139);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                return;
            }
            case 613: {
                return;
            }
            case 615: {
                return;
            }
            case 628: {
                switch (n2) {
                    default: 
                }
                return;
            }
            case 629: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 634: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 638: {
                sMServices.setColor(0);
                return;
            }
            case 652: {
                return;
            }
            case 660: {
                return;
            }
            case 669: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 670: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 673: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 684: {
                this.ap9_switchToTelOutgoingCall_2107068339();
                this.ap11_leaveCustomerUpdate_2107068339();
                return;
            }
            case 685: {
                this.ap9_switchToTelOutgoingCall_2107068339();
                return;
            }
            case 700: {
                return;
            }
            case 701: {
                return;
            }
            case 702: {
                return;
            }
            case 703: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(4);
                        return;
                    }
                }
                return;
            }
            case 704: {
                this.ap7_myAudiAuthScreenType_725899433();
                return;
            }
            case 706: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-652540416);
                        return;
                    }
                }
                return;
            }
            case 709: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 710: {
                this.ap0_setMMICombiContext_1804655909();
                return;
            }
            case 711: {
                return;
            }
            case 712: {
                return;
            }
            case 727: {
                return;
            }
            case 734: {
                return;
            }
            case 735: {
                return;
            }
            case 737: {
                sMServices.setColor(3);
                return;
            }
            case 739: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 750: {
                return;
            }
            case 751: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 756: {
                return;
            }
            case 760: {
                return;
            }
            case 765: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 2) {
                    sMServices.setColor(3);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 2' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    sMServices.setColor(4);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 788: {
                return;
            }
            case 789: {
                return;
            }
            case 793: {
                return;
            }
            case 794: {
                this.ap11_leaveCustomerUpdate_2107068339();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 811: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 817: {
                return;
            }
            case 835: {
                if (((ChoiceModel)this.getModel(1686700288)).getValue() == 0) {
                    EntertainmentActionProxy entertainmentActionProxy = this.ap3;
                    try {
                        entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 1001);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
                    }
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#100708) Value == 0' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 841: {
                return;
            }
            case 842: {
                return;
            }
            case 849: {
                TrafficInfoJPActionProxy trafficInfoJPActionProxy = this.ap13;
                try {
                    trafficInfoJPActionProxy.vicsGlobalShowInMapLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTrafficInfoJPActionProxy(trafficInfoJPActionProxy, nullPointerException, "vicsGlobalShowInMapLeft");
                }
                return;
            }
            case 850: {
                sMServices.addScreenAnimation(1);
                return;
            }
            case 865: {
                this.ap12_resetTruffleSelection_2107068339();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 870: {
                EcallActionProxy ecallActionProxy = this.ap2;
                try {
                    ecallActionProxy.btnPerformTest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "btnPerformTest");
                }
                return;
            }
            case 875: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(1);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(191);
                        sMServices.setColor(0);
                        return;
                    }
                }
                return;
            }
            case 877: {
                sMServices.showPartialPopup(85533440);
                return;
            }
            case 878: {
                sMServices.showPartialPopup(85533440);
                return;
            }
            case 879: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 881: {
                sMServices.showPartialPopup(85533440);
                return;
            }
            case 884: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 885: {
                sMServices.showPartialPopup(191);
                return;
            }
            case 886: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(191);
                        return;
                    }
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


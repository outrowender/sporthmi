/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.PhoneActionProxy;

public class ConnectivitySMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile ConnectivityActionProxy ap0;
    private volatile PhoneActionProxy ap1;
    private volatile OnlineActionProxy ap2;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{26, 11, 12};

    protected ConnectivitySMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "PhoneActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap0 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap1 = (PhoneActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "PhoneActionProxy Action Proxy added");
            return this.ap1;
        }
        return null;
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionPhoneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'PhoneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'PhoneActionProxy' missing for call '%1'", (Object)string);
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

    private void ap0_connectivityBluetoothBondingExitAction_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBluetoothBondingExitAction(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothBondingExitAction");
        }
    }

    private void ap0_connectivityBlueAbortInquiry_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBlueAbortInquiry(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueAbortInquiry");
        }
    }

    private void ap0_connectivityBlueOfficeSetupExit_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBlueOfficeSetupExit(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueOfficeSetupExit");
        }
    }

    private void ap0_connectivityWlanAbortInquiry_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityWlanAbortInquiry(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityWlanAbortInquiry");
        }
    }

    private void ap0_connectivityDataOnlineSetupLeft_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataOnlineSetupLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineSetupLeft");
        }
    }

    private void ap0_connectivityDataOnlineCheckLeft_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataOnlineCheckLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineCheckLeft");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 2500004: {
                sMServices.removeContext(-601412079L);
                return;
            }
            case 2500018: {
                this.ap0_connectivityBluetoothBondingExitAction_2107068339();
                return;
            }
            case 2500019: {
                this.ap0_connectivityBlueAbortInquiry_2107068339();
                return;
            }
            case 2500040: {
                this.ap0_connectivityBlueOfficeSetupExit_2107068339();
                return;
            }
            case 2500063: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500074: {
                this.ap0_connectivityWlanAbortInquiry_2107068339();
                return;
            }
            case 0x262616: {
                sMServices.popDrawerIDs();
                return;
            }
            case 0x262636: {
                this.ap0_connectivityDataOnlineSetupLeft_2107068339();
                return;
            }
            case 0x262652: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityDataOnlinePopupLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlinePopupLeft");
                }
                return;
            }
            case 2500179: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500184: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500216: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500254: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500273: {
                this.ap0_connectivityDataOnlineCheckLeft_2107068339();
                return;
            }
            case 2500280: {
                sMServices.setScreenMode(1);
                sMServices.popDrawerIDs();
                return;
            }
            case 2500281: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500282: {
                sMServices.setScreenMode(1);
                return;
            }
            case 2500296: {
                sMServices.popDrawerIDs();
                return;
            }
            case 0x2626DD: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500320: {
                this.ap0_connectivityBlueAbortInquiry_2107068339();
                return;
            }
            case 2500352: {
                this.ap0_connectivityBlueAbortInquiry_2107068339();
                return;
            }
            case 2500356: {
                this.ap0_connectivityDataOnlineCheckLeft_2107068339();
                return;
            }
            case 2500372: {
                sMServices.removeContext(-239478427L);
                return;
            }
            case 2500377: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500384: {
                this.ap0_connectivityBlueOfficeSetupExit_2107068339();
                return;
            }
            case 0x262727: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500400: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500402: {
                this.ap0_connectivityWlanAbortInquiry_2107068339();
                return;
            }
            case 2500406: {
                this.ap0_connectivityBluetoothBondingExitAction_2107068339();
                return;
            }
            case 2500408: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2500437: {
                this.ap0_connectivityDataOnlineSetupLeft_2107068339();
                return;
            }
            case 2500452: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.telUnlockLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telUnlockLeft");
                }
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_connectivityCoMaApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
        }
    }

    private void ap0_connectivityBluetoothBondingEntryAction_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBluetoothBondingEntryAction(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothBondingEntryAction");
        }
    }

    private void ap0_connectivityDataOnlineCheckEntered_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataOnlineCheckEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineCheckEntered");
        }
    }

    private void ap0_connectivityDataApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataApplicationContext");
        }
    }

    private void ap0_connectivityDataInstanceEntered_725899433() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataInstanceEntered(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataInstanceEntered");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 2500004: {
                sMServices.addContext(-601412079L);
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityCoMaEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaEntered");
                }
                return;
            }
            case 2500007: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 5, 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap0_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 2500018: {
                this.ap0_connectivityBluetoothBondingEntryAction_2107068339();
                return;
            }
            case 2500063: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 0x262616: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500119: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 0x262652: {
                sMServices.setColor(3);
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityDataOnlinePopupEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlinePopupEntered");
                }
                return;
            }
            case 2500179: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500184: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500216: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(-1L, 0);
                return;
            }
            case 2500254: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500273: {
                this.ap0_connectivityDataOnlineCheckEntered_2107068339();
                return;
            }
            case 2500280: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500281: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500282: {
                sMServices.setScreenMode(2);
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
                }
                return;
            }
            case 0x2626C2: {
                this.ap0_connectivityDataApplicationContext_725899434();
                return;
            }
            case 2500296: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500315: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 0x2626DD: {
                sMServices.pushDrawerIDs(0L, 0);
                this.ap0_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 2500323: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityBluetoothInstanceEntered(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothInstanceEntered");
                }
                return;
            }
            case 2500324: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityWlanInstanceEntered(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityWlanInstanceEntered");
                }
                return;
            }
            case 2500325: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityDataInstanceEntered(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataInstanceEntered");
                }
                return;
            }
            case 0x2626E6: {
                this.ap0_connectivityDataInstanceEntered_725899433();
                return;
            }
            case 2500356: {
                this.ap0_connectivityDataOnlineCheckEntered_2107068339();
                return;
            }
            case 2500371: {
                this.ap0_connectivityDataInstanceEntered_725899433();
                return;
            }
            case 2500372: {
                this.ap0_connectivityDataApplicationContext_725899434();
                sMServices.addContext(-239478427L);
                return;
            }
            case 2500377: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 0x262727: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500400: {
                sMServices.pushDrawerIDs(-1L, 0);
                return;
            }
            case 2500406: {
                this.ap0_connectivityBluetoothBondingEntryAction_2107068339();
                return;
            }
            case 2500408: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 2500409: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500425: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500452: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.telUnlockEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "telUnlockEntered");
                }
                actionProxy = this.ap0;
                try {
                    actionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(actionProxy, nullPointerException, "connectivityDataApplicationContext");
                }
                return;
            }
            case 2500538: {
                OnlineActionProxy onlineActionProxy = this.ap2;
                try {
                    onlineActionProxy.changePrivacySettingsScreenMode(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "changePrivacySettingsScreenMode");
                }
                return;
            }
            case 2500543: {
                sMServices.setColor(3);
                return;
            }
        }
    }

    private void ap0_connectivityBlueApplicationContext_725899433() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBlueApplicationContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueApplicationContext");
        }
    }

    private void ap0_connectivityDataOnlineSetupOnlineError_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityDataOnlineSetupOnlineError(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineSetupOnlineError");
        }
    }

    private void ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap0;
        try {
            connectivityActionProxy.connectivityBluetoothBondingSpeedDisclaimerEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothBondingSpeedDisclaimerEntered");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 2500000: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500002: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500003: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500007: {
                sMServices.addScreenAnimation(8);
                this.ap0_connectivityBlueApplicationContext_725899433();
                return;
            }
            case 2500011: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2500017: {
                return;
            }
            case 2500022: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500034: {
                switch (n2) {
                    case 5: {
                        sMServices.showPartialPopup(-299555328);
                        return;
                    }
                }
                return;
            }
            case 2500039: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.btBondingEntryPoint(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "btBondingEntryPoint");
                }
                return;
            }
            case 2500067: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500148: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 0x262636: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500151: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500152: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500153: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500154: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500157: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 0x262642: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500163: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500184: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 0x262666: {
                sMServices.addScreenAnimation(2);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 0x26266A: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 0x26266B: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 0x26266D: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 0x26266E: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 0x26266F: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500208: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 0x262672: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-484104704);
                        return;
                    }
                }
                return;
            }
            case 2500211: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500213: {
                sMServices.hidePartialPopup(-920312320);
                return;
            }
            case 0x262676: {
                sMServices.hidePartialPopup(-920312320);
                sMServices.hidePartialPopup(723920384);
                return;
            }
            case 0x2626A2: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2500259: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2500269: {
                sMServices.showPartialPopup(-668654080);
                return;
            }
            case 2500270: {
                sMServices.showPartialPopup(-685431296);
                return;
            }
            case 2500286: {
                sMServices.showPartialPopup(-500881920);
                return;
            }
            case 0x2626C2: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500293: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 0x2626C6: {
                sMServices.showPartialPopup(-450550272);
                return;
            }
            case 2500297: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 0x2626D2: {
                sMServices.hidePartialPopup(-349886976);
                sMServices.hidePartialPopup(321267200);
                return;
            }
            case 2500315: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500316: {
                switch (n2) {
                    case 2: {
                        sMServices.showPartialPopup(723920384);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(-920312320);
                        return;
                    }
                }
                return;
            }
            case 2500318: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-266000896);
                return;
            }
            case 2500319: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500320: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500321: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-266000896);
                return;
            }
            case 0x2626E2: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500323: {
                sMServices.hidePartialPopup(-249223680);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500325: {
                sMServices.showPartialPopup(-249223680);
                return;
            }
            case 2500327: {
                sMServices.showPartialPopup(-249223680);
                return;
            }
            case 2500332: {
                sMServices.showPartialPopup(-316332544);
                return;
            }
            case 2500333: {
                sMServices.hidePartialPopup(-316332544);
                sMServices.showPartialPopup(-333109760);
                return;
            }
            case 0x2626EE: {
                sMServices.hidePartialPopup(-316332544);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500335: {
                sMServices.hidePartialPopup(-316332544);
                sMServices.showPartialPopup(-232446464);
                return;
            }
            case 2500336: {
                sMServices.showPartialPopup(-316332544);
                return;
            }
            case 2500337: {
                sMServices.hidePartialPopup(-316332544);
                return;
            }
            case 0x2626F2: {
                sMServices.hidePartialPopup(-316332544);
                return;
            }
            case 2500339: {
                sMServices.hidePartialPopup(-316332544);
                sMServices.showPartialPopup(-333109760);
                return;
            }
            case 2500340: {
                sMServices.showPartialPopup(-299555328);
                return;
            }
            case 2500341: {
                sMServices.hidePartialPopup(-299555328);
                return;
            }
            case 0x2626F6: {
                sMServices.hidePartialPopup(-299555328);
                return;
            }
            case 2500343: {
                sMServices.hidePartialPopup(-299555328);
                sMServices.showPartialPopup(-282778112);
                return;
            }
            case 2500360: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityDataOnlineSetupCoMa(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineSetupCoMa");
                }
                return;
            }
            case 2500372: {
                sMServices.showPartialPopup(-165337600);
                return;
            }
            case 2500373: {
                this.ap0_connectivityBlueApplicationContext_725899433();
                return;
            }
            case 0x262722: {
                sMServices.showPartialPopup(-131783168);
                return;
            }
            case 2500388: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(-131783168);
                        return;
                    }
                }
                return;
            }
            case 2500394: {
                sMServices.showPartialPopup(-131783168);
                return;
            }
            case 2500405: {
                sMServices.showPartialPopup(-651876864);
                return;
            }
            case 2500429: {
                sMServices.hidePartialPopup(86386176);
                return;
            }
            case 2500430: {
                sMServices.hidePartialPopup(0x6262600);
                return;
            }
            case 2500440: {
                sMServices.showPartialPopup(69608960);
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2500441: {
                sMServices.hidePartialPopup(69608960);
                sMServices.showPartialPopup(0x6262600);
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2500442: {
                sMServices.hidePartialPopup(69608960);
                sMServices.showPartialPopup(86386176);
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2500489: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500490: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500493: {
                sMServices.hidePartialPopup(-651876864);
                return;
            }
            case 2500504: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500510: {
                sMServices.hidePartialPopup(-668654080);
                return;
            }
            case 2500511: {
                sMServices.hidePartialPopup(-668654080);
                return;
            }
            case 2500524: {
                sMServices.showPartialPopup(304489984);
                return;
            }
            case 2500525: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500526: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500527: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500529: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500544: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.connectivityBlueApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueApplicationContext");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500549: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500552: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500554: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500555: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500565: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(656811520);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(-349886976);
                        return;
                    }
                }
                return;
            }
            case 2500566: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(673588736);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(321267200);
                        return;
                    }
                }
                return;
            }
            case 2500588: {
                sMServices.hidePartialPopup(-349886976);
                return;
            }
            case 2500589: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500617: {
                this.ap0_connectivityDataOnlineSetupOnlineError_2107068339();
                return;
            }
            case 2500623: {
                ConnectivityActionProxy connectivityActionProxy = this.ap0;
                try {
                    connectivityActionProxy.btBondingEntryPoint(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "btBondingEntryPoint");
                }
                return;
            }
            case 2500626: {
                switch (n2) {
                    case 0: {
                        return;
                    }
                    case 1: {
                        return;
                    }
                }
                return;
            }
            case 2500632: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500633: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500634: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 0x262828: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500670: {
                sMServices.showPartialPopup(304489984);
                return;
            }
            case 2500673: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500674: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500675: {
                sMServices.hidePartialPopup(304489984);
                return;
            }
            case 2500682: {
                sMServices.showPartialPopup(-668654080);
                return;
            }
            case 2500686: {
                sMServices.hidePartialPopup(-668654080);
                return;
            }
            case 2500687: {
                sMServices.hidePartialPopup(-668654080);
                return;
            }
            case 2500693: {
                switch (n2) {
                    case 1: {
                        ConnectivityActionProxy connectivityActionProxy = this.ap0;
                        try {
                            connectivityActionProxy.connectivityDataOnlineRequestEntered(this.smm.getTerminalID(), 1);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineRequestEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 2500694: {
                switch (n2) {
                    case 1: {
                        ConnectivityActionProxy connectivityActionProxy = this.ap0;
                        try {
                            connectivityActionProxy.connectivityDataOnlineRequestEntered(this.smm.getTerminalID(), 0);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineRequestEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 2500699: {
                sMServices.showPartialPopup(-450550272);
                return;
            }
            case 0x262868: {
                sMServices.showPartialPopup(-685431296);
                return;
            }
            case 2500715: {
                this.ap0_connectivityDataOnlineSetupOnlineError_2107068339();
                return;
            }
            case 2500731: {
                sMServices.hidePartialPopup(-349886976);
                return;
            }
            case 2500734: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500736: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500737: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500755: {
                sMServices.addScreenAnimation(2);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500759: {
                sMServices.showPartialPopup(-500881920);
                return;
            }
            case 2500761: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500794: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500798: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2500804: {
                sMServices.hidePartialPopup(-349886976);
                sMServices.hidePartialPopup(321267200);
                return;
            }
            case 2500805: {
                sMServices.hidePartialPopup(-349886976);
                sMServices.hidePartialPopup(321267200);
                return;
            }
            case 2500806: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(321267200);
                        return;
                    }
                }
                return;
            }
            case 2500808: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(-349886976);
                        return;
                    }
                }
                return;
            }
            case 2500813: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500825: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2500836: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500837: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500838: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500839: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2500840: {
                sMServices.showPartialPopup(-484104704);
                return;
            }
            case 2500841: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500842: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500843: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500850: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500853: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500855: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500857: {
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500864: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500871: {
                return;
            }
            case 2500872: {
                return;
            }
            case 2500873: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500875: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500876: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500877: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500878: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500879: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500880: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500881: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2500888: {
                sMServices.hidePartialPopup(673588736);
                sMServices.showPartialPopup(321267200);
                return;
            }
            case 2500889: {
                sMServices.hidePartialPopup(656811520);
                sMServices.showPartialPopup(-349886976);
                return;
            }
            case 2500915: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500918: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500921: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500939: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500942: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500945: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500972: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500974: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500976: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500978: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500980: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500982: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500984: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2500986: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500988: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500990: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2500992: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2501007: {
                sMServices.hidePartialPopup(723920384);
                return;
            }
            case 0x262996: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2501019: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2501028: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2501029: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2501030: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(774252032);
                        return;
                    }
                }
                return;
            }
            case 2501031: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2501032: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2501033: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 2501034: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501035: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501037: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501039: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501040: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501041: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 2501062: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2501063: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2501074: {
                OnlineActionProxy onlineActionProxy = this.ap2;
                try {
                    onlineActionProxy.gpsPopupAcknowledged(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "gpsPopupAcknowledged");
                }
                return;
            }
            case 2501106: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2501108: {
                this.ap0_connectivityBluetoothBondingSpeedDisclaimerEntered_2107068339();
                return;
            }
            case 2501110: {
                sMServices.addScreenAnimation(128);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2501111: {
                sMServices.addScreenAnimation(128);
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


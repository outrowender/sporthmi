/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.sm;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.PhoneActionProxy;
import de.audi.atip.statemachine.ap.SystemCallActionProxy;

public class PhoneSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile FrameworkActionProxy ap0;
    private volatile PhoneActionProxy ap1;
    private volatile ConnectivityActionProxy ap2;
    private volatile OnlineActionProxy ap3;
    private volatile SystemCallActionProxy ap4;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{4, 26, 17, 11, 12};

    protected PhoneSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof SystemCallActionProxy) {
            this.ap4 = null;
            this.logChannel.log(-2137614336, "SystemCallActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = null;
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
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap2 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof SystemCallActionProxy) {
            this.ap4 = (SystemCallActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "SystemCallActionProxy Action Proxy added");
            return this.ap4;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap1 = (PhoneActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "PhoneActionProxy Action Proxy added");
            return this.ap1;
        }
        return null;
    }

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionSystemCallActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'SystemCallActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'SystemCallActionProxy' missing for call '%1'", (Object)string);
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

    private void ap1_telUnlockLeft_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.telUnlockLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telUnlockLeft");
        }
    }

    private void ap1_popupTelephoneOptionsLeft_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.popupTelephoneOptionsLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "popupTelephoneOptionsLeft");
        }
    }

    private void ap1_numberSpellerLeft_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.numberSpellerLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "numberSpellerLeft");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 300001: {
                sMServices.popDrawerIDs();
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.TelAppLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "TelAppLeft");
                }
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300005: {
                this.ap1_telUnlockLeft_2107068339();
                sMServices.popDrawerIDs();
                sMServices.removeContext(0);
                return;
            }
            case 300039: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300067: {
                sMServices.removeContext(-2142410760L);
                return;
            }
            case 300093: {
                sMServices.hidePartialPopup(0x40940400);
                sMServices.hidePartialPopup(1066664960);
                sMServices.hidePartialPopup(1049887744);
                return;
            }
            case 300098: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300103: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.intellicallFullViewLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "intellicallFullViewLeft");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 300116: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.callDivertActivateLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "callDivertActivateLeft");
                }
                return;
            }
            case 300132: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300167: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                this.ap1_popupTelephoneOptionsLeft_2107068339();
                return;
            }
            case 300168: {
                sMServices.removeContext(0);
                sMServices.addContext(-2142410760L);
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 300170: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300171: {
                sMServices.removeContext(-399568537L);
                return;
            }
            case 300173: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300174: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.telIntelliCallLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telIntelliCallLeft");
                }
                return;
            }
            case 300189: {
                sMServices.removeContext(0);
                return;
            }
            case 300190: {
                sMServices.removeContext(0);
                return;
            }
            case 300191: {
                sMServices.removeContext(-2107031813L);
                return;
            }
            case 300192: {
                sMServices.removeContext(0);
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.favoritesLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "favoritesLeft");
                }
                return;
            }
            case 300199: {
                sMServices.removeContext(-1782111656L);
                this.ap1_numberSpellerLeft_2107068339();
                return;
            }
            case 300201: {
                sMServices.removeContext(-1494997765L);
                return;
            }
            case 300206: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300257: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.telOptSetupNetMainLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telOptSetupNetMainLeft");
                }
                return;
            }
            case 300279: {
                this.ap1_telUnlockLeft_2107068339();
                sMServices.popDrawerIDs();
                sMServices.removeContext(-239478427L);
                return;
            }
            case 300282: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300288: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 300304: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300320: {
                sMServices.setScreenMode(1);
                return;
            }
            case 300350: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300403: {
                sMServices.setScreenMode(1);
                return;
            }
            case 300429: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300446: {
                this.ap1_telUnlockLeft_2107068339();
                sMServices.popDrawerIDs();
                sMServices.removeContext(-239478427L);
                return;
            }
            case 300461: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300478: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.intellicallReducedViewLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "intellicallReducedViewLeft");
                }
                return;
            }
            case 300482: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 300525: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300533: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                this.ap1_popupTelephoneOptionsLeft_2107068339();
                return;
            }
            case 300536: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                this.ap1_popupTelephoneOptionsLeft_2107068339();
                return;
            }
            case 300542: {
                sMServices.setScreenMode(1);
                sMServices.popDrawerIDs();
                return;
            }
            case 300545: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300553: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300555: {
                sMServices.removeContext(-1782111656L);
                this.ap1_numberSpellerLeft_2107068339();
                return;
            }
            case 300586: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300671: {
                sMServices.removeContext(-2142410760L);
                return;
            }
            case 300672: {
                sMServices.popDrawerIDs();
                return;
            }
            case 300680: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                this.ap1_popupTelephoneOptionsLeft_2107068339();
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap1_telUnlockEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.telUnlockEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telUnlockEntered");
        }
    }

    private void ap2_connectivityDataApplicationContext_725899433() {
        ConnectivityActionProxy connectivityActionProxy = this.ap2;
        try {
            connectivityActionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataApplicationContext");
        }
    }

    private void ap1_popupTelephoneOptionsEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.popupTelephoneOptionsEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "popupTelephoneOptionsEntered");
        }
    }

    private void ap1_adbEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.adbEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "adbEntered");
        }
    }

    private void ap1_numberSpellerEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.numberSpellerEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "numberSpellerEntered");
        }
    }

    private void ap1_smsEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.smsEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "smsEntered");
        }
    }

    private void ap2_connectivityCoMaApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap2;
        try {
            connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
        }
    }

    private void ap2_connectivityCoMaApplicationContext_725899433() {
        ConnectivityActionProxy connectivityActionProxy = this.ap2;
        try {
            connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
        }
    }

    private void ap2_connectivitySetApplicationId_725899436() {
        ConnectivityActionProxy connectivityActionProxy = this.ap2;
        try {
            connectivityActionProxy.connectivitySetApplicationId(this.smm.getTerminalID(), 3);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivitySetApplicationId");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 300001: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                sMServices.pushDrawerIDs(0, 0);
                actionProxy = this.ap1;
                try {
                    actionProxy.TelAppEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "TelAppEntered");
                }
                sMServices.setColor(4);
                this.ap2_connectivityBlueApplicationContext_725899434();
                return;
            }
            case 300005: {
                this.ap1_telUnlockEntered_2107068339();
                sMServices.pushDrawerIDs(0L, 0);
                this.ap2_connectivityDataApplicationContext_725899433();
                sMServices.addContext(0);
                return;
            }
            case 300014: {
                sMServices.setScreenMode(2);
                return;
            }
            case 300019: {
                sMServices.setScreenMode(2);
                return;
            }
            case 300039: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300058: {
                sMServices.setColor(4);
                return;
            }
            case 300061: {
                sMServices.hidePartialPopup(982778880);
                sMServices.hidePartialPopup(999556096);
                sMServices.hidePartialPopup(1016333312);
                sMServices.hidePartialPopup(-1131150336);
                return;
            }
            case 300067: {
                sMServices.addContext(-2142410760L);
                return;
            }
            case 300077: {
                sMServices.setColor(4);
                return;
            }
            case 300078: {
                sMServices.setColor(4);
                return;
            }
            case 300080: {
                sMServices.setColor(4);
                return;
            }
            case 300081: {
                sMServices.setColor(4);
                return;
            }
            case 300082: {
                sMServices.setColor(4);
                return;
            }
            case 300083: {
                sMServices.setColor(4);
                return;
            }
            case 300098: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 300103: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.intellicallFullViewEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "intellicallFullViewEntered");
                }
                if (((ChoiceModel)this.getModel(76874752)).getValue() == 0) {
                    sMServices.pushDrawerIDs(0, 0);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#300292) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(76874752)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 0L);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#300292) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 300116: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.callDivertActivateEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "callDivertActivateEntered");
                }
                return;
            }
            case 300132: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300134: {
                sMServices.hidePartialPopup(1016333312);
                return;
            }
            case 300137: {
                sMServices.showPartialPopup(1385432064);
                return;
            }
            case 300167: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap1_popupTelephoneOptionsEntered_2107068339();
                return;
            }
            case 300168: {
                sMServices.removeContext(-2142410760L);
                sMServices.addContext(0);
                if (((ChoiceModel)this.getModel(76874752)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 0L);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#300292) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 300170: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300171: {
                sMServices.addContext(-399568537L);
                this.ap1_adbEntered_2107068339();
                return;
            }
            case 300173: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300174: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.telIntelliCallEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telIntelliCallEntered");
                }
                return;
            }
            case 300189: {
                sMServices.addContext(0);
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.audiServiceEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "audiServiceEntered");
                }
                return;
            }
            case 300190: {
                sMServices.addContext(0);
                return;
            }
            case 300191: {
                sMServices.addContext(-2107031813L);
                return;
            }
            case 300192: {
                sMServices.addContext(0);
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.favoritesEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "favoritesEntered");
                }
                return;
            }
            case 300199: {
                sMServices.addContext(-1782111656L);
                this.ap1_numberSpellerEntered_2107068339();
                return;
            }
            case 300201: {
                this.ap1_smsEntered_2107068339();
                sMServices.addContext(-1494997765L);
                return;
            }
            case 300204: {
                sMServices.setColor(4);
                return;
            }
            case 300206: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 300214: {
                sMServices.setColor(4);
                return;
            }
            case 300219: {
                sMServices.setColor(3);
                return;
            }
            case 300257: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.telOptSetupNetMainEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "telOptSetupNetMainEntered");
                }
                return;
            }
            case 300279: {
                this.ap1_telUnlockEntered_2107068339();
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataApplicationContext");
                }
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(-239478427L);
                return;
            }
            case 300282: {
                sMServices.pushDrawerIDs(0L, 0);
                this.ap2_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 300288: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                return;
            }
            case 300304: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300320: {
                sMServices.setScreenMode(2);
                return;
            }
            case 300327: {
                this.ap1_adbEntered_2107068339();
                return;
            }
            case 300333: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 13, 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap2_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 300350: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300365: {
                this.ap1_smsEntered_2107068339();
                return;
            }
            case 300371: {
                this.ap1_adbEntered_2107068339();
                return;
            }
            case 300402: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 16, 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap2_connectivityCoMaApplicationContext_725899433();
                return;
            }
            case 300403: {
                sMServices.setScreenMode(2);
                return;
            }
            case 300405: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityBluetoothInstanceEntered(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothInstanceEntered");
                }
                this.ap2_connectivitySetApplicationId_725899436();
                return;
            }
            case 300407: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityDataInstanceEntered(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataInstanceEntered");
                }
                this.ap2_connectivitySetApplicationId_725899436();
                return;
            }
            case 300409: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityWlanInstanceEntered(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityWlanInstanceEntered");
                }
                this.ap2_connectivitySetApplicationId_725899436();
                return;
            }
            case 300429: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300443: {
                sMServices.setColor(4);
                return;
            }
            case 300446: {
                this.ap1_telUnlockEntered_2107068339();
                this.ap2_connectivityDataApplicationContext_725899433();
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(-239478427L);
                return;
            }
            case 300447: {
                sMServices.setColor(4);
                return;
            }
            case 300461: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300476: {
                sMServices.setColor(4);
                return;
            }
            case 300482: {
                ActionProxy actionProxy = this.ap3;
                try {
                    actionProxy.startOperatorCall(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "startOperatorCall");
                }
                sMServices.pushDrawerIDs(0, 0);
                actionProxy = this.ap1;
                try {
                    actionProxy.audiConnectNavigatorEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "audiConnectNavigatorEntered");
                }
                return;
            }
            case 300525: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300533: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap1_popupTelephoneOptionsEntered_2107068339();
                return;
            }
            case 300536: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap1_popupTelephoneOptionsEntered_2107068339();
                return;
            }
            case 300542: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0);
                this.ap2_connectivityCoMaApplicationContext_725899433();
                return;
            }
            case 300545: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300553: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300555: {
                sMServices.addContext(-1782111656L);
                this.ap1_numberSpellerEntered_2107068339();
                return;
            }
            case 300586: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 300671: {
                sMServices.addContext(-2142410760L);
                return;
            }
            case 300672: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 300680: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap1_popupTelephoneOptionsEntered_2107068339();
                return;
            }
        }
    }

    private void ap1_resetFavoriteSearchResult_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.resetFavoriteSearchResult(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "resetFavoriteSearchResult");
        }
    }

    private void ap1_resetSearchResult_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.resetSearchResult(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "resetSearchResult");
        }
    }

    private void ap1_clearNumberSpeller_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.clearNumberSpeller(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "clearNumberSpeller");
        }
    }

    private void ap2_connectivityBlueApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap2;
        try {
            connectivityActionProxy.connectivityBlueApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueApplicationContext");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 300005: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300011: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 300025: {
                sMServices.addContext(-1494997765L);
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300066: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 300075: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300083: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 300096: {
                sMServices.hidePartialPopup(-1617689600);
                return;
            }
            case 300097: {
                sMServices.showPartialPopup(-1600912384);
                return;
            }
            case 300099: {
                sMServices.showPartialPopup(-1617689600);
                return;
            }
            case 300101: {
                sMServices.hidePartialPopup(-1600912384);
                return;
            }
            case 300117: {
                sMServices.showPartialPopup(1049887744);
                return;
            }
            case 300118: {
                sMServices.hidePartialPopup(1049887744);
                sMServices.showPartialPopup(0x40940400);
                return;
            }
            case 300119: {
                sMServices.hidePartialPopup(1049887744);
                sMServices.showPartialPopup(1066664960);
                return;
            }
            case 300124: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 300126: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 300135: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300155: {
                sMServices.showPartialPopup(1100219392);
                return;
            }
            case 300156: {
                sMServices.hidePartialPopup(1100219392);
                sMServices.showPartialPopup(1116996608);
                return;
            }
            case 300157: {
                sMServices.hidePartialPopup(1100219392);
                sMServices.showPartialPopup(1133773824);
                return;
            }
            case 300164: {
                sMServices.showPartialPopup(0x44940400);
                return;
            }
            case 300165: {
                sMServices.hidePartialPopup(0x44940400);
                sMServices.showPartialPopup(1184105472);
                return;
            }
            case 300166: {
                sMServices.hidePartialPopup(0x44940400);
                sMServices.showPartialPopup(1167328256);
                return;
            }
            case 300167: {
                sMServices.hidePartialPopup(0x44940400);
                sMServices.showPartialPopup(1200882688);
                return;
            }
            case 300193: {
                sMServices.showPartialPopup(-1668021248);
                return;
            }
            case 300194: {
                sMServices.hidePartialPopup(-1668021248);
                sMServices.showPartialPopup(-1651244032);
                return;
            }
            case 300195: {
                sMServices.hidePartialPopup(-1668021248);
                sMServices.showPartialPopup(-1634466816);
                return;
            }
            case 300198: {
                sMServices.showPartialPopup(1217659904);
                return;
            }
            case 300199: {
                sMServices.hidePartialPopup(1217659904);
                sMServices.showPartialPopup(0x49940400);
                return;
            }
            case 300200: {
                sMServices.hidePartialPopup(1217659904);
                sMServices.showPartialPopup(1251214336);
                return;
            }
            case 300205: {
                sMServices.showPartialPopup(1267991552);
                return;
            }
            case 300206: {
                sMServices.hidePartialPopup(1267991552);
                sMServices.showPartialPopup(1284768768);
                return;
            }
            case 300207: {
                sMServices.hidePartialPopup(1267991552);
                sMServices.showPartialPopup(1301545984);
                return;
            }
            case 300208: {
                sMServices.hidePartialPopup(1267991552);
                sMServices.showPartialPopup(1318323200);
                return;
            }
            case 300213: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300219: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 300227: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(445973504);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(445973504);
                        return;
                    }
                }
                return;
            }
            case 300231: {
                sMServices.hidePartialPopup(-1131150336);
                sMServices.hidePartialPopup(1016333312);
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.hkBackNetworkSearch(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "hkBackNetworkSearch");
                }
                return;
            }
            case 300232: {
                sMServices.showPartialPopup(-1131150336);
                sMServices.hidePartialPopup(1016333312);
                return;
            }
            case 300233: {
                sMServices.hidePartialPopup(-1131150336);
                sMServices.hidePartialPopup(1016333312);
                return;
            }
            case 300234: {
                sMServices.hidePartialPopup(-1131150336);
                sMServices.showPartialPopup(1016333312);
                return;
            }
            case 300241: {
                sMServices.showPartialPopup(1385432064);
                return;
            }
            case 300242: {
                sMServices.hidePartialPopup(1385432064);
                return;
            }
            case 300243: {
                sMServices.hidePartialPopup(1385432064);
                sMServices.showPartialPopup(1402209280);
                return;
            }
            case 300244: {
                sMServices.hidePartialPopup(1385432064);
                sMServices.showPartialPopup(1418986496);
                return;
            }
            case 300254: {
                sMServices.showPartialPopup(999556096);
                return;
            }
            case 300256: {
                sMServices.hidePartialPopup(999556096);
                return;
            }
            case 300257: {
                sMServices.hidePartialPopup(999556096);
                return;
            }
            case 300258: {
                sMServices.hidePartialPopup(999556096);
                return;
            }
            case 300262: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300280: {
                sMServices.showPartialPopup(1435763712);
                return;
            }
            case 300281: {
                switch (n2) {
                    case 0: {
                        sMServices.hidePartialPopup(1435763712);
                        sMServices.showPartialPopup(1469318144);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1435763712);
                        sMServices.showPartialPopup(1452540928);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(1502872576);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(1486095360);
                        return;
                    }
                }
                return;
            }
            case 300284: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1519649792);
                        return;
                    }
                }
                return;
            }
            case 300285: {
                sMServices.showPartialPopup(1536427008);
                return;
            }
            case 300286: {
                sMServices.hidePartialPopup(1536427008);
                sMServices.showPartialPopup(1553204224);
                return;
            }
            case 300287: {
                sMServices.hidePartialPopup(1536427008);
                sMServices.showPartialPopup(1569981440);
                return;
            }
            case 300308: {
                sMServices.showPartialPopup(1586758656);
                return;
            }
            case 300309: {
                sMServices.hidePartialPopup(1586758656);
                sMServices.showPartialPopup(1603535872);
                return;
            }
            case 300310: {
                sMServices.hidePartialPopup(1620313088);
                sMServices.showPartialPopup(1620313088);
                return;
            }
            case 300312: {
                sMServices.hidePartialPopup(1637090304);
                sMServices.showPartialPopup(1670644736);
                return;
            }
            case 300313: {
                sMServices.showPartialPopup(1637090304);
                return;
            }
            case 300314: {
                sMServices.hidePartialPopup(1637090304);
                sMServices.showPartialPopup(1653867520);
                return;
            }
            case 300317: {
                sMServices.showPartialPopup(1737753600);
                return;
            }
            case 300318: {
                switch (n2) {
                    case 0: {
                        sMServices.hidePartialPopup(1737753600);
                        sMServices.showPartialPopup(1771308032);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1737753600);
                        sMServices.showPartialPopup(1754530816);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1737753600);
                        sMServices.showPartialPopup(1804862464);
                        return;
                    }
                    case 3: {
                        sMServices.hidePartialPopup(1737753600);
                        sMServices.showPartialPopup(1788085248);
                        return;
                    }
                }
                return;
            }
            case 300319: {
                sMServices.showPartialPopup(1687421952);
                return;
            }
            case 300320: {
                sMServices.hidePartialPopup(1687421952);
                sMServices.showPartialPopup(1704199168);
                return;
            }
            case 300321: {
                sMServices.hidePartialPopup(1687421952);
                sMServices.showPartialPopup(1720976384);
                return;
            }
            case 300344: {
                switch (n2) {
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 300346: {
                sMServices.addScreenAnimation(32);
                this.ap1_resetSearchResult_2107068339();
                return;
            }
            case 300348: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                    case 1: {
                        sMServices.addScreenAnimation(32);
                        this.ap1_resetSearchResult_2107068339();
                        return;
                    }
                }
                return;
            }
            case 300349: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 300355: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityBlueApplicationContext(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueApplicationContext");
                }
                return;
            }
            case 300357: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300358: {
                sMServices.hidePartialPopup(949224448);
                return;
            }
            case 300362: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 300363: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 300364: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 300372: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 300377: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300381: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300386: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300391: {
                sMServices.showPartialPopup(1989411840);
                return;
            }
            case 300397: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1972634624);
                        return;
                    }
                }
                return;
            }
            case 300404: {
                sMServices.showPartialPopup(2073297920);
                return;
            }
            case 300408: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2056520704);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(2039743488);
                        return;
                    }
                }
                return;
            }
            case 300412: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300416: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300418: {
                this.ap1_clearNumberSpeller_2107068339();
                return;
            }
            case 300435: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300441: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300444: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.HKTelPressed(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(actionProxy, nullPointerException, "HKTelPressed");
                }
                actionProxy = this.ap2;
                try {
                    actionProxy.connectivityDataHkTelPressed(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(actionProxy, nullPointerException, "connectivityDataHkTelPressed");
                }
                return;
            }
            case 300445: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 300483: {
                SystemCallActionProxy systemCallActionProxy = this.ap4;
                try {
                    systemCallActionProxy.sdsScreenSynced(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSystemCallActionProxy(systemCallActionProxy, nullPointerException, "sdsScreenSynced");
                }
                return;
            }
            case 300490: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300496: {
                sMServices.showPartialPopup(2006189056);
                return;
            }
            case 300497: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300515: {
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300525: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-1466694656);
                        return;
                    }
                }
                return;
            }
            case 300539: {
                sMServices.hidePartialPopup(-1684798464);
                return;
            }
            case 300540: {
                sMServices.showPartialPopup(-1684798464);
                return;
            }
            case 300541: {
                sMServices.hidePartialPopup(-1684798464);
                return;
            }
            case 300542: {
                sMServices.showPartialPopup(865338368);
                return;
            }
            case 300546: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300548: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300560: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 300562: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-1466694656);
                        return;
                    }
                }
                return;
            }
            case 300563: {
                sMServices.hidePartialPopup(2039743488);
                return;
            }
            case 300564: {
                sMServices.hidePartialPopup(2056520704);
                return;
            }
            case 300566: {
                sMServices.hidePartialPopup(2073297920);
                return;
            }
            case 300567: {
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300580: {
                sMServices.hidePartialPopup(2039743488);
                return;
            }
            case 300638: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300643: {
                sMServices.setColor(4);
                return;
            }
            case 300685: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300688: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300713: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300720: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300721: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300722: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 300724: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 300731: {
                return;
            }
            case 300734: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300735: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300748: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.hkBackNetworkRegistration(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "hkBackNetworkRegistration");
                }
                return;
            }
            case 300757: {
                return;
            }
            case 300849: {
                sMServices.hidePartialPopup(1016333312);
                return;
            }
            case 300864: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetFavoriteSearchResult_2107068339();
                return;
            }
            case 300869: {
                sMServices.hidePartialPopup(1418986496);
                return;
            }
            case 300870: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 300873: {
                return;
            }
            case 300878: {
                sMServices.showPartialPopup(462750720);
                return;
            }
            case 300884: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 300888: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 300898: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "dictation", "SMS Dictation");
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                }
                return;
            }
            case 301006: {
                PhoneActionProxy phoneActionProxy = this.ap1;
                try {
                    phoneActionProxy.intellicallReducedViewEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "intellicallReducedViewEntered");
                }
                return;
            }
            case 301016: {
                sMServices.hidePartialPopup(445973504);
                return;
            }
            case 301043: {
                sMServices.showPartialPopup(-1265368064);
                return;
            }
            case 301047: {
                sMServices.hidePartialPopup(949224448);
                return;
            }
            case 301050: {
                sMServices.addScreenAnimation(8);
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 301052: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301054: {
                sMServices.popDrawerIDs();
                return;
            }
            case 301129: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301133: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301136: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301145: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301149: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301152: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301157: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 301161: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(714408960);
                        return;
                    }
                }
                return;
            }
            case 301162: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(714408960);
                        return;
                    }
                }
                return;
            }
            case 301340: {
                this.ap1_clearNumberSpeller_2107068339();
                return;
            }
            case 301359: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(798295040);
                        return;
                    }
                }
                return;
            }
            case 301360: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(798295040);
                        return;
                    }
                }
                return;
            }
            case 301361: {
                return;
            }
            case 301362: {
                return;
            }
            case 301396: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301397: {
                this.ap2_connectivityBlueApplicationContext_725899434();
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301398: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301399: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 301400: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301402: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301403: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 301404: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301405: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301406: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301411: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 301417: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301420: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301421: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 301456: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(798295040);
                        return;
                    }
                }
                return;
            }
            case 301457: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(798295040);
                        return;
                    }
                }
                return;
            }
            case 301463: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301464: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 301468: {
                sMServices.addScreenAnimation(128);
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


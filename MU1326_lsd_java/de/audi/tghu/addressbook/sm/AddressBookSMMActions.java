/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.sm;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.AdrActionProxy;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import java.util.NoSuchElementException;

public class AddressBookSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile AdrActionProxy ap0;
    private volatile ConnectivityActionProxy ap1;
    private volatile NaviActionProxy ap2;
    private volatile OnlineActionProxy ap3;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{26, 0, 11, 10};

    protected AddressBookSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof AdrActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "AdrActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = null;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "NaviActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap1 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof AdrActionProxy) {
            this.ap0 = (AdrActionProxy)actionProxy;
            this.logChannel.log(10000000, "AdrActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = (NaviActionProxy)actionProxy;
            this.logChannel.log(10000000, "NaviActionProxy Action Proxy added");
            return this.ap2;
        }
        return null;
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionAdrActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'AdrActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'AdrActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionNaviActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'NaviActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'NaviActionProxy' missing for call '%1'", (Object)string);
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

    private void ap1_connectivityDataOnlineAppLeft_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap1;
        try {
            connectivityActionProxy.connectivityDataOnlineAppLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppLeft");
        }
    }

    private void ap0_adrExitPreviewMapScreen_2107068339() {
        AdrActionProxy adrActionProxy = this.ap0;
        try {
            adrActionProxy.adrExitPreviewMapScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionAdrActionProxy(adrActionProxy, nullPointerException, "adrExitPreviewMapScreen");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 700000: {
                AdrActionProxy adrActionProxy = this.ap0;
                try {
                    adrActionProxy.adrState(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionAdrActionProxy(adrActionProxy, nullPointerException, "adrState");
                }
                return;
            }
            case 700011: {
                this.ap1_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 700012: {
                this.ap0_adrExitPreviewMapScreen_2107068339();
                return;
            }
            case 700013: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(-1766199732L);
                sMServices.setScreenMode(1);
                this.ap0_adrExitPreviewMapScreen_2107068339();
                return;
            }
            case 700042: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 700043: {
                sMServices.setScreenMode(1);
                sMServices.popDrawerIDs();
                return;
            }
            case 700072: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(-1766199732L);
                this.ap0_adrExitPreviewMapScreen_2107068339();
                return;
            }
            case 700075: {
                sMServices.popDrawerIDs();
                return;
            }
            case 700090: {
                if (((ChoiceModel)this.getModel(8)).getValue() == 4) {
                    sMServices.addContext(-399568537L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#8) Value == ICoreSysConfig.APPLICATION_ID_PHONE' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(8)).getValue() == 5) {
                    sMServices.addContext(-690834900L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#8) Value == ICoreSysConfig.APPLICATION_ID_NAVI' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 700092: {
                sMServices.popDrawerIDs();
                return;
            }
            case 700094: {
                sMServices.popDrawerIDs();
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiExit");
                }
                sMServices.setScreenMode(1);
                sMServices.removeContext(-390699210L);
                sMServices.removeContext(1103448890L);
                return;
            }
            case 700105: {
                sMServices.removeContext(-427027396L);
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.myAudiAuthScreenType(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthScreenType");
                }
                return;
            }
            case 700113: {
                this.ap1_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 700119: {
                sMServices.setScreenMode(1);
                return;
            }
            case 700125: {
                sMServices.popDrawerIDs();
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

    private void ap0_adrEnterPreviewMapScreen__388087338() {
        AdrActionProxy adrActionProxy = this.ap0;
        try {
            adrActionProxy.adrEnterPreviewMapScreen(this.smm.getTerminalID(), 277, 324);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionAdrActionProxy(adrActionProxy, nullPointerException, "adrEnterPreviewMapScreen");
        }
    }

    private void ap2_setNavAddressFormContext_725899438() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 5);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 700000: {
                AdrActionProxy adrActionProxy = this.ap0;
                try {
                    adrActionProxy.adrState(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionAdrActionProxy(adrActionProxy, nullPointerException, "adrState");
                }
                return;
            }
            case 700012: {
                this.ap0_adrEnterPreviewMapScreen__388087338();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 700013: {
                sMServices.pushDrawerIDs(0L, 700020L);
                sMServices.addContext(-1766199732L);
                this.ap0_adrEnterPreviewMapScreen__388087338();
                this.ap2_setNavAddressFormContext_725899438();
                sMServices.setScreenMode(2);
                return;
            }
            case 700018: {
                sMServices.setColor(4);
                return;
            }
            case 700024: {
                sMServices.setColor(3);
                return;
            }
            case 700026: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 700042: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 700043: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 700047: {
                sMServices.setColor(3);
                return;
            }
            case 700072: {
                sMServices.pushDrawerIDs(0L, 700020L);
                sMServices.addContext(-1766199732L);
                this.ap0_adrEnterPreviewMapScreen__388087338();
                return;
            }
            case 700075: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 700087: {
                sMServices.setColor(4);
                return;
            }
            case 700090: {
                if (((ChoiceModel)this.getModel(8)).getValue() == 4) {
                    sMServices.removeContext(-399568537L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#8) Value == ICoreSysConfig.APPLICATION_ID_PHONE' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(8)).getValue() == 5) {
                    sMServices.removeContext(-690834900L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#8) Value == ICoreSysConfig.APPLICATION_ID_NAVI' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 700091: {
                this.ap2_setNavAddressFormContext_725899439();
                return;
            }
            case 700092: {
                this.ap2_setNavAddressFormContext_725899438();
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 700093: {
                this.ap2_setNavAddressFormContext_725899439();
                return;
            }
            case 700094: {
                if (((ChoiceModel)this.getModel(2300989)).getValue() == 0) {
                    sMServices.pushDrawerIDs(2300001L, 2300002L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2300989) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() != 0) {
                    sMServices.pushDrawerIDs(0L, 2300057L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ChoiceModel (MODELID#2300989) Value == 0 )' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() == 0) {
                    sMServices.setScreenMode(1);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2300989) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() != 0) {
                    sMServices.setScreenMode(2);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ChoiceModel (MODELID#2300989) Value == 0 )' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() == 0) {
                    sMServices.addContext(-390699210L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2300989) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() == 1) {
                    sMServices.addContext(1103448890L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2300989) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 700105: {
                sMServices.addContext(-427027396L);
                this.ap3_myAudiAuthScreenType_725899434();
                return;
            }
            case 700113: {
                ActionProxy actionProxy = this.ap3;
                try {
                    actionProxy.remoteHmiEnter(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "remoteHmiEnter");
                }
                actionProxy = this.ap1;
                try {
                    actionProxy.connectivityDataOnlineAppEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(actionProxy, nullPointerException, "connectivityDataOnlineAppEntered");
                }
                return;
            }
            case 700119: {
                sMServices.setScreenMode(2);
                return;
            }
            case 700125: {
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
        }
    }

    private void ap2_setNavAddressFormContext_725899439() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 6);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
        }
    }

    private void ap3_myAudiAuthScreenType_725899434() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.myAudiAuthScreenType(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthScreenType");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 700004: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700010: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700012: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700013: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(700055);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(700035);
                        return;
                    }
                }
                return;
            }
            case 700014: {
                sMServices.showPartialPopup(700042);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700029: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(700036);
                        return;
                    }
                }
                return;
            }
            case 700034: {
                sMServices.hidePartialPopup(700042);
                return;
            }
            case 700035: {
                sMServices.hidePartialPopup(700042);
                sMServices.showPartialPopup(700043);
                return;
            }
            case 700041: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700042: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700047: {
                sMServices.addScreenAnimation(8);
                this.ap2_setNavAddressFormContext_725899439();
                return;
            }
            case 700048: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700050: {
                switch (n2) {
                    case 1: {
                        sMServices.addScreenAnimation(128);
                        return;
                    }
                }
                return;
            }
            case 700054: {
                sMServices.showPartialPopup(700034);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700055: {
                sMServices.showPartialPopup(700034);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700065: {
                sMServices.showPartialPopup(700015);
                return;
            }
            case 700066: {
                switch (n2) {
                    case 0: {
                        sMServices.hidePartialPopup(700015);
                        return;
                    }
                }
                return;
            }
            case 700067: {
                switch (n2) {
                    case 0: {
                        sMServices.hidePartialPopup(700015);
                        return;
                    }
                }
                return;
            }
            case 700068: {
                switch (n2) {
                    case 0: {
                        sMServices.hidePartialPopup(700015);
                        return;
                    }
                }
                return;
            }
            case 700089: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(700052);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(700017);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(700017);
                        return;
                    }
                }
                return;
            }
            case 700090: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(700055);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(700035);
                        return;
                    }
                }
                return;
            }
            case 700094: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 700098: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700099: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700100: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700103: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700104: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700112: {
                return;
            }
            case 700128: {
                AdrActionProxy adrActionProxy = this.ap0;
                try {
                    adrActionProxy.adrImportListHKReturn(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionAdrActionProxy(adrActionProxy, nullPointerException, "adrImportListHKReturn");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 700132: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700133: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700134: {
                sMServices.removeContext(-399568537L);
                return;
            }
            case 700143: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700144: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700145: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
                }
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700149: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiClosedViaOptionDrawer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiClosedViaOptionDrawer");
                }
                return;
            }
            case 700153: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 700155: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700156: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700157: {
                sMServices.showPartialPopup(700056);
                return;
            }
            case 700162: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700163: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700164: {
                sMServices.showPartialPopup(700056);
                return;
            }
            case 700171: {
                return;
            }
            case 700172: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 700198: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700205: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700206: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700207: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700208: {
                sMServices.showPartialPopup(700034);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700209: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700210: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700211: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700212: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700213: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700214: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700215: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(700055);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(700035);
                        return;
                    }
                }
                return;
            }
            case 700217: {
                sMServices.showPartialPopup(700056);
                return;
            }
            case 700227: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700229: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700231: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700234: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700236: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700241: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700242: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700245: {
                return;
            }
            case 700246: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700248: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700251: {
                return;
            }
            case 700266: {
                return;
            }
            case 700290: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700291: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700301: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700302: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700308: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiMarkForTopLevel(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMarkForTopLevel");
                }
                onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.myAudiAuthContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthContext");
                }
                this.ap3_myAudiAuthScreenType_725899434();
                return;
            }
            case 700332: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700342: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700343: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 700345: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700351: {
                sMServices.hidePartialPopup(700052);
                return;
            }
            case 700367: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700371: {
                return;
            }
            case 700382: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700388: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 700390: {
                sMServices.hidePartialPopup(700056);
                sMServices.hidePartialPopup(400194);
                sMServices.hidePartialPopup(400230);
                return;
            }
            case 700391: {
                sMServices.addScreenAnimation(128);
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}


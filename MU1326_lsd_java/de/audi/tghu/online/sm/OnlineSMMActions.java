/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.sm;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import java.util.NoSuchElementException;

public class OnlineSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile OnlineActionProxy ap0;
    private volatile EntertainmentActionProxy ap1;
    private volatile NaviActionProxy ap2;
    private volatile ConnectivityActionProxy ap3;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 26, 10, 11};

    protected OnlineSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap3 = null;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "NaviActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap3 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(10000000, "ConnectivityActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = (NaviActionProxy)actionProxy;
            this.logChannel.log(10000000, "NaviActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap0 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy added");
            return this.ap0;
        }
        return null;
    }

    private void catchActionExceptionEntertainmentActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EntertainmentActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'EntertainmentActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionNaviActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'NaviActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'NaviActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
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

    private void ap1_entertainmentBlacklist_1028045899() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap1;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), -1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap2_exitPreviewMapScreen_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.exitPreviewMapScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitPreviewMapScreen");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 2300007: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiBrowserLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiBrowserLeft");
                }
                return;
            }
            case 2300018: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300020: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(-390699210L);
                return;
            }
            case 2300024: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.rhmiAuthenticationFinished(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "rhmiAuthenticationFinished");
                }
                return;
            }
            case 2300046: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300051: {
                sMServices.removeContext(-390699210L);
                sMServices.removeContext(1103448890L);
                return;
            }
            case 2300053: {
                sMServices.removeContext(-390699210L);
                sMServices.removeContext(1103448890L);
                return;
            }
            case 2300073: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300075: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300077: {
                this.ap1_entertainmentBlacklist_1028045899();
                return;
            }
            case 2300078: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiListExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiListExit");
                }
                return;
            }
            case 2300079: {
                sMServices.popDrawerIDs();
                if (((ChoiceModel)this.getModel(2300989)).getValue() != 0) {
                    sMServices.addScreenAnimation(8);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ChoiceModel (MODELID#2300989) Value == 0 )' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300080: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiHkReturnFromInclude(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiHkReturnFromInclude");
                }
                return;
            }
            case 2300081: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitMapScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitMapScreen");
                }
                return;
            }
            case 2300092: {
                this.ap3_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 2300114: {
                this.ap1_entertainmentBlacklist_1028045899();
                return;
            }
            case 2300115: {
                sMServices.popDrawerIDs();
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
                }
                sMServices.removeContext(1832057120L);
                return;
            }
            case 2300128: {
                sMServices.setScreenMode(1);
                this.ap0_remoteHmiHkReturnFromInclude_725899434();
                return;
            }
            case 2300130: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300140: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300141: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 2300142: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300152: {
                this.ap0_remoteHmiExit_2107068339();
                return;
            }
            case 2300154: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                sMServices.removeContext(1103448890L);
                return;
            }
            case 2300160: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 2300164: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.operatorEndMsgLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorEndMsgLeft");
                }
                return;
            }
            case 2300169: {
                this.ap2_exitPreviewMapScreen_2107068339();
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.operatorCallResultListLeft(this.smm.getTerminalID(), ((ChoiceModel)this.getModel(5535)).getValue());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorCallResultListLeft");
                }
                return;
            }
            case 2300175: {
                sMServices.removeContext(1143844270L);
                sMServices.removeContext(559392987L);
                if (((ChoiceModel)this.getModel(4370)).getStatus() == 1) {
                    OnlineActionProxy onlineActionProxy = this.ap0;
                    try {
                        onlineActionProxy.operatorCallCenterLeft(this.smm.getTerminalID());
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorCallCenterLeft");
                    }
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#4370) Status == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300177: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300181: {
                this.ap3_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 2300184: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300189: {
                this.ap3_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 2300190: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300191: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300195: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
                }
                return;
            }
            case 2300208: {
                this.ap0_remoteHmiSetEntryPoint_725899434();
                return;
            }
            case 2300238: {
                sMServices.popDrawerIDs();
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.connGatewayLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "connGatewayLeft");
                }
                return;
            }
            case 2300253: {
                sMServices.removeContext(1018057960L);
                sMServices.removeContext(471191366L);
                return;
            }
            case 2300261: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 2300263: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300265: {
                sMServices.popDrawerIDs();
                this.ap0_remoteHmiExit_2107068339();
                sMServices.removeContext(1103448890L);
                return;
            }
            case 2300276: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(-390699210L);
                return;
            }
            case 2300278: {
                if (((ChoiceModel)this.getModel(2301200)).getValue() == 0) {
                    sMServices.setScreenMode(1);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301200) Value == 0' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300280: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    NaviActionProxy naviActionProxy = this.ap2;
                    try {
                        naviActionProxy.exitOperatorCallMapScreen(this.smm.getTerminalID());
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitOperatorCallMapScreen");
                    }
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                sMServices.popDrawerIDs();
                return;
            }
            case 2300289: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.licenseOverviewExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseOverviewExited");
                }
                return;
            }
            case 2300296: {
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
                return;
            }
            case 2300315: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2300330: {
                ConnectivityActionProxy connectivityActionProxy = this.ap3;
                try {
                    connectivityActionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataApplicationContext");
                }
                return;
            }
            case 2300337: {
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

    private void ap0_remoteHmiToggleInclude_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiToggleInclude(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiToggleInclude");
        }
    }

    private void ap3_connectivityDataOnlineAppEntered_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap3;
        try {
            connectivityActionProxy.connectivityDataOnlineAppEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppEntered");
        }
    }

    private void ap3_connectivityCoMaApplicationContext_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap3;
        try {
            connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
        }
    }

    private void ap0_remoteHmiSetEntryPoint_725899434() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
        }
    }

    private void ap2_enterPreviewMapScreen_109716467() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterPreviewMapScreen(this.smm.getTerminalID(), 0, 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPreviewMapScreen");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 2300001: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiLayoutConstants(this.smm.getTerminalID(), 290, 245, 25);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiLayoutConstants");
                }
                return;
            }
            case 2300007: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiBrowserEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiBrowserEntered");
                }
                if (((ChoiceModel)this.getModel(2300989)).getValue() != 0) {
                    sMServices.addScreenAnimation(8);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ChoiceModel (MODELID#2300989) Value == 0 )' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300017: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 2300018: {
                if (((ChoiceModel)this.getModel(2300989)).getValue() != 0) {
                    sMServices.addScreenAnimation(8);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ChoiceModel (MODELID#2300989) Value == 0 )' is not fullfilled, Action is not executed.");
                }
                sMServices.pushDrawerIDs(-1L, 0L);
                return;
            }
            case 2300020: {
                if (((ChoiceModel)this.getModel(2301257)).getValue() == 0) {
                    sMServices.pushDrawerIDs(2300001L, 2300002L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301257) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2301257)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 2300002L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301257) Value == 1' is not fullfilled, Action is not executed.");
                }
                sMServices.setScreenMode(1);
                sMServices.addContext(-390699210L);
                this.ap0_remoteHmiToggleInclude_2107068339();
                return;
            }
            case 2300024: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHMIAuthenticationInit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHMIAuthenticationInit");
                }
                return;
            }
            case 2300046: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 2300002L);
                return;
            }
            case 2300051: {
                if (((ChoiceModel)this.getModel(2301200)).getValue() == 0) {
                    sMServices.addContext(-390699210L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301200) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2301200)).getValue() == 1) {
                    sMServices.addContext(1103448890L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301200) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300053: {
                if (((ChoiceModel)this.getModel(2301200)).getValue() == 0) {
                    sMServices.addContext(-390699210L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301200) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2301200)).getValue() == 1) {
                    sMServices.addContext(1103448890L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301200) Value == 1' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300069: {
                sMServices.setColor(3);
                return;
            }
            case 2300071: {
                sMServices.setColor(3);
                return;
            }
            case 2300073: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 2300002L);
                return;
            }
            case 2300075: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300077: {
                if (((ChoiceModel)this.getModel(2301528)).getValue() == 0) {
                    EntertainmentActionProxy entertainmentActionProxy = this.ap1;
                    try {
                        entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 7001);
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
                    }
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301528) Value == 0' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300078: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiListEnter(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiListEnter");
                }
                return;
            }
            case 2300079: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300080: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiEnterInclude(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiEnterInclude");
                }
                return;
            }
            case 2300081: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.enterRemoteHMIResultMap(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "enterRemoteHMIResultMap");
                }
                return;
            }
            case 2300092: {
                this.ap3_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 2300100: {
                sMServices.setScreenMode(1);
                return;
            }
            case 2300114: {
                this.ap1_entertainmentBlacklist_109929345();
                return;
            }
            case 2300115: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.startOperatorCall(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "startOperatorCall");
                }
                sMServices.pushDrawerIDs(0L, 2300145L);
                sMServices.addContext(1832057120L);
                return;
            }
            case 2300128: {
                sMServices.addScreenAnimation(8);
                sMServices.setScreenMode(2);
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.remoteHmiEnterInclude(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "remoteHmiEnterInclude");
                }
                actionProxy = this.ap3;
                try {
                    actionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 10, 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(actionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                this.ap3_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 2300130: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300140: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300141: {
                sMServices.pushDrawerIDs(0L, 2300057L);
                return;
            }
            case 2300142: {
                sMServices.pushDrawerIDs(0L, 2300002L);
                return;
            }
            case 2300152: {
                this.ap0_remoteHmiSetEntryPoint_725899434();
                return;
            }
            case 2300154: {
                sMServices.pushDrawerIDs(0L, 2300057L);
                if (((ChoiceModel)this.getModel(2300070)).getStatus() != 6000) {
                    sMServices.setScreenMode(2);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '( !( ChoiceModel (MODELID#2300070) Status == 6000 ) )' is not fullfilled, Action is not executed.");
                }
                sMServices.addContext(1103448890L);
                return;
            }
            case 2300160: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 2300169: {
                this.ap2_enterPreviewMapScreen_109716467();
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.operatorCallResultListEntered(this.smm.getTerminalID(), ((ChoiceModel)this.getModel(5535)).getValue());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorCallResultListEntered");
                }
                return;
            }
            case 2300175: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    sMServices.addContext(1143844270L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(5535)).getValue() == 2) {
                    sMServices.addContext(559392987L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 2' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300177: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300181: {
                this.ap3_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 2300184: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 2300185: {
                ConnectivityActionProxy connectivityActionProxy = this.ap3;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 17, 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                return;
            }
            case 2300189: {
                this.ap3_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 2300190: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300191: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300202: {
                this.ap0_remoteHmiEnter_725899433();
                return;
            }
            case 2300238: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 2300253: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    sMServices.addContext(1018057960L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(5535)).getValue() == 2) {
                    sMServices.addContext(471191366L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 2' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300261: {
                sMServices.pushDrawerIDs(0L, 69L);
                sMServices.setScreenMode(2);
                return;
            }
            case 2300263: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300265: {
                sMServices.pushDrawerIDs(0L, 2300057L);
                sMServices.addContext(1103448890L);
                return;
            }
            case 2300276: {
                if (((ChoiceModel)this.getModel(2301257)).getValue() == 0) {
                    sMServices.pushDrawerIDs(2300001L, 2300002L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301257) Value == 0' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2301257)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 2300002L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#2301257) Value == 1' is not fullfilled, Action is not executed.");
                }
                sMServices.setScreenMode(1);
                sMServices.addContext(-390699210L);
                this.ap0_remoteHmiToggleInclude_2107068339();
                return;
            }
            case 2300278: {
                if (((ChoiceModel)this.getModel(2301379)).getValue() == 1) {
                    sMServices.setScreenMode(2);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '( ChoiceModel (MODELID#2301379) Value == 1 )' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300280: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    NaviActionProxy naviActionProxy = this.ap2;
                    try {
                        naviActionProxy.enterOperatorCallMapScreen(this.smm.getTerminalID());
                    }
                    catch (NullPointerException nullPointerException) {
                        this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterOperatorCallMapScreen");
                    }
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2300287: {
                this.ap3_connectivityCoMaApplicationContext_725899434();
                return;
            }
            case 2300289: {
                sMServices.pushDrawerIDs(0L, 0L);
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.licenseOverviewEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseOverviewEntered");
                }
                return;
            }
            case 2300296: {
                sMServices.setScreenMode(2);
                return;
            }
            case 2300301: {
                sMServices.setColor(3);
                return;
            }
            case 2300315: {
                if (((ChoiceModel)this.getModel(2301077)).getValue() != 1 || ((ChoiceModel)this.getModel(2301257)).getValue() != 1) {
                    sMServices.pushDrawerIDs(0L, 0L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '!( ( ChoiceModel (MODELID#2301077) Value == 1 ) && ( ChoiceModel (MODELID#2301257) Value == 1 ) )' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(2301077)).getValue() == 1 && ((ChoiceModel)this.getModel(2301257)).getValue() == 1) {
                    sMServices.pushDrawerIDs(200087L, 0L);
                } else {
                    this.logChannel.log(1000000, "Action-Condition '( ChoiceModel (MODELID#2301077) Value == 1 ) && ( ChoiceModel (MODELID#2301257) Value == 1 )' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300321: {
                sMServices.setColor(3);
                return;
            }
            case 2300327: {
                sMServices.setScreenMode(1);
                return;
            }
            case 2300330: {
                sMServices.pushDrawerIDs(0L, 0L);
                ConnectivityActionProxy connectivityActionProxy = this.ap3;
                try {
                    connectivityActionProxy.connectivityDataApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataApplicationContext");
                }
                sMServices.setScreenMode(1);
                return;
            }
            case 2300337: {
                sMServices.addScreenAnimation(8);
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0L);
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.changePrivacySettingsScreenMode(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "changePrivacySettingsScreenMode");
                }
                return;
            }
            case 2300354: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.requestMobileDeviceKeyCount(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "requestMobileDeviceKeyCount");
                }
                return;
            }
            case 2300366: {
                sMServices.setColor(3);
                return;
            }
            case 2300368: {
                sMServices.setColor(3);
                return;
            }
        }
    }

    private void ap1_entertainmentBlacklist_109929345() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap1;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 7001);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    private void ap0_remoteHmiLogOff_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiLogOff(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiLogOff");
        }
    }

    private void ap0_trafficLightEntered_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.trafficLightEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "trafficLightEntered");
        }
    }

    private void ap0_remoteHmiHkReturnFromInclude_725899434() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiHkReturnFromInclude(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiHkReturnFromInclude");
        }
    }

    private void ap0_remoteHmiMarkForTopLevel_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiMarkForTopLevel(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMarkForTopLevel");
        }
    }

    private void ap0_myAudiAuthContext_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.myAudiAuthContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthContext");
        }
    }

    private void ap0_operatorCallChecksSuccessful_347802294() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.operatorCallChecksSuccessful(this.smm.getTerminalID(), ((ChoiceModel)this.getModel(5535)).getValue());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorCallChecksSuccessful");
        }
    }

    private void ap0_remoteHmiEnter_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiEnter(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiEnter");
        }
    }

    private void ap3_connectivityDataOnlineAppLeft_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap3;
        try {
            connectivityActionProxy.connectivityDataOnlineAppLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppLeft");
        }
    }

    private void ap0_remoteHmiExit_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap0;
        try {
            onlineActionProxy.remoteHmiExit(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiExit");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 2300001: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2300023: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiPrepare(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiPrepare");
                }
                return;
            }
            case 2300031: {
                switch (n2) {
                    case 4: {
                        sMServices.addScreenAnimation(8);
                        return;
                    }
                    case 10: {
                        sMServices.addScreenAnimation(8);
                        return;
                    }
                    case 11: {
                        sMServices.addScreenAnimation(8);
                        return;
                    }
                    case 12: {
                        this.ap1_entertainmentBlacklist_109929345();
                        return;
                    }
                }
                return;
            }
            case 2300032: {
                switch (n2) {
                    case 0: {
                        this.ap0_remoteHmiLogOff_2107068339();
                        sMServices.setScreenMode(2);
                        return;
                    }
                    case 6: {
                        this.ap0_trafficLightEntered_2107068339();
                        return;
                    }
                }
                return;
            }
            case 2300041: {
                switch (n2) {
                    case 6: {
                        sMServices.showPartialPopup(2300044);
                        return;
                    }
                }
                return;
            }
            case 2300045: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300046: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.destOnlineStartDestinationImport(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "destOnlineStartDestinationImport");
                }
                return;
            }
            case 2300051: {
                sMServices.addScreenAnimation(8);
                sMServices.setScreenMode(2);
                return;
            }
            case 2300064: {
                switch (n2) {
                    case 0: {
                        OnlineActionProxy onlineActionProxy = this.ap0;
                        try {
                            onlineActionProxy.remoteHMIStartKnownLogin(this.smm.getTerminalID());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHMIStartKnownLogin");
                        }
                        return;
                    }
                }
                return;
            }
            case 2300067: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300069: {
                this.ap0_remoteHmiHkReturnFromInclude_725899434();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300071: {
                return;
            }
            case 2300111: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiMapExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMapExit");
                }
                return;
            }
            case 2300113: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHMINavDestFormExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHMINavDestFormExit");
                }
                return;
            }
            case 2300127: {
                sMServices.setScreenMode(1);
                return;
            }
            case 2300139: {
                this.ap0_remoteHmiMarkForTopLevel_725899433();
                return;
            }
            case 2300193: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "breakdowncall", "Breadkdown Call");
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                }
                return;
            }
            case 2300200: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2300078);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(2300077);
                        return;
                    }
                }
                return;
            }
            case 2300201: {
                sMServices.hidePartialPopup(2300077);
                return;
            }
            case 2300213: {
                sMServices.setScreenMode(2);
                this.ap0_remoteHmiMarkForTopLevel_725899433();
                this.ap0_myAudiAuthContext_725899433();
                return;
            }
            case 2300215: {
                sMServices.setScreenMode(1);
                this.ap0_remoteHmiMarkForTopLevel_725899433();
                this.ap0_myAudiAuthContext_725899433();
                return;
            }
            case 2300240: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiHkReturnFromSelectionDrawer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiHkReturnFromSelectionDrawer");
                }
                return;
            }
            case 2300266: {
                switch (n2) {
                    case 0: {
                        OnlineActionProxy onlineActionProxy = this.ap0;
                        try {
                            onlineActionProxy.operatorCallCallActiveShown(this.smm.getTerminalID(), ((ChoiceModel)this.getModel(5535)).getValue());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorCallCallActiveShown");
                        }
                        return;
                    }
                }
                return;
            }
            case 2300268: {
                this.ap0_operatorCallChecksSuccessful_347802294();
                return;
            }
            case 2300296: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.authenticationLogoutFinished(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "authenticationLogoutFinished");
                }
                sMServices.showPartialPopup(2300063);
                return;
            }
            case 2300298: {
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
            case 2300320: {
                switch (n2) {
                    case 0: {
                        return;
                    }
                }
                return;
            }
            case 2300322: {
                switch (n2) {
                    case 0: {
                        return;
                    }
                }
                return;
            }
            case 2300340: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2300359: {
                switch (n2) {
                    case 1: {
                        OnlineActionProxy onlineActionProxy = this.ap0;
                        try {
                            onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "poicall", "Poi Call");
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 2300361: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiOverrideNextAnimation(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiOverrideNextAnimation");
                }
                return;
            }
            case 2300375: {
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
            case 2300426: {
                this.ap0_operatorCallChecksSuccessful_347802294();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 2300435: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300436: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300438: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300453: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300455: {
                if (((ChoiceModel)this.getModel(5535)).getValue() == 1) {
                    sMServices.showPartialPopup(2300146);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(5535)).getValue() == 2) {
                    sMServices.showPartialPopup(2300110);
                } else {
                    this.logChannel.log(1000000, "Action-Condition 'ChoiceModel (MODELID#5535) Value == 2' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 2300461: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300462: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.operatorUpdateDetailInfo(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "operatorUpdateDetailInfo");
                }
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300468: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiClosedViaOptionDrawer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiClosedViaOptionDrawer");
                }
                return;
            }
            case 2300475: {
                this.ap0_remoteHmiEnter_725899433();
                return;
            }
            case 2300482: {
                OnlineActionProxy onlineActionProxy = this.ap0;
                try {
                    onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
                }
                return;
            }
            case 2300513: {
                return;
            }
            case 2300514: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300520: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300530: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2300532: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300545: {
                switch (n2) {
                    case 0: {
                        this.ap0_remoteHmiLogOff_2107068339();
                        sMServices.setScreenMode(2);
                        return;
                    }
                    case 6: {
                        this.ap0_trafficLightEntered_2107068339();
                        return;
                    }
                }
                return;
            }
            case 2300579: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2300625: {
                switch (n2) {
                    case 0: {
                        this.ap3_connectivityDataOnlineAppLeft_2107068339();
                        this.ap0_remoteHmiExit_2107068339();
                        return;
                    }
                }
                return;
            }
            case 2300678: {
                switch (n2) {
                    case 1: {
                        return;
                    }
                }
                return;
            }
            case 2300679: {
                switch (n2) {
                    case 1: {
                        return;
                    }
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}


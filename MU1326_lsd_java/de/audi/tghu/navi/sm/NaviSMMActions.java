/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.sm;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.atip.statemachine.ap.EcallActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.InfoActionProxy;
import de.audi.atip.statemachine.ap.MMICombiActionProxy;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.TopLevelScreenActionProxy;
import de.audi.atip.statemachine.ap.TrafficInfoJPActionProxy;

public class NaviSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile FrameworkActionProxy ap0;
    private volatile MMICombiActionProxy ap1;
    private volatile NaviActionProxy ap2;
    private volatile OnlineActionProxy ap3;
    private volatile TopLevelScreenActionProxy ap4;
    private volatile EcallActionProxy ap5;
    private volatile ConnectivityActionProxy ap6;
    private volatile InfoActionProxy ap7;
    private volatile TrafficInfoJPActionProxy ap8;
    private volatile CustDownloadActionProxy ap9;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{5, 22, 30, 4, 26, 11, 10, 23, 29, 27};

    protected NaviSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof InfoActionProxy) {
            this.ap7 = null;
            this.logChannel.log(-2137614336, "InfoActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap9 = null;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap5 = null;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap6 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = null;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TrafficInfoJPActionProxy) {
            this.ap8 = null;
            this.logChannel.log(-2137614336, "TrafficInfoJPActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap4 = null;
            this.logChannel.log(-2137614336, "TopLevelScreenActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof InfoActionProxy) {
            this.ap7 = (InfoActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "InfoActionProxy Action Proxy added");
            return this.ap7;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap9 = (CustDownloadActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy added");
            return this.ap9;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap5 = (EcallActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy added");
            return this.ap5;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap0 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap6 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap6;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap3 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof NaviActionProxy) {
            this.ap2 = (NaviActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "NaviActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap1 = (MMICombiActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof TrafficInfoJPActionProxy) {
            this.ap8 = (TrafficInfoJPActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TrafficInfoJPActionProxy Action Proxy added");
            return this.ap8;
        }
        if (actionProxy instanceof TopLevelScreenActionProxy) {
            this.ap4 = (TopLevelScreenActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TopLevelScreenActionProxy Action Proxy added");
            return this.ap4;
        }
        return null;
    }

    private void catchActionExceptionInfoActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'InfoActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'InfoActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionCustDownloadActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CustDownloadActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'CustDownloadActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionEcallActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EcallActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EcallActionProxy' missing for call '%1'", (Object)string);
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

    private void catchActionExceptionMMICombiActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'MMICombiActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'MMICombiActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTrafficInfoJPActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TrafficInfoJPActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TrafficInfoJPActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTopLevelScreenActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TopLevelScreenActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TopLevelScreenActionProxy' missing for call '%1'", (Object)string);
    }

    private void ap3_remoteHmiEnterInMap_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiEnterInMap(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiEnterInMap");
        }
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            case 400697: {
                this.ap3_remoteHmiEnterInMap_2107068339();
                return;
            }
            case 400698: {
                this.ap3_remoteHmiEnterInMap_2107068339();
                return;
            }
            case 400792: {
                this.ap3_remoteHmiEnterInMap_2107068339();
                return;
            }
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            case 400697: {
                this.ap3_remoteHmiExit_2107068339();
                return;
            }
            case 400698: {
                this.ap3_remoteHmiExit_2107068339();
                return;
            }
            case 400792: {
                this.ap3_remoteHmiExit_2107068339();
                return;
            }
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

    private void ap3_remoteHmiExit_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiExit(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiExit");
        }
    }

    private void ap5_sysInitConnectLeft_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap5;
        try {
            ecallActionProxy.sysInitConnectLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "sysInitConnectLeft");
        }
    }

    private void ap2_setSpellerScreenInactive_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setSpellerScreenInactive(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setSpellerScreenInactive");
        }
    }

    private void ap2_exitMapMainScreen_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.exitMapMainScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitMapMainScreen");
        }
    }

    private void ap2_exitPoiWarning_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.exitPoiWarning(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitPoiWarning");
        }
    }

    private void ap6_connectivityDataOnlineAppLeft_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap6;
        try {
            connectivityActionProxy.connectivityDataOnlineAppLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppLeft");
        }
    }

    private void ap6_connectivityOpenSelectionDrawerByHKReturn_725899433() {
        ConnectivityActionProxy connectivityActionProxy = this.ap6;
        try {
            connectivityActionProxy.connectivityOpenSelectionDrawerByHKReturn(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityOpenSelectionDrawerByHKReturn");
        }
    }

    private void ap3_leaveCallcenterCall_725899435() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.leaveCallcenterCall(this.smm.getTerminalID(), 2);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "leaveCallcenterCall");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 400022: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400023: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400024: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.navigationLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navigationLeft");
                }
                return;
            }
            case 400025: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400026: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400027: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400028: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitNavDestForm(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitNavDestForm");
                }
                return;
            }
            case 400031: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400033: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400035: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400038: {
                sMServices.removeContext(-2066650800L);
                return;
            }
            case 400040: {
                sMServices.removeContext(-690834900L);
                return;
            }
            case 400041: {
                sMServices.removeContext(-1024090492L);
                return;
            }
            case 400043: {
                sMServices.removeContext(-1647038573L);
                return;
            }
            case 400044: {
                sMServices.removeContext(-101863888L);
                return;
            }
            case 400045: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDestIntellidest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDestIntellidest");
                }
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400046: {
                sMServices.removeContext(-427027396L);
                return;
            }
            case 400049: {
                sMServices.removeContext(0);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitPoiInput(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitPoiInput");
                }
                return;
            }
            case 400055: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 400058: {
                sMServices.removeContext(0);
                return;
            }
            case 400059: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 400064: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400066: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400072: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                return;
            }
            case 400076: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400078: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400081: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400084: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400085: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitPoiMainScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitPoiMainScreen");
                }
                return;
            }
            case 400087: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                return;
            }
            case 400097: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitTrufflesRangeSelect(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitTrufflesRangeSelect");
                }
                return;
            }
            case 400116: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                return;
            }
            case 400121: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400142: {
                sMServices.removeContext(-1310425789L);
                return;
            }
            case 400150: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400152: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400166: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400168: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400173: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDestOptMethods(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDestOptMethods");
                }
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400175: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400178: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400180: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400207: {
                this.ap2_setNavigationInputMode_725899433();
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 400211: {
                this.ap2_setNavigationInputMode_725899433();
                return;
            }
            case 400222: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDemoModeStartPosIntellidest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDemoModeStartPosIntellidest");
                }
                return;
            }
            case 400224: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitNaviGeneralSettings(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitNaviGeneralSettings");
                }
                return;
            }
            case 400225: {
                sMServices.popDrawerIDs();
                this.ap3_remoteHmiExit_2107068339();
                sMServices.removeContext(0);
                this.ap0_activeApplication_1501447227();
                this.ap5_sysInitConnectLeft_2107068339();
                this.ap0_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 400226: {
                this.ap3_remoteHmiExit_2107068339();
                return;
            }
            case 400236: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDestLastDest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDestLastDest");
                }
                return;
            }
            case 400240: {
                this.ap2_setSpellerScreenInactive_2107068339();
                return;
            }
            case 400248: {
                this.ap2_exitPreviewMapScreen_2107068339();
                this.ap2_setSpellerScreenInactive_2107068339();
                sMServices.removeContext(0);
                return;
            }
            case 400251: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400261: {
                this.ap2_rmlExit_2107068339();
                sMServices.removeContext(-240799801L);
                return;
            }
            case 400263: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400278: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400279: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRouteCriteria(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRouteCriteria");
                }
                return;
            }
            case 400285: {
                this.ap2_setSpellerScreenInactive_2107068339();
                return;
            }
            case 400286: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400291: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400292: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400295: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400304: {
                this.ap2_exitMapMainScreen_2107068339();
                return;
            }
            case 400320: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitNavFavorites(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitNavFavorites");
                }
                return;
            }
            case 400322: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400341: {
                sMServices.removeContext(0);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.onlineSearchExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlineSearchExit");
                }
                return;
            }
            case 400342: {
                this.ap2_exitPoiWarning_2107068339();
                return;
            }
            case 400343: {
                this.ap2_exitPoiWarning_2107068339();
                return;
            }
            case 400353: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                return;
            }
            case 400376: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitMapScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitMapScreen");
                }
                return;
            }
            case 400382: {
                this.ap6_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 400383: {
                sMServices.removeContext(-101863888L);
                sMServices.popDrawerIDs();
                return;
            }
            case 400390: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.onlinePOIMainExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlinePOIMainExit");
                }
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400393: {
                this.ap2_setSpellerScreenInactive_2107068339();
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400395: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400399: {
                this.ap6_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 400400: {
                this.ap6_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 400402: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitAddAddressDestOpt(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitAddAddressDestOpt");
                }
                return;
            }
            case 400418: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDestOptContacts(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDestOptContacts");
                }
                return;
            }
            case 400441: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400442: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitMapBriefingScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitMapBriefingScreen");
                }
                return;
            }
            case 400461: {
                this.ap2_setNavigationInputMode_725899433();
                return;
            }
            case 400475: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400498: {
                sMServices.removeContext(0);
                return;
            }
            case 400500: {
                sMServices.removeContext(0);
                return;
            }
            case 400501: {
                sMServices.removeContext(0);
                return;
            }
            case 400513: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400516: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400521: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400522: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400523: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400524: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400526: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899433();
                return;
            }
            case 400527: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899433();
                return;
            }
            case 400528: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899433();
                return;
            }
            case 400535: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400537: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400540: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400541: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400542: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400543: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400545: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400546: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400554: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400555: {
                InfoActionProxy infoActionProxy = this.ap7;
                try {
                    infoActionProxy.tmcExitDetailsScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcExitDetailsScreen");
                }
                return;
            }
            case 400560: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(0);
                this.ap0_activeApplication_1501447227();
                this.ap5_sysInitConnectLeft_2107068339();
                this.ap0_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 400561: {
                sMServices.removeContext(0);
                sMServices.addContext(-2066650800L);
                return;
            }
            case 400562: {
                sMServices.removeContext(0);
                sMServices.addContext(-2066650800L);
                return;
            }
            case 400568: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 400573: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400575: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400577: {
                sMServices.removeContext(0);
                sMServices.addContext(-2066650800L);
                return;
            }
            case 400578: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400579: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400580: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400583: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400585: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899433();
                return;
            }
            case 400588: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400589: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400597: {
                sMServices.removeContext(0);
                return;
            }
            case 400602: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400609: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400610: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400611: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400614: {
                this.ap3_leaveCallcenterCall_725899435();
                sMServices.popDrawerIDs();
                return;
            }
            case 400627: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400629: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400630: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400631: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400633: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400634: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400639: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400644: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400656: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400657: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitDestOptFavorites(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitDestOptFavorites");
                }
                return;
            }
            case 400659: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400660: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400664: {
                this.ap6_connectivityDataOnlineAppLeft_2107068339();
                return;
            }
            case 400692: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400696: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.leavePOINewAreaSearchScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "leavePOINewAreaSearchScreen");
                }
                return;
            }
            case 400711: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400713: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400716: {
                this.ap2_exitMapMainScreen_2107068339();
                return;
            }
            case 400721: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400722: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400729: {
                this.ap3_leaveCallcenterCall_725899435();
                return;
            }
            case 400745: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400751: {
                this.ap2_exitMapMainScreen_2107068339();
                return;
            }
            case 400761: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400762: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitTpegPOI(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitTpegPOI");
                }
                return;
            }
            case 400764: {
                this.ap2_exitPreviewMapScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitTpegPOIRRD(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitTpegPOIRRD");
                }
                return;
            }
            case 400770: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400773: {
                sMServices.setScreenMode(1);
                sMServices.popDrawerIDs();
                return;
            }
            case 400774: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400789: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400796: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.navFuelFeatureActive(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navFuelFeatureActive");
                }
                this.ap2_exitPreviewMapScreen_2107068339();
                sMServices.popDrawerIDs();
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.exitRRD(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "exitRRD");
                }
                return;
            }
            case 400800: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400803: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400806: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400811: {
                this.ap2_exitPreviewMapScreen_2107068339();
                return;
            }
            case 400817: {
                this.ap2_exitMapMainScreen_2107068339();
                return;
            }
            case 400828: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 400829: {
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_activeApplication_1501447227() {
        FrameworkActionProxy frameworkActionProxy = this.ap0;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 5);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap1_setMMICombiContext_1028046053() {
        MMICombiActionProxy mMICombiActionProxy = this.ap1;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 20);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap0_mainApplicationWizardLastApplication_725899437() {
        FrameworkActionProxy frameworkActionProxy = this.ap0;
        try {
            frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 4);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
        }
    }

    private void ap2_enterPreviewMapScreen__1475995103() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterPreviewMapScreen(this.smm.getTerminalID(), 260, 318);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPreviewMapScreen");
        }
    }

    private void ap2_setDestActiveContext_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
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

    private void ap2_setMapShowDetailsContext_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setMapShowDetailsContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapShowDetailsContext");
        }
    }

    private void ap2_setNavigationInputMode_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavigationInputMode(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavigationInputMode");
        }
    }

    private void ap2_enterShowDetailsOnlinePoiBrowserMain_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterShowDetailsOnlinePoiBrowserMain(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterShowDetailsOnlinePoiBrowserMain");
        }
    }

    private void ap2_setNavigationInputMode_725899434() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavigationInputMode(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavigationInputMode");
        }
    }

    private void ap0_activeApplication__177886808() {
        FrameworkActionProxy frameworkActionProxy = this.ap0;
        try {
            frameworkActionProxy.activeApplication(this.smm.getTerminalID(), 22);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "activeApplication");
        }
    }

    private void ap5_sysInitConnectEntered_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap5;
        try {
            ecallActionProxy.sysInitConnectEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "sysInitConnectEntered");
        }
    }

    private void ap0_mainApplicationWizardLastApplication_725899439() {
        FrameworkActionProxy frameworkActionProxy = this.ap0;
        try {
            frameworkActionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 6);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionFrameworkActionProxy(frameworkActionProxy, nullPointerException, "mainApplicationWizardLastApplication");
        }
    }

    private void ap2_setSpellerScreenActive_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setSpellerScreenActive(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setSpellerScreenActive");
        }
    }

    private void ap2_enterMapMainScreen_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterMapMainScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterMapMainScreen");
        }
    }

    private void ap2_setDestOptSelectionBreadcrumb_725899435() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setDestOptSelectionBreadcrumb(this.smm.getTerminalID(), 2);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestOptSelectionBreadcrumb");
        }
    }

    private void ap6_connectivityDataOnlineAppEntered_2107068339() {
        ConnectivityActionProxy connectivityActionProxy = this.ap6;
        try {
            connectivityActionProxy.connectivityDataOnlineAppEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppEntered");
        }
    }

    private void ap2_setNavDestPOIContext_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavDestPOIContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavDestPOIContext");
        }
    }

    private void ap2_setPoiActiveContext_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setPoiActiveContext(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setPoiActiveContext");
        }
    }

    private void ap6_connectivityOpenSelectionDrawerByHKReturn_725899434() {
        ConnectivityActionProxy connectivityActionProxy = this.ap6;
        try {
            connectivityActionProxy.connectivityOpenSelectionDrawerByHKReturn(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityOpenSelectionDrawerByHKReturn");
        }
    }

    private void ap2_enterTrafficDetails_725899434() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterTrafficDetails(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterTrafficDetails");
        }
    }

    private void ap2_setNavDestPOIContext_725899434() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavDestPOIContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavDestPOIContext");
        }
    }

    private void ap4_setTopLevelScreen_1322014434() {
        TopLevelScreenActionProxy topLevelScreenActionProxy = this.ap4;
        try {
            topLevelScreenActionProxy.setTopLevelScreen(this.smm.getTerminalID(), 4, false);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionTopLevelScreenActionProxy(topLevelScreenActionProxy, nullPointerException, "setTopLevelScreen");
        }
    }

    private void ap2_setNavDestPOIContext_725899436() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setNavDestPOIContext(this.smm.getTerminalID(), 3);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavDestPOIContext");
        }
    }

    private void ap6_connectivitySetApplicationId__1186095480() {
        ConnectivityActionProxy connectivityActionProxy = this.ap6;
        try {
            connectivityActionProxy.connectivitySetApplicationId(this.smm.getTerminalID(), 3);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivitySetApplicationId");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 400000: {
                this.ap0_activeApplication_1501447227();
                this.ap1_setMMICombiContext_1028046053();
                sMServices.setColor(3);
                return;
            }
            case 400018: {
                sMServices.popDrawerIDs();
                return;
            }
            case 400021: {
                sMServices.setColor(3);
                return;
            }
            case 400022: {
                ActionProxy actionProxy = this.ap2;
                try {
                    actionProxy.activateDestination(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "activateDestination");
                }
                actionProxy = this.ap1;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 22);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.pushDrawerIDs(0, 0);
                this.ap0_mainApplicationWizardLastApplication_725899437();
                return;
            }
            case 400023: {
                ActionProxy actionProxy = this.ap2;
                try {
                    actionProxy.activateMap(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "activateMap");
                }
                this.ap1_setMMICombiContext_1028046053();
                sMServices.pushDrawerIDs(0, 0);
                actionProxy = this.ap0;
                try {
                    actionProxy.mainApplicationWizardLastApplication(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "mainApplicationWizardLastApplication");
                }
                return;
            }
            case 400024: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.navigationEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navigationEntered");
                }
                return;
            }
            case 400025: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400026: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400027: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400028: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterNavDestForm(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterNavDestForm");
                }
                return;
            }
            case 400031: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400033: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400035: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400038: {
                sMServices.addContext(-2066650800L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 400040: {
                sMServices.addContext(-690834900L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                return;
            }
            case 400041: {
                sMServices.addContext(-1024090492L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 8);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                return;
            }
            case 400043: {
                sMServices.addContext(-1647038573L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                return;
            }
            case 400044: {
                sMServices.addContext(-101863888L);
                this.ap2_setDestActiveContext_725899433();
                return;
            }
            case 400045: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestIntellidest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestIntellidest");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400046: {
                sMServices.addContext(-427027396L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                this.ap3_myAudiAuthScreenType_725899433();
                this.ap3_myAudiAuthContext_725899435();
                return;
            }
            case 400049: {
                sMServices.addContext(0);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                return;
            }
            case 400055: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap2_setMapShowDetailsContext_725899433();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestOptSelectionBreadcrumb(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestOptSelectionBreadcrumb");
                }
                return;
            }
            case 400058: {
                sMServices.addContext(0);
                ActionProxy actionProxy = this.ap4;
                try {
                    actionProxy.setTopLevelScreen(this.smm.getTerminalID(), 4, true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTopLevelScreenActionProxy(actionProxy, nullPointerException, "setTopLevelScreen");
                }
                actionProxy = this.ap2;
                try {
                    actionProxy.setMapActiveContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "setMapActiveContext");
                }
                return;
            }
            case 400059: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400064: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400066: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400072: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                return;
            }
            case 400076: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400078: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400081: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400084: {
                this.ap2_enterPreviewMapScreen__1475995103();
                this.ap2_enterPoiMainScreen_2107068339();
                return;
            }
            case 400085: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400087: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                return;
            }
            case 400101: {
                this.ap2_setNavigationInputMode_725899433();
                return;
            }
            case 400116: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                return;
            }
            case 400121: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400142: {
                sMServices.addContext(-1310425789L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapActiveContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapActiveContext");
                }
                return;
            }
            case 400150: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400152: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400154: {
                sMServices.setColor(3);
                return;
            }
            case 400156: {
                sMServices.setColor(3);
                return;
            }
            case 400158: {
                sMServices.setColor(3);
                return;
            }
            case 400160: {
                sMServices.setColor(3);
                return;
            }
            case 400166: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400168: {
                this.ap2_enterShowDetailsOnlinePoiBrowserMain_2107068339();
                sMServices.pushDrawerIDs(-1L, 0L);
                return;
            }
            case 400170: {
                sMServices.setColor(3);
                return;
            }
            case 400171: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavDestPOIContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavDestPOIContext");
                }
                return;
            }
            case 400173: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestOptMethods(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestOptMethods");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400175: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 400178: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400180: {
                sMServices.setColor(3);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 400182: {
                sMServices.setColor(3);
                return;
            }
            case 400193: {
                sMServices.setColor(3);
                return;
            }
            case 400207: {
                this.ap2_setNavigationInputMode_725899434();
                this.ap3_myAudiAuthScreenType_725899434();
                this.ap3_myAudiAuthContext_725899434();
                return;
            }
            case 400211: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavigationInputMode(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavigationInputMode");
                }
                this.ap3_myAudiAuthContext_725899435();
                return;
            }
            case 400222: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDemoModeStartPosIntellidest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDemoModeStartPosIntellidest");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400225: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(0);
                this.ap0_activeApplication__177886808();
                this.ap5_sysInitConnectEntered_2107068339();
                this.ap0_mainApplicationWizardLastApplication_725899439();
                return;
            }
            case 400236: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestLastDest(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestLastDest");
                }
                return;
            }
            case 400240: {
                this.ap2_setSpellerScreenActive_2107068339();
                return;
            }
            case 400248: {
                this.ap2_enterPreviewMapScreen__1475995103();
                this.ap2_setSpellerScreenActive_2107068339();
                sMServices.addContext(0);
                return;
            }
            case 400251: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400261: {
                sMServices.addContext(-240799801L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.rmlEnter(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "rmlEnter");
                }
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapActiveContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapActiveContext");
                }
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400263: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400278: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterGeoCoordInput(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterGeoCoordInput");
                }
                return;
            }
            case 400285: {
                this.ap2_setSpellerScreenActive_2107068339();
                return;
            }
            case 400286: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400291: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400292: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400295: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapShowDetailsContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapShowDetailsContext");
                }
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 400304: {
                this.ap2_enterMapMainScreen_2107068339();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.resetAudiConnectOptionState(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "resetAudiConnectOptionState");
                }
                return;
            }
            case 400318: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 400320: {
                this.ap2_enterPreviewMapScreen__1475995103();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterNavFavorites(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterNavFavorites");
                }
                this.ap2_setDestOptSelectionBreadcrumb_725899435();
                return;
            }
            case 400322: {
                this.ap2_enterPreviewMapScreen_109716467();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestOptSaveAsFavorite(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestOptSaveAsFavorite");
                }
                return;
            }
            case 400341: {
                sMServices.addContext(0);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                return;
            }
            case 400353: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                return;
            }
            case 400354: {
                sMServices.setColor(3);
                return;
            }
            case 400376: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterMapScreen(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterMapScreen");
                }
                return;
            }
            case 400380: {
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400382: {
                this.ap6_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 400383: {
                sMServices.addContext(-101863888L);
                this.ap2_setDestActiveContext_725899433();
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 400390: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.onlinePOIMainEnter(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlinePOIMainEnter");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400393: {
                this.ap2_setSpellerScreenActive_2107068339();
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400395: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400399: {
                this.ap6_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 400400: {
                this.ap6_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 400402: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterAddAddressDestOpt(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterAddAddressDestOpt");
                }
                return;
            }
            case 400418: {
                this.ap2_enterPreviewMapScreen_109716467();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestOptContacts(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestOptContacts");
                }
                return;
            }
            case 400426: {
                sMServices.setColor(3);
                return;
            }
            case 400428: {
                sMServices.setColor(3);
                return;
            }
            case 400430: {
                sMServices.setColor(3);
                return;
            }
            case 400441: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 400442: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterMapBriefingScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterMapBriefingScreen");
                }
                return;
            }
            case 400445: {
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400461: {
                this.ap2_setNavigationInputMode_725899434();
                return;
            }
            case 400475: {
                this.ap2_enterShowDetailsOnlinePoiBrowserMain_2107068339();
                sMServices.pushDrawerIDs(-1L, 0L);
                return;
            }
            case 400482: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapActiveContext(this.smm.getTerminalID(), 4);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapActiveContext");
                }
                return;
            }
            case 400488: {
                this.ap2_setNavDestPOIContext_725899433();
                this.ap2_setPoiActiveContext_725899433();
                return;
            }
            case 400490: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapActiveContext(this.smm.getTerminalID(), 5);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapActiveContext");
                }
                return;
            }
            case 400498: {
                sMServices.addContext(0);
                return;
            }
            case 400500: {
                sMServices.addContext(0);
                return;
            }
            case 400501: {
                sMServices.addContext(0);
                return;
            }
            case 400513: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400516: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400521: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400522: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400523: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400524: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400526: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899434();
                return;
            }
            case 400527: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899434();
                return;
            }
            case 400528: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899434();
                return;
            }
            case 400535: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 400537: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400540: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400541: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400542: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400543: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400545: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400546: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400547: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 400554: {
                sMServices.pushDrawerIDs(0, 0L);
                return;
            }
            case 400555: {
                InfoActionProxy infoActionProxy = this.ap7;
                try {
                    infoActionProxy.tmcEnterDetailsScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionInfoActionProxy(infoActionProxy, nullPointerException, "tmcEnterDetailsScreen");
                }
                return;
            }
            case 400556: {
                this.ap2_enterTrafficDetails_725899434();
                return;
            }
            case 400557: {
                this.ap2_enterTrafficDetails_725899434();
                return;
            }
            case 400558: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterTrafficDetails(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterTrafficDetails");
                }
                return;
            }
            case 400560: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(0);
                this.ap0_activeApplication__177886808();
                this.ap5_sysInitConnectEntered_2107068339();
                this.ap0_mainApplicationWizardLastApplication_725899439();
                return;
            }
            case 400561: {
                this.ap2_setNavDestPOIContext_725899434();
                this.ap2_setPoiActiveContext_725899433();
                sMServices.removeContext(-2066650800L);
                sMServices.addContext(0);
                return;
            }
            case 400562: {
                this.ap2_setNavDestPOIContext_725899434();
                this.ap2_setPoiActiveContext_725899433();
                sMServices.removeContext(-2066650800L);
                sMServices.addContext(0);
                return;
            }
            case 400565: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setNavAddressFormContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setNavAddressFormContext");
                }
                return;
            }
            case 400568: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400570: {
                sMServices.setColor(3);
                return;
            }
            case 400573: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400575: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400577: {
                this.ap2_setNavDestPOIContext_725899434();
                this.ap2_setPoiActiveContext_725899433();
                sMServices.removeContext(-2066650800L);
                sMServices.addContext(0);
                return;
            }
            case 400578: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400579: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400580: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400583: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400585: {
                this.ap6_connectivityOpenSelectionDrawerByHKReturn_725899434();
                return;
            }
            case 400588: {
                if (((ChoiceModel)this.getModel(1729897216)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 0);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2301031) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(1729897216)).getValue() == 2) {
                    sMServices.pushDrawerIDs(0, 0);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2301031) Value == 2' is not fullfilled, Action is not executed.");
                }
                sMServices.setScreenMode(1);
                return;
            }
            case 400589: {
                if (((ChoiceModel)this.getModel(1729897216)).getValue() == 1) {
                    sMServices.pushDrawerIDs(0L, 0);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2301031) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(1729897216)).getValue() == 2) {
                    sMServices.pushDrawerIDs(0L, 0);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#2301031) Value == 2' is not fullfilled, Action is not executed.");
                }
                sMServices.setScreenMode(2);
                return;
            }
            case 400596: {
                this.ap2_setNavDestPOIContext_725899433();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setPoiActiveContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setPoiActiveContext");
                }
                return;
            }
            case 400597: {
                sMServices.addContext(0);
                return;
            }
            case 400598: {
                this.ap4_setTopLevelScreen_1322014434();
                return;
            }
            case 400602: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400609: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400610: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400611: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400614: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.startOperatorCall(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "startOperatorCall");
                }
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 400627: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400629: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400630: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400631: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400633: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400634: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400639: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400644: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400656: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400657: {
                this.ap2_enterPreviewMapScreen_109716467();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestOptFavorites(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestOptFavorites");
                }
                return;
            }
            case 400659: {
                sMServices.pushDrawerIDs(0, 0);
                this.ap2_setDestOptSelectionBreadcrumb_725899435();
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 400660: {
                sMServices.pushDrawerIDs(0, 0);
                this.ap2_setDestOptSelectionBreadcrumb_725899434();
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 400664: {
                this.ap6_connectivityDataOnlineAppEntered_2107068339();
                return;
            }
            case 400678: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapLicenceWeatherMapCheckResChoice(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapLicenceWeatherMapCheckResChoice");
                }
                return;
            }
            case 400692: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400696: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterPOINewAreaSearchScreen(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPOINewAreaSearchScreen");
                }
                return;
            }
            case 400710: {
                sMServices.setColor(3);
                return;
            }
            case 400711: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400713: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400716: {
                this.ap2_enterMapMainScreen_2107068339();
                return;
            }
            case 400718: {
                this.ap2_setNavDestPOIContext_725899436();
                return;
            }
            case 400720: {
                this.ap4_setTopLevelScreen_1322014434();
                return;
            }
            case 400721: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400722: {
                this.ap2_enterPreviewMapScreen__1475995103();
                return;
            }
            case 400725: {
                this.ap2_setNavDestPOIContext_725899436();
                return;
            }
            case 400734: {
                sMServices.setColor(3);
                return;
            }
            case 400745: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400751: {
                this.ap2_enterMapMainScreen_2107068339();
                return;
            }
            case 400761: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400762: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterTpegPOI(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterTpegPOI");
                }
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setPoiActiveContext(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setPoiActiveContext");
                }
                return;
            }
            case 400764: {
                this.ap2_enterPreviewMapScreen_109716467();
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterTpegPOIRRD(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterTpegPOIRRD");
                }
                return;
            }
            case 400770: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400773: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 400774: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400784: {
                sMServices.setColor(3);
                return;
            }
            case 400789: {
                sMServices.pushDrawerIDs(-1L, 0);
                return;
            }
            case 400796: {
                sMServices.pushDrawerIDs(0L, 0L);
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setDestActiveContext(this.smm.getTerminalID(), 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestActiveContext");
                }
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.navFuelFeatureActive(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "navFuelFeatureActive");
                }
                this.ap2_enterPreviewMapScreen_109716467();
                naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterRRD(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterRRD");
                }
                return;
            }
            case 400800: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 400802: {
                this.ap2_enterTrafficDetails_725899434();
                return;
            }
            case 400803: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 400806: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400809: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.prepareVICS2ShowInMap(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "prepareVICS2ShowInMap");
                }
                return;
            }
            case 400811: {
                this.ap2_enterPreviewMapScreen_109716467();
                return;
            }
            case 400817: {
                this.ap2_enterMapMainScreen_2107068339();
                return;
            }
            case 400818: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
                }
                return;
            }
            case 400828: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.setScreenMode(2);
                this.ap2_setMapShowDetailsContext_725899433();
                return;
            }
            case 400829: {
                this.ap3_myAudiAuthScreenType_725899434();
                return;
            }
            case 400836: {
                ConnectivityActionProxy connectivityActionProxy = this.ap6;
                try {
                    connectivityActionProxy.connectivityDataInstanceEntered(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataInstanceEntered");
                }
                this.ap6_connectivitySetApplicationId__1186095480();
                return;
            }
            case 400837: {
                ConnectivityActionProxy connectivityActionProxy = this.ap6;
                try {
                    connectivityActionProxy.connectivityBluetoothInstanceEntered(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBluetoothInstanceEntered");
                }
                this.ap6_connectivitySetApplicationId__1186095480();
                return;
            }
        }
    }

    private void ap2_destAddressInputHKReturn_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destAddressInputHKReturn(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destAddressInputHKReturn");
        }
    }

    private void ap2_destPOIHKReturn_725899434() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
        }
    }

    private void ap2_destPOIHKReturn_725899433() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
        }
    }

    private void ap2_destPOIHKReturn_1804660464() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 601);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
        }
    }

    private void ap3_destOnlineStartDestinationImport_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.destOnlineStartDestinationImport(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "destOnlineStartDestinationImport");
        }
    }

    private void ap3_myAudiAuthContext_725899434() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.myAudiAuthContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthContext");
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

    private void ap2_setDestOptSelectionBreadcrumb_725899434() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setDestOptSelectionBreadcrumb(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setDestOptSelectionBreadcrumb");
        }
    }

    private void ap3_myAudiAuthContext_725899435() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.myAudiAuthContext(this.smm.getTerminalID(), 2);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthContext");
        }
    }

    private void ap2_rmlExit_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.rmlExit(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "rmlExit");
        }
    }

    private void ap3_myAudiAuthScreenType_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.myAudiAuthScreenType(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "myAudiAuthScreenType");
        }
    }

    private void ap3_remoteHmiMarkForTopLevel_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiMarkForTopLevel(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMarkForTopLevel");
        }
    }

    private void ap3_remoteHmiMarkForTopLevel_725899434() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiMarkForTopLevel(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiMarkForTopLevel");
        }
    }

    private void ap2_setOnlineMapDataConnectionLicenseStatus_699132190() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setOnlineMapDataConnectionLicenseStatus(this.smm.getTerminalID(), false, true);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionLicenseStatus");
        }
    }

    private void ap2_setOnlineMapDataConnectionLicenseStatus_184817555() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setOnlineMapDataConnectionLicenseStatus(this.smm.getTerminalID(), false, false);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionLicenseStatus");
        }
    }

    private void ap2_setOnlineMapDataConnectionStatus__842232548() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setOnlineMapDataConnectionStatus(this.smm.getTerminalID(), false);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionStatus");
        }
    }

    private void ap2_onlineTrafficLicenceActive_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.onlineTrafficLicenceActive(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "onlineTrafficLicenceActive");
        }
    }

    private void ap3_licenseCheckEntered__228141130() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "lic_traffic", "Onlineverkehrsdaten");
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
        }
    }

    private void ap2_destPOIHKReturn_1028046024() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 12);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
        }
    }

    private void ap2_destExitStartGuidancePopup_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.destExitStartGuidancePopup(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destExitStartGuidancePopup");
        }
    }

    private void ap2_setOnlineMapDataConnectionLicenseStatus_1415795639() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.setOnlineMapDataConnectionLicenseStatus(this.smm.getTerminalID(), true, true);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionLicenseStatus");
        }
    }

    private void ap2_enterDestSelectionContext_725899436() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterDestSelectionContext(this.smm.getTerminalID(), 3);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestSelectionContext");
        }
    }

    private void ap2_returnFromConnectivity_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.returnFromConnectivity(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "returnFromConnectivity");
        }
    }

    private void ap2_returnFromConnectivityError_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.returnFromConnectivityError(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "returnFromConnectivityError");
        }
    }

    private void ap3_remoteHmiClosedViaOptionDrawer_2107068339() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiClosedViaOptionDrawer(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiClosedViaOptionDrawer");
        }
    }

    private void ap3_remoteHmiEnter_725899433() {
        OnlineActionProxy onlineActionProxy = this.ap3;
        try {
            onlineActionProxy.remoteHmiEnter(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiEnter");
        }
    }

    private void ap2_enterPoiMainScreen_2107068339() {
        NaviActionProxy naviActionProxy = this.ap2;
        try {
            naviActionProxy.enterPoiMainScreen(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterPoiMainScreen");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 400035: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 400039: {
                return;
            }
            case 400040: {
                return;
            }
            case 400041: {
                return;
            }
            case 400042: {
                return;
            }
            case 400044: {
                return;
            }
            case 400067: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400071: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400076: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 400077: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterDestIntellidestDownTransition(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterDestIntellidestDownTransition");
                }
                return;
            }
            case 400090: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 400093: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 400112: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 501);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
                }
                return;
            }
            case 400121: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 401);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
                }
                return;
            }
            case 400153: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 400157: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 400169: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 400180: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(320538112);
                        return;
                    }
                }
                return;
            }
            case 400182: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400190: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400196: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 201);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 400206: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400209: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 400214: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(437978624);
                        return;
                    }
                }
                return;
            }
            case 400238: {
                this.ap2_destPOIHKReturn_1804660464();
                return;
            }
            case 400280: {
                this.ap2_destPOIHKReturn_1804660464();
                return;
            }
            case 400324: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400328: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400346: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400350: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 400369: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 400370: {
                sMServices.addScreenAnimation(4);
                return;
            }
            case 400372: {
                sMServices.addScreenAnimation(2);
                sMServices.hidePartialPopup(-149289472);
                sMServices.hidePartialPopup(505087488);
                sMServices.hidePartialPopup(1008403968);
                sMServices.hidePartialPopup(-166066688);
                return;
            }
            case 400373: {
                sMServices.addScreenAnimation(2);
                sMServices.hidePartialPopup(-149289472);
                sMServices.hidePartialPopup(505087488);
                sMServices.hidePartialPopup(1008403968);
                sMServices.showPartialPopup(-166066688);
                return;
            }
            case 400374: {
                sMServices.hidePartialPopup(-166066688);
                sMServices.addScreenAnimation(32);
                if (((LabelModel)this.getModel(-165935616)).getLength() > 0 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9) {
                    sMServices.showPartialPopup(505087488);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition '( LabelModel (MODELID#400630) Length > 0 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )' is not fullfilled, Action is not executed.");
                }
                if (((LabelModel)this.getModel(-165935616)).getLength() < 1 && ((ChoiceModel)this.getModel(335)).getValue() != 2 && ((ChoiceModel)this.getModel(335)).getValue() != 3 && ((ChoiceModel)this.getModel(335)).getValue() != 8 && ((ChoiceModel)this.getModel(335)).getValue() != 9) {
                    sMServices.showPartialPopup(-149289472);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition '( LabelModel (MODELID#400630) Length < 1 ) && ( !( ( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 ) ) )' is not fullfilled, Action is not executed.");
                }
                return;
            }
            case 400375: {
                sMServices.hidePartialPopup(-166066688);
                return;
            }
            case 400376: {
                sMServices.hidePartialPopup(-149289472);
                return;
            }
            case 400379: {
                sMServices.addScreenAnimation(32);
                sMServices.hidePartialPopup(-149289472);
                sMServices.hidePartialPopup(505087488);
                sMServices.hidePartialPopup(-166066688);
                sMServices.showPartialPopup(1008403968);
                return;
            }
            case 400386: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400405: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-132512256);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(-820378112);
                        return;
                    }
                }
                return;
            }
            case 400412: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400428: {
                this.ap3_destOnlineStartDestinationImport_2107068339();
                return;
            }
            case 400429: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400435: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400436: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400447: {
                this.ap3_myAudiAuthContext_725899434();
                this.ap3_myAudiAuthScreenType_725899434();
                return;
            }
            case 400452: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-199621120);
                        this.ap2_setDestOptSelectionBreadcrumb_725899434();
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(191);
                        return;
                    }
                }
                return;
            }
            case 400459: {
                this.ap3_myAudiAuthContext_725899435();
                return;
            }
            case 400467: {
                sMServices.hidePartialPopup(-468056576);
                return;
            }
            case 400468: {
                sMServices.showPartialPopup(-468056576);
                return;
            }
            case 400472: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                return;
            }
            case 400480: {
                sMServices.showPartialPopup(-31848960);
                return;
            }
            case 400481: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400482: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400492: {
                sMServices.showPartialPopup(622528000);
                return;
            }
            case 400502: {
                if (((ChoiceModel)this.getModel(958727680)).getValue() == 1) {
                    sMServices.showPartialPopup(191);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#402745) Value == 1' is not fullfilled, Action is not executed.");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 400511: {
                sMServices.showPartialPopup(1771008);
                return;
            }
            case 400512: {
                sMServices.hidePartialPopup(1771008);
                return;
            }
            case 400520: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400521: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400528: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400529: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400543: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400550: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400569: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-82180608);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(-98957824);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(-1357117952);
                        return;
                    }
                }
                return;
            }
            case 400570: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-82180608);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(-98957824);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(-1357117952);
                        return;
                    }
                }
                return;
            }
            case 400581: {
                sMServices.hidePartialPopup(152765952);
                return;
            }
            case 400582: {
                sMServices.showPartialPopup(152765952);
                return;
            }
            case 400583: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 400605: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(303760896);
                        return;
                    }
                }
                return;
            }
            case 400609: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400615: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400622: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400632: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 400646: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 400647: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 400649: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(-98957824);
                        return;
                    }
                }
                return;
            }
            case 400650: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400656: {
                sMServices.showPartialPopup(622528000);
                return;
            }
            case 400728: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400730: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 400731: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 400732: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.closeSelectionDrawer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "closeSelectionDrawer");
                }
                return;
            }
            case 400734: {
                sMServices.showPartialPopup(-115735040);
                return;
            }
            case 400735: {
                sMServices.showPartialPopup(-48626176);
                return;
            }
            case 400740: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.enterNavFavoritesDownTransition(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterNavFavoritesDownTransition");
                }
                return;
            }
            case 400762: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400765: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400769: {
                switch (n2) {
                    case 0: {
                        OnlineActionProxy onlineActionProxy = this.ap3;
                        try {
                            onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "zieleinspeisung", "Destination Import");
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                        }
                        return;
                    }
                }
                return;
            }
            case 400773: {
                sMServices.addScreenAnimation(16);
                switch (n2) {
                    case 2: {
                        this.ap2_rmlExit_2107068339();
                        return;
                    }
                    case 6: {
                        NaviActionProxy naviActionProxy = this.ap2;
                        try {
                            naviActionProxy.enterMapScreenFromLeftDrawer(this.smm.getTerminalID());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "enterMapScreenFromLeftDrawer");
                        }
                        return;
                    }
                }
                return;
            }
            case 400774: {
                sMServices.addScreenAnimation(16);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 400797: {
                return;
            }
            case 400799: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 400804: {
                this.ap3_myAudiAuthContext_725899435();
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 400805: {
                this.ap3_remoteHmiMarkForTopLevel_725899433();
                return;
            }
            case 400817: {
                sMServices.hidePartialPopup(1008403968);
                return;
            }
            case 400852: {
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 400866: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1025181184);
                        return;
                    }
                    case 3: {
                        sMServices.showPartialPopup(1041958400);
                        return;
                    }
                }
                return;
            }
            case 400883: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400888: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1243284992);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1226507776);
                        return;
                    }
                }
                return;
            }
            case 400889: {
                sMServices.showPartialPopup(1243284992);
                return;
            }
            case 400894: {
                sMServices.hidePartialPopup(-149289472);
                sMServices.hidePartialPopup(505087488);
                sMServices.hidePartialPopup(1008403968);
                sMServices.showPartialPopup(-166066688);
                return;
            }
            case 400895: {
                sMServices.hidePartialPopup(-149289472);
                sMServices.hidePartialPopup(505087488);
                sMServices.hidePartialPopup(1008403968);
                sMServices.hidePartialPopup(-166066688);
                return;
            }
            case 400896: {
                sMServices.showPartialPopup(1260062208);
                return;
            }
            case 400904: {
                switch (n2) {
                    case 1: {
                        this.ap3_destOnlineStartDestinationImport_2107068339();
                        return;
                    }
                }
                return;
            }
            case 400919: {
                switch (n2) {
                    case 0: {
                        ActionProxy actionProxy = this.ap2;
                        try {
                            actionProxy.onlineSearchEnter(this.smm.getTerminalID(), 2);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "onlineSearchEnter");
                        }
                        if (((ChoiceModel)this.getModel(335)).getValue() < 1 || ((SysConstModel)this.getModel(442)).getValue() == 2 && ((ChoiceModel)this.getModel(335)).getValue() > 0) {
                            actionProxy = this.ap3;
                            try {
                                actionProxy.licenseCheckEntered(this.smm.getTerminalID(), "poi_haptic", "Onlinesuche");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition '( ChoiceModel (MODELID#335) Value < 1 ) || ( ( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) ) && ( ChoiceModel (MODELID#335) Value > 0 ) )' is not fullfilled, Action is not executed.");
                        }
                        if (((ChoiceModel)this.getModel(335)).getValue() > 0 && ((SysConstModel)this.getModel(442)).getValue() != 2) {
                            actionProxy = this.ap3;
                            try {
                                actionProxy.licenseCheckEntered(this.smm.getTerminalID(), "poi_sds", "Onlinesuche");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition '( ChoiceModel (MODELID#335) Value > 0 ) && ( !( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_CN ) ) )' is not fullfilled, Action is not executed.");
                        }
                        this.ap3_remoteHmiMarkForTopLevel_725899434();
                        return;
                    }
                }
                return;
            }
            case 400935: {
                sMServices.hidePartialPopup(-166066688);
                return;
            }
            case 400936: {
                sMServices.showPartialPopup(1377502720);
                return;
            }
            case 400940: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_699132190();
                        return;
                    }
                    case 1: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_184817555();
                        return;
                    }
                }
                return;
            }
            case 400942: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setOnlineMapDataConnectionStatus(this.smm.getTerminalID(), true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionStatus");
                }
                return;
            }
            case 400943: {
                this.ap2_setOnlineMapDataConnectionStatus__842232548();
                return;
            }
            case 400951: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400959: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionStatus__842232548();
                        return;
                    }
                }
                return;
            }
            case 400966: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400970: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400971: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 400977: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 400997: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401001: {
                sMServices.showPartialPopup(773522944);
                return;
            }
            case 401012: {
                sMServices.showPartialPopup(-115735040);
                return;
            }
            case 401013: {
                sMServices.showPartialPopup(-48626176);
                return;
            }
            case 401014: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.confirmRouteCalcFail(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "confirmRouteCalcFail");
                }
                return;
            }
            case 401016: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1276839424);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1293616640);
                        return;
                    }
                    case 2: {
                        sMServices.hidePartialPopup(1276839424);
                        sMServices.hidePartialPopup(1293616640);
                        return;
                    }
                }
                return;
            }
            case 401019: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1713047040);
                        return;
                    }
                }
                return;
            }
            case 401029: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401039: {
                this.ap2_onlineTrafficLicenceActive_2107068339();
                return;
            }
            case 401042: {
                switch (n2) {
                    case 0: {
                        this.ap3_licenseCheckEntered__228141130();
                        this.ap3_remoteHmiMarkForTopLevel_725899433();
                        return;
                    }
                }
                return;
            }
            case 401046: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401049: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401052: {
                switch (n2) {
                    case 2: {
                        sMServices.showPartialPopup(1763378688);
                        return;
                    }
                }
                return;
            }
            case 401053: {
                switch (n2) {
                    case 2: {
                        sMServices.showPartialPopup(1763378688);
                        return;
                    }
                }
                return;
            }
            case 401054: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401055: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401056: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401057: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401058: {
                return;
            }
            case 401059: {
                return;
            }
            case 401082: {
                return;
            }
            case 401083: {
                return;
            }
            case 401086: {
                sMServices.showPartialPopup(-115735040);
                return;
            }
            case 401087: {
                sMServices.showPartialPopup(-48626176);
                return;
            }
            case 401092: {
                this.ap2_onlineTrafficLicenceActive_2107068339();
                return;
            }
            case 401095: {
                switch (n2) {
                    case 0: {
                        this.ap3_licenseCheckEntered__228141130();
                        this.ap3_remoteHmiMarkForTopLevel_725899433();
                        return;
                    }
                }
                return;
            }
            case 401098: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 401099: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 401100: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(-434436608);
                        return;
                    }
                }
                return;
            }
            case 401101: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401116: {
                return;
            }
            case 401117: {
                sMServices.showPartialPopup(622528000);
                switch (n2) {
                    case 0: {
                        this.ap2_destPOIHKReturn_725899433();
                        return;
                    }
                }
                return;
            }
            case 401118: {
                return;
            }
            case 401121: {
                switch (n2) {
                    case 0: {
                        this.ap2_destPOIHKReturn_725899433();
                        return;
                    }
                }
                return;
            }
            case 401142: {
                this.ap2_setOnlineMapDataConnectionLicenseStatus_1415795639();
                return;
            }
            case 401144: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1109067264);
                        return;
                    }
                }
                return;
            }
            case 401174: {
                sMServices.addScreenAnimation(16);
                this.ap2_enterDestSelectionContext_725899436();
                return;
            }
            case 401175: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_699132190();
                        return;
                    }
                    case 1: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_184817555();
                        return;
                    }
                }
                return;
            }
            case 401177: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setOnlineMapDataConnectionLicenseStatus(this.smm.getTerminalID(), true, false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setOnlineMapDataConnectionLicenseStatus");
                }
                return;
            }
            case 401179: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_699132190();
                        return;
                    }
                    case 1: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_184817555();
                        return;
                    }
                }
                return;
            }
            case 401186: {
                this.ap2_returnFromConnectivity_2107068339();
                return;
            }
            case 401196: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401205: {
                return;
            }
            case 401206: {
                return;
            }
            case 401207: {
                return;
            }
            case 401208: {
                return;
            }
            case 401209: {
                return;
            }
            case 401212: {
                this.ap2_returnFromConnectivity_2107068339();
                return;
            }
            case 401213: {
                this.ap2_returnFromConnectivityError_2107068339();
                return;
            }
            case 401214: {
                this.ap2_returnFromConnectivityError_2107068339();
                return;
            }
            case 401235: {
                this.ap2_setOnlineMapDataConnectionStatus__842232548();
                return;
            }
            case 401236: {
                this.ap2_returnFromConnectivityError_2107068339();
                return;
            }
            case 401240: {
                return;
            }
            case 401241: {
                return;
            }
            case 401242: {
                return;
            }
            case 401244: {
                return;
            }
            case 401245: {
                return;
            }
            case 401259: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401270: {
                sMServices.showPartialPopup(1176176128);
                return;
            }
            case 401272: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401273: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401277: {
                OnlineActionProxy onlineActionProxy = this.ap3;
                try {
                    onlineActionProxy.remoteHmiSetEntryPoint(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "remoteHmiSetEntryPoint");
                }
                return;
            }
            case 401291: {
                sMServices.showPartialPopup(-48626176);
                return;
            }
            case 401299: {
                sMServices.showPartialPopup(656082432);
                return;
            }
            case 401300: {
                this.ap3_myAudiAuthScreenType_725899433();
                return;
            }
            case 401302: {
                return;
            }
            case 401303: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401304: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 401315: {
                sMServices.hidePartialPopup(1763378688);
                return;
            }
            case 401316: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_699132190();
                        return;
                    }
                    case 1: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_184817555();
                        return;
                    }
                }
                return;
            }
            case 401320: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_1415795639();
                        return;
                    }
                    case 2: {
                        OnlineActionProxy onlineActionProxy;
                        if (((SysConstModel)this.getModel(442)).getValue() != 3) {
                            onlineActionProxy = this.ap3;
                            try {
                                onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "satellitemaps_eb", "Satellite Map");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition '!( ( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP ) )' is not fullfilled, Action is not executed.");
                        }
                        if (((SysConstModel)this.getModel(442)).getValue() == 3) {
                            onlineActionProxy = this.ap3;
                            try {
                                onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "satellitemaps", "Satellite Map");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition '( SysConstModel (MODELID#442) Value == ICoreSysConfig.HU_REGION_JP )' is not fullfilled, Action is not executed.");
                        }
                        this.ap3_remoteHmiMarkForTopLevel_725899433();
                        return;
                    }
                }
                return;
            }
            case 401326: {
                return;
            }
            case 401327: {
                return;
            }
            case 401328: {
                return;
            }
            case 401329: {
                return;
            }
            case 401330: {
                return;
            }
            case 401343: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401355: {
                switch (n2) {
                    case 0: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_699132190();
                        return;
                    }
                    case 1: {
                        this.ap2_setOnlineMapDataConnectionLicenseStatus_184817555();
                        return;
                    }
                }
                return;
            }
            case 401363: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401368: {
                return;
            }
            case 401373: {
                switch (n2) {
                    case 0: {
                        ActionProxy actionProxy = this.ap2;
                        try {
                            actionProxy.onlineSearchEnter(this.smm.getTerminalID(), 0);
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionNaviActionProxy(actionProxy, nullPointerException, "onlineSearchEnter");
                        }
                        if (((ChoiceModel)this.getModel(335)).getValue() < 1) {
                            actionProxy = this.ap3;
                            try {
                                actionProxy.licenseCheckEntered(this.smm.getTerminalID(), "poi_haptic", "Onlinesuche");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#335) Value < 1' is not fullfilled, Action is not executed.");
                        }
                        if (((ChoiceModel)this.getModel(335)).getValue() > 0) {
                            actionProxy = this.ap3;
                            try {
                                actionProxy.licenseCheckEntered(this.smm.getTerminalID(), "poi_sds", "Onlinesuche");
                            }
                            catch (NullPointerException nullPointerException) {
                                this.catchActionExceptionOnlineActionProxy(actionProxy, nullPointerException, "licenseCheckEntered");
                            }
                        } else {
                            this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#335) Value > 0' is not fullfilled, Action is not executed.");
                        }
                        this.ap3_remoteHmiMarkForTopLevel_725899434();
                        return;
                    }
                }
                return;
            }
            case 401382: {
                sMServices.addScreenAnimation(16);
                this.ap2_enterDestSelectionContext_725899436();
                return;
            }
            case 401391: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401393: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401403: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401404: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401427: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401450: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401454: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401457: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401461: {
                return;
            }
            case 401467: {
                return;
            }
            case 401468: {
                return;
            }
            case 401471: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401472: {
                sMServices.addScreenAnimation(64);
                switch (n2) {
                    case 0: {
                        this.ap2_destPOIHKReturn_725899433();
                        return;
                    }
                }
                return;
            }
            case 401492: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401493: {
                sMServices.addScreenAnimation(64);
                switch (n2) {
                    case 0: {
                        this.ap2_destPOIHKReturn_725899433();
                        return;
                    }
                }
                return;
            }
            case 401498: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 401502: {
                this.ap3_remoteHmiClosedViaOptionDrawer_2107068339();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401506: {
                this.ap3_remoteHmiEnter_725899433();
                return;
            }
            case 401511: {
                this.ap3_remoteHmiEnter_725899433();
                return;
            }
            case 401513: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401515: {
                return;
            }
            case 401516: {
                return;
            }
            case 401517: {
                return;
            }
            case 401518: {
                return;
            }
            case 401525: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401530: {
                return;
            }
            case 401531: {
                return;
            }
            case 401532: {
                return;
            }
            case 401539: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401554: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.reenterPOIOnline(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "reenterPOIOnline");
                }
                return;
            }
            case 401556: {
                this.ap3_remoteHmiMarkForTopLevel_725899433();
                return;
            }
            case 401561: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-1927608832);
                        return;
                    }
                }
                return;
            }
            case 401563: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-1927608832);
                        return;
                    }
                }
                return;
            }
            case 401564: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(-1927608832);
                        return;
                    }
                }
                return;
            }
            case 401565: {
                this.ap2_destPOIHKReturn_1804660464();
                return;
            }
            case 401567: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401570: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401580: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401581: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401591: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401595: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.setMapLicenceWeatherMapCheckResChoice(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "setMapLicenceWeatherMapCheckResChoice");
                }
                return;
            }
            case 401599: {
                switch (n2) {
                    case 0: {
                        OnlineActionProxy onlineActionProxy = this.ap3;
                        try {
                            onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "weatherGrid", "Wetter in Karte");
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
                        }
                        this.ap3_remoteHmiMarkForTopLevel_725899433();
                        return;
                    }
                }
                return;
            }
            case 401609: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.weatherMapLicenceActive(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "weatherMapLicenceActive");
                }
                sMServices.addScreenAnimation(32);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 401612: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.weatherMapLicenceActiveKombi(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "weatherMapLicenceActiveKombi");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 401651: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401671: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401672: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 401673: {
                switch (n2) {
                    case 0: {
                        sMServices.addScreenAnimation(32);
                        return;
                    }
                }
                return;
            }
            case 401675: {
                sMServices.addScreenAnimation(2);
                sMServices.setScreenMode(2);
                return;
            }
            case 401676: {
                sMServices.addScreenAnimation(2);
                sMServices.setScreenMode(1);
                return;
            }
            case 401678: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 401680: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401681: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401683: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401684: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401691: {
                return;
            }
            case 401692: {
                return;
            }
            case 401699: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401704: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 401707: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401712: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401714: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401720: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 401721: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 401732: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 1206);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
                }
                return;
            }
            case 401733: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401736: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401753: {
                sMServices.showPartialPopup(-434436608);
                return;
            }
            case 401760: {
                this.ap3_remoteHmiClosedViaOptionDrawer_2107068339();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401765: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401766: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401767: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401768: {
                return;
            }
            case 401769: {
                this.ap2_destPOIHKReturn_725899434();
                return;
            }
            case 401770: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destPOIHKReturn(this.smm.getTerminalID(), 701);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destPOIHKReturn");
                }
                return;
            }
            case 401772: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401774: {
                if (((ChoiceModel)this.getModel(-1273166336)).getValue() == 1) {
                    sMServices.showPartialPopup(1578829312);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#400820) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(-1273166336)).getValue() != 1) {
                    sMServices.hidePartialPopup(1578829312);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition '!( ChoiceModel (MODELID#400820) Value == 1 )' is not fullfilled, Action is not executed.");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 401784: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401785: {
                return;
            }
            case 401786: {
                return;
            }
            case 401787: {
                return;
            }
            case 401788: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401791: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401793: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401803: {
                this.ap2_enterPoiMainScreen_2107068339();
                return;
            }
            case 401808: {
                sMServices.hidePartialPopup(-1927608832);
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401809: {
                sMServices.hidePartialPopup(-1927608832);
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401814: {
                sMServices.hidePartialPopup(-1927608832);
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401819: {
                NaviActionProxy naviActionProxy = this.ap2;
                try {
                    naviActionProxy.destTpegPOIHKReturn(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionNaviActionProxy(naviActionProxy, nullPointerException, "destTpegPOIHKReturn");
                }
                return;
            }
            case 401831: {
                sMServices.showPartialPopup(-233110016);
                return;
            }
            case 401833: {
                sMServices.showPartialPopup(-216332800);
                return;
            }
            case 401836: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401837: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401840: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 401851: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-501545472);
                        return;
                    }
                }
                return;
            }
            case 401852: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-501545472);
                        return;
                    }
                }
                return;
            }
            case 401858: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401859: {
                this.ap2_destAddressInputHKReturn_2107068339();
                return;
            }
            case 401860: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1578829312);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1578829312);
                        return;
                    }
                }
                return;
            }
            case 401861: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1578829312);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1578829312);
                        return;
                    }
                }
                return;
            }
            case 401870: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1578829312);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1578829312);
                        return;
                    }
                }
                return;
            }
            case 401871: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1578829312);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1578829312);
                        return;
                    }
                }
                return;
            }
            case 401872: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1578829312);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1578829312);
                        return;
                    }
                }
                return;
            }
            case 401878: {
                switch (n2) {
                    case 2: {
                        sMServices.showPartialPopup(1763378688);
                        return;
                    }
                }
                return;
            }
            case 401879: {
                sMServices.hidePartialPopup(1763378688);
                return;
            }
            case 401880: {
                switch (n2) {
                    case 2: {
                        sMServices.showPartialPopup(1763378688);
                        return;
                    }
                }
                return;
            }
            case 401884: {
                this.ap2_destPOIHKReturn_1028046024();
                return;
            }
            case 401886: {
                sMServices.showPartialPopup(-132446720);
                return;
            }
            case 401891: {
                this.ap2_enterPoiMainScreen_2107068339();
                return;
            }
            case 401903: {
                sMServices.hidePartialPopup(-132512256);
                sMServices.hidePartialPopup(-820378112);
                sMServices.hidePartialPopup(-65403392);
                this.ap2_destPOIHKReturn_1028046024();
                this.ap2_destExitStartGuidancePopup_2107068339();
                return;
            }
            case 401908: {
                TrafficInfoJPActionProxy trafficInfoJPActionProxy = this.ap8;
                try {
                    trafficInfoJPActionProxy.vicsGlobalShowInMapLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTrafficInfoJPActionProxy(trafficInfoJPActionProxy, nullPointerException, "vicsGlobalShowInMapLeft");
                }
                return;
            }
            case 401923: {
                sMServices.showPartialPopup(-115735040);
                return;
            }
            case 401924: {
                sMServices.addScreenAnimation(2);
                return;
            }
            case 401932: {
                this.ap2_destPOIHKReturn_725899433();
                return;
            }
            case 401935: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401940: {
                if (((ChoiceModel)this.getModel(958727680)).getValue() == 1) {
                    sMServices.showPartialPopup(191);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#402745) Value == 1' is not fullfilled, Action is not executed.");
                }
                if (((ChoiceModel)this.getModel(958727680)).getValue() == 0) {
                    sMServices.hidePartialPopup(191);
                } else {
                    this.logChannel.log(1078071040, "Action-Condition 'ChoiceModel (MODELID#402745) Value == 0' is not fullfilled, Action is not executed.");
                }
                switch (n2) {
                    default: 
                }
                return;
            }
            case 401957: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap9;
                try {
                    custDownloadActionProxy.swdlCustomerUpdateEnteredFromNavi(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEnteredFromNavi");
                }
                return;
            }
            case 401958: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401965: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap9;
                try {
                    custDownloadActionProxy.swdlCustomerUpdateEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEntered");
                }
                return;
            }
            case 401968: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401969: {
                this.ap3_myAudiAuthScreenType_725899434();
                return;
            }
            case 401975: {
                sMServices.hidePartialPopup(-199621120);
                sMServices.hidePartialPopup(-468056576);
                return;
            }
            case 401976: {
                switch (n2) {
                    case 1: {
                        sMServices.hidePartialPopup(656082432);
                        sMServices.hidePartialPopup(1260062208);
                        sMServices.hidePartialPopup(-468056576);
                        return;
                    }
                }
                return;
            }
            case 401984: {
                ConnectivityActionProxy connectivityActionProxy = this.ap6;
                try {
                    connectivityActionProxy.connectivityBlueApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityBlueApplicationContext");
                }
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401985: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 401987: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401988: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401989: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 401995: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 401996: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 401997: {
                sMServices.addScreenAnimation(128);
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


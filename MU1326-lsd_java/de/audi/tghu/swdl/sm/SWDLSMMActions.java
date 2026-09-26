/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.SWDLActionProxy;

public class SWDLSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile SWDLActionProxy ap0;
    private volatile EntertainmentActionProxy ap1;
    private volatile CustDownloadActionProxy ap2;
    private volatile ConnectivityActionProxy ap3;
    private volatile OnlineActionProxy ap4;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 22, 26, 15, 11};

    protected SWDLSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap3 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof SWDLActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "SWDLActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap4 = null;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap2 = (CustDownloadActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap3 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof SWDLActionProxy) {
            this.ap0 = (SWDLActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "SWDLActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap4 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap4;
        }
        return null;
    }

    private void catchActionExceptionEntertainmentActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EntertainmentActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EntertainmentActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionCustDownloadActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CustDownloadActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'CustDownloadActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionSWDLActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'SWDLActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'SWDLActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
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

    private void ap0_swdlModuleSelectLeft_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlModuleSelectLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlModuleSelectLeft");
        }
    }

    private void ap0_swdlAppBlSelectLeft_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlAppBlSelectLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlAppBlSelectLeft");
        }
    }

    private void ap0_swdlDeviceSelectLeft_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlDeviceSelectLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlDeviceSelectLeft");
        }
    }

    private void ap2_leaveCustomerUpdatePopups_725899433() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap2;
        try {
            custDownloadActionProxy.leaveCustomerUpdatePopups(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "leaveCustomerUpdatePopups");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 1700006: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlProgressExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlProgressExit");
                }
                return;
            }
            case 1700013: {
                sMServices.popDrawerIDs();
                return;
            }
            case 1700014: {
                sMServices.removeContext(0);
                sMServices.popDrawerIDs();
                return;
            }
            case 1700024: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlSummaryExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlSummaryExit");
                }
                return;
            }
            case 1700026: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlStopWaitLostDevices(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlStopWaitLostDevices");
                }
                return;
            }
            case 1700031: {
                sMServices.popDrawerIDs();
                return;
            }
            case 1700032: {
                sMServices.popDrawerIDs();
                return;
            }
            case 1700035: {
                this.ap0_swdlModuleSelectLeft_2107068339();
                return;
            }
            case 1700036: {
                this.ap0_swdlAppBlSelectLeft_2107068339();
                return;
            }
            case 1700039: {
                this.ap0_swdlDeviceSelectLeft_2107068339();
                sMServices.popDrawerIDs();
                return;
            }
            case 1700040: {
                sMServices.popDrawerIDs();
                return;
            }
            case 1700058: {
                this.ap0_swdlAppBlSelectLeft_2107068339();
                return;
            }
            case 1700061: {
                this.ap0_swdlModuleSelectLeft_2107068339();
                return;
            }
            case 1700069: {
                this.ap2_swdlCustomerUpdateLeft_2107068339();
                return;
            }
            case 1700085: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap2;
                try {
                    custDownloadActionProxy.leaveCustomerUpdatePopups(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "leaveCustomerUpdatePopups");
                }
                return;
            }
            case 1700087: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap2;
                try {
                    custDownloadActionProxy.leaveCustomerUpdatePopups(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "leaveCustomerUpdatePopups");
                }
                return;
            }
            case 1700089: {
                this.ap2_leaveCustomerUpdatePopups_725899433();
                return;
            }
            case 1700097: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlExit");
                }
                return;
            }
            case 1700101: {
                ConnectivityActionProxy connectivityActionProxy = this.ap3;
                try {
                    connectivityActionProxy.connectivityDataOnlineAppLeft(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppLeft");
                }
                return;
            }
            case 1700118: {
                this.ap0_swdlAppBlSelectLeft_2107068339();
                return;
            }
            case 1700120: {
                this.ap0_swdlDeviceSelectLeft_2107068339();
                return;
            }
            case 1700122: {
                this.ap0_swdlModuleSelectLeft_2107068339();
                return;
            }
            case 1700124: {
                sMServices.removeContext(-210598829L);
                return;
            }
            case 1700174: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlLeaveSummaryChanged(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlLeaveSummaryChanged");
                }
                return;
            }
            case 1700188: {
                this.ap2_leaveCustomerUpdatePopups_725899433();
                return;
            }
            case 1700190: {
                this.ap2_leaveCustomerUpdatePopups_725899433();
                return;
            }
            case 1700201: {
                sMServices.popDrawerIDs();
                sMServices.removeContext(0);
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_swdlModuleSelectEntered_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlModuleSelectEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlModuleSelectEntered");
        }
    }

    private void ap2_readyForCustomerUpdate_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap2;
        try {
            custDownloadActionProxy.readyForCustomerUpdate(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "readyForCustomerUpdate");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 1700006: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlProgressEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlProgressEntered");
                }
                sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlTriggerEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlTriggerEntered");
                }
                return;
            }
            case 1700013: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 1700014: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(0);
                return;
            }
            case 1700026: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlStartWaitLostDevices(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlStartWaitLostDevices");
                }
                return;
            }
            case 1700028: {
                EntertainmentActionProxy entertainmentActionProxy = this.ap1;
                try {
                    entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
                }
                return;
            }
            case 1700029: {
                sMServices.setColor(1);
                EntertainmentActionProxy entertainmentActionProxy = this.ap1;
                try {
                    entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), -2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
                }
                return;
            }
            case 1700031: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 1700032: {
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 1700035: {
                this.ap0_swdlModuleSelectEntered_2107068339();
                return;
            }
            case 1700039: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 1700040: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 1700061: {
                this.ap0_swdlModuleSelectEntered_2107068339();
                return;
            }
            case 1700070: {
                this.ap2_readyForCustomerUpdate_2107068339();
                return;
            }
            case 1700077: {
                this.ap2_readyForCustomerUpdate_2107068339();
                return;
            }
            case 1700097: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlEntered");
                }
                return;
            }
            case 1700101: {
                ConnectivityActionProxy connectivityActionProxy = this.ap3;
                try {
                    connectivityActionProxy.connectivityDataOnlineAppEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityDataOnlineAppEntered");
                }
                return;
            }
            case 1700122: {
                this.ap0_swdlModuleSelectEntered_2107068339();
                return;
            }
            case 1700124: {
                sMServices.addContext(-210598829L);
                return;
            }
            case 1700141: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap2;
                try {
                    custDownloadActionProxy.swdlEnterUota(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlEnterUota");
                }
                return;
            }
            case 1700149: {
                sMServices.setColor(0);
                return;
            }
            case 1700159: {
                sMServices.setColor(0);
                return;
            }
            case 1700161: {
                sMServices.setColor(0);
                return;
            }
            case 1700163: {
                sMServices.setColor(0);
                return;
            }
            case 1700165: {
                sMServices.setColor(0);
                return;
            }
            case 1700167: {
                sMServices.setColor(0);
                return;
            }
            case 1700169: {
                sMServices.setColor(0);
                return;
            }
            case 1700171: {
                sMServices.setColor(0);
                return;
            }
            case 1700174: {
                sMServices.setColor(1);
                return;
            }
            case 1700201: {
                sMServices.pushDrawerIDs(0L, 0);
                sMServices.addContext(0);
                return;
            }
        }
    }

    private void ap0_swdlSummaryEntered_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlSummaryEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlSummaryEntered");
        }
    }

    private void ap0_swdlDeviceSelectEntered_2107068339() {
        SWDLActionProxy sWDLActionProxy = this.ap0;
        try {
            sWDLActionProxy.swdlDeviceSelectEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlDeviceSelectEntered");
        }
    }

    private void ap2_abortSelection_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap2;
        try {
            custDownloadActionProxy.abortSelection(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "abortSelection");
        }
    }

    private void ap2_swdlCustomerUpdateLeft_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap2;
        try {
            custDownloadActionProxy.swdlCustomerUpdateLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateLeft");
        }
    }

    private void ap2_swdlCustomerUpdateEntered_2107068339() {
        CustDownloadActionProxy custDownloadActionProxy = this.ap2;
        try {
            custDownloadActionProxy.swdlCustomerUpdateEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "swdlCustomerUpdateEntered");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 1700002: {
                this.ap0_swdlSummaryEntered_2107068339();
                return;
            }
            case 1700011: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlInterruptDownload(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlInterruptDownload");
                }
                return;
            }
            case 1700015: {
                switch (n2) {
                    case 0: {
                        SWDLActionProxy sWDLActionProxy = this.ap0;
                        try {
                            sWDLActionProxy.swdlSelectOneRelease(this.smm.getTerminalID());
                        }
                        catch (NullPointerException nullPointerException) {
                            this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlSelectOneRelease");
                        }
                        return;
                    }
                }
                return;
            }
            case 1700022: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlAbortReadingReleases(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlAbortReadingReleases");
                }
                return;
            }
            case 1700027: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700028: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlAbortReadingMetainfo(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlAbortReadingMetainfo");
                }
                return;
            }
            case 1700033: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700034: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700035: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700040: {
                switch (n2) {
                    case 1: {
                        this.ap0_swdlSummaryEntered_2107068339();
                        return;
                    }
                }
                return;
            }
            case 1700041: {
                switch (n2) {
                    case 1: {
                        this.ap0_swdlSummaryEntered_2107068339();
                        return;
                    }
                }
                return;
            }
            case 1700044: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlTriggerExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlTriggerExit");
                }
                return;
            }
            case 1700062: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700064: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlLeavePopupByHKReturn(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlLeavePopupByHKReturn");
                }
                return;
            }
            case 1700065: {
                sMServices.setColor(1);
                return;
            }
            case 1700073: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlLoggingEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlLoggingEntered");
                }
                sMServices.addScreenAnimation(8);
                return;
            }
            case 1700074: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700075: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 1700120: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700124: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700146: {
                this.ap2_abortSelection_2107068339();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 1700160: {
                sMServices.setColor(0);
                return;
            }
            case 1700164: {
                sMServices.setColor(0);
                return;
            }
            case 1700166: {
                sMServices.setColor(0);
                return;
            }
            case 1700173: {
                this.ap0_swdlSummaryEntered_2107068339();
                return;
            }
            case 1700179: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(821106944);
                        return;
                    }
                }
                return;
            }
            case 1700187: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlProgressDetailEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlProgressDetailEntered");
                }
                return;
            }
            case 1700188: {
                SWDLActionProxy sWDLActionProxy = this.ap0;
                try {
                    sWDLActionProxy.swdlProgressDetailExit(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSWDLActionProxy(sWDLActionProxy, nullPointerException, "swdlProgressDetailExit");
                }
                return;
            }
            case 1700229: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 1700248: {
                sMServices.setColor(0);
                return;
            }
            case 1700250: {
                sMServices.setColor(0);
                return;
            }
            case 1700252: {
                sMServices.setColor(0);
                return;
            }
            case 0x19F19F: {
                sMServices.setColor(0);
                return;
            }
            case 1700269: {
                this.ap0_swdlDeviceSelectEntered_2107068339();
                return;
            }
            case 1700346: {
                sMServices.setColor(0);
                return;
            }
            case 1700347: {
                sMServices.setColor(0);
                return;
            }
            case 1700353: {
                sMServices.setColor(0);
                return;
            }
            case 1700359: {
                sMServices.setColor(0);
                return;
            }
            case 1700361: {
                sMServices.setColor(0);
                return;
            }
            case 1700387: {
                sMServices.setColor(0);
                return;
            }
            case 1700391: {
                CustDownloadActionProxy custDownloadActionProxy = this.ap2;
                try {
                    custDownloadActionProxy.leaveCustomerUpdate(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(custDownloadActionProxy, nullPointerException, "leaveCustomerUpdate");
                }
                return;
            }
            case 1700392: {
                this.ap2_abortSelection_2107068339();
                return;
            }
            case 1700400: {
                sMServices.hidePartialPopup(821106944);
                return;
            }
            case 1700401: {
                this.ap2_swdlCustomerUpdateLeft_2107068339();
                return;
            }
            case 1700403: {
                this.ap2_swdlCustomerUpdateEntered_2107068339();
                return;
            }
            case 1700404: {
                this.ap2_swdlCustomerUpdateEntered_2107068339();
                return;
            }
            case 1700405: {
                this.ap2_swdlCustomerUpdateEntered_2107068339();
                OnlineActionProxy onlineActionProxy = this.ap4;
                try {
                    onlineActionProxy.destOnlineStartDestinationImport(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "destOnlineStartDestinationImport");
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


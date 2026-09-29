/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.CarActionProxy;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.atip.statemachine.ap.EarlyAppsActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.FrameworkActionProxy;
import de.audi.atip.statemachine.ap.MMICombiActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.SettingsActionProxy;

public class CarSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile MMICombiActionProxy ap0;
    private volatile CarActionProxy ap1;
    private volatile OnlineActionProxy ap2;
    private volatile EntertainmentActionProxy ap3;
    private volatile FrameworkActionProxy ap4;
    private volatile EarlyAppsActionProxy ap5;
    private volatile SettingsActionProxy ap6;
    private volatile CustDownloadActionProxy ap7;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{2, 3, 25, 22, 4, 16, 11, 23};

    protected CarSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof CarActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "CarActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EarlyAppsActionProxy) {
            this.ap5 = null;
            this.logChannel.log(-2137614336, "EarlyAppsActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap3 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap7 = null;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap4 = null;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof SettingsActionProxy) {
            this.ap6 = null;
            this.logChannel.log(-2137614336, "SettingsActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof CarActionProxy) {
            this.ap1 = (CarActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CarActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof EarlyAppsActionProxy) {
            this.ap5 = (EarlyAppsActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EarlyAppsActionProxy Action Proxy added");
            return this.ap5;
        }
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap3 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap3;
        }
        if (actionProxy instanceof CustDownloadActionProxy) {
            this.ap7 = (CustDownloadActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "CustDownloadActionProxy Action Proxy added");
            return this.ap7;
        }
        if (actionProxy instanceof FrameworkActionProxy) {
            this.ap4 = (FrameworkActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "FrameworkActionProxy Action Proxy added");
            return this.ap4;
        }
        if (actionProxy instanceof SettingsActionProxy) {
            this.ap6 = (SettingsActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "SettingsActionProxy Action Proxy added");
            return this.ap6;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "OnlineActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof MMICombiActionProxy) {
            this.ap0 = (MMICombiActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "MMICombiActionProxy Action Proxy added");
            return this.ap0;
        }
        return null;
    }

    private void catchActionExceptionCarActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'CarActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'CarActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionEarlyAppsActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EarlyAppsActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EarlyAppsActionProxy' missing for call '%1'", (Object)string);
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

    private void catchActionExceptionFrameworkActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'FrameworkActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'FrameworkActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionSettingsActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'SettingsActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'SettingsActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionMMICombiActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'MMICombiActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'MMICombiActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            case 604115: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaMenuStateChange(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaMenuStateChange");
                }
                return;
            }
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            case 604115: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaMenuStateChange(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaMenuStateChange");
                }
                return;
            }
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 600002: {
                sMServices.removeContext(0);
                return;
            }
            case 600003: {
                sMServices.removeContext(0);
                return;
            }
            case 600004: {
                sMServices.removeContext(-1734813716L);
                return;
            }
            case 600006: {
                sMServices.removeContext(0);
                return;
            }
            case 600007: {
                sMServices.removeContext(0);
                return;
            }
            case 600009: {
                sMServices.removeContext(0);
                return;
            }
            case 600010: {
                sMServices.removeContext(0);
                return;
            }
            case 600013: {
                sMServices.addContext(0);
                return;
            }
            case 600016: {
                sMServices.removeContext(0);
                return;
            }
            case 600021: {
                sMServices.removeContext(0);
                return;
            }
            case 600022: {
                sMServices.removeContext(0);
                return;
            }
            case 600024: {
                sMServices.removeContext(0);
                return;
            }
            case 600027: {
                sMServices.removeContext(0);
                return;
            }
            case 600029: {
                sMServices.removeContext(0);
                return;
            }
            case 600030: {
                sMServices.removeContext(0);
                return;
            }
            case 600031: {
                sMServices.removeContext(1L);
                return;
            }
            case 600032: {
                sMServices.removeContext(0);
                return;
            }
            case 600033: {
                sMServices.removeContext(0);
                return;
            }
            case 600034: {
                sMServices.removeContext(0);
                return;
            }
            case 600036: {
                sMServices.removeContext(0);
                return;
            }
            case 600039: {
                sMServices.removeContext(-288962771L);
                return;
            }
            case 600047: {
                sMServices.removeContext(-1734813716L);
                return;
            }
            case 600061: {
                sMServices.removeContext(0);
                return;
            }
            case 600064: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.codriverMovementByDriverScreenExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "codriverMovementByDriverScreenExited");
                }
                return;
            }
            case 600067: {
                sMServices.removeContext(0);
                return;
            }
            case 600072: {
                sMServices.removeContext(0);
                return;
            }
            case 600073: {
                sMServices.removeContext(-1734813716L);
                return;
            }
            case 600083: {
                sMServices.popDrawerIDs();
                return;
            }
            case 600097: {
                sMServices.removeContext(0);
                return;
            }
            case 600099: {
                sMServices.removeContext(0);
                return;
            }
            case 600115: {
                this.ap1_ugdoAbort_2107068339();
                return;
            }
            case 600119: {
                this.ap1_ugdoAbort_2107068339();
                return;
            }
            case 600127: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.browserScreenExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "browserScreenExited");
                }
                return;
            }
            case 600131: {
                sMServices.popDrawerIDs();
                return;
            }
            case 600134: {
                sMServices.removeContext(-1246329379L);
                return;
            }
            case 600136: {
                sMServices.removeContext(0L);
                return;
            }
            case 600137: {
                sMServices.popDrawerIDs();
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaExited(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaExited");
                }
                return;
            }
            case 600140: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.browserScreenEndMediaPlayback(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(actionProxy, nullPointerException, "browserScreenEndMediaPlayback");
                }
                sMServices.popDrawerIDs();
                actionProxy = this.ap3;
                try {
                    actionProxy.entertainmentBlacklist(this.smm.getTerminalID(), -1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(actionProxy, nullPointerException, "entertainmentBlacklist");
                }
                return;
            }
            case 600152: {
                sMServices.popDrawerIDs();
                return;
            }
            case 600153: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 600157: {
                sMServices.removeContext(0);
                return;
            }
            case 600170: {
                sMServices.popDrawerIDs();
                return;
            }
            case 600178: {
                sMServices.popDrawerIDs();
                return;
            }
            case 600192: {
                sMServices.removeContext(0);
                return;
            }
            case 600203: {
                sMServices.removeContext(0);
                sMServices.removeContext(0);
                return;
            }
            case 604115: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaMenuStateChange(this.smm.getTerminalID(), 2);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaMenuStateChange");
                }
                return;
            }
            case 604116: {
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 604121: {
                sMServices.removeContext(0);
                return;
            }
            case 604128: {
                sMServices.removeContext(0);
                return;
            }
            case 604130: {
                sMServices.removeContext(-920831887L);
                return;
            }
            case 604139: {
                sMServices.removeContext(-920831887L);
                return;
            }
            case 604140: {
                sMServices.removeContext(0);
                return;
            }
            case 604147: {
                sMServices.removeContext(0);
                return;
            }
            case 604148: {
                sMServices.removeContext(0);
                return;
            }
            case 604167: {
                sMServices.popDrawerIDs();
                EarlyAppsActionProxy earlyAppsActionProxy = this.ap5;
                try {
                    earlyAppsActionProxy.carMenusEnteredEarly(this.smm.getTerminalID(), false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEarlyAppsActionProxy(earlyAppsActionProxy, nullPointerException, "carMenusEnteredEarly");
                }
                return;
            }
            case 604168: {
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

    private void ap0_setMMICombiContext_1804655753() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 132);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap1_setCarContext_725899434() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.setCarContext(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
        }
    }

    private void ap0_setMMICombiContext_1804655752() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 131);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap1_setCarContext_725899435() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.setCarContext(this.smm.getTerminalID(), 2);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
        }
    }

    private void ap0_setMMICombiContext_1804655756() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 135);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap1_setCarContext_725899438() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.setCarContext(this.smm.getTerminalID(), 5);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
        }
    }

    private void ap1_setCarContext_725899436() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.setCarContext(this.smm.getTerminalID(), 3);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
        }
    }

    private void ap1_setCarContext_725899437() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.setCarContext(this.smm.getTerminalID(), 4);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
        }
    }

    private void ap0_setMMICombiContext_1804655755() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 134);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 600002: {
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                this.ap1_setCarContext_725899434();
                return;
            }
            case 600003: {
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                this.ap1_setCarContext_725899435();
                return;
            }
            case 600004: {
                this.ap0_setMMICombiContext_1804655756();
                sMServices.addContext(-1734813716L);
                this.ap1_setCarContext_725899438();
                return;
            }
            case 600006: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600007: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600009: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600010: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600013: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600014: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                return;
            }
            case 600016: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600021: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600022: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600024: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.jokerKeyPopupActive(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "jokerKeyPopupActive");
                }
                return;
            }
            case 600025: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600026: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600027: {
                MMICombiActionProxy mMICombiActionProxy = this.ap0;
                try {
                    mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 133);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.addContext(0);
                this.ap1_setCarContext_725899436();
                return;
            }
            case 600029: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600030: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600031: {
                this.ap1_setCarContext_725899434();
                sMServices.addContext(0);
                return;
            }
            case 600032: {
                sMServices.addContext(0);
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                return;
            }
            case 600033: {
                sMServices.addContext(0);
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                return;
            }
            case 600034: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600036: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600038: {
                this.ap1_setCarContext_725899437();
                this.ap0_setMMICombiContext_1804655755();
                return;
            }
            case 600039: {
                this.ap0_setMMICombiContext_1804655755();
                sMServices.addContext(-288962771L);
                this.ap1_setCarContext_725899437();
                return;
            }
            case 600043: {
                OnlineActionProxy onlineActionProxy = this.ap2;
                try {
                    onlineActionProxy.requestMobileDeviceKeyCount(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "requestMobileDeviceKeyCount");
                }
                return;
            }
            case 600047: {
                sMServices.addContext(-1734813716L);
                this.ap1_setCarContext_725899438();
                this.ap0_setMMICombiContext_1804655756();
                return;
            }
            case 600049: {
                sMServices.setScreenMode(1);
                return;
            }
            case 600050: {
                sMServices.setScreenMode(1);
                return;
            }
            case 600055: {
                sMServices.setColor(1);
                return;
            }
            case 600057: {
                sMServices.setColor(1);
                return;
            }
            case 600059: {
                sMServices.setColor(1);
                return;
            }
            case 600061: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600064: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.codriverMovementByDriverScreenEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "codriverMovementByDriverScreenEntered");
                }
                return;
            }
            case 600067: {
                this.ap1_setCarContext_725899436();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600072: {
                this.ap1_setCarContext_725899436();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600073: {
                this.ap1_setCarContext_725899438();
                this.ap0_setMMICombiContext_1804655756();
                sMServices.addContext(-1734813716L);
                return;
            }
            case 600075: {
                this.ap1_setCarContext_725899438();
                this.ap0_setMMICombiContext_1804655756();
                return;
            }
            case 600079: {
                this.ap1_setCarContext_725899438();
                this.ap0_setMMICombiContext_1804655756();
                return;
            }
            case 600080: {
                this.ap1_setCarContext_725899438();
                this.ap0_setMMICombiContext_1804655756();
                return;
            }
            case 600083: {
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 600097: {
                this.ap1_setCarContext_725899436();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 600099: {
                sMServices.addContext(0);
                return;
            }
            case 600121: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600122: {
                this.ap1_resetTruffleSelection_2107068339();
                this.ap0_setMMICombiContext_1804655881();
                return;
            }
            case 600124: {
                sMServices.setColor(1);
                return;
            }
            case 600126: {
                sMServices.setColor(1);
                return;
            }
            case 600127: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.browserScreenEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "browserScreenEntered");
                }
                return;
            }
            case 600131: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 139);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                actionProxy = this.ap1;
                try {
                    actionProxy.setCarContext(this.smm.getTerminalID(), 6);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(actionProxy, nullPointerException, "setCarContext");
                }
                return;
            }
            case 600134: {
                ActionProxy actionProxy = this.ap0;
                try {
                    actionProxy.setMMICombiContext(this.smm.getTerminalID(), 136);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionMMICombiActionProxy(actionProxy, nullPointerException, "setMMICombiContext");
                }
                sMServices.addContext(-1246329379L);
                actionProxy = this.ap1;
                try {
                    actionProxy.setCarContext(this.smm.getTerminalID(), 0);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(actionProxy, nullPointerException, "setCarContext");
                }
                return;
            }
            case 600136: {
                sMServices.addContext(-1246329379L);
                return;
            }
            case 600137: {
                sMServices.setColor(1);
                sMServices.pushDrawerIDs(-1L, 0);
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaEntered");
                }
                return;
            }
            case 600139: {
                sMServices.setColor(1);
                return;
            }
            case 600140: {
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.browserScreenStartMediaPlayback(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(actionProxy, nullPointerException, "browserScreenStartMediaPlayback");
                }
                sMServices.pushDrawerIDs(0, 0L);
                actionProxy = this.ap3;
                try {
                    actionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 7001);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(actionProxy, nullPointerException, "entertainmentBlacklist");
                }
                return;
            }
            case 600143: {
                sMServices.setColor(1);
                return;
            }
            case 600152: {
                sMServices.setColor(1);
                sMServices.pushDrawerIDs(0L, 0);
                return;
            }
            case 600153: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 600155: {
                sMServices.setColor(1);
                return;
            }
            case 600157: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600168: {
                this.ap1_setCarContext_725899437();
                this.ap0_setMMICombiContext_1804655755();
                return;
            }
            case 600170: {
                sMServices.pushDrawerIDs(0, 0L);
                return;
            }
            case 600178: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 600179: {
                sMServices.pushDrawerIDs(0, 0);
                return;
            }
            case 600192: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 600203: {
                sMServices.addContext(0);
                this.ap1_setCarContext_725899437();
                return;
            }
            case 604115: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.charismaMenuStateChange(this.smm.getTerminalID(), 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "charismaMenuStateChange");
                }
                return;
            }
            case 604116: {
                sMServices.popDrawerIDs();
                return;
            }
            case 604121: {
                sMServices.addContext(0);
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.setCarContext(this.smm.getTerminalID(), 8);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
                }
                return;
            }
            case 604128: {
                sMServices.addContext(0);
                this.ap1_setCarContext_725899437();
                return;
            }
            case 604130: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.setCarContext(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
                }
                sMServices.addContext(-920831887L);
                return;
            }
            case 604139: {
                sMServices.addContext(-920831887L);
                return;
            }
            case 604140: {
                this.ap1_setCarContext_725899434();
                this.ap0_setMMICombiContext_1804655753();
                sMServices.addContext(0);
                return;
            }
            case 604147: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.setCarContext(this.smm.getTerminalID(), 9);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "setCarContext");
                }
                return;
            }
            case 604148: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
            case 604163: {
                sMServices.setScreenMode(1);
                return;
            }
            case 604164: {
                sMServices.setScreenMode(1);
                return;
            }
            case 604167: {
                ActionProxy actionProxy = this.ap4;
                try {
                    actionProxy.activeApplication(this.smm.getTerminalID(), 7);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionFrameworkActionProxy(actionProxy, nullPointerException, "activeApplication");
                }
                sMServices.pushDrawerIDs(0, 0);
                actionProxy = this.ap5;
                try {
                    actionProxy.carMenusEnteredEarly(this.smm.getTerminalID(), true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEarlyAppsActionProxy(actionProxy, nullPointerException, "carMenusEnteredEarly");
                }
                sMServices.setColor(1);
                return;
            }
            case 604168: {
                this.ap1_setCarContext_725899435();
                this.ap0_setMMICombiContext_1804655752();
                sMServices.addContext(0);
                return;
            }
        }
    }

    private void ap0_setMMICombiContext_1804655881() {
        MMICombiActionProxy mMICombiActionProxy = this.ap0;
        try {
            mMICombiActionProxy.setMMICombiContext(this.smm.getTerminalID(), 176);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMMICombiActionProxy(mMICombiActionProxy, nullPointerException, "setMMICombiContext");
        }
    }

    private void ap1_resetTruffleSelection_2107068339() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.resetTruffleSelection(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "resetTruffleSelection");
        }
    }

    private void ap1_ugdoAbort_2107068339() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.ugdoAbort(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "ugdoAbort");
        }
    }

    private void ap1_ugdoSync_2107068339() {
        CarActionProxy carActionProxy = this.ap1;
        try {
            carActionProxy.ugdoSync(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "ugdoSync");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 600000: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600001: {
                this.ap1_resetTruffleSelection_2107068339();
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600002: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600003: {
                this.ap1_resetTruffleSelection_2107068339();
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600029: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600140: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.ugdoRestart(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "ugdoRestart");
                }
                return;
            }
            case 600146: {
                switch (n2) {
                    case 0: {
                        this.ap1_ugdoAbort_2107068339();
                        return;
                    }
                }
                return;
            }
            case 600169: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600245: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600249: {
                sMServices.setColor(0);
                ActionProxy actionProxy = this.ap6;
                try {
                    actionProxy.enterInstructionBookUpdate(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionSettingsActionProxy(actionProxy, nullPointerException, "enterInstructionBookUpdate");
                }
                actionProxy = this.ap7;
                try {
                    actionProxy.swdlCustomerUpdateEntered(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCustDownloadActionProxy(actionProxy, nullPointerException, "swdlCustomerUpdateEntered");
                }
                return;
            }
            case 600256: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600269: {
                sMServices.showPartialPopup(1311246592);
                return;
            }
            case 600273: {
                CarActionProxy carActionProxy = this.ap1;
                try {
                    carActionProxy.jokerKeyPopupActive(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionCarActionProxy(carActionProxy, nullPointerException, "jokerKeyPopupActive");
                }
                return;
            }
            case 600274: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600275: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600276: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600277: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600278: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600279: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600283: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 600284: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600290: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600291: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600292: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600293: {
                sMServices.addScreenAnimation(16);
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600295: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1042811136);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(1059588352);
                        return;
                    }
                }
                return;
            }
            case 600298: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600300: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600303: {
                this.ap1_resetTruffleSelection_2107068339();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 600304: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600305: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600306: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600307: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600308: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600316: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600323: {
                sMServices.showPartialPopup(1227360512);
                return;
            }
            case 600329: {
                return;
            }
            case 600330: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600334: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600340: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600341: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600359: {
                sMServices.hidePartialPopup(371722496);
                return;
            }
            case 600360: {
                sMServices.hidePartialPopup(388499712);
                return;
            }
            case 600364: {
                sMServices.addScreenAnimation(128);
                sMServices.setScreenMode(1);
                return;
            }
            case 600365: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600371: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 600375: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600380: {
                sMServices.showPartialPopup(1311246592);
                return;
            }
            case 600385: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1395132672);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1395132672);
                        return;
                    }
                }
                return;
            }
            case 600387: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1395132672);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1395132672);
                        return;
                    }
                }
                return;
            }
            case 600388: {
                sMServices.hidePartialPopup(1227360512);
                return;
            }
            case 600391: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600392: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600393: {
                sMServices.addScreenAnimation(16);
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600395: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600405: {
                this.ap1_ugdoSync_2107068339();
                return;
            }
            case 600422: {
                this.ap1_ugdoAbort_2107068339();
                return;
            }
            case 600424: {
                this.ap1_ugdoSync_2107068339();
                sMServices.addScreenAnimation(32);
                return;
            }
            case 600433: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600443: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600480: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(-785905408);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(-769128192);
                        return;
                    }
                }
                return;
            }
            case 600481: {
                sMServices.hidePartialPopup(-785905408);
                return;
            }
            case 600483: {
                sMServices.hidePartialPopup(-769128192);
                return;
            }
            case 600488: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600490: {
                sMServices.showPartialPopup(1292574720);
                return;
            }
            case 600491: {
                this.ap1_resetTruffleSelection_2107068339();
                return;
            }
            case 600496: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600497: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600500: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600501: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 600513: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600524: {
                sMServices.addScreenAnimation(8);
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 600532: {
                sMServices.addScreenAnimation(128);
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 600536: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(1395132672);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(1395132672);
                        return;
                    }
                }
                return;
            }
            case 600545: {
                sMServices.addScreenAnimation(32);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 600547: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 600548: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 600549: {
                sMServices.addScreenAnimation(32);
                switch (n2) {
                    default: 
                }
                return;
            }
            case 600555: {
                switch (n2) {
                    case 1: {
                        this.ap0_setMMICombiContext_1804655881();
                        return;
                    }
                }
                return;
            }
            case 600578: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600582: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600583: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 600584: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(191);
                        return;
                    }
                }
                return;
            }
            case 600585: {
                sMServices.showPartialPopup(191);
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


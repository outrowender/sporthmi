/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.ConnectivityActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import de.audi.atip.statemachine.ap.TerminalModeActionProxy;

public class TerminalModeSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile TerminalModeActionProxy ap0;
    private volatile EntertainmentActionProxy ap1;
    private volatile ConnectivityActionProxy ap2;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 26, 28};

    protected TerminalModeSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap2 = null;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof TerminalModeActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "TerminalModeActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof ConnectivityActionProxy) {
            this.ap2 = (ConnectivityActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "ConnectivityActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof TerminalModeActionProxy) {
            this.ap0 = (TerminalModeActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "TerminalModeActionProxy Action Proxy added");
            return this.ap0;
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

    private void catchActionExceptionConnectivityActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'ConnectivityActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'ConnectivityActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionTerminalModeActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'TerminalModeActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'TerminalModeActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            case 3200004: {
                this.ap1_entertainmentBlacklist__891745397();
                return;
            }
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            case 3200004: {
                this.ap1_entertainmentBlacklist_1028045899();
                return;
            }
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

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 3200001: {
                sMServices.popDrawerIDs();
                return;
            }
            case 3200004: {
                TerminalModeActionProxy terminalModeActionProxy = this.ap0;
                try {
                    terminalModeActionProxy.hmiDeactivatedTerminalMode(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTerminalModeActionProxy(terminalModeActionProxy, nullPointerException, "hmiDeactivatedTerminalMode");
                }
                this.ap1_entertainmentBlacklist_1028045899();
                return;
            }
            case 3200005: {
                TerminalModeActionProxy terminalModeActionProxy = this.ap0;
                try {
                    terminalModeActionProxy.resetNewDeviceDetection(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTerminalModeActionProxy(terminalModeActionProxy, nullPointerException, "resetNewDeviceDetection");
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

    private void ap1_entertainmentBlacklist__891745397() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap1;
        try {
            entertainmentActionProxy.entertainmentBlacklist(this.smm.getTerminalID(), 21001);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentBlacklist");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 3200001: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 3200004: {
                TerminalModeActionProxy terminalModeActionProxy = this.ap0;
                try {
                    terminalModeActionProxy.hmiActivatedTerminalMode(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionTerminalModeActionProxy(terminalModeActionProxy, nullPointerException, "hmiActivatedTerminalMode");
                }
                this.ap1_entertainmentBlacklist__891745397();
                return;
            }
            case 3200010: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityCoMaApplicationContext(this.smm.getTerminalID(), 1);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaApplicationContext");
                }
                return;
            }
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 3200009: {
                ConnectivityActionProxy connectivityActionProxy = this.ap2;
                try {
                    connectivityActionProxy.connectivityCoMaInstanceEnteredSetApplicationId(this.smm.getTerminalID(), 4, 3);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionConnectivityActionProxy(connectivityActionProxy, nullPointerException, "connectivityCoMaInstanceEnteredSetApplicationId");
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.EcallActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;

public class EcallSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile EcallActionProxy ap0;
    private volatile EntertainmentActionProxy ap1;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 30};

    protected EcallSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = null;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap0 = null;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EntertainmentActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof EcallActionProxy) {
            this.ap0 = (EcallActionProxy)actionProxy;
            this.logChannel.log(-2137614336, "EcallActionProxy Action Proxy added");
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

    private void catchActionExceptionEcallActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EcallActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1078071040, "Action Proxy 'EcallActionProxy' missing for call '%1'", (Object)string);
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

    private void ap0_ecallAppLeft_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap0;
        try {
            ecallActionProxy.ecallAppLeft(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "ecallAppLeft");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 3300004: {
                this.ap0_ecallAppLeft_2107068339();
                return;
            }
            case 3300006: {
                this.ap0_ecallAppLeft_2107068339();
                return;
            }
            case 3300059: {
                this.ap0_ecallAppLeft_2107068339();
                return;
            }
            case 3300063: {
                this.ap0_ecallAppLeft_2107068339();
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_ecallAppEntered_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap0;
        try {
            ecallActionProxy.ecallAppEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "ecallAppEntered");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 3300004: {
                this.ap0_ecallAppEntered_2107068339();
                sMServices.setColor(3);
                return;
            }
            case 3300006: {
                this.ap0_ecallAppEntered_2107068339();
                sMServices.setColor(3);
                return;
            }
            case 3300027: {
                this.ap1_entertainmentSetVisible__842232548();
                return;
            }
            case 3300029: {
                this.ap1_entertainmentSetVisible__842232548();
                return;
            }
            case 3300059: {
                this.ap0_ecallAppEntered_2107068339();
                sMServices.setColor(3);
                return;
            }
            case 3300063: {
                this.ap0_ecallAppEntered_2107068339();
                sMServices.setColor(3);
                return;
            }
        }
    }

    private void ap0_hkBackForOprPopupAutomatic_2107068339() {
        EcallActionProxy ecallActionProxy = this.ap0;
        try {
            ecallActionProxy.hkBackForOprPopupAutomatic(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEcallActionProxy(ecallActionProxy, nullPointerException, "hkBackForOprPopupAutomatic");
        }
    }

    private void ap1_entertainmentSetVisible__842232548() {
        EntertainmentActionProxy entertainmentActionProxy = this.ap1;
        try {
            entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), false);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 3300001: {
                switch (n2) {
                    case 0: {
                        sMServices.setColor(3);
                        return;
                    }
                    case 1: {
                        sMServices.setColor(4);
                        return;
                    }
                }
                return;
            }
            case 3300010: {
                this.ap0_hkBackForOprPopupAutomatic_2107068339();
                return;
            }
            case 3300017: {
                this.ap1_entertainmentSetVisible__842232548();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 3300020: {
                this.ap1_entertainmentSetVisible__842232548();
                switch (n2) {
                    default: 
                }
                return;
            }
            case 3300021: {
                this.ap0_hkBackForOprPopupAutomatic_2107068339();
                switch (n2) {
                    default: 
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) {
        return this.smm.getModel(n);
    }
}


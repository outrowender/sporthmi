/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.EngineeringActionProxy;
import de.audi.atip.statemachine.ap.EntertainmentActionProxy;
import java.util.NoSuchElementException;

public class EngineeringSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile EngineeringActionProxy ap0;
    private volatile EntertainmentActionProxy ap1;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{25, 21};

    protected EngineeringSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof EngineeringActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "EngineeringActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof EntertainmentActionProxy) {
            this.ap1 = (EntertainmentActionProxy)actionProxy;
            this.logChannel.log(10000000, "EntertainmentActionProxy Action Proxy added");
            return this.ap1;
        }
        if (actionProxy instanceof EngineeringActionProxy) {
            this.ap0 = (EngineeringActionProxy)actionProxy;
            this.logChannel.log(10000000, "EngineeringActionProxy Action Proxy added");
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

    private void catchActionExceptionEngineeringActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'EngineeringActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'EngineeringActionProxy' missing for call '%1'", (Object)string);
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

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 1300001: {
                EntertainmentActionProxy entertainmentActionProxy = this.ap1;
                try {
                    entertainmentActionProxy.entertainmentSetVisible(this.smm.getTerminalID(), true);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(entertainmentActionProxy, nullPointerException, "entertainmentSetVisible");
                }
                return;
            }
            case 1300016: {
                EngineeringActionProxy engineeringActionProxy = this.ap0;
                try {
                    engineeringActionProxy.stopSystemUpTimer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEngineeringActionProxy(engineeringActionProxy, nullPointerException, "stopSystemUpTimer");
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

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 1300000: {
                EngineeringActionProxy engineeringActionProxy = this.ap0;
                try {
                    engineeringActionProxy.EngineeringTestProxy(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEngineeringActionProxy(engineeringActionProxy, nullPointerException, "EngineeringTestProxy");
                }
                return;
            }
            case 1300001: {
                sMServices.setColor(1);
                ActionProxy actionProxy = this.ap1;
                try {
                    actionProxy.entertainmentSetVisible(this.smm.getTerminalID(), false);
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEntertainmentActionProxy(actionProxy, nullPointerException, "entertainmentSetVisible");
                }
                actionProxy = this.ap0;
                try {
                    actionProxy.enterREM(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEngineeringActionProxy(actionProxy, nullPointerException, "enterREM");
                }
                return;
            }
            case 1300016: {
                EngineeringActionProxy engineeringActionProxy = this.ap0;
                try {
                    engineeringActionProxy.startSystemUpTimer(this.smm.getTerminalID());
                }
                catch (NullPointerException nullPointerException) {
                    this.catchActionExceptionEngineeringActionProxy(engineeringActionProxy, nullPointerException, "startSystemUpTimer");
                }
                return;
            }
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            default: 
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}


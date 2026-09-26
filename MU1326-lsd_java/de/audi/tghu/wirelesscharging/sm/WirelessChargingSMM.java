/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMMActions;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMMInitMediators;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMMInitStates;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMMInitTransitions;
import java.util.NoSuchElementException;

public class WirelessChargingSMM
extends AbstractAppSMM {
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private WirelessChargingSMMInitStates smmInitStates;
    private WirelessChargingSMMInitTransitions smmInitTransitions;
    private WirelessChargingSMMInitMediators smmInitMediators;
    private WirelessChargingSMMActions smmActions;

    public WirelessChargingSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 34, "WirelessChargingSMM");
    }

    public WirelessChargingSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 34, "WirelessChargingSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new WirelessChargingSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new WirelessChargingSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new WirelessChargingSMMInitMediators(this, this.logChannel);
        this.smmActions = new WirelessChargingSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 1088500480;
        this.popupIDList = new int[]{1088500480, 1105277696};
        this.popupPriorityList = new int[]{1000, 1000};
        this.popupTopLevelStateIDList = new int[]{1122054912, 1155609344};
        this.popupZPMPriorityList = new int[]{140, 135};
        this.popupZPMSlotList = new int[]{5, 5};
        this.extStateIDList = new int[]{1088500480};
        this.extStateLabelList = new String[]{"wirelessChargingDesktop"};
        this.incSlotList = EMPTY_INT_LIST;
        this.incSlotStateIDList = EMPTY_INT_LIST;
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                default: 
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[WirelessChargingSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[WirelessChargingSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(-2137614336, "[WirelessChargingSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[WirelessChargingSMM.java#checkGuard] checking: '%1'", (Object)string);
    }

    @Override
    public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }

    @Override
    public void execFocusGainedAction(SMServices sMServices, int n) {
        this.smmActions.execFocusGainedAction(sMServices, n);
    }

    @Override
    public void execFocusLostAction(SMServices sMServices, int n) {
        this.smmActions.execFocusLostAction(sMServices, n);
    }

    @Override
    public void execExitAction(SMServices sMServices, int n) {
        this.smmActions.execExitAction(sMServices, n);
    }

    @Override
    public void execEnteredAction(SMServices sMServices, int n) {
        this.smmActions.execEnteredAction(sMServices, n);
    }

    @Override
    public void execEnterAction(SMServices sMServices, int n) {
        this.smmActions.execEnterAction(sMServices, n);
    }

    @Override
    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        this.smmActions.execTransitionAction(sMServices, n, n2);
    }

    @Override
    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        return this.smmActions.addActionProxy(n, actionProxy);
    }

    @Override
    public void removeActionProxy(int n, ActionProxy actionProxy) {
        this.smmActions.removeActionProxy(n, actionProxy);
    }
}


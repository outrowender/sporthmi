/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.statemachine.AbstractAppSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.info.sm.InfoSMMActions;
import de.audi.tghu.info.sm.InfoSMMInitMediators;
import de.audi.tghu.info.sm.InfoSMMInitStates;
import de.audi.tghu.info.sm.InfoSMMInitTransitions;
import java.util.NoSuchElementException;

public class InfoSMM
extends AbstractAppSMM {
    public static final int MODULE_ID;
    public static final String SMM_NAME;
    private InfoSMMInitStates smmInitStates;
    private InfoSMMInitTransitions smmInitTransitions;
    private InfoSMMInitMediators smmInitMediators;
    private InfoSMMActions smmActions;

    public InfoSMM(IFrameworkAccess iFrameworkAccess, int n, String string) {
        super(iFrameworkAccess, n, string, 0, 5, "InfoSMM");
    }

    public InfoSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2) {
        super(iFrameworkAccess, n, string, n2, 5, "InfoSMM");
    }

    private void initSubclasses() {
        this.smmInitStates = new InfoSMMInitStates(this, this.logChannel);
        this.smmInitTransitions = new InfoSMMInitTransitions(this, this.logChannel);
        this.smmInitMediators = new InfoSMMInitMediators(this, this.logChannel);
        this.smmActions = new InfoSMMActions(this, this.logChannel);
    }

    @Override
    protected void init() {
        this.initSubclasses();
        this.topLevelStateID = 564201216;
        this.popupIDList = new int[]{564201216, 547424000};
        this.popupPriorityList = new int[]{1100, 1500};
        this.popupTopLevelStateIDList = new int[]{782305024, 815859456};
        this.popupZPMPriorityList = new int[]{155, 105};
        this.popupZPMSlotList = new int[]{5, 3};
        this.extStateIDList = new int[]{681641728, 715196160, 564201216};
        this.extStateLabelList = new String[]{"mapTrafficDetails_incl", "mapTrafficMain", "infoDesktop"};
        this.incSlotList = new int[]{597755648, 614532864, 631310080, 648087296, 664864512};
        this.incSlotStateIDList = new int[]{681641728, -3, -4, 715196160, -4};
        this.smmInitStates.initStates();
        this.smmInitMediators.initMediators();
        this.smmInitTransitions.initTransitions();
        this.reqExtStateLabelList = new String[]{null, null, null, "tunerListMsgUnsubscr", "mapMapviewMain_incl", "phoneDesktop"};
    }

    @Override
    public boolean checkGuard(int n, int n2) {
        try {
            switch (n) {
                case 500002: {
                    switch (n2) {
                        case 0: {
                            this.logCheckGuard("ChoiceModel (MODELID#500183) Value == 0");
                            return ((ChoiceModel)this.getModel(-677312768)).getValue() == 0;
                        }
                        case 1: {
                            this.logCheckGuard("ChoiceModel (MODELID#500183) Value == 1");
                            return ((ChoiceModel)this.getModel(-677312768)).getValue() == 1;
                        }
                        case 2: {
                            this.logCheckGuardDefault();
                            return true;
                        }
                    }
                    return false;
                }
                case 500035: {
                    this.logCheckGuard("( ChoiceModel (MODELID#335) Value == 2 ) || ( ChoiceModel (MODELID#335) Value == 3 ) || ( ChoiceModel (MODELID#335) Value == 8 ) || ( ChoiceModel (MODELID#335) Value == 9 )");
                    return ((ChoiceModel)this.getModel(335)).getValue() == 2 || ((ChoiceModel)this.getModel(335)).getValue() == 3 || ((ChoiceModel)this.getModel(335)).getValue() == 8 || ((ChoiceModel)this.getModel(335)).getValue() == 9;
                }
            }
            return false;
        }
        catch (NullPointerException nullPointerException) {
            if (this.hmiService == null) {
                this.logChannel.log(10000, "[InfoSMM.java#checkGuard] Model Broker not registered");
                return false;
            }
            throw nullPointerException;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.logChannel.log(10000, "[InfoSMM.java#checkGuard] unable to retrieve all required models to check guard of transition %1.%2", (long)n, (long)n2);
            return false;
        }
    }

    private void logCheckGuardDefault() {
        this.smLogChannel.log(-2137614336, "[InfoSMM.java#checkGuard] else-case, always true");
    }

    private void logCheckGuard(String string) {
        this.smLogChannel.log(-2137614336, "[InfoSMM.java#checkGuard] checking: '%1'", (Object)string);
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


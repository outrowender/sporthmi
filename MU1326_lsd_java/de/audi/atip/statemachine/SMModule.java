/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorRegistry;
import de.audi.atip.statemachine.Popup;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.SMSyncTarget;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.Transition;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;

public interface SMModule
extends SMModuleConstants {
    public static final String PROP_KEY_SM_ID = "smID";
    public static final String PROP_KEY_SM_NAME = "smName";
    public static final String PROP_KEY_SMM_NAME = "smmName";
    public static final String PROP_KEY_SUBTERMINAL_ID = "subterminalID";
    public static final String PROP_KEY_MODULE_ID = "moduleID";

    public int getTerminalID();

    public String getTerminalName();

    public int getSubterminalID();

    public int getModuleID();

    public String getSMMName();

    public void setMediatorRegistry(MediatorRegistry var1);

    public void setSyncTargetProcessor(SyncTargetProcessor var1);

    public ActionProxy addActionProxy(int var1, ActionProxy var2);

    public void removeActionProxy(int var1, ActionProxy var2);

    public void registerExternalState(String var1, int var2);

    public void deregisterExternalState(String var1);

    public boolean bindIncludeState(int var1, int var2);

    public int getTopLevelState();

    public Popup getPopup(int var1);

    public int externalStates();

    public String getExternalStateLabel(int var1);

    public int getExternalStateID(int var1);

    public State getState(int var1);

    public int getHistory(int var1);

    public void setHistory(int var1, int var2);

    public void resetHistory(int var1);

    public Transition getTransition(int var1);

    public EventMediator getEventMediator(int var1);

    public SMSyncTarget getSyncTarget(int var1);

    public void execEnteredAction(SMServices var1, int var2);

    public void execEnterAction(SMServices var1, int var2);

    public void execExitAction(SMServices var1, int var2);

    public void execTransitionAction(SMServices var1, int var2, int var3);

    public boolean checkGuard(SMServices var1, int var2, int var3);

    public boolean checkGuard(int var1, int var2);

    public void execFocusLostAction(SMServices var1, int var2);

    public void execFocusGainedAction(SMServices var1, int var2);

    public void execSDForState(TTSASR var1, ITTSASRContext var2, int var3);

    public void setJumpBackPoint(int var1, int var2);

    public int getTransIncludeJumpEvent(int var1);
}


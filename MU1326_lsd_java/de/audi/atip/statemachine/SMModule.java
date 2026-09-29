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
    public static final String PROP_KEY_SM_ID;
    public static final String PROP_KEY_SM_NAME;
    public static final String PROP_KEY_SMM_NAME;
    public static final String PROP_KEY_SUBTERMINAL_ID;
    public static final String PROP_KEY_MODULE_ID;

    default public int getTerminalID() {
    }

    default public String getTerminalName() {
    }

    default public int getSubterminalID() {
    }

    default public int getModuleID() {
    }

    default public String getSMMName() {
    }

    default public void setMediatorRegistry(MediatorRegistry mediatorRegistry) {
    }

    default public void setSyncTargetProcessor(SyncTargetProcessor syncTargetProcessor) {
    }

    default public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
    }

    default public void removeActionProxy(int n, ActionProxy actionProxy) {
    }

    default public void registerExternalState(String string, int n) {
    }

    default public void deregisterExternalState(String string) {
    }

    default public boolean bindIncludeState(int n, int n2) {
    }

    default public int getTopLevelState() {
    }

    default public Popup getPopup(int n) {
    }

    default public int externalStates() {
    }

    default public String getExternalStateLabel(int n) {
    }

    default public int getExternalStateID(int n) {
    }

    default public State getState(int n) {
    }

    default public int getHistory(int n) {
    }

    default public void setHistory(int n, int n2) {
    }

    default public void resetHistory(int n) {
    }

    default public Transition getTransition(int n) {
    }

    default public EventMediator getEventMediator(int n) {
    }

    default public SMSyncTarget getSyncTarget(int n) {
    }

    default public void execEnteredAction(SMServices sMServices, int n) {
    }

    default public void execEnterAction(SMServices sMServices, int n) {
    }

    default public void execExitAction(SMServices sMServices, int n) {
    }

    default public void execTransitionAction(SMServices sMServices, int n, int n2) {
    }

    default public boolean checkGuard(SMServices sMServices, int n, int n2) {
    }

    default public boolean checkGuard(int n, int n2) {
    }

    default public void execFocusLostAction(SMServices sMServices, int n) {
    }

    default public void execFocusGainedAction(SMServices sMServices, int n) {
    }

    default public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }

    default public void setJumpBackPoint(int n, int n2) {
    }

    default public int getTransIncludeJumpEvent(int n) {
    }
}


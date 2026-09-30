/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.StateMachineEvent;
import de.audi.atip.statemachine.SMListener;

public interface SMInterpreter {
    public void startPopup(int var1, int var2);

    public void stopPopup(int var1, int var2);

    public void processEvent(StateMachineEvent var1);

    public void processUpdate(ModelUpdateEvent var1);

    public void registersSMListener(SMListener var1);

    public void setActiveSubterminal(int var1, int var2);

    public int getActiveSubterminal(int var1);

    public void jointModeLeft(int var1);
}


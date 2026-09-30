/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.Message;

public interface IState {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;

    public void enter(Message var1);

    public void exit(Message var1);

    public boolean processMessage(Message var1);

    public String getName();
}


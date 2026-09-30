/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public interface SCXMLListener {
    public void onEntry(TransitionTarget var1);

    public void onExit(TransitionTarget var1);

    public void onTransition(TransitionTarget var1, TransitionTarget var2, Transition var3);
}


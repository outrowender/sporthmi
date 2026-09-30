/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public abstract class AbstractSCXMLListener
implements SCXMLListener {
    public void onEntry(TransitionTarget transitionTarget) {
    }

    public void onExit(TransitionTarget transitionTarget) {
    }

    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
    }
}


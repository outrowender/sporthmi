/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public interface SCXMLListener {
    default public void onEntry(TransitionTarget transitionTarget) {
    }

    default public void onExit(TransitionTarget transitionTarget) {
    }

    default public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
    }
}


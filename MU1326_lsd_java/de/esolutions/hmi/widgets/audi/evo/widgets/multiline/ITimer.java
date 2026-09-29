/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

public interface ITimer {
    default public void onEnqueue(int n) {
    }

    default public void onTimeout(int n) {
    }

    default public void onCancel(int n) {
    }
}


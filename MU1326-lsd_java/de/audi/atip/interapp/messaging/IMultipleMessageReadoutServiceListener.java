/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging;

public interface IMultipleMessageReadoutServiceListener {
    default public void responseBeginDialog(int n) {
    }

    default public void responseNextMessage(int n, String string) {
    }

    default public void responseEndDialog(int n) {
    }
}


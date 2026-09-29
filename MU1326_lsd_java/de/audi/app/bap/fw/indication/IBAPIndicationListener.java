/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

public interface IBAPIndicationListener {
    default public void processAcknowledge(int n, int n2) {
    }

    default public void processIndication(int n, int n2, int n3, int n4) {
    }

    default public void processIndicationByteSequence(int n, int n2, byte[] byArray) {
    }

    default public void processIndicationVoid(int n, int n2) {
    }

    default public void processIndicationError(int n, int n2) {
    }
}


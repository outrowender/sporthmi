/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi.bap;

import de.audi.app.bap.dsi.IDSIController;

public interface IDSIBAPController
extends IDSIController {
    default public boolean isDSIBAPAvailable() {
    }

    default public void getBAPState(int n) {
    }

    default public void setHMIState(int n, int n2) {
    }

    default public void request(int n, int n2, int n3, int n4, int n5) {
    }

    default public void requestVoid(int n, int n2, int n3) {
    }

    default public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
    }

    default public void requestError(int n, int n2, int n3) {
    }
}


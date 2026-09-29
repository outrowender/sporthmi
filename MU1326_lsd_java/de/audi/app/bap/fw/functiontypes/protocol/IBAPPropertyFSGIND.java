/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPPropertyFSGIND {
    default public void getIND() {
    }

    default public void setGetIND(SetGetProperty setGetProperty) {
    }

    default public void setIND(SetGetProperty setGetProperty) {
    }

    default public void ackIND(AckProperty ackProperty) {
    }
}


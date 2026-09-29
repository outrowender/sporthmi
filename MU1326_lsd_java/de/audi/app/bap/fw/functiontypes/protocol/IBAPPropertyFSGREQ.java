/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPPropertyFSGREQ {
    default public void sendStatus(StatusProperty statusProperty) {
    }

    default public void sendStatusIfChanged(StatusProperty statusProperty) {
    }

    default public void resendLastStatus() {
    }

    default public void sendStatusAck(StatusAckProperty statusAckProperty) {
    }

    default public void resendLastStatusAck() {
    }

    default public void setInitialStatus(StatusProperty statusProperty) {
    }

    default public void setInitialStatusAck(StatusAckProperty statusAckProperty) {
    }

    default public StatusProperty getLastStatus() {
    }

    default public StatusAckProperty getLastStatusAck() {
    }
}


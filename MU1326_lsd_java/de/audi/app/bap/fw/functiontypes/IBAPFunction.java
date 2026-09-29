/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.indication.BAPIndicationData;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface IBAPFunction {
    default public int getFctID() {
    }

    default public String getFctIDDescription() {
    }

    default public String getLSGIDDescription() {
    }

    default public BAPEntity getIndicationSerializer(int n) {
    }

    default public void processAcknowledge(int n) {
    }

    default public void processIndication(int n, BAPIndicationData bAPIndicationData) {
    }

    default public void processIndicationError(int n) {
    }

    default public void reset() {
    }

    default public void onRemoteProcessState(RemoteProcessState remoteProcessState) {
    }
}


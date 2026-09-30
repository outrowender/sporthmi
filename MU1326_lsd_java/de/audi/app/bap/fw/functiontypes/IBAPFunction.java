/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.indication.BAPIndicationData;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface IBAPFunction {
    public int getFctID();

    public String getFctIDDescription();

    public String getLSGIDDescription();

    public BAPEntity getIndicationSerializer(int var1);

    public void processAcknowledge(int var1);

    public void processIndication(int var1, BAPIndicationData var2);

    public void processIndicationError(int var1);

    public void reset();

    public void onRemoteProcessState(RemoteProcessState var1);
}


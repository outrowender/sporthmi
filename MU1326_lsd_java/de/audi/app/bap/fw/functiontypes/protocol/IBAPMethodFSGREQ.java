/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ResultMethod;

public interface IBAPMethodFSGREQ {
    public void processingREQ();

    public void resultREQ(ResultMethod var1);
}


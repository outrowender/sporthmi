/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ResultMethod;

public interface IBAPMethodASGIND {
    public void processingIND();

    public void resultIND(ResultMethod var1);
}


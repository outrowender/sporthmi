/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.rsdb.IRSDBResult;

public class NullRSDBResult
implements IRSDBResult {
    public static final IRSDBResult INSTANCE = new NullRSDBResult();

    public void resultAvailable() {
    }
}


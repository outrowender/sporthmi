/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayObjectId;

public interface FsgArrayObjectIdGenerator {
    public FsgArrayObjectId createObjectID(Object var1, int var2);

    public boolean compareObjectID(FsgArrayObjectId var1, Object var2);
}


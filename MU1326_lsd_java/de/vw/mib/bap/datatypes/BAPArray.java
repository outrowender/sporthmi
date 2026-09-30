/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPDataType;

public interface BAPArray
extends BAPDataType {
    public void setArrayHeader(ArrayHeader var1);

    public ArrayHeader getArrayHeader();
}


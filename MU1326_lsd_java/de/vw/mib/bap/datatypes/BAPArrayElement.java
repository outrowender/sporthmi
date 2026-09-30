/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPArrayElement
extends BAPEntity {
    public int getPos();

    public void setPos(int var1);

    public void setArrayHeader(ArrayHeader var1);

    public ArrayHeader getArrayHeader();
}


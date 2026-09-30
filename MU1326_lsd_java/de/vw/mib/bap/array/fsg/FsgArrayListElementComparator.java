/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface FsgArrayListElementComparator {
    public static final int ARRAYELEMENTCOMPARATOR_ELEMENTS_ARE_EQUAL = -1;
    public static final int ARRAYELEMENTCOMPARATOR_NO_LAST_CHANGED_RECORD_ADDRESS = -1;

    public int compare(BAPArrayElement var1, BAPArrayElement var2, int var3);
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;

public interface PropertyListener
extends BAPFunctionListener {
    public boolean statusProperty(BAPEntity var1, Property var2);

    public boolean statusAckProperty(BAPEntity var1, Property var2);
}


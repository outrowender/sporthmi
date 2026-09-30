/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.PropertyListener;

public interface Property
extends BAPFunction {
    public void getProperty(BAPEntity var1, PropertyListener var2);

    public void setGetProperty(BAPEntity var1, PropertyListener var2);

    public void ackProperty(BAPEntity var1, PropertyListener var2);
}


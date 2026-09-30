/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;

public interface BAPDisplayFunctionControllerDelegate {
    public Array getArray(BAPFunctionController var1);

    public Method getMethod(BAPFunctionController var1);

    public Property getProperty(BAPFunctionController var1);
}


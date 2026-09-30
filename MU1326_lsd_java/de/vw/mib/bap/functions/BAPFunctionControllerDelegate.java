/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;

public interface BAPFunctionControllerDelegate {
    public ArrayListener getArrayListener(BAPFunctionController var1);

    public MethodListener getMethodListener(BAPFunctionController var1);

    public PropertyListener getPropertyListener(BAPFunctionController var1);
}


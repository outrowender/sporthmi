/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.BAPOperationState;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;

public interface BAPFunctionListenerRegistry {
    public BAPFunctionListener getBAPFunctionListener(int var1);

    public ArrayListener getArrayListener(int var1);

    public MethodListener getMethodListener(int var1);

    public PropertyListener getPropertyListener(int var1);

    public BAPFunctionController getFunctionController(int var1);

    public BAPConfigVersionCheck getBapConfigVersionCheckFunction();

    public BAPFunctionList getFunctionList();

    public BAPOperationState getOperationState();
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IBAPFunctionFactory;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;

public interface IBAPFunctionFactoryFSG
extends IBAPFunctionFactory {
    public BAPFunctionMethodFSG createBAPFunctionMethodFSG(AbstractBAPModuleFSG var1, int var2);

    public BAPFunctionPropertyFSG createBAPFunctionPropertyFSG(AbstractBAPModuleFSG var1, int var2);

    public BAPFunctionArrayFSG createBAPFunctionArrayFSG(AbstractBAPModuleFSG var1, int var2);
}


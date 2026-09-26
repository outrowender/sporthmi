/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;

public class BAPFunctionFactoryFSG
implements IBAPFunctionFactoryFSG {
    @Override
    public BAPFunctionMethodFSG createBAPFunctionMethodFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        return new BAPFunctionMethodFSG(abstractBAPModuleFSG, n);
    }

    @Override
    public BAPFunctionPropertyFSG createBAPFunctionPropertyFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        return new BAPFunctionPropertyFSG(abstractBAPModuleFSG, n);
    }

    @Override
    public BAPFunctionArrayFSG createBAPFunctionArrayFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        return new BAPFunctionArrayFSG(abstractBAPModuleFSG, n);
    }
}


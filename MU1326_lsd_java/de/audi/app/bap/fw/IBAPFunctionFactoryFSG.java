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
    default public BAPFunctionMethodFSG createBAPFunctionMethodFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
    }

    default public BAPFunctionPropertyFSG createBAPFunctionPropertyFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
    }

    default public BAPFunctionArrayFSG createBAPFunctionArrayFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
    }
}


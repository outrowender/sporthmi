/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.IBAPFunctionFactoryASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.RetryConfig;

public final class BAPFunctionFactoryASG
implements IBAPFunctionFactoryASG {
    @Override
    public BAPFunctionGetAll createBAPFunctionGetAll(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionGetAll(abstractBAPModuleASG, n);
    }

    @Override
    public BAPFunctionMethodASG createBAPFunctionMethodASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionMethodASG(abstractBAPModuleASG, n);
    }

    @Override
    public BAPFunctionPropertyASG createBAPFunctionPropertyASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionPropertyASG(abstractBAPModuleASG, n);
    }

    @Override
    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionArrayASG(abstractBAPModuleASG, n);
    }

    @Override
    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n, RetryConfig retryConfig) {
        return new BAPFunctionArrayASG(abstractBAPModuleASG, n, retryConfig);
    }
}


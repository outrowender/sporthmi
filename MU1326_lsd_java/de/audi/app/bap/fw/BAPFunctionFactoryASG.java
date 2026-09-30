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
    public BAPFunctionGetAll createBAPFunctionGetAll(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionGetAll(abstractBAPModuleASG, n);
    }

    public BAPFunctionMethodASG createBAPFunctionMethodASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionMethodASG(abstractBAPModuleASG, n);
    }

    public BAPFunctionPropertyASG createBAPFunctionPropertyASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionPropertyASG(abstractBAPModuleASG, n);
    }

    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        return new BAPFunctionArrayASG(abstractBAPModuleASG, n);
    }

    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n, RetryConfig retryConfig) {
        return new BAPFunctionArrayASG(abstractBAPModuleASG, n, retryConfig);
    }
}


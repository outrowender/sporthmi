/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.IBAPFunctionFactory;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.RetryConfig;

public interface IBAPFunctionFactoryASG
extends IBAPFunctionFactory {
    default public BAPFunctionGetAll createBAPFunctionGetAll(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
    }

    default public BAPFunctionMethodASG createBAPFunctionMethodASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
    }

    default public BAPFunctionPropertyASG createBAPFunctionPropertyASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
    }

    default public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
    }

    default public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n, RetryConfig retryConfig) {
    }
}


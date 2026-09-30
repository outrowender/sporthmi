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
    public BAPFunctionGetAll createBAPFunctionGetAll(AbstractBAPModuleASG var1, int var2);

    public BAPFunctionMethodASG createBAPFunctionMethodASG(AbstractBAPModuleASG var1, int var2);

    public BAPFunctionPropertyASG createBAPFunctionPropertyASG(AbstractBAPModuleASG var1, int var2);

    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG var1, int var2);

    public BAPFunctionArrayASG createBAPFunctionArrayASG(AbstractBAPModuleASG var1, int var2, RetryConfig var3);
}


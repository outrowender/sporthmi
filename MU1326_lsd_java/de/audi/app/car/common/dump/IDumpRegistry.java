/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dump;

import de.audi.app.car.common.dump.IDumpHandlerComponentAccess;

public interface IDumpRegistry {
    public void init();

    public void deinit();

    public IDumpHandlerComponentAccess registerAsProvider(String var1);

    public void deRegisterAsProvider(IDumpHandlerComponentAccess var1);
}


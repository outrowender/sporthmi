/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dump;

import de.audi.app.car.common.dump.IDumpHandlerComponentAccess;

public interface IDumpRegistry {
    default public void init() {
    }

    default public void deinit() {
    }

    default public IDumpHandlerComponentAccess registerAsProvider(String string) {
    }

    default public void deRegisterAsProvider(IDumpHandlerComponentAccess iDumpHandlerComponentAccess) {
    }
}


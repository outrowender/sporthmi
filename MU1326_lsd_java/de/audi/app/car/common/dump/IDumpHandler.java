/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dump;

import de.audi.app.car.common.dump.IDumpHandlerComponentAccess;
import java.util.HashMap;

public interface IDumpHandler
extends IDumpHandlerComponentAccess {
    default public HashMap getData() {
    }

    default public String getName() {
    }
}


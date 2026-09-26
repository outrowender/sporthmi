/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.swdiagnosis;

import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

public interface IDiagProvider {
    default public IDiagPlugIn[] createDiagPlugIns() {
    }
}


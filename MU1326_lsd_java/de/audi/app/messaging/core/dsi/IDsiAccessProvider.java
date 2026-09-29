/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi;

import de.audi.app.messaging.core.dsi.IDsiAccessClient;

public interface IDsiAccessProvider {
    default public void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
    }
}


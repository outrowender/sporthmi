/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.tuner.ifc.ILogoDatabase;

public interface IRadioDatabaseListener {
    default public void databaseReady(ILogoDatabase iLogoDatabase) {
    }
}


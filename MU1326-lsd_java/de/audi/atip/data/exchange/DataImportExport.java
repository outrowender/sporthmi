/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExportData;
import de.audi.atip.data.exchange.ImportData;

public interface DataImportExport {
    public static final int APP_NAVI;

    default public int getApplicationID() {
    }

    default public void exportData(ExportData exportData) {
    }

    default public boolean importData(ImportData importData) {
    }
}


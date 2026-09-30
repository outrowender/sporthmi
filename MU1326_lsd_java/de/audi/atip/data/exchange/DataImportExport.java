/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExportData;
import de.audi.atip.data.exchange.ImportData;

public interface DataImportExport {
    public static final int APP_NAVI = 0;

    public int getApplicationID();

    public void exportData(ExportData var1);

    public boolean importData(ImportData var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIListener;

public interface DSICalendarExchangeListener
extends DSIListener {
    public void parseICalResult(int var1);

    public void parseICalDirectoryResult(int[] var1);

    public void exportICalResult(int var1, String var2);

    public void finishExportResult(int var1, long[] var2, int var3, String var4);
}


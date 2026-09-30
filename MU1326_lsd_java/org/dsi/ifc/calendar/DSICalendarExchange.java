/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICalendarExchange
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int RT_PARSEICAL = 1000;
    public static final int RT_PARSEICALDIRECTORY = 1001;
    public static final int RT_EXPORTICAL = 1002;
    public static final int RT_IMPORTICAL = 1003;
    public static final int RT_ABORTEXPORT = 1004;
    public static final int RP_PARSEICALRESULT = 2000;
    public static final int RP_PARSEICALDIRECTORYRESULT = 2001;
    public static final int RP_EXPORTICALRESULT = 2002;
    public static final int RP_FINISHEXPORTRESULT = 2003;
    public static final int RESULTTYPE_OK = 0;
    public static final int RESULTTYPE_ERROR = 1;

    public void parseICal(String var1);

    public void parseICalDirectory(String var1);

    public void exportICal(int var1, int var2, long[] var3, int var4);

    public void importICal(ResourceLocator[] var1);

    public void abortExport();
}


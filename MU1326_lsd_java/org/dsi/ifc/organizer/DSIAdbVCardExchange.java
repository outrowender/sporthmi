/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAdbVCardExchange
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_IMPORTVCARD = 1000;
    public static final int RT_EXPORTVCARD = 1001;
    public static final int RT_EXPORTSPELLERVCARD = 1002;
    public static final int RT_CREATEVCARD = 1004;
    public static final int RT_PARSEVCARD = 1005;
    public static final int RT_REQUESTABORT = 1006;
    public static final int ATTR_EXPORTCOUNT = 4;
    public static final int ATTR_IMPORTCOUNT = 5;
    public static final int RP_IMPORTVCARDRESULT = 2000;
    public static final int RP_EXPORTVCARDRESULT = 2001;
    public static final int RP_EXPORTSPELLERVCARDRESULT = 2002;
    public static final int RP_CREATEVCARDRESULT = 2004;
    public static final int RP_PARSEVCARDRESULT = 2005;
    public static final int RP_RESPONSEABORT = 2006;

    public void importVCard(ResourceLocator[] var1, int var2);

    public void exportVCard(int var1, String var2, long[] var3, int var4);

    public void exportSpellerVCard(int var1, int var2, String var3, long[] var4, int var5);

    public void createVCard(int var1, long[] var2, int var3);

    public void parseVCard(String var1);

    public void requestAbort(int var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travelguide;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSITravelGuide
extends DSIBase {
    public static final String VERSION = "2.11.0";
    public static final int RESULTCODE_OK = 0;
    public static final int RESULTCODE_ERROR = 1;
    public static final int RESULTCODE_NOT_OPERABLE = 2;
    public static final int RESULTCODE_UNSUPPORTED = 3;
    public static final int FAILUREREASON_NONE = 0;
    public static final int FAILUREREASON_UNSPECIFIED = 1;
    public static final int FAILUREREASON_MEMORY_FULL = 2;
    public static final int FAILUREREASON_DUPLICATE = 3;
    public static final int WINDOWSTEP_CURRENT_PAGE = 0;
    public static final int WINDOWSTEP_NEXT_PAGE = 1;
    public static final int WINDOWSTEP_PREVIOUS_PAGE = 2;
    public static final int WINDOWSTEP_FIRST_PAGE = 4;
    public static final int WINDOWSTEP_GOTO_POSITION = 6;
    public static final int LISTITEMSTATUS_AVAILABLE = 0;
    public static final int LISTITEMSTATUS_DOWNLOADING = 1;
    public static final int LISTITEMSTATUS_IMPORTING = 2;
    public static final int LISTITEMSTATUS_UPDATING = 3;
    public static final int ATTR_TRAVELGUIDEMEMORYLIST = 1;
    public static final int ATTR_TRAVELGUIDEMEMORYLISTELEMENT = 2;
    public static final int RT_IMPORTTRAVELGUIDE = 1003;
    public static final int RT_DELETETRAVELGUIDE = 1004;
    public static final int RP_IMPORTTRAVELGUIDERESULT = 2003;
    public static final int RP_DELETETRAVELGUIDERESULT = 2004;

    public void importTravelGuide(ResourceLocator var1);

    public void deleteTravelGuide(long var1);
}


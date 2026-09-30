/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbSds
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_GETALLVOICETAGS = 1000;
    public static final int RT_DELETEVOICETAGS = 1001;
    public static final int RP_GETALLVOICETAGSRESULT = 2000;
    public static final int RP_DELETEVOICETAGSRESULT = 2001;

    public void getAllVoiceTags();

    public void deleteVoiceTags(int[] var1);
}


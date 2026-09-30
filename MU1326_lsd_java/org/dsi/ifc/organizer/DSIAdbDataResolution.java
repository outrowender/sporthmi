/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbDataResolution
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_RESOLVEMAILADDRESSES = 1000;
    public static final int RT_RESOLVEPHONENUMBERS = 1001;
    public static final int RP_RESOLVEMAILADDRESSRESULT = 2000;
    public static final int RP_RESOLVEPHONENUMBERSRESULT = 2001;

    public void resolveMailAddresses(String[] var1);

    public void resolvePhoneNumbers(String[] var1);
}


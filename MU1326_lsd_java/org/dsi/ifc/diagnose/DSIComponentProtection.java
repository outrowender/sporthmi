/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIBase;

public interface DSIComponentProtection
extends DSIBase {
    public static final String VERSION = "2.11.10";
    public static final int CONSTANTS_CONSTANT1 = 0;
    public static final int CONSTANTS_CONSTANT2 = 1;
    public static final int ENCRYPTIONOPTION_COMPONENTBASE = 0;
    public static final int ENCRYPTIONOPTION_COMPONENTANDCARBASE = 1;
    public static final int RT_AUTHSTRING = 1000;
    public static final int RP_AUTHSTRINGRESPONSE = 2000;

    public void authString(String var1, int var2, int var3);
}


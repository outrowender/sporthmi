/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSICallStacks
extends DSIBase {
    public static final String VERSION = "2.11.27";
    public static final int RT_DELETEALL = 1000;
    public static final int RT_DELETEENTRY = 1001;
    public static final int RT_RESETMISSEDCALLINDICATOR = 1002;
    public static final int RT_REVERTCALLSTACKS = 1003;
    public static final int ATTR_ISREVERTED = 1;
    public static final int ATTR_LASTANSWEREDNUMBERS = 2;
    public static final int ATTR_LASTDIALEDNUMBERS = 3;
    public static final int ATTR_MISSEDNUMBERS = 4;
    public static final int ATTR_MEDATAVALIDITY = 6;
    public static final int ATTR_MISSEDCALLINDICATOR = 7;
    public static final int CALLSTACKS_LD = 0;
    public static final int CALLSTACKS_RC = 1;
    public static final int CALLSTACKS_MC = 2;
    public static final int CALLSTACKS_ALL = 3;
    public static final int DATAVALIDITY_DATAVALID = 0;
    public static final int DATAVALIDITY_DATAINVALID = 1;
    public static final int CALLSTACKORIGIN_ME = 0;
    public static final int CALLSTACKORIGIN_MU = 1;

    public void deleteAll(int var1);

    public void deleteEntry(int var1, int var2);

    public void resetMissedCallIndicator();

    public void revertCallstacks(boolean var1);
}


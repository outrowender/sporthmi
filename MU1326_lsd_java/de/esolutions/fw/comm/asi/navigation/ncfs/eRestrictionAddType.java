/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.core.IEnum;

public interface eRestrictionAddType
extends IEnum {
    public static final int RESTRICTION_ADDTYPE_NOSIGN = 0;
    public static final int RESTRICTION_ADDTYPE_EMPTYADDSIGN = 1;
    public static final int RESTRICTION_ADDTYPE_WET = 2;
    public static final int RESTRICTION_ADDTYPE_RAIN = 3;
    public static final int RESTRICTION_ADDTYPE_TEMPCOND = 4;
    public static final int RESTRICTION_ADDTYPE_ONLYPASSENGERCAR = 5;
    public static final int RESTRICTION_ADDTYPE_VEHICLEWITHTRAILER = 6;
    public static final int RESTRICTION_ADDTYPE_VEHILCESTURNRIGHT = 7;
    public static final int RESTRICTION_ADDTYPE_VEHILCESTURNLEFT = 8;
    public static final int RESTRICTION_ADDTYPE_OVERTAKINGTRACTORALLOWED = 9;
    public static final int RESTRICTION_ADDTYPE_VARIABLESIGN = 10;
}


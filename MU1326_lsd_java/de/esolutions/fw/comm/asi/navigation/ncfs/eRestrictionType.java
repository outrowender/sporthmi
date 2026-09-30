/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.core.IEnum;

public interface eRestrictionType
extends IEnum {
    public static final int RESTRICTION_TYPE_NORESTRICTION = 0;
    public static final int RESTRICTION_TYPE_SPEEDLIMIT = 1;
    public static final int RESTRICTION_TYPE_SPEEDLIMITVAR = 2;
    public static final int RESTRICTION_TYPE_NOPASSINGALLVEHICLES = 3;
    public static final int RESTRICTION_TYPE_NOPASSINGMORE35T = 4;
    public static final int RESTRICTION_TYPE_NOPASSINGALLVEHICLESVAR = 5;
    public static final int RESTRICTION_TYPE_NOPASSINGMORE35TVAREU = 6;
    public static final int RESTRICTION_TYPE_RECOMMENDEDSPEED = 7;
}


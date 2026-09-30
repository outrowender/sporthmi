/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

import de.esolutions.fw.comm.core.IEnum;

public interface eCardTypeDSRC
extends IEnum {
    public static final int DSRC_CARD_TYPE_NO_CARD = 0;
    public static final int DSRC_CARD_TYPE_ETC_CARD = 1;
    public static final int DSRC_CARD_TYPE_ISO_IEC7816 = 2;
    public static final int DSRC_CARD_TYPE_ETC_SETUPCARD = 16;
    public static final int DSRC_CARD_TYPE_DSRC_SETUPCARD = 17;
    public static final int DSRC_CARD_TYPE_ETC_DSRC_SETUPCARD = 18;
    public static final int DSRC_CARD_TYPE_NOT_AVAILABLE = 128;
    public static final int DSRC_CARD_TYPE_NO_COMMUNICATION = 255;
}


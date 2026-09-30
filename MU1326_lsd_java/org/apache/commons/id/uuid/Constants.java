/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

public interface Constants {
    public static final int UUID_BIT_LENGTH = 128;
    public static final int UUID_BYTE_LENGTH = 16;
    public static final int UUID_UNFORMATTED_LENGTH = 32;
    public static final int UUID_FORMATTED_LENGTH = 36;
    public static final int TOKENS_IN_UUID = 5;
    public static final int[] TOKEN_LENGTHS = new int[]{8, 4, 4, 4, 12};
    public static final int FORMAT_POSITION1 = 8;
    public static final int FORMAT_POSITION2 = 13;
    public static final int FORMAT_POSITION3 = 18;
    public static final int FORMAT_POSITION4 = 23;
    public static final String URN_PREFIX = "urn:uuid:";
    public static final int VARIANT_NCS_COMPAT = 0;
    public static final int VARIANT_IETF_DRAFT = 2;
    public static final int VARIANT_MS = 6;
    public static final int VARIANT_FUTURE = 7;
    public static final int VERSION_ONE = 1;
    public static final int VERSION_TWO = 2;
    public static final int VERSION_THREE = 3;
    public static final int VERSION_FOUR = 4;
    public static final int VERSION_FIVE = 3;
    public static final String MD5_ENCODING = "MD5";
    public static final String SHA1_ENCODING = "SHA1";
    public static final String WRONG_VAR_VER_MSG = "Not a ietf variant 2 or version 1 (time-based UUID)";
    public static final int TIME_LOW_BYTE_LEN = 4;
    public static final int TIME_MID_BYTE_LEN = 2;
    public static final int TIME_HI_BYTE_LEN = 2;
    public static final int TIME_LOW_TS_POS = 4;
    public static final int TIME_MID_TS_POS = 2;
    public static final int TIME_HI_TS_POS = 0;
    public static final int TIME_LOW_START_POS = 0;
    public static final int TIME_MID_START_POS = 4;
    public static final int TIME_HI_START_POS = 6;
    public static final short TIME_HI_AND_VERSION_BYTE_6 = 6;
    public static final short CLOCK_SEQ_HI_AND_RESERVED_BYTE_8 = 8;
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sds;

public class HMISlotGrammars {
    public static int SPEECH_INPUT_MAPPINA_J = 34;
    public static int ONLINE_STREAMING_PICKLIST = 35;
    public static int PHONE_CONTACTS_CONTACTNUMBERS = 300023;
    public static int SPEECH_PHONE_FAVORITES_DYNAMIC = 300101;
    public static int SPEECH_PHONE_CALLSTACKS_DYNAMIC = 300100;
    public static int SPEECH_TUNER_STATION_DYNAMIC = 100018;
    public static int MEDIA_ONESHOT_TITLES = 200051;
    public static int SPEECH_TUNER_GENRELIST_DYNAMIC = 100085;
    public static int NAVIGATION_SPEECH_KRSIMPLEMAPS_DYNAMIC = 800244;
    public static int SPEECH_TUNER_DABENSEMBLELIST_DYNAMIC = 100016;
    public static int MEDIA_ONESHOT_ARTISTS = 200049;
    public static int SPEECH_NAVI_MY_AUDI_CONTACTS_DYNAMIC = 400349;
    public static int MEDIA_ONESHOT_ALBUMS = 200047;
    public static int SPEECH_INPUT_ROWNUMBER1_6 = 21;
    public static int MEDIA_DYNAMIC_DEVICE = 200069;
    public static int SPEECH_NAVI_LAST_DESTINATIONS_DYNAMIC = 400344;
    public static int SPEECH_INPUT_SDCARDNUMBER1_2 = 22;
    public static int ONLINE_REMOTEHMI_GLOBAL = 2300025;
    public static int SPEECH_INPUT_MAILADDRESS = 0x219222;
    public static int SPEECH_NAVI_FAVORITES_DYNAMIC = 400342;
    public static int ONLINE_REMOTEHMI_HELP = 2300031;
    public static int ONLINE_REMOTEHMI = 2300028;
    public static int[] HMISlotGrammarArray = new int[]{SPEECH_INPUT_MAPPINA_J, ONLINE_STREAMING_PICKLIST, PHONE_CONTACTS_CONTACTNUMBERS, SPEECH_PHONE_FAVORITES_DYNAMIC, SPEECH_PHONE_CALLSTACKS_DYNAMIC, SPEECH_TUNER_STATION_DYNAMIC, MEDIA_ONESHOT_TITLES, SPEECH_TUNER_GENRELIST_DYNAMIC, NAVIGATION_SPEECH_KRSIMPLEMAPS_DYNAMIC, SPEECH_TUNER_DABENSEMBLELIST_DYNAMIC, MEDIA_ONESHOT_ARTISTS, SPEECH_NAVI_MY_AUDI_CONTACTS_DYNAMIC, MEDIA_ONESHOT_ALBUMS, SPEECH_INPUT_ROWNUMBER1_6, MEDIA_DYNAMIC_DEVICE, SPEECH_NAVI_LAST_DESTINATIONS_DYNAMIC, SPEECH_INPUT_SDCARDNUMBER1_2, ONLINE_REMOTEHMI_GLOBAL, SPEECH_INPUT_MAILADDRESS, SPEECH_NAVI_FAVORITES_DYNAMIC, ONLINE_REMOTEHMI_HELP, ONLINE_REMOTEHMI};
    public static int[] SLOT_ORDER_ARRAY_400166 = new int[]{400150, 400152, 400151};
    public static int[] SLOT_ORDER_ARRAY_400288 = new int[]{400287, 400340};
    public static int[] SLOT_ORDER_ARRAY_400357 = new int[]{400198, 400261};
    public static int[] SLOT_ORDER_ARRAY_200125 = new int[]{200161, 200162};
    public static int[] SLOT_ORDER_ARRAY_800177 = new int[]{400148, 400150, 400149, 400152, 400151};
    public static int[] SLOT_ORDER_ARRAY_200046 = new int[]{200028, 200030};
    public static int[] SLOT_ORDER_ARRAY_200164 = new int[]{200161, 200162, 200160};
    public static int[] SLOT_ORDER_ARRAY_200044 = new int[]{200028, 200026};
    public static int[] SLOT_ORDER_ARRAY_800168 = new int[]{400152, 400151};
    public static int[] SLOT_ORDER_ARRAY_200039 = new int[]{200026, 200030};
    public static int[] SLOT_ORDER_ARRAY_800226 = new int[]{400381, 400191, 400382, 400192, 400193};
    public static int[] SLOT_ORDER_ARRAY_800225 = new int[]{400381, 400191, 400382, 400192, 400193};
    public static int[] SLOT_ORDER_ARRAY_400252 = new int[]{400203, 400259};
    public static int[] SLOT_ORDER_ARRAY_800224 = new int[]{400191, 400192, 400193};
    public static int[] SLOT_ORDER_ARRAY_800110 = new int[]{400377, 400200, 400378, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_800111 = new int[]{400377, 400200, 400378, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_800109 = new int[]{400200, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_400368 = new int[]{400369, 400370};
    public static int[] SLOT_ORDER_ARRAY_200149 = new int[]{200160, 200162};
    public static int[] SLOT_ORDER_ARRAY_400265 = new int[]{400266, 400333};
    public static int[] SLOT_ORDER_ARRAY_400196 = new int[]{400191, 400192, 400193};
    public static int[] SLOT_ORDER_ARRAY_200151 = new int[]{200160, 200161};
    public static int[] SLOT_ORDER_ARRAY_800222 = new int[]{400150, 400152, 400151};
    public static int[] SLOT_ORDER_ARRAY_400257 = new int[]{400203, 400259};
    public static int[] SLOT_ORDER_ARRAY_400207 = new int[]{400200, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_400258 = new int[]{400200, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_800144 = new int[]{400381, 400191, 400382, 400192, 400193};
    public static int[] SLOT_ORDER_ARRAY_255 = new int[]{256, 263};
    public static int[] SLOT_ORDER_ARRAY_2200072 = new int[]{2200071, 2200094};
    public static int[] SLOT_ORDER_ARRAY_800143 = new int[]{400377, 400200, 400378, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_800142 = new int[]{400200, 400202, 400201};
    public static int[] SLOT_ORDER_ARRAY_400347 = new int[]{400034, 400260};
    public static int[] SLOT_ORDER_ARRAY_800128 = new int[]{400148, 400150, 400149, 400152, 400151};
    public static int[] SLOT_ORDER_ARRAY_2200068 = new int[]{2200067, 2200093};

    public static int[] getSlotOrder(int n) {
        switch (n) {
            case 400166: {
                return SLOT_ORDER_ARRAY_400166;
            }
            case 400288: {
                return SLOT_ORDER_ARRAY_400288;
            }
            case 400357: {
                return SLOT_ORDER_ARRAY_400357;
            }
            case 200125: {
                return SLOT_ORDER_ARRAY_200125;
            }
            case 800177: {
                return SLOT_ORDER_ARRAY_800177;
            }
            case 200046: {
                return SLOT_ORDER_ARRAY_200046;
            }
            case 200164: {
                return SLOT_ORDER_ARRAY_200164;
            }
            case 200044: {
                return SLOT_ORDER_ARRAY_200044;
            }
            case 800168: {
                return SLOT_ORDER_ARRAY_800168;
            }
            case 200039: {
                return SLOT_ORDER_ARRAY_200039;
            }
            case 800226: {
                return SLOT_ORDER_ARRAY_800226;
            }
            case 800225: {
                return SLOT_ORDER_ARRAY_800225;
            }
            case 400252: {
                return SLOT_ORDER_ARRAY_400252;
            }
            case 800224: {
                return SLOT_ORDER_ARRAY_800224;
            }
            case 800110: {
                return SLOT_ORDER_ARRAY_800110;
            }
            case 800111: {
                return SLOT_ORDER_ARRAY_800111;
            }
            case 800109: {
                return SLOT_ORDER_ARRAY_800109;
            }
            case 400368: {
                return SLOT_ORDER_ARRAY_400368;
            }
            case 200149: {
                return SLOT_ORDER_ARRAY_200149;
            }
            case 400265: {
                return SLOT_ORDER_ARRAY_400265;
            }
            case 400196: {
                return SLOT_ORDER_ARRAY_400196;
            }
            case 200151: {
                return SLOT_ORDER_ARRAY_200151;
            }
            case 800222: {
                return SLOT_ORDER_ARRAY_800222;
            }
            case 400257: {
                return SLOT_ORDER_ARRAY_400257;
            }
            case 400207: {
                return SLOT_ORDER_ARRAY_400207;
            }
            case 400258: {
                return SLOT_ORDER_ARRAY_400258;
            }
            case 800144: {
                return SLOT_ORDER_ARRAY_800144;
            }
            case 255: {
                return SLOT_ORDER_ARRAY_255;
            }
            case 2200072: {
                return SLOT_ORDER_ARRAY_2200072;
            }
            case 800143: {
                return SLOT_ORDER_ARRAY_800143;
            }
            case 800142: {
                return SLOT_ORDER_ARRAY_800142;
            }
            case 400347: {
                return SLOT_ORDER_ARRAY_400347;
            }
            case 800128: {
                return SLOT_ORDER_ARRAY_800128;
            }
            case 2200068: {
                return SLOT_ORDER_ARRAY_2200068;
            }
        }
        return null;
    }
}


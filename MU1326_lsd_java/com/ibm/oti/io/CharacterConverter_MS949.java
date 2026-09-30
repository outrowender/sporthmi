/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.BinarySearch;

class CharacterConverter_MS949
extends CharacterConverter {
    private static String MS949 = "";
    private static String MS949Keys = "";
    private static String MS949Keys2 = "\uf900\uf901\uf902\uf903\uf904\uf905\uf906\uf907\uf908\uf909\uf90a\uf90b\uf90c\uf90d\uf90e\uf90f\uf910\uf911\uf912\uf913\uf914\uf915\uf916\uf917\uf918\uf919\uf91a\uf91b\uf91c\uf91d\uf91e\uf91f\uf920\uf921\uf922\uf923\uf924\uf925\uf926\uf927\uf928\uf929\uf92a\uf92b\uf92c\uf92d\uf92e\uf92f\uf930\uf931\uf932\uf933\uf934\uf935\uf936\uf937\uf938\uf939\uf93a\uf93b\uf93c\uf93d\uf93e\uf93f\uf940\uf941\uf942\uf943\uf944\uf945\uf946\uf947\uf948\uf949\uf94a\uf94b\uf94c\uf94d\uf94e\uf94f\uf950\uf951\uf952\uf953\uf954\uf955\uf956\uf957\uf958\uf959\uf95a\uf95b\uf95c\uf95d\uf95e\uf95f\uf960\uf961\uf962\uf963\uf964\uf965\uf966\uf967\uf968\uf969\uf96a\uf96b\uf96c\uf96d\uf96e\uf96f\uf970\uf971\uf972\uf973\uf974\uf975\uf976\uf977\uf978\uf979\uf97a\uf97b\uf97c\uf97d\uf97e\uf97f\uf980\uf981\uf982\uf983\uf984\uf985\uf986\uf987\uf988\uf989\uf98a\uf98b\uf98c\uf98d\uf98e\uf98f\uf990\uf991\uf992\uf993\uf994\uf995\uf996\uf997\uf998\uf999\uf99a\uf99b\uf99c\uf99d\uf99e\uf99f\uf9a0\uf9a1\uf9a2\uf9a3\uf9a4\uf9a5\uf9a6\uf9a7\uf9a8\uf9a9\uf9aa\uf9ab\uf9ac\uf9ad\uf9ae\uf9af\uf9b0\uf9b1\uf9b2\uf9b3\uf9b4\uf9b5\uf9b6\uf9b7\uf9b8\uf9b9\uf9ba\uf9bb\uf9bc\uf9bd\uf9be\uf9bf\uf9c0\uf9c1\uf9c2\uf9c3\uf9c4\uf9c5\uf9c6\uf9c7\uf9c8\uf9c9\uf9ca\uf9cb\uf9cc\uf9cd\uf9ce\uf9cf\uf9d0\uf9d1\uf9d2\uf9d3\uf9d4\uf9d5\uf9d6\uf9d7\uf9d8\uf9d9\uf9da\uf9db\uf9dc\uf9dd\uf9de\uf9df\uf9e0\uf9e1\uf9e2\uf9e3\uf9e4\uf9e5\uf9e6\uf9e7\uf9e8\uf9e9\uf9ea\uf9eb\uf9ec\uf9ed\uf9ee\uf9ef\uf9f0\uf9f1\uf9f2\uf9f3\uf9f4\uf9f5\uf9f6\uf9f7\uf9f8\uf9f9\uf9fa\uf9fb\uf9fc\uf9fd\uf9fe\uf9ff\ufa00\ufa01\ufa02\ufa03\ufa04\ufa05\ufa06\ufa07\ufa08\ufa09\ufa0a\ufa0b\uff01\uff02\uff03\uff04\uff05\uff06\uff07\uff08\uff09\uff0a\uff0b\uff0c\uff0d\uff0e\uff0f\uff10\uff11\uff12\uff13\uff14\uff15\uff16\uff17\uff18\uff19\uff1a\uff1b\uff1c\uff1d\uff1e\uff1f\uff20\uff21\uff22\uff23\uff24\uff25\uff26\uff27\uff28\uff29\uff2a\uff2b\uff2c\uff2d\uff2e\uff2f\uff30\uff31\uff32\uff33\uff34\uff35\uff36\uff37\uff38\uff39\uff3a\uff3b\uff3c\uff3d\uff3e\uff3f\uff40\uff41\uff42\uff43\uff44\uff45\uff46\uff47\uff48\uff49\uff4a\uff4b\uff4c\uff4d\uff4e\uff4f\uff50\uff51\uff52\uff53\uff54\uff55\uff56\uff57\uff58\uff59\uff5a\uff5b\uff5c\uff5d\uff5e\uffe0\uffe1\uffe2\uffe3\uffe5\uffe6";
    private static String MS949Values = "";
    private static String MS949Values2 = "\ucbd0\ucbd6\ucbe7\ucdcf\ucde8\ucead\ucffb\ud0a2\ud0b8\ud0d0\ud0dd\ud1d4\ud1d5\ud1d8\ud1db\ud1dc\ud1dd\ud1de\ud1df\ud1e0\ud1e2\ud1e3\ud1e4\ud1e5\ud1e6\ud1e8\ud1e9\ud1ea\ud1eb\ud1ed\ud1ef\ud1f0\ud1f2\ud1f6\ud1fa\ud1fc\ud1fd\ud1fe\ud2a2\ud2a3\ud2a7\ud2a8\ud2a9\ud2aa\ud2ab\ud2ad\ud2b2\ud2be\ud2c2\ud2c3\ud2c4\ud2c6\ud2c7\ud2c8\ud2c9\ud2ca\ud2cb\ud2cd\ud2ce\ud2cf\ud2d0\ud2d1\ud2d2\ud2d3\ud2d4\ud2d5\ud2d6\ud2d7\ud2d9\ud2da\ud2de\ud2df\ud2e1\ud2e2\ud2e4\ud2e5\ud2e6\ud2e7\ud2e8\ud2e9\ud2ea\ud2eb\ud2f0\ud2f1\ud2f2\ud2f3\ud2f4\ud2f5\ud2f7\ud2f8\ud4e6\ud4fc\ud5a5\ud5ab\ud5ae\ud6b8\ud6cd\ud7cb\ud7e4\udbc5\udbe4\udca5\udda5\uddd5\uddf4\udefc\udefe\udfb3\udfe1\udfe8\ue0f1\ue1ad\ue1ed\ue3f5\ue4a1\ue4a9\ue5ae\ue5b1\ue5b2\ue5b9\ue5bb\ue5bc\ue5c4\ue5ce\ue5d0\ue5d2\ue5d6\ue5fa\ue5fb\ue5fc\ue5fe\ue6a1\ue6a4\ue6a7\ue6ad\ue6af\ue6b0\ue6b1\ue6b3\ue6b7\ue6b8\ue6bc\ue6c4\ue6c6\ue6c7\ue6ca\ue6d2\ue6d6\ue6d9\ue6dc\ue6df\ue6e1\ue6e4\ue6e5\ue6e6\ue6e8\ue6ea\ue6eb\ue6ec\ue6ef\ue6f1\ue6f2\ue6f5\ue6f6\ue6f7\ue6f9\ue7a1\ue7a6\ue7a9\ue7aa\ue7ac\ue7ad\ue7b0\ue7bf\ue7c1\ue7c6\ue7c7\ue7cb\ue7cd\ue7cf\ue7d0\ue7d3\ue7df\ue7e4\ue7e6\ue7f7\ue8e7\ue8e8\ue8f0\ue8f1\ue8f7\ue8f9\ue8fb\ue8fe\ue9a7\ue9ac\ue9cc\ue9f7\ueac1\ueae5\ueaf4\ueaf7\ueafc\ueafe\ueba4\ueba7\ueba9\uebaa\uebba\uebbb\uebbd\uebc1\uebc2\uebc6\uebc7\uebcc\uebcf\uebd0\uebd1\uebd2\uebd8\ueca6\ueca7\uecaa\uecaf\uecb0\uecb1\uecb2\uecb5\uecb8\uecba\uecc0\uecc1\uecc5\uecc6\uecc9\uecca\uecd5\uecdd\uecde\uece1\uece4\uece7\uece8\uecf7\uecf8\uecfa\ueda1\ueda2\ueda3\uedee\ueedb\uf2bd\uf2fa\uf3b1\uf4a7\uf4ee\uf6f4\uf6f6\uf7b8\uf7c8\uf7d3\uf8db\uf8f0\ufaa1\ufaa2\ufae6\ufca9\ua3a1\ua3a2\ua3a3\ua3a4\ua3a5\ua3a6\ua3a7\ua3a8\ua3a9\ua3aa\ua3ab\ua3ac\ua3ad\ua3ae\ua3af\ua3b0\ua3b1\ua3b2\ua3b3\ua3b4\ua3b5\ua3b6\ua3b7\ua3b8\ua3b9\ua3ba\ua3bb\ua3bc\ua3bd\ua3be\ua3bf\ua3c0\ua3c1\ua3c2\ua3c3\ua3c4\ua3c5\ua3c6\ua3c7\ua3c8\ua3c9\ua3ca\ua3cb\ua3cc\ua3cd\ua3ce\ua3cf\ua3d0\ua3d1\ua3d2\ua3d3\ua3d4\ua3d5\ua3d6\ua3d7\ua3d8\ua3d9\ua3da\ua3db\ua1ac\ua3dd\ua3de\ua3df\ua3e0\ua3e1\ua3e2\ua3e3\ua3e4\ua3e5\ua3e6\ua3e7\ua3e8\ua3e9\ua3ea\ua3eb\ua3ec\ua3ed\ua3ee\ua3ef\ua3f0\ua3f1\ua3f2\ua3f3\ua3f4\ua3f5\ua3f6\ua3f7\ua3f8\ua3f9\ua3fa\ua3fb\ua3fc\ua3fd\ua2a6\ua1cb\ua1cc\ua1fe\ua3fe\ua1cd\ua3dc";
    private static final int byteMapLength = MS949.length();

    CharacterConverter_MS949() {
    }

    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = n + n2;
        int n4 = 0;
        while (n < n3) {
            int n5;
            if ((n5 = byArray[n++] & 0xFF) >= 128) {
                if (n >= n3) continue;
                ++n;
                ++n4;
                continue;
            }
            ++n4;
        }
        return n4;
    }

    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        n3 += n2;
        while (n2 < n3) {
            int n4;
            int n5;
            int n6;
            if ((n6 = byArray[n++] & 0xFF) < 128) {
                cArray[n2++] = (char)n6;
                continue;
            }
            if (n6 < 129 || n6 > 253 || (n5 = byArray[n++] & 0xFF) < 65 || n5 > 254 || n6 == 201) {
                cArray[n2++] = 65533;
                continue;
            }
            if (n5 > 128) {
                n5 -= 77;
            } else if (n5 > 96) {
                if (n5 >= 123) {
                    cArray[n2++] = 65533;
                    continue;
                }
                n5 -= 71;
            } else {
                if (n5 >= 91) {
                    cArray[n2++] = 65533;
                    continue;
                }
                n5 -= 65;
            }
            n6 = n6 >= 201 ? (n6 -= 130) : (n6 -= 129);
            cArray[n2++] = (n5 += n6 * 178) < byteMapLength && (n4 = MS949.charAt(n5)) != 0 ? n4 : 65533;
        }
        return n;
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = 0;
        n2 += n;
        int n4 = n;
        while (n4 < n2) {
            char c2 = cArray[n4];
            n3 = c2 < '\u0080' ? ++n3 : (n3 += 2);
            ++n4;
        }
        n4 = 0;
        String string = null;
        byte[] byArray = new byte[n3];
        int n5 = n;
        while (n5 < n2) {
            char c3 = cArray[n5];
            if (c3 < '\u0080') {
                byArray[n4++] = (byte)c3;
            } else {
                int n6;
                if (c3 <= '\ud7a3') {
                    string = MS949Values;
                    n6 = c3 >= '\uac00' ? 5506 + (c3 - 44032) : BinarySearch.binarySearch(MS949Keys, c3);
                } else {
                    string = MS949Values2;
                    n6 = BinarySearch.binarySearch(MS949Keys2, c3);
                }
                if (n6 == -1) {
                    byArray[n4++] = 63;
                } else {
                    char c4 = string.charAt(n6);
                    byte by = (byte)(c4 >> 8);
                    if (by != 0) {
                        byArray[n4++] = by;
                    }
                    byArray[n4++] = (byte)c4;
                }
            }
            ++n5;
        }
        if (n4 < byArray.length) {
            byte[] byArray2 = new byte[n4];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n4);
            byArray = byArray2;
        }
        return byArray;
    }
}


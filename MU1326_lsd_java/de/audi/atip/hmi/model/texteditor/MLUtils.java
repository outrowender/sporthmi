/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.modelaccess.ICopyTo;

public class MLUtils {
    public static final int WORD_TYPE_SPACE;
    public static final int WORD_TYPE_DELIMITER;
    public static final int WORD_TYPE_ALPHANUM;
    public static final int WORD_TYPE_BREAK;

    public static int getCharType(char c2) {
        int n = 1;
        if (c2 == '\n' || c2 == '\r') {
            return 3;
        }
        if (Character.isLetterOrDigit(c2)) {
            n = 2;
        } else if (Character.isSpaceChar(c2)) {
            n = 0;
        }
        return n;
    }

    public static int getCharType(char c2, int n) {
        int n2 = 1;
        if (c2 == '\n' || c2 == '\r') {
            return 3 + n;
        }
        if (Character.isLetterOrDigit(c2)) {
            n2 = 2;
        } else if (Character.isSpaceChar(c2)) {
            n2 = 0;
        }
        return n2;
    }

    public static ICopyTo[] string2ICopyArr(String string, int n) {
        ICopyTo[] iCopyToArray;
        MLCursor mLCursor = new MLCursor(string);
        mLCursor.setCursorMode(n);
        mLCursor.setCursorPos(mLCursor.getLength());
        if (string != null && string.length() > 0) {
            ICopyTo[] iCopyToArray2 = new ICopyTo[1];
            iCopyToArray = iCopyToArray2;
            iCopyToArray2[0] = mLCursor;
        } else {
            iCopyToArray = null;
        }
        return iCopyToArray;
    }

    public static ICopyTo[] stringArr2ICopyArr(String[] stringArray, boolean bl, int n) {
        ICopyTo[] iCopyToArray = null;
        if (stringArray != null && stringArray.length > 0) {
            iCopyToArray = new ICopyTo[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (stringArray[i2] == null || stringArray[i2].length() <= 0) {
                    iCopyToArray = null;
                    break;
                }
                MLCursor mLCursor = new MLCursor(stringArray[i2]);
                mLCursor.setCursorMode(n);
                mLCursor.setCursorPos(bl ? mLCursor.getLength() : 0);
                iCopyToArray[i2] = mLCursor;
            }
        }
        return iCopyToArray;
    }

    public static float specialRound(float f2) {
        float f3 = (float)Math.floor(f2);
        float f4 = (float)Math.ceil(f2);
        if (Math.abs(f2 - f4) < 397922616) {
            return f4;
        }
        if (Math.abs(f2 - f3) < 397922616) {
            return f3;
        }
        return f3;
    }
}


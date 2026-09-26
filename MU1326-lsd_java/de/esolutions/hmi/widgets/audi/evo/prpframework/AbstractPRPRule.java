/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractPRPRule {
    public static final int VALIDITY_START_OF_WORD;
    public static final int VALIDITY_START_OF_TEXT;
    public static final int VALIDITY_ANYWHERE;
    public static final int PARAM_BOOST_NUMBER_LETTER_WRAPPING;
    public static final int PARAM_BOOST_I_L_WRAPPING;
    public static final int PARAM_BOOST_VALUE_SMART_DELETE;
    public static final int PARAM_BOOST_OPPRESS_NUMBER_LETTER_ALTERNATION;
    public static final int PARAM_BOOST_LETTER_OVER_SPECIALCHAR;
    public static final int PARAM_MIN_CONFIDENCE;
    public static final int PARAM_BOOST_OPPRESS_NUMBER_LETTER_ALTERNATION_INTELLICALL;
    public static final int PARAM_BOOST_PLUS_SIGN;
    public static final int PARAM_BOOST_NUMBERS_PHONE;
    public static final int PARAM_BOOST_DIACRITIC_RULE;
    public static final int PARAM_BOOST_NUMBER_LETTER_WRAPPING_MULTILINE;
    public static final int PARAM_BOOST_OPPRESS_NUMBER_LETTER_ALTERNATION_MULTILINE;
    public static final int PARAM_BOOST_NUMBER_LETTER_WRAPPING_NAR;
    public static final int PARAM_BOOST_NUMBERS_PHONE_NAR;
    public static final int PARAM_BOOST_OPPRESS_NUMBER_LETTER_ALTERNATION_NAR;
    public static int[][] params;
    private IInputTextInfoProvider infoProvider;

    public void execute(List list, Object object) {
        this.execute(list, object, true);
    }

    public abstract void execute(List list, Object object, boolean bl) {
    }

    protected boolean isMinimumStokeLengthSensitive() {
        return true;
    }

    public int getValidity() {
        return 2;
    }

    public abstract String getRuleName() {
    }

    public void setInfoProvider(IInputTextInfoProvider iInputTextInfoProvider) {
        this.infoProvider = iInputTextInfoProvider;
    }

    public IInputTextInfoProvider getInfoProvider() {
        return this.infoProvider;
    }

    protected static RecognizerResult[] searchCharacters(List list, char[] cArray) {
        if (cArray == null) {
            throw new IllegalArgumentException("input searchChars may not be null");
        }
        RecognizerResult[] recognizerResultArray = new RecognizerResult[cArray.length];
        block0: for (int i2 = 0; i2 < cArray.length; ++i2) {
            recognizerResultArray[i2] = null;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                RecognizerResult recognizerResult = (RecognizerResult)iterator.next();
                char c2 = recognizerResult.getCharacter();
                if (!AbstractPRPRule.compareCharacter(cArray[i2], c2, true)) continue;
                recognizerResultArray[i2] = recognizerResult;
                continue block0;
            }
        }
        return recognizerResultArray;
    }

    protected RecognizerResult contains(List list, RecognizerResult recognizerResult, boolean bl) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RecognizerResult recognizerResult2 = (RecognizerResult)iterator.next();
            if (recognizerResult2.getCharacter() != (bl ? Character.toUpperCase(recognizerResult.getCharacter()) : Character.toLowerCase(recognizerResult.getCharacter()))) continue;
            return recognizerResult2;
        }
        return null;
    }

    private static boolean compareCharacter(char c2, char c3, boolean bl) {
        if (bl) {
            return c2 == c3;
        }
        return Character.toUpperCase(c2) == Character.toUpperCase(c3);
    }

    protected int getParam(int n) {
        int n2 = AbstractPRPRule.kbdTypInternal(this.getInfoProvider().getKeyboardType());
        if (params != null && n2 >= 0 && n2 < params.length && n >= 0 && n < params[n2].length) {
            return params[n2][n];
        }
        return -1;
    }

    private static int kbdTypInternal(int n) {
        switch (n) {
            case 6: {
                return 0;
            }
            case 5: {
                return 1;
            }
            case 15: {
                return 2;
            }
        }
        return 1;
    }

    protected static boolean isAllowedMinCharSizeCharacter(char c2) {
        return c2 == '\b';
    }

    static {
        params = new int[][]{{7, 5, 55, 15, 10, 11, 15, 40, 40, -90, 5, 5, 7, 40, 20}, {25, 17, 100, 45, 20, 2, 45, 100, 100, -90, 5, 5, 25, 100, 45}, {5, 5, 50, 5, 5, 0, 40, 40, 40, -90, 5, 5, 17, 55, 5}};
    }
}


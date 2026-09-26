/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import java.util.List;

public class FirstCharNumberLetterBoostRule
extends AbstractPRPRule {
    private int boostParamId = 0;

    public FirstCharNumberLetterBoostRule() {
    }

    public FirstCharNumberLetterBoostRule(int n) {
        this.boostParamId = n;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        if (AbstractWidget.isArabia() && TouchControllerArabia.isArabicCharSetActivated()) {
            return;
        }
        RecognizerResult[] recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'1', 'I'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
        recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'6', 'G'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
        recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'9', 'g'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
        recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'2', 'Z', 'z'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
        recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'5', 'S', 's'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
        recognizerResultArray = FirstCharNumberLetterBoostRule.searchCharacters(list, new char[]{'0', 'O', 'o'});
        this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
    }

    @Override
    public String getRuleName() {
        return "First-Char-Number-Letter-Boosting-Rule";
    }

    @Override
    public int getValidity() {
        return 0;
    }

    private void findAndBoostFirstCharLetter(RecognizerResult recognizerResult, RecognizerResult recognizerResult2, RecognizerResult recognizerResult3) {
        if (recognizerResult != null && (recognizerResult2 != null || recognizerResult3 != null)) {
            recognizerResult.boost(-this.getParam(this.boostParamId));
            if (recognizerResult2 != null) {
                recognizerResult2.boost(this.getParam(this.boostParamId));
            }
            if (recognizerResult3 != null) {
                recognizerResult3.boost(this.getParam(this.boostParamId));
            }
        }
    }

    private void findAndBoostFirstCharLetter(RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        this.findAndBoostFirstCharLetter(recognizerResult, recognizerResult2, null);
    }
}


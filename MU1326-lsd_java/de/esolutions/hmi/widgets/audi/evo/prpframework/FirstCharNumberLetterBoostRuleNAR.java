/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.List;

public class FirstCharNumberLetterBoostRuleNAR
extends AbstractPRPRule {
    private int boostParamId = 12;

    @Override
    public void execute(List list, Object object, boolean bl) {
        if (this.getInfoProvider().isStartOfWord()) {
            RecognizerResult[] recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'1', 'I', 'l'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
            recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'2', 'Z', 'z'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
            recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'5', 'S', 's'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
            recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'6', 'G'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
            recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'9', 'g', 'q'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1]);
            recognizerResultArray = FirstCharNumberLetterBoostRuleNAR.searchCharacters(list, new char[]{'0', 'O', 'o'});
            this.findAndBoostFirstCharLetter(recognizerResultArray[0], recognizerResultArray[1], recognizerResultArray[2]);
        }
    }

    @Override
    public String getRuleName() {
        return "First-Char-Number-Letter-Boosting-Rule-NAR";
    }

    @Override
    public int getValidity() {
        return 2;
    }

    private void findAndBoostFirstCharLetter(RecognizerResult recognizerResult, RecognizerResult recognizerResult2, RecognizerResult recognizerResult3) {
        if (recognizerResult != null && (recognizerResult2 != null || recognizerResult3 != null)) {
            int n = 1;
            if (this.getInfoProvider().isStartOfText()) {
                n = -1;
            }
            recognizerResult.boost(-this.getParam(this.boostParamId) * n);
            if (recognizerResult2 != null) {
                recognizerResult2.boost(this.getParam(this.boostParamId) * n);
            }
            if (recognizerResult3 != null) {
                recognizerResult3.boost(this.getParam(this.boostParamId) * n);
            }
        }
    }

    private void findAndBoostFirstCharLetter(RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        this.findAndBoostFirstCharLetter(recognizerResult, recognizerResult2, null);
    }
}


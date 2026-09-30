/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class UpperLowerCaseHandlingJPRule
extends AbstractPRPRule {
    private static final int MAX_ALTERNATIVE_LENGTH = 5;
    private final HashMap cachedCaseChars = new HashMap(5);

    public void execute(List list, Object object, boolean bl) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.checkCounterpart(list);
    }

    private void checkCounterpart(List list) {
        this.cachedCaseChars.clear();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            RecognizerResult recognizerResult = (RecognizerResult)list.get(n2);
            boolean bl = false;
            if (UpperLowerCaseHandlingJPRule.hasCaseVariant(recognizerResult)) {
                RecognizerResult recognizerResult2 = null;
                if (n2 + 1 < n) {
                    recognizerResult2 = (RecognizerResult)list.get(n2 + 1);
                }
                bl = this.checkRecognizedCharacters(list, recognizerResult, recognizerResult2);
            }
            if (bl) {
                n2 += 2;
                continue;
            }
            ++n2;
        }
        if (!this.cachedCaseChars.isEmpty()) {
            this.createTheMissingCase(list);
        }
    }

    private void createTheMissingCase(List list) {
        Iterator iterator = this.cachedCaseChars.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            List list2 = (List)this.cachedCaseChars.get(string);
            if (null == list2 || list2.isEmpty()) continue;
            for (int i2 = 0; i2 < list2.size(); ++i2) {
                RecognizerResult recognizerResult = (RecognizerResult)list2.get(i2);
                String string2 = String.valueOf(recognizerResult.getCharacter());
                int n = list.indexOf(recognizerResult);
                RecognizerResult recognizerResult2 = new RecognizerResult(string.charAt(0), recognizerResult.getConfidence());
                if (n == 4) {
                    list.remove(3);
                }
                if (AbstractToneAndCaseTogglingTable.isCapitalCase(string2)) {
                    list.add(list.indexOf(recognizerResult) + 1, recognizerResult2);
                    continue;
                }
                if (AbstractToneAndCaseTogglingTable.isLowCase(string2)) {
                    list.add(list.indexOf(recognizerResult), recognizerResult2);
                    continue;
                }
                IWidgetLogChannel.spellerLogChannel.log(10000, "CompletionCounterpartLowCapitalCaseJPRule#checkCounterpart: No Confirm of Low or Capital Case letter for the character %1", (Object)string2);
            }
        }
    }

    private static boolean hasCaseVariant(RecognizerResult recognizerResult) {
        String string = String.valueOf(recognizerResult.getCharacter());
        return AbstractToneAndCaseTogglingTable.hasCaseVariance(string);
    }

    private boolean checkRecognizedCharacters(List list, RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        if (null == recognizerResult2) {
            this.checkMissingCase(recognizerResult);
        } else if (UpperLowerCaseHandlingJPRule.hasCaseVariant(recognizerResult2)) {
            if (UpperLowerCaseHandlingJPRule.isInCaseVarianceGroup(recognizerResult, recognizerResult2)) {
                UpperLowerCaseHandlingJPRule.checkCaseSequence(list, recognizerResult, recognizerResult2);
                return true;
            }
            this.checkMissingCase(recognizerResult);
        } else {
            this.checkMissingCase(recognizerResult);
        }
        return false;
    }

    private void checkMissingCase(RecognizerResult recognizerResult) {
        String string = String.valueOf(recognizerResult.getCharacter());
        List list = null;
        if (this.cachedCaseChars.containsKey(string)) {
            list = (List)this.cachedCaseChars.get(string);
            if (null != list && !list.isEmpty()) {
                list.remove(0);
            } else {
                this.cachedCaseChars.remove(string);
            }
        } else {
            String string2 = AbstractToneAndCaseTogglingTable.getOppositeCaseCharacterAsString(string);
            list = (List)this.cachedCaseChars.get(string2);
            if (null == list) {
                list = new ArrayList();
                this.cachedCaseChars.put(string2, list);
            }
            list.add(recognizerResult);
        }
    }

    private static void swapConfidence(RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        int n = recognizerResult.getConfidence();
        recognizerResult.setConfidence(recognizerResult2.getConfidence());
        recognizerResult2.setConfidence(n);
    }

    private static boolean isInCaseVarianceGroup(RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        String string = String.valueOf(recognizerResult.getCharacter());
        String string2 = String.valueOf(recognizerResult2.getCharacter());
        return string2.equals(AbstractToneAndCaseTogglingTable.getOppositeCaseCharacterAsString(string));
    }

    private static void checkCaseSequence(List list, RecognizerResult recognizerResult, RecognizerResult recognizerResult2) {
        String string = String.valueOf(recognizerResult.getCharacter());
        if (!AbstractToneAndCaseTogglingTable.isCapitalCase(string)) {
            UpperLowerCaseHandlingJPRule.swapConfidence(recognizerResult, recognizerResult2);
            Collections.swap(list, list.indexOf(recognizerResult), list.indexOf(recognizerResult2));
        }
    }

    public String getRuleName() {
        return "Upper Lower Case Handling Rule(JP)";
    }
}


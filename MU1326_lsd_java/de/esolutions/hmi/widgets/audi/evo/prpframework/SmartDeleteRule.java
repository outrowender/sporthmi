/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmartDeleteRule
extends AbstractPRPRule {
    private List smartDeleteList = new ArrayList();
    private RecognizerResult lastInput;
    private boolean isCaseSensitive = true;
    private int lastDeleteIndex = -1;

    public SmartDeleteRule() {
    }

    public SmartDeleteRule(boolean bl) {
        this.isCaseSensitive = bl;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        RecognizerResult recognizerResult = SmartDeleteRule.searchCharacters(list, new char[]{'\b'})[0];
        if (recognizerResult != null && recognizerResult.getConfidence() > 70) {
            IWidgetLogChannel.logPRPEngine.log(-2137614336, "SmartDelete: Do nothing, because backspace is in the result!");
            return;
        }
        if (this.lastDeleteIndex > -1 && this.lastInput.getCharacter() != '\b' && this.lastDeleteIndex != this.getInfoProvider().getCurrentText().length() + 1) {
            this.resetSmartDelete();
        }
        IWidgetLogChannel.logPRPEngine.log(-2137614336, "SmartDelete: smartDeleteList=%1", (Object)this.smartDeleteList);
        List list2 = this.checkForLastDeleteChars(list);
        IWidgetLogChannel.logPRPEngine.log(-2137614336, "SmartDelete: matchedSmartDeleteList=%1", (Object)list2);
        if (list2.isEmpty()) {
            this.resetSmartDelete();
        } else {
            RecognizerResult recognizerResult2;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                recognizerResult2 = (RecognizerResult)iterator.next();
                recognizerResult2.resetBoost();
            }
            iterator = list2.iterator();
            while (iterator.hasNext()) {
                recognizerResult2 = (RecognizerResult)iterator.next();
                recognizerResult2.boost(-this.getParam(2));
            }
        }
    }

    private List checkForLastDeleteChars(List list) {
        if (this.smartDeleteList == null || this.smartDeleteList.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(this.smartDeleteList.size());
        char[] cArray = new char[this.smartDeleteList.size()];
        for (int i2 = 0; i2 < this.smartDeleteList.size(); ++i2) {
            RecognizerResult recognizerResult = (RecognizerResult)this.smartDeleteList.get(i2);
            cArray[i2] = recognizerResult.getCharacter();
        }
        RecognizerResult[] recognizerResultArray = SmartDeleteRule.searchCharacters(list, cArray);
        for (int i3 = 0; i3 < recognizerResultArray.length; ++i3) {
            if (recognizerResultArray[i3] == null) continue;
            arrayList.add(recognizerResultArray[i3]);
        }
        return arrayList;
    }

    @Override
    public String getRuleName() {
        return "Smart-Delete-Rule";
    }

    public void resetSmartDelete() {
        IWidgetLogChannel.logPRPEngine.log(-2137614336, "SmartDeleteRule#resetSmartDelete: called!");
        this.smartDeleteList.clear();
    }

    public void characterEntered(RecognizerResult recognizerResult) {
        IWidgetLogChannel.logPRPEngine.log(-2137614336, "SmartDeleteRule#characterEntered: character entered: %1 (lastInput=%2)", (Object)recognizerResult, (Object)this.lastInput);
        if (recognizerResult != null && recognizerResult.getCharacter() == '\b') {
            this.lastDeleteIndex = this.getInfoProvider().getCurrentText().length();
            if (this.lastInput != null && this.lastInput.getCharacter() != '\b') {
                this.smartDeleteList.add(this.lastInput);
                if (!this.isCaseSensitive) {
                    char c2 = this.lastInput.getCharacter();
                    if (Character.isUpperCase(c2)) {
                        RecognizerResult recognizerResult2 = new RecognizerResult(Character.toLowerCase(c2), 99);
                        this.smartDeleteList.add(recognizerResult2);
                    } else if (Character.isLowerCase(c2)) {
                        RecognizerResult recognizerResult3 = new RecognizerResult(Character.toUpperCase(c2), 99);
                        this.smartDeleteList.add(recognizerResult3);
                    }
                }
            } else {
                this.resetSmartDelete();
            }
        }
        this.lastInput = recognizerResult;
    }
}


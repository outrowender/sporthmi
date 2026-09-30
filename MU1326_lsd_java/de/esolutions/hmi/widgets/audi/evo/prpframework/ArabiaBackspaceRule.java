/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataArabia;
import java.util.List;

public class ArabiaBackspaceRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        if (!AbstractWidget.isArabia() || list.size() <= 0) {
            return;
        }
        ITouchInputDataArabia iTouchInputDataArabia = (ITouchInputDataArabia)this.getInfoProvider();
        if (iTouchInputDataArabia.isDeleteDirectionFromRightToLeft()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                RecognizerResult recognizerResult = (RecognizerResult)list.get(i2);
                if (recognizerResult == null) {
                    return;
                }
                char c2 = recognizerResult.getCharacter();
                int n = recognizerResult.getConfidence();
                if (c2 == ' ' || c2 == '_' || c2 == '-') {
                    list.set(i2, new RecognizerResult('\b', n));
                    continue;
                }
                if (c2 != '\b') continue;
                list.set(i2, new RecognizerResult(' ', n));
                list.add(i2 + 1, new RecognizerResult('_', n));
                list.add(i2 + 2, new RecognizerResult('-', n));
                break;
            }
        }
    }

    public String getRuleName() {
        return "Arabia-Backspace-Rule";
    }
}


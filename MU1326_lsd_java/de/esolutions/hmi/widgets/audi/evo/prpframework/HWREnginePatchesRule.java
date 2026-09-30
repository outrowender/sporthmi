/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import java.util.List;

public class HWREnginePatchesRule
extends AbstractPRPRule {
    public void execute(List list, Object object, boolean bl) {
        if (AbstractWidget.isArabia() && TouchControllerArabia.isArabicCharSetActivated()) {
            return;
        }
        RecognizerResult[] recognizerResultArray = HWREnginePatchesRule.searchCharacters(list, new char[]{'9', 'g', 'I', '1'});
        if (recognizerResultArray[0] != null && recognizerResultArray[1] == null) {
            list.add(new RecognizerResult('g', recognizerResultArray[0].getConfidence() - 1));
        }
        if (recognizerResultArray[2] != null && recognizerResultArray[3] == null) {
            list.add(new RecognizerResult('1', recognizerResultArray[2].getConfidence() - 1));
        }
    }

    public String getRuleName() {
        return "HWR-Engine-Patches";
    }
}


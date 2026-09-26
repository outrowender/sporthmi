/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterMap;
import java.util.ArrayList;
import java.util.List;

public class SimplifiedTraditionalMappingRule
extends AbstractPRPRule {
    private final ICharacterMap map;
    private int mapType = -1;

    public SimplifiedTraditionalMappingRule(ICharacterMap iCharacterMap) {
        this.map = iCharacterMap;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        char[] cArray;
        if (list.isEmpty()) {
            return;
        }
        LogChannel logChannel = IWidgetLogChannel.logPRPEngine;
        RecognizerResult recognizerResult = (RecognizerResult)list.get(0);
        if (null != logChannel && this.mapType != 0 && this.mapType != 1 && this.mapType != 2) {
            logChannel.log(-1601830656, "PRPEngine#WeirdRadicalMappingRule: using map type 1% is not defined in this rule", (long)this.mapType);
        }
        if ((cArray = this.map.getMappedCharacters(recognizerResult.getCharacter(), this.mapType)).length > 0) {
            SimplifiedTraditionalMappingRule.replaceMappedCharacters(list, cArray, 0, recognizerResult.getConfidence());
        }
    }

    private static void replaceMappedCharacters(List list, char[] cArray, int n, int n2) {
        int n3;
        ArrayList arrayList = new ArrayList(cArray.length);
        for (n3 = 0; n3 < cArray.length; ++n3) {
            arrayList.add(new RecognizerResult(cArray[n3], n2));
        }
        list.remove(n);
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            list.add(n, arrayList.get(n3));
        }
    }

    @Override
    public String getRuleName() {
        return "Simplified-traditional-mapping-rule";
    }

    public int getMapType() {
        return this.mapType;
    }

    public void setMapType(int n) {
        this.mapType = n;
    }
}


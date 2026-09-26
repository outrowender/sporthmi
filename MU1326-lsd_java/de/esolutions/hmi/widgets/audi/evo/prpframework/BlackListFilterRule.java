/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.prpframework.AbstractPRPRule;
import de.esolutions.hmi.widgets.audi.evo.prpframework.CharacterRegisterBinarySearch;
import de.esolutions.hmi.widgets.audi.evo.prpframework.RecognizerResult;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;
import java.util.Arrays;
import java.util.List;

public class BlackListFilterRule
extends AbstractPRPRule {
    private int validity;
    private String ruleName;

    public BlackListFilterRule(int n, String string) {
        this.ruleName = string;
        this.validity = n;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        ICharacterRegister iCharacterRegister;
        Object object2;
        IWidgetLogChannel.logPRPEngine.log(1078071040, "BlackListFilterRule#execute");
        if (object instanceof String) {
            object2 = ((String)object).toCharArray();
            Arrays.sort((char[])object2);
            iCharacterRegister = CharacterRegisterBinarySearch.createInstance(this.ruleName, WidgetConstants.EMPTY_CHAR_ARRAY, (char[])object2, WidgetConstants.EMPTY_CHAR_ARRAY);
        } else if (object instanceof ICharacterRegister) {
            iCharacterRegister = (ICharacterRegister)object;
        } else {
            IWidgetLogChannel.logPRPEngine.log(10000, "BlackListFilterRule#execute: no blacklist information given. Param was %1.", object);
            return;
        }
        object2 = list.iterator();
        while (object2.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)object2.next();
            char c2 = recognizerResult.getCharacter();
            if (!iCharacterRegister.contains(c2)) continue;
            object2.remove();
        }
    }

    @Override
    public int getValidity() {
        return this.validity;
    }

    @Override
    public String getRuleName() {
        return this.ruleName;
    }
}


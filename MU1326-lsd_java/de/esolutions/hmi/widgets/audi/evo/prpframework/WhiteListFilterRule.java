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

public class WhiteListFilterRule
extends AbstractPRPRule {
    private int validity;
    private String ruleName;
    private boolean useOnlyUpperCase = false;
    private boolean isCaseSensitive = true;
    private boolean isPhoneNumber = false;

    public WhiteListFilterRule(int n, String string) {
        this(n, string, false);
    }

    public WhiteListFilterRule(int n, String string, boolean bl) {
        this.ruleName = string;
        this.validity = n;
        this.useOnlyUpperCase = bl;
        this.isCaseSensitive = true;
    }

    public WhiteListFilterRule(int n, String string, boolean bl, boolean bl2) {
        this.ruleName = string;
        this.validity = n;
        this.useOnlyUpperCase = bl;
        this.isCaseSensitive = true;
        this.isPhoneNumber = bl2;
    }

    @Override
    public void execute(List list, Object object, boolean bl) {
        Object object2;
        IWidgetLogChannel.logPRPEngine.log(1078071040, "WhiteListFilterRule#execute additionalArgument = %1", object);
        ICharacterRegister iCharacterRegister = null;
        if (object instanceof String) {
            object2 = ((String)object).toCharArray();
            Arrays.sort((char[])object2);
            iCharacterRegister = CharacterRegisterBinarySearch.createInstance(this.ruleName, WidgetConstants.EMPTY_CHAR_ARRAY, (char[])object2, WidgetConstants.EMPTY_CHAR_ARRAY);
        } else if (object instanceof ICharacterRegister) {
            iCharacterRegister = (ICharacterRegister)object;
        } else {
            IWidgetLogChannel.logPRPEngine.log(10000, "WhiteListFilterRule#execute: no whitelist information given. Param was %1.", object);
            return;
        }
        object2 = list.iterator();
        while (object2.hasNext()) {
            RecognizerResult recognizerResult = (RecognizerResult)object2.next();
            char c2 = recognizerResult.getCharacter();
            boolean bl2 = false;
            if (c2 == '\b') continue;
            if (this.isValidCase(c2)) {
                if (this.isCaseSensitive) {
                    if (iCharacterRegister.contains(c2)) {
                        bl2 = true;
                    }
                } else if (iCharacterRegister.containsIgnoreCase(c2)) {
                    bl2 = true;
                }
            }
            if (c2 == '+') {
                bl2 = this.isPlusAllowed(iCharacterRegister);
            }
            if (bl2) continue;
            object2.remove();
        }
    }

    private boolean isValidCase(char c2) {
        if (this.useOnlyUpperCase) {
            boolean bl = Character.isLetter(c2);
            return c2 == '\u00df' || !bl || bl && Character.isUpperCase(c2);
        }
        return true;
    }

    @Override
    public int getValidity() {
        return this.validity;
    }

    @Override
    public String getRuleName() {
        return this.ruleName;
    }

    public void setCaseSensitive(boolean bl) {
        this.isCaseSensitive = bl;
    }

    public boolean isPlusAllowed(ICharacterRegister iCharacterRegister) {
        boolean bl;
        if (this.isPhoneNumber && !(bl = this.getInfoProvider().isStartOfText())) {
            return false;
        }
        return iCharacterRegister.containsIgnoreCase('+');
    }
}


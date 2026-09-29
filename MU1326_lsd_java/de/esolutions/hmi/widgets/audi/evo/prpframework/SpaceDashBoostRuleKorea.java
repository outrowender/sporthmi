/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.prpframework.SpaceDashBoostRuleAsia;

public class SpaceDashBoostRuleKorea
extends SpaceDashBoostRuleAsia {
    private static final char[] ruleDefinedChars = new char[]{' ', '\u3161', '-'};

    @Override
    protected char[] getRuleDefinedChars() {
        return ruleDefinedChars;
    }
}


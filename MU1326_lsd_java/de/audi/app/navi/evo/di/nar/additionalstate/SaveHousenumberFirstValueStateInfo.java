/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.additionalstate;

import de.audi.tghu.navi.app.li.IAdditionalStateInfo;

public class SaveHousenumberFirstValueStateInfo
implements IAdditionalStateInfo {
    private final String housenumberFirstValue;

    public SaveHousenumberFirstValueStateInfo(String string) {
        this.housenumberFirstValue = string;
    }

    @Override
    public void gatherInfo() {
    }

    @Override
    public void restoreBefore() {
    }

    @Override
    public void restoreAfter() {
    }

    public String toString() {
        return new StringBuffer().append("Value for housenumberfirst is ").append(this.housenumberFirstValue).toString();
    }

    public String getHousenumberFirstValue() {
        return this.housenumberFirstValue;
    }
}


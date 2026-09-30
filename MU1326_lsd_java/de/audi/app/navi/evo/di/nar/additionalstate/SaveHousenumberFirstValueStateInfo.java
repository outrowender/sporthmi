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

    public void gatherInfo() {
    }

    public void restoreBefore() {
    }

    public void restoreAfter() {
    }

    public String toString() {
        return "Value for housenumberfirst is " + this.housenumberFirstValue;
    }

    public String getHousenumberFirstValue() {
        return this.housenumberFirstValue;
    }
}


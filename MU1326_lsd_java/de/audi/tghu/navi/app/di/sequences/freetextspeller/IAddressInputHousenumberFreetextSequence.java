/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.di.sequences.freetextspeller.IAddressInputFreetextSpellerSequence;

public interface IAddressInputHousenumberFreetextSequence
extends IAddressInputFreetextSpellerSequence {
    public void selectAlternativeHousenumber();

    public void ignoreHousenumber();

    public void setHousenumber(String var1, boolean var2);

    public void updatePreviewHousenumber(String var1);
}


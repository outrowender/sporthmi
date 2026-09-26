/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.di.sequences.freetextspeller.IAddressInputFreetextSpellerSequence;

public interface IAddressInputHousenumberFreetextSequence
extends IAddressInputFreetextSpellerSequence {
    default public void selectAlternativeHousenumber() {
    }

    default public void ignoreHousenumber() {
    }

    default public void setHousenumber(String string, boolean bl) {
    }

    default public void updatePreviewHousenumber(String string) {
    }
}


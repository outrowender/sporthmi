/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputSDSSequence$SpellingResult {
    private final LIValueListElement element;
    private final LISpellerData liSpellerData;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    public AddressInputSDSSequence$SpellingResult(AddressInputSDSSequence addressInputSDSSequence, LIValueListElement lIValueListElement, LISpellerData lISpellerData) {
        this.this$0 = addressInputSDSSequence;
        this.element = lIValueListElement;
        this.liSpellerData = lISpellerData;
    }

    public LIValueListElement getElement() {
        return this.element;
    }

    public LISpellerData getLiSpellerData() {
        return this.liSpellerData;
    }
}


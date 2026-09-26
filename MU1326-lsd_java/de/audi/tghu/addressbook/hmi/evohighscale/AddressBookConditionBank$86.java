/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenFactory;

class AddressBookConditionBank$86
extends AbstractCondition {
    private final /* synthetic */ AddressBookConditionBank this$0;

    AddressBookConditionBank$86(AddressBookConditionBank addressBookConditionBank) {
        this.this$0 = addressBookConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{14, 523, 1739590144, -1330640384, -1297085952, -1280308736};
    }

    @Override
    public boolean evaluate(int n) {
        return AddressBookScreenFactory.evalCond701358(n);
    }
}


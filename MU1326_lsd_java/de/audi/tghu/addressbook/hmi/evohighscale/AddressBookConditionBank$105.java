/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenFactory;

class AddressBookConditionBank$105
extends AbstractCondition {
    private final /* synthetic */ AddressBookConditionBank this$0;

    AddressBookConditionBank$105(AddressBookConditionBank addressBookConditionBank) {
        this.this$0 = addressBookConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{556, 4078, 5583, 5605, 1555040768, 2075134464};
    }

    @Override
    public boolean evaluate(int n) {
        return AddressBookScreenFactory.evalCond701453(n);
    }
}


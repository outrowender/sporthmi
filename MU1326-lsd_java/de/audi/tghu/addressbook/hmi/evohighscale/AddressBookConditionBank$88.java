/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenFactory;

class AddressBookConditionBank$88
extends AbstractCondition {
    private final /* synthetic */ AddressBookConditionBank this$0;

    AddressBookConditionBank$88(AddressBookConditionBank addressBookConditionBank) {
        this.this$0 = addressBookConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{177, 3939};
    }

    @Override
    public boolean evaluate(int n) {
        return AddressBookScreenFactory.evalCond701435(n);
    }
}


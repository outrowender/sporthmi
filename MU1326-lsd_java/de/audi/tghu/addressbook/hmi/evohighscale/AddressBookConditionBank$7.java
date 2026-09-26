/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;

class AddressBookConditionBank$7
extends AbstractCondition {
    private final /* synthetic */ AddressBookConditionBank this$0;

    AddressBookConditionBank$7(AddressBookConditionBank addressBookConditionBank) {
        this.this$0 = addressBookConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{766511616};
    }

    @Override
    public boolean evaluate(int n) {
        return AddressBookConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(766511616, n, 0);
    }
}


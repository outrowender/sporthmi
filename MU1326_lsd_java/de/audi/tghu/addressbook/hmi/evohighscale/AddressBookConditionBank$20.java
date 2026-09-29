/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookConditionBank;

class AddressBookConditionBank$20
extends AbstractCondition {
    private final /* synthetic */ AddressBookConditionBank this$0;

    AddressBookConditionBank$20(AddressBookConditionBank addressBookConditionBank) {
        this.this$0 = addressBookConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1789921792};
    }

    @Override
    public boolean evaluate(int n) {
        return AddressBookConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(1789921792, n, 0);
    }
}


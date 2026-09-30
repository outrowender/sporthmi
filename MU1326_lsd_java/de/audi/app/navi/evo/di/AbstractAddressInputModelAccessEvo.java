/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAddressInputModelAccessEvo
implements IMatchspellerModelAccess {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final IAddressInputFormModelAccessHelper modelAccessHelper;

    public AbstractAddressInputModelAccessEvo(IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    public void onSpellerStatusChanged(int n) {
    }
}


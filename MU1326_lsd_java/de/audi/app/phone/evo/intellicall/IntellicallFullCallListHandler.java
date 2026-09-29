/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.evo.intellicall.AbstractIntellicallCallListModelHandler;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;

public class IntellicallFullCallListHandler
extends AbstractIntellicallCallListModelHandler
implements OptionModelListener {
    public IntellicallFullCallListHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    @Override
    protected BaseListModelApp getCallListList() {
        return this.getBaseListModel(462881792);
    }
}


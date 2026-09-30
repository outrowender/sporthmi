/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.app.combi.bap.app.AbstractListManager;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListAdapterBAP;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListAdapterFastList;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListHandler;
import de.audi.app.combi.bap.app.phone.list.FavoriteNumbersListAdapterBAP;
import de.audi.app.combi.bap.app.phone.list.FavoriteNumbersListAdapterFastList;
import de.audi.app.combi.bap.app.phone.list.FavoriteNumbersListHandler;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler;
import de.audi.app.combi.bap.app.phone.list.PhonebookListAdapterBAP;
import de.audi.app.combi.bap.app.phone.list.PhonebookListAdapterFastList;
import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListPhone;

public class ListManagerPhone
extends AbstractListManager {
    public ListManagerPhone(CombiModulePhone combiModulePhone, boolean bl) {
        super(combiModulePhone, bl, new DSIFastListPhone());
        Object object;
        Object object2;
        CombinedNumbersListHandler combinedNumbersListHandler = new CombinedNumbersListHandler(combiModulePhone);
        combinedNumbersListHandler.addListAdapter(new CombinedNumbersListAdapterBAP(combiModulePhone, combinedNumbersListHandler));
        if (bl) {
            object2 = new CombinedNumbersListAdapterFastList(combinedNumbersListHandler);
            this.fastListAdapters.add(object2);
            combinedNumbersListHandler.addListAdapter((IListAdapter)object2);
        }
        combiModulePhone.getBAPFunctionArrayFSG(49).setArrayHandler(combinedNumbersListHandler);
        object2 = new FavoriteNumbersListHandler(combiModulePhone);
        ((AbstractArrayHandler)object2).addListAdapter(new FavoriteNumbersListAdapterBAP(combiModulePhone, (ArrayHandler)object2));
        if (bl) {
            object = new FavoriteNumbersListAdapterFastList((FavoriteNumbersListHandler)object2);
            this.fastListAdapters.add(object);
            ((AbstractArrayHandler)object2).addListAdapter((IListAdapter)object);
        }
        combiModulePhone.getBAPFunctionArrayFSG(60).setArrayHandler((ArrayHandler)object2);
        object = new PhonebookHandler(combiModulePhone);
        ((AbstractArrayHandler)object).addListAdapter(new PhonebookListAdapterBAP(combiModulePhone, (ArrayHandler)object));
        if (bl) {
            PhonebookListAdapterFastList phonebookListAdapterFastList = new PhonebookListAdapterFastList(combiModulePhone, (PhonebookHandler)object);
            this.fastListAdapters.add(phonebookListAdapterFastList);
            ((AbstractArrayHandler)object).addListAdapter(phonebookListAdapterFastList);
        }
        combiModulePhone.getBAPFunctionArrayFSG(52).setArrayHandler((ArrayHandler)object);
    }

    protected int convertMostOperationState(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 15;
            }
        }
        return 0;
    }
}


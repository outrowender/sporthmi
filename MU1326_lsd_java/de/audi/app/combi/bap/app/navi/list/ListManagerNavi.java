/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.app.combi.bap.app.AbstractListManager;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.app.combi.bap.app.navi.list.AddressListAdapterBAP;
import de.audi.app.combi.bap.app.navi.list.AddressListArrayHandler;
import de.audi.app.combi.bap.app.navi.list.FavoriteDestinationsListAdapterBAP;
import de.audi.app.combi.bap.app.navi.list.FavoriteDestinationsListAdapterFastList;
import de.audi.app.combi.bap.app.navi.list.FavoriteDestinationsListHandler;
import de.audi.app.combi.bap.app.navi.list.LaneGuidanceHandler;
import de.audi.app.combi.bap.app.navi.list.LaneGuidanceListAdapterBAP;
import de.audi.app.combi.bap.app.navi.list.LastDestinationsListAdapterBAP;
import de.audi.app.combi.bap.app.navi.list.LastDestinationsListAdapterFastList;
import de.audi.app.combi.bap.app.navi.list.LastDestinationsListHandler;
import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListNavi;

public class ListManagerNavi
extends AbstractListManager {
    public ListManagerNavi(CombiModuleNavi combiModuleNavi, boolean bl) {
        super(combiModuleNavi, bl, new DSIFastListNavi());
        Object object;
        Object object2;
        LaneGuidanceHandler laneGuidanceHandler = new LaneGuidanceHandler(combiModuleNavi);
        laneGuidanceHandler.addListAdapter(new LaneGuidanceListAdapterBAP(combiModuleNavi, laneGuidanceHandler));
        combiModuleNavi.getBAPFunctionArrayFSG(24).setArrayHandler(laneGuidanceHandler);
        LastDestinationsListHandler lastDestinationsListHandler = new LastDestinationsListHandler(combiModuleNavi);
        lastDestinationsListHandler.addListAdapter(new LastDestinationsListAdapterBAP(combiModuleNavi, lastDestinationsListHandler));
        if (bl) {
            object2 = new LastDestinationsListAdapterFastList(lastDestinationsListHandler);
            this.fastListAdapters.add(object2);
            lastDestinationsListHandler.addListAdapter((IListAdapter)object2);
        }
        combiModuleNavi.getBAPFunctionArrayFSG(29).setArrayHandler(lastDestinationsListHandler);
        object2 = new FavoriteDestinationsListHandler(combiModuleNavi);
        ((AbstractArrayHandler)object2).addListAdapter(new FavoriteDestinationsListAdapterBAP(combiModuleNavi, (ArrayHandler)object2));
        if (bl) {
            object = new FavoriteDestinationsListAdapterFastList((FavoriteDestinationsListHandler)object2);
            this.fastListAdapters.add(object);
            ((AbstractArrayHandler)object2).addListAdapter((IListAdapter)object);
        }
        combiModuleNavi.getBAPFunctionArrayFSG(30).setArrayHandler((ArrayHandler)object2);
        object = new AddressListArrayHandler(combiModuleNavi);
        ((AbstractArrayHandler)object).addListAdapter(new AddressListAdapterBAP(combiModuleNavi, (ArrayHandler)object));
        combiModuleNavi.getBAPFunctionArrayFSG(33).setArrayHandler((ArrayHandler)object);
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


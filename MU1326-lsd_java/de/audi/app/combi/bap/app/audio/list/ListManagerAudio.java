/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.app.combi.bap.app.AbstractListManager;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.CommonListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.CommonListHandler;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListAdapterFastList;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import de.audi.app.combi.bap.app.audio.list.RadioTVPresetListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.RadioTVPresetListHandler;
import de.audi.app.combi.bap.app.audio.list.ReceptionListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.ReceptionListAdapterFastList;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.app.audio.list.SourceListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListAudio;

public class ListManagerAudio
extends AbstractListManager {
    public ListManagerAudio(CombiModuleAudio combiModuleAudio, boolean bl) {
        super(combiModuleAudio, bl, new DSIFastListAudio());
        Object object;
        Object object2;
        ReceptionListHandler receptionListHandler = new ReceptionListHandler(combiModuleAudio);
        receptionListHandler.addListAdapter(new ReceptionListAdapterBAP(combiModuleAudio, receptionListHandler));
        if (bl) {
            object2 = new ReceptionListAdapterFastList(receptionListHandler);
            this.fastListAdapters.add(object2);
            receptionListHandler.addListAdapter((IListAdapter)object2);
        }
        combiModuleAudio.getBAPFunctionArrayFSG(23).setArrayHandler(receptionListHandler);
        object2 = new SourceListHandler(combiModuleAudio);
        ((AbstractArrayHandler)object2).addListAdapter(new SourceListAdapterBAP(combiModuleAudio, (SourceListHandler)object2));
        combiModuleAudio.getBAPFunctionArrayFSG(32).setArrayHandler((ArrayHandler)object2);
        RadioTVPresetListHandler radioTVPresetListHandler = new RadioTVPresetListHandler(combiModuleAudio);
        radioTVPresetListHandler.addListAdapter(new RadioTVPresetListAdapterBAP(combiModuleAudio, radioTVPresetListHandler));
        combiModuleAudio.getBAPFunctionArrayFSG(33).setArrayHandler(radioTVPresetListHandler);
        MediaBrowserListHandler mediaBrowserListHandler = new MediaBrowserListHandler(combiModuleAudio);
        mediaBrowserListHandler.addListAdapter(new MediaBrowserListAdapterBAP(combiModuleAudio, mediaBrowserListHandler));
        if (bl) {
            object = new MediaBrowserListAdapterFastList(combiModuleAudio, mediaBrowserListHandler);
            this.fastListAdapters.add(object);
            mediaBrowserListHandler.addListAdapter((IListAdapter)object);
        }
        combiModuleAudio.getBAPFunctionArrayFSG(36).setArrayHandler(mediaBrowserListHandler);
        object = new CommonListHandler(combiModuleAudio);
        ((AbstractArrayHandler)object).addListAdapter(new CommonListAdapterBAP(combiModuleAudio, (ArrayHandler)object));
        combiModuleAudio.getBAPFunctionArrayFSG(50).setArrayHandler((ArrayHandler)object);
    }

    @Override
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


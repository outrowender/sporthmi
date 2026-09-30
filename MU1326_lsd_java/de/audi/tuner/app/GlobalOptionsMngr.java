/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.listener.MessageListener;

public class GlobalOptionsMngr {
    public final MessageListener messageListener = new MyMessageListener();
    private final TunerModels models;
    private final TunerStorage storage;
    private int imgType;
    private final MemoryListHandler memory;
    private final HistoryTuner historyTuner;
    private final ChoiceListener choiceListener = new ChoiceListener();
    private final CombiBAPServiceHandler combi;

    GlobalOptionsMngr(TunerBasics tunerBasics, TunerStorage tunerStorage, MemoryListHandler memoryListHandler, HistoryTuner historyTuner, CombiBAPServiceHandler combiBAPServiceHandler) {
        this.models = tunerBasics.getModels();
        this.storage = tunerStorage;
        this.memory = memoryListHandler;
        this.historyTuner = historyTuner;
        this.imgType = this.storage.loadPreferredImageType();
        this.combi = combiBAPServiceHandler;
        int n = Utilities.getImgConfig();
        if (this.imgType == 2 && (n & 4) != 4) {
            this.imgType = GlobalOptionsMngr.getDefaultPreferedImgType();
        }
        if (Utilities.countBits(n) > 1) {
            this.models.getChoiceModel(100548).setStatus(1);
        } else {
            this.models.getChoiceModel(100548).setStatus(0);
        }
        this.models.getChoiceModel(100548).addHint(n);
        this.models.getChoiceModel(100548).setValue(this.imgType);
        this.models.getChoiceModel(100548).setChoiceListener(this.choiceListener);
    }

    public static int getDefaultPreferedImgType() {
        if (Utilities.isPGen1OrBentley()) {
            return 0;
        }
        if (Utilities.isGraceNoteLocal() || Utilities.isNARBuild()) {
            return 1;
        }
        if (Utilities.isDABEPGPresent()) {
            return 0;
        }
        return 2;
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            GlobalOptionsMngr.this.models.getChoiceModel(n).setValue(n2);
            if (n2 != GlobalOptionsMngr.this.imgType) {
                GlobalOptionsMngr.this.imgType = n2;
                GlobalOptionsMngr.this.storage.storePreferredImageType(GlobalOptionsMngr.this.imgType);
                TunerProxyManager.getInstance().getStationListHandler(1).setPrefImgType(GlobalOptionsMngr.this.imgType);
                TunerProxyManager.getInstance().getStationListHandler(5).setPrefImgType(GlobalOptionsMngr.this.imgType);
                TunerProxyManager.getInstance().getStationListHandler(11).setPrefImgType(GlobalOptionsMngr.this.imgType);
                TunerProxyManager.getInstance().getStationListHandler(7).setPrefImgType(GlobalOptionsMngr.this.imgType);
                GlobalOptionsMngr.this.memory.setPreferredImgType(GlobalOptionsMngr.this.imgType);
                GlobalOptionsMngr.this.combi.setPreferredImgType(GlobalOptionsMngr.this.imgType);
                if (GlobalOptionsMngr.this.historyTuner != null) {
                    GlobalOptionsMngr.this.historyTuner.setPreferredImgType(GlobalOptionsMngr.this.imgType);
                }
            }
        }
    }

    private class MyMessageListener
    extends MessageListener {
        private MyMessageListener() {
        }

        public void resetToDefaultSettings() {
            int n = GlobalOptionsMngr.getDefaultPreferedImgType();
            GlobalOptionsMngr.this.choiceListener.itemSelected(100548, n, 0, 0);
        }
    }
}


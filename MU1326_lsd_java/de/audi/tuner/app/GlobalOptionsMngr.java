/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.GlobalOptionsMngr$ChoiceListener;
import de.audi.tuner.app.GlobalOptionsMngr$MyMessageListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.listener.MessageListener;

public class GlobalOptionsMngr {
    public final MessageListener messageListener = new GlobalOptionsMngr$MyMessageListener(this, null);
    private final TunerModels models;
    private final TunerStorage storage;
    private int imgType;
    private final MemoryListHandler memory;
    private final HistoryTuner historyTuner;
    private final GlobalOptionsMngr$ChoiceListener choiceListener = new GlobalOptionsMngr$ChoiceListener(this, null);
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
            this.models.getChoiceModel(-997719808).setStatus(1);
        } else {
            this.models.getChoiceModel(-997719808).setStatus(0);
        }
        this.models.getChoiceModel(-997719808).addHint(n);
        this.models.getChoiceModel(-997719808).setValue(this.imgType);
        this.models.getChoiceModel(-997719808).setChoiceListener(this.choiceListener);
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

    static /* synthetic */ TunerModels access$200(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.models;
    }

    static /* synthetic */ int access$300(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.imgType;
    }

    static /* synthetic */ int access$302(GlobalOptionsMngr globalOptionsMngr, int n) {
        globalOptionsMngr.imgType = n;
        return globalOptionsMngr.imgType;
    }

    static /* synthetic */ TunerStorage access$400(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.storage;
    }

    static /* synthetic */ MemoryListHandler access$500(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.memory;
    }

    static /* synthetic */ CombiBAPServiceHandler access$600(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.combi;
    }

    static /* synthetic */ HistoryTuner access$700(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.historyTuner;
    }

    static /* synthetic */ GlobalOptionsMngr$ChoiceListener access$800(GlobalOptionsMngr globalOptionsMngr) {
        return globalOptionsMngr.choiceListener;
    }
}


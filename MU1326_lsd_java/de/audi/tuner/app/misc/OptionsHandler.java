/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.misc;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.misc.IOptionsListener;
import de.audi.tuner.app.misc.OptionsHandler$ChoiceListener;
import de.audi.tuner.app.storage.TunerStorage;
import java.util.ArrayList;

public class OptionsHandler {
    private final TunerModels models;
    private final TunerStorage storage;
    private final TunerStatus status;
    private final ArrayList optionsListener = new ArrayList(3);
    private final Object mutex;

    public OptionsHandler(TunerStorage tunerStorage, TunerBasics tunerBasics) {
        this.models = tunerBasics.getModels();
        this.storage = tunerStorage;
        this.status = tunerBasics.getStatus();
        this.mutex = new Object();
        OptionsHandler$ChoiceListener optionsHandler$ChoiceListener = new OptionsHandler$ChoiceListener(this, null);
        this.models.getChoiceModel(394920192).setChoiceListener(optionsHandler$ChoiceListener);
        this.models.getChoiceModel(210370816).setChoiceListener(optionsHandler$ChoiceListener);
        int n = tunerStorage.isShowRadioText() ? 1 : 0;
        optionsHandler$ChoiceListener.itemSelected(394920192, n, 0, 0);
        optionsHandler$ChoiceListener.itemSelected(210370816, tunerStorage.getAmfmView(), 0, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addOptionListener(IOptionsListener iOptionsListener) {
        Object object = this.mutex;
        synchronized (object) {
            this.optionsListener.add(iOptionsListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyAmFmViewChanged(int n) {
        ArrayList arrayList;
        Object object = this.mutex;
        synchronized (object) {
            arrayList = new ArrayList(this.optionsListener);
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((IOptionsListener)object.next()).amFmViewChanged(n);
        }
    }

    static /* synthetic */ TunerStorage access$100(OptionsHandler optionsHandler) {
        return optionsHandler.storage;
    }

    static /* synthetic */ TunerStatus access$200(OptionsHandler optionsHandler) {
        return optionsHandler.status;
    }

    static /* synthetic */ void access$300(OptionsHandler optionsHandler, int n) {
        optionsHandler.notifyAmFmViewChanged(n);
    }

    static /* synthetic */ TunerModels access$400(OptionsHandler optionsHandler) {
        return optionsHandler.models;
    }
}


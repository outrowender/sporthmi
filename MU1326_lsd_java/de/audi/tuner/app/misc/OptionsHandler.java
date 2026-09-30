/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.misc;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.misc.IOptionsListener;
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
        ChoiceListener choiceListener = new ChoiceListener();
        this.models.getChoiceModel(100887).setChoiceListener(choiceListener);
        this.models.getChoiceModel(100876).setChoiceListener(choiceListener);
        int n = tunerStorage.isShowRadioText() ? 1 : 0;
        choiceListener.itemSelected(100887, n, 0, 0);
        choiceListener.itemSelected(100876, tunerStorage.getAmfmView(), 0, 0);
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

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            switch (n) {
                case 100887: {
                    OptionsHandler.this.storage.storeShowRadioText(n2 == 1);
                    break;
                }
                case 100876: {
                    OptionsHandler.this.storage.storeAmfmView(n2);
                    OptionsHandler.this.status.setPorscheNameMode(n2 == 0);
                    TunerProxyManager.getInstance().getAmFmTuner().reNotification(2);
                    OptionsHandler.this.notifyAmFmViewChanged(n2);
                    break;
                }
            }
            OptionsHandler.this.models.getChoiceModel(n).setValue(n2);
        }
    }
}


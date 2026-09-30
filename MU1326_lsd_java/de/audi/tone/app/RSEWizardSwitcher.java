/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class RSEWizardSwitcher
extends AbstractAppListener {
    private static final int A2LS_FULL_WIZARD = 0;
    private static final int WIRED_HP_WIZARD = 1;
    private static final int BT_HP_NO_WIZARD = 2;
    private static final int DEFAULT_WIZARD = 1;
    private final Object mutex = new Object();
    private final ToneEnv env;

    public RSEWizardSwitcher(ToneEnv toneEnv) {
        this.env = toneEnv;
        toneEnv.getChoiceModel(3, 1000013).setValue(1);
        toneEnv.getChoiceModel(4, 1000013).setValue(1);
    }

    public void updateA2LSStatus(int n) {
        this.update(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(int n) {
        int n2;
        Object object = this.mutex;
        synchronized (object) {
            n2 = this.isA2LSActive(n) ? 0 : (this.isWiredPlugged(n) ? 1 : (this.isBTBonded(n) ? 2 : 1));
            this.env.getChoiceModel(n, 1000013).setValue(n2);
        }
        this.env.lcMain.log(10000000, "[WizardSwitcher.update] HT:%1 wizard:%2", (long)n, (long)n2);
    }

    private boolean isA2LSActive(int n) {
        ChoiceModelApp choiceModelApp = this.env.getSystemChoiceModel(n, 217);
        return choiceModelApp.getValue() == 0;
    }

    private boolean isBTBonded(int n) {
        switch (n) {
            default: 
        }
        return false;
    }

    private boolean isWiredPlugged(int n) {
        switch (n) {
            default: 
        }
        return false;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.AsiaMapContentHMIListener$AisaMapContentChoiceListener;

public class AsiaMapContentHMIListener {
    private static final int UNCHECKED;
    private static final int CHECKED;
    private NavigationEnv env;

    public AsiaMapContentHMIListener(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.initListeners();
    }

    private final void initListeners() {
        AsiaMapContentHMIListener$AisaMapContentChoiceListener asiaMapContentHMIListener$AisaMapContentChoiceListener = new AsiaMapContentHMIListener$AisaMapContentChoiceListener(this, null);
        this.env.getChoiceModel(-1491008000).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
        this.env.getChoiceModel(-1474230784).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
        this.env.getChoiceModel(-1457453568).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
        this.env.getChoiceModel(-1591933440).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
        this.env.getChoiceModel(-1407121920).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
        this.env.getChoiceModel(-1440676352).setChoiceListener(asiaMapContentHMIListener$AisaMapContentChoiceListener);
    }

    static /* synthetic */ NavigationEnv access$100(AsiaMapContentHMIListener asiaMapContentHMIListener) {
        return asiaMapContentHMIListener.env;
    }
}


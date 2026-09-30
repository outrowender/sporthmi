/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;

public class AsiaMapContentHMIListener {
    private static final int UNCHECKED = 0;
    private static final int CHECKED = 1;
    private NavigationEnv env;

    public AsiaMapContentHMIListener(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.initListeners();
    }

    private final void initListeners() {
        AisaMapContentChoiceListener aisaMapContentChoiceListener = new AisaMapContentChoiceListener();
        this.env.getChoiceModel(401831).setChoiceListener(aisaMapContentChoiceListener);
        this.env.getChoiceModel(401832).setChoiceListener(aisaMapContentChoiceListener);
        this.env.getChoiceModel(401833).setChoiceListener(aisaMapContentChoiceListener);
        this.env.getChoiceModel(400801).setChoiceListener(aisaMapContentChoiceListener);
        this.env.getChoiceModel(401836).setChoiceListener(aisaMapContentChoiceListener);
        this.env.getChoiceModel(401834).setChoiceListener(aisaMapContentChoiceListener);
    }

    private class AisaMapContentChoiceListener
    extends DefaultChoiceListener {
        private AisaMapContentChoiceListener() {
        }

        public void switchModelStateOnOff(int n) {
            ChoiceModelApp choiceModelApp;
            choiceModelApp.setValue(0 == (choiceModelApp = AsiaMapContentHMIListener.this.env.getFramework().getHMIService().getChoiceModel(n)).getValue() ? 1 : 0);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AsiaMapContentHMIListener.this.env.getLogChannel().log(1000000, "AsiaMapContentHMIListener#AisaMapContentCheckboxListener#itemSelected model=%1 index=%2", (long)n, (long)n2);
            switch (n) {
                case 401831: {
                    this.switchModelStateOnOff(n);
                    break;
                }
                case 401832: {
                    this.switchModelStateOnOff(n);
                    break;
                }
                case 401833: {
                    this.switchModelStateOnOff(n);
                    break;
                }
                case 400801: {
                    this.switchModelStateOnOff(n);
                    break;
                }
                case 401836: {
                    this.switchModelStateOnOff(n);
                    break;
                }
                case 401834: {
                    AsiaMapContentHMIListener.this.env.getFramework().getHMIService().getChoiceModel(n).setValue(n2);
                    break;
                }
            }
        }
    }
}


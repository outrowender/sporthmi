/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.gui.AsiaMapContentHMIListener;
import de.audi.tghu.navi.app.map.gui.AsiaMapContentHMIListener$1;

class AsiaMapContentHMIListener$AisaMapContentChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AsiaMapContentHMIListener this$0;

    private AsiaMapContentHMIListener$AisaMapContentChoiceListener(AsiaMapContentHMIListener asiaMapContentHMIListener) {
        this.this$0 = asiaMapContentHMIListener;
    }

    public void switchModelStateOnOff(int n) {
        ChoiceModelApp choiceModelApp;
        choiceModelApp.setValue(0 == (choiceModelApp = AsiaMapContentHMIListener.access$100(this.this$0).getFramework().getHMIService().getChoiceModel(n)).getValue() ? 1 : 0);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AsiaMapContentHMIListener.access$100(this.this$0).getLogChannel().log(1078071040, "AsiaMapContentHMIListener#AisaMapContentCheckboxListener#itemSelected model=%1 index=%2", (long)n, (long)n2);
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
                AsiaMapContentHMIListener.access$100(this.this$0).getFramework().getHMIService().getChoiceModel(n).setValue(n2);
                break;
            }
        }
    }

    /* synthetic */ AsiaMapContentHMIListener$AisaMapContentChoiceListener(AsiaMapContentHMIListener asiaMapContentHMIListener, AsiaMapContentHMIListener$1 asiaMapContentHMIListener$1) {
        this(asiaMapContentHMIListener);
    }
}


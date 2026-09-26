/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.statemachine.ap.TopLevelScreenActionProxy;

public class TopLevelScreenActionProxyImpl
implements TopLevelScreenActionProxy {
    public static final int MODULDE_SYSTEM;
    public static final int MODULDE_NAVI;
    public static final int TOP_LEVEL_MODEL_ID_SYSTEM;
    public static final int TOP_LEVEL_MODEL_ID_NAVIGATION;
    private ChoiceModelApp[] systemTopLevelModel = new ChoiceModelApp[8];
    private ChoiceModelApp[] naviTopLevelModel = new ChoiceModelApp[8];
    private IFrameworkAccess frameworkAccess;

    public TopLevelScreenActionProxyImpl(IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
    }

    @Override
    public void setTopLevelScreen(int n, int n2, boolean bl) {
        if (this.systemTopLevelModel[n] == null || this.naviTopLevelModel[n] == null) {
            this.initModels(n);
        }
        int n3 = bl ? 1 : 0;
        ChoiceModelApp choiceModelApp = this.systemTopLevelModel[n];
        switch (n2) {
            case 0: {
                choiceModelApp = this.systemTopLevelModel[n];
                break;
            }
            case 4: {
                choiceModelApp = this.naviTopLevelModel[n];
                break;
            }
            default: {
                choiceModelApp = this.systemTopLevelModel[n];
            }
        }
        if (choiceModelApp != null) {
            choiceModelApp.setValue(n3);
        }
    }

    private void initModels(int n) {
        this.systemTopLevelModel[n] = this.frameworkAccess.getHMIService().getChoiceModel(n, 3883);
        this.naviTopLevelModel[n] = this.frameworkAccess.getHMIService().getChoiceModel(n, 3882);
    }
}


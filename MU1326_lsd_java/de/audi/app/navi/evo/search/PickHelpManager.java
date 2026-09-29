/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.PickHelpManager$MyChoiceModelListener;
import de.audi.app.navi.evo.search.PickHelpPersistanceHelper;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class PickHelpManager {
    public static final int PICKING_OFF;
    public static final int PICKING_ON;
    private static final String LOGCLASS;
    private final NavigationEnv env;
    private final PickHelpPersistanceHelper persistanceHelper;
    private final ChoiceModelApp pickHelpChoiceModel;

    private static boolean isPickHelpStateValid(int n, IFrameworkAccess iFrameworkAccess) {
        switch (n) {
            case 1: {
                return Util.isIntellidestPickHelpAvailable(iFrameworkAccess);
            }
            case 0: {
                return true;
            }
        }
        return false;
    }

    public PickHelpManager(NavigationEnv navigationEnv, PickHelpPersistanceHelper pickHelpPersistanceHelper) {
        this.pickHelpChoiceModel = navigationEnv.getChoiceModel(1260389888);
        this.env = navigationEnv;
        this.persistanceHelper = pickHelpPersistanceHelper;
        int n = pickHelpPersistanceHelper.loadPickHelpState();
        if (!PickHelpManager.isPickHelpStateValid(n, navigationEnv.getFramework())) {
            navigationEnv.getLogChannel().log(10000, "%1#PickHelpManager - invalid parameter read from persistence: %2 ", (Object)"PickHelpManager", (long)n);
            n = PickHelpPersistanceHelper.getPickHelpStateDefault(navigationEnv.getFramework());
        }
        this.setPickHelpState(n);
        this.initListener();
    }

    private void initListener() {
        PickHelpManager$MyChoiceModelListener pickHelpManager$MyChoiceModelListener = new PickHelpManager$MyChoiceModelListener(this, null);
        this.pickHelpChoiceModel.setChoiceListener(pickHelpManager$MyChoiceModelListener);
    }

    public int getPickHelpState() {
        return this.pickHelpChoiceModel.getValue();
    }

    public final void setPickHelpState(int n) {
        if (!PickHelpManager.isPickHelpStateValid(n, this.env.getFramework())) {
            this.env.getLogChannel().log(10000, "%1#setPickHelpState - invalid parameter: %2 ", (Object)"PickHelpManager", (long)n);
            return;
        }
        if (n != this.pickHelpChoiceModel.getValue()) {
            this.env.getLogChannel().log(-2137614336, "%1#setPickHelpState - change model state from Model = %2 to %3", (Object)"PickHelpManager", (Object)new StringBuffer().append(this.pickHelpChoiceModel.getID()).append("").toString(), (long)n);
            this.pickHelpChoiceModel.setValue(n);
            this.persistanceHelper.persistPickHelpState(n);
        } else {
            this.env.getLogChannel().log(-2137614336, "%1#setsetPickHelpState - model has already the given state", (Object)"PickHelpManager");
        }
    }

    public void resetSettings() {
        this.env.getLogChannel().log(-2137614336, "%1#resetSettings() - set default settings", (Object)"PickHelpManager");
        this.setPickHelpState(PickHelpPersistanceHelper.getPickHelpStateDefault(this.env.getFramework()));
    }

    static /* synthetic */ NavigationEnv access$100(PickHelpManager pickHelpManager) {
        return pickHelpManager.env;
    }

    static /* synthetic */ ChoiceModelApp access$200(PickHelpManager pickHelpManager) {
        return pickHelpManager.pickHelpChoiceModel;
    }
}


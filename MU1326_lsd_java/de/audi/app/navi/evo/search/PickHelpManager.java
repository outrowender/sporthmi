/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.PickHelpPersistanceHelper;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class PickHelpManager {
    public static final int PICKING_OFF = 0;
    public static final int PICKING_ON = 1;
    private static final String LOGCLASS = "PickHelpManager";
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
        this.pickHelpChoiceModel = navigationEnv.getChoiceModel(401483);
        this.env = navigationEnv;
        this.persistanceHelper = pickHelpPersistanceHelper;
        int n = pickHelpPersistanceHelper.loadPickHelpState();
        if (!PickHelpManager.isPickHelpStateValid(n, navigationEnv.getFramework())) {
            navigationEnv.getLogChannel().log(10000, "%1#PickHelpManager - invalid parameter read from persistence: %2 ", (Object)LOGCLASS, (long)n);
            n = PickHelpPersistanceHelper.getPickHelpStateDefault(navigationEnv.getFramework());
        }
        this.setPickHelpState(n);
        this.initListener();
    }

    private void initListener() {
        MyChoiceModelListener myChoiceModelListener = new MyChoiceModelListener();
        this.pickHelpChoiceModel.setChoiceListener(myChoiceModelListener);
    }

    public int getPickHelpState() {
        return this.pickHelpChoiceModel.getValue();
    }

    public final void setPickHelpState(int n) {
        if (!PickHelpManager.isPickHelpStateValid(n, this.env.getFramework())) {
            this.env.getLogChannel().log(10000, "%1#setPickHelpState - invalid parameter: %2 ", (Object)LOGCLASS, (long)n);
            return;
        }
        if (n != this.pickHelpChoiceModel.getValue()) {
            this.env.getLogChannel().log(10000000, "%1#setPickHelpState - change model state from Model = %2 to %3", (Object)LOGCLASS, (Object)new StringBuffer().append(this.pickHelpChoiceModel.getID()).append("").toString(), (long)n);
            this.pickHelpChoiceModel.setValue(n);
            this.persistanceHelper.persistPickHelpState(n);
        } else {
            this.env.getLogChannel().log(10000000, "%1#setsetPickHelpState - model has already the given state", (Object)LOGCLASS);
        }
    }

    public void resetSettings() {
        this.env.getLogChannel().log(10000000, "%1#resetSettings() - set default settings", (Object)LOGCLASS);
        this.setPickHelpState(PickHelpPersistanceHelper.getPickHelpStateDefault(this.env.getFramework()));
    }

    private class MyChoiceModelListener
    extends DefaultChoiceListener {
        private MyChoiceModelListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            PickHelpManager.this.env.getLogChannel().log(1000000, "%1#ChoiceModelListener.keyPressed model = %2 itemID = %3", (Object)PickHelpManager.LOGCLASS, (long)n, (long)n2);
            switch (n) {
                case 401483: {
                    PickHelpManager.this.setPickHelpState(0 == PickHelpManager.this.pickHelpChoiceModel.getValue() ? 1 : 0);
                    PickHelpManager.this.env.fireModelEvent(n, n4);
                    break;
                }
            }
        }
    }
}


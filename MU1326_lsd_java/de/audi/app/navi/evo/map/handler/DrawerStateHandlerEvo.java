/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;

public class DrawerStateHandlerEvo
implements IDrawerStateHandler {
    private final NavigationEnv navigationEnv;
    private final MapInterface mapInterface;
    private final ChoiceModelApp drawerStateModelApp;
    private boolean drawerOpen = false;

    public DrawerStateHandlerEvo(NavigationEnv navigationEnv, MapInterface mapInterface) {
        this.navigationEnv = navigationEnv;
        this.mapInterface = mapInterface;
        this.drawerStateModelApp = navigationEnv.getChoiceModel(401909);
        this.drawerStateModelApp.setChoiceListener(new DrawerStateModelListener());
    }

    public boolean isDrawerOpen() {
        return this.drawerOpen;
    }

    private void onDrawerOpened() {
        this.navigationEnv.getMapMainLogChannel().log(10000000, "DrawerStateHandlerEvo#onDrawerOpened");
        this.drawerOpen = true;
        this.mapInterface.setBackgroundMode(true, true);
    }

    private void onDrawerClosed() {
        this.navigationEnv.getMapMainLogChannel().log(10000000, "DrawerStateHandlerEvo#onDrawerClosed");
        this.drawerOpen = false;
        this.mapInterface.setBackgroundMode(false, true);
    }

    public void onExitMapScreen() {
        this.navigationEnv.getMapMainLogChannel().log(10000000, "DrawerStateHandlerEvo#onExitMapScreen");
        this.drawerOpen = false;
        int n = DrawerFocusUtil.calculateChoiceValue(2, 16, 512);
        this.drawerStateModelApp.setValue(n);
        this.onDrawerClosed();
    }

    private class DrawerStateModelListener
    extends DefaultChoiceListener
    implements ChoiceListener {
        private DrawerStateModelListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            DrawerStateHandlerEvo.this.navigationEnv.getMapMainLogChannel().log(1000000, "DrawerStateHandlerEvo#DrawerStateModelListener#itemSelected modelID=%1 itemID=%2", (long)n, (long)n2);
            if (n != 401909) {
                DrawerStateHandlerEvo.this.navigationEnv.getMapMainLogChannel().log(100000, "DrawerStateHandlerEvo#DrawerStateModelListener#itemSelected unexpected model ID: %1", (long)n);
                return;
            }
            DrawerStateHandlerEvo.this.drawerStateModelApp.setValue(n2);
            if (DrawerFocusUtil.isFocusGained(n2)) {
                DrawerStateHandlerEvo.this.onDrawerClosed();
            } else if (DrawerFocusUtil.isFocusLost(n2)) {
                DrawerStateHandlerEvo.this.onDrawerOpened();
            }
        }
    }
}


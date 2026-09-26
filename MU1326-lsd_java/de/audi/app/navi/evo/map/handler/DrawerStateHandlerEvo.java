/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler;

import de.audi.app.navi.evo.map.handler.DrawerStateHandlerEvo$DrawerStateModelListener;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
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
        this.drawerStateModelApp = navigationEnv.getChoiceModel(-182385152);
        this.drawerStateModelApp.setChoiceListener(new DrawerStateHandlerEvo$DrawerStateModelListener(this, null));
    }

    @Override
    public boolean isDrawerOpen() {
        return this.drawerOpen;
    }

    private void onDrawerOpened() {
        this.navigationEnv.getMapMainLogChannel().log(-2137614336, "DrawerStateHandlerEvo#onDrawerOpened");
        this.drawerOpen = true;
        this.mapInterface.setBackgroundMode(true, true);
    }

    private void onDrawerClosed() {
        this.navigationEnv.getMapMainLogChannel().log(-2137614336, "DrawerStateHandlerEvo#onDrawerClosed");
        this.drawerOpen = false;
        this.mapInterface.setBackgroundMode(false, true);
    }

    @Override
    public void onExitMapScreen() {
        this.navigationEnv.getMapMainLogChannel().log(-2137614336, "DrawerStateHandlerEvo#onExitMapScreen");
        this.drawerOpen = false;
        int n = DrawerFocusUtil.calculateChoiceValue(2, 16, 512);
        this.drawerStateModelApp.setValue(n);
        this.onDrawerClosed();
    }

    static /* synthetic */ NavigationEnv access$100(DrawerStateHandlerEvo drawerStateHandlerEvo) {
        return drawerStateHandlerEvo.navigationEnv;
    }

    static /* synthetic */ ChoiceModelApp access$200(DrawerStateHandlerEvo drawerStateHandlerEvo) {
        return drawerStateHandlerEvo.drawerStateModelApp;
    }

    static /* synthetic */ void access$300(DrawerStateHandlerEvo drawerStateHandlerEvo) {
        drawerStateHandlerEvo.onDrawerClosed();
    }

    static /* synthetic */ void access$400(DrawerStateHandlerEvo drawerStateHandlerEvo) {
        drawerStateHandlerEvo.onDrawerOpened();
    }
}


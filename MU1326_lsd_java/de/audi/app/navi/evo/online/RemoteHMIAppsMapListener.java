/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.global.NavLocation;

public class RemoteHMIAppsMapListener
extends RemoteHMIAppsBaseListener {
    public static final RemoteHMIAppsBaseListener.ModelEntry[] ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP = new RemoteHMIAppsBaseListener.ModelEntry[]{new RemoteHMIAppsBaseListener.ModelEntry(400995, 401032), new RemoteHMIAppsBaseListener.ModelEntry(401037, 401033), new RemoteHMIAppsBaseListener.ModelEntry(401038, 401034), new RemoteHMIAppsBaseListener.ModelEntry(401039, 401035), new RemoteHMIAppsBaseListener.ModelEntry(401040, 401036), new RemoteHMIAppsBaseListener.ModelEntry(401455, 401445), new RemoteHMIAppsBaseListener.ModelEntry(401456, 401446), new RemoteHMIAppsBaseListener.ModelEntry(401457, 401447), new RemoteHMIAppsBaseListener.ModelEntry(401458, 401448), new RemoteHMIAppsBaseListener.ModelEntry(401459, 401449), new RemoteHMIAppsBaseListener.ModelEntry(401460, 401450), new RemoteHMIAppsBaseListener.ModelEntry(401461, 401451), new RemoteHMIAppsBaseListener.ModelEntry(401462, 401452), new RemoteHMIAppsBaseListener.ModelEntry(401463, 401453), new RemoteHMIAppsBaseListener.ModelEntry(401464, 401454)};
    private final MapInterface mapInterface;

    public RemoteHMIAppsMapListener(NavigationEnv navigationEnv, MapInterface mapInterface) {
        super(navigationEnv);
        this.mapInterface = mapInterface;
        int n = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP.length;
        for (int i2 = 0; i2 < n; ++i2) {
            RemoteHMIAppsBaseListener.ModelEntry modelEntry = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP[i2];
            ButtonModelApp buttonModelApp = navigationEnv.getButtonModel(modelEntry.getNonLabelModel());
            buttonModelApp.setButtonListener(this);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        RemoteHMIAppsBaseListener.ModelEntry modelEntry;
        this.logChannel.log(1000000, "RemoteHMIAppsMapListener#keyTyped: called for model id '%1'", (long)n);
        NavLocation navLocation = null;
        if (this.navigationEnv.getFramework().isTarget()) {
            navLocation = this.mapInterface.getMapFocusedLocation();
            if (navLocation == null) {
                navLocation = this.createDummyNavLocation();
                this.logChannel.log(10000, "RemoteHMIAppsMapListener#keyTyped: Location instance is null so dummy location is used");
            }
        } else {
            this.logChannel.log(10000000, "RemoteHMIAppsMapListener#keyTyped: using PC simulation");
            navLocation = this.createDummyNavLocation();
        }
        if ((modelEntry = this.getSelectedModelEntry(n, ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP)) == null) {
            this.logChannel.log(100000, "RemoteHMIAppsMapListener#keyTyped: Model entry for selected application not found");
            return;
        }
        String string = modelEntry.getApplicationContext();
        int n4 = modelEntry.getNonLabelModel();
        this.logChannel.log(10000000, "RemoteHMIAppsMapListener#keyTyped: Selected navi mini application context is '%1' and button model id is '%2'", (Object)string, (long)n4);
        final ButtonModelApp buttonModelApp = this.navigationEnv.getButtonModel(n4);
        this.logChannel.log(10000000, "RemoteHMIAppsMapListener#keyPressed: AppContext = %1", (Object)string);
        if (navLocation == null) {
            this.logChannel.log(100000, "RemoteHMIAppsMapListener#keyPressed: navLocation is null");
        } else if (this.onlineServiceProvider == null) {
            this.logChannel.log(10000, "RemoteHMIAppsMapListener#keyPressed: onlineServiceProvider is null");
        } else {
            this.onlineServiceProvider.startMapApp(navLocation, string, new TransitionCallback(){

                public void triggerTransition() {
                    buttonModelApp.fireEvent(0);
                }
            });
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener;
import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener$ModelEntry;
import de.audi.app.navi.evo.online.RemoteHMIAppsMapListener$1;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.global.NavLocation;

public class RemoteHMIAppsMapListener
extends RemoteHMIAppsBaseListener {
    public static final RemoteHMIAppsBaseListener$ModelEntry[] ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP = new RemoteHMIAppsBaseListener$ModelEntry[]{new RemoteHMIAppsBaseListener$ModelEntry(1662912000, -2011298304), new RemoteHMIAppsBaseListener$ModelEntry(-1927412224, -1994521088), new RemoteHMIAppsBaseListener$ModelEntry(-1910635008, -1977743872), new RemoteHMIAppsBaseListener$ModelEntry(-1893857792, -1960966656), new RemoteHMIAppsBaseListener$ModelEntry(-1877080576, -1944189440), new RemoteHMIAppsBaseListener$ModelEntry(790627840, 622855680), new RemoteHMIAppsBaseListener$ModelEntry(807405056, 0x26200600), new RemoteHMIAppsBaseListener$ModelEntry(824182272, 656410112), new RemoteHMIAppsBaseListener$ModelEntry(840959488, 673187328), new RemoteHMIAppsBaseListener$ModelEntry(857736704, 689964544), new RemoteHMIAppsBaseListener$ModelEntry(874513920, 706741760), new RemoteHMIAppsBaseListener$ModelEntry(891291136, 723518976), new RemoteHMIAppsBaseListener$ModelEntry(908068352, 740296192), new RemoteHMIAppsBaseListener$ModelEntry(924845568, 757073408), new RemoteHMIAppsBaseListener$ModelEntry(941622784, 773850624)};
    private final MapInterface mapInterface;

    public RemoteHMIAppsMapListener(NavigationEnv navigationEnv, MapInterface mapInterface) {
        super(navigationEnv);
        this.mapInterface = mapInterface;
        for (RemoteHMIAppsBaseListener$ModelEntry remoteHMIAppsBaseListener$ModelEntry : ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP) {
            ButtonModelApp buttonModelApp = navigationEnv.getButtonModel(remoteHMIAppsBaseListener$ModelEntry.getNonLabelModel());
            buttonModelApp.setButtonListener(this);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        RemoteHMIAppsBaseListener$ModelEntry remoteHMIAppsBaseListener$ModelEntry;
        this.logChannel.log(1078071040, "RemoteHMIAppsMapListener#keyTyped: called for model id '%1'", (long)n);
        NavLocation navLocation = null;
        if (this.navigationEnv.getFramework().isTarget()) {
            navLocation = this.mapInterface.getMapFocusedLocation();
            if (navLocation == null) {
                navLocation = this.createDummyNavLocation();
                this.logChannel.log(10000, "RemoteHMIAppsMapListener#keyTyped: Location instance is null so dummy location is used");
            }
        } else {
            this.logChannel.log(-2137614336, "RemoteHMIAppsMapListener#keyTyped: using PC simulation");
            navLocation = this.createDummyNavLocation();
        }
        if ((remoteHMIAppsBaseListener$ModelEntry = this.getSelectedModelEntry(n, ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_MAP)) == null) {
            this.logChannel.log(-1601830656, "RemoteHMIAppsMapListener#keyTyped: Model entry for selected application not found");
            return;
        }
        String string = remoteHMIAppsBaseListener$ModelEntry.getApplicationContext();
        int n4 = remoteHMIAppsBaseListener$ModelEntry.getNonLabelModel();
        this.logChannel.log(-2137614336, "RemoteHMIAppsMapListener#keyTyped: Selected navi mini application context is '%1' and button model id is '%2'", (Object)string, (long)n4);
        ButtonModelApp buttonModelApp = this.navigationEnv.getButtonModel(n4);
        this.logChannel.log(-2137614336, "RemoteHMIAppsMapListener#keyPressed: AppContext = %1", (Object)string);
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "RemoteHMIAppsMapListener#keyPressed: navLocation is null");
        } else if (this.onlineServiceProvider == null) {
            this.logChannel.log(10000, "RemoteHMIAppsMapListener#keyPressed: onlineServiceProvider is null");
        } else {
            this.onlineServiceProvider.startMapApp(navLocation, string, new RemoteHMIAppsMapListener$1(this, buttonModelApp));
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterInputListener$State;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.ClusterViewMode;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.via.RemoveViaPointsCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class ClusterInputListener
implements ChoiceListener {
    protected static final int MENU_ITEM_COMPASS;
    protected static final int MENU_ITEM_KDK;
    protected static final int MENU_ITEM_MAP;
    protected static final int MENU_ITEM_HOME;
    protected static final int MENU_ITEM_STOP_RG;
    protected final NavigationEnv env;
    protected LogChannel logChannel;
    protected ClusterService service;
    protected Navigation navigation;

    public ClusterInputListener(NavigationEnv navigationEnv, ClusterService clusterService) {
        this.env = navigationEnv;
        this.service = clusterService;
        this.logChannel = navigationEnv.getLogChannel();
        this.navigation = Navigation.getInstance();
        navigationEnv.getChoiceModel(203097600).setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 400140: {
                this.evaluateFavoredViewMode(n, n2, n4);
                break;
            }
            default: {
                this.logChannel.log(10000, "ClusterInputListener#itemSelected() - unknown model id: %1!", (long)n);
            }
        }
    }

    protected void evaluateFavoredViewMode(int n, int n2, int n3) {
        switch (n2) {
            case 0: {
                this.setFavoredViewMode(0, true);
                break;
            }
            case 1: {
                this.setFavoredViewMode(2, true);
                break;
            }
            case 2: {
                this.setFavoredViewMode(3, true);
                break;
            }
            case 3: {
                this.startGuidanceToHomeAddress();
                break;
            }
            case 4: {
                this.stopRouteGuidance();
                break;
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    protected boolean startGuidanceToHomeAddress() {
        HomeAddressHandler homeAddressHandler = this.navigation.getHomeAddressHandler();
        NavLocation navLocation = homeAddressHandler.getCurrentHomeAddress();
        if (!this.isHomeAddressValid(navLocation, homeAddressHandler)) {
            this.fireEventNoHome();
            return false;
        }
        this.logChannel.log(-2137614336, "ClusterInputListener#startGuidanceToHomeAddress(): %1", (Object)navLocation);
        CommandList commandList = this.navigation.getRouteManager().getStartRouteGuidanceToSingleDestinationSequence(navLocation);
        commandList.execute("ClusterInputListener.startGuidanceToHomeAddress");
        return true;
    }

    protected void fireEventNoHome() {
    }

    private boolean isHomeAddressValid(NavLocation navLocation, HomeAddressHandler homeAddressHandler) {
        boolean bl;
        boolean bl2 = homeAddressHandler.isHomeAddressAvailable();
        boolean bl3 = bl = navLocation == null ? false : navLocation.isPositionValid();
        if (!bl2 || !bl) {
            this.logChannel.log(!bl2 ? 10000 : 1078071040, "ClusterInputListener#isHomeAddressValid( %1 ) - %2", (Object)navLocation, (Object)(!bl2 ? "Home status unknown!" : "Home location is unavailable or not navigable!"));
            return false;
        }
        return true;
    }

    protected void stopRouteGuidance() {
        this.logChannel.log(-2137614336, "ClusterInputListener#stopRouteGuidance()");
        CommandList commandList = this.navigation.getCommandListFactory().createCommandList(1);
        commandList.add(new RGStopGuidanceCommand());
        commandList.add(new RemoveViaPointsCommand());
        commandList.execute("ClusterInputListener.stopRouteGuidance");
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void resetSettings() {
        this.setFavoredViewMode(ClusterInputListener.getDefaultViewMode(this.env), true);
    }

    public void setFavoredViewMode(int n, boolean bl) {
        ClusterInputListener$State clusterInputListener$State;
        IStorageAccess iStorageAccess;
        int n2;
        this.logChannel.log(-2137614336, "ClusterInputListener#setFavoredViewMode( %2, %1 )", bl, (Object)ClusterViewMode.viewModeToString(n));
        int n3 = this.validateViewMode(n);
        switch (n3) {
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.env.getChoiceModel(203097600).setValue(n2);
        this.service.getClusterViewMode().setFavoredViewMode(n3);
        if (bl && (iStorageAccess = this.env.getFramework().getStorageMgr()) != null && (clusterInputListener$State = new ClusterInputListener$State(iStorageAccess, this.logChannel, this.env)).getFavoredViewMode() != n3) {
            clusterInputListener$State.setFavoredViewMode(n3);
            clusterInputListener$State.serializeAndWrite();
        }
    }

    public void loadState() {
        this.logChannel.log(-2137614336, "ClusterInputListener#loadState()");
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            ClusterInputListener$State clusterInputListener$State = new ClusterInputListener$State(iStorageAccess, this.logChannel, this.env);
            clusterInputListener$State.readAndDeserialize();
            this.setFavoredViewMode(clusterInputListener$State.getFavoredViewMode(), false);
        }
    }

    private static int getDefaultViewMode(NavigationEnv navigationEnv) {
        if (Util.isClusterKDKOnly(navigationEnv.getFramework())) {
            return 2;
        }
        if (Util.isClusterMapAvailable(navigationEnv.getFramework())) {
            return 3;
        }
        if (Util.isClusterRGI(navigationEnv.getFramework())) {
            return 1;
        }
        return 0;
    }

    private int validateViewMode(int n) {
        int n2 = n;
        if (Util.isClusterKDKOnly(this.env.getFramework())) {
            this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( ) - KDK-only configuration, using default view mode");
            return ClusterInputListener.getDefaultViewMode(this.env);
        }
        if (Util.isClusterMapAvailable(this.env.getFramework())) {
            if (Util.isClusterMapFPK(this.env.getFramework())) {
                if (n != 0 && n != 3) {
                    this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( %1 ) - invalid view mode for FPK! Using Default: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(ClusterInputListener.getDefaultViewMode(this.env)));
                    return ClusterInputListener.getDefaultViewMode(this.env);
                }
            } else if (Util.isClusterMapMOST(this.env.getFramework())) {
                if (n == 0) {
                    return 2;
                }
                if (n != 2 && n != 3) {
                    this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( %1 ) - invalid view mode for MOST-Cluster! Using Default: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(ClusterInputListener.getDefaultViewMode(this.env)));
                    return ClusterInputListener.getDefaultViewMode(this.env);
                }
            }
        } else {
            if (Util.isClusterMMI(this.env.getFramework())) {
                this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( %1 ) - Using Default for MMI-Cluster: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(ClusterInputListener.getDefaultViewMode(this.env)));
                return ClusterInputListener.getDefaultViewMode(this.env);
            }
            if (Util.isClusterRGI(this.env.getFramework())) {
                if (n == 0) {
                    return 1;
                }
                if (n != 1) {
                    this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( %1 ) - invalid view mode for RGI-Cluster! Using Default: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(ClusterInputListener.getDefaultViewMode(this.env)));
                    return ClusterInputListener.getDefaultViewMode(this.env);
                }
            } else {
                this.logChannel.log(-2137614336, "ClusterInputListener#validateViewMode( %1 ) - unknow cluster! Using Default: %2", (Object)ClusterViewMode.viewModeToString(n), (Object)ClusterViewMode.viewModeToString(ClusterInputListener.getDefaultViewMode(this.env)));
                return ClusterInputListener.getDefaultViewMode(this.env);
            }
        }
        return n2;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void cleanup() {
        this.navigation = null;
        this.service = null;
    }

    static /* synthetic */ int access$000(NavigationEnv navigationEnv) {
        return ClusterInputListener.getDefaultViewMode(navigationEnv);
    }
}


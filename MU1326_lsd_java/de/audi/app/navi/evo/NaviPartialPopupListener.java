/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.app.navi.evo.map.minimap.EvoTrafficMiniMapView;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.util.Util;

public class NaviPartialPopupListener
implements IPartialPopupListener {
    private final LogChannel logChannel;
    private final CombiBAPListener combiBAPListener;
    private final IPoiService poiService;
    private final IAddressInputForm addressInputService;
    private final NavigationEnv env;
    private final MapManager mapManager;
    private final EvoTrafficMiniMapView miniMapView;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private int previousCtx = -1;
    private int[] registeredPopups = new int[]{400120, 400079, 400124, 400269, 400373, 400347};

    public NaviPartialPopupListener(NavigationEnv navigationEnv, MapManager mapManager, CombiBAPListener combiBAPListener, IPoiService iPoiService, IAddressInputForm iAddressInputForm, EvoTrafficMiniMapView evoTrafficMiniMapView) {
        this.env = navigationEnv;
        this.mapManager = mapManager;
        this.combiBAPListener = combiBAPListener;
        this.logChannel = navigationEnv.getLogChannel();
        this.poiService = iPoiService;
        this.addressInputService = iAddressInputForm;
        this.miniMapView = evoTrafficMiniMapView;
    }

    public void partialPopupVisible(int n, int n2) {
        this.previousCtx = this.env.getChoiceModel(8).getValue();
        this.logChannel.log(10000000, "%1#partialPopupVisible() - partialPopupID:%2, terminalID:%3, currentCtx: %4", (Object)this.CLASS_NAME, (Object)(n + ""), (Object)(n2 + ""), (Object)(this.previousCtx + ""));
    }

    public void partialPopupHidden(int n, int n2) {
        this.logChannel.log(10000000, "%1#partialPopupHidden() - partialPopupID:%2, terminalID:%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
    }

    public void partialPopupRemoved(int n, int n2) {
        this.logChannel.log(10000000, "%1#partialPopupRemoved() - partialPopupID:%2, terminalID:%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        boolean bl = this.hasCtxChanged();
        if (this.miniMapView != null && 400373 == n && !bl) {
            this.miniMapView.hideMiniMap();
        }
        this.combiBAPListener.partialPopupRemoved(n);
        if (!bl) {
            return;
        }
        if (this.isRestorePreviousStateWithinPoiNecessary(n)) {
            this.logChannel.log(10000000, "%1#partialPopupRemoved() - simulating HK return for POI service", (Object)this.CLASS_NAME);
            this.poiService.destPOIHKReturn(n2, 12);
        } else if (this.isRestorePreviousStateWithinHsnScreenNecessary(n) || this.isRestorePreviousStateWithinCityZipScreenNecessary(n)) {
            this.logChannel.log(10000000, "%1#partialPopupRemoved() - simulating HK return for address input service", (Object)this.CLASS_NAME);
            this.addressInputService.destAddressInputHKReturn(n2, -1, null, null);
        }
    }

    public int[] getPPIDsForCallbacks() {
        return this.registeredPopups;
    }

    private boolean hasCtxChanged() {
        int n = this.env.getChoiceModel(8).getValue();
        this.logChannel.log(10000000, "%1#hasCtxChanged() - previousCtx:%2, currentCtx:%3", (Object)this.CLASS_NAME, (long)this.previousCtx, (long)n);
        return this.previousCtx != n;
    }

    private boolean isRestorePreviousStateWithinPoiNecessary(int n) {
        SpellerStack spellerStack = SpellerStack.getInstance();
        return (n == 400120 || n == 400079) && spellerStack.isActiveSpellerContextIDEqual(5);
    }

    private boolean isRestorePreviousStateWithinHsnScreenNecessary(int n) {
        SpellerStack spellerStack = SpellerStack.getInstance();
        return n == 400269 && spellerStack.isActiveSpellerContextIDEqual(70);
    }

    private boolean isRestorePreviousStateWithinCityZipScreenNecessary(int n) {
        SpellerStack spellerStack = SpellerStack.getInstance();
        return n == 400269 && spellerStack.isActiveSpellerContextIDEqual(61) || spellerStack.isActiveSpellerContextIDEqual(106);
    }

    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
        if (400347 == n) {
            this.mapManager.getMapInterface().informTENMPopupPosition(n2, n3, n4, n5, n6);
        }
    }
}


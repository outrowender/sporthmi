/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi;

import de.audi.app.navi.evo.NaviSMEventConstantsImplEvo;
import de.audi.app.navi.evo.NaviTextConstantsImplEvo;
import de.audi.app.navi.evo.NavigationEvo;
import de.audi.app.navi.evo.actionproxy.NaviActionProxyImplEvo;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.navi.app.AbstractNavigationActivator;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.appcore.INaviSMEventConstants;
import de.audi.tghu.navi.app.appcore.INaviTextConstants;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class NavigationActivator
extends AbstractNavigationActivator {
    private final INaviTextConstants textConstants = new NaviTextConstantsImplEvo();
    private final INaviSMEventConstants smEventConstants = new NaviSMEventConstantsImplEvo();
    static /* synthetic */ Class class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviSDSPOIOnlineService;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
    }

    @Override
    protected Navigation createNavigation(NavigationEnv navigationEnv) {
        NavigationEvo.createInstance(navigationEnv);
        NavigationEvo navigationEvo = NavigationEvo.getInstanceEvo();
        return navigationEvo;
    }

    @Override
    protected void registerProvidedServices(Navigation navigation, NavigationEnv navigationEnv) {
        super.registerProvidedServices(navigation, navigationEnv);
        this.registerActionProxy((NaviActionProxyImplEvo)navigation.navigationActionProxy);
        this.registerService(new String[]{(class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener == null ? (class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener = NavigationActivator.class$("de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener")) : class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener).getName()}, (Object)((NavigationEvo)navigation).getSearchController(), null);
        this.registerService(new String[]{(class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener == null ? (class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener = NavigationActivator.class$("de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener")) : class$de$audi$tghu$navi$app$routeguidance$IRouteGuidanceListener).getName()}, (Object)((NavigationEvo)navigation).getDestTransfereToNdfHandler(), null);
        if (this.framework.isEvoHigh()) {
            this.registerService((class$de$audi$atip$interapp$NaviSDSPOIOnlineService == null ? (class$de$audi$atip$interapp$NaviSDSPOIOnlineService = NavigationActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineService")) : class$de$audi$atip$interapp$NaviSDSPOIOnlineService).getName(), (Object)this.navigation.getOnlineSearchController().getSDS(), null);
        }
        this.registerMyAudiService();
        Hashtable hashtable = new Hashtable();
        hashtable = new Hashtable(0);
        this.registerService((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = NavigationActivator.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), (Object)((NavigationEvo)navigation).getNaviPartialPopupListener(), (Dictionary)hashtable);
        navigation.getNaviTabletService().registerService(this);
    }

    @Override
    protected void startRequiredDSIServices(NavigationEnv navigationEnv) {
        super.startRequiredDSIServices(navigationEnv);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        NavigationEvo navigationEvo = (NavigationEvo)this.navigation;
        navigationEvo.getSearchController().deinit(bundleContext);
        super.stop(bundleContext);
        this.navigation.cleanup2();
        this.navigation = null;
    }

    private void registerActionProxy(NaviActionProxyImplEvo naviActionProxyImplEvo) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(10));
        this.registerFrameworkService(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = NavigationActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy, naviActionProxyImplEvo, hashtable);
    }

    @Override
    public IIDMapper getTextConstantsMapper() {
        return this.textConstants;
    }

    @Override
    public IIDMapper getSMEventConstantsMapper() {
        return this.smEventConstants;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


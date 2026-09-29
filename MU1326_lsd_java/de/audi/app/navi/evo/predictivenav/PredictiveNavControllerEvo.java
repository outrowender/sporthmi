/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavControllerEvo$1;
import de.audi.app.navi.evo.predictivenav.PredictiveNavModelAccessEvo;
import de.audi.app.navi.evo.predictivenav.PredictiveNavModelListenerEvo;
import de.audi.app.navi.evo.predictivenav.PredictiveNavSequenceEvo;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavControllerCore;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public class PredictiveNavControllerEvo
extends PredictiveNavControllerCore
implements ButtonListener {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final ICommandListFactory commandListFactory;
    private final long betterRouteFoundTimeDelayInMs;
    private PredictiveNavModelListenerEvo predictiveNavModelListener;
    private IRouteCalculator routeCalculator;
    private boolean ignoreIndicationsForAllRoutes;
    private ButtonModelApp predictiveNavPopupStartGuidance;
    private ButtonModelApp predictiveNavPopupIgnoreThis;
    private ButtonModelApp predictiveNavPopupIgnoreAll;
    private ButtonModelApp activatePredictiveNav;
    private ButtonModelApp deactivatePredictiveNav;
    private LikelyDestination likelyDestinationForRouteGuidance;
    private ArrayList navLocationsToIgnore;

    public PredictiveNavControllerEvo(NavigationEnv navigationEnv, NaviInterface naviInterface, ICommandListFactory iCommandListFactory, BundleContext bundleContext, DispatcherBase dispatcherBase, IPreviewMap iPreviewMap, IRouteCalculator iRouteCalculator) {
        super(navigationEnv);
        this.commandListFactory = iCommandListFactory;
        this.routeCalculator = iRouteCalculator;
        this.betterRouteFoundTimeDelayInMs = 1625948160 * navigationEnv.getFramework().getSysConst(4537);
        this.sequence = new PredictiveNavSequenceEvo(iCommandListFactory);
        this.predictiveNavModelAccess = new PredictiveNavModelAccessEvo(navigationEnv);
        this.predictiveNavModelListener = new PredictiveNavModelListenerEvo(navigationEnv, this.predictiveNavDSIHandler, naviInterface, this.sequence, dispatcherBase, iPreviewMap);
        this.ignoreIndicationsForAllRoutes = false;
        this.likelyDestinationForRouteGuidance = null;
        this.navLocationsToIgnore = new ArrayList();
        this.predictiveNavPopupStartGuidance = navigationEnv.getButtonModel(-1407056384);
        this.predictiveNavPopupIgnoreThis = navigationEnv.getButtonModel(-1423833600);
        this.predictiveNavPopupIgnoreAll = navigationEnv.getButtonModel(-1390279168);
        this.activatePredictiveNav = navigationEnv.getButtonModel(-1507719680);
        this.deactivatePredictiveNav = navigationEnv.getButtonModel(-1524496896);
    }

    private void registerListener() {
        this.predictiveNavPopupStartGuidance.setButtonListener(this);
        this.predictiveNavPopupIgnoreThis.setButtonListener(this);
        this.predictiveNavPopupIgnoreAll.setButtonListener(this);
        this.activatePredictiveNav.setButtonListener(this);
        this.deactivatePredictiveNav.setButtonListener(this);
    }

    private void unregisterListener() {
        this.predictiveNavPopupStartGuidance.setButtonListener(null);
        this.predictiveNavPopupIgnoreThis.setButtonListener(null);
        this.predictiveNavPopupIgnoreAll.setButtonListener(null);
        this.activatePredictiveNav.setButtonListener(null);
        this.deactivatePredictiveNav.setButtonListener(null);
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.registerListener();
        this.predictiveNavModelListener.registerListener();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.unregisterListener();
        this.predictiveNavModelListener.unregisterListener();
        this.navLocationsToIgnore.clear();
    }

    @Override
    public void updateOperationMode() {
        super.updateOperationMode();
        if (this.currentOperationMode != 2) {
            this.env.getFramework().getHmiServiceApp().removePartialPopup(0, -199555584);
        }
    }

    @Override
    protected boolean getIsRgActiveOrCalculating() {
        return super.getIsRgActiveOrCalculating() || this.routeCalculator.isRubberbandActive();
    }

    @Override
    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
        if (((PredictiveNavSequenceEvo)this.sequence).isGuidanceStarting()) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new PredictiveNavControllerEvo$1(this, "delay updateLikelyDestinations to after screenchange", likelyDestinationArray));
            commandList.execute("PredictiveNavControllerEvo#updateLikelyDestinations");
        } else {
            super.updateLikelyDestinations(likelyDestinationArray);
        }
        if (this.currentOperationMode == 2) {
            this.checkForPopup();
        }
    }

    private void checkForPopup() {
        if (this.ignoreIndicationsForAllRoutes || this.env.getContainer().getRgRouteCalculationState() != 0) {
            return;
        }
        if (this.likelyDestinations == null || this.likelyDestinations.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.likelyDestinations.length; ++i2) {
            if (this.likelyDestinations[i2].calculationState != 2 || this.likelyDestinations[i2].timeDelay < this.betterRouteFoundTimeDelayInMs || this.isDestinationIgnored(this.likelyDestinations[i2].destination)) continue;
            this.logChannel.log(-2137614336, "%1#checkForPopup() show popup for: %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.likelyDestinations[i2].getDestination()));
            LabelModelApp labelModelApp = this.env.getLabelModel(-1440610816);
            labelModelApp.setText(AddressFormatter.formatOneLine(this.likelyDestinations[i2].getDestination(), this.env).getFirstLineAsText());
            MetricsModelApp metricsModelApp = this.env.getMetricsModel(-1457388032);
            DateMetric dateMetric = new DateMetric(new Date(this.likelyDestinations[i2].timeDelay), 11);
            metricsModelApp.setMetric(dateMetric);
            this.likelyDestinationForRouteGuidance = this.likelyDestinations[i2];
            this.env.getFramework().getHmiServiceApp().showPartialPopup(0, -199555584);
            return;
        }
    }

    private boolean isDestinationIgnored(NavLocation navLocation) {
        for (int i2 = 0; i2 < this.navLocationsToIgnore.size(); ++i2) {
            if (navLocation.latitude != ((NavLocation)this.navLocationsToIgnore.get((int)i2)).latitude || navLocation.longitude != ((NavLocation)this.navLocationsToIgnore.get((int)i2)).longitude) continue;
            return true;
        }
        return false;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed # model=%2", (Object)this.CLASS_NAME, (long)n);
        if (n == this.predictiveNavPopupIgnoreThis.getID()) {
            this.navLocationsToIgnore.add(this.likelyDestinationForRouteGuidance.getDestination());
        } else if (n == this.predictiveNavPopupIgnoreAll.getID()) {
            this.ignoreIndicationsForAllRoutes = true;
        } else if (n == this.predictiveNavPopupStartGuidance.getID()) {
            this.sequence.startGuidanceBySegmendID(this.likelyDestinationForRouteGuidance.getSegmentId());
            this.ignoreIndicationsForAllRoutes = true;
        } else if (n == this.activatePredictiveNav.getID()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#keyPressed # activatePredictiveNav", (Object)this.CLASS_NAME);
            }
            this.sequence.activatePredictiveNav();
        } else if (n == this.deactivatePredictiveNav.getID()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#keyPressed # deactivatePredictiveNav", (Object)this.CLASS_NAME);
            }
            this.sequence.deactivatePredictiveNav();
        }
        this.likelyDestinationForRouteGuidance = null;
        ButtonModelApp buttonModelApp = this.env.getButtonModel(n);
        buttonModelApp.fireEvent(n3);
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
}


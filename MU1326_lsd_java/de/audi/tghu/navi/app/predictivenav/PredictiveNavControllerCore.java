/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavModelAccess;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavDSIHandler;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public class PredictiveNavControllerCore
implements IPredictiveNavController {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected LikelyDestination[] likelyDestinations;
    protected NavigationEnv env;
    protected LogChannel logChannel;
    protected PredictiveNavDSIHandler predictiveNavDSIHandler;
    protected PredictiveNavSequence sequence;
    protected IPredictiveNavModelAccess predictiveNavModelAccess = null;
    protected int currentOperationMode;
    protected int lastActivationMode = -1;

    public PredictiveNavControllerCore(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPredictiveNavigationLogChannel();
        this.predictiveNavDSIHandler = new PredictiveNavDSIHandler(navigationEnv, this);
    }

    public void start(BundleContext bundleContext) {
        this.predictiveNavDSIHandler.startDSI(bundleContext);
    }

    public void stop(BundleContext bundleContext) {
        this.predictiveNavDSIHandler.stopDSI(bundleContext);
    }

    public void updateRgActive() {
        this.logChannel.log(100000000, "%1#updateRgActive() - rgActive = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(this.env.getContainer().isRgActive()));
        this.sequence.updateOperationModePredictiveNav();
    }

    public void updateRgRouteCalculationState() {
    }

    public void updateOperationMode() {
        this.currentOperationMode = this.env.getContainer().getPredictiveNavOperationMode();
        this.logChannel.log(10000000, this.CLASS_NAME + "#updateOperationMode # operationMode=%1", (Object)Integer.toString(this.currentOperationMode));
        boolean bl = this.getIsRgActiveOrCalculating();
        if (this.lastActivationMode != 1 && (this.currentOperationMode == 2 && bl || this.currentOperationMode == 1 && !bl)) {
            this.setActivationMode(3);
            return;
        }
        if (this.currentOperationMode == 2 || this.currentOperationMode == 1) {
            this.predictiveNavModelAccess.updateOperationModeModels(true);
        } else if (this.currentOperationMode == 0) {
            this.predictiveNavModelAccess.updateOperationModeModels(false);
        }
    }

    public void setActivationMode(int n) {
        boolean bl = this.getIsRgActiveOrCalculating();
        this.logChannel.log(10000000, this.CLASS_NAME + "#setActivationMode # activationMode=%1, isRgActiveOrCalculated=%2, currentOperationMode=%3", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (Object)Integer.toString(this.env.getContainer().getPredictiveNavOperationMode()));
        this.lastActivationMode = n;
        if (this.currentOperationMode == 2 && n == 1) {
            this.predictiveNavDSIHandler.setOperationMode(1);
        } else if (n == 0) {
            this.predictiveNavDSIHandler.setOperationMode(0);
        } else if (n == 2) {
            if (bl) {
                this.predictiveNavDSIHandler.setOperationMode(1);
            } else {
                this.predictiveNavDSIHandler.setOperationMode(2);
            }
        } else if (n == 3) {
            if (this.currentOperationMode == 0) {
                return;
            }
            if (bl) {
                this.predictiveNavDSIHandler.setOperationMode(1);
            } else {
                this.predictiveNavDSIHandler.setOperationMode(2);
            }
        }
    }

    protected boolean getIsRgActiveOrCalculating() {
        return this.env.getContainer().isRgActive() || this.env.getContainer().getRgRouteCalculationState() == 1;
    }

    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
        if (this.env.getContainer().getPredictiveNavOperationMode() == 2 || this.env.getContainer().getPredictiveNavOperationMode() == 1) {
            this.likelyDestinations = this.filterLikelyDestinations(likelyDestinationArray);
            this.predictiveNavModelAccess.updateSelection(this.likelyDestinations);
        }
    }

    private LikelyDestination[] filterLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
        LikelyDestination[] likelyDestinationArray2 = null;
        if (likelyDestinationArray != null) {
            int n;
            int n2 = 0;
            LikelyDestination[] likelyDestinationArray3 = new LikelyDestination[likelyDestinationArray.length];
            for (n = 0; n < likelyDestinationArray.length; ++n) {
                if (likelyDestinationArray[n].calculationState != 2) continue;
                likelyDestinationArray3[n2] = likelyDestinationArray[n];
                ++n2;
            }
            likelyDestinationArray2 = new LikelyDestination[n2];
            for (n = 0; n < likelyDestinationArray2.length; ++n) {
                likelyDestinationArray2[n] = likelyDestinationArray3[n];
            }
        }
        return likelyDestinationArray2;
    }

    public void updateMaxPredictions(int n) {
    }

    public void clearCacheResult() {
        this.logChannel.log(10000000, "%1#clearCacheResult", (Object)this.CLASS_NAME);
        this.predictiveNavModelAccess.clearLikelyDestinations();
    }

    public final int getOperationMode() {
        return this.env.getContainer().getPredictiveNavOperationMode();
    }

    public void resetMemorySettings() {
        this.predictiveNavDSIHandler.clearCache();
    }

    public void resetSettings() {
        this.predictiveNavDSIHandler.setOperationMode(0);
    }

    public LikelyDestination[] getLikelyDestinations() {
        return this.likelyDestinations;
    }

    public void focusSelenaRoutes(boolean bl) {
    }
}


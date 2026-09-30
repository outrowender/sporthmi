/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.app.navi.evo.addressinput.poi.rrd.IRRDListProviderFactory;
import de.audi.app.navi.evo.addressinput.poi.rrd.RRDListProviderFactory;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.DistanceContainer;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IDistanceContainer;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.addressinput.poi.rrd.PoiDistanceCalculator;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class RRDListener
implements IRRDListener {
    private final LogChannel poiLogChannel;
    private final NavigationEnv env;
    private volatile IRRDListProvider currentRRDListProvider;
    private final ICommandListFactory commandListFactory;
    private final IVehicle vehicle;
    private final IRRDListProviderFactory rrdListProviderFactory;
    private PoiDistanceCalculator currentPoiDistanceCalculator;

    public RRDListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, Navigation navigation) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.vehicle = iVehicle;
        this.poiLogChannel = navigationEnv.getPOILogChannel();
        this.rrdListProviderFactory = new RRDListProviderFactory(navigationEnv.getPOILogChannel(), navigation);
    }

    public void cleanUp() {
        this.currentRRDListProvider = null;
        this.rrdListProviderFactory.cleanUp();
        if (this.currentPoiDistanceCalculator != null) {
            this.currentPoiDistanceCalculator.cancelTimers();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enterRRD(int n) {
        this.poiLogChannel.log(10000000, "RRDListener#enterRRD called with type = %1", (long)n);
        Object object = this;
        synchronized (object) {
            if (this.currentPoiDistanceCalculator != null) {
                this.poiLogChannel.log(100000, "RRDListener#enterRRD removes lingering poiDistanceCalculator %1", (long)n);
                this.currentPoiDistanceCalculator.nameListLeft(n);
                this.currentPoiDistanceCalculator = null;
            }
            this.currentPoiDistanceCalculator = new PoiDistanceCalculator(this.env, this.commandListFactory, this.vehicle, "UpdateRRDTimer", "UpdateAirDistanceTimer");
        }
        this.currentRRDListProvider = this.rrdListProviderFactory.getProviderForType(n, this.env, this.vehicle);
        if (this.currentRRDListProvider != null) {
            object = new DistanceContainer(this.currentRRDListProvider.getRRDListCalculationLimit());
            this.currentPoiDistanceCalculator.nameListEntered(true, this.currentRRDListProvider, (IDistanceContainer)object);
        } else {
            this.poiLogChannel.log(10000, "RRDListener#enterRRD rrdListProviderFactory returned no listProvider for listType = %1", (long)n);
        }
    }

    public synchronized void exitRRD(int n) {
        this.poiLogChannel.log(10000000, "RRDListener#exitRRD(%1)", (long)n);
        if (this.currentRRDListProvider != null) {
            this.currentPoiDistanceCalculator.nameListLeft(n);
        } else {
            this.poiLogChannel.log(10000, "RRDListener#exitRRD rrdListProviderFactory returned no listProvider for listType = %1", (long)n);
        }
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        if (this.currentPoiDistanceCalculator != null) {
            this.currentPoiDistanceCalculator.updateRRDCalculationInfo(rrdCalculationInfoArray);
        } else {
            this.poiLogChannel.log(100000, "RRDListener#updateRrdCalculationInfo no PoiDistanceCalculator set");
        }
    }
}


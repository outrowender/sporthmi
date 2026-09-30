/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car.kombi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.car.kombi.ICarKombiEventsProvider;
import de.audi.tghu.navi.app.car.kombi.ICarKombiObserver;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCViewOptions;

public class NaviCarKombiService
implements ICarKombiObserver,
ICarKombiService {
    private final LogChannel logChannel;
    private int engineTypePrimary = 4;
    private int engineTypeSecondary = 4;

    public NaviCarKombiService(LogChannel logChannel, ICarKombiEventsProvider iCarKombiEventsProvider) {
        this.logChannel = logChannel;
        iCarKombiEventsProvider.registerListener(this);
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions) {
        this.logChannel.log(10000000, "NaviDSICarKombiListener#updateBCViewOptions( %1 )", (Object)bCViewOptions);
        BCConfiguration bCConfiguration = bCViewOptions.getConfiguration();
        if (bCConfiguration == null) {
            this.logChannel.log(1000000, "NaviDSICarKombiListener#updateBCViewOptions() - configuration is null");
            return;
        }
        this.engineTypePrimary = bCConfiguration.getPrimaryEngineType();
        this.engineTypeSecondary = bCConfiguration.getSecondaryEngineType();
    }

    public int getEngineTypePrimary() {
        return this.engineTypePrimary;
    }

    public int getEngineTypeSecondary() {
        return this.engineTypeSecondary;
    }

    public int getConventionalEngineType() {
        int n = this.isFuelTypeAlternative(this.getEngineTypeSecondary()) ? this.getEngineTypePrimary() : this.getEngineTypeSecondary();
        return n;
    }

    public int getAlternativeEngineType() {
        int n = this.isFuelTypeAlternative(this.getEngineTypePrimary()) ? this.getEngineTypePrimary() : this.getEngineTypeSecondary();
        return n;
    }

    private boolean isFuelTypeAlternative(int n) {
        return n == 3 || n == 8 || n == 9;
    }
}


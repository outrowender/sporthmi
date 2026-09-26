/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.sdis.interapp.ISDISZeroEmissionAccess;
import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent;
import de.audi.atip.interapp.car.Car2XObjectCollection$CarZeroEmissionEntry;
import org.dsi.ifc.global.CarViewOption;

public class AbstractZeroEmissionStatisticsComponent$SDISInterface
implements ISDISZeroEmissionAccess {
    private final /* synthetic */ AbstractZeroEmissionStatisticsComponent this$0;

    public AbstractZeroEmissionStatisticsComponent$SDISInterface(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        this.this$0 = abstractZeroEmissionStatisticsComponent;
    }

    public void sendVisibilityStates(CarViewOption carViewOption) {
        if (null != carViewOption) {
            AbstractZeroEmissionStatisticsComponent.access$000(this.this$0, 102, carViewOption);
        }
    }

    public void sendCurrentBarGraphUpdate(Car2XObjectCollection$CarZeroEmissionEntry car2XObjectCollection$CarZeroEmissionEntry) {
        if (null != car2XObjectCollection$CarZeroEmissionEntry) {
            AbstractZeroEmissionStatisticsComponent.access$100(this.this$0, 4201, car2XObjectCollection$CarZeroEmissionEntry);
        }
    }

    public void sendHistoryBarGraphUpdate(Car2XObjectCollection$CarZeroEmissionEntry[] car2XObjectCollection$CarZeroEmissionEntryArray) {
        if (null != car2XObjectCollection$CarZeroEmissionEntryArray) {
            AbstractZeroEmissionStatisticsComponent.access$200(this.this$0, 4202, car2XObjectCollection$CarZeroEmissionEntryArray);
        }
    }
}


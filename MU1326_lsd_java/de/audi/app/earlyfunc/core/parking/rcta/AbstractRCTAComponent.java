/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.rcta;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;

public abstract class AbstractRCTAComponent
extends AbstractDSICarDriverAssistanceAdapter {
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.Parking";
    public static final short CODING_ID = 5;
    private static final int RCTA_NONE = 0;
    private static final int RCTA_OBSTACLE = 1;
    private static final int RCTA_SENSOR_ERROR = 2;

    public AbstractRCTAComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        this.getLogChannel().log(1000000, "--> updateSWARCTASensorData(%1, %2)", (Object)sWARCTASensorData, (long)n);
        if (n == 1) {
            switch (sWARCTASensorData.getStatusLevelRearLeft()) {
                case 2: {
                    this.getChoiceModel(2100199).setValue(1);
                    break;
                }
                case 15: {
                    this.getChoiceModel(2100199).setValue(2);
                    break;
                }
                default: {
                    this.getChoiceModel(2100199).setValue(0);
                }
            }
            switch (sWARCTASensorData.getStatusLevelRearRight()) {
                case 2: {
                    this.getChoiceModel(2100200).setValue(1);
                    break;
                }
                case 15: {
                    this.getChoiceModel(2100200).setValue(2);
                    break;
                }
                default: {
                    this.getChoiceModel(2100200).setValue(0);
                }
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[0], new int[]{54})};
    }

    public String getCurrentViewOptions() {
        return "no view options for this component";
    }

    public String getName() {
        return "Parking - RCTA";
    }
}


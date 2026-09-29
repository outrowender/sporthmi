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
    private static final String LOGCHANNEL_NAME;
    public static final short CODING_ID;
    private static final int RCTA_NONE;
    private static final int RCTA_OBSTACLE;
    private static final int RCTA_SENSOR_ERROR;

    public AbstractRCTAComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Parking");
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        this.getLogChannel().log(1078071040, "--> updateSWARCTASensorData(%1, %2)", (Object)sWARCTASensorData, (long)n);
        if (n == 1) {
            switch (sWARCTASensorData.getStatusLevelRearLeft()) {
                case 2: {
                    this.getChoiceModel(-418701312).setValue(1);
                    break;
                }
                case 15: {
                    this.getChoiceModel(-418701312).setValue(2);
                    break;
                }
                default: {
                    this.getChoiceModel(-418701312).setValue(0);
                }
            }
            switch (sWARCTASensorData.getStatusLevelRearRight()) {
                case 2: {
                    this.getChoiceModel(-401924096).setValue(1);
                    break;
                }
                case 15: {
                    this.getChoiceModel(-401924096).setValue(2);
                    break;
                }
                default: {
                    this.getChoiceModel(-401924096).setValue(0);
                }
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[0], new int[]{54})};
    }

    @Override
    public String getCurrentViewOptions() {
        return "no view options for this component";
    }

    @Override
    public String getName() {
        return "Parking - RCTA";
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.pla.IPLAAdditionalInfoHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLAAdditionalInfoHandler
implements IPLAAdditionalInfoHandler {
    private final LogChannel logChannel;
    private final ChoiceModelApp drivingDirectionModel;
    private static final int DRIVING_DIRECTION_NONE;
    private static final int DRIVING_DIRECTION_FORWARD;
    private static final int DRIVING_DIRECTION_BACKWARD;
    private static final int DRIVING_DIRECTION_OK;
    private static final int SYMBOL_INVISIBLE;
    private static final int SYMBOL_VISIBLE;
    private final ChoiceModelApp brakeSymbolModel;
    private final ChoiceModelApp steeringInterventionModel;

    public PLAAdditionalInfoHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.drivingDirectionModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1460412416);
        this.brakeSymbolModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1477189632);
        this.steeringInterventionModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1493966848);
    }

    @Override
    public void init() {
        this.logChannel.log(1078071040, "[PLAAdditionalHandler#init]");
    }

    @Override
    public void deinit() {
        this.logChannel.log(1078071040, "[PLAAdditionalHandler#deinit]");
    }

    @Override
    public void updatePLAStatus(PDCPLAStatus pDCPLAStatus) {
        this.logChannel.log(1078071040, "[PLAAdditionalInfoHandler#updatePLAStatus]");
        int n = pDCPLAStatus.getDrivingDirection();
        boolean bl = pDCPLAStatus.getInstructions().isBrakeSymbol();
        if (bl) {
            this.brakeSymbolModel.setValue(1);
        } else {
            this.brakeSymbolModel.setValue(0);
        }
        switch (n) {
            case 3: {
                this.drivingDirectionModel.setValue(1);
                break;
            }
            case 4: {
                this.drivingDirectionModel.setValue(2);
                break;
            }
            case 1: {
                if (!bl) {
                    this.drivingDirectionModel.setValue(3);
                    break;
                }
            }
            default: {
                this.drivingDirectionModel.setValue(0);
            }
        }
        this.steeringInterventionModel.setValue(this.getInterventionSymbolState(pDCPLAStatus));
    }

    private int getInterventionSymbolState(PDCPLAStatus pDCPLAStatus) {
        boolean bl = pDCPLAStatus.getInstructions().isSteeringInterventionSymbol();
        if (bl) {
            boolean bl2 = pDCPLAStatus.getMode() == 4 || pDCPLAStatus.getMode() == 5;
            return bl2 ? 2 : 1;
        }
        return 0;
    }
}


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
    private static final int DRIVING_DIRECTION_NONE = 0;
    private static final int DRIVING_DIRECTION_FORWARD = 1;
    private static final int DRIVING_DIRECTION_BACKWARD = 2;
    private static final int DRIVING_DIRECTION_OK = 3;
    private static final int SYMBOL_INVISIBLE = 0;
    private static final int SYMBOL_VISIBLE = 1;
    private final ChoiceModelApp brakeSymbolModel;
    private final ChoiceModelApp steeringInterventionModel;

    public PLAAdditionalInfoHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.drivingDirectionModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100311);
        this.brakeSymbolModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100312);
        this.steeringInterventionModel = iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100313);
    }

    public void init() {
        this.logChannel.log(1000000, "[PLAAdditionalHandler#init]");
    }

    public void deinit() {
        this.logChannel.log(1000000, "[PLAAdditionalHandler#deinit]");
    }

    public void updatePLAStatus(PDCPLAStatus pDCPLAStatus) {
        this.logChannel.log(1000000, "[PLAAdditionalInfoHandler#updatePLAStatus]");
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


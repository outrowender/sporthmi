/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;

public abstract class AbstractEtronComponent
extends AbstractDSICarDrivingCharacteristicsAdapter
implements ChoiceListener {
    public static final short[] CODING_ID = new short[]{17, 24};
    protected static final String LOGCHANNEL_NAME = "App.Car.Charge.Etron";
    private final LogChannel logMSC;
    protected volatile CharismaViewOptions currViewOptions;
    private ChoiceModelApp selectedProfileChoiceModel;

    public AbstractEtronComponent(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charge.Etron.MSC");
    }

    public AbstractEtronComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.selectedProfileChoiceModel = this.getChoiceModel(2100359);
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charge.Etron.MSC");
    }

    public String getName() {
        return "Etron";
    }

    protected ChoiceModelApp getEtronModusSelectionModel() {
        return this.selectedProfileChoiceModel;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{15, 28})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public CharismaViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    protected void initModels() {
        this.getChoiceModel(2100359).setChoiceListener(this);
    }

    protected void deinitModels() {
    }

    protected int getCharismaActiveOperationMode() {
        return this.getChoiceModel(2100359).getValue();
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 2100359: {
                this.switchEtronModeSelection(n2);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    private void switchEtronModeSelection(int n) {
        this.logMSC.log(1000000, "---> setCharismaActiveOperationMode(%1)", (long)n);
        this.getDSI().setCharismaActiveOperationMode(n);
    }

    protected boolean isChargeEtronSelectedModeChoiceItemID(int n) {
        return 2100359 == n;
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void updateCharismaActiveOperationMode(int n, int n2) {
        if (n2 == 1) {
            this.getChoiceModel(2100359).setValue(n);
        }
    }

    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateCharismaViewOptions: charismaViewOptions=%1, valid=%2", (Object)(charismaViewOptions != null ? this.formatViewOptionsLog(charismaViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && charismaViewOptions != null) {
            this.currViewOptions = charismaViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(CharismaViewOptions var1);
}


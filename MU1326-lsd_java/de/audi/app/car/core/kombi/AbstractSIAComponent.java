/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.lang.ILanguageUpdateListener;
import de.audi.app.car.common.util.CarDistance;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.i18n.Language;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;

public abstract class AbstractSIAComponent
extends AbstractDSICarKombiAdapter
implements ButtonListener,
ILanguageUpdateListener {
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    private volatile SIAViewOptions currentViewOptions;
    private volatile SIAServiceData currentServiceData = new SIAServiceData(0, 0, 0, 0, 0);
    private volatile SIAOilInspection currentOilInspectionData = new SIAOilInspection(0, 0, 0, 0, 0);
    private static final int HIDE;
    private static final int SHOW;
    private static final int TIME_MEASURE_SINGULAR;
    private static final int TIME_MEASURE_PLURAL;
    private static final int TIME_MEASURE_UNDEFINED;
    private static final int TEXT_FRAGMENT_VISIBLE_DISTANCE;
    private static final int TEXT_FRAGMENT_VISIBLE_TIME;
    private static final int TEXT_FRAGMENT_VISIBLE_ALL;
    private static final int PREPOSITION_IN;
    private static final int PREPOSITION_SINCE;
    private final ModelGroup siaHideModelGroup = new ModelGroup();

    public AbstractSIAComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.SIA");
    }

    @Override
    protected void initModels() {
        this.getButtonModel(1311312128).setButtonListener(this);
        this.getMetricsModel(1126959360).setMetric(new CarDistance(0.0f, 1));
        this.getMetricsModel(1126959360).formatChanged();
        this.getMetricsModel(1277954304).setMetric(new CarDistance(0.0f, 1));
        this.getMetricsModel(1277954304).formatChanged();
        this.siaHideModelGroup.add(this.getChoiceModel(1277757696));
        this.siaHideModelGroup.add(this.getChoiceModel(1378420992));
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(1311312128).resetListener();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{2, 3})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(SIAViewOptions sIAViewOptions) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed:", n, n2, true);
        switch (n) {
            case 600398: {
                this.resetOilInterval();
                this.getButtonModel(1311312128).fireEvent(n3);
                break;
            }
            default: {
                this.logModelData("keyPressed:", n, n2, false);
            }
        }
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

    @Override
    public void setLanguage(Language language) {
        this.updateOilData();
        this.updateServiceData();
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
        this.getLogChannel().log(1078071040, "updateSIAOilInspection(%1), valid:%2", (Object)sIAOilInspection, (long)n);
        if (n == 1) {
            this.currentOilInspectionData = sIAOilInspection;
            this.updateOilData();
        }
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
        this.getLogChannel().log(1078071040, "updateSIAServiceData(%1), valid:%2", (Object)sIAServiceData, (long)n);
        if (n == 1) {
            this.currentServiceData = sIAServiceData;
            this.updateServiceData();
        }
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateSIAViewOptions(%1), valid:%2", (Object)(sIAViewOptions != null ? this.formatViewOptionsLog(sIAViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && sIAViewOptions != null) {
            this.currentViewOptions = sIAViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.updateOilData();
            this.updateServiceData();
            this.primaryAttributeFirstSetReceived();
        }
    }

    private void resetOilInterval() {
        int n = 3;
        this.getLogChannel().log(1078071040, "dsi.resetSIAValue(%1)", (long)n);
        this.getDSI().resetSIAValue(n);
    }

    private void updateServiceData() {
        this.setVisibilityOfInspectionEntries();
        if (this.currentServiceData != null) {
            this.getLogChannel().log(1078071040, "[AbstractSiaComponenti#setInspectionData] Setting Service Data to %1", (Object)this.currentServiceData);
            this.updatePrepositionChoice(this.getChoiceModel(-1725363968), this.currentServiceData.getDistanceStatus(), this.currentServiceData.getTimeStatus());
            this.updateTextFragmentVisibility(this.getChoiceModel(1177291008), this.currentServiceData.getDistanceStatus(), this.currentServiceData.getTimeStatus());
            this.updateDistanceMetrics(this.getMetricsModel(1277954304), this.currentServiceData.getDistanceStatus(), this.currentServiceData.getDistanceUnit(), this.currentServiceData.getDistance());
            this.updateTimeLabel(this.getChoiceModel(1311508736), this.getLabelModel(-1708586752), this.currentServiceData.getTimeStatus(), this.currentServiceData.getTime());
        }
    }

    private void updateOilData() {
        this.setVisibilityOfInspectionEntries();
        if (this.currentOilInspectionData != null) {
            this.getLogChannel().log(1078071040, "[AbstractSiaComponent#setOilChangeData] Setting Oil Interval Data to %1", (Object)this.currentOilInspectionData);
            this.updatePrepositionChoice(this.getChoiceModel(-1658255104), this.currentOilInspectionData.getDistanceStatus(), this.currentOilInspectionData.getTimeStatus());
            this.updateTextFragmentVisibility(this.getChoiceModel(1160513792), this.currentOilInspectionData.getDistanceStatus(), this.currentOilInspectionData.getTimeStatus());
            this.updateDistanceMetrics(this.getMetricsModel(1126959360), this.currentOilInspectionData.getDistanceStatus(), this.currentOilInspectionData.getDistanceUnit(), this.currentOilInspectionData.getDistance());
            this.updateTimeLabel(this.getChoiceModel(1294731520), this.getLabelModel(-1641477888), this.currentOilInspectionData.getTimeStatus(), this.currentOilInspectionData.getTime());
        }
    }

    private void updatePrepositionChoice(ChoiceModelApp choiceModelApp, int n, int n2) {
        int n3 = 0;
        if (n == 3 || n2 == 3) {
            n3 = 1;
        }
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSIAComponent#updatePrepositionChoice] set preposition ChoiceModel: preposition='%1' , model='%2'", (Object)(n3 == 1 ? "since" : "in"), (Object)choiceModelApp);
        }
        choiceModelApp.setValue(n3);
    }

    private void updateTextFragmentVisibility(ChoiceModelApp choiceModelApp, int n, int n2) {
        int n3 = 3;
        if (n2 == 3) {
            if (n == 2) {
                n3 = 2;
            }
        } else if (n == 3 && n2 == 2) {
            n3 = 1;
        }
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSIAComponent#updateTextFragmentVisibility] set text fragment visibility ChoiceModel: value='%1' , model='%2'", (Object)new Integer(n3), (Object)choiceModelApp);
        }
        choiceModelApp.setValue(n3);
    }

    private void updateTimeLabel(ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, int n, int n2) {
        int n3 = 2;
        if (n != 0 && n != 1) {
            n3 = this.getNumberOfTimeMeasure(n2);
        }
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSIAComponent#updateTimeLabel] set time measure ChoiceModel: value='%1' , model='%2'", (Object)new Integer(n3), (Object)choiceModelApp);
            this.getLogChannel().log(1078071040, "[AbstractSIAComponent#updateTimeLabel] set time text label: value='%1' , model='%2'", (Object)new Integer(n2), (Object)labelModelApp);
        }
        choiceModelApp.setValue(n3);
        labelModelApp.setText(String.valueOf(n2));
    }

    private int getNumberOfTimeMeasure(int n) {
        if (n != 1) {
            return 1;
        }
        return 0;
    }

    private void updateDistanceMetrics(MetricsModelApp metricsModelApp, int n, int n2, int n3) {
        CarDistance carDistance = this.createDistanceMetric(n, n2, n3);
        carDistance.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractSIAComponent#updateDistanceMetrics] distanceMetric='%1' , model=%2", (Object)carDistance.format(carDistance.getUnit()), (Object)metricsModelApp);
        }
        metricsModelApp.setMetric(carDistance);
        metricsModelApp.formatChanged();
    }

    private CarDistance createDistanceMetric(int n, int n2, int n3) {
        if (n == 0 || n == 1) {
            return new CarDistance();
        }
        return new CarDistance(n3, this.getCarUnitForDSIDistanceConstant(n2));
    }

    private int getCarUnitForDSIDistanceConstant(int n) {
        if (n == 1) {
            return 2;
        }
        return 1;
    }

    private void setVisibilityOfInspectionEntries() {
        boolean bl = this.isOilinspectionDataValid();
        boolean bl2 = this.isServiceDataValid();
        boolean bl3 = false;
        boolean bl4 = false;
        if (bl) {
            bl3 = this.isErrorOilInspectionState();
        }
        if (bl2) {
            bl4 = this.isErrorServiceState();
        }
        boolean bl5 = bl3 && (bl4 || !bl2) || bl4 && !bl;
        this.setVisibilityOfInspectionEntry(1277757696, bl && !bl5);
        this.setVisibilityOfInspectionEntry(1378420992, bl2 && !bl5);
        this.siaHideModelGroup.flush();
    }

    private void setVisibilityOfInspectionEntry(int n, boolean bl) {
        this.getChoiceModel(n).setValue(bl ? 1 : 0);
    }

    private boolean isErrorOilInspectionState() {
        return this.currentOilInspectionData.getDistanceStatus() != 3 && this.currentOilInspectionData.getDistanceStatus() != 2 && this.currentOilInspectionData.getTimeStatus() != 3 && this.currentOilInspectionData.getTimeStatus() != 2;
    }

    private boolean isErrorServiceState() {
        return this.currentServiceData.getDistanceStatus() != 3 && this.currentServiceData.getDistanceStatus() != 2 && this.currentServiceData.getTimeStatus() != 3 && this.currentServiceData.getTimeStatus() != 2;
    }

    private boolean isServiceDataValid() {
        return this.currentViewOptions != null && this.currentServiceData != null && this.currentViewOptions.getServiceData().state == 2 && (this.currentServiceData.getDistanceStatus() != 0 || this.currentServiceData.getTimeStatus() != 0);
    }

    private boolean isOilinspectionDataValid() {
        return this.currentViewOptions != null && this.currentOilInspectionData != null && this.currentViewOptions.getOilInspection().state == 2 && (this.currentOilInspectionData.getDistanceStatus() != 0 || this.currentOilInspectionData.getTimeStatus() != 0);
    }

    @Override
    public String getName() {
        return "SIA";
    }
}


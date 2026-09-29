/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.earlyfunc.core.hybrid.AbstractEtronComponent;
import de.audi.app.earlyfunc.hybrid.EtronMenuEventBusiness;
import de.audi.app.earlyfunc.hybrid.EtronPopupHKTimerController;
import de.audi.app.earlyfunc.hybrid.EtronPopupHandler;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class EtronComponentEvo
extends AbstractEtronComponent {
    private static final int STATE_DISABLED_BATTERY_ERROR;
    public CharismaViewOptions currViewOptions;
    public static final int ETRON_POPUP_ID_INVALID;
    private EtronPopupHandler popupHandler = new EtronPopupHandler(this.getApplication(), this, this.getLogChannel());
    private EtronPopupHKTimerController popupHKTimer = null;
    private DefaultMenuModelHandler etronMenuHandler = null;
    private final LogChannel logMSC;

    public EtronComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charge.Etron.MSC");
    }

    @Override
    public void initModels() {
        super.initModels();
        this.popupHKTimer = new EtronPopupHKTimerController(this.getChoiceModel(-1525932032), this.getLogChannel());
        this.initServiceProvider();
        this.popupHandler.setTimer(this.popupHKTimer);
        this.etronMenuHandler = new DefaultMenuModelHandler(this.getMenuModel(-1509154816), this.getLogChannel());
        this.getChoiceModel(-1525932032).setValue(0);
        this.getButtonModel(-1475600384).setButtonListener(this);
    }

    @Override
    protected void initBusiness() {
        this.etronMenuHandler.setBusiness(new EtronMenuEventBusiness(this.getDSI(), this.etronMenuHandler, this.getChoiceModel(-1492377600), this.popupHKTimer, this.getLogChannel()));
    }

    @Override
    protected void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(8, this.getExtendedMenuEntryVisibilityState(charismaViewOptions.getActiveOperationMode(), charismaViewOptions.getSustainingMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(7, this.getExtendedMenuEntryVisibilityState(charismaViewOptions.getActiveOperationMode(), charismaViewOptions.getEvMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(9, this.getExtendedMenuEntryVisibilityState(charismaViewOptions.getActiveOperationMode(), charismaViewOptions.getHybridMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(10, this.getExtendedMenuEntryVisibilityState(charismaViewOptions.getActiveOperationMode(), charismaViewOptions.getChargingMode()));
    }

    private int getExtendedMenuEntryVisibilityState(CarViewOption carViewOption, CarViewOption carViewOption2) {
        if (this.isDisabledBatteryL1(carViewOption) && this.isLowerPrioThanL1(carViewOption2) || this.isDisabledBatteryL1(carViewOption2) && this.isLowerPrioThanL1(carViewOption) || this.isDisabledBatteryL1(carViewOption) && this.isDisabledBatteryL1(carViewOption2)) {
            return 11;
        }
        if (this.isDisabledBatteryL1(carViewOption)) {
            return this.getMenuEntryVisibilityState(carViewOption2);
        }
        if (this.isDisabledBatteryL1(carViewOption2)) {
            return this.getMenuEntryVisibilityState(carViewOption);
        }
        return this.getMenuEntryVisibilityState(new CarViewOption[]{carViewOption, carViewOption2});
    }

    private boolean isDisabledBatteryL1(CarViewOption carViewOption) {
        return carViewOption.getState() == 1 && carViewOption.getReason() == 30;
    }

    private boolean isLowerPrioThanL1(CarViewOption carViewOption) {
        return carViewOption.getState() == 2;
    }

    @Override
    public int getID() {
        return 10;
    }

    public int getPopUpID() {
        return 1292574720;
    }

    public int getStandbyPopupID() {
        return 6;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(8, CODING_ID[0]);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(7, CODING_ID[0]);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(9, CODING_ID[0]);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(10, CODING_ID[0]);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(8);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(7);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(9);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(10);
    }

    public void initServiceProvider() {
        this.popupHandler.initServiceProvider();
    }

    @Override
    public void requestCharismaPopup(int n) {
        this.logMSC.log(1078071040, "<--- requestCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1 && 5 == n) {
            this.popupHandler.requestCharismaPopup(n, true);
        } else if (this.getPopUpID() != -1 && 0 == n) {
            this.popupHandler.removeEtronPopup();
        }
    }

    @Override
    public void acknowledgeCharismaPopup(int n) {
        this.logMSC.log(1078071040, "<--- acknowledgeCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1) {
            this.popupHandler.acknowledgePopup(n);
        }
    }

    @Override
    public void updateCharismaContent(int n, int n2) {
        this.logMSC.log(1078071040, "<--- updateCharismaContent(%1, %2)", (long)n, (long)n2);
        this.popupHandler.updateCharismaPopup(n);
    }

    public void showCharismaPopup(int n, int n2) {
        this.logMSC.log(1078071040, "---> showCharismaContent(%1, %2)", (long)n, (long)n2);
        this.getDSI().showCharismaPopup(n, n2);
    }

    public void cancelCharismaPopup(int n, int n2) {
        this.logMSC.log(1078071040, "---> cancelCharismaPopup(%1, %2)", (long)n, (long)n2);
        this.getDSI().cancelCharismaPopup(n, n2);
    }

    @Override
    public void updateCharismaActiveOperationMode(int n, int n2) {
        super.updateCharismaActiveOperationMode(n, n2);
        this.updateOperationMode();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed", n, n2, true);
        if (n == -1475600384) {
            this.getChoiceModel(-1525932032).setValue(1);
        }
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        if (this.getApplication().getCarMenuCoding().getByteCoding((short)17) <= 0) {
            super.dsiAvailable(bl);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        this.getLogChannel().log(1078071040, "[EtronComponentEvo:itemSelected]modelID:%1, itemID:%2", (long)n, (long)n2);
        if (this.isChargeEtronSelectedModeChoiceItemID(n)) {
            if (this.getCharismaActiveOperationMode() == n2) {
                this.getLogChannel().log(1078071040, "[EtronComponentEvo:itemSelected] ChargeEtronSelectedMode unchanged, no DSI call!");
                this.updateOperationMode();
            } else {
                this.getLogChannel().log(1078071040, "[EtronComponentEvo:itemSelected] ChargeEtronSelectedMode changed from %1 to %2, calling DSI", (long)this.getCharismaActiveOperationMode(), (long)n2);
                this.logMSC.log(1078071040, "---> setCharismaActiveOperationMode(%1)", (long)n2);
                this.getDSI().setCharismaActiveOperationMode(n2);
            }
        } else {
            this.getLogChannel().log(1078071040, "[EtronComponentEvo:itemSelected] unhandled model ID %1", (long)n);
            this.logModelData("itemSelected:", n, n2, false);
        }
    }

    private void updateOperationMode() {
        this.popupHKTimer.resetActivated();
        ((EtronMenuEventBusiness)this.etronMenuHandler.getBusiness()).updateActiveOperationMode(this.getEtronModusSelectionModel().getValue());
    }
}


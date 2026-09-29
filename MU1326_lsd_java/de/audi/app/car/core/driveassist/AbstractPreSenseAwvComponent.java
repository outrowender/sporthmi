/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;

public abstract class AbstractPreSenseAwvComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final short AWV_TIMEGAP_OFF_HMI_INDEX;
    private static final short AWV_TIMEGAP_EARLY_HMI_INDEX;
    private static final short AWV_TIMEGAP_MEDIUM_HMI_INDEX;
    private static final short AWV_TIMEGAP_LATE_HMI_INDEX;
    private volatile AWVViewOptions currViewOptions;

    public AbstractPreSenseAwvComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.PreSense.AWV");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1540749056).setChoiceListener(this);
        this.getChoiceModel(-1507194624).setChoiceListener(this);
        this.getChoiceModel(1009912064).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1540749056).resetListener();
        this.getChoiceModel(-1507194624).resetListener();
        this.getChoiceModel(1009912064).resetListener();
    }

    private void setAWVSystem(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setAWVSystem(%1)", bl);
        this.getDSI().setAWVSystem(bl ? 1 : 0);
    }

    private void setAWVWarning(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setAWVWarning(%1)", bl);
        this.getDSI().setAWVWarning(bl);
    }

    private void setAwvWarningTimegap(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
        }
        this.getLogChannel().log(1078071040, "dsi.setAWVWarningTimegap(%1)", (long)n2);
        this.getDSI().setAWVWarningTimegap(n2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        boolean bl = n2 == 1;
        switch (n) {
            case 600740: {
                this.setAWVSystem(bl);
                break;
            }
            case 600742: {
                this.setAWVWarning(bl);
                break;
            }
            case 602684: {
                this.setAwvWarningTimegap(n2);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{30}, new int[]{31, 32, 63})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public AWVViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    @Override
    public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateAWVViewOptions(%1), valid:%2", (Object)aWVViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = aWVViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateAWVSystem(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateAWVSystem(%1), valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(-1540749056).setValue(n);
        }
    }

    @Override
    public void updateAWVWarning(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateAWVWarning(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-1507194624).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateAWVWarningTimegap(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateAWVWarningTimegap(%1), valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = 0;
            switch (n) {
                case 0: {
                    n3 = 0;
                    break;
                }
                case 3: {
                    n3 = 1;
                    break;
                }
                case 2: {
                    n3 = 2;
                    break;
                }
                case 1: {
                    n3 = 3;
                    break;
                }
            }
            this.getChoiceModel(1009912064).setValue(n3);
        }
    }

    protected abstract void updateMenuEntryVisibility(AWVViewOptions aWVViewOptions) {
    }

    @Override
    public String getName() {
        return "Audi PreSense (AWV)";
    }
}


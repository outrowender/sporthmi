/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;

public abstract class AbstractAppManagerCore
implements ButtonListener {
    private final ButtonModel[] hardkeys;
    private final int[] smEvents;
    private final IFrameworkAccess framework;
    private final LogChannel log;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;

    public AbstractAppManagerCore(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = this.framework.getLogChannel("App.System.Main");
        int n = this.framework.getLastmodeHandler().getLastmodeStorage().getSkin();
        ((ChoiceModel)this.framework.getHMIService().getModel(3937)).setValue(n);
        this.setKeyboardTypeModel(iFrameworkAccess);
        this.hardkeys = new ButtonModel[22];
        this.smEvents = new int[22];
        this.hardkeys[0] = (ButtonModel)this.framework.getHMIService().getModel(119);
        this.hardkeys[1] = (ButtonModel)this.framework.getHMIService().getModel(114);
        this.hardkeys[2] = null;
        this.hardkeys[3] = (ButtonModel)this.framework.getHMIService().getModel(118);
        this.hardkeys[4] = (ButtonModel)this.framework.getHMIService().getModel(116);
        this.hardkeys[5] = (ButtonModel)this.framework.getHMIService().getModel(3975);
        this.hardkeys[6] = (ButtonModel)this.framework.getHMIService().getModel(113);
        this.hardkeys[7] = (ButtonModel)this.framework.getHMIService().getModel(458);
        this.hardkeys[8] = null;
        this.hardkeys[9] = (ButtonModel)this.framework.getHMIService().getModel(117);
        this.hardkeys[10] = (ButtonModel)this.framework.getHMIService().getModel(454);
        this.hardkeys[11] = (ButtonModel)this.framework.getHMIService().getModel(457);
        this.hardkeys[12] = (ButtonModel)this.framework.getHMIService().getModel(4393);
        this.hardkeys[13] = (ButtonModel)this.framework.getHMIService().getModel(4391);
        this.hardkeys[14] = (ButtonModel)this.framework.getHMIService().getModel(115);
        this.hardkeys[15] = (ButtonModel)this.framework.getHMIService().getModel(3814);
        this.hardkeys[16] = (ButtonModel)this.framework.getHMIService().getModel(3815);
        this.hardkeys[17] = (ButtonModel)this.framework.getHMIService().getModel(3816);
        this.hardkeys[18] = (ButtonModel)this.framework.getHMIService().getModel(4408);
        this.hardkeys[19] = (ButtonModel)this.framework.getHMIService().getModel(4390);
        this.hardkeys[20] = (ButtonModel)this.framework.getHMIService().getModel(4392);
        this.hardkeys[21] = (ButtonModel)this.framework.getHMIService().getModel(4407);
        for (int i2 = 0; i2 < this.hardkeys.length; ++i2) {
            if (this.hardkeys[i2] == null) continue;
            this.hardkeys[i2].setButtonListener(this);
        }
    }

    private void setKeyboardTypeModel(IFrameworkAccess iFrameworkAccess) {
        try {
            KbdService kbdService = null;
            ServiceReference serviceReference = iFrameworkAccess.getBundleCxt().getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = AbstractAppManagerCore.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
            if (serviceReference != null) {
                kbdService = (KbdService)iFrameworkAccess.getBundleCxt().getService(serviceReference);
            }
            if (kbdService == null) {
                this.log.log(10000, "AbstractAppManagerCore#setKeyboardTypeModel No key board service available!");
                return;
            }
            int n = kbdService.getCurrentKeyboardType();
            this.log.log(-2137614336, "# AbstractAppManagerCore#setKeyboardTypeModel KBD_TYPE=%1", (long)n);
            if (n != 0) {
                ((ChoiceModel)this.framework.getHMIService().getModel(4076)).setValue(n);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected final IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected final HMIService getHMIService() {
        return this.framework.getHMIService();
    }

    protected final LogChannel getLog() {
        return this.log;
    }

    protected void fireSMEvent(int n, int n2) {
        this.getLog().log(1078071040, "AbstractAppManager.fireSMEvent(%1, %2)", (long)n, (long)n2);
        this.getHMIService().fireSMEvent(n, n2);
    }

    abstract void handleHKSource(int n, int n2) {
    }

    abstract void handleHKOption(int n, int n2) {
    }

    abstract void handleHKNav(int n, int n2) {
    }

    protected final void initSMEvents(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20) {
        this.smEvents[0] = n;
        this.smEvents[1] = n2;
        this.smEvents[2] = 0;
        this.smEvents[3] = n3;
        this.smEvents[4] = n4;
        this.smEvents[5] = n14;
        this.smEvents[6] = n5;
        this.smEvents[7] = n6;
        this.smEvents[8] = 0;
        this.smEvents[9] = n7;
        this.smEvents[10] = n8;
        this.smEvents[11] = n9;
        this.smEvents[12] = n16;
        this.smEvents[13] = n17;
        this.smEvents[14] = n10;
        this.smEvents[15] = n11;
        this.smEvents[16] = n12;
        this.smEvents[17] = n13;
        this.smEvents[18] = n15;
        this.smEvents[19] = n18;
        this.smEvents[20] = n19;
        this.smEvents[21] = n20;
    }

    public final ButtonModelGUI getVirtualButton(int n) {
        switch (n) {
            case 19: {
                return this.hardkeys[0];
            }
            case 20: {
                return this.hardkeys[1];
            }
            case 21: {
                return this.hardkeys[2];
            }
            case 22: {
                return this.hardkeys[3];
            }
            case 23: {
                return this.hardkeys[4];
            }
            case 24: {
                return this.hardkeys[5];
            }
            case 25: {
                return this.hardkeys[6];
            }
            case 26: {
                return this.hardkeys[7];
            }
            case 27: {
                return this.hardkeys[8];
            }
            case 28: {
                return this.hardkeys[9];
            }
            case 29: {
                return this.hardkeys[10];
            }
            case 30: {
                return this.hardkeys[11];
            }
            case 31: {
                return this.hardkeys[12];
            }
            case 32: {
                return this.hardkeys[13];
            }
            case 33: {
                return this.hardkeys[14];
            }
            case 40: {
                return this.hardkeys[15];
            }
            case 41: {
                return this.hardkeys[16];
            }
            case 42: {
                return this.hardkeys[17];
            }
            case 48: {
                return this.hardkeys[18];
            }
            case 46: {
                return this.hardkeys[19];
            }
            case 47: {
                return this.hardkeys[20];
            }
            case 49: {
                return this.hardkeys[21];
            }
        }
        return null;
    }

    @Override
    public final void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public final void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public final void keyTyped(int n, int n2, int n3) {
        this.getLog().log(1078071040, "AbstractAppManager.keyTyped(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 119: {
                this.fireSMEvent(n3, this.smEvents[0]);
                break;
            }
            case 114: {
                this.fireSMEvent(n3, this.smEvents[1]);
                break;
            }
            case 118: {
                this.fireSMEvent(n3, this.smEvents[3]);
                break;
            }
            case 116: {
                this.handleHKNav(n3, this.smEvents[4]);
                break;
            }
            case 3975: {
                this.fireSMEvent(n3, this.smEvents[5]);
                break;
            }
            case 113: {
                this.fireSMEvent(n3, this.smEvents[6]);
                break;
            }
            case 458: {
                this.fireSMEvent(n3, this.smEvents[7]);
                break;
            }
            case 117: {
                this.fireSMEvent(n3, this.smEvents[9]);
                break;
            }
            case 454: {
                this.fireSMEvent(n3, this.smEvents[10]);
                break;
            }
            case 457: {
                this.fireSMEvent(n3, this.smEvents[11]);
                break;
            }
            case 4393: {
                this.fireSMEvent(n3, this.smEvents[12]);
                break;
            }
            case 4391: {
                this.fireSMEvent(n3, this.smEvents[13]);
                break;
            }
            case 115: {
                this.fireSMEvent(n3, this.smEvents[14]);
                break;
            }
            case 3814: {
                this.fireSMEvent(n3, this.smEvents[15]);
                break;
            }
            case 3815: {
                this.handleHKOption(n3, this.smEvents[16]);
                break;
            }
            case 3816: {
                this.handleHKSource(n3, this.smEvents[17]);
                break;
            }
            case 4408: {
                this.fireSMEvent(n3, this.smEvents[18]);
                break;
            }
            case 4390: {
                this.fireSMEvent(n3, this.smEvents[19]);
                break;
            }
            case 4392: {
                this.fireSMEvent(n3, this.smEvents[20]);
                break;
            }
            case 4407: {
                this.fireSMEvent(n3, this.smEvents[21]);
                break;
            }
        }
    }

    @Override
    public final void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


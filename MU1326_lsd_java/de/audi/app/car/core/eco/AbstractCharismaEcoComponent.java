/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.eco.AbstractDSICarEcoAdapter;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;
import org.dsi.ifc.careco.EAViewOptions;

public abstract class AbstractCharismaEcoComponent
extends AbstractDSICarEcoAdapter {
    public static final short CODING_ID = 17;
    private static final String LOGCHANNEL_NAME = "App.Car.Charisma.Eco";
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    private final ChoiceListener modelListener = new ChoiceListener();
    private final LocalMsgListener msgListener = new LocalMsgListener();
    protected volatile EAViewOptions currentViewOptions;
    protected boolean invertHMIStartStop = false;

    public AbstractCharismaEcoComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void dsiSetStartStop(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setEAStartStop(%1)", bl);
        this.getDSI().setEAStartStop(bl);
    }

    protected void dsiSetFreeRolling(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setEAFreeWheeling(%1)", bl);
        this.getDSI().setEAFreeWheeling(bl);
    }

    protected boolean getStartStopStatus() {
        boolean bl;
        int n = this.getChoiceModel(601716).getValue();
        boolean bl2 = bl = 1 == n;
        return this.invertHMIStartStop ? !bl : bl;
    }

    public abstract void updateMenuEntryVisibility(EAViewOptions var1);

    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    protected void initModels() {
        this.getChoiceModel(601716).setChoiceListener(this.modelListener);
        this.getChoiceModel(601707).setChoiceListener(this.modelListener);
    }

    protected void deinitModels() {
        this.getChoiceModel(601716).resetListener();
        this.getChoiceModel(601707).resetListener();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{42}, new int[]{48, 47})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions != null) {
            return this.currentViewOptions.toString();
        }
        return "not yet received";
    }

    public String getName() {
        return "Charisma Eco";
    }

    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaEcoComponentPorscheGen2#updateEAViewOptions] '%1', valid:%2", (Object)eAViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = eAViewOptions;
            this.updateMenuEntryVisibility(eAViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateEAFreeWheeling(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaEcoComponentPorscheGen2#updateEAFreeWheeling] '%1', valid:%2", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(601707).setValue(bl ? 1 : 0);
        }
    }

    public void updateEAStartStop(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaEcoComponentPorscheGen2#updateEAStartStop] '%1', valid:%2", bl, (long)n);
        }
        if (n == 1) {
            int n2 = this.invertHMIStartStop ? (bl ? 0 : 1) : (bl ? 1 : 0);
            this.getChoiceModel(601716).setValue(n2);
        }
    }

    private final class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractCharismaEcoComponent.this.getLogChannel().log(1000000, "[AbstractCharismaEcoComponent#itemSelected] %1, %2", (long)n, (long)n2);
            boolean bl = 1 == n2;
            switch (n) {
                case 601716: {
                    AbstractCharismaEcoComponent.this.dsiSetStartStop(AbstractCharismaEcoComponent.this.invertHMIStartStop ? !bl : bl);
                    break;
                }
                case 601707: {
                    AbstractCharismaEcoComponent.this.dsiSetFreeRolling(bl);
                    break;
                }
            }
        }
    }

    private class LocalMsgListener
    implements MsgListener {
        private LocalMsgListener() {
        }

        public void processMsg(int n) {
            ButtonModelApp buttonModelApp;
            if (79 == n && 82 == AbstractCharismaEcoComponent.this.getChoiceModel(395).getValue() && null != (buttonModelApp = AbstractCharismaEcoComponent.this.getButtonModel(600977))) {
                buttonModelApp.setButtonListener(new JokerKeyButtonListener());
            }
        }
    }

    private class JokerKeyButtonListener
    extends DefaultButtonListener {
        private JokerKeyButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 600977: {
                    AbstractCharismaEcoComponent.this.logModelData("keyPressed", n, n2, true);
                    break;
                }
                default: {
                    AbstractCharismaEcoComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            if (600977 == n) {
                int n4 = AbstractCharismaEcoComponent.this.getChoiceModel(395).getValue();
                switch (n4) {
                    case 82: {
                        int n5 = AbstractCharismaEcoComponent.this.getChoiceModel(601716).getValue();
                        AbstractCharismaEcoComponent.this.dsiSetStartStop(0 == n5);
                        break;
                    }
                    default: {
                        AbstractCharismaEcoComponent.this.logModelData("keyReleased", n, n2, false);
                        break;
                    }
                }
            } else {
                AbstractCharismaEcoComponent.this.logModelData("keyReleased", n, n2, false);
            }
        }
    }
}


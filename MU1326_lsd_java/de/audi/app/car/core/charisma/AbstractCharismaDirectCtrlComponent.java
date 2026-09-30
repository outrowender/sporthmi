/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;

public abstract class AbstractCharismaDirectCtrlComponent
extends AbstractDSICarDrivingCharacteristicsAdapter {
    public static final short CODING_ID = 17;
    public static final String LOGCHANNEL_NAME = "App.Car.Charisma";
    public static final String DSI_LOGCHANNEL_NAME = "App.Car.Charisma.DSI";
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    private final LogChannel dsiLogChannel;
    private final LocalMsgListener msgListener;
    protected volatile CharismaViewOptions currentViewOptions;
    protected volatile boolean currentCharismaSoundState = false;

    public AbstractCharismaDirectCtrlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.dsiLogChannel = iCarApplication.getFrameworkAccess().getLogChannel(DSI_LOGCHANNEL_NAME);
        this.msgListener = new LocalMsgListener();
    }

    public LogChannel getLogChannelDSI() {
        return this.dsiLogChannel;
    }

    public String getName() {
        return "Charisma (direct control)";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{45})};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No charisma view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    protected void initModels() {
        this.getChoiceModel(602411).setChoiceListener(new ChoiceListener());
    }

    protected void deinitModels() {
        this.getChoiceModel(602411).resetListener();
    }

    protected abstract void updateMenuEntryVisibility(CharismaViewOptions var1);

    private synchronized void setExhaustFlap(boolean bl) {
        this.getLogChannel().log(1000000, "[AbstractCharismaDirectCtrlComponent#setExhaustFlap] active='%1'", (Object)(bl ? "true" : "false"));
        this.getLogChannelDSI().log(1000000, "dsi.setCharismaSound(%1)", (Object)(bl ? "true" : "false"));
        this.getDSI().setCharismaSound(bl);
    }

    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        this.getLogChannel().log(1000000, "[AbstractCharismaDirectCtrlComponent#updateCharismaViewOptions]: charismaViewOptions=%1, valid=%2", (Object)(charismaViewOptions != null ? this.formatViewOptionsLog(charismaViewOptions.toString()) : "null"), (long)n);
        if (1 == n && null != charismaViewOptions) {
            this.currentViewOptions = charismaViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateCharismaSound(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractCharismaDirectCtrlComponent#updateCharismaSound] state='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.currentCharismaSoundState = bl;
            this.getChoiceModel(602411).setValue(bl ? 1 : 0);
        }
    }

    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractCharismaDirectCtrlComponent.this.getLogChannel().log(1000000, "[AbstractCharismaDirectCtrlComponent#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
            switch (n) {
                case 602411: {
                    AbstractCharismaDirectCtrlComponent.this.setExhaustFlap(1 == n2);
                    break;
                }
                default: {
                    return;
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
            if (79 == n && 80 == AbstractCharismaDirectCtrlComponent.this.getChoiceModel(395).getValue() && null != (buttonModelApp = AbstractCharismaDirectCtrlComponent.this.getButtonModel(600977))) {
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
                    AbstractCharismaDirectCtrlComponent.this.logModelData("keyPressed", n, n2, true);
                    break;
                }
                default: {
                    AbstractCharismaDirectCtrlComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            if (600977 == n) {
                int n4 = AbstractCharismaDirectCtrlComponent.this.getChoiceModel(395).getValue();
                switch (n4) {
                    case 80: {
                        int n5 = AbstractCharismaDirectCtrlComponent.this.getChoiceModel(602411).getValue();
                        AbstractCharismaDirectCtrlComponent.this.setExhaustFlap(0 == n5);
                        break;
                    }
                    default: {
                        AbstractCharismaDirectCtrlComponent.this.logModelData("keyReleased", n, n2, false);
                        break;
                    }
                }
            } else {
                AbstractCharismaDirectCtrlComponent.this.logModelData("keyReleased", n, n2, false);
            }
        }
    }
}


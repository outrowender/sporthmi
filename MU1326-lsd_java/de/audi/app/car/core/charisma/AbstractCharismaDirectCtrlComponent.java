/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$ChoiceListener;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$LocalMsgListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;

public abstract class AbstractCharismaDirectCtrlComponent
extends AbstractDSICarDrivingCharacteristicsAdapter {
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    public static final String DSI_LOGCHANNEL_NAME;
    public static final int DISABLED;
    public static final int ENABLED;
    private final LogChannel dsiLogChannel;
    private final AbstractCharismaDirectCtrlComponent$LocalMsgListener msgListener;
    protected volatile CharismaViewOptions currentViewOptions;
    protected volatile boolean currentCharismaSoundState = false;

    public AbstractCharismaDirectCtrlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma");
        this.dsiLogChannel = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charisma.DSI");
        this.msgListener = new AbstractCharismaDirectCtrlComponent$LocalMsgListener(this, null);
    }

    public LogChannel getLogChannelDSI() {
        return this.dsiLogChannel;
    }

    @Override
    public String getName() {
        return "Charisma (direct control)";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{45})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No charisma view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    @Override
    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(724633856).setChoiceListener(new AbstractCharismaDirectCtrlComponent$ChoiceListener(this, null));
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(724633856).resetListener();
    }

    protected abstract void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions) {
    }

    private synchronized void setExhaustFlap(boolean bl) {
        this.getLogChannel().log(1078071040, "[AbstractCharismaDirectCtrlComponent#setExhaustFlap] active='%1'", (Object)(bl ? "true" : "false"));
        this.getLogChannelDSI().log(1078071040, "dsi.setCharismaSound(%1)", (Object)(bl ? "true" : "false"));
        this.getDSI().setCharismaSound(bl);
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        this.getLogChannel().log(1078071040, "[AbstractCharismaDirectCtrlComponent#updateCharismaViewOptions]: charismaViewOptions=%1, valid=%2", (Object)(charismaViewOptions != null ? this.formatViewOptionsLog(charismaViewOptions.toString()) : "null"), (long)n);
        if (1 == n && null != charismaViewOptions) {
            this.currentViewOptions = charismaViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateCharismaSound(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "[AbstractCharismaDirectCtrlComponent#updateCharismaSound] state='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.currentCharismaSoundState = bl;
            this.getChoiceModel(724633856).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    @Override
    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    static /* synthetic */ void access$000(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, boolean bl) {
        abstractCharismaDirectCtrlComponent.setExhaustFlap(bl);
    }

    static /* synthetic */ void access$100(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaDirectCtrlComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$200(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaDirectCtrlComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, int n) {
        return abstractCharismaDirectCtrlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$400(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, int n) {
        return abstractCharismaDirectCtrlComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$500(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaDirectCtrlComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$600(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaDirectCtrlComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$700(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, int n) {
        return abstractCharismaDirectCtrlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$800(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, int n) {
        return abstractCharismaDirectCtrlComponent.getButtonModel(n);
    }
}


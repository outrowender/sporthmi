/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tone.app.IGreyOutAndPopupHandler;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.audi.tone.app.volume.mapper.DummyVolumeMapper;
import de.audi.tone.app.volume.mapper.IVolumeMapper;
import de.audi.tone.app.volume.samples.ISamplePlayer;
import de.audi.tone.app.volume.samples.NullSamplePlayer;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractVolumeRange
implements RangeListener,
ChoiceListener,
IViewSizeListener {
    protected static final int DUMMY_MODEL_ID;
    protected static final int DEFAULT_TERMINAL;
    protected static final int[] NO_CONNECTIONS;
    protected final RangeModelApp model;
    final ChoiceModelApp focusModel;
    private final String label;
    private int connection = 0;
    protected boolean active = false;
    protected boolean focused = false;
    protected boolean enableOnOffToDDSMapping = true;
    protected boolean isSmallstage = false;
    protected VolumeRangeManager volMenuManager;
    protected final ToneEnv env;
    protected final IDSISoundHandler dsiSound;
    protected final AudioServiceHandler audioService;
    protected IGreyOutAndPopupHandler greyOutHandler;
    protected IVolumeMapper volumeMapper;

    protected abstract int[] getVolumeConnections() {
    }

    protected abstract String getName() {
    }

    protected abstract int getID() {
    }

    protected AbstractVolumeRange(VolumeRangeManager volumeRangeManager, int n, int n2, int n3) {
        this(volumeRangeManager, n, n2);
        this.setForegroundConnection(n3);
    }

    protected AbstractVolumeRange(VolumeRangeManager volumeRangeManager, int n, int n2) {
        this.volMenuManager = volumeRangeManager;
        this.env = volumeRangeManager.env;
        this.dsiSound = volumeRangeManager.dsiSound;
        this.audioService = volumeRangeManager.audioService;
        this.model = n == -1 ? new RangeModel(n) : this.env.getRangeModel(n);
        this.focusModel = n2 == -1 ? new ChoiceModel(n2) : this.env.getChoiceModel(n2);
        this.label = new Buffer(100).append('[').append(this.getName()).append("] [AbstractVolumeRange").toString();
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(new ChoiceModel(-1), new int[0], this.env.lcHMI, this.label);
        this.model.setRangeListener(this);
        this.focusModel.setChoiceListener(this);
        this.volumeMapper = new DummyVolumeMapper();
    }

    protected ISamplePlayer getSamplePlayer() {
        return NullSamplePlayer.getInstance();
    }

    protected void registerService(Object object) {
        this.env.lcMain.log(-2137614336, "%1.registerService] %2", (Object)this.label, object);
        try {
            this.getSamplePlayer().registerService(object);
        }
        catch (Exception exception) {
            this.env.lcMain.log(10000, "%1.registerService] Registering %2 failed!", (Object)this.label, object);
            this.env.lcMain.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    protected void deregisterService(Object object) {
        this.env.lcMain.log(-2137614336, "%1.deregisterService] %2", (Object)this.label, object);
        this.getSamplePlayer().deregisterService(object);
    }

    protected void init() {
        this.env.lcMain.log(-2137614336, "%1.init]", (Object)this.label);
        if (this.connection != 0) {
            this.dsiSound.getMenuVolumeRange(0, this.connection);
            this.dsiSound.getVolume(0, this.connection);
        }
    }

    protected final void setForegroundConnection(int n) {
        this.env.lcMain.log(-2137614336, "%1.setForegroundConnection() conn:%2", (Object)this.label, (long)n);
        this.connection = n;
    }

    protected final int getForegroundConnection() {
        return this.connection;
    }

    protected int getLimitsConnection() {
        return this.connection;
    }

    protected void setMedialPosition(int n) {
        if (n != this.model.getMedialPosition()) {
            this.env.lcDSI.log(-2137614336, "%1.setMedialPosition] pos:%2", (Object)this.label, (long)n);
            this.model.setMedialPosition(n);
        }
    }

    protected boolean enableOnOffDDSMapping() {
        return this.enableOnOffToDDSMapping;
    }

    protected void entered() {
        this.env.lcHMI.log(-2137614336, "%1.entered]", (Object)this.label);
        this.active = true;
        this.focused = true;
        this.setEnableOnOffToDDSMapping(true);
        this.greyOutHandler.updateActiveConnection(this.audioService.getActiveConnection(0), 0);
        this.requestMenuConnection();
    }

    protected void left() {
        this.env.lcHMI.log(-2137614336, "%1.left]", (Object)this.label);
        this.active = false;
        this.focused = false;
        this.releaseMenuConnection();
    }

    final boolean isVolumeConnection(int n) {
        int[] nArray = this.getVolumeConnections();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    void updateValue(int n) {
        int n2 = this.volumeMapper.mapVolume2Model(n);
        if (n2 == 128) {
            this.env.lcDSI.log(-2137614336, "%1.updateValue] value:%2 mapped:not found! Do not update model", (Object)this.label, (long)n);
            return;
        }
        this.env.lcDSI.log(-2137614336, "%1.updateValue] value:%2 mapped:%3", (Object)this.label, (long)n, (long)n2);
        this.model.setValue(n2);
    }

    protected void updateLimits(int n, int n2) {
        int n3 = this.volumeMapper.mapModelVolumeRangeMin(n);
        int n4 = this.volumeMapper.mapModelVolumeRangeMax(n2);
        if (n3 != this.model.getMinimum() || n4 != this.model.getMaximum()) {
            this.env.lcDSI.log(-2137614336, "%1.updateLimits] min:%2 max:%3", (Object)this.label, (long)n3, (long)n4);
            this.model.setLimits(n3, n4, 1);
        }
    }

    protected int getMin() {
        return this.volumeMapper.mapModel2Volume(this.model.getMinimum());
    }

    protected int getMax() {
        return this.volumeMapper.mapModel2Volume(this.model.getMaximum());
    }

    protected void audible(boolean bl) {
        this.env.lcMain.log(-2137614336, "%1.audible] audible:%2 active:%3", (Object)this.label, (Object)String.valueOf(bl), (Object)String.valueOf(this.active));
        if (bl) {
            if (this.active) {
                this.getSamplePlayer().play();
            }
        } else {
            this.getSamplePlayer().stop();
        }
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "%1.decrement] steps:%2 HT:%3", (Object)this.label, (long)n2, (long)n3);
        this.decrease(n3, n2);
    }

    public void decrease(int n, int n2) {
        int n3 = this.model.getValue();
        int n4 = -this.volumeMapper.mapModel2Volume(n3, -n2);
        this.dsiSound.decreaseVolume(n, 2, n4);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "%1.increment] steps:%2 HT:%3", (Object)this.label, (long)n2, (long)n3);
        this.increase(n3, n2);
    }

    public void increase(int n, int n2) {
        int n3 = this.model.getValue();
        int n4 = this.volumeMapper.mapModel2Volume(n3, n2);
        this.dsiSound.increaseVolume(n, 2, n4);
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.greyOutHandler.updateActiveEntertainmentConnection(n, n2);
    }

    public void updateActiveConnection(int n, int n2) {
        this.greyOutHandler.updateActiveConnection(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "%1.keyTyped] model:%2 HT:%3", (Object)this.label, (long)n, (long)n3);
        this.model.fireEvent(n3);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public final void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public final void keyReleased(int n, int n2, int n3) {
    }

    protected void setEnableOnOffToDDSMapping(boolean bl) {
        this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.setEnableOnOffToDDSMapping] [%2] enable:%1", bl, (Object)this.label);
        this.enableOnOffToDDSMapping = bl;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] modelID:%1, itemID:%2", (long)n, (long)n2);
        if (n == this.focusModel.getID() && this.active) {
            this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] active:%1, already focused:%2", this.active, this.focused);
            if (DrawerFocusUtil.isFocusGained(n2)) {
                if (DrawerFocusUtil.isMainArea(n2) && this.focused) {
                    this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] already focused - return");
                    return;
                }
                if (this.greyOutHandler.getGreyOutState() == 1) {
                    this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] announcement still active - return");
                    return;
                }
                this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] [%1], focus gained ", (Object)this.label);
                this.focused = true;
                if (this.isSmallstage) {
                    this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected]  isSmallStage:%1 ", this.isSmallstage);
                } else {
                    this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] [%1], focus gained and big Stage", (Object)this.label);
                    this.setEnableOnOffToDDSMapping(true);
                    this.greyOutHandler.updateActiveConnection(this.audioService.getActiveConnection(0), 0);
                    this.requestMenuConnection();
                    this.volMenuManager.menuDrawerFocused(this.getID());
                }
            } else if (DrawerFocusUtil.isFocusLost(n2)) {
                if (DrawerFocusUtil.isReasonReInit(n2)) {
                    this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] partial popup, ignored drawerstate:%1", (long)n2);
                    return;
                }
                this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] [%1], focus lost", (Object)this.label);
                this.focused = false;
                this.setEnableOnOffToDDSMapping(false);
                this.releaseMenuConnection();
                this.volMenuManager.menuDrawerUnfocused(this.getID());
            } else {
                this.env.lcHMI.log(-2137614336, "[AbstractVolumeRange.itemSelected] ignore drawerstate:%1", (long)n2);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void viewSizeChanged(int n) {
        this.env.lcHMI.log(-2137614336, "%1.viewSizeChanged] called", (Object)this.label);
        if (this.active) {
            if (n == 1) {
                this.env.lcHMI.log(-2137614336, "%1.viewSizeChanged] newViewSize:%2, small stage", (Object)this.label, (long)n);
                this.isSmallstage = true;
                this.setEnableOnOffToDDSMapping(false);
                this.releaseMenuConnection();
                this.volMenuManager.menuDrawerUnfocused(this.getID());
            } else {
                this.isSmallstage = false;
                if (this.focused) {
                    this.setEnableOnOffToDDSMapping(true);
                    this.greyOutHandler.updateActiveConnection(this.audioService.getActiveConnection(0), 0);
                    this.env.lcHMI.log(-2137614336, "%1.viewSizeChanged] newViewSize:%2, big stage", (Object)this.label, (long)n);
                    this.requestMenuConnection();
                    this.volMenuManager.menuDrawerFocused(this.getID());
                }
            }
        }
    }

    public final String getDebugState() {
        return new Buffer(500).append(this.label).append('\n').append("value = ").append(this.model.getValue()).append('\n').append("limits = ").append(this.model.getMinimum()).append('/').append(this.model.getMaximum()).append('\n').append("medial pos = ").append(this.model.getMedialPosition()).append('\n').append("active = ").append(this.active).append('\n').toString();
    }

    public String toString() {
        return new Buffer(100).append(this.getName()).append(" (id:").append(this.getID()).append(", active:").append(this.active).toString();
    }

    protected void limitVolumeToHmiLimits() {
        short s = (short)this.model.getValue();
        if (s == this.model.getMinimum() || s == this.model.getMaximum()) {
            int n = this.volumeMapper.mapModel2Volume(s);
            this.dsiSound.setVolume(0, this.connection, n);
        }
    }

    protected void requestMenuConnection() {
        if (this.connection != 0) {
            this.limitVolumeToHmiLimits();
            this.audioService.requestAndFadeToConnection(0, this.connection);
        } else {
            this.env.lcMain.log(-2137614336, "%1.requestMenuConnection] connection:%2 not requested", (Object)this.label, (long)this.connection);
        }
    }

    protected void releaseMenuConnection() {
        if (this.connection != 0) {
            this.audioService.releaseConnection(0, this.connection);
        } else {
            this.env.lcMain.log(-2137614336, "%1.releaseMenuConnection] connection:%2 undefined", (Object)this.label, (long)this.connection);
        }
    }

    protected static int[] merge(int[] nArray, int n) {
        int[] nArray2 = new int[nArray.length + 1];
        AbstractVolumeRange.copy(nArray, nArray2, 0);
        nArray2[nArray2.length - 1] = n;
        return nArray2;
    }

    protected static int[] merge(int[] nArray, int[] nArray2) {
        int[] nArray3 = new int[nArray.length + nArray2.length];
        int n = 0;
        n = AbstractVolumeRange.copy(nArray, nArray3, n);
        n = AbstractVolumeRange.copy(nArray2, nArray3, n);
        return nArray3;
    }

    private static int copy(int[] nArray, int[] nArray2, int n) {
        System.arraycopy((Object)nArray, 0, (Object)nArray2, n, nArray.length);
        return n + nArray.length;
    }

    protected void setVolumeMapper(IVolumeMapper iVolumeMapper) {
        this.volumeMapper = iVolumeMapper;
    }

    static {
        NO_CONNECTIONS = new int[0];
    }
}


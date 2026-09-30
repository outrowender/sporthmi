/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tone.app.IGreyOutAndPopupHandler;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.greyout.DefaultGreyOutAndPopupHandler;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractSoundRange
implements RangeListener {
    private static final int STEPS = 1;
    private static final Timer MEDIAL_POS_LOCK_TIMER = new Timer("MedialPosLockTimer", 400L, true, new MedialPositionTimerListener());
    protected final IDSISoundHandler dsiSound;
    protected final RangeModelApp model;
    final int hmiTerminal;
    private final boolean haltAtMedialPosition;
    protected final int[] greyOutConnections = AudioConnection.GREY_OUT_ALL;
    protected IGreyOutAndPopupHandler greyOutHandler;
    protected boolean isSmallStage;
    protected boolean menuHiddenOrUnfocused;
    private boolean limitsSet = false;
    protected final ToneEnv env;

    abstract void changeBy(int var1);

    protected AbstractSoundRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n, int n2, boolean bl) {
        this.env = toneEnv;
        this.dsiSound = iDSISoundHandler;
        this.model = toneEnv.getRangeModel(n2, n);
        this.haltAtMedialPosition = bl;
        this.hmiTerminal = n2;
        this.model.setRangeListener(this);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(new ChoiceModel(-1), new int[0], toneEnv.lcHMI, "AbstractSoundRange");
    }

    protected AbstractSoundRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n, int n2, int n3, boolean bl) {
        this(iDSISoundHandler, toneEnv, n, n3, bl);
        ChoiceModelApp choiceModelApp = toneEnv.getChoiceModel(n2);
        this.greyOutHandler = new DefaultGreyOutAndPopupHandler(choiceModelApp, this.greyOutConnections, toneEnv.lcHMI, "AbstractSoundRange");
    }

    protected void updateValue(int n) {
        if (!this.limitsSet) {
            this.model.setLimits(n - 1, n + 1, 1);
        }
        this.model.setValue(n);
    }

    protected void updateValue(int n, int n2) {
    }

    void updateLimits(int n, int n2) {
        this.limitsSet = true;
        int n3 = (n + n2) / 2;
        this.model.setLimits(n, n2, 1, n3);
    }

    public final void increment(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[AbstractSoundRange.increment] steps:%1 model:%2 HT:%3", (long)n2, (long)n, (long)n3);
        this.callChangeBy(n2);
    }

    public final void decrement(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[AbstractSoundRange.decrement] steps:%1 model:%2 HT:%3", (long)n2, (long)n, (long)n3);
        this.callChangeBy(-n2);
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.greyOutHandler.updateActiveEntertainmentConnection(n, n2);
    }

    public void updateActiveConnection(int n, int n2) {
        this.greyOutHandler.updateActiveConnection(n, n2);
    }

    private void callChangeBy(int n) {
        if (MEDIAL_POS_LOCK_TIMER.isRunning()) {
            this.env.lcMain.log(100000000, "[AbstractSoundRange.callChangeBy] Freeze on medial position.");
            return;
        }
        if (!this.haltAtMedialPosition) {
            this.changeBy(n);
            return;
        }
        int n2 = this.model.getMedialPosition();
        int n3 = this.model.getValue();
        int n4 = n3 + n;
        boolean bl = n3 > n2 && n4 <= n2;
        boolean bl2 = n3 < n2 && n4 >= n2;
        int n5 = n;
        if (bl || bl2) {
            MEDIAL_POS_LOCK_TIMER.restart();
            n5 = n2 - n3;
            this.env.lcMain.log(100000000, "[AbstractSoundRange.callChangeBy] steps:%1 Freeze on medial position.", (long)n);
        }
        this.changeBy(n5);
    }

    public final void keyTyped(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[AbstractSoundRange.keyTyped] model:%1 terminal:%2", (long)n, (long)n3);
        this.model.fireEvent(n3);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public final String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.toString());
        buffer.append(" model:").append(this.model.getID());
        buffer.append(" terminal:").append(this.model.getTerminalID());
        buffer.append(" value:").append(this.model.getValue());
        buffer.append(" min:").append(this.model.getMinimum());
        buffer.append(" max:").append(this.model.getMaximum());
        return buffer.toString();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    private static class MedialPositionTimerListener
    implements TimerListener {
        private MedialPositionTimerListener() {
        }

        public void cancelTimer(Timer timer) {
        }

        public void fireTimer(Timer timer) {
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;
import de.audi.tone.app.sound.BalanceFader;
import de.audi.tone.app.sound.BalanceRange;
import de.audi.tone.app.sound.BassRange;
import de.audi.tone.app.sound.FaderRange;
import de.audi.tone.app.sound.NoiseCompensation;
import de.audi.tone.app.sound.SubwooferRange;
import de.audi.tone.app.sound.SurroundRange;
import de.audi.tone.app.sound.TrebleRange;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class SoundHandler {
    private static final int MAIN = 0;
    private static final int RSE_LEFT = 3;
    private static final int RSE_RIGHT = 4;
    private final ToneEnv env;
    private final SimpleIntObjectMap map = new SimpleIntObjectMap(20);
    public final ActionProxyListener actionProxyListener = new ActionProxyListenerExt();

    public SoundHandler(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv) {
        this.env = toneEnv;
        if (toneEnv.isFrontUnit()) {
            this.createSoundRanges(0, iDSISoundHandler);
        } else {
            this.createSoundRanges(3, iDSISoundHandler);
            this.createSoundRanges(4, iDSISoundHandler);
        }
    }

    public void updateValue(int n, int n2, int n3) {
        AbstractSoundRange abstractSoundRange = (AbstractSoundRange)this.map.get(this.getKey(n, n2));
        BalanceFader balanceFader = (BalanceFader)this.map.get(this.getKey(1000037, n2));
        if (abstractSoundRange != null && balanceFader != null) {
            abstractSoundRange.updateValue(n3);
            if (n == 1000036) {
                balanceFader.updateBalance(n3);
            } else if (n == 1000043) {
                balanceFader.updateFader(n3);
            }
        }
    }

    public void updateChoiceValue(int n, int n2, int n3) {
        AbstractSoundRange abstractSoundRange = (AbstractSoundRange)this.map.get(this.getKey(n, n2));
        if (abstractSoundRange != null) {
            abstractSoundRange.updateValue(n, n3);
        }
    }

    public void updateLimits(int n, int n2, int n3) {
        if (this.env.isFrontUnit()) {
            this.updateLimits(0, n, n2, n3);
        } else {
            this.updateLimits(3, n, n2, n3);
            this.updateLimits(4, n, n2, n3);
        }
    }

    public BalanceFader getBalanceFader(int n) {
        return (BalanceFader)this.map.get(this.getKey(1000037, n));
    }

    private void createSoundRanges(int n, IDSISoundHandler iDSISoundHandler) {
        BalanceFader balanceFader = new BalanceFader(this.env, iDSISoundHandler, n);
        this.map.add(this.getKey(1000036, n), new BalanceRange(iDSISoundHandler, this.env, balanceFader, n));
        this.map.add(this.getKey(1000043, n), new FaderRange(iDSISoundHandler, this.env, balanceFader, n));
        this.map.add(this.getKey(1000037, n), balanceFader);
        this.map.add(this.getKey(1000015, n), new SubwooferRange(iDSISoundHandler, this.env, n));
        SurroundRange surroundRange = new SurroundRange(iDSISoundHandler, this.env, n);
        this.map.add(this.getKey(1000040, n), surroundRange);
        this.map.add(this.getKey(1000116, n), surroundRange);
        this.map.add(this.getKey(1000039, n), new NoiseCompensation(iDSISoundHandler, this.env, n));
        this.map.add(this.getKey(1000038, n), new BassRange(iDSISoundHandler, this.env, n));
        this.map.add(this.getKey(1000018, n), new TrebleRange(iDSISoundHandler, this.env, n));
    }

    private void updateLimits(int n, int n2, int n3, int n4) {
        AbstractSoundRange abstractSoundRange = (AbstractSoundRange)this.map.get(this.getKey(n2, n));
        abstractSoundRange.updateLimits(n3, n4);
        if (n2 == 1000036) {
            this.getBalanceFader(n).updateBalanceLimits(n3, n4);
        } else if (n2 == 1000043) {
            this.getBalanceFader(n).updateFaderLimits(n3, n4);
        }
    }

    private int getKey(int n, int n2) {
        return n * 100 + n2;
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        Object[] objectArray = this.map.getValues();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (!(objectArray[i2] instanceof AbstractSoundRange)) continue;
            ((AbstractSoundRange)objectArray[i2]).updateActiveEntertainmentConnection(n, n2);
        }
    }

    public void updateActiveConnection(int n, int n2) {
        Object[] objectArray = this.map.getValues();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (!(objectArray[i2] instanceof AbstractSoundRange)) continue;
            ((AbstractSoundRange)objectArray[i2]).updateActiveConnection(n, n2);
        }
    }

    private class ActionProxyListenerExt
    extends ActionProxyListener {
        ActionProxyListenerExt() {
            super(0);
        }

        public void balanceFaderLeft() {
            SoundHandler.this.getBalanceFader(this.terminalID).setActiveStatus(0);
            if (SoundHandler.this.env.isPorsche()) {
                SoundHandler.this.getBalanceFader(this.terminalID).writeBackModelValue();
            }
        }

        public void balanceFaderEntered() {
            if (SoundHandler.this.env.isPorsche()) {
                SoundHandler.this.getBalanceFader(this.terminalID).writeBackModelValue();
            }
        }
    }
}


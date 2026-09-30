/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.RangeListener2D;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.tone.app.ToneDefaultListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ToneTools;
import de.audi.tone.app.dsi.IDSISoundHandler;

public class BalanceFader
extends ToneDefaultListener
implements RangeListener2D {
    public static final int STATUS_NONE_ACTIVE = 0;
    static final int STATUS_BALANCE_ACTIVE = 1;
    static final int STATUS_FADER_ACTIVE = 2;
    static final int MODEL = 1000037;
    private volatile int tempBalanceValue;
    private volatile int tempFaderValue;
    private final IDSISoundHandler dsiSound;
    private final RangeModel2DApp model;
    private final ToneEnv env;

    BalanceFader(ToneEnv toneEnv, IDSISoundHandler iDSISoundHandler, int n) {
        this.env = toneEnv;
        this.dsiSound = iDSISoundHandler;
        this.model = toneEnv.getRangeModel2D(n, 1000037);
        this.model.setRangeListener(this);
        this.setActiveStatus(0);
    }

    void updateBalanceLimits(int n, int n2) {
        if (this.getBalanceMin() != n || this.getBalanceMax() != n2) {
            int n3 = ToneTools.calculateMedialPosition(n, n2);
            this.model.setLimitsX(n, n2, 1, n3);
        }
    }

    void updateFaderLimits(int n, int n2) {
        if (this.getFaderMin() != n || this.getFaderMax() != n2) {
            int n3 = ToneTools.calculateMedialPosition(n, n2);
            this.model.setLimitsY(n, n2, 1, n3);
        }
    }

    void updateBalance(int n) {
        if (this.env.getSysConst(4542) == 1) {
            this.env.lcHMI.log(10000000, "[BalanceFader.updateBalance] In Porsche widget is updating itself. balance: %1", (long)n);
            this.tempBalanceValue = n;
        } else {
            int n2 = this.normalize(n, this.getBalanceMin(), this.getBalanceMax());
            this.model.setValue(n2, this.getFader());
        }
        this.env.getChoiceModel(1000047).setValue(n);
    }

    void updateFader(int n) {
        if (this.env.getSysConst(4542) == 1) {
            this.env.lcHMI.log(10000000, "[BalanceFader.updateFader] In Porsche widget is updating itself. fader :%1", (long)n);
            this.tempFaderValue = n;
        } else {
            int n2 = this.normalize(n, this.getFaderMin(), this.getFaderMax());
            this.model.setValue(this.getBalance(), n2);
        }
        this.env.getChoiceModel(1000049).setValue(n);
    }

    public void setValueHit(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(10000000, "[BalanceFader.setValueHit] x/balance:%1 y/fader:%2", (long)n2, (long)n3);
        if (n2 != 0) {
            this.dsiSound.changeBalance(n4, n2);
        }
        if (n3 != 0) {
            this.dsiSound.changeFader(n4, n3);
        }
    }

    public final void setActiveStatus(int n) {
        this.model.setStatus(n);
    }

    public final void writeBackModelValue() {
        int n = this.normalize(this.tempBalanceValue, this.getBalanceMin(), this.getBalanceMax());
        int n2 = this.normalize(this.tempFaderValue, this.getFaderMin(), this.getFaderMax());
        this.env.lcHMI.log(10000000, "[BalanceFader.writeBackModelValue] x/balance:%1 y/fader:%2", (long)n, (long)n2);
        this.model.setValue(n, n2);
    }

    private int getBalance() {
        return this.model.getValueX();
    }

    private int getBalanceMin() {
        return this.model.getMinimumX();
    }

    private int getBalanceMax() {
        return this.model.getMaximumX();
    }

    private int getFader() {
        return this.model.getValueY();
    }

    private int getFaderMin() {
        return this.model.getMinimumY();
    }

    private int getFaderMax() {
        return this.model.getMaximumY();
    }

    private int normalize(int n, int n2, int n3) {
        int n4 = n;
        if (n < n2) {
            this.env.lcMain.log(1000000, "[BalanceFader.normalize] value:%2 < min:%3 (%1)", (Object)this.model, (long)n, (long)n2);
            n4 = n2;
        } else if (n > n3) {
            this.env.lcMain.log(1000000, "[BalanceFader.normalize] value:%2 > max:%3 (%1)", (Object)this.model, (long)n, (long)n3);
            n4 = n3;
        }
        return n4;
    }
}


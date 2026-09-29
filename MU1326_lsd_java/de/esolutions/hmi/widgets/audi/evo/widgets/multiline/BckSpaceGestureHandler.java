/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.tghu.hmi.evo.BckSpaceGestureHandlerConfig;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FastDeleteHelper;

public class BckSpaceGestureHandler {
    private FastDeleteHelper fastDeleteHelper;
    private int numCharsToDelete;
    private int deleteSpeed;
    private int numCharsInWord;
    private int charsDeleted;
    private int wordsDeleted;
    private int minDeltaTime;
    private float factor;
    private int m_kbdType;
    private BckSpaceGestureHandlerConfig cfg;
    private float[] fCfg;
    private int[] iCfg;

    private void updateConfig() {
        if (this.cfg != null) {
            this.iCfg = this.cfg.getConfigInts(this.m_kbdType, this.iCfg);
            this.fCfg = this.cfg.getConfigFloats(this.m_kbdType, this.fCfg);
        }
    }

    public BckSpaceGestureHandler(int n, FastDeleteHelper fastDeleteHelper) {
        this.m_kbdType = n > -1 && n < 3 ? n : 1;
        this.fastDeleteHelper = fastDeleteHelper;
        this.cfg = BckSpaceGestureHandlerConfig.getInstance();
        this.fCfg = new float[BckSpaceGestureHandlerConfig.INT_DEFAULT_CONFIG.length];
        this.iCfg = new int[BckSpaceGestureHandlerConfig.FLOAT_DEFAULT_CONFIG.length];
        if (this.cfg == null) {
            System.arraycopy(BckSpaceGestureHandlerConfig.INT_DEFAULT_CONFIG, 0, (Object)this.iCfg, 0, this.iCfg.length);
            System.arraycopy(BckSpaceGestureHandlerConfig.FLOAT_DEFAULT_CONFIG, 0, (Object)this.fCfg, 0, this.fCfg.length);
        }
    }

    private void updateDeleteSpeed(int n) {
        if (n == 0 || n > this.iCfg[0]) {
            this.minDeltaTime = 0;
            this.deleteSpeed = 1;
        } else if (this.minDeltaTime == 0) {
            this.minDeltaTime = n;
        } else {
            if (n < this.minDeltaTime) {
                this.minDeltaTime = n;
            }
            this.factor = (float)n / (float)this.minDeltaTime;
            if (this.factor <= this.fCfg[0] && this.minDeltaTime <= this.iCfg[1]) {
                ++this.deleteSpeed;
                if (this.deleteSpeed > this.iCfg[3]) {
                    this.deleteSpeed = this.iCfg[3];
                }
            } else if (this.factor >= this.fCfg[2]) {
                this.deleteSpeed = 1;
            } else if (this.factor >= this.fCfg[1]) {
                this.deleteSpeed -= this.iCfg[2];
                if (this.deleteSpeed < 1) {
                    this.deleteSpeed = 1;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void backspaceGesture(int n) {
        block8: {
            try {
                this.updateConfig();
                if (this.fastDeleteHelper.lock()) {
                    this.updateDeleteSpeed(n);
                    if (this.fastDeleteHelper.isEditMode()) {
                        this.numCharsToDelete = this.deleteSpeed;
                        this.numCharsInWord = this.fastDeleteHelper.getWordLength();
                        if (this.numCharsToDelete > this.numCharsInWord || (float)this.deleteSpeed * this.fCfg[3] + this.fCfg[4] >= (float)this.numCharsInWord) {
                            this.numCharsToDelete = this.numCharsInWord;
                        }
                        for (int i2 = 0; i2 < this.numCharsToDelete; ++i2) {
                            if (!this.fastDeleteHelper.deleteOneChar()) continue;
                            break block8;
                        }
                        break block8;
                    }
                    this.numCharsToDelete = this.deleteSpeed * this.iCfg[4];
                    this.charsDeleted = 0;
                    this.wordsDeleted = 0;
                    while (this.charsDeleted + this.wordsDeleted < this.numCharsToDelete) {
                        int n2 = this.fastDeleteHelper.getTextLength();
                        this.fastDeleteHelper.deleteWordIncludingPrecedingWhitespaces();
                        this.charsDeleted = this.charsDeleted + n2 - this.fastDeleteHelper.getTextLength();
                        ++this.wordsDeleted;
                    }
                    break block8;
                }
                IWidgetLogChannel.tpLogChannelKeypanel.log(-2137614336, "BckSpaceGestureHandler#BackspaceGesture lock could not acquire");
            }
            finally {
                this.fastDeleteHelper.unlock();
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$1;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$10;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$11;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$12;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$13;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$14;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$15;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$16;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$2;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$3;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$4;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$5;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$6;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$7;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$8;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank$9;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenFactory;

public class EcallConditionBank
implements HMIConditionBank {
    private EcallScreenFactory screenFactory;

    public EcallConditionBank(EcallScreenFactory ecallScreenFactory) {
        this.screenFactory = ecallScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 3300000: {
                return new EcallConditionBank$1(this);
            }
            case 3300001: {
                return new EcallConditionBank$2(this);
            }
            case 3300002: {
                return new EcallConditionBank$3(this);
            }
            case 3300003: {
                return new EcallConditionBank$4(this);
            }
            case 3300004: {
                return new EcallConditionBank$5(this);
            }
            case 3300005: {
                return new EcallConditionBank$6(this);
            }
            case 3300006: {
                return new EcallConditionBank$7(this);
            }
            case 3300007: {
                return new EcallConditionBank$8(this);
            }
            case 3300008: {
                return new EcallConditionBank$9(this);
            }
            case 3300009: {
                return new EcallConditionBank$10(this);
            }
            case 3300010: {
                return new EcallConditionBank$11(this);
            }
            case 3300011: {
                return new EcallConditionBank$12(this);
            }
            case 3300012: {
                return new EcallConditionBank$13(this);
            }
            case 3300013: {
                return new EcallConditionBank$14(this);
            }
            case 3300014: {
                return new EcallConditionBank$15(this);
            }
            case 3300015: {
                return new EcallConditionBank$16(this);
            }
        }
        return null;
    }

    static /* synthetic */ EcallScreenFactory access$000(EcallConditionBank ecallConditionBank) {
        return ecallConditionBank.screenFactory;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$1;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$10;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$11;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$12;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$13;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$14;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$15;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$16;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$17;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$18;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$19;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$2;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$20;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$21;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$22;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$3;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$4;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$5;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$6;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$7;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$8;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank$9;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenFactory;

public class EngineeringConditionBank
implements HMIConditionBank {
    private EngineeringScreenFactory screenFactory;

    public EngineeringConditionBank(EngineeringScreenFactory engineeringScreenFactory) {
        this.screenFactory = engineeringScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1300009: {
                return new EngineeringConditionBank$1(this);
            }
            case 1300010: {
                return new EngineeringConditionBank$2(this);
            }
            case 1300011: {
                return new EngineeringConditionBank$3(this);
            }
            case 1300012: {
                return new EngineeringConditionBank$4(this);
            }
            case 1300013: {
                return new EngineeringConditionBank$5(this);
            }
            case 1300014: {
                return new EngineeringConditionBank$6(this);
            }
            case 1300015: {
                return new EngineeringConditionBank$7(this);
            }
            case 1300016: {
                return new EngineeringConditionBank$8(this);
            }
            case 1300017: {
                return new EngineeringConditionBank$9(this);
            }
            case 1300018: {
                return new EngineeringConditionBank$10(this);
            }
            case 1300019: {
                return new EngineeringConditionBank$11(this);
            }
            case 1300020: {
                return new EngineeringConditionBank$12(this);
            }
            case 1300021: {
                return new EngineeringConditionBank$13(this);
            }
            case 1300022: {
                return new EngineeringConditionBank$14(this);
            }
            case 1300023: {
                return new EngineeringConditionBank$15(this);
            }
            case 1300024: {
                return new EngineeringConditionBank$16(this);
            }
            case 1300025: {
                return new EngineeringConditionBank$17(this);
            }
            case 1300026: {
                return new EngineeringConditionBank$18(this);
            }
            case 1300027: {
                return new EngineeringConditionBank$19(this);
            }
            case 1300028: {
                return new EngineeringConditionBank$20(this);
            }
            case 1300030: {
                return new EngineeringConditionBank$21(this);
            }
            case 1300031: {
                return new EngineeringConditionBank$22(this);
            }
        }
        return null;
    }

    static /* synthetic */ EngineeringScreenFactory access$000(EngineeringConditionBank engineeringConditionBank) {
        return engineeringConditionBank.screenFactory;
    }
}


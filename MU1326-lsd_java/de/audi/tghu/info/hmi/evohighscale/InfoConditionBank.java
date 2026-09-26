/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$1;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$10;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$11;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$12;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$13;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$14;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$15;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$16;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$17;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$18;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$19;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$2;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$20;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$21;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$22;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$23;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$24;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$25;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$26;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$27;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$28;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$29;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$3;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$30;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$31;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$32;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$33;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$34;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$35;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$36;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$37;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$38;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$39;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$4;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$40;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$41;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$42;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$43;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$44;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$45;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$46;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$47;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$48;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$49;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$5;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$50;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$51;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$52;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$53;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$54;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$55;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$56;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$57;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$58;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$59;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$6;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$60;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$61;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$62;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$63;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$64;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$65;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$66;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$67;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$7;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$8;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank$9;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenFactory;

public class InfoConditionBank
implements HMIConditionBank {
    private InfoScreenFactory screenFactory;

    public InfoConditionBank(InfoScreenFactory infoScreenFactory) {
        this.screenFactory = infoScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 500003: {
                return new InfoConditionBank$1(this);
            }
            case 500006: {
                return new InfoConditionBank$2(this);
            }
            case 500007: {
                return new InfoConditionBank$3(this);
            }
            case 500008: {
                return new InfoConditionBank$4(this);
            }
            case 500009: {
                return new InfoConditionBank$5(this);
            }
            case 500012: {
                return new InfoConditionBank$6(this);
            }
            case 500013: {
                return new InfoConditionBank$7(this);
            }
            case 500016: {
                return new InfoConditionBank$8(this);
            }
            case 500017: {
                return new InfoConditionBank$9(this);
            }
            case 500019: {
                return new InfoConditionBank$10(this);
            }
            case 500020: {
                return new InfoConditionBank$11(this);
            }
            case 500021: {
                return new InfoConditionBank$12(this);
            }
            case 500022: {
                return new InfoConditionBank$13(this);
            }
            case 500025: {
                return new InfoConditionBank$14(this);
            }
            case 500026: {
                return new InfoConditionBank$15(this);
            }
            case 500027: {
                return new InfoConditionBank$16(this);
            }
            case 500028: {
                return new InfoConditionBank$17(this);
            }
            case 500029: {
                return new InfoConditionBank$18(this);
            }
            case 500030: {
                return new InfoConditionBank$19(this);
            }
            case 500031: {
                return new InfoConditionBank$20(this);
            }
            case 500032: {
                return new InfoConditionBank$21(this);
            }
            case 500035: {
                return new InfoConditionBank$22(this);
            }
            case 500036: {
                return new InfoConditionBank$23(this);
            }
            case 500037: {
                return new InfoConditionBank$24(this);
            }
            case 500038: {
                return new InfoConditionBank$25(this);
            }
            case 500039: {
                return new InfoConditionBank$26(this);
            }
            case 500041: {
                return new InfoConditionBank$27(this);
            }
            case 500042: {
                return new InfoConditionBank$28(this);
            }
            case 500045: {
                return new InfoConditionBank$29(this);
            }
            case 500046: {
                return new InfoConditionBank$30(this);
            }
            case 500047: {
                return new InfoConditionBank$31(this);
            }
            case 500048: {
                return new InfoConditionBank$32(this);
            }
            case 500049: {
                return new InfoConditionBank$33(this);
            }
            case 500051: {
                return new InfoConditionBank$34(this);
            }
            case 500052: {
                return new InfoConditionBank$35(this);
            }
            case 500055: {
                return new InfoConditionBank$36(this);
            }
            case 500056: {
                return new InfoConditionBank$37(this);
            }
            case 500057: {
                return new InfoConditionBank$38(this);
            }
            case 500058: {
                return new InfoConditionBank$39(this);
            }
            case 500059: {
                return new InfoConditionBank$40(this);
            }
            case 500060: {
                return new InfoConditionBank$41(this);
            }
            case 500061: {
                return new InfoConditionBank$42(this);
            }
            case 500062: {
                return new InfoConditionBank$43(this);
            }
            case 500063: {
                return new InfoConditionBank$44(this);
            }
            case 500064: {
                return new InfoConditionBank$45(this);
            }
            case 500065: {
                return new InfoConditionBank$46(this);
            }
            case 500066: {
                return new InfoConditionBank$47(this);
            }
            case 500067: {
                return new InfoConditionBank$48(this);
            }
            case 500068: {
                return new InfoConditionBank$49(this);
            }
            case 500069: {
                return new InfoConditionBank$50(this);
            }
            case 500070: {
                return new InfoConditionBank$51(this);
            }
            case 500071: {
                return new InfoConditionBank$52(this);
            }
            case 500072: {
                return new InfoConditionBank$53(this);
            }
            case 500073: {
                return new InfoConditionBank$54(this);
            }
            case 500074: {
                return new InfoConditionBank$55(this);
            }
            case 500075: {
                return new InfoConditionBank$56(this);
            }
            case 500076: {
                return new InfoConditionBank$57(this);
            }
            case 500077: {
                return new InfoConditionBank$58(this);
            }
            case 500078: {
                return new InfoConditionBank$59(this);
            }
            case 500079: {
                return new InfoConditionBank$60(this);
            }
            case 500080: {
                return new InfoConditionBank$61(this);
            }
            case 500085: {
                return new InfoConditionBank$62(this);
            }
            case 500086: {
                return new InfoConditionBank$63(this);
            }
            case 500087: {
                return new InfoConditionBank$64(this);
            }
            case 500088: {
                return new InfoConditionBank$65(this);
            }
            case 500089: {
                return new InfoConditionBank$66(this);
            }
            case 500090: {
                return new InfoConditionBank$67(this);
            }
        }
        return null;
    }

    static /* synthetic */ InfoScreenFactory access$000(InfoConditionBank infoConditionBank) {
        return infoConditionBank.screenFactory;
    }
}


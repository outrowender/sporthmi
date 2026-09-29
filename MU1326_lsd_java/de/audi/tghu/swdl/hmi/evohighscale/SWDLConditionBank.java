/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$1;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$10;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$11;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$12;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$13;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$14;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$15;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$16;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$17;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$18;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$19;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$2;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$20;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$21;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$22;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$23;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$24;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$25;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$26;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$27;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$28;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$29;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$3;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$30;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$31;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$32;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$33;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$34;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$35;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$36;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$37;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$38;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$39;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$4;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$40;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$41;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$42;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$43;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$44;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$45;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$46;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$47;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$48;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$49;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$5;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$50;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$51;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$52;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$53;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$54;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$55;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$56;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$57;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$58;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$59;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$6;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$60;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$61;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$62;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$63;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$64;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$65;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$66;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$67;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$68;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$69;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$7;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$70;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$71;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$72;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$73;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$74;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$75;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$76;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$77;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$78;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$79;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$8;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$80;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$81;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank$9;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;

public class SWDLConditionBank
implements HMIConditionBank {
    private SWDLScreenFactory screenFactory;

    public SWDLConditionBank(SWDLScreenFactory sWDLScreenFactory) {
        this.screenFactory = sWDLScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1700000: {
                return new SWDLConditionBank$1(this);
            }
            case 1700001: {
                return new SWDLConditionBank$2(this);
            }
            case 1700002: {
                return new SWDLConditionBank$3(this);
            }
            case 1700003: {
                return new SWDLConditionBank$4(this);
            }
            case 1700004: {
                return new SWDLConditionBank$5(this);
            }
            case 1700005: {
                return new SWDLConditionBank$6(this);
            }
            case 1700006: {
                return new SWDLConditionBank$7(this);
            }
            case 1700007: {
                return new SWDLConditionBank$8(this);
            }
            case 1700009: {
                return new SWDLConditionBank$9(this);
            }
            case 1700017: {
                return new SWDLConditionBank$10(this);
            }
            case 1700018: {
                return new SWDLConditionBank$11(this);
            }
            case 1700019: {
                return new SWDLConditionBank$12(this);
            }
            case 1700020: {
                return new SWDLConditionBank$13(this);
            }
            case 1700021: {
                return new SWDLConditionBank$14(this);
            }
            case 1700022: {
                return new SWDLConditionBank$15(this);
            }
            case 1700023: {
                return new SWDLConditionBank$16(this);
            }
            case 1700024: {
                return new SWDLConditionBank$17(this);
            }
            case 1700025: {
                return new SWDLConditionBank$18(this);
            }
            case 1700028: {
                return new SWDLConditionBank$19(this);
            }
            case 1700029: {
                return new SWDLConditionBank$20(this);
            }
            case 1700044: {
                return new SWDLConditionBank$21(this);
            }
            case 1700045: {
                return new SWDLConditionBank$22(this);
            }
            case 1700048: {
                return new SWDLConditionBank$23(this);
            }
            case 1700049: {
                return new SWDLConditionBank$24(this);
            }
            case 1700050: {
                return new SWDLConditionBank$25(this);
            }
            case 1700057: {
                return new SWDLConditionBank$26(this);
            }
            case 1700058: {
                return new SWDLConditionBank$27(this);
            }
            case 1700060: {
                return new SWDLConditionBank$28(this);
            }
            case 1700061: {
                return new SWDLConditionBank$29(this);
            }
            case 1700062: {
                return new SWDLConditionBank$30(this);
            }
            case 1700063: {
                return new SWDLConditionBank$31(this);
            }
            case 1700068: {
                return new SWDLConditionBank$32(this);
            }
            case 1700071: {
                return new SWDLConditionBank$33(this);
            }
            case 1700072: {
                return new SWDLConditionBank$34(this);
            }
            case 1700073: {
                return new SWDLConditionBank$35(this);
            }
            case 1700074: {
                return new SWDLConditionBank$36(this);
            }
            case 1700075: {
                return new SWDLConditionBank$37(this);
            }
            case 1700076: {
                return new SWDLConditionBank$38(this);
            }
            case 1700089: {
                return new SWDLConditionBank$39(this);
            }
            case 1700090: {
                return new SWDLConditionBank$40(this);
            }
            case 1700091: {
                return new SWDLConditionBank$41(this);
            }
            case 1700093: {
                return new SWDLConditionBank$42(this);
            }
            case 1700094: {
                return new SWDLConditionBank$43(this);
            }
            case 1700095: {
                return new SWDLConditionBank$44(this);
            }
            case 1700096: {
                return new SWDLConditionBank$45(this);
            }
            case 1700097: {
                return new SWDLConditionBank$46(this);
            }
            case 1700098: {
                return new SWDLConditionBank$47(this);
            }
            case 1700100: {
                return new SWDLConditionBank$48(this);
            }
            case 1700101: {
                return new SWDLConditionBank$49(this);
            }
            case 1700102: {
                return new SWDLConditionBank$50(this);
            }
            case 1700103: {
                return new SWDLConditionBank$51(this);
            }
            case 1700106: {
                return new SWDLConditionBank$52(this);
            }
            case 1700107: {
                return new SWDLConditionBank$53(this);
            }
            case 1700108: {
                return new SWDLConditionBank$54(this);
            }
            case 1700109: {
                return new SWDLConditionBank$55(this);
            }
            case 1700110: {
                return new SWDLConditionBank$56(this);
            }
            case 1700116: {
                return new SWDLConditionBank$57(this);
            }
            case 1700117: {
                return new SWDLConditionBank$58(this);
            }
            case 1700118: {
                return new SWDLConditionBank$59(this);
            }
            case 1700119: {
                return new SWDLConditionBank$60(this);
            }
            case 1700120: {
                return new SWDLConditionBank$61(this);
            }
            case 1700122: {
                return new SWDLConditionBank$62(this);
            }
            case 1700123: {
                return new SWDLConditionBank$63(this);
            }
            case 1700124: {
                return new SWDLConditionBank$64(this);
            }
            case 1700125: {
                return new SWDLConditionBank$65(this);
            }
            case 1700126: {
                return new SWDLConditionBank$66(this);
            }
            case 0x19F11F: {
                return new SWDLConditionBank$67(this);
            }
            case 1700128: {
                return new SWDLConditionBank$68(this);
            }
            case 1700129: {
                return new SWDLConditionBank$69(this);
            }
            case 1700130: {
                return new SWDLConditionBank$70(this);
            }
            case 1700135: {
                return new SWDLConditionBank$71(this);
            }
            case 1700136: {
                return new SWDLConditionBank$72(this);
            }
            case 1700137: {
                return new SWDLConditionBank$73(this);
            }
            case 1700139: {
                return new SWDLConditionBank$74(this);
            }
            case 1700140: {
                return new SWDLConditionBank$75(this);
            }
            case 1700142: {
                return new SWDLConditionBank$76(this);
            }
            case 1700143: {
                return new SWDLConditionBank$77(this);
            }
            case 1700144: {
                return new SWDLConditionBank$78(this);
            }
            case 1700145: {
                return new SWDLConditionBank$79(this);
            }
            case 1700146: {
                return new SWDLConditionBank$80(this);
            }
            case 1700149: {
                return new SWDLConditionBank$81(this);
            }
        }
        return null;
    }

    static /* synthetic */ SWDLScreenFactory access$000(SWDLConditionBank sWDLConditionBank) {
        return sWDLConditionBank.screenFactory;
    }
}


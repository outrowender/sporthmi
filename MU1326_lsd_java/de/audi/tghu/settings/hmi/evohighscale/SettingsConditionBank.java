/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$1;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$10;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$11;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$12;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$13;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$14;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$15;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$16;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$17;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$18;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$19;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$2;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$20;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$21;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$22;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$23;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$24;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$25;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$26;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$27;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$28;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$29;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$3;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$30;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$31;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$32;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$33;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$34;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$35;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$36;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$37;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$38;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$39;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$4;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$40;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$41;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$42;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$43;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$44;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$45;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$46;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$47;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$48;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$49;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$5;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$50;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$51;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$52;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$53;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$54;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$55;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$56;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$57;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$58;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$59;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$6;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$60;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$61;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$7;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$8;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank$9;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

public class SettingsConditionBank
implements HMIConditionBank {
    private SettingsScreenFactory screenFactory;

    public SettingsConditionBank(SettingsScreenFactory settingsScreenFactory) {
        this.screenFactory = settingsScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1100000: {
                return new SettingsConditionBank$1(this);
            }
            case 1100007: {
                return new SettingsConditionBank$2(this);
            }
            case 1100081: {
                return new SettingsConditionBank$3(this);
            }
            case 1100082: {
                return new SettingsConditionBank$4(this);
            }
            case 1100083: {
                return new SettingsConditionBank$5(this);
            }
            case 1100084: {
                return new SettingsConditionBank$6(this);
            }
            case 1100085: {
                return new SettingsConditionBank$7(this);
            }
            case 1100086: {
                return new SettingsConditionBank$8(this);
            }
            case 1100087: {
                return new SettingsConditionBank$9(this);
            }
            case 1100088: {
                return new SettingsConditionBank$10(this);
            }
            case 1100089: {
                return new SettingsConditionBank$11(this);
            }
            case 1100090: {
                return new SettingsConditionBank$12(this);
            }
            case 1100099: {
                return new SettingsConditionBank$13(this);
            }
            case 1100100: {
                return new SettingsConditionBank$14(this);
            }
            case 1100102: {
                return new SettingsConditionBank$15(this);
            }
            case 1100103: {
                return new SettingsConditionBank$16(this);
            }
            case 1100104: {
                return new SettingsConditionBank$17(this);
            }
            case 1100105: {
                return new SettingsConditionBank$18(this);
            }
            case 1100106: {
                return new SettingsConditionBank$19(this);
            }
            case 1100107: {
                return new SettingsConditionBank$20(this);
            }
            case 1100108: {
                return new SettingsConditionBank$21(this);
            }
            case 1100109: {
                return new SettingsConditionBank$22(this);
            }
            case 1100110: {
                return new SettingsConditionBank$23(this);
            }
            case 1100111: {
                return new SettingsConditionBank$24(this);
            }
            case 1100112: {
                return new SettingsConditionBank$25(this);
            }
            case 1100119: {
                return new SettingsConditionBank$26(this);
            }
            case 1100120: {
                return new SettingsConditionBank$27(this);
            }
            case 1100121: {
                return new SettingsConditionBank$28(this);
            }
            case 1100122: {
                return new SettingsConditionBank$29(this);
            }
            case 1100123: {
                return new SettingsConditionBank$30(this);
            }
            case 1100124: {
                return new SettingsConditionBank$31(this);
            }
            case 1100125: {
                return new SettingsConditionBank$32(this);
            }
            case 1100127: {
                return new SettingsConditionBank$33(this);
            }
            case 1100129: {
                return new SettingsConditionBank$34(this);
            }
            case 1100130: {
                return new SettingsConditionBank$35(this);
            }
            case 1100131: {
                return new SettingsConditionBank$36(this);
            }
            case 1100132: {
                return new SettingsConditionBank$37(this);
            }
            case 1100133: {
                return new SettingsConditionBank$38(this);
            }
            case 1100134: {
                return new SettingsConditionBank$39(this);
            }
            case 1100135: {
                return new SettingsConditionBank$40(this);
            }
            case 1100136: {
                return new SettingsConditionBank$41(this);
            }
            case 1100137: {
                return new SettingsConditionBank$42(this);
            }
            case 1100138: {
                return new SettingsConditionBank$43(this);
            }
            case 1100139: {
                return new SettingsConditionBank$44(this);
            }
            case 1100140: {
                return new SettingsConditionBank$45(this);
            }
            case 1100141: {
                return new SettingsConditionBank$46(this);
            }
            case 1100143: {
                return new SettingsConditionBank$47(this);
            }
            case 1100144: {
                return new SettingsConditionBank$48(this);
            }
            case 1100148: {
                return new SettingsConditionBank$49(this);
            }
            case 1100149: {
                return new SettingsConditionBank$50(this);
            }
            case 1100153: {
                return new SettingsConditionBank$51(this);
            }
            case 1100162: {
                return new SettingsConditionBank$52(this);
            }
            case 1100163: {
                return new SettingsConditionBank$53(this);
            }
            case 1100164: {
                return new SettingsConditionBank$54(this);
            }
            case 1100165: {
                return new SettingsConditionBank$55(this);
            }
            case 1100166: {
                return new SettingsConditionBank$56(this);
            }
            case 1100167: {
                return new SettingsConditionBank$57(this);
            }
            case 1100168: {
                return new SettingsConditionBank$58(this);
            }
            case 1100169: {
                return new SettingsConditionBank$59(this);
            }
            case 1100170: {
                return new SettingsConditionBank$60(this);
            }
            case 1100171: {
                return new SettingsConditionBank$61(this);
            }
        }
        return null;
    }

    static /* synthetic */ SettingsScreenFactory access$000(SettingsConditionBank settingsConditionBank) {
        return settingsConditionBank.screenFactory;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$1;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$10;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$100;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$101;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$102;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$103;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$104;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$105;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$106;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$107;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$108;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$109;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$11;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$110;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$111;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$112;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$113;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$114;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$115;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$116;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$117;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$118;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$119;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$12;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$120;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$121;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$122;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$123;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$124;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$125;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$126;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$127;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$128;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$129;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$13;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$130;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$131;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$132;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$133;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$134;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$135;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$136;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$137;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$138;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$139;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$14;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$140;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$141;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$142;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$143;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$144;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$145;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$146;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$147;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$148;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$149;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$15;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$150;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$151;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$152;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$153;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$154;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$155;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$156;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$157;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$158;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$159;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$16;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$160;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$161;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$162;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$163;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$164;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$165;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$166;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$167;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$168;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$169;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$17;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$170;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$171;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$172;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$173;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$174;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$175;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$176;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$177;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$178;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$179;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$18;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$180;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$181;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$182;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$183;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$184;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$185;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$186;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$187;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$188;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$189;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$19;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$190;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$191;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$192;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$193;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$194;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$195;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$196;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$197;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$198;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$199;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$2;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$20;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$200;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$201;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$202;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$203;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$204;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$205;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$206;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$207;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$208;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$21;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$22;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$23;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$24;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$25;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$26;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$27;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$28;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$29;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$3;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$30;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$31;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$32;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$33;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$34;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$35;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$36;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$37;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$38;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$39;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$4;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$40;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$41;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$42;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$43;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$44;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$45;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$46;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$47;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$48;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$49;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$5;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$50;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$51;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$52;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$53;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$54;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$55;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$56;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$57;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$58;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$59;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$6;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$60;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$61;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$62;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$63;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$64;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$65;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$66;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$67;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$68;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$69;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$7;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$70;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$71;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$72;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$73;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$74;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$75;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$76;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$77;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$78;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$79;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$8;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$80;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$81;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$82;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$83;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$84;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$85;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$86;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$87;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$88;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$89;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$9;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$90;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$91;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$92;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$93;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$94;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$95;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$96;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$97;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$98;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank$99;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenFactory;

public class ConnectivityConditionBank
implements HMIConditionBank {
    private ConnectivityScreenFactory screenFactory;

    public ConnectivityConditionBank(ConnectivityScreenFactory connectivityScreenFactory) {
        this.screenFactory = connectivityScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 2500000: {
                return new ConnectivityConditionBank$1(this);
            }
            case 2500004: {
                return new ConnectivityConditionBank$2(this);
            }
            case 2500005: {
                return new ConnectivityConditionBank$3(this);
            }
            case 2500009: {
                return new ConnectivityConditionBank$4(this);
            }
            case 2500010: {
                return new ConnectivityConditionBank$5(this);
            }
            case 2500011: {
                return new ConnectivityConditionBank$6(this);
            }
            case 2500012: {
                return new ConnectivityConditionBank$7(this);
            }
            case 2500014: {
                return new ConnectivityConditionBank$8(this);
            }
            case 2500015: {
                return new ConnectivityConditionBank$9(this);
            }
            case 2500019: {
                return new ConnectivityConditionBank$10(this);
            }
            case 2500020: {
                return new ConnectivityConditionBank$11(this);
            }
            case 2500023: {
                return new ConnectivityConditionBank$12(this);
            }
            case 2500031: {
                return new ConnectivityConditionBank$13(this);
            }
            case 2500032: {
                return new ConnectivityConditionBank$14(this);
            }
            case 2500033: {
                return new ConnectivityConditionBank$15(this);
            }
            case 2500034: {
                return new ConnectivityConditionBank$16(this);
            }
            case 2500035: {
                return new ConnectivityConditionBank$17(this);
            }
            case 2500036: {
                return new ConnectivityConditionBank$18(this);
            }
            case 2500037: {
                return new ConnectivityConditionBank$19(this);
            }
            case 2500039: {
                return new ConnectivityConditionBank$20(this);
            }
            case 2500051: {
                return new ConnectivityConditionBank$21(this);
            }
            case 2500052: {
                return new ConnectivityConditionBank$22(this);
            }
            case 2500053: {
                return new ConnectivityConditionBank$23(this);
            }
            case 2500079: {
                return new ConnectivityConditionBank$24(this);
            }
            case 2500080: {
                return new ConnectivityConditionBank$25(this);
            }
            case 2500081: {
                return new ConnectivityConditionBank$26(this);
            }
            case 0x262629: {
                return new ConnectivityConditionBank$27(this);
            }
            case 0x26262A: {
                return new ConnectivityConditionBank$28(this);
            }
            case 0x26262B: {
                return new ConnectivityConditionBank$29(this);
            }
            case 0x26262C: {
                return new ConnectivityConditionBank$30(this);
            }
            case 0x26262D: {
                return new ConnectivityConditionBank$31(this);
            }
            case 0x26262E: {
                return new ConnectivityConditionBank$32(this);
            }
            case 0x26262F: {
                return new ConnectivityConditionBank$33(this);
            }
            case 2500144: {
                return new ConnectivityConditionBank$34(this);
            }
            case 2500145: {
                return new ConnectivityConditionBank$35(this);
            }
            case 0x262632: {
                return new ConnectivityConditionBank$36(this);
            }
            case 0x262669: {
                return new ConnectivityConditionBank$37(this);
            }
            case 2500231: {
                return new ConnectivityConditionBank$38(this);
            }
            case 0x262688: {
                return new ConnectivityConditionBank$39(this);
            }
            case 2500234: {
                return new ConnectivityConditionBank$40(this);
            }
            case 2500289: {
                return new ConnectivityConditionBank$41(this);
            }
            case 0x2626C2: {
                return new ConnectivityConditionBank$42(this);
            }
            case 2500321: {
                return new ConnectivityConditionBank$43(this);
            }
            case 0x2626E2: {
                return new ConnectivityConditionBank$44(this);
            }
            case 2500324: {
                return new ConnectivityConditionBank$45(this);
            }
            case 2500381: {
                return new ConnectivityConditionBank$46(this);
            }
            case 2500382: {
                return new ConnectivityConditionBank$47(this);
            }
            case 2500383: {
                return new ConnectivityConditionBank$48(this);
            }
            case 2500384: {
                return new ConnectivityConditionBank$49(this);
            }
            case 2500385: {
                return new ConnectivityConditionBank$50(this);
            }
            case 0x262722: {
                return new ConnectivityConditionBank$51(this);
            }
            case 2500387: {
                return new ConnectivityConditionBank$52(this);
            }
            case 2500388: {
                return new ConnectivityConditionBank$53(this);
            }
            case 2500389: {
                return new ConnectivityConditionBank$54(this);
            }
            case 0x262726: {
                return new ConnectivityConditionBank$55(this);
            }
            case 0x262727: {
                return new ConnectivityConditionBank$56(this);
            }
            case 2500420: {
                return new ConnectivityConditionBank$57(this);
            }
            case 2500422: {
                return new ConnectivityConditionBank$58(this);
            }
            case 2500423: {
                return new ConnectivityConditionBank$59(this);
            }
            case 2500425: {
                return new ConnectivityConditionBank$60(this);
            }
            case 2500426: {
                return new ConnectivityConditionBank$61(this);
            }
            case 2500427: {
                return new ConnectivityConditionBank$62(this);
            }
            case 0x262767: {
                return new ConnectivityConditionBank$63(this);
            }
            case 2500456: {
                return new ConnectivityConditionBank$64(this);
            }
            case 2500457: {
                return new ConnectivityConditionBank$65(this);
            }
            case 2500458: {
                return new ConnectivityConditionBank$66(this);
            }
            case 2500459: {
                return new ConnectivityConditionBank$67(this);
            }
            case 2500460: {
                return new ConnectivityConditionBank$68(this);
            }
            case 2500516: {
                return new ConnectivityConditionBank$69(this);
            }
            case 2500543: {
                return new ConnectivityConditionBank$70(this);
            }
            case 2500544: {
                return new ConnectivityConditionBank$71(this);
            }
            case 2500571: {
                return new ConnectivityConditionBank$72(this);
            }
            case 2500629: {
                return new ConnectivityConditionBank$73(this);
            }
            case 2500630: {
                return new ConnectivityConditionBank$74(this);
            }
            case 2500633: {
                return new ConnectivityConditionBank$75(this);
            }
            case 2500659: {
                return new ConnectivityConditionBank$76(this);
            }
            case 2500660: {
                return new ConnectivityConditionBank$77(this);
            }
            case 2500661: {
                return new ConnectivityConditionBank$78(this);
            }
            case 2500662: {
                return new ConnectivityConditionBank$79(this);
            }
            case 2500663: {
                return new ConnectivityConditionBank$80(this);
            }
            case 2500664: {
                return new ConnectivityConditionBank$81(this);
            }
            case 2500665: {
                return new ConnectivityConditionBank$82(this);
            }
            case 2500666: {
                return new ConnectivityConditionBank$83(this);
            }
            case 2500667: {
                return new ConnectivityConditionBank$84(this);
            }
            case 2500668: {
                return new ConnectivityConditionBank$85(this);
            }
            case 2500669: {
                return new ConnectivityConditionBank$86(this);
            }
            case 2500671: {
                return new ConnectivityConditionBank$87(this);
            }
            case 2500734: {
                return new ConnectivityConditionBank$88(this);
            }
            case 2500756: {
                return new ConnectivityConditionBank$89(this);
            }
            case 2500758: {
                return new ConnectivityConditionBank$90(this);
            }
            case 2500829: {
                return new ConnectivityConditionBank$91(this);
            }
            case 2500830: {
                return new ConnectivityConditionBank$92(this);
            }
            case 2500831: {
                return new ConnectivityConditionBank$93(this);
            }
            case 2500832: {
                return new ConnectivityConditionBank$94(this);
            }
            case 2500833: {
                return new ConnectivityConditionBank$95(this);
            }
            case 2500834: {
                return new ConnectivityConditionBank$96(this);
            }
            case 2500835: {
                return new ConnectivityConditionBank$97(this);
            }
            case 2500861: {
                return new ConnectivityConditionBank$98(this);
            }
            case 2500873: {
                return new ConnectivityConditionBank$99(this);
            }
            case 2500874: {
                return new ConnectivityConditionBank$100(this);
            }
            case 2500897: {
                return new ConnectivityConditionBank$101(this);
            }
            case 2500920: {
                return new ConnectivityConditionBank$102(this);
            }
            case 2500921: {
                return new ConnectivityConditionBank$103(this);
            }
            case 2500946: {
                return new ConnectivityConditionBank$104(this);
            }
            case 2500947: {
                return new ConnectivityConditionBank$105(this);
            }
            case 2500948: {
                return new ConnectivityConditionBank$106(this);
            }
            case 2500949: {
                return new ConnectivityConditionBank$107(this);
            }
            case 2500950: {
                return new ConnectivityConditionBank$108(this);
            }
            case 2500951: {
                return new ConnectivityConditionBank$109(this);
            }
            case 2500952: {
                return new ConnectivityConditionBank$110(this);
            }
            case 2500953: {
                return new ConnectivityConditionBank$111(this);
            }
            case 2500954: {
                return new ConnectivityConditionBank$112(this);
            }
            case 2500956: {
                return new ConnectivityConditionBank$113(this);
            }
            case 2500957: {
                return new ConnectivityConditionBank$114(this);
            }
            case 2500958: {
                return new ConnectivityConditionBank$115(this);
            }
            case 2500959: {
                return new ConnectivityConditionBank$116(this);
            }
            case 2500960: {
                return new ConnectivityConditionBank$117(this);
            }
            case 2500961: {
                return new ConnectivityConditionBank$118(this);
            }
            case 0x262962: {
                return new ConnectivityConditionBank$119(this);
            }
            case 2500963: {
                return new ConnectivityConditionBank$120(this);
            }
            case 2500964: {
                return new ConnectivityConditionBank$121(this);
            }
            case 2500965: {
                return new ConnectivityConditionBank$122(this);
            }
            case 0x262966: {
                return new ConnectivityConditionBank$123(this);
            }
            case 2500967: {
                return new ConnectivityConditionBank$124(this);
            }
            case 0x262969: {
                return new ConnectivityConditionBank$125(this);
            }
            case 2500970: {
                return new ConnectivityConditionBank$126(this);
            }
            case 2500973: {
                return new ConnectivityConditionBank$127(this);
            }
            case 2500974: {
                return new ConnectivityConditionBank$128(this);
            }
            case 2500975: {
                return new ConnectivityConditionBank$129(this);
            }
            case 2500976: {
                return new ConnectivityConditionBank$130(this);
            }
            case 2500977: {
                return new ConnectivityConditionBank$131(this);
            }
            case 2500978: {
                return new ConnectivityConditionBank$132(this);
            }
            case 2500979: {
                return new ConnectivityConditionBank$133(this);
            }
            case 2500980: {
                return new ConnectivityConditionBank$134(this);
            }
            case 2500981: {
                return new ConnectivityConditionBank$135(this);
            }
            case 2500983: {
                return new ConnectivityConditionBank$136(this);
            }
            case 2500984: {
                return new ConnectivityConditionBank$137(this);
            }
            case 2500985: {
                return new ConnectivityConditionBank$138(this);
            }
            case 2500986: {
                return new ConnectivityConditionBank$139(this);
            }
            case 2500987: {
                return new ConnectivityConditionBank$140(this);
            }
            case 2500988: {
                return new ConnectivityConditionBank$141(this);
            }
            case 2500989: {
                return new ConnectivityConditionBank$142(this);
            }
            case 2500990: {
                return new ConnectivityConditionBank$143(this);
            }
            case 2500991: {
                return new ConnectivityConditionBank$144(this);
            }
            case 2500992: {
                return new ConnectivityConditionBank$145(this);
            }
            case 2500993: {
                return new ConnectivityConditionBank$146(this);
            }
            case 2500994: {
                return new ConnectivityConditionBank$147(this);
            }
            case 2500995: {
                return new ConnectivityConditionBank$148(this);
            }
            case 2500996: {
                return new ConnectivityConditionBank$149(this);
            }
            case 2500997: {
                return new ConnectivityConditionBank$150(this);
            }
            case 2500998: {
                return new ConnectivityConditionBank$151(this);
            }
            case 2500999: {
                return new ConnectivityConditionBank$152(this);
            }
            case 2501001: {
                return new ConnectivityConditionBank$153(this);
            }
            case 2501002: {
                return new ConnectivityConditionBank$154(this);
            }
            case 2501008: {
                return new ConnectivityConditionBank$155(this);
            }
            case 2501009: {
                return new ConnectivityConditionBank$156(this);
            }
            case 2501012: {
                return new ConnectivityConditionBank$157(this);
            }
            case 2501013: {
                return new ConnectivityConditionBank$158(this);
            }
            case 2501018: {
                return new ConnectivityConditionBank$159(this);
            }
            case 2501019: {
                return new ConnectivityConditionBank$160(this);
            }
            case 2501020: {
                return new ConnectivityConditionBank$161(this);
            }
            case 2501022: {
                return new ConnectivityConditionBank$162(this);
            }
            case 2501023: {
                return new ConnectivityConditionBank$163(this);
            }
            case 2501024: {
                return new ConnectivityConditionBank$164(this);
            }
            case 2501025: {
                return new ConnectivityConditionBank$165(this);
            }
            case 2501026: {
                return new ConnectivityConditionBank$166(this);
            }
            case 2501027: {
                return new ConnectivityConditionBank$167(this);
            }
            case 2501028: {
                return new ConnectivityConditionBank$168(this);
            }
            case 2501029: {
                return new ConnectivityConditionBank$169(this);
            }
            case 2501030: {
                return new ConnectivityConditionBank$170(this);
            }
            case 2501031: {
                return new ConnectivityConditionBank$171(this);
            }
            case 2501032: {
                return new ConnectivityConditionBank$172(this);
            }
            case 2501033: {
                return new ConnectivityConditionBank$173(this);
            }
            case 2501034: {
                return new ConnectivityConditionBank$174(this);
            }
            case 2501035: {
                return new ConnectivityConditionBank$175(this);
            }
            case 2501036: {
                return new ConnectivityConditionBank$176(this);
            }
            case 2501037: {
                return new ConnectivityConditionBank$177(this);
            }
            case 2501038: {
                return new ConnectivityConditionBank$178(this);
            }
            case 2501039: {
                return new ConnectivityConditionBank$179(this);
            }
            case 2501040: {
                return new ConnectivityConditionBank$180(this);
            }
            case 2501045: {
                return new ConnectivityConditionBank$181(this);
            }
            case 2501046: {
                return new ConnectivityConditionBank$182(this);
            }
            case 2501047: {
                return new ConnectivityConditionBank$183(this);
            }
            case 2501048: {
                return new ConnectivityConditionBank$184(this);
            }
            case 2501049: {
                return new ConnectivityConditionBank$185(this);
            }
            case 2501052: {
                return new ConnectivityConditionBank$186(this);
            }
            case 2501054: {
                return new ConnectivityConditionBank$187(this);
            }
            case 2501055: {
                return new ConnectivityConditionBank$188(this);
            }
            case 2501056: {
                return new ConnectivityConditionBank$189(this);
            }
            case 2501057: {
                return new ConnectivityConditionBank$190(this);
            }
            case 2501095: {
                return new ConnectivityConditionBank$191(this);
            }
            case 2501096: {
                return new ConnectivityConditionBank$192(this);
            }
            case 2501097: {
                return new ConnectivityConditionBank$193(this);
            }
            case 2501098: {
                return new ConnectivityConditionBank$194(this);
            }
            case 2501099: {
                return new ConnectivityConditionBank$195(this);
            }
            case 2501100: {
                return new ConnectivityConditionBank$196(this);
            }
            case 2501101: {
                return new ConnectivityConditionBank$197(this);
            }
            case 2501102: {
                return new ConnectivityConditionBank$198(this);
            }
            case 2501103: {
                return new ConnectivityConditionBank$199(this);
            }
            case 2501104: {
                return new ConnectivityConditionBank$200(this);
            }
            case 2501105: {
                return new ConnectivityConditionBank$201(this);
            }
            case 2501107: {
                return new ConnectivityConditionBank$202(this);
            }
            case 2501108: {
                return new ConnectivityConditionBank$203(this);
            }
            case 2501109: {
                return new ConnectivityConditionBank$204(this);
            }
            case 2501110: {
                return new ConnectivityConditionBank$205(this);
            }
            case 2501111: {
                return new ConnectivityConditionBank$206(this);
            }
            case 2501112: {
                return new ConnectivityConditionBank$207(this);
            }
            case 2501113: {
                return new ConnectivityConditionBank$208(this);
            }
        }
        return null;
    }

    static /* synthetic */ ConnectivityScreenFactory access$000(ConnectivityConditionBank connectivityConditionBank) {
        return connectivityConditionBank.screenFactory;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class SwdlTextFactoryEvo
extends AbstractSwdlTextFactory {
    @Override
    public String getTextConstantInterruptDownload() {
        return this.getI18nText(-1275782912);
    }

    @Override
    public String getTextConstantCustProgressUserInterrupt() {
        return this.getI18nText(1995774208);
    }

    @Override
    public String getTextConstantUnknown() {
        return this.getI18nText(183900416);
    }

    @Override
    public String getTextConstantCustDevInfoManagerAlreadyOn() {
        return this.getI18nText(1911888128);
    }

    @Override
    public String getTextConstantCustDevInfoManagerUnsuccess() {
        return this.getI18nText(1945442560);
    }

    @Override
    public String getTextConstantCustDevInfoManagerSuccess() {
        return this.getI18nText(1928665344);
    }

    @Override
    public String getTextConstantCustNoDevice() {
        return this.getI18nText(1962219776);
    }

    @Override
    public String getLabelForAccessType(int n, String string) {
        String string2;
        if (string != null) {
            string2 = string;
        } else {
            switch (n) {
                case 1: {
                    string2 = this.getI18nText(-1896539904);
                    break;
                }
                case 2: {
                    string2 = this.getI18nText(-1728767744);
                    break;
                }
                case 3: {
                    string2 = this.getI18nText(-1711990528);
                    break;
                }
                case 4: {
                    string2 = this.getI18nText(-1695213312);
                    break;
                }
                default: {
                    string2 = this.getI18nText(-1678436096);
                }
            }
        }
        return string2;
    }

    @Override
    public String getTextConstantDeviceInfo7() {
        return this.getI18nText(-1644881664);
    }

    @Override
    public String getTextConstantDeviceInfo6() {
        return this.getI18nText(-1661658880);
    }

    @Override
    public String getUpdateGeneralInformationText(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
        Buffer buffer = new Buffer();
        if (bl) {
            buffer.append(this.getI18nText(-1628104448));
        } else {
            buffer.append(this.getI18nText(-1611327232));
        }
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(-1879762688), new String[]{string}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(-1862985472), new String[]{string2}));
        buffer.append('\n');
        if (bl2) {
            buffer.append(this.getI18nText(-1846208256));
        } else {
            buffer.append(this.getI18nText(-1829431040));
        }
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(-1812653824), new String[]{string3}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(-1795876608), new String[]{this.intToHex(n)}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(-1779099392), new int[]{n2}));
        buffer.append('\n');
        if (bl3) {
            buffer.append(this.getI18nText(-1762322176));
            buffer.append('\n');
        }
        return buffer.toString();
    }

    @Override
    public String getUpdateSignatureText(int[] nArray) {
        Buffer buffer = new Buffer();
        if (nArray != null && nArray.length > 0) {
            buffer.append(this.getI18nText(-1745544960));
            for (int i2 = 0; i2 < nArray.length; i2 += 4) {
                buffer.append('\n');
                this.formatHex(buffer, nArray[i2]);
                for (int i3 = 0; i3 < 3; ++i3) {
                    if (i2 + i3 + 1 >= nArray.length) continue;
                    buffer.append(" ");
                    this.formatHex(buffer, nArray[i2 + i3 + 1]);
                }
            }
        }
        return buffer.toString();
    }

    @Override
    public String getPopupTemplateText(int n) {
        String string;
        switch (n) {
            case 0: {
                string = this.getI18nText(1240799488);
                break;
            }
            case 1: {
                string = this.getI18nText(-889906944);
                break;
            }
            case 2: {
                string = this.getI18nText(1307908352);
                break;
            }
            case 3: {
                string = this.getI18nText(1341462784);
                break;
            }
            case 4: {
                string = this.getI18nText(1358240000);
                break;
            }
            case 5: {
                string = this.getI18nText(1375017216);
                break;
            }
            case 6: {
                string = this.getI18nText(-873129728);
                break;
            }
            case 7: {
                string = this.getI18nText(-856352512);
                break;
            }
            case 8: {
                string = this.getI18nText(1257576704);
                break;
            }
            case 9: {
                string = this.getI18nText(1274353920);
                break;
            }
            case 10: {
                string = this.getI18nText(1291131136);
                break;
            }
            case 11: {
                string = this.getI18nText(-906684160);
                break;
            }
            case 12: {
                string = this.getI18nText(-822798080);
                break;
            }
            case 13: {
                string = this.getI18nText(-806020864);
                break;
            }
            case 14: {
                string = this.getI18nText(1408571648);
                break;
            }
            case 15: {
                string = this.getI18nText(1391794432);
                break;
            }
            case 16: {
                string = this.getI18nText(-839575296);
                break;
            }
            case 17: {
                string = this.getI18nText(1559566592);
                break;
            }
            case 18: {
                string = this.getI18nText(1576343808);
                break;
            }
            case 19: {
                string = this.getI18nText(1593121024);
                break;
            }
            case 20: {
                string = this.getI18nText(1609898240);
                break;
            }
            case 21: {
                string = this.getI18nText(1626675456);
                break;
            }
            case 22: {
                string = this.getI18nText(-1426712320);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @Override
    public String getFileErrorText(int n) {
        String string = "";
        switch (n) {
            case 1: {
                string = this.getI18nText(-1460332288);
                break;
            }
            case 2: {
                string = this.getI18nText(-1443555072);
                break;
            }
            case 3: {
                string = this.getI18nText(-1493886720);
                break;
            }
            case 4: {
                string = this.getI18nText(-1443555072);
                break;
            }
            case 5: {
                string = this.getI18nText(-1493886720);
                break;
            }
            case 6: {
                string = this.getI18nText(-1443555072);
                break;
            }
            case 7: {
                string = this.getI18nText(-1410000640);
                break;
            }
            case 8: {
                string = this.getI18nText(-1393223424);
                break;
            }
            case 9: {
                string = this.getI18nText(-1477109504);
                break;
            }
            case 10: {
                string = this.getI18nText(-1477109504);
                break;
            }
            case 11: {
                string = this.getI18nText(-1460332288);
                break;
            }
            case 12: {
                string = this.getI18nText(-1460332288);
                break;
            }
            case 13: {
                string = this.getI18nText(-1477109504);
                break;
            }
            case 14: {
                string = this.getI18nText(-1426777856);
                break;
            }
            case 15: {
                string = this.getI18nText(-1410000640);
                break;
            }
            case 16: {
                string = this.getI18nText(-1460332288);
                break;
            }
            case 17: {
                string = this.getI18nText(-1443555072);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @Override
    public String getSubTitleText(int n) {
        switch (n) {
            case 0: {
                return this.getI18nText(-789243648);
            }
            case 1: {
                return this.getI18nText(-738912000);
            }
            case 2: {
                return this.getI18nText(-722134784);
            }
            case 3: {
                return this.getI18nText(-705357568);
            }
            case 4: {
                return this.getI18nText(-688580352);
            }
            case 5: {
                return this.getI18nText(-671803136);
            }
            case 6: {
                return this.getI18nText(-655025920);
            }
            case 7: {
                return this.getI18nText(-638248704);
            }
            case 8: {
                return this.getI18nText(-621471488);
            }
            case 9: {
                return this.getI18nText(-772466432);
            }
            case 10: {
                return this.getI18nText(-772466432);
            }
            case 11: {
                return this.getI18nText(-755689216);
            }
            case 12: {
                return this.getI18nText(-604694272);
            }
            case 13: {
                return this.getI18nText(-537585408);
            }
            case 14: {
                return this.getI18nText(-571139840);
            }
            case 15: {
                return this.getI18nText(-587917056);
            }
            case 16: {
                return this.getI18nText(-604694272);
            }
            case 17: {
                return this.getI18nText(1509234944);
            }
            case 18: {
                return this.getI18nText(1526012160);
            }
            case 19: {
                return this.getI18nText(1526012160);
            }
            case 20: {
                return this.getI18nText(1526012160);
            }
            case 21: {
                return this.getI18nText(1542789376);
            }
            case 22: {
                return this.getI18nText(-1544087296);
            }
        }
        return "";
    }

    @Override
    public String getTextConstantCustProgressPleaseInsert() {
        return this.getI18nText(1978996992);
    }

    @Override
    public String getTextConstantCustUotaUpdateUnavailable() {
        int n = -1393092352;
        switch (this.getSwdlEnv().getUotaRegion()) {
            case 1: {
                n = -1258874624;
                break;
            }
            case 3: {
                n = -1258874624;
                break;
            }
            case 2: {
                n = -1242097408;
                break;
            }
        }
        return this.getI18nText(n);
    }

    @Override
    public String getTextConstantCustUotaAlreadyInstalled() {
        return this.getI18nText(-1376315136);
    }

    @Override
    public String getTextConstantPopupMessage14() {
        return this.getI18nText(1307908352);
    }

    @Override
    public String getUpdateGeneralProgressText(GeneralProgress generalProgress) {
        Buffer buffer = new Buffer();
        int n = generalProgress.getFinishedDevicesWithoutError() + generalProgress.getUnavailableDevices() + generalProgress.getFinishedDevicesWithError() + generalProgress.getActiveDevices();
        if (generalProgress.getMaxStage() > 1) {
            StringUtilities.formatMessage(buffer, this.getI18nText(-403367680), new int[]{n, generalProgress.getUpdatingDevices(), generalProgress.getCurrentStage(), generalProgress.getMaxStage()});
        } else {
            StringUtilities.formatMessage(buffer, this.getI18nText(-504030976), new int[]{n, generalProgress.getUpdatingDevices()});
        }
        buffer.append('\n');
        StringUtilities.formatMessage(buffer, this.getI18nText(-487253760), new int[]{generalProgress.getFinishedDevicesWithoutError(), generalProgress.getUnavailableDevices(), generalProgress.getFinishedDevicesWithError()});
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    @Override
    public String getUpdateLostDevicesText(String[] stringArray) {
        Buffer buffer = new Buffer();
        buffer.append(this.getI18nText(-470476544));
        buffer.append('\n');
        String string = this.getI18nText(-453699328);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (i2 > 0) {
                buffer.append(string);
            }
            buffer.append(stringArray[i2]);
        }
        return buffer.toString();
    }

    @Override
    public String getUpdateStaticProgressDetailsWithProgressText(int n, int n2, short s, String string) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append('\n');
        buffer.append(this.getI18nText(-520808192));
        buffer.append(" %2%%\n");
        if (n >= 0 && n2 >= 0) {
            StringUtilities.formatMessage(buffer, this.getI18nText(-420144896), new int[]{n, n2});
            buffer.append('\n');
        }
        buffer.append(this.getI18nText(-436922112));
        buffer.append('\n');
        buffer.append(this.getI18nText(-1342891776));
        if (s > 0) {
            buffer.append(" ");
            buffer.append(s);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    @Override
    public String getUpdateStaticProgressDetailsWithoutProgressText(int n, int n2, short s, String string) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append('\n');
        if (n >= 0 && n2 >= 0) {
            StringUtilities.formatMessage(buffer, this.getI18nText(-420144896), new int[]{n, n2});
            buffer.append('\n');
        }
        buffer.append(this.getI18nText(-436922112));
        buffer.append('\n');
        if (s > 0) {
            buffer.append(this.getI18nText(-1342891776));
            buffer.append(" ");
            buffer.append(s);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    @Override
    public String getTextConstantProgress3() {
        return this.getI18nText(-470476544);
    }

    @Override
    public String getTextConstantRetryDownload() {
        return this.getI18nText(116791552);
    }

    @Override
    public String getSelectionErrorNoFittingText() {
        return this.getI18nText(2046105856);
    }

    @Override
    public String getSelectionErrorMoreThanOneText() {
        return this.getI18nText(2029328640);
    }

    @Override
    public String getSelectionErrorUpdateInconsistentText() {
        return this.getI18nText(2062883072);
    }

    @Override
    public String getSelectionErrorIncompDevicesText() {
        return this.getI18nText(2012551424);
    }

    @Override
    public String getTextConstantWaiting() {
        return this.getI18nText(251009280);
    }

    @Override
    public String getTextConstantOK() {
        return this.getI18nText(535959808);
    }

    @Override
    public String getTextConstantUnexpectedResultFromConsistencyCheck() {
        return this.getI18nText(167123200);
    }

    @Override
    public String getTextConstantRequires() {
        return this.getI18nText(100014336);
    }

    @Override
    public String getTextConstantEngSelectManagerAbort() {
        return this.getI18nText(1106581760);
    }

    @Override
    public String getTextConstantEngSelectManagerConfirmed() {
        return this.getI18nText(1123358976);
    }

    @Override
    public String getTextConstantEngSelectManagerFailed() {
        return this.getI18nText(1140136192);
    }

    @Override
    public String getTextConstantDeviceInfo1() {
        return this.getI18nText(-1896539904);
    }

    @Override
    public String getDetailedSummaryText(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(2113214720);
                break;
            }
            case 1: {
                string = this.getI18nText(-2030757632);
                break;
            }
            case 2: {
                string = this.getI18nText(-2013980416);
                break;
            }
            case 3: {
                string = this.getI18nText(-1997203200);
                break;
            }
            case 4: {
                string = this.getI18nText(-1980425984);
                break;
            }
            case 5: {
                string = this.getI18nText(-1963648768);
                break;
            }
            case 6: {
                string = this.getI18nText(-1946871552);
                break;
            }
            case 7: {
                string = this.getI18nText(-1930094336);
                break;
            }
            case 8: {
                string = this.getI18nText(-1913317120);
                break;
            }
            case 9: {
                string = this.getI18nText(2129991936);
                break;
            }
            case 10: {
                string = this.getI18nText(2146769152);
                break;
            }
            case 11: {
                string = this.getI18nText(-2131420928);
                break;
            }
            case 12: {
                string = this.getI18nText(-2114643712);
                break;
            }
            case 13: {
                string = this.getI18nText(-2097866496);
                break;
            }
            case 14: {
                string = this.getI18nText(-2081089280);
                break;
            }
            case 15: {
                string = this.getI18nText(1089804544);
                break;
            }
            case 16: {
                string = this.getI18nText(-1678305024);
                break;
            }
            default: {
                string = new StringBuffer().append(this.getI18nText(-2047534848)).append(n).toString();
            }
        }
        return string;
    }

    @Override
    public String[] getDefaultFiles() {
        return new String[]{this.getI18nText(-1644881664), this.getI18nText(-1661658880)};
    }

    @Override
    public String getLanguageErrorText() {
        return this.getI18nText(-1259005696);
    }

    @Override
    public String getErrorText(int n) {
        String string;
        switch (n) {
            case 256: {
                string = this.getI18nText(-873195264);
                break;
            }
            case 257: {
                string = this.getI18nText(-856418048);
                break;
            }
            case 258: {
                string = this.getI18nText(-839640832);
                break;
            }
            case 259: {
                string = this.getI18nText(-822863616);
                break;
            }
            case 272: {
                string = this.getI18nText(-806086400);
                break;
            }
            case 273: {
                string = this.getI18nText(-789309184);
                break;
            }
            case 288: {
                string = this.getI18nText(-772531968);
                break;
            }
            case 289: {
                string = this.getI18nText(-755754752);
                break;
            }
            case 290: {
                string = this.getI18nText(-738977536);
                break;
            }
            case 291: {
                string = this.getI18nText(-722200320);
                break;
            }
            case 294: {
                string = this.getI18nText(-705423104);
                break;
            }
            case 304: {
                string = this.getI18nText(-688645888);
                break;
            }
            case 305: {
                string = this.getI18nText(-671868672);
                break;
            }
            case 306: {
                string = this.getI18nText(-655091456);
                break;
            }
            case 307: {
                string = this.getI18nText(-638314240);
                break;
            }
            case 308: {
                string = this.getI18nText(-621537024);
                break;
            }
            case 309: {
                string = this.getI18nText(-604759808);
                break;
            }
            case 310: {
                string = this.getI18nText(-587982592);
                break;
            }
            case 311: {
                string = this.getI18nText(-571205376);
                break;
            }
            case 312: {
                string = this.getI18nText(-554428160);
                break;
            }
            case 313: {
                string = this.getI18nText(-537650944);
                break;
            }
            case 314: {
                string = this.getI18nText(-520873728);
                break;
            }
            case 315: {
                string = this.getI18nText(-504096512);
                break;
            }
            case 316: {
                string = this.getI18nText(-487319296);
                break;
            }
            case 317: {
                string = this.getI18nText(-470542080);
                break;
            }
            case 318: {
                string = this.getI18nText(-453764864);
                break;
            }
            case 319: {
                string = this.getI18nText(-436987648);
                break;
            }
            case 320: {
                string = this.getI18nText(-420210432);
                break;
            }
            case 321: {
                string = this.getI18nText(-403433216);
                break;
            }
            case 322: {
                string = this.getI18nText(-386656000);
                break;
            }
            case 323: {
                string = this.getI18nText(-369878784);
                break;
            }
            case 324: {
                string = this.getI18nText(-353101568);
                break;
            }
            case 325: {
                string = this.getI18nText(-336324352);
                break;
            }
            case 326: {
                string = this.getI18nText(-319547136);
                break;
            }
            case 327: {
                string = this.getI18nText(-302769920);
                break;
            }
            case 328: {
                string = this.getI18nText(-285992704);
                break;
            }
            case 329: {
                string = this.getI18nText(-269215488);
                break;
            }
            case 330: {
                string = this.getI18nText(-252438272);
                break;
            }
            case 331: {
                string = this.getI18nText(-235661056);
                break;
            }
            case 332: {
                string = this.getI18nText(-218883840);
                break;
            }
            case 333: {
                string = this.getI18nText(-202106624);
                break;
            }
            case 334: {
                string = this.getI18nText(-185329408);
                break;
            }
            case 335: {
                string = this.getI18nText(-168552192);
                break;
            }
            case 336: {
                string = this.getI18nText(-151774976);
                break;
            }
            case 337: {
                string = this.getI18nText(-134997760);
                break;
            }
            case 338: {
                string = this.getI18nText(-118220544);
                break;
            }
            case 339: {
                string = this.getI18nText(-101443328);
                break;
            }
            default: {
                string = this.getI18nText(-84666112);
            }
        }
        return string;
    }

    @Override
    public String getErrorText9() {
        return this.getI18nText(-1544218368);
    }

    @Override
    public String[] getUnusualEventData(int n) {
        String[] stringArray = new String[2];
        if (n < 256) {
            stringArray[0] = this.getI18nText(-889972480);
            stringArray[1] = this.getI18nText(-1712056064);
        } else {
            switch (n) {
                case 256: {
                    stringArray[0] = this.getI18nText(-873195264);
                    stringArray[1] = this.getI18nText(-1695278848);
                    break;
                }
                case 257: {
                    stringArray[0] = this.getI18nText(-856418048);
                    stringArray[1] = this.getI18nText(-1678501632);
                    break;
                }
                case 258: {
                    stringArray[0] = this.getI18nText(-839640832);
                    stringArray[1] = this.getI18nText(-1661724416);
                    break;
                }
                case 259: {
                    stringArray[0] = this.getI18nText(-822863616);
                    stringArray[1] = this.getI18nText(-1644947200);
                    break;
                }
                case 272: {
                    stringArray[0] = this.getI18nText(-806086400);
                    stringArray[1] = this.getI18nText(-1628169984);
                    break;
                }
                case 273: {
                    stringArray[0] = this.getI18nText(-789309184);
                    stringArray[1] = this.getI18nText(-1611392768);
                    break;
                }
                case 288: {
                    stringArray[0] = this.getI18nText(-772531968);
                    stringArray[1] = this.getI18nText(-1594615552);
                    break;
                }
                case 289: {
                    stringArray[0] = this.getI18nText(-755754752);
                    stringArray[1] = this.getI18nText(-1577838336);
                    break;
                }
                case 290: {
                    stringArray[0] = this.getI18nText(-738977536);
                    stringArray[1] = this.getI18nText(-1561061120);
                    break;
                }
                case 291: {
                    stringArray[0] = this.getI18nText(-722200320);
                    stringArray[1] = this.getI18nText(-1544283904);
                    break;
                }
                case 294: {
                    stringArray[0] = this.getI18nText(-705423104);
                    stringArray[1] = this.getI18nText(-1527506688);
                    break;
                }
                case 304: {
                    stringArray[0] = this.getI18nText(-688645888);
                    stringArray[1] = this.getI18nText(-1510729472);
                    break;
                }
                case 305: {
                    stringArray[0] = this.getI18nText(-671868672);
                    stringArray[1] = this.getI18nText(-1493952256);
                    break;
                }
                case 306: {
                    stringArray[0] = this.getI18nText(-655091456);
                    stringArray[1] = this.getI18nText(-1477175040);
                    break;
                }
                case 307: {
                    stringArray[0] = this.getI18nText(-638314240);
                    stringArray[1] = this.getI18nText(-1460397824);
                    break;
                }
                case 308: {
                    stringArray[0] = this.getI18nText(-621537024);
                    stringArray[1] = this.getI18nText(-1443620608);
                    break;
                }
                case 309: {
                    stringArray[0] = this.getI18nText(-604759808);
                    stringArray[1] = this.getI18nText(-1426843392);
                    break;
                }
                case 310: {
                    stringArray[0] = this.getI18nText(-587982592);
                    stringArray[1] = this.getI18nText(-1410066176);
                    break;
                }
                case 311: {
                    stringArray[0] = this.getI18nText(-571205376);
                    stringArray[1] = this.getI18nText(-1393288960);
                    break;
                }
                case 312: {
                    stringArray[0] = this.getI18nText(-554428160);
                    stringArray[1] = this.getI18nText(-1376511744);
                    break;
                }
                case 313: {
                    stringArray[0] = this.getI18nText(-537650944);
                    stringArray[1] = this.getI18nText(-1359734528);
                    break;
                }
                case 314: {
                    stringArray[0] = this.getI18nText(-520873728);
                    stringArray[1] = this.getI18nText(-1342957312);
                    break;
                }
                case 315: {
                    stringArray[0] = this.getI18nText(-504096512);
                    stringArray[1] = this.getI18nText(-1326180096);
                    break;
                }
                case 316: {
                    stringArray[0] = this.getI18nText(-487319296);
                    stringArray[1] = this.getI18nText(-1309402880);
                    break;
                }
                case 317: {
                    stringArray[0] = this.getI18nText(-470542080);
                    stringArray[1] = this.getI18nText(-1292625664);
                    break;
                }
                case 318: {
                    stringArray[0] = this.getI18nText(-453764864);
                    stringArray[1] = this.getI18nText(-1275848448);
                    break;
                }
                case 319: {
                    stringArray[0] = this.getI18nText(-436987648);
                    stringArray[1] = this.getI18nText(-1259071232);
                    break;
                }
                case 320: {
                    stringArray[0] = this.getI18nText(-420210432);
                    stringArray[1] = this.getI18nText(-1242294016);
                    break;
                }
                case 321: {
                    stringArray[0] = this.getI18nText(-403433216);
                    stringArray[1] = this.getI18nText(-1225516800);
                    break;
                }
                case 322: {
                    stringArray[0] = this.getI18nText(-386656000);
                    stringArray[1] = this.getI18nText(-1208739584);
                    break;
                }
                case 323: {
                    stringArray[0] = this.getI18nText(-369878784);
                    stringArray[1] = this.getI18nText(-1191962368);
                    break;
                }
                case 324: {
                    stringArray[0] = this.getI18nText(-353101568);
                    stringArray[1] = this.getI18nText(-1175185152);
                    break;
                }
                case 325: {
                    stringArray[0] = this.getI18nText(-336324352);
                    stringArray[1] = this.getI18nText(-1158407936);
                    break;
                }
                case 326: {
                    stringArray[0] = this.getI18nText(-319547136);
                    stringArray[1] = this.getI18nText(-1141630720);
                    break;
                }
                case 327: {
                    stringArray[0] = this.getI18nText(-302769920);
                    stringArray[1] = this.getI18nText(-1124853504);
                    break;
                }
                case 328: {
                    stringArray[0] = this.getI18nText(-285992704);
                    stringArray[1] = this.getI18nText(-1108076288);
                    break;
                }
                case 329: {
                    stringArray[0] = this.getI18nText(-269215488);
                    stringArray[1] = this.getI18nText(-1091299072);
                    break;
                }
                case 330: {
                    stringArray[0] = this.getI18nText(-252438272);
                    stringArray[1] = this.getI18nText(-1074521856);
                    break;
                }
                case 331: {
                    stringArray[0] = this.getI18nText(-235661056);
                    stringArray[1] = this.getI18nText(-1057744640);
                    break;
                }
                case 332: {
                    stringArray[0] = this.getI18nText(-218883840);
                    stringArray[1] = this.getI18nText(-1040967424);
                    break;
                }
                case 333: {
                    stringArray[0] = this.getI18nText(-202106624);
                    stringArray[1] = this.getI18nText(-1024190208);
                    break;
                }
                case 334: {
                    stringArray[0] = this.getI18nText(-185329408);
                    stringArray[1] = this.getI18nText(-1007412992);
                    break;
                }
                case 335: {
                    stringArray[0] = this.getI18nText(-168552192);
                    stringArray[1] = this.getI18nText(-990635776);
                    break;
                }
                case 336: {
                    stringArray[0] = this.getI18nText(-151774976);
                    stringArray[1] = this.getI18nText(-973858560);
                    break;
                }
                case 337: {
                    stringArray[0] = this.getI18nText(-134997760);
                    stringArray[1] = this.getI18nText(-957081344);
                    break;
                }
                case 338: {
                    stringArray[0] = this.getI18nText(-118220544);
                    stringArray[1] = this.getI18nText(-940304128);
                    break;
                }
                case 339: {
                    stringArray[0] = this.getI18nText(-101443328);
                    stringArray[1] = this.getI18nText(-923526912);
                    break;
                }
                default: {
                    stringArray[0] = this.getI18nText(-84666112);
                    stringArray[1] = this.getI18nText(-906749696);
                }
            }
        }
        return stringArray;
    }

    @Override
    public String getDlProgressAsText(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(-386590464);
                break;
            }
            case 1: {
                string = this.getI18nText(-1678305024);
                break;
            }
            case 2: {
                string = this.getI18nText(-134932224);
                break;
            }
            case 3: {
                string = this.getI18nText(-118155008);
                break;
            }
            case 4: {
                string = this.getI18nText(-101377792);
                break;
            }
            case 5: {
                string = this.getI18nText(-84600576);
                break;
            }
            case 6: {
                string = this.getI18nText(-67823360);
                break;
            }
            case 7: {
                string = this.getI18nText(-51046144);
                break;
            }
            case 8: {
                string = this.getI18nText(-34268928);
                break;
            }
            case 9: {
                string = this.getI18nText(-369813248);
                break;
            }
            case 10: {
                string = this.getI18nText(-353036032);
                break;
            }
            case 11: {
                string = this.getI18nText(-336258816);
                break;
            }
            case 12: {
                string = this.getI18nText(-319481600);
                break;
            }
            case 13: {
                string = this.getI18nText(-302704384);
                break;
            }
            case 14: {
                string = this.getI18nText(-285927168);
                break;
            }
            case 15: {
                string = this.getI18nText(-269149952);
                break;
            }
            case 17: {
                string = this.getI18nText(-252372736);
                break;
            }
            case 18: {
                string = this.getI18nText(-235595520);
                break;
            }
            case 19: {
                string = this.getI18nText(-218818304);
                break;
            }
            case 20: {
                string = this.getI18nText(-185263872);
                break;
            }
            case 21: {
                string = this.getI18nText(-168486656);
                break;
            }
            case 22: {
                string = this.getI18nText(-151709440);
                break;
            }
            default: {
                string = this.getI18nText(-386590464);
            }
        }
        return string;
    }

    @Override
    public String getTextConstantDevicesReady() {
        return "all devices are ready.";
    }

    @Override
    public String getReleaseErrorTemplate(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(1727338752);
                break;
            }
            case 1: {
                string = this.getI18nText(1744115968);
                break;
            }
            case 2: {
                string = this.getI18nText(-17491712);
                break;
            }
            case 3: {
                string = this.getI18nText(16128256);
                break;
            }
            case 4: {
                string = this.getI18nText(1458903296);
                break;
            }
            case 5: {
                string = this.getI18nText(-1040901888);
                break;
            }
            case 6: {
                string = this.getI18nText(49682688);
                break;
            }
            case 7: {
                string = this.getI18nText(66459904);
                break;
            }
            case 8: {
                string = this.getI18nText(83237120);
                break;
            }
            case 9: {
                string = this.getI18nText(1425348864);
                break;
            }
            case 10: {
                string = this.getI18nText(1442126080);
                break;
            }
            case 11: {
                string = this.getI18nText(1475680512);
                break;
            }
            default: {
                string = null;
            }
        }
        return string;
    }

    @Override
    public String getTextConstantUndefinedError() {
        return this.getI18nText(1492457728);
    }

    @Override
    public String getConsistencyMessage(int n, String string, int n2) {
        Buffer buffer = new Buffer();
        String string2 = "";
        if ((n & 0) != 0) {
            buffer.append(string2).append(this.getI18nText(1727338752));
            string2 = "\n";
        }
        if ((n & 1) != 0) {
            buffer.append(string2).append(this.getI18nText(1744115968));
            string2 = "\n";
        }
        if ((n & 2) != 0) {
            buffer.append(string2).append(this.getI18nText(1660229888));
            string2 = "\n";
        }
        if ((n & 4) != 0) {
            buffer.append(string2).append(this.getI18nText(1039472896));
            string2 = "\n";
        }
        if ((n & 8) != 0) {
            buffer.append(string2).append(this.getI18nText(1056250112));
            string2 = "\n";
        }
        if ((n & 0x10) != 0) {
            buffer.append(string2).append(this.getI18nText(1073027328));
            string2 = "\n";
        }
        if ((n & 0x20) != 0) {
            buffer.append(string2).append(this.getI18nText(1828002048));
            string2 = "\n";
        }
        if ((n & 0x40) != 0) {
            buffer.append(string2).append(this.getI18nText(1844779264));
            string2 = "\n";
        }
        if ((n & 0x80) != 0) {
            buffer.append(string2).append(this.getI18nText(1710561536));
            string2 = "\n";
        }
        if ((n & 0x100) != 0) {
            String string3 = StringUtilities.formatMessage(this.getI18nText(1677007104), new String[]{string, Integer.toString(n2)});
            buffer.append(string2).append(string3);
            string2 = "\n";
        }
        if ((n & 0x200) != 0) {
            buffer.append(string2).append(this.getI18nText(1811224832));
            string2 = "\n";
        }
        if ((n & 0x400) != 0) {
            buffer.append(string2).append(this.getI18nText(1794447616));
            string2 = "\n";
        }
        if ((n & 0x800) != 0) {
            buffer.append(string2).append(this.getI18nText(1760893184));
            string2 = "\n";
        }
        if ((n & 0x1000) != 0) {
            buffer.append(string2).append(this.getI18nText(1777670400));
            string2 = "\n";
        }
        if ((n & 0x2000) != 0) {
            buffer.append(string2).append(this.getI18nText(1693784320));
            string2 = "\n";
        }
        return buffer.toString();
    }

    @Override
    public String getMetainfoErrorTemplate(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(-1091233536);
                break;
            }
            case 1: {
                string = this.getI18nText(1744115968);
                break;
            }
            case 2: {
                string = this.getI18nText(-1074456320);
                break;
            }
            case 3: {
                string = this.getI18nText(-1057679104);
                break;
            }
            case 4: {
                string = this.getI18nText(1190467840);
                break;
            }
            case 5: {
                string = this.getI18nText(-1040901888);
                break;
            }
            case 6: {
                string = this.getI18nText(-1024124672);
                break;
            }
            case 7: {
                string = this.getI18nText(1207245056);
                break;
            }
            case 8: {
                string = this.getI18nText(1224022272);
                break;
            }
            case 9: {
                string = this.getI18nText(1156913408);
                break;
            }
            case 10: {
                string = this.getI18nText(1173690624);
                break;
            }
            default: {
                string = null;
            }
        }
        return string;
    }

    public String getMediumNameById(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "Undefined Medium ID";
                break;
            }
            case 1: {
                string = "Ethernet";
                break;
            }
            case 2: {
                string = "DVD";
                break;
            }
            case 3: {
                string = "USB";
                break;
            }
            case 4: {
                string = "SD 1";
                break;
            }
            case 5: {
                string = "SD 2";
                break;
            }
            case 6: {
                string = "CIFS";
                break;
            }
            case 8: {
                string = "FS";
                break;
            }
            default: {
                string = "Undefined Medium ID";
            }
        }
        return string;
    }
}


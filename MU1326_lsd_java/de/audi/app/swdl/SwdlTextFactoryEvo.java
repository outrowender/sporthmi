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
    public String getTextConstantInterruptDownload() {
        return this.getI18nText(1701299);
    }

    public String getTextConstantCustProgressUserInterrupt() {
        return this.getI18nText(1701238);
    }

    public String getTextConstantUnknown() {
        return this.getI18nText(1701386);
    }

    public String getTextConstantCustDevInfoManagerAlreadyOn() {
        return this.getI18nText(1701233);
    }

    public String getTextConstantCustDevInfoManagerUnsuccess() {
        return this.getI18nText(1701235);
    }

    public String getTextConstantCustDevInfoManagerSuccess() {
        return this.getI18nText(1701234);
    }

    public String getTextConstantCustNoDevice() {
        return this.getI18nText(1701236);
    }

    public String getLabelForAccessType(int n, String string) {
        String string2;
        if (string != null) {
            string2 = string;
        } else {
            switch (n) {
                case 1: {
                    string2 = this.getI18nText(1701262);
                    break;
                }
                case 2: {
                    string2 = this.getI18nText(1701272);
                    break;
                }
                case 3: {
                    string2 = this.getI18nText(1701273);
                    break;
                }
                case 4: {
                    string2 = this.getI18nText(1701274);
                    break;
                }
                default: {
                    string2 = this.getI18nText(1701275);
                }
            }
        }
        return string2;
    }

    public String getTextConstantDeviceInfo7() {
        return this.getI18nText(1701277);
    }

    public String getTextConstantDeviceInfo6() {
        return this.getI18nText(1701276);
    }

    public String getUpdateGeneralInformationText(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
        Buffer buffer = new Buffer();
        if (bl) {
            buffer.append(this.getI18nText(1701278));
        } else {
            buffer.append(this.getI18nText(1701279));
        }
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(1701263), new String[]{string}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(1701264), new String[]{string2}));
        buffer.append('\n');
        if (bl2) {
            buffer.append(this.getI18nText(1701265));
        } else {
            buffer.append(this.getI18nText(1701266));
        }
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(1701267), new String[]{string3}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(1701268), new String[]{this.intToHex(n)}));
        buffer.append('\n');
        buffer.append(StringUtilities.formatMessage(this.getI18nText(1701269), new int[]{n2}));
        buffer.append('\n');
        if (bl3) {
            buffer.append(this.getI18nText(1701270));
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public String getUpdateSignatureText(int[] nArray) {
        Buffer buffer = new Buffer();
        if (nArray != null && nArray.length > 0) {
            buffer.append(this.getI18nText(1701271));
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

    public String getPopupTemplateText(int n) {
        String string;
        switch (n) {
            case 0: {
                string = this.getI18nText(1701193);
                break;
            }
            case 1: {
                string = this.getI18nText(1701322);
                break;
            }
            case 2: {
                string = this.getI18nText(1701197);
                break;
            }
            case 3: {
                string = this.getI18nText(1701199);
                break;
            }
            case 4: {
                string = this.getI18nText(1701200);
                break;
            }
            case 5: {
                string = this.getI18nText(1701201);
                break;
            }
            case 6: {
                string = this.getI18nText(1701323);
                break;
            }
            case 7: {
                string = this.getI18nText(1701324);
                break;
            }
            case 8: {
                string = this.getI18nText(1701194);
                break;
            }
            case 9: {
                string = this.getI18nText(1701195);
                break;
            }
            case 10: {
                string = this.getI18nText(1701196);
                break;
            }
            case 11: {
                string = this.getI18nText(1701321);
                break;
            }
            case 12: {
                string = this.getI18nText(1701326);
                break;
            }
            case 13: {
                string = this.getI18nText(1701327);
                break;
            }
            case 14: {
                string = this.getI18nText(1701203);
                break;
            }
            case 15: {
                string = this.getI18nText(1701202);
                break;
            }
            case 16: {
                string = this.getI18nText(1701325);
                break;
            }
            case 17: {
                string = this.getI18nText(1701212);
                break;
            }
            case 18: {
                string = this.getI18nText(1701213);
                break;
            }
            case 19: {
                string = this.getI18nText(1701214);
                break;
            }
            case 20: {
                string = this.getI18nText(1701215);
                break;
            }
            case 21: {
                string = this.getI18nText(1701216);
                break;
            }
            case 22: {
                string = this.getI18nText(1701546);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    public String getFileErrorText(int n) {
        String string = "";
        switch (n) {
            case 1: {
                string = this.getI18nText(1701288);
                break;
            }
            case 2: {
                string = this.getI18nText(1701289);
                break;
            }
            case 3: {
                string = this.getI18nText(1701286);
                break;
            }
            case 4: {
                string = this.getI18nText(1701289);
                break;
            }
            case 5: {
                string = this.getI18nText(1701286);
                break;
            }
            case 6: {
                string = this.getI18nText(1701289);
                break;
            }
            case 7: {
                string = this.getI18nText(1701291);
                break;
            }
            case 8: {
                string = this.getI18nText(1701292);
                break;
            }
            case 9: {
                string = this.getI18nText(1701287);
                break;
            }
            case 10: {
                string = this.getI18nText(1701287);
                break;
            }
            case 11: {
                string = this.getI18nText(1701288);
                break;
            }
            case 12: {
                string = this.getI18nText(1701288);
                break;
            }
            case 13: {
                string = this.getI18nText(1701287);
                break;
            }
            case 14: {
                string = this.getI18nText(1701290);
                break;
            }
            case 15: {
                string = this.getI18nText(1701291);
                break;
            }
            case 16: {
                string = this.getI18nText(1701288);
                break;
            }
            case 17: {
                string = this.getI18nText(1701289);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    public String getSubTitleText(int n) {
        switch (n) {
            case 0: {
                return this.getI18nText(1701328);
            }
            case 1: {
                return this.getI18nText(1701331);
            }
            case 2: {
                return this.getI18nText(1701332);
            }
            case 3: {
                return this.getI18nText(1701333);
            }
            case 4: {
                return this.getI18nText(1701334);
            }
            case 5: {
                return this.getI18nText(1701335);
            }
            case 6: {
                return this.getI18nText(1701336);
            }
            case 7: {
                return this.getI18nText(1701337);
            }
            case 8: {
                return this.getI18nText(1701338);
            }
            case 9: {
                return this.getI18nText(1701329);
            }
            case 10: {
                return this.getI18nText(1701329);
            }
            case 11: {
                return this.getI18nText(1701330);
            }
            case 12: {
                return this.getI18nText(1701339);
            }
            case 13: {
                return this.getI18nText(1701343);
            }
            case 14: {
                return this.getI18nText(1701341);
            }
            case 15: {
                return this.getI18nText(1701340);
            }
            case 16: {
                return this.getI18nText(1701339);
            }
            case 17: {
                return this.getI18nText(1701209);
            }
            case 18: {
                return this.getI18nText(1701210);
            }
            case 19: {
                return this.getI18nText(1701210);
            }
            case 20: {
                return this.getI18nText(1701210);
            }
            case 21: {
                return this.getI18nText(1701211);
            }
            case 22: {
                return this.getI18nText(1701795);
            }
        }
        return "";
    }

    public String getTextConstantCustProgressPleaseInsert() {
        return this.getI18nText(1701237);
    }

    public String getTextConstantCustUotaUpdateUnavailable() {
        int n = 1701804;
        switch (this.getSwdlEnv().getUotaRegion()) {
            case 1: {
                n = 1701812;
                break;
            }
            case 3: {
                n = 1701812;
                break;
            }
            case 2: {
                n = 1701813;
                break;
            }
        }
        return this.getI18nText(n);
    }

    public String getTextConstantCustUotaAlreadyInstalled() {
        return this.getI18nText(1701805);
    }

    public String getTextConstantPopupMessage14() {
        return this.getI18nText(1701197);
    }

    public String getUpdateGeneralProgressText(GeneralProgress generalProgress) {
        Buffer buffer = new Buffer();
        int n = generalProgress.getFinishedDevicesWithoutError() + generalProgress.getUnavailableDevices() + generalProgress.getFinishedDevicesWithError() + generalProgress.getActiveDevices();
        if (generalProgress.getMaxStage() > 1) {
            StringUtilities.formatMessage(buffer, this.getI18nText(1701351), new int[]{n, generalProgress.getUpdatingDevices(), generalProgress.getCurrentStage(), generalProgress.getMaxStage()});
        } else {
            StringUtilities.formatMessage(buffer, this.getI18nText(1701345), new int[]{n, generalProgress.getUpdatingDevices()});
        }
        buffer.append('\n');
        StringUtilities.formatMessage(buffer, this.getI18nText(1701346), new int[]{generalProgress.getFinishedDevicesWithoutError(), generalProgress.getUnavailableDevices(), generalProgress.getFinishedDevicesWithError()});
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    public String getUpdateLostDevicesText(String[] stringArray) {
        Buffer buffer = new Buffer();
        buffer.append(this.getI18nText(1701347));
        buffer.append('\n');
        String string = this.getI18nText(1701348);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (i2 > 0) {
                buffer.append(string);
            }
            buffer.append(stringArray[i2]);
        }
        return buffer.toString();
    }

    public String getUpdateStaticProgressDetailsWithProgressText(int n, int n2, short s, String string) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append('\n');
        buffer.append(this.getI18nText(1701344));
        buffer.append(" %2%%\n");
        if (n >= 0 && n2 >= 0) {
            StringUtilities.formatMessage(buffer, this.getI18nText(1701350), new int[]{n, n2});
            buffer.append('\n');
        }
        buffer.append(this.getI18nText(1701349));
        buffer.append('\n');
        buffer.append(this.getI18nText(1701295));
        if (s > 0) {
            buffer.append(" ");
            buffer.append(s);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    public String getUpdateStaticProgressDetailsWithoutProgressText(int n, int n2, short s, String string) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append('\n');
        if (n >= 0 && n2 >= 0) {
            StringUtilities.formatMessage(buffer, this.getI18nText(1701350), new int[]{n, n2});
            buffer.append('\n');
        }
        buffer.append(this.getI18nText(1701349));
        buffer.append('\n');
        if (s > 0) {
            buffer.append(this.getI18nText(1701295));
            buffer.append(" ");
            buffer.append(s);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    public String getTextConstantProgress3() {
        return this.getI18nText(1701347);
    }

    public String getTextConstantRetryDownload() {
        return this.getI18nText(1701382);
    }

    public String getSelectionErrorNoFittingText() {
        return this.getI18nText(1701241);
    }

    public String getSelectionErrorMoreThanOneText() {
        return this.getI18nText(1701240);
    }

    public String getSelectionErrorUpdateInconsistentText() {
        return this.getI18nText(1701242);
    }

    public String getSelectionErrorIncompDevicesText() {
        return this.getI18nText(1701239);
    }

    public String getTextConstantWaiting() {
        return this.getI18nText(1701390);
    }

    public String getTextConstantOK() {
        return this.getI18nText(1700383);
    }

    public String getTextConstantUnexpectedResultFromConsistencyCheck() {
        return this.getI18nText(1701385);
    }

    public String getTextConstantRequires() {
        return this.getI18nText(1701381);
    }

    public String getTextConstantEngSelectManagerAbort() {
        return this.getI18nText(1701185);
    }

    public String getTextConstantEngSelectManagerConfirmed() {
        return this.getI18nText(1701186);
    }

    public String getTextConstantEngSelectManagerFailed() {
        return this.getI18nText(1701187);
    }

    public String getTextConstantDeviceInfo1() {
        return this.getI18nText(1701262);
    }

    public String getDetailedSummaryText(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(1701245);
                break;
            }
            case 1: {
                string = this.getI18nText(1701254);
                break;
            }
            case 2: {
                string = this.getI18nText(1701255);
                break;
            }
            case 3: {
                string = this.getI18nText(1701256);
                break;
            }
            case 4: {
                string = this.getI18nText(1701257);
                break;
            }
            case 5: {
                string = this.getI18nText(1701258);
                break;
            }
            case 6: {
                string = this.getI18nText(1701259);
                break;
            }
            case 7: {
                string = this.getI18nText(1701260);
                break;
            }
            case 8: {
                string = this.getI18nText(1701261);
                break;
            }
            case 9: {
                string = this.getI18nText(1701246);
                break;
            }
            case 10: {
                string = this.getI18nText(1701247);
                break;
            }
            case 11: {
                string = this.getI18nText(1701248);
                break;
            }
            case 12: {
                string = this.getI18nText(1701249);
                break;
            }
            case 13: {
                string = this.getI18nText(1701250);
                break;
            }
            case 14: {
                string = this.getI18nText(1701251);
                break;
            }
            case 15: {
                string = this.getI18nText(1701184);
                break;
            }
            case 16: {
                string = this.getI18nText(1701787);
                break;
            }
            default: {
                string = this.getI18nText(1701253) + n;
            }
        }
        return string;
    }

    public String[] getDefaultFiles() {
        return new String[]{this.getI18nText(1701277), this.getI18nText(1701276)};
    }

    public String getLanguageErrorText() {
        return this.getI18nText(1701300);
    }

    public String getErrorText(int n) {
        String string;
        switch (n) {
            case 256: {
                string = this.getI18nText(1701067);
                break;
            }
            case 257: {
                string = this.getI18nText(1701068);
                break;
            }
            case 258: {
                string = this.getI18nText(1701069);
                break;
            }
            case 259: {
                string = this.getI18nText(1701070);
                break;
            }
            case 272: {
                string = this.getI18nText(1701071);
                break;
            }
            case 273: {
                string = this.getI18nText(1701072);
                break;
            }
            case 288: {
                string = this.getI18nText(1701073);
                break;
            }
            case 289: {
                string = this.getI18nText(1701074);
                break;
            }
            case 290: {
                string = this.getI18nText(1701075);
                break;
            }
            case 291: {
                string = this.getI18nText(1701076);
                break;
            }
            case 294: {
                string = this.getI18nText(1701077);
                break;
            }
            case 304: {
                string = this.getI18nText(1701078);
                break;
            }
            case 305: {
                string = this.getI18nText(1701079);
                break;
            }
            case 306: {
                string = this.getI18nText(1701080);
                break;
            }
            case 307: {
                string = this.getI18nText(1701081);
                break;
            }
            case 308: {
                string = this.getI18nText(1701082);
                break;
            }
            case 309: {
                string = this.getI18nText(1701083);
                break;
            }
            case 310: {
                string = this.getI18nText(1701084);
                break;
            }
            case 311: {
                string = this.getI18nText(1701085);
                break;
            }
            case 312: {
                string = this.getI18nText(1701086);
                break;
            }
            case 313: {
                string = this.getI18nText(1701087);
                break;
            }
            case 314: {
                string = this.getI18nText(1701088);
                break;
            }
            case 315: {
                string = this.getI18nText(1701089);
                break;
            }
            case 316: {
                string = this.getI18nText(1701090);
                break;
            }
            case 317: {
                string = this.getI18nText(1701091);
                break;
            }
            case 318: {
                string = this.getI18nText(1701092);
                break;
            }
            case 319: {
                string = this.getI18nText(1701093);
                break;
            }
            case 320: {
                string = this.getI18nText(1701094);
                break;
            }
            case 321: {
                string = this.getI18nText(1701095);
                break;
            }
            case 322: {
                string = this.getI18nText(1701096);
                break;
            }
            case 323: {
                string = this.getI18nText(1701097);
                break;
            }
            case 324: {
                string = this.getI18nText(1701098);
                break;
            }
            case 325: {
                string = this.getI18nText(1701099);
                break;
            }
            case 326: {
                string = this.getI18nText(1701100);
                break;
            }
            case 327: {
                string = this.getI18nText(1701101);
                break;
            }
            case 328: {
                string = this.getI18nText(1701102);
                break;
            }
            case 329: {
                string = this.getI18nText(1701103);
                break;
            }
            case 330: {
                string = this.getI18nText(1701104);
                break;
            }
            case 331: {
                string = this.getI18nText(1701105);
                break;
            }
            case 332: {
                string = this.getI18nText(1701106);
                break;
            }
            case 333: {
                string = this.getI18nText(1701107);
                break;
            }
            case 334: {
                string = this.getI18nText(1701108);
                break;
            }
            case 335: {
                string = this.getI18nText(1701109);
                break;
            }
            case 336: {
                string = this.getI18nText(1701110);
                break;
            }
            case 337: {
                string = this.getI18nText(1701111);
                break;
            }
            case 338: {
                string = this.getI18nText(1701112);
                break;
            }
            case 339: {
                string = this.getI18nText(1701113);
                break;
            }
            default: {
                string = this.getI18nText(1701114);
            }
        }
        return string;
    }

    public String getErrorText9() {
        return this.getI18nText(1701283);
    }

    public String[] getUnusualEventData(int n) {
        String[] stringArray = new String[2];
        if (n < 256) {
            stringArray[0] = this.getI18nText(1701066);
            stringArray[1] = this.getI18nText(1701017);
        } else {
            switch (n) {
                case 256: {
                    stringArray[0] = this.getI18nText(1701067);
                    stringArray[1] = this.getI18nText(1701018);
                    break;
                }
                case 257: {
                    stringArray[0] = this.getI18nText(1701068);
                    stringArray[1] = this.getI18nText(1701019);
                    break;
                }
                case 258: {
                    stringArray[0] = this.getI18nText(1701069);
                    stringArray[1] = this.getI18nText(1701020);
                    break;
                }
                case 259: {
                    stringArray[0] = this.getI18nText(1701070);
                    stringArray[1] = this.getI18nText(1701021);
                    break;
                }
                case 272: {
                    stringArray[0] = this.getI18nText(1701071);
                    stringArray[1] = this.getI18nText(1701022);
                    break;
                }
                case 273: {
                    stringArray[0] = this.getI18nText(1701072);
                    stringArray[1] = this.getI18nText(1701023);
                    break;
                }
                case 288: {
                    stringArray[0] = this.getI18nText(1701073);
                    stringArray[1] = this.getI18nText(1701024);
                    break;
                }
                case 289: {
                    stringArray[0] = this.getI18nText(1701074);
                    stringArray[1] = this.getI18nText(1701025);
                    break;
                }
                case 290: {
                    stringArray[0] = this.getI18nText(1701075);
                    stringArray[1] = this.getI18nText(1701026);
                    break;
                }
                case 291: {
                    stringArray[0] = this.getI18nText(1701076);
                    stringArray[1] = this.getI18nText(1701027);
                    break;
                }
                case 294: {
                    stringArray[0] = this.getI18nText(1701077);
                    stringArray[1] = this.getI18nText(1701028);
                    break;
                }
                case 304: {
                    stringArray[0] = this.getI18nText(1701078);
                    stringArray[1] = this.getI18nText(1701029);
                    break;
                }
                case 305: {
                    stringArray[0] = this.getI18nText(1701079);
                    stringArray[1] = this.getI18nText(1701030);
                    break;
                }
                case 306: {
                    stringArray[0] = this.getI18nText(1701080);
                    stringArray[1] = this.getI18nText(1701031);
                    break;
                }
                case 307: {
                    stringArray[0] = this.getI18nText(1701081);
                    stringArray[1] = this.getI18nText(1701032);
                    break;
                }
                case 308: {
                    stringArray[0] = this.getI18nText(1701082);
                    stringArray[1] = this.getI18nText(1701033);
                    break;
                }
                case 309: {
                    stringArray[0] = this.getI18nText(1701083);
                    stringArray[1] = this.getI18nText(1701034);
                    break;
                }
                case 310: {
                    stringArray[0] = this.getI18nText(1701084);
                    stringArray[1] = this.getI18nText(1701035);
                    break;
                }
                case 311: {
                    stringArray[0] = this.getI18nText(1701085);
                    stringArray[1] = this.getI18nText(1701036);
                    break;
                }
                case 312: {
                    stringArray[0] = this.getI18nText(1701086);
                    stringArray[1] = this.getI18nText(1701037);
                    break;
                }
                case 313: {
                    stringArray[0] = this.getI18nText(1701087);
                    stringArray[1] = this.getI18nText(1701038);
                    break;
                }
                case 314: {
                    stringArray[0] = this.getI18nText(1701088);
                    stringArray[1] = this.getI18nText(1701039);
                    break;
                }
                case 315: {
                    stringArray[0] = this.getI18nText(1701089);
                    stringArray[1] = this.getI18nText(1701040);
                    break;
                }
                case 316: {
                    stringArray[0] = this.getI18nText(1701090);
                    stringArray[1] = this.getI18nText(1701041);
                    break;
                }
                case 317: {
                    stringArray[0] = this.getI18nText(1701091);
                    stringArray[1] = this.getI18nText(1701042);
                    break;
                }
                case 318: {
                    stringArray[0] = this.getI18nText(1701092);
                    stringArray[1] = this.getI18nText(1701043);
                    break;
                }
                case 319: {
                    stringArray[0] = this.getI18nText(1701093);
                    stringArray[1] = this.getI18nText(1701044);
                    break;
                }
                case 320: {
                    stringArray[0] = this.getI18nText(1701094);
                    stringArray[1] = this.getI18nText(1701045);
                    break;
                }
                case 321: {
                    stringArray[0] = this.getI18nText(1701095);
                    stringArray[1] = this.getI18nText(1701046);
                    break;
                }
                case 322: {
                    stringArray[0] = this.getI18nText(1701096);
                    stringArray[1] = this.getI18nText(1701047);
                    break;
                }
                case 323: {
                    stringArray[0] = this.getI18nText(1701097);
                    stringArray[1] = this.getI18nText(1701048);
                    break;
                }
                case 324: {
                    stringArray[0] = this.getI18nText(1701098);
                    stringArray[1] = this.getI18nText(1701049);
                    break;
                }
                case 325: {
                    stringArray[0] = this.getI18nText(1701099);
                    stringArray[1] = this.getI18nText(1701050);
                    break;
                }
                case 326: {
                    stringArray[0] = this.getI18nText(1701100);
                    stringArray[1] = this.getI18nText(1701051);
                    break;
                }
                case 327: {
                    stringArray[0] = this.getI18nText(1701101);
                    stringArray[1] = this.getI18nText(1701052);
                    break;
                }
                case 328: {
                    stringArray[0] = this.getI18nText(1701102);
                    stringArray[1] = this.getI18nText(1701053);
                    break;
                }
                case 329: {
                    stringArray[0] = this.getI18nText(1701103);
                    stringArray[1] = this.getI18nText(1701054);
                    break;
                }
                case 330: {
                    stringArray[0] = this.getI18nText(1701104);
                    stringArray[1] = this.getI18nText(1701055);
                    break;
                }
                case 331: {
                    stringArray[0] = this.getI18nText(1701105);
                    stringArray[1] = this.getI18nText(1701056);
                    break;
                }
                case 332: {
                    stringArray[0] = this.getI18nText(1701106);
                    stringArray[1] = this.getI18nText(1701057);
                    break;
                }
                case 333: {
                    stringArray[0] = this.getI18nText(1701107);
                    stringArray[1] = this.getI18nText(1701058);
                    break;
                }
                case 334: {
                    stringArray[0] = this.getI18nText(1701108);
                    stringArray[1] = this.getI18nText(1701059);
                    break;
                }
                case 335: {
                    stringArray[0] = this.getI18nText(1701109);
                    stringArray[1] = this.getI18nText(1701060);
                    break;
                }
                case 336: {
                    stringArray[0] = this.getI18nText(1701110);
                    stringArray[1] = this.getI18nText(1701061);
                    break;
                }
                case 337: {
                    stringArray[0] = this.getI18nText(1701111);
                    stringArray[1] = this.getI18nText(1701062);
                    break;
                }
                case 338: {
                    stringArray[0] = this.getI18nText(1701112);
                    stringArray[1] = this.getI18nText(1701063);
                    break;
                }
                case 339: {
                    stringArray[0] = this.getI18nText(1701113);
                    stringArray[1] = this.getI18nText(1701064);
                    break;
                }
                default: {
                    stringArray[0] = this.getI18nText(1701114);
                    stringArray[1] = this.getI18nText(1701065);
                }
            }
        }
        return stringArray;
    }

    public String getDlProgressAsText(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(1701352);
                break;
            }
            case 1: {
                string = this.getI18nText(1701787);
                break;
            }
            case 2: {
                string = this.getI18nText(1701367);
                break;
            }
            case 3: {
                string = this.getI18nText(1701368);
                break;
            }
            case 4: {
                string = this.getI18nText(1701369);
                break;
            }
            case 5: {
                string = this.getI18nText(1701370);
                break;
            }
            case 6: {
                string = this.getI18nText(1701371);
                break;
            }
            case 7: {
                string = this.getI18nText(1701372);
                break;
            }
            case 8: {
                string = this.getI18nText(1701373);
                break;
            }
            case 9: {
                string = this.getI18nText(1701353);
                break;
            }
            case 10: {
                string = this.getI18nText(1701354);
                break;
            }
            case 11: {
                string = this.getI18nText(1701355);
                break;
            }
            case 12: {
                string = this.getI18nText(1701356);
                break;
            }
            case 13: {
                string = this.getI18nText(1701357);
                break;
            }
            case 14: {
                string = this.getI18nText(1701358);
                break;
            }
            case 15: {
                string = this.getI18nText(1701359);
                break;
            }
            case 17: {
                string = this.getI18nText(1701360);
                break;
            }
            case 18: {
                string = this.getI18nText(1701361);
                break;
            }
            case 19: {
                string = this.getI18nText(1701362);
                break;
            }
            case 20: {
                string = this.getI18nText(1701364);
                break;
            }
            case 21: {
                string = this.getI18nText(1701365);
                break;
            }
            case 22: {
                string = this.getI18nText(1701366);
                break;
            }
            default: {
                string = this.getI18nText(1701352);
            }
        }
        return string;
    }

    public String getTextConstantDevicesReady() {
        return "all devices are ready.";
    }

    public String getReleaseErrorTemplate(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(1701222);
                break;
            }
            case 1: {
                string = this.getI18nText(1701223);
                break;
            }
            case 2: {
                string = this.getI18nText(1701374);
                break;
            }
            case 3: {
                string = this.getI18nText(1701376);
                break;
            }
            case 4: {
                string = this.getI18nText(1701206);
                break;
            }
            case 5: {
                string = this.getI18nText(1701313);
                break;
            }
            case 6: {
                string = this.getI18nText(1701378);
                break;
            }
            case 7: {
                string = this.getI18nText(1701379);
                break;
            }
            case 8: {
                string = this.getI18nText(1701380);
                break;
            }
            case 9: {
                string = this.getI18nText(1701204);
                break;
            }
            case 10: {
                string = this.getI18nText(1701205);
                break;
            }
            case 11: {
                string = this.getI18nText(1701207);
                break;
            }
            default: {
                string = null;
            }
        }
        return string;
    }

    public String getTextConstantUndefinedError() {
        return this.getI18nText(1701208);
    }

    public String getConsistencyMessage(int n, String string, int n2) {
        Buffer buffer = new Buffer();
        String string2 = "";
        if ((n & 0) != 0) {
            buffer.append(string2).append(this.getI18nText(1701222));
            string2 = "\n";
        }
        if ((n & 1) != 0) {
            buffer.append(string2).append(this.getI18nText(1701223));
            string2 = "\n";
        }
        if ((n & 2) != 0) {
            buffer.append(string2).append(this.getI18nText(1701218));
            string2 = "\n";
        }
        if ((n & 4) != 0) {
            buffer.append(string2).append(this.getI18nText(1701181));
            string2 = "\n";
        }
        if ((n & 8) != 0) {
            buffer.append(string2).append(this.getI18nText(1701182));
            string2 = "\n";
        }
        if ((n & 0x10) != 0) {
            buffer.append(string2).append(this.getI18nText(1701183));
            string2 = "\n";
        }
        if ((n & 0x20) != 0) {
            buffer.append(string2).append(this.getI18nText(1701228));
            string2 = "\n";
        }
        if ((n & 0x40) != 0) {
            buffer.append(string2).append(this.getI18nText(1701229));
            string2 = "\n";
        }
        if ((n & 0x80) != 0) {
            buffer.append(string2).append(this.getI18nText(1701221));
            string2 = "\n";
        }
        if ((n & 0x100) != 0) {
            String string3 = StringUtilities.formatMessage(this.getI18nText(1701219), new String[]{string, Integer.toString(n2)});
            buffer.append(string2).append(string3);
            string2 = "\n";
        }
        if ((n & 0x200) != 0) {
            buffer.append(string2).append(this.getI18nText(1701227));
            string2 = "\n";
        }
        if ((n & 0x400) != 0) {
            buffer.append(string2).append(this.getI18nText(1701226));
            string2 = "\n";
        }
        if ((n & 0x800) != 0) {
            buffer.append(string2).append(this.getI18nText(1701224));
            string2 = "\n";
        }
        if ((n & 0x1000) != 0) {
            buffer.append(string2).append(this.getI18nText(1701225));
            string2 = "\n";
        }
        if ((n & 0x2000) != 0) {
            buffer.append(string2).append(this.getI18nText(1701220));
            string2 = "\n";
        }
        return buffer.toString();
    }

    public String getMetainfoErrorTemplate(int n) {
        String string = null;
        switch (n) {
            case 0: {
                string = this.getI18nText(1701310);
                break;
            }
            case 1: {
                string = this.getI18nText(1701223);
                break;
            }
            case 2: {
                string = this.getI18nText(1701311);
                break;
            }
            case 3: {
                string = this.getI18nText(1701312);
                break;
            }
            case 4: {
                string = this.getI18nText(1701190);
                break;
            }
            case 5: {
                string = this.getI18nText(1701313);
                break;
            }
            case 6: {
                string = this.getI18nText(1701314);
                break;
            }
            case 7: {
                string = this.getI18nText(1701191);
                break;
            }
            case 8: {
                string = this.getI18nText(1701192);
                break;
            }
            case 9: {
                string = this.getI18nText(1701188);
                break;
            }
            case 10: {
                string = this.getI18nText(1701189);
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


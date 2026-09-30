/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.hmi.view.IDisplayListener;
import de.audi.tghu.fwhmi.DisplayManager;
import de.audi.tghu.fwhmi.IDisplayManagerKombiControl;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public class DisplayManagerMIB2High
extends DisplayManager
implements IDisplayListener,
IDisplayManagerKombiControl {
    private static final boolean SHOW_DM_INFO = Boolean.getBoolean("showDisplayManagerInfo");
    int[] visibleKDKs = new int[8];

    public DisplayManagerMIB2High(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new DisplayManagerProvider());
        for (int i2 = 0; i2 < this.visibleKDKs.length; ++i2) {
            this.visibleKDKs[i2] = -1;
        }
    }

    protected int getMappedInternalContext(int n) {
        return n;
    }

    protected int getMappedExternalContext(int n) {
        return n;
    }

    protected void defineContexts() {
        this.dc = this.framework.getKombiType() == 4 ? new DisplayContext[158] : new DisplayContext[79];
        this.dc[0] = new DisplayContext(0, new int[]{16});
        this.dc[1] = new DisplayContext(1, new int[]{16, 26});
        this.dc[2] = new DisplayContext(2, new int[]{16, 25});
        this.dc[7] = new DisplayContext(7, new int[]{16, 34});
        this.dc[3] = new DisplayContext(3, new int[]{16, 17});
        this.dc[4] = new DisplayContext(4, new int[]{16, 18});
        this.dc[5] = new DisplayContext(5, new int[]{16, 0});
        this.dc[6] = new DisplayContext(6, new int[]{16, 27});
        this.dc[8] = new DisplayContext(8, new int[]{16, 37});
        this.dc[9] = new DisplayContext(9, new int[]{16, 35});
        this.dc[33] = new DisplayContext(33, new int[]{16, 38});
        this.dc[10] = new DisplayContext(10, new int[]{16, 19});
        this.dc[11] = new DisplayContext(11, new int[]{16, 20, 21, 19});
        this.dc[12] = new DisplayContext(12, new int[]{16, 20, 22, 19});
        this.dc[13] = new DisplayContext(13, new int[]{16, 20, 23, 19});
        this.dc[14] = new DisplayContext(14, new int[]{16, 20, 19});
        this.dc[15] = new DisplayContext(15, new int[]{16, 24, 19});
        this.dc[16] = new DisplayContext(16, new int[]{16, 39});
        this.dc[17] = new DisplayContext(17, new int[]{16, 20, 21, 39});
        this.dc[18] = new DisplayContext(18, new int[]{16, 20, 22, 39});
        this.dc[19] = new DisplayContext(19, new int[]{16, 20, 23, 39});
        this.dc[20] = new DisplayContext(20, new int[]{16, 20, 39});
        this.dc[21] = new DisplayContext(21, new int[]{16, 24, 39});
        this.dc[22] = new DisplayContext(22, new int[]{16, 23, 20, 19});
        this.dc[23] = new DisplayContext(23, new int[]{16, 31});
        this.dc[24] = new DisplayContext(24, new int[]{16, 41});
        this.dc[25] = new DisplayContext(25, new int[]{16, 43});
        this.dc[26] = new DisplayContext(26, new int[]{16, 44});
        this.dc[27] = new DisplayContext(27, new int[]{16, 19, 38});
        this.dc[28] = new DisplayContext(28, new int[]{16, 39, 38});
        this.dc[29] = new DisplayContext(29, new int[]{16, 50, 19});
        this.dc[30] = new DisplayContext(30, new int[]{16, 50, 39});
        this.dc[31] = new DisplayContext(31, new int[]{16, 51});
        this.dc[32] = new DisplayContext(32, new int[]{16, 21});
        this.dc[35] = new DisplayContext(35, new int[]{36});
        this.dc[36] = new DisplayContext(36, new int[]{36, 26});
        this.dc[37] = new DisplayContext(37, new int[]{36, 25});
        this.dc[42] = new DisplayContext(42, new int[]{36, 34});
        this.dc[38] = new DisplayContext(38, new int[]{36, 17});
        this.dc[39] = new DisplayContext(39, new int[]{36, 18});
        this.dc[40] = new DisplayContext(40, new int[]{36, 0});
        this.dc[41] = new DisplayContext(41, new int[]{36, 27});
        this.dc[43] = new DisplayContext(43, new int[]{36, 37});
        this.dc[44] = new DisplayContext(44, new int[]{36, 35});
        this.dc[45] = new DisplayContext(45, new int[]{36, 19});
        this.dc[46] = new DisplayContext(46, new int[]{36, 20, 21, 19});
        this.dc[47] = new DisplayContext(47, new int[]{36, 20, 22, 19});
        this.dc[48] = new DisplayContext(48, new int[]{36, 20, 23, 19});
        this.dc[49] = new DisplayContext(49, new int[]{36, 20, 19});
        this.dc[50] = new DisplayContext(50, new int[]{36, 24, 19});
        this.dc[51] = new DisplayContext(51, new int[]{36, 39});
        this.dc[52] = new DisplayContext(52, new int[]{36, 20, 21, 39});
        this.dc[53] = new DisplayContext(53, new int[]{36, 20, 22, 39});
        this.dc[54] = new DisplayContext(54, new int[]{36, 20, 23, 39});
        this.dc[55] = new DisplayContext(55, new int[]{36, 20, 39});
        this.dc[56] = new DisplayContext(56, new int[]{36, 24, 39});
        this.dc[57] = new DisplayContext(57, new int[]{36, 31});
        this.dc[58] = new DisplayContext(58, new int[]{36, 43});
        this.dc[59] = new DisplayContext(59, new int[]{36, 44});
        this.dc[60] = new DisplayContext(60, new int[]{36, 19, 38});
        this.dc[61] = new DisplayContext(61, new int[]{36, 39, 38});
        this.dc[62] = new DisplayContext(62, new int[]{36, 50, 19});
        this.dc[63] = new DisplayContext(63, new int[]{36, 50, 39});
        this.dc[64] = new DisplayContext(64, new int[]{36, 51});
        this.dc[66] = new DisplayContext(66, new int[]{36, 21});
        this.dc[67] = new DisplayContext(67, new int[]{26});
        this.dc[68] = new DisplayContext(68, new int[]{25});
        this.dc[69] = new DisplayContext(69, new int[]{34});
        this.dc[71] = new DisplayContext(71, new int[]{27});
        this.dc[72] = new DisplayContext(72, new int[]{33});
        this.dc[76] = new DisplayContext(76, new int[]{58});
        this.dc[77] = new DisplayContext(77, new int[]{20, 102, 101, 58});
        this.dc[73] = new DisplayContext(73, new int[]{20, 102, 101});
        this.dc[74] = new DisplayContext(74, new int[]{20, 102, 101, 33});
        this.dc[75] = new DisplayContext(75, new int[0]);
        this.dc[78] = new DisplayContext(78, new int[]{16, 59});
        if (this.framework.getKombiType() == 4) {
            this.defineContextsForG24();
        }
    }

    private void defineContextsForG24() {
        for (int i2 = 0; i2 < 79; ++i2) {
            if (this.dc[i2] == null) continue;
            int n = 20;
            int[] nArray = this.createG24ContextWithKDK(i2, n);
            this.dc[i2 + 79] = new DisplayContext(i2 + 79, nArray);
        }
    }

    private int[] createG24ContextWithKDK(int n, int n2) {
        int n3 = -1;
        int[] nArray = this.dc[n].getDisplayableList();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n4 = nArray[i2];
            if (n4 != n2) continue;
            n3 = i2;
            break;
        }
        int[] nArray2 = n3 == -1 ? new int[nArray.length + 1] : new int[nArray.length];
        nArray2[0] = n2;
        int n5 = 1;
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            if (nArray[i3] == n2) continue;
            nArray2[n5] = nArray[i3];
            ++n5;
        }
        return nArray2;
    }

    protected void configureDM() {
        if (this.framework.getSysConst(541) == 2) {
            this.createImageDisplayable(new ResourceLocator(102, "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/987.png"), 102);
            this.createImageDisplayable(new ResourceLocator(101, "/mnt/app/eso/hmi/lsd/images/HMISystemEvoHigh/987.png"), 101);
        }
    }

    public void setupKDKBackground(int n) {
    }

    public void activeContext(int n, int n2) {
    }

    public void setKDKVisible(int n, int n2) {
        this.log.log(1000000, "DisplayManager#setKDKVisible visibleKDK %1 terminal %2 ", (long)n, (long)n2);
        if (this.visibleKDKs[n2] != n) {
            this.visibleKDKs[n2] = n;
            int n3 = this.getCurrentContextID(n2);
            if (n == -1) {
                this.removeKDKFromContext(n2, n3);
            } else {
                this.switchContext(n3, n2, null);
            }
        }
    }

    private void removeKDKFromContext(int n, int n2) {
        if (n == 0) {
            if (n2 >= 79) {
                this.switchContext(n2 % 79, 0, null);
            }
        } else if (n == 1 && this.framework.getSysConst(541) == 2) {
            if (n2 == 74) {
                this.switchContext(72, n, null);
            } else if (n2 == 77) {
                this.switchContext(76, n, null);
            } else if (n2 == 73) {
                this.switchContext(75, n, null);
            } else {
                this.switchContext(n2, n, null);
            }
        }
    }

    public boolean isKDKVisible(int n) {
        return this.visibleKDKs[n] != -1;
    }

    public int getVisibleKDK(int n) {
        return this.visibleKDKs[n];
    }

    public synchronized void switchContext(int n, int n2, IDisplayListener iDisplayListener) {
        this.log.log(1000000, "DisplayManager#switchContext visibleKDK %1 terminal %2 ", (long)this.visibleKDKs[n2], (long)n2);
        if (this.visibleKDKs[n2] == 20) {
            n = this.addKDKToContext(n);
        }
        super.switchContext(n, n2, iDisplayListener);
        if (SHOW_DM_INFO && this.getCurrentContextID(n2) > -1) {
            this.postStatisticInfoContextGeneral(n, n2);
            this.postStatisticInfoContextOpacity(n, n2);
        }
    }

    private void postStatisticInfoContextGeneral(int n, int n2) {
        HMIService hMIService = this.framework.getHMIService();
        String[] stringArray = this.createContextInfo(n);
        ScreenDebugInfoEvent screenDebugInfoEvent = new ScreenDebugInfoEvent(hMIService.getRootWindow(0), stringArray, 19);
        hMIService.getEventDispatcher().postEvent(screenDebugInfoEvent);
    }

    private String[] createContextInfo(int n) {
        int[] nArray = this.getDisplayables(n);
        String[] stringArray = new String[nArray.length + 1];
        stringArray[0] = new Buffer("DM: context = ").append(n).toString();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2 + 1] = new Buffer("displayable: ").append(i2).append(" = ").append(nArray[i2]).toString();
        }
        return stringArray;
    }

    private void postStatisticInfoContextOpacity(int n, int n2) {
        HMIService hMIService = this.framework.getHMIService();
        String[] stringArray = this.createOpacityInfo(n, n2);
        ScreenDebugInfoEvent screenDebugInfoEvent = new ScreenDebugInfoEvent(hMIService.getRootWindow(0), stringArray, 20);
        hMIService.getEventDispatcher().postEvent(screenDebugInfoEvent);
    }

    private String[] createOpacityInfo(int n, int n2) {
        int[] nArray = this.getDisplayables(n);
        String[] stringArray = new String[nArray.length + 1];
        stringArray[0] = "DM: displayable opacity";
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2 + 1] = new Buffer().append(nArray[i2]).append(" = ").append(this.getOpacity(nArray[i2], n2)).toString();
        }
        return stringArray;
    }

    private int addKDKToContext(int n) {
        if (this.framework.getKombiType() == 4) {
            n += 79;
        } else if (this.framework.getSysConst(541) == 2) {
            switch (n) {
                case 72: {
                    n = 74;
                    break;
                }
                case 76: {
                    n = 77;
                    break;
                }
                case 75: {
                    n = 73;
                    break;
                }
                case 74: {
                    n = 74;
                    break;
                }
                case 77: {
                    n = 77;
                    break;
                }
                default: {
                    n = 73;
                }
            }
            this.log.log(1000000, "DisplayManager#addKDKToContext new context %1 ", (long)n);
        }
        return n;
    }

    public void setKDKOpacity(int n, int n2) {
        if (this.visibleKDKs[n] != -1) {
            super.setOpacity(this.visibleKDKs[n], n, n2);
        }
    }

    public void setOpacity(int n, int n2, int n3) {
        super.setOpacity(n, n2, n3);
        if (SHOW_DM_INFO && this.getCurrentContextID(n2) > -1) {
            this.postStatisticInfoContextOpacity(this.getCurrentContextID(n2), n2);
        }
    }

    private class DisplayManagerProvider
    implements DumpInfoProvider {
        private DisplayManagerProvider() {
        }

        public String getName() {
            return "DisplayManager-Info";
        }

        public void dump(PrintStream printStream, String string) {
            this.dumpTerminalInfo(printStream, 0);
            this.dumpTerminalInfo(printStream, 1);
        }

        private void dumpTerminalInfo(PrintStream printStream, int n) {
            printStream.println(new StringBuffer().append("DM info for terminal: ").append(n).toString());
            if (DisplayManagerMIB2High.this.getCurrentContextID(n) != -1) {
                int n2;
                String[] stringArray = DisplayManagerMIB2High.this.createContextInfo(DisplayManagerMIB2High.this.getCurrentContextID(n));
                String[] stringArray2 = DisplayManagerMIB2High.this.createOpacityInfo(DisplayManagerMIB2High.this.getCurrentContextID(n), n);
                for (n2 = 0; n2 < stringArray.length; ++n2) {
                    printStream.println(stringArray[n2]);
                }
                for (n2 = 0; n2 < stringArray2.length; ++n2) {
                    printStream.println(stringArray2[n2]);
                }
            } else {
                printStream.println("no context activated ");
            }
        }
    }
}


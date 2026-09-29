/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public final class SystemInfo {
    private static final int DISPLAY_NOTHING;
    private static final int DISPLAY_CPU;
    private static final int DISPLAY_MEM;
    private static final int DISPLAY_CPU_MEM;
    private static final int DISPLAY_DAB_INFO;
    private int prodMode = 0;
    private long memMin = Long.MAX_VALUE;
    private long memMax = Long.MIN_VALUE;
    private int displayFlag = 0;
    private static final String SYSLOAD_DATA_NAME;
    private static final String SYSLOAD_DATA_NAME_NEW;
    private File sysLoadDataFile = null;
    private int[] loadCpu = null;
    private int sysMemInUse = -1;
    private final EngineeringEnv engineeringEnv;
    private final EngineeringApp engineeringApp;

    protected SystemInfo(EngineeringEnv engineeringEnv, EngineeringApp engineeringApp) {
        this.engineeringEnv = engineeringEnv;
        this.engineeringApp = engineeringApp;
        String string = this.getEnv().getMostTrainVersion();
        this.getSystemLabel(151).setText(string);
        this.getSystemLabel(340).setText(string);
        this.getLabel(1138103040).setText(this.getEnv().getHUSwVersion());
        if (this.getEnv().isPBuild() || this.getEnv().isSimulator()) {
            this.displayFlag = 0;
        } else {
            this.displayFlag = Integer.getInteger("FlagMemCPU", this.getFlagMemCPU());
            if (this.displayFlag < 0 || this.displayFlag > 4) {
                this.displayFlag = 0;
            }
        }
        if (this.isProductionFlag()) {
            this.getEnv().getDebugLabel().setText("P");
            this.displayFlag = 0;
        }
        this.updateUseStatusLabel();
        this.getLabel(1708528384).setText(this.getEnv().getTextToolVersion());
        this.getLabel(1859523328).setText(this.getEnv().getOptionDrawerVersion());
        if (System.getProperty("enableTouchCrosshair") != null) {
            this.getSystemChoice(102).setValue(1);
        }
        if (this.getEnv().isTarget()) {
            this.sysLoadDataFile = this.getSysLoadDataFile();
            if (null != this.sysLoadDataFile) {
                this.getLogMain().log(-1601830656, "System load file %1 exists and is readable!", (Object)this.sysLoadDataFile);
            } else {
                this.getLogMain().log(-1601830656, "System load file %1 not found!", (Object)this.sysLoadDataFile);
            }
        }
    }

    private EngineeringApp getEngineeringApp() {
        return this.engineeringApp;
    }

    public EngineeringEnv getEnv() {
        return this.engineeringEnv;
    }

    private IHMIServiceApp getHMIService() {
        return this.getEnv().getHMIService();
    }

    private LogChannel getLogMain() {
        return this.getEnv().getLogMain();
    }

    private LabelModelApp getLabel(int n) {
        return this.getHMIService().getLabelModel(n);
    }

    private ListModelApp getList(int n) {
        return this.getHMIService().getListModel(n);
    }

    private LabelModelApp getSystemLabel(int n) {
        return this.getHMIService().getLabelModel(n);
    }

    private ChoiceModelApp getSystemChoice(int n) {
        return this.getHMIService().getChoiceModel(n);
    }

    protected void pwrStateOnReached() {
        if (this.displayFlag != 0) {
            this.getSystemChoice(1).setValue(0);
            this.getSystemChoice(1).setValue(1);
        }
    }

    public String getMemoryValue(long l) {
        return Long.toString(l > 0 ? (l > 0 ? l / 0 : l / 0) : l);
    }

    public String getUnit(long l) {
        return l > 0 ? (l > 0 ? "MB" : "kB") : "B";
    }

    private boolean isProductionFlag() {
        return this.prodMode != 0;
    }

    private boolean isCustemTracing() {
        return new File("/mnt/persist/savedpreset.json").exists();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private synchronized void refreshLoadData() {
        this.getLogMain().log(1078071040, "refreshLoadData()");
        this.sysMemInUse = -1;
        if (this.sysLoadDataFile != null) {
            FileInputStream fileInputStream = null;
            try {
                byte[] byArray = new byte[128];
                fileInputStream = new FileInputStream(this.sysLoadDataFile);
                int n = fileInputStream.read(byArray);
                if (n >= 5) {
                    String string = new String(byArray, 0, n, "ASCII");
                    this.getLogMain().log(-2137614336, "CPUmeter raw data %1", (Object)string);
                    int n2 = string.indexOf(" | ");
                    if (n2 > 0) {
                        String string2 = string.substring(n2 + 3).trim();
                        this.sysMemInUse = Integer.parseInt(string2);
                        string2 = string.substring(0, n2).trim();
                        if (string2.indexOf("CPU") >= 0) {
                            StringTokenizer stringTokenizer = new StringTokenizer(string2, " ");
                            this.loadCpu = new int[stringTokenizer.countTokens()];
                            for (int i2 = 0; i2 < this.loadCpu.length; ++i2) {
                                this.loadCpu[i2] = -1;
                                try {
                                    int n3;
                                    String string3 = stringTokenizer.nextToken();
                                    if (string3 == null || (n3 = string3.indexOf(58)) <= 0) continue;
                                    this.loadCpu[i2] = Integer.parseInt(string3.substring(n3 + 1));
                                    continue;
                                }
                                catch (NumberFormatException numberFormatException) {
                                    this.loadCpu[i2] = -1;
                                }
                            }
                        } else {
                            this.loadCpu = new int[]{Integer.parseInt(string2)};
                        }
                        this.getLogMain().log(-2137614336, "CPUmeter Load %1, Memory %2", (Object)this.loadCpu, (long)this.sysMemInUse);
                    }
                }
            }
            catch (IOException iOException) {
                this.loadCpu = null;
                this.sysMemInUse = -1;
            }
            catch (NumberFormatException numberFormatException) {
                this.loadCpu = null;
                this.sysMemInUse = -1;
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {
                        this.getLogMain().log(-1601830656, "closing system file '%1' failed!", (Object)this.sysLoadDataFile);
                    }
                }
            }
        }
    }

    public synchronized int getCPULoad(int n) {
        if (this.loadCpu == null || n < 0 || n > this.loadCpu.length) {
            return -1;
        }
        if (this.loadCpu[n] >= 100) {
            this.loadCpu[n] = 99;
        }
        return this.loadCpu[n];
    }

    public int getFreeMem() {
        return this.sysMemInUse;
    }

    public int getFlagMemCPU() {
        int n = this.getEnv().getStorageMgr().getInt(262, 100, 0);
        if (n < 0 || n > 4) {
            n = 0;
        }
        this.getLogMain().log(-2137614336, "Loaded statusline mode is: %1", (long)n);
        return n;
    }

    private void updateUseStatusLabel() {
        this.getEngineeringApp().setRunMemPollTimer((this.displayFlag & 3) != 0);
        if ((this.displayFlag & 4) != 0) {
            this.getEnv().sendMessage(80);
        } else {
            this.getEnv().sendMessage(81);
        }
    }

    public void setFlagMemCPU(int n) {
        this.displayFlag = n;
        this.getEnv().getStorageMgr().setInt(262, 100, n);
        this.updateUseStatusLabel();
    }

    public void setFlagScreenInfo(int n) {
        this.getEnv().getStorageMgr().setInt(262, 101, n);
    }

    public void setFlagEventQueueStatistics(int n) {
        this.getEnv().getStorageMgr().setInt(262, 102, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected String updateSystemMemory() {
        this.refreshLoadData();
        if ((long)this.sysMemInUse > this.memMax) {
            this.memMax = this.sysMemInUse;
            this.getLabel(1339429632).setText(new StringBuffer().append(this.getMemoryValue(this.sysMemInUse)).append(this.getUnit(this.sysMemInUse)).toString());
        } else if ((long)this.sysMemInUse < this.memMin) {
            this.memMin = this.sysMemInUse;
            this.getLabel(1322652416).setText(new StringBuffer().append(this.getMemoryValue(this.sysMemInUse)).append(this.getUnit(this.sysMemInUse)).toString());
        }
        Buffer buffer = new Buffer();
        if ((this.displayFlag & 2) != 0) {
            buffer.append(this.getMemoryValue(this.sysMemInUse));
            buffer.append(this.getUnit(this.sysMemInUse));
        }
        if (this.isProductionFlag()) {
            buffer.append('P');
        } else if ((this.displayFlag & 3) == 3) {
            buffer.append('|');
        }
        if ((this.displayFlag & 1) != 0) {
            SystemInfo systemInfo = this;
            synchronized (systemInfo) {
                if (this.loadCpu != null) {
                    for (int i2 = 0; i2 < this.loadCpu.length; ++i2) {
                        if (i2 > 0) {
                            buffer.append('|');
                        }
                        buffer.append(this.getCPULoad(i2));
                        buffer.append('%');
                    }
                }
            }
        }
        if (this.isCustemTracing()) {
            buffer.append("CT");
        }
        return buffer.toString();
    }

    private File getSysLoadDataFile() {
        File file = new File("/dev/cpumeter/mmx_cpu");
        if (!file.exists() || !file.canRead()) {
            file = new File("/dev/cpumeter/mmx");
        }
        if (file.exists() && file.canRead()) {
            return file;
        }
        return null;
    }

    public void fillParameter() {
        this.getLabel(1289097984).setText(" \u00b0C");
        this.getLabel(1305875200).setText(new StringBuffer().append(this.getEnv().getFOTTemp()).append(" \u00b0C").toString());
        this.getLabel(1322652416).setText("");
        this.getLabel(1339429632).setText("");
        this.getLabel(1372984064).setText(" - ");
        this.getLabel(1389761280).setText("false");
    }

    protected void fillSwAuthorizationList() {
        ListModelApp listModelApp = this.getList(584454912);
        listModelApp.clear();
        listModelApp.setMaxRows(100);
        listModelApp.setMaxColumns(2);
        ListCell[] listCellArray = new ListCell[]{new TextListCell("Addressbook"), new IntegerListCell(this.getSystemChoice(350).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Car"), new IntegerListCell(this.getSystemChoice(352).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("SWDL"), new IntegerListCell(this.getSystemChoice(375).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Info"), new IntegerListCell(this.getSystemChoice(357).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Media"), new IntegerListCell(this.getSystemChoice(358).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Navi"), new IntegerListCell(this.getSystemChoice(361).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Phone"), new IntegerListCell(this.getSystemChoice(367).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Settings"), new IntegerListCell(this.getSystemChoice(372).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Tone"), new IntegerListCell(this.getSystemChoice(377).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
        listCellArray = new ListCell[]{new TextListCell("Tuner"), new IntegerListCell(this.getSystemChoice(378).getValue() == 0 ? 0 : 1, 1)};
        listModelApp.addRow(listCellArray);
    }
}


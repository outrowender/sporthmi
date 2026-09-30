/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag.sw;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.CmdDescriptionMap;
import java.io.PrintStream;

public interface SwDiagnosisManager {
    public static final int ERROR_CODE_NO_ERROR = 0;
    public static final int ERROR_CODE_EXCEPTION = -1;
    public static final int ERROR_CODE_NOT_SUPPORTED = -2;
    public static final int ERROR_CODE_WRONG_PARAMETER_FORMAT = -3;
    public static final int ERROR_CODE_NO_SUCH_CALL = -10;

    public void addDiagGateway(AbstractSwDiagnosis var1);

    public AbstractSwDiagnosis getDiagGatewayByName(String var1);

    public void removeDiagGateway(AbstractSwDiagnosis var1);

    public int getIdByModule(String var1);

    public String getModuleById(int var1);

    public String[] getKeys(String var1);

    public Object getValue(int var1, String var2);

    public String[] getModel(int var1, int var2);

    public int[] getModelIds(int var1);

    public String[] getModelNames(int var1);

    public String[] getModules();

    public String[] getModels(int var1);

    public String[] getBundleInformation(long var1);

    public void getGlobalDump(PrintStream var1);

    public void setXMLMode(boolean var1);

    public boolean isXMLMode();

    public String getMemoryState();

    public String[] getCommands(String var1);

    public CmdDescriptionMap getCommandDescriptions(String var1);

    public Object processCommand(int var1, String var2, Object var3);
}


/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag.sw;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.CmdDescriptionMap;
import java.io.PrintStream;

public interface SwDiagnosisManager {
    public static final int ERROR_CODE_NO_ERROR;
    public static final int ERROR_CODE_EXCEPTION;
    public static final int ERROR_CODE_NOT_SUPPORTED;
    public static final int ERROR_CODE_WRONG_PARAMETER_FORMAT;
    public static final int ERROR_CODE_NO_SUCH_CALL;

    default public void addDiagGateway(AbstractSwDiagnosis abstractSwDiagnosis) {
    }

    default public AbstractSwDiagnosis getDiagGatewayByName(String string) {
    }

    default public void removeDiagGateway(AbstractSwDiagnosis abstractSwDiagnosis) {
    }

    default public int getIdByModule(String string) {
    }

    default public String getModuleById(int n) {
    }

    default public String[] getKeys(String string) {
    }

    default public Object getValue(int n, String string) {
    }

    default public String[] getModel(int n, int n2) {
    }

    default public int[] getModelIds(int n) {
    }

    default public String[] getModelNames(int n) {
    }

    default public String[] getModules() {
    }

    default public String[] getModels(int n) {
    }

    default public String[] getBundleInformation(long l) {
    }

    default public void getGlobalDump(PrintStream printStream) {
    }

    default public void setXMLMode(boolean bl) {
    }

    default public boolean isXMLMode() {
    }

    default public String getMemoryState() {
    }

    default public String[] getCommands(String string) {
    }

    default public CmdDescriptionMap getCommandDescriptions(String string) {
    }

    default public Object processCommand(int n, String string, Object object) {
    }
}


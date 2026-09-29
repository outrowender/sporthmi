/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.FSCViewer;
import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator$1;
import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator$2;
import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator$3;
import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator$4;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.SFscHistory;

public class DSISwdlSWaPSimulator
implements DSISWaP {
    private final EngineeringEnv engineeringEnv;
    private final ArrayList m_attributes = new ArrayList();
    private final FSCViewer fscViewer;

    public DSISwdlSWaPSimulator(EngineeringEnv engineeringEnv, FSCViewer fSCViewer) {
        this.engineeringEnv = engineeringEnv;
        this.fscViewer = fSCViewer;
    }

    private final FSCViewer getFSCViewer() {
        return this.fscViewer;
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::setNotification[").append(i2).append("] ").append(nArray[i2]).toString());
                this.m_attributes.add(new Integer(nArray[i2]));
            }
        }
        if (this.m_attributes.contains(new Integer(8))) {
            this.getEngineeringEnv().executeInUtilThread(new DSISwdlSWaPSimulator$1(this));
        }
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::setNotification ").append(n).toString());
        this.m_attributes.add(new Integer(n));
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::clearNotification[").append(i2).append("] ").append(nArray[i2]).toString());
                this.m_attributes.remove(new Integer(nArray[i2]));
            }
        }
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::clearNotification ").append(n).toString());
        this.m_attributes.remove(new Integer(n));
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void encryptFile(String string, String string2, byte[] byArray) {
    }

    @Override
    public void checkSignature(String string, short[] sArray, int n, long l) {
    }

    @Override
    public void getPublicKey() {
    }

    @Override
    public void checkSingleFsc(int n) {
    }

    @Override
    public void decryptFile(String string, String string2, byte[] byArray) {
    }

    @Override
    public void getFscDetails(int n, int n2, int n3) {
        this.getEngineeringEnv().executeInUtilThread(new DSISwdlSWaPSimulator$2(this, n, n2, n3));
    }

    @Override
    public void triggerSoftwareEnabling() {
    }

    @Override
    public void importFSCs(int n) {
        this.getEngineeringEnv().executeInUtilThread(new DSISwdlSWaPSimulator$3(this));
    }

    @Override
    public void exportCCD(int n) {
        this.getEngineeringEnv().executeInUtilThread(new DSISwdlSWaPSimulator$4(this));
    }

    @Override
    public void getHistory() {
        this.getFSCViewer().getHistoryList(new SFscHistory[]{new SFscHistory(1024, "2012-12-23 10:15", "added"), new SFscHistory(0x2000400, "2013-01-07 18:45", "Source:'HMI' Reason:'Import' Details:'fsid(0x00040002),state(1),suppInfo(0)'"), new SFscHistory(1280, "2013-01-07 18:45", "overwritten"), new SFscHistory(0x5000600, "2013-01-15 08:23", "imported")});
    }

    static /* synthetic */ FSCViewer access$000(DSISwdlSWaPSimulator dSISwdlSWaPSimulator) {
        return dSISwdlSWaPSimulator.getFSCViewer();
    }

    static /* synthetic */ EngineeringEnv access$100(DSISwdlSWaPSimulator dSISwdlSWaPSimulator) {
        return dSISwdlSWaPSimulator.getEngineeringEnv();
    }
}


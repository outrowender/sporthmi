/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.FSCViewer;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

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

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::setNotification[").append(i2).append("] ").append(nArray[i2]).toString());
                this.m_attributes.add(new Integer(nArray[i2]));
            }
        }
        if (this.m_attributes.contains(new Integer(8))) {
            this.getEngineeringEnv().executeInUtilThread(new Runnable(){

                public void run() {
                    try {
                        Thread.sleep(2000L);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                    DSISwdlSWaPSimulator.this.getFSCViewer().updateFscList(new SFscStatus[]{new SFscStatus(262144, 0, 0), new SFscStatus(262144, 0, 1), new SFscStatus(262145, 1, 0), new SFscStatus(262146, 2, 0), new SFscStatus(262147, 4, 0), new SFscStatus(327680, 0, 0), new SFscStatus(393216, 3, 0)}, 1);
                }
            });
        }
    }

    public void setNotification(int n, DSIListener dSIListener) {
        System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::setNotification ").append(n).toString());
        this.m_attributes.add(new Integer(n));
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::clearNotification[").append(i2).append("] ").append(nArray[i2]).toString());
                this.m_attributes.remove(new Integer(nArray[i2]));
            }
        }
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        System.out.println(new StringBuffer().append("Simulating: DSISwdlSWaPSimulator::clearNotification ").append(n).toString());
        this.m_attributes.remove(new Integer(n));
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void encryptFile(String string, String string2, byte[] byArray) {
    }

    public void checkSignature(String string, short[] sArray, int n, long l) {
    }

    public void getPublicKey() {
    }

    public void checkSingleFsc(int n) {
    }

    public void decryptFile(String string, String string2, byte[] byArray) {
    }

    public void getFscDetails(final int n, final int n2, final int n3) {
        this.getEngineeringEnv().executeInUtilThread(new Runnable(){

            public void run() {
                DSISwdlSWaPSimulator.this.getEngineeringEnv().sleep(500L);
                SFscDetails sFscDetails = new SFscDetails(n, n2, n3, (short)(DSISwdlSWaPSimulator.this.getFSCViewer().isInstalled(n) ? 128 : 0), DSISwdlSWaPSimulator.this.getFSCViewer().isInstalled(n) ? "WAUZZZ8K99A123456" : "---", DSISwdlSWaPSimulator.this.getFSCViewer().isInstalled(n) ? "200806231015+0100" : "---", "VCRN ???");
                DSISwdlSWaPSimulator.this.getFSCViewer().getFscDetail(sFscDetails);
            }
        });
    }

    public void triggerSoftwareEnabling() {
    }

    public void importFSCs(int n) {
        this.getEngineeringEnv().executeInUtilThread(new Runnable(){

            public void run() {
                DSISwdlSWaPSimulator.this.getEngineeringEnv().sleep(500L);
                System.out.println("Simulating: DSISWaPSimulator::importFSCs(int medium)");
                DSISwdlSWaPSimulator.this.getEngineeringEnv().sleep(2000L);
                DSISwdlSWaPSimulator.this.getFSCViewer().importFSCsList(0, new SFscImportStatus[]{new SFscImportStatus(458752, 0, 0, 1), new SFscImportStatus(458752, 0, 0, 2), new SFscImportStatus(458753, 1, 1, 2), new SFscImportStatus(458754, 2, 2, 3), new SFscImportStatus(458755, 3, 3, 4), new SFscImportStatus(458756, 0, 4, 5)});
            }
        });
    }

    public void exportCCD(int n) {
        this.getEngineeringEnv().executeInUtilThread(new Runnable(){

            public void run() {
                DSISwdlSWaPSimulator.this.getEngineeringEnv().sleep(500L);
                System.out.println("Simulating: DSISWaPSimulator::exportCCD(int medium)");
                DSISwdlSWaPSimulator.this.getEngineeringEnv().sleep(500L);
                DSISwdlSWaPSimulator.this.getFSCViewer().exportCCD(0);
            }
        });
    }

    public void getHistory() {
        this.getFSCViewer().getHistoryList(new SFscHistory[]{new SFscHistory(262144, "2012-12-23 10:15", "added"), new SFscHistory(262146, "2013-01-07 18:45", "Source:'HMI' Reason:'Import' Details:'fsid(0x00040002),state(1),suppInfo(0)'"), new SFscHistory(327680, "2013-01-07 18:45", "overwritten"), new SFscHistory(393221, "2013-01-15 08:23", "imported")});
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DText;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public class MassageProgramNodeManager
implements IWidgetLogChannel {
    private static final String[][] MASSAGE_TEXT_NODE_NAMES = new String[][]{{"left_massage_line0", "left_massage_line1", "left_massage_line2", "left_massage_line3", "left_massage_line4", "left_massage_line5"}, {"right_massage_line0", "right_massage_line1", "right_massage_line2", "right_massage_line3", "right_massage_line4", "right_massage_line5"}};
    private static final int DEFAULT_FONT_SIZE = 16;
    private static final int NUMBER_OF_MASSAGEPROGRAMM_SLOTS = 6;
    private static MassageProgramNodeManager instance = null;
    private static Object instanceLock = new Object();
    private EALManager ealManager;
    private INode2DText[][] nodes;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MassageProgramNodeManager getInstance(EALManager eALManager) {
        Object object = instanceLock;
        synchronized (object) {
            if (instance == null) {
                instance = new MassageProgramNodeManager(eALManager);
            } else if (eALManager != null && instance.getEalManager() != null && !instance.getEalManager().equals(eALManager)) {
                instance.setEalManager(eALManager);
            }
        }
        return instance;
    }

    private MassageProgramNodeManager(EALManager eALManager) {
        this.initialize(eALManager);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initialize(EALManager eALManager) {
        this.ealManager = eALManager;
        this.cleanUp();
        try {
            this.nodes = new INode2DText[2][];
            IProject iProject = eALManager.getProject();
            for (int i2 = 0; i2 < 2; ++i2) {
                this.nodes[i2] = new INode2DText[6];
                for (int i3 = 0; i3 < 6; ++i3) {
                    String string = "Program Slot " + i3;
                    INode2DText iNode2DText = new INode2DText(iProject, string, 16, "");
                    iNode2DText.setColor(EALManager.createColorCode(-1));
                    iNode2DText.setTranslation(0.0f, 29.0f);
                    iNode2DText.setVisible(true);
                    this.nodes[i2][i3] = iNode2DText;
                    String string2 = MASSAGE_TEXT_NODE_NAMES[i2][i3];
                    INode2D iNode2D = null;
                    try {
                        iNode2D = iProject.getNode2D(string2);
                        if (iNode2D != null && iNode2D.isValid()) {
                            iNode2D.add(iNode2DText);
                            continue;
                        }
                        throw new Exception("Failed to retrieve anchor node [" + string2 + "]");
                    }
                    finally {
                        if (iNode2D != null) {
                            iNode2D.dispose();
                        }
                    }
                }
            }
        }
        catch (Exception exception) {
            logChannel.log(10000, "MassageProgramNodeManager#<init> Failed to initialize slot nodes", (Throwable)exception);
            this.cleanUp();
        }
    }

    public EALManager getEalManager() {
        return this.ealManager;
    }

    public synchronized void setEalManager(EALManager eALManager) {
        this.initialize(eALManager);
    }

    public synchronized void updateNode(int n, int n2, String string, IWrappedFont iWrappedFont) {
        INode2DText iNode2DText;
        INode2DText[] iNode2DTextArray;
        if (this.nodes != null && n > -1 && n < this.nodes.length && (iNode2DTextArray = this.nodes[n]) != null && n2 > -1 && n2 < iNode2DTextArray.length && (iNode2DText = iNode2DTextArray[n2]) != null) {
            iWrappedFont.getFontGroup().activate();
            iNode2DText.setText(iWrappedFont.getSize(), string == null ? "" : string);
        }
    }

    private void cleanUp() {
        if (this.nodes != null) {
            for (int i2 = 0; i2 < this.nodes.length; ++i2) {
                INode2DText[] iNode2DTextArray = this.nodes[i2];
                if (iNode2DTextArray == null) continue;
                for (int i3 = 0; i3 < iNode2DTextArray.length; ++i3) {
                    INode2DText iNode2DText = iNode2DTextArray[i3];
                    if (iNode2DText == null) continue;
                    iNode2DText.dispose();
                    iNode2DTextArray[i3] = null;
                }
            }
            this.nodes = null;
        }
    }
}


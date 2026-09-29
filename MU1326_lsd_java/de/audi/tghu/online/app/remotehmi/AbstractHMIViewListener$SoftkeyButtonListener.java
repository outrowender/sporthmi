/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;

class AbstractHMIViewListener$SoftkeyButtonListener
implements ButtonListener {
    private final AbstractHMIViewListener hmiView;
    private final int[] modelIDs;
    private final int[] actionTypes = new int[]{103, 100, 101, 102};

    public AbstractHMIViewListener$SoftkeyButtonListener(AbstractHMIViewListener abstractHMIViewListener, int[] nArray) {
        this.hmiView = abstractHMIViewListener;
        this.modelIDs = nArray;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.modelIDs.length; ++i2) {
            if (n != this.modelIDs[i2]) continue;
            String string = this.getSelectedSkID(i2);
            this.hmiView.invokeSoftkeyAction(this.actionTypes[i2], string);
            break;
        }
    }

    public String getSelectedSkID(int n) {
        String string = "";
        String[] stringArray = this.hmiView.getSkIDs();
        if (stringArray != null && n >= 0 && n <= stringArray.length) {
            string = stringArray[n];
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}


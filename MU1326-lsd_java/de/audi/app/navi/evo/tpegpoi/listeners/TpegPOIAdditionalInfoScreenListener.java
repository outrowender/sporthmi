/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.listeners;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegScreenListener;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence;

public class TpegPOIAdditionalInfoScreenListener
extends AbstractTpegScreenListener
implements ButtonListener {
    private final TpegPOIDetailSequence sequence;

    public TpegPOIAdditionalInfoScreenListener(NavigationEnv navigationEnv, TpegPOIDetailSequence tpegPOIDetailSequence, int n) {
        super(navigationEnv);
        this.sequence = tpegPOIDetailSequence;
        this.initListener();
    }

    private void initListener() {
        this.env.getButtonModel(-1876752896).setButtonListener(this);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "%1#keyTyped(%2, %3) - ", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == -1876752896) {
            this.sequence.startWithNavLocation(this.env.getContainer().getSelectedLocation());
        } else {
            this.logChannel.log(-1601830656, "TpegPOIDetailScreenListener#keyTyped() - unexpected ModelID this shouldnt happen - implementation missing?");
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}


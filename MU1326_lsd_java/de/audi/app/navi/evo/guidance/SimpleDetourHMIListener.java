/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;

public class SimpleDetourHMIListener
implements ButtonListener,
ChoiceListener,
RangeListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private SimpleDetourHandler simpleDetourHandler;

    public SimpleDetourHMIListener(NavigationEnv navigationEnv, SimpleDetourHandler simpleDetourHandler) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.simpleDetourHandler = simpleDetourHandler;
        this.setupListeners();
    }

    private final void setupListeners() {
        this.env.getChoiceModel(400749).setChoiceListener(this);
        this.env.getButtonModel(400647).setButtonListener(this);
        this.env.getButtonModel(401570).setButtonListener(this);
        this.env.getRangeModel(400733).setRangeListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "SimpleDetourHMIListener#keyPressed( %1 )", (long)n);
        switch (n) {
            case 400647: {
                this.simpleDetourHandler.removeDetour(this.env.getContainer().isRgActive());
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401570: {
                if (this.env.getChoiceModel(400749).getValue() == 0) {
                    this.simpleDetourHandler.validateDetour();
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400749: {
                this.simpleDetourHandler.resetDetour();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400733: {
                this.simpleDetourHandler.blockRoute();
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(10000, "SimpleDetourHMIListener#keyPressed() - unhandled model: %1", (long)n);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "SimpleDetourHMIListener#itemSelected( %1 )", (long)n);
        switch (n) {
            case 400749: {
                this.simpleDetourHandler.removeDetour(this.env.getContainer().isRgActive());
                break;
            }
            default: {
                this.logChannel.log(10000, "SimpleDetourHMIListener#itemSelected() - unhandled model: %1", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void decrement(int n, int n2, int n3) {
        this.logChannel.log(10000000, "SimpleDetourHMIListener#decrement( %1 )", (long)n);
        switch (n) {
            case 400733: {
                this.simpleDetourHandler.decrementDetourLength(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "SimpleDetourHMIListener#decrement() - unhandled model: %1", (long)n);
            }
        }
    }

    public void increment(int n, int n2, int n3) {
        this.logChannel.log(10000000, "SimpleDetourHMIListener#increment( %1 )", (long)n);
        switch (n) {
            case 400733: {
                this.simpleDetourHandler.incrementDetourLength(n2);
                break;
            }
            default: {
                this.logChannel.log(10000, "SimpleDetourHMIListener#increment() - unhandled model: %1", (long)n);
            }
        }
    }
}


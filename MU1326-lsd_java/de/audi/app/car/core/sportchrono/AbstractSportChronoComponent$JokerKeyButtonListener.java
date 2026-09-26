/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.sportchrono;

import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent;
import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractSportChronoComponent$JokerKeyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractSportChronoComponent this$0;

    private AbstractSportChronoComponent$JokerKeyButtonListener(AbstractSportChronoComponent abstractSportChronoComponent) {
        this.this$0 = abstractSportChronoComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600977: {
                AbstractSportChronoComponent.access$000(this.this$0, "keyPressed", n, n2, true);
                break;
            }
            default: {
                AbstractSportChronoComponent.access$100(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (-1859450624 == n) {
            int n4 = AbstractSportChronoComponent.access$200(this.this$0, 395).getValue();
            switch (n4) {
                case 70: {
                    this.this$0.controlToggleStartStop();
                    break;
                }
                case 71: {
                    this.this$0.controlSetNewLap();
                    break;
                }
                default: {
                    AbstractSportChronoComponent.access$300(this.this$0, "keyReleased", n, n2, false);
                    break;
                }
            }
        } else {
            AbstractSportChronoComponent.access$400(this.this$0, "keyReleased", n, n2, false);
        }
    }

    /* synthetic */ AbstractSportChronoComponent$JokerKeyButtonListener(AbstractSportChronoComponent abstractSportChronoComponent, AbstractSportChronoComponent$1 abstractSportChronoComponent$1) {
        this(abstractSportChronoComponent);
    }
}


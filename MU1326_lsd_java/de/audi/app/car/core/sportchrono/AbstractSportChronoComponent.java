/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.sportchrono;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.sportchrono.AbstractDSICarStopWatchAdapter;
import de.audi.app.car.core.sportchrono.ISportChronoAccess;
import de.audi.app.car.core.sportchrono.ISportChronoControl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;

public abstract class AbstractSportChronoComponent
extends AbstractDSICarStopWatchAdapter
implements ISportChronoAccess,
ISportChronoControl {
    private final LocalMsgListener msgListener = new LocalMsgListener();

    public AbstractSportChronoComponent(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public String getName() {
        return "SportChrono";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    public String getCurrentViewOptions() {
        return "none";
    }

    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
    }

    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
        super.deinit();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.getApplication().getFrameworkAccess();
    }

    private class LocalMsgListener
    implements MsgListener {
        private LocalMsgListener() {
        }

        public void processMsg(int n) {
            if (79 == n) {
                ButtonModelApp buttonModelApp;
                int n2 = AbstractSportChronoComponent.this.getChoiceModel(395).getValue();
                if (70 == n2 && null != (buttonModelApp = AbstractSportChronoComponent.this.getButtonModel(600977))) {
                    buttonModelApp.setButtonListener(new JokerKeyButtonListener());
                }
                if (71 == n2 && null != (buttonModelApp = AbstractSportChronoComponent.this.getButtonModel(600977))) {
                    buttonModelApp.setButtonListener(new JokerKeyButtonListener());
                }
            }
        }
    }

    private class JokerKeyButtonListener
    extends DefaultButtonListener {
        private JokerKeyButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 600977: {
                    AbstractSportChronoComponent.this.logModelData("keyPressed", n, n2, true);
                    break;
                }
                default: {
                    AbstractSportChronoComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            if (600977 == n) {
                int n4 = AbstractSportChronoComponent.this.getChoiceModel(395).getValue();
                switch (n4) {
                    case 70: {
                        AbstractSportChronoComponent.this.controlToggleStartStop();
                        break;
                    }
                    case 71: {
                        AbstractSportChronoComponent.this.controlSetNewLap();
                        break;
                    }
                    default: {
                        AbstractSportChronoComponent.this.logModelData("keyReleased", n, n2, false);
                        break;
                    }
                }
            } else {
                AbstractSportChronoComponent.this.logModelData("keyReleased", n, n2, false);
            }
        }
    }
}


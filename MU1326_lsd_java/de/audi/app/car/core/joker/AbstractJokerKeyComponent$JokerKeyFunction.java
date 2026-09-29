/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.core.joker.AbstractJokerKeyComponent;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$CombiMFLHandler;
import de.audi.atip.hmi.model.ChoiceListener;

class AbstractJokerKeyComponent$JokerKeyFunction
implements ChoiceListener {
    int meaningModelID;
    int meaning;
    int selectionModelID;
    int menuEntryID;
    boolean visible = false;
    private final /* synthetic */ AbstractJokerKeyComponent this$0;

    public AbstractJokerKeyComponent$JokerKeyFunction(AbstractJokerKeyComponent abstractJokerKeyComponent, int n, int n2, int n3, int n4) {
        this.this$0 = abstractJokerKeyComponent;
        this.meaning = n;
        this.meaningModelID = n2;
        this.selectionModelID = n3;
        this.menuEntryID = n4;
    }

    public void initModel() {
        if (this.this$0.menuStyle == 0 && this.selectionModelID != -1) {
            AbstractJokerKeyComponent.access$400(this.this$0, this.selectionModelID).setChoiceListener(this);
        }
    }

    public void deinitModel() {
        if (this.this$0.menuStyle == 0 && this.selectionModelID != -1) {
            AbstractJokerKeyComponent.access$500(this.this$0, this.selectionModelID).resetListener();
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n2 == 1) {
            String string = "[AbstractJokerKeyComponent.JokerKeyFunction#itemSelected]";
            if (n == this.selectionModelID) {
                AbstractJokerKeyComponent.access$600(this.this$0, string, n, n2, true);
                if (this.meaning != AbstractJokerKeyComponent.access$300(this.this$0)) {
                    this.updateJokerKeyConfiguration();
                }
            } else {
                AbstractJokerKeyComponent.access$700(this.this$0, string, n, n2, false);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected void updateJokerKeyConfiguration() {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent.JokerKeyFunction#updateJokerKeyConfiguration] newJokerKeyFunction=%1", (long)this.meaning);
        this.activate();
        AbstractJokerKeyComponent$CombiMFLHandler.access$900(AbstractJokerKeyComponent.access$800(this.this$0), this.meaning);
    }

    public void activate() {
        if (this.this$0.menuStyle == 0) {
            AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = AbstractJokerKeyComponent.access$200(this.this$0, AbstractJokerKeyComponent.access$300(this.this$0));
            if (abstractJokerKeyComponent$JokerKeyFunction != null) {
                abstractJokerKeyComponent$JokerKeyFunction.deactivate();
            }
            if (this.selectionModelID != -1) {
                AbstractJokerKeyComponent.access$1000(this.this$0, this.selectionModelID).setValue(1);
            }
        }
        AbstractJokerKeyComponent.access$1102(this.this$0, -1);
        AbstractJokerKeyComponent.access$1200(this.this$0, this.meaningModelID).setValue(this.meaning);
        AbstractJokerKeyComponent.access$1300(this.this$0).getFrameworkAccess().getStorageMgr().setInt(1006, 10, this.meaning);
        AbstractJokerKeyComponent.access$1400(this.this$0).getFrameworkAccess().getMsgDistrib().sendMessage(79);
    }

    public void deactivate() {
        if (this.this$0.menuStyle == 0 && this.selectionModelID != -1) {
            AbstractJokerKeyComponent.access$1500(this.this$0, this.selectionModelID).setValue(0);
        }
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
        this.this$0.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent.JokerKeyFunction#setVisible] menuEntryID=%2, visible=%1", bl, (long)this.menuEntryID);
        this.updateMenuEntryVisiblity();
    }

    public boolean isVisible() {
        return this.visible;
    }

    private void updateMenuEntryVisiblity() {
        AbstractJokerKeyComponent.access$1600(this.this$0).getMenuEntryRegistry().updateMenuEntryVisibility(this.menuEntryID, this.visible ? 0 : 1);
    }
}


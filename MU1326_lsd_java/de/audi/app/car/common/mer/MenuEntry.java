/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.List;

public class MenuEntry
implements IMenuEntry {
    private final int menuEntryID;
    private static final int[] statePriority = new int[]{19, 0, 18, 17, 15, 16, 12, 14, 13, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private final String name;
    private final int modelId;
    private volatile IMenuEntry parent;
    private volatile IMenuEntry[] children;
    private volatile boolean registered = false;
    protected volatile int state;
    protected volatile int stateViewOptions = 1;
    protected volatile int stateMenuOperation = 0;
    private final IHMIServiceApp hmiService;
    protected final LogChannel logChannel;
    protected IMenuEntryRegistry menuEntryRegistry;
    private int[] functionalStateValues;

    public MenuEntry(int n, String string, int n2, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.menuEntryID = n;
        this.name = string;
        this.modelId = n2;
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.logChannel = logChannel;
    }

    public MenuEntry(int n, String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.menuEntryID = n;
        this.name = string;
        this.modelId = -1;
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.logChannel = logChannel;
    }

    public void setChildren(IMenuEntry[] iMenuEntryArray) {
        if (iMenuEntryArray != null) {
            if (this.logChannel.isInfo()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < iMenuEntryArray.length; ++i2) {
                    stringBuffer.append('\n');
                    stringBuffer.append(iMenuEntryArray[i2]);
                }
                this.logChannel.log(1000000, "[%1('%2')#setChildren] children=%3", (Object)this.getType(), (Object)this, (Object)stringBuffer);
            }
            for (int i3 = 0; i3 < iMenuEntryArray.length; ++i3) {
                iMenuEntryArray[i3].setParent(this);
            }
        }
        this.children = iMenuEntryArray;
    }

    public void setParent(IMenuEntry iMenuEntry) {
        this.parent = iMenuEntry;
    }

    public void init(IMenuEntryRegistry iMenuEntryRegistry) {
        this.logChannel.log(1000000, "[%1('%2')#init] called", (Object)this.getType(), (Object)this);
        this.menuEntryRegistry = iMenuEntryRegistry;
        this.setState(this.getInitialState());
    }

    public void deinit() {
        this.logChannel.log(1000000, "[%1('%2')#deinit] called", (Object)this.getType(), (Object)this);
    }

    public void notifyComponentsInitialized() {
    }

    public void register() {
        this.logChannel.log(1000000, "[%1('%2')#register] called", (Object)this.getType(), (Object)this);
        this.registered = true;
    }

    public void deregister() {
        this.logChannel.log(1000000, "[%1('%2')#deregister] called", (Object)this.getType(), (Object)this);
        this.registered = false;
        this.resetStates();
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public void updateState(int n) {
        this.logChannel.log(1000000, "[%1('%2')#updateState] state='%3'", (Object)this.getType(), (Object)this, (long)n);
        boolean bl = false;
        if (n != this.state) {
            if (this.children == null) {
                this.setState(n);
            } else if (statePriority[n] > statePriority[this.state]) {
                this.setState(n);
            } else {
                int n2;
                int n3;
                int[] nArray = new int[this.children.length];
                for (n3 = 0; n3 < this.children.length; ++n3) {
                    nArray[n3] = this.children[n3].getState();
                }
                n3 = MenuEntry.calculateMaxState(nArray);
                int n4 = n2 = statePriority[n] > statePriority[n3] ? n : n3;
                if (n2 != this.state) {
                    this.setState(n2);
                }
            }
            if (this.parent != null) {
                this.parent.updateState(this.state);
            } else {
                bl = true;
            }
        } else {
            bl = true;
        }
        if (this.menuEntryRegistry != null && bl) {
            this.menuEntryRegistry.stateUpdateForwardingTerminated();
        }
    }

    public static int calculateMaxState(int[] nArray) {
        int n = 1;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (statePriority[n] >= statePriority[nArray[i2]]) continue;
            n = nArray[i2];
        }
        return n;
    }

    protected void setState(int n) {
        this.logChannel.log(1000000, "[%1('%2')#setState] state='%3'", (Object)this.getType(), (Object)this, (long)n);
        this.state = n;
        this.setVisibilityModelStatus(n);
        this.setModelValue(n);
        if (this.menuEntryRegistry != null) {
            this.menuEntryRegistry.notifyStateChange(this);
        }
    }

    private void setVisibilityModelStatus(int n) {
        if (this.functionalStateValues != null) {
            int n2 = 0;
            if (n > 1) {
                for (int i2 = 0; i2 < this.functionalStateValues.length; ++i2) {
                    int n3 = this.functionalStateValues[i2];
                    if (n3 != n) continue;
                    n2 = 1;
                    break;
                }
            }
            this.logChannel.log(1000000, "[%1('%2')#setVisibilityModelStatus] MenuEntry is %3: VisibilityChoiceModel.setStatus('%4')", (Object)this.getType(), (Object)this, (Object)(n2 == 1 ? "functional" : "not functional"), (long)n2);
            this.setModelSatus(n2);
        }
    }

    public int getState() {
        return this.state;
    }

    public boolean isTop() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.children == null;
    }

    public String toString() {
        return this.name;
    }

    public IMenuEntry getParent() {
        return this.parent;
    }

    public IMenuEntry[] getChildren() {
        return this.children;
    }

    public int getModelID() {
        return this.modelId;
    }

    public int getID() {
        return this.menuEntryID;
    }

    public boolean isRegistrable() {
        return this.isLeaf();
    }

    public void addChildrenToListRecursively(List list) {
        if (this.getChildren() != null) {
            IMenuEntry[] iMenuEntryArray = this.getChildren();
            for (int i2 = 0; i2 < iMenuEntryArray.length; ++i2) {
                IMenuEntry iMenuEntry = iMenuEntryArray[i2];
                list.add(iMenuEntry);
                iMenuEntry.addChildrenToListRecursively(list);
            }
        }
    }

    public boolean isType(MenuEntryType menuEntryType) {
        return this.getType().equalsMenuEntryType(menuEntryType);
    }

    public MenuEntryType getType() {
        return MenuEntryType.MENU_ENTRY;
    }

    public int getInitialState() {
        return 1;
    }

    public void setFunctionalStateValues(int[] nArray) {
        this.functionalStateValues = nArray;
    }

    private void setModelValue(int n) {
        ChoiceModelApp choiceModelApp;
        if (this.getModelID() != -1 && (choiceModelApp = this.hmiService.getChoiceModel(this.getModelID())) != null) {
            choiceModelApp.setValue(n);
        }
    }

    private void setModelSatus(int n) {
        ChoiceModelApp choiceModelApp;
        if (this.getModelID() != -1 && (choiceModelApp = this.hmiService.getChoiceModel(this.getModelID())) != null) {
            choiceModelApp.setStatus(n);
        }
    }

    public void updateStateViewOptions(int n) {
        this.logChannel.log(1000000, "[%1('%2')#updateStateViewOptions] state='%3'", (Object)this.getType(), (Object)this, (long)this.state);
        if (this.getStateViewOptions() != n) {
            this.setStateViewOptions(n);
            this.combineStates();
        }
    }

    public void updateStateMenuOperation(int n) {
        this.logChannel.log(1000000, "[%1('%2')#updateStateMenuOpteration] state='%3'", (Object)this.getType(), (Object)this, (long)this.state);
        if (this.isValidStateMenuOperation(n)) {
            if (this.getStateMenuOperation() != n) {
                this.setStateMenuOperation(n);
                this.combineStates();
            }
        } else {
            this.logChannel.log(10000, "[%1('%2')#updateStateMenuOpteration] Received state is not a valid menu operation state: state='%3'", (Object)this.getType(), (Object)this, (long)this.state);
        }
    }

    private boolean isValidStateMenuOperation(int n) {
        return n == 0 || n == 3 || n == 4 || n == 6;
    }

    private void combineStates() {
        if (this.stateViewOptions == 1 || this.getStateMenuOperation() == 0) {
            this.updateState(this.getStateViewOptions());
        } else {
            this.updateState(this.getStateMenuOperation());
        }
    }

    private void resetStates() {
        this.setStateViewOptions(1);
        this.setStateMenuOperation(0);
    }

    private int getStateViewOptions() {
        return this.stateViewOptions;
    }

    protected void setStateViewOptions(int n) {
        this.stateViewOptions = n;
    }

    private int getStateMenuOperation() {
        return this.stateMenuOperation;
    }

    private void setStateMenuOperation(int n) {
        this.stateMenuOperation = n;
    }

    public int getStateViewOptionsForRegistration() {
        return 2;
    }
}


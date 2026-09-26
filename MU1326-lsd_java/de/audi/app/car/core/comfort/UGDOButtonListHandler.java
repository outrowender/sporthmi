/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.IUGDOLearningHandler;
import de.audi.app.car.core.comfort.UGDOButtonData;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public class UGDOButtonListHandler {
    private static final int NOT_INITIALIZED;
    private final LogChannel logChannel;
    private final IUGDOComponent ugdoComponent;
    private final IUGDOLearningHandler ugdoLearningHandler;
    private volatile int totalNumberOfListElements = -1;
    private volatile int currentTransactionID = -1;
    private volatile ArrayList receivedData;

    public UGDOButtonListHandler(IUGDOComponent iUGDOComponent, IUGDOLearningHandler iUGDOLearningHandler, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.ugdoComponent = iUGDOComponent;
        this.ugdoLearningHandler = iUGDOLearningHandler;
        this.receivedData = iUGDOComponent.getInternalButtonList();
    }

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        int n = this.calcTransactionID(uGDOButtonListUpdateInfo.getTransactionID());
        switch (uGDOButtonListUpdateInfo.getArrayContent()) {
            case 1: {
                this.currentTransactionID = uGDOButtonListUpdateInfo.transactionID = n;
                this.handleRequestArrayContentAll(uGDOButtonListUpdateInfo);
                break;
            }
            case 4: {
                this.currentTransactionID = uGDOButtonListUpdateInfo.transactionID = n;
                uGDOButtonListUpdateInfo.arrayContent = 1;
                this.handleRequestArrayContentOnlyChanges(uGDOButtonListUpdateInfo);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "ArrayContent %1 not suppported yet.", (long)uGDOButtonListUpdateInfo.getArrayContent());
            }
        }
    }

    public void updateUGDOButtonListTotalNumberOfElements(int n) {
        this.totalNumberOfListElements = n;
    }

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.handleResponseArrayContentAll(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.handleResponseArrayContentOnlyChangesRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA0] arrayContent(%1) not supported yet.", (long)uGDOButtonListUpdateInfo.getArrayContent());
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA0] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA1] arrayContent(UGDOARRAYCONTENT_ALL) %1", (Object)uGDOButtonListUpdateInfo);
                this.receivedData.clear();
                for (int i2 = 0; i2 < uGDOButtonListRA1Array.length; ++i2) {
                    UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA1Array[i2].getPos(), uGDOButtonListRA1Array[i2].getLearnedState());
                    this.receivedData.add(uGDOButtonData);
                }
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA1] arrayContent(UGDOARRAYCONTENT_ONLY_CHANGES) %1", (Object)uGDOButtonListUpdateInfo);
                this.handleResponseArrayContentOnlyChangesRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA1] arrayContent(%1) not supported yet.", (long)uGDOButtonListUpdateInfo.getArrayContent());
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA1] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA2] arrayContent(UGDOARRAYCONTENT_ALL) %1", (Object)uGDOButtonListUpdateInfo);
                this.receivedData.clear();
                for (int i2 = 0; i2 < uGDOButtonListRA2Array.length; ++i2) {
                    UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA2Array[i2].getPos(), uGDOButtonListRA2Array[i2].getLearnedState());
                    this.receivedData.add(uGDOButtonData);
                }
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA2] arrayContent(UGDOARRAYCONTENT_ONLY_CHANGES) %1", (Object)uGDOButtonListUpdateInfo);
                this.handleResponseArrayContentOnlyChangesRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA2] arrayContent %1 not supported.");
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA2] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA3] arrayContent(UGDOARRAYCONTENT_ALL) %1", (Object)uGDOButtonListUpdateInfo);
                this.receivedData.clear();
                for (int i2 = 0; i2 < uGDOButtonListRA3Array.length; ++i2) {
                    UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA3Array[i2].getPos());
                    this.receivedData.add(uGDOButtonData);
                }
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA3] arrayContent(UGDOARRAYCONTENT_ONLY_CHANGES) %1", (Object)uGDOButtonListUpdateInfo);
                this.handleResponseArrayContentOnlyChangesRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA3] arrayContent %1 not supported.");
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA3] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA4] arrayContent(UGDOARRAYCONTENT_ALL) %1", (Object)uGDOButtonListUpdateInfo);
                this.receivedData.clear();
                for (int i2 = 0; i2 < uGDOButtonListRA4Array.length; ++i2) {
                    UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA4Array[i2].getPos(), uGDOButtonListRA4Array[i2].getName());
                    this.receivedData.add(uGDOButtonData);
                }
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA4] arrayContent(UGDOARRAYCONTENT_ONLY_CHANGES) %1", (Object)uGDOButtonListUpdateInfo);
                this.handleResponseArrayContentOnlyChangesRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA4] arrayContent(%1) not supported yet.", (long)uGDOButtonListUpdateInfo.getArrayContent());
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA4] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        if (uGDOButtonListUpdateInfo.getTransactionID() == this.currentTransactionID) {
            if (uGDOButtonListUpdateInfo.arrayContent == 1) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA5] arrayContent(UGDOARRAYCONTENT_ALL) %1", (Object)uGDOButtonListUpdateInfo);
                this.receivedData.clear();
                for (int i2 = 0; i2 < uGDOButtonListRA5Array.length; ++i2) {
                    UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA5Array[i2].getPos(), uGDOButtonListRA5Array[i2].getLearnedState());
                    this.receivedData.add(uGDOButtonData);
                }
            } else if (uGDOButtonListUpdateInfo.arrayContent == 4) {
                this.logChannel.log(1078071040, "[UGDOButtonListHandler#responseUGDOButtonListRA5] arrayContent(UGDOARRAYCONTENT_ONLY_CHANGES) %1", (Object)uGDOButtonListUpdateInfo);
                this.handleResponseArrayContentOnlyChangesRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
            } else {
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA5] arrayContent(%1) not supported yet.", (long)uGDOButtonListUpdateInfo.getArrayContent());
                return;
            }
            this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
            this.ugdoLearningHandler.startLearningButtonFixkitDefaultMode();
        } else {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#responseUGDOButtonListRA5] Transaction id does not match.");
        }
    }

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        if (uGDOButtonListUpdateInfo.getArrayContent() == 5 && uGDOButtonListUpdateInfo.getRecordContent() == 15 && uGDOButtonListUpdateInfo.getTransactionID() == 0) {
            int n = uGDOButtonListUpdateInfo.getStartElement();
            int n2 = uGDOButtonListUpdateInfo.getNumOfElements();
            Iterator iterator = this.receivedData.iterator();
            while (iterator.hasNext()) {
                UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
                for (int i2 = n; i2 < n2; ++i2) {
                    if (uGDOButtonData.getPos() != nArray[i2]) continue;
                    this.receivedData.remove(uGDOButtonData);
                }
            }
        } else if (uGDOButtonListUpdateInfo.getArrayContent() == 6 && uGDOButtonListUpdateInfo.getRecordContent() == 15 && uGDOButtonListUpdateInfo.getTransactionID() == 0) {
            uGDOButtonListUpdateInfo.arrayContent = 1;
            uGDOButtonListUpdateInfo.recordContent = 0;
            uGDOButtonListUpdateInfo.startElement = 0;
            uGDOButtonListUpdateInfo.transactionID = this.calcTransactionID(uGDOButtonListUpdateInfo.getTransactionID());
            this.handleRequestArrayContentAll(uGDOButtonListUpdateInfo);
        }
        this.logChannel.log(1078071040, "Internal list output: %1", (Object)this.receivedData);
    }

    private void handleRequestArrayContentAll(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        this.setNumOfElements(uGDOButtonListUpdateInfo);
        this.logChannel.log(1078071040, "[UGDOButtonListHandler#handleRequestArrayContentAll] dsi.requestUGDOButtonList(currentUpdateInfo=%1)", (Object)uGDOButtonListUpdateInfo);
        this.ugdoComponent.getDSILogChannel().log(1078071040, "[dsi.requestUGDOButtonList(currentUpdateInfo=%1)]", (Object)uGDOButtonListUpdateInfo);
        this.ugdoComponent.getDSICarComfort().requestUGDOButtonList(uGDOButtonListUpdateInfo);
    }

    private void handleRequestArrayContentOnlyChanges(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        this.setNumOfElements(uGDOButtonListUpdateInfo);
        this.logChannel.log(1078071040, "[UGDOButtonListHandler#handleRequestArrayContentOnlyChanges] dsi.requestUGDOButtonList(currentUpdateInfo=%1)", (Object)uGDOButtonListUpdateInfo);
        this.ugdoComponent.getDSILogChannel().log(1078071040, "[dsi.requestUGDOButtonList(currentUpdateInfo=%1)]", (Object)uGDOButtonListUpdateInfo);
        this.ugdoComponent.getDSICarComfort().requestUGDOButtonList(uGDOButtonListUpdateInfo);
    }

    private void setNumOfElements(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        int n = this.getTransmittableElementsForRA(uGDOButtonListUpdateInfo.getRecordContent());
        if (n != -1) {
            uGDOButtonListUpdateInfo.numOfElements = n;
        }
        uGDOButtonListUpdateInfo.asgID = 1;
    }

    private void handleResponseArrayContentAll(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.receivedData.clear();
        for (int i2 = 0; i2 < uGDOButtonListRA0Array.length; ++i2) {
            UGDOButtonData uGDOButtonData = new UGDOButtonData(uGDOButtonListRA0Array[i2].getPos(), uGDOButtonListRA0Array[i2].getName(), uGDOButtonListRA0Array[i2].getLearnedState(), uGDOButtonListRA0Array[i2].getHardkey(), uGDOButtonListRA0Array[i2].getSoftkey());
            this.receivedData.add(uGDOButtonData);
        }
        if (uGDOButtonListRA0Array.length < this.totalNumberOfListElements) {
            this.logChannel.log(1078071040, "[UGDOButtonListHandler#handleResponseArrayContentAll] data are splitted: data:%1 totalNumberOfList: %2", (long)uGDOButtonListRA0Array.length, (long)this.totalNumberOfListElements);
            uGDOButtonListUpdateInfo.startElement = uGDOButtonListRA0Array.length + 1;
            uGDOButtonListUpdateInfo.transactionID = this.currentTransactionID = this.calcTransactionID(uGDOButtonListUpdateInfo.getTransactionID());
            uGDOButtonListUpdateInfo.numOfElements = this.totalNumberOfListElements;
            this.handleRequestArrayContentAll(uGDOButtonListUpdateInfo);
        }
    }

    private void handleResponseArrayContentOnlyChangesRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(0, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA0Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA0Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA0Array[i2].pos) continue;
                uGDOButtonData.setName(uGDOButtonListRA0Array[i2].getName());
                uGDOButtonData.setLearnedState(uGDOButtonListRA0Array[i2].getLearnedState());
                uGDOButtonData.setSoftkey(uGDOButtonListRA0Array[i2].getSoftkey());
                uGDOButtonData.setHardkey(uGDOButtonListRA0Array[i2].getHardkey());
            }
        }
    }

    private void handleResponseArrayContentOnlyChangesRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(1, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA1Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA1Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA1Array[i2].pos) continue;
                uGDOButtonData.setLearnedState(uGDOButtonListRA1Array[i2].getLearnedState());
            }
        }
    }

    private void handleResponseArrayContentOnlyChangesRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(2, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA2Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA2Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA2Array[i2].pos) continue;
                uGDOButtonData.setLearnedState(uGDOButtonListRA2Array[i2].getLearnedState());
            }
        }
    }

    private void handleResponseArrayContentOnlyChangesRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(3, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA3Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA3Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA3Array[i2].pos) continue;
                this.logChannel.log(-1601830656, "[UGDOButtonListHandler#handleResponseArrayContentOnlyChangesRA3: unhandled data");
            }
        }
    }

    private void handleResponseArrayContentOnlyChangesRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(4, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA4Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA4Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA4Array[i2].pos) continue;
                uGDOButtonData.setName(uGDOButtonListRA4Array[i2].getName());
            }
        }
    }

    private void handleResponseArrayContentOnlyChangesRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        int n;
        int n2 = uGDOButtonListUpdateInfo.getStartElement();
        if (this.isOutOfRange(5, n2, n = uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListRA5Array.length)) {
            return;
        }
        Iterator iterator = this.receivedData.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            for (int i2 = 0; i2 < uGDOButtonListRA5Array.length; ++i2) {
                if (uGDOButtonData.getPos() != uGDOButtonListRA5Array[i2].pos) continue;
                uGDOButtonData.setLearnedState(uGDOButtonListRA5Array[i2].getLearnedState());
            }
        }
    }

    private boolean isOutOfRange(int n, int n2, int n3, int n4) {
        if (n2 < 0) {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#handleResponseArrayContentOnlyChanges%1: startElement out of range: %2 %3 -> No change of list] ", (long)n, (long)n2, (long)this.receivedData.size());
            return true;
        }
        if (n4 < n3) {
            this.logChannel.log(-1601830656, "[UGDOButtonListHandler#handleResponseArrayContentOnlyChanges%1: data[].length %2 smaller getNumOfElement() %3 -> No change of list] ", (long)n, (long)n4, (long)n3);
            return true;
        }
        return false;
    }

    private int calcTransactionID(int n) {
        int n2;
        return (n2 = ++n % 16) == 0 ? 1 : n2;
    }

    private int getTransmittableElementsForRA(int n) {
        UGDOViewOptions uGDOViewOptions = this.ugdoComponent.getCurrentViewOptionsObject();
        if (uGDOViewOptions == null || uGDOViewOptions.getConfiguration() == null) {
            return -1;
        }
        switch (n) {
            case 0: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa0();
            }
            case 1: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa1();
            }
            case 2: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa2();
            }
            case 3: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa3();
            }
            case 4: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa4();
            }
            case 5: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRa5();
            }
            case 15: {
                return uGDOViewOptions.getConfiguration().getButtonListTransmittableElements().getRaF();
            }
        }
        return 0;
    }
}


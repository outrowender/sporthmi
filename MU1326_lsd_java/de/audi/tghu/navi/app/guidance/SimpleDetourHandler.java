/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.command.block.BlockRouteBasedOnLengthCommand;
import de.audi.tghu.navi.app.command.block.DeleteBlockCommand;
import de.audi.tghu.navi.app.command.block.IWaitForBlockingAvailableListener;
import de.audi.tghu.navi.app.command.block.WaitForBlockingAvailableCommand;
import de.audi.tghu.navi.app.guidance.ISimpleDetourModelAccess;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler$1;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.navigation.BlockElement;

public class SimpleDetourHandler {
    private ICommandListFactory commandListFactory;
    private final LogChannel logChannel;
    private ISimpleDetourModelAccess simpleDetourModelAccess;
    private OperationManager operationManager;
    private IRouteManager routeManager;
    private long detourUid;
    private int detourLength;
    private int lengthIdx;
    private int[] availableLengths;
    private static final int[] availableLengthsMetric = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000, 20000};
    private static final int[] availableLengthsImperial = new int[]{161, 322, 483, 644, 805, 966, 1127, 1287, 1448, 1609, 3219, 4828, 6437, 8047, 9656, 11265, 12875, 14484, 16093, 17703, 19312, 20921, 22531, 24140, 25750, 27359, 28968, 30578, 32187};
    private static final String BLOCK_TRAFFIC_AHEAD;
    private static final int INVALID;
    private BlockElement[] blocks = new BlockElement[0];
    private volatile boolean isBlockingPossible = true;
    private int maxLengthBlockRouteBasedOnLength = -1;
    private boolean isDeleteBlockingsAtStartup = false;
    private List blockAvailableListeners;

    public SimpleDetourHandler(LogChannel logChannel, ICommandListFactory iCommandListFactory, ISimpleDetourModelAccess iSimpleDetourModelAccess, OperationManager operationManager, IRouteManager iRouteManager) {
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.simpleDetourModelAccess = iSimpleDetourModelAccess;
        this.operationManager = operationManager;
        this.routeManager = iRouteManager;
        this.blockAvailableListeners = new ArrayList();
        this.doInitAvailableLengths();
        this.resetDetour();
        iSimpleDetourModelAccess.updateBlockingAvailable(this.isBlockingPossible);
        iSimpleDetourModelAccess.reset(this.detourLength);
    }

    public void unitsChanged() {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#unitsChanged() ");
        this.initAvailableLengths();
    }

    public void updateRgActive(boolean bl) {
        this.logChannel.log(14808325, "SimpleDetourHandler#updateRgActive( %1 ) ", bl);
        if (this.operationManager.isFullyOperable()) {
            if (!bl && this.detourUid != -1L) {
                this.removeDetour(bl);
            }
        } else {
            this.logChannel.log(-2137614336, "SimpleDetourHandler#updateRgActive() - navigation not operable, removing of detour is disabled");
        }
    }

    public void toggleDetour() {
        if (this.detourUid == -1L) {
            this.blockRoute();
        } else {
            this.resetDetour();
        }
    }

    public final void resetDetour() {
        this.detourLength = 0;
        this.lengthIdx = 0;
        this.detourUid = -1L;
        this.doValidateDetour();
    }

    public void removeDetour(boolean bl) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#removeDetour()");
        if (bl) {
            this.deleteBlock(this.detourUid);
        } else {
            this.resetDeleteBlockingsAtStartup();
        }
        this.simpleDetourModelAccess.detourAdded(false);
        this.lengthIdx = -1;
    }

    private void initAvailableLengths() {
        this.doInitAvailableLengths();
    }

    private final void doInitAvailableLengths() {
        this.availableLengths = Util.getCurrentMetricsSystem(false) != 2 ? availableLengthsImperial : availableLengthsMetric;
        this.doValidateDetour();
    }

    public void validateDetour() {
        this.doValidateDetour();
    }

    private final void doValidateDetour() {
        if (this.lengthIdx < 0) {
            this.lengthIdx = 0;
        }
        if (this.lengthIdx >= this.availableLengths.length) {
            this.lengthIdx = this.availableLengths.length - 1;
        }
        this.detourLength = this.availableLengths[this.lengthIdx];
        this.simpleDetourModelAccess.refreshDistanceTextfield(this.detourLength);
    }

    private int getDetourLength() {
        return this.detourLength;
    }

    public void incrementDetourLength(int n) {
        this.lengthIdx += n;
        this.validateDetour();
    }

    public void decrementDetourLength(int n) {
        this.lengthIdx -= n;
        this.validateDetour();
    }

    public void blockRoute() {
        int n = this.getDetourLength();
        int n2 = this.routeManager.getTripDataAuto().distanceToFinalDestination;
        this.logChannel.log(-2137614336, "SimpleDetourHandler#blockRoute() - offset: %1, length: %2", (long)n2, (long)n);
        this.blockRouteBasedOnLength(n2, n);
    }

    private void updateDetourInfo(boolean bl, long l) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#updateDetourInfo( %1, %2)", bl, l);
        if (bl) {
            this.detourUid = l;
            this.simpleDetourModelAccess.detourAdded(true);
        } else {
            this.detourUid = -1L;
            this.simpleDetourModelAccess.detourAdded(false);
        }
    }

    public boolean isLimitedLengthBlockRouteBasedOnLength() {
        return this.maxLengthBlockRouteBasedOnLength != -1;
    }

    public boolean isBlockingPossible() {
        return this.isBlockingPossible;
    }

    public BlockElement[] getBlocks() {
        return this.blocks;
    }

    public boolean isBlockUidAvailable(long l) {
        for (int i2 = 0; i2 < this.blocks.length; ++i2) {
            if (this.blocks[i2].getUid() != l) continue;
            return true;
        }
        return false;
    }

    public boolean blockRouteExt(int n, int n2) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#blockRouteExt( %1, %2 )", (long)n, (long)n2);
        this.simpleDetourModelAccess.refreshDistanceTextfield(n2);
        if (n2 > this.maxLengthBlockRouteBasedOnLength) {
            n2 = this.maxLengthBlockRouteBasedOnLength;
        }
        return this.blockRouteBasedOnLength(n, n2);
    }

    private boolean blockRouteBasedOnLength(int n, int n2) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#blockRouteBasedOnLength( %1, %2 )", (long)n, (long)n2);
        boolean bl = false;
        this.resetDeleteBlockingsAtStartup();
        if (!this.isLimitedLengthBlockRouteBasedOnLength() || this.maxLengthBlockRouteBasedOnLength >= n2) {
            bl = true;
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new WaitForBlockingAvailableCommand(this, false));
            commandList.add(new BlockRouteBasedOnLengthCommand(n, n2));
            commandList.add(new SimpleDetourHandler$1(this, "SimpleDetourHandler#blockRouteBasedOnLength_SetBlockDescription_Persist"));
            commandList.execute("SimpleDetourHandler#blockRouteBasedOnLength");
        } else {
            this.logChannel.log(10000, "SimpleDetourHandler#blockRouteBasedOnLength() - unable to block, segment too large!");
        }
        return bl;
    }

    public void deleteBlockRouteBasedOnLength() {
        for (int i2 = 0; i2 < this.blocks.length; ++i2) {
            if (!"@@TRAFFIC_AHEAD@@".equals(this.blocks[i2].getDescription())) continue;
            this.deleteBlock(this.blocks[i2].getUid());
        }
    }

    public void deleteBlock(long l) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#deleteBlock( %1 )", l);
        this.resetDeleteBlockingsAtStartup();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new WaitForBlockingAvailableCommand(this, false));
        commandList.add(new DeleteBlockCommand(this, l));
        commandList.execute("SimpleDetourHandler#deleteBlock");
    }

    public void deleteAllBlocks() {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#deleteAllBlocks()");
        this.resetDeleteBlockingsAtStartup();
        CommandList commandList = this.commandListFactory.createCommandList();
        for (int i2 = 0; i2 < this.blocks.length; ++i2) {
            commandList.add(new WaitForBlockingAvailableCommand(this, false));
            commandList.add(new DeleteBlockCommand(this, this.blocks[i2].getUid()));
        }
        commandList.execute("SimpleDetourHandler#deleteAllBlocks");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDeleteBlockingsAtStartup() {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#setDeleteBlockingsAtStartup()");
        SimpleDetourHandler simpleDetourHandler = this;
        synchronized (simpleDetourHandler) {
            this.isDeleteBlockingsAtStartup = true;
        }
        this.triggerDeleteBlocksAtStartup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void resetDeleteBlockingsAtStartup() {
        SimpleDetourHandler simpleDetourHandler = this;
        synchronized (simpleDetourHandler) {
            this.isDeleteBlockingsAtStartup = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void triggerDeleteBlocksAtStartup() {
        if (this.blocks.length > 0) {
            SimpleDetourHandler simpleDetourHandler = this;
            synchronized (simpleDetourHandler) {
                if (this.isDeleteBlockingsAtStartup) {
                    this.logChannel.log(-2137614336, "SimpleDetourHandler#triggerDeleteBlocksAtStartup() - assuming startup, deleting all blocks");
                    this.deleteAllBlocks();
                    this.isDeleteBlockingsAtStartup = false;
                }
            }
        }
    }

    public void updateListOfBlocks(BlockElement[] blockElementArray) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#updateListOfBlocks()");
        BlockElement[] blockElementArray2 = blockElementArray;
        if (blockElementArray2 == null) {
            blockElementArray2 = new BlockElement[]{};
        }
        if (this.blocks == null) {
            this.blocks = new BlockElement[0];
        }
        ArrayList arrayList = new ArrayList(blockElementArray2.length);
        ArrayList arrayList2 = new ArrayList(this.blocks.length);
        this.computeDeltaLists(this.blocks, blockElementArray2, arrayList, arrayList2);
        this.propagateBlockInfo(arrayList, true);
        this.propagateBlockInfo(arrayList2, false);
        this.blocks = blockElementArray2;
        this.triggerDeleteBlocksAtStartup();
    }

    public void updateNaviCoreAvailableToSetBlocks(int n) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#updateNaviCoreAvailableToSetBlocks( %1 )", (long)n);
        this.isBlockingPossible = n == 0;
        this.simpleDetourModelAccess.updateBlockingAvailable(this.isBlockingPossible);
        this.updateBlockedAvailableListener(this.isBlockingPossible);
    }

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#updateMaximumLengthOfBlockRouteBasedOnLength( %1 )", (long)n);
        this.maxLengthBlockRouteBasedOnLength = n;
    }

    private void propagateBlockInfo(List list, boolean bl) {
        this.logChannel.log(-2137614336, "SimpleDetourHandler#propagateBlockInfo()");
        boolean bl2 = false;
        long l = -1L;
        block3: for (int i2 = 0; i2 < list.size(); ++i2) {
            BlockElement blockElement = (BlockElement)list.get(i2);
            this.logChannel.log(-2137614336, "SimpleDetourHandler#propagateBlockInfo() - found block element %1", (Object)blockElement);
            switch (blockElement.getType()) {
                case 3: {
                    if (!"@@TRAFFIC_AHEAD@@".equals(blockElement.getDescription())) continue block3;
                    bl2 = true;
                    l = blockElement.getUid();
                    continue block3;
                }
                default: {
                    this.logChannel.log(10000, "SimpleDetourHandler#propagateBlocks() - current block type %1 not supported!", (long)blockElement.getType());
                }
            }
        }
        if (bl2) {
            this.updateDetourInfo(bl, l);
        }
    }

    private boolean blockPropertiesChanged(BlockElement blockElement, BlockElement blockElement2) {
        return blockElement.getUid() == blockElement2.getUid() && blockElement.getType() == blockElement2.getType() && (!blockElement.getDescription().equals(blockElement2.getDescription()) || blockElement.getDistanceToDestination() != blockElement2.getDistanceToDestination() || blockElement.isOnRoute() != blockElement2.isOnRoute() || blockElement.isPersistent() != blockElement2.isPersistent());
    }

    private void computeDeltaLists(BlockElement[] blockElementArray, BlockElement[] blockElementArray2, List list, List list2) {
        int n;
        for (n = 0; n < blockElementArray2.length; ++n) {
            list.add(blockElementArray2[n]);
        }
        for (n = 0; n < blockElementArray.length; ++n) {
            list2.add(blockElementArray[n]);
        }
        Iterator iterator = list.iterator();
        block2: while (iterator.hasNext()) {
            BlockElement blockElement = (BlockElement)iterator.next();
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                BlockElement blockElement2 = (BlockElement)iterator2.next();
                if (blockElement.getUid() != blockElement2.getUid()) continue;
                iterator2.remove();
                if (this.blockPropertiesChanged(blockElement, blockElement2)) continue block2;
                iterator.remove();
                continue block2;
            }
        }
        this.logChannel.log(-2137614336, "SimpleDetourHandler#computeDeltaLists() -   added blocks: %1", (Object)list);
        this.logChannel.log(-2137614336, "SimpleDetourHandler#computeDeltaLists() - removed blocks: %1", (Object)list2);
    }

    public void registerAsListener(IWaitForBlockingAvailableListener iWaitForBlockingAvailableListener) {
        this.blockAvailableListeners.add(iWaitForBlockingAvailableListener);
    }

    public void derigisterAsListener(IWaitForBlockingAvailableListener iWaitForBlockingAvailableListener) {
        this.blockAvailableListeners.remove(iWaitForBlockingAvailableListener);
    }

    private void updateBlockedAvailableListener(boolean bl) {
        for (int i2 = 0; i2 < this.blockAvailableListeners.size(); ++i2) {
            IWaitForBlockingAvailableListener iWaitForBlockingAvailableListener = (IWaitForBlockingAvailableListener)this.blockAvailableListeners.get(i2);
            this.logChannel.log(-2137614336, "SimpleDetourHandler#updateBlockedAvailableListener() - notify : %1 with %2", (Object)Util.getClassNameFromPackageName(super.getClass()), (Object)String.valueOf(bl));
            iWaitForBlockingAvailableListener.updateBlockingAvailable(bl);
        }
    }

    static /* synthetic */ ICommandListFactory access$000(SimpleDetourHandler simpleDetourHandler) {
        return simpleDetourHandler.commandListFactory;
    }
}


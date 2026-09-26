.version 50 0 
.class public super [65] 
.super [67] 
.field private [68] [69] 

.method public [71] : [72] 
    .attribute [70] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     aload 4 
L5:     invokespecial [15] 
L8:     aload_0 
L9:     iload_2 
L10:    putfield [16] 
L13:    aload_1 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    invokevirtual [11] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [70] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [10] 
L12:    i2l 
L13:    invokevirtual [13] 
L16:    pop 
L17:    aload_0 
L18:    getfield [14] 
L21:    aload_0 
L22:    getfield [10] 
L25:    bipush 10 
L27:    invokeinterface [17] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [18] 
.const [4] = Int -2137614336 
.const [5] = String [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Class [22] 
.const [9] = Class [23] 
.const [10] = Field [24] [25] 
.const [11] = Method [26] [27] 
.const [12] = Field [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Field [32] [33] 
.const [15] = Method [34] [35] 
.const [16] = Field [36] [37] 
.const [17] = InterfaceMethod [38] [39] 
.const [18] = Utf8 'OnlineSearchNextOrPreviousResultsCommand#OnlineSearchNextOrPreviousResultsCommand()' 
.const [19] = Utf8 'OnlineSearchNextOrPreviousResultsCommand#execute() Requesting results from index : %1' 
.const [20] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [21] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [22] = Utf8 de/audi/atip/log/LogChannel 
.const [23] = Utf8 org/dsi/ifc/online/DSIPoiOnlineSearch 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [41] = Utf8 indexOfFirstItem 
.const [42] = Utf8 I 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 log 
.const [45] = Utf8 (ILjava/lang/String;)Z 
.const [46] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [47] = Utf8 logger 
.const [48] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 log 
.const [51] = Utf8 (ILjava/lang/String;J)Z 
.const [52] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [53] = Utf8 dsiOnlineSearch 
.const [54] = Utf8 Lorg/dsi/ifc/online/DSIPoiOnlineSearch; 
.const [55] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [56] = Utf8 <init> 
.const [57] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm;Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext;)V 
.const [58] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [59] = Utf8 indexOfFirstItem 
.const [60] = Utf8 I 
.const [61] = Utf8 org/dsi/ifc/online/DSIPoiOnlineSearch 
.const [62] = Utf8 poiRequestValueList 
.const [63] = Utf8 (II)V 
.const [64] = Utf8 de/audi/tghu/navi/app/command/poi/online/OnlineSearchNextOrPreviousResultsCommand 
.const [65] = Class [64] 
.const [66] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [67] = Class [66] 
.const [68] = Utf8 indexOfFirstItem 
.const [69] = Utf8 I 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/tghu/navi/app/poi/online/IOnlineSearchForm;Lde/audi/tghu/navi/app/poi/online/OnlineSearchContext;)V 
.const [73] = Utf8 execute 
.const [74] = Utf8 ()V 
.end class 

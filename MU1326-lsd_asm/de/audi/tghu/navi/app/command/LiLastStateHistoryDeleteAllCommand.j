.version 50 0 
.class public super [68] 
.super [70] 

.method public annotation [72] : [73] 
    .attribute [71] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [74] : [75] 
    .attribute [71] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [12] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [13] 
L16:    invokeinterface [16] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [71] .code stack 4 locals 0 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L30 
L6:     aload_0 
L7:     getfield [11] 
L10:    ldc [2] 
L12:    ldc [4] 
L14:    invokevirtual [12] 
L17:    pop 
L18:    aload_0 
L19:    invokevirtual [14] 
L22:    invokeinterface [17] 0 
L27:    goto L53 
L30:    aload_0 
L31:    getfield [11] 
L34:    sipush 10000 
L37:    ldc [5] 
L39:    invokevirtual [12] 
L42:    pop 
L43:    aload_0 
L44:    invokevirtual [14] 
L47:    lload_1 
L48:    invokeinterface [18] 0 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [19] 
.const [4] = String [20] 
.const [5] = String [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Class [25] 
.const [10] = Class [26] 
.const [11] = Field [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = InterfaceMethod [37] [38] 
.const [17] = InterfaceMethod [39] [40] 
.const [18] = InterfaceMethod [41] [42] 
.const [19] = Utf8 'LiLastStateHistoryDeleteAllCommand#execute() - calling liLastStateHistoryDeleteAll() ' 
.const [20] = Utf8 'LiLastStateHistoryDeleteAllCommand#liHistoryResult()' 
.const [21] = Utf8 'LiLastStateHistoryDeleteAllCommand#liHistoryResult() - commandAborted' 
.const [22] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryDeleteAllCommand 
.const [23] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [26] = Utf8 de/audi/tghu/command/ICommandList 
.const [27] = Class [43] 
.const [28] = NameAndType [44] [45] 
.const [29] = Class [46] 
.const [30] = NameAndType [47] [48] 
.const [31] = Class [49] 
.const [32] = NameAndType [50] [51] 
.const [33] = Class [52] 
.const [34] = NameAndType [53] [54] 
.const [35] = Class [55] 
.const [36] = NameAndType [56] [57] 
.const [37] = Class [58] 
.const [38] = NameAndType [59] [60] 
.const [39] = Class [61] 
.const [40] = NameAndType [62] [63] 
.const [41] = Class [64] 
.const [42] = NameAndType [65] [66] 
.const [43] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryDeleteAllCommand 
.const [44] = Utf8 logger 
.const [45] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 log 
.const [48] = Utf8 (ILjava/lang/String;)Z 
.const [49] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryDeleteAllCommand 
.const [50] = Utf8 getDSINavigation 
.const [51] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [52] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryDeleteAllCommand 
.const [53] = Utf8 getCommandList 
.const [54] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [55] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [59] = Utf8 liLastStateHistoryDeleteAll 
.const [60] = Utf8 ()V 
.const [61] = Utf8 de/audi/tghu/command/ICommandList 
.const [62] = Utf8 commandFinished 
.const [63] = Utf8 ()V 
.const [64] = Utf8 de/audi/tghu/command/ICommandList 
.const [65] = Utf8 commandAborted 
.const [66] = Utf8 (J)V 
.const [67] = Utf8 de/audi/tghu/navi/app/command/LiLastStateHistoryDeleteAllCommand 
.const [68] = Class [67] 
.const [69] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [70] = Class [69] 
.const [71] = Utf8 Code 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 execute 
.const [75] = Utf8 ()V 
.const [76] = Utf8 liHistoryResult 
.const [77] = Utf8 (J)V 
.end class 

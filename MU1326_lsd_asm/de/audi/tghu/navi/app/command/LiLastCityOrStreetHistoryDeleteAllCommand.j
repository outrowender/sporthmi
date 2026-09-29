.version 50 0 
.class public super [86] 
.super [88] 
.field public static final [89] [90] 
.field public static final [91] [92] 
.field private [93] [94] 

.method public [96] : [97] 
    .attribute [95] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [95] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [13] 
L11:    pop 
L12:    aload_0 
L13:    getfield [11] 
L16:    ifne L31 
L19:    aload_0 
L20:    invokevirtual [14] 
L23:    invokeinterface [18] 0 
L28:    goto L40 
L31:    aload_0 
L32:    invokevirtual [14] 
L35:    invokeinterface [19] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [100] : [101] 
    .attribute [95] .code stack 4 locals 0 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L30 
L6:     aload_0 
L7:     getfield [12] 
L10:    ldc [2] 
L12:    ldc [4] 
L14:    invokevirtual [13] 
L17:    pop 
L18:    aload_0 
L19:    invokevirtual [15] 
L22:    invokeinterface [20] 0 
L27:    goto L53 
L30:    aload_0 
L31:    getfield [12] 
L34:    sipush 10000 
L37:    ldc [5] 
L39:    invokevirtual [13] 
L42:    pop 
L43:    aload_0 
L44:    invokevirtual [15] 
L47:    lload_1 
L48:    invokeinterface [21] 0 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = InterfaceMethod [44] [45] 
.const [19] = InterfaceMethod [46] [47] 
.const [20] = InterfaceMethod [48] [49] 
.const [21] = InterfaceMethod [50] [51] 
.const [22] = Utf8 'LiLastCityHistoryDeleteAllCommand#execute() - calling liLastCityHistoryDeleteAll() ' 
.const [23] = Utf8 'LiLastCityHistoryDeleteAllCommand#liLastCityAndStreetHistoryResult()' 
.const [24] = Utf8 'LiLastCityHistoryDeleteAllCommand#liLastCityAndStreetHistoryResult() - commandAborted' 
.const [25] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [26] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [29] = Utf8 de/audi/tghu/command/ICommandList 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [53] = Utf8 type 
.const [54] = Utf8 I 
.const [55] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [56] = Utf8 logger 
.const [57] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 log 
.const [60] = Utf8 (ILjava/lang/String;)Z 
.const [61] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [62] = Utf8 getDSINavigation 
.const [63] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [64] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [65] = Utf8 getCommandList 
.const [66] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [67] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [71] = Utf8 type 
.const [72] = Utf8 I 
.const [73] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [74] = Utf8 liLastCityHistoryDeleteAll 
.const [75] = Utf8 ()V 
.const [76] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [77] = Utf8 liLastStreetHistoryDeleteAll 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/tghu/command/ICommandList 
.const [80] = Utf8 commandFinished 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/audi/tghu/command/ICommandList 
.const [83] = Utf8 commandAborted 
.const [84] = Utf8 (J)V 
.const [85] = Utf8 de/audi/tghu/navi/app/command/LiLastCityOrStreetHistoryDeleteAllCommand 
.const [86] = Class [85] 
.const [87] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [88] = Class [87] 
.const [89] = Utf8 TYPE_CITY 
.const [90] = Utf8 I 
.const [91] = Utf8 TYPE_STREET 
.const [92] = Utf8 I 
.const [93] = Utf8 type 
.const [94] = Utf8 I 
.const [95] = Utf8 Code 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (I)V 
.const [98] = Utf8 execute 
.const [99] = Utf8 ()V 
.const [100] = Utf8 liLastCityAndStreetHistoryResult 
.const [101] = Utf8 (J)V 
.end class 

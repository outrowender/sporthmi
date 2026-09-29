.version 50 0 
.class public super [92] 
.super [94] 
.field private final [95] [96] 
.field public static final [97] [98] 

.method public [100] : [101] 
    .attribute [99] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [102] : [103] 
    .attribute [99] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [11] 
L12:    invokevirtual [13] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [14] 
L20:    aload_0 
L21:    getfield [11] 
L24:    invokeinterface [19] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [104] : [105] 
    .attribute [99] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [15] 
L14:    pop 
L15:    iload_2 
L16:    ifeq L30 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    iload_2 
L24:    i2l 
L25:    invokeinterface [20] 0 
L30:    aload_0 
L31:    invokevirtual [16] 
L34:    ldc [5] 
L36:    aload_1 
L37:    invokeinterface [21] 0 
L42:    aload_0 
L43:    invokevirtual [16] 
L46:    invokeinterface [22] 0 
L51:    return 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [23] 
.const [4] = String [24] 
.const [5] = String [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Field [31] [32] 
.const [12] = Field [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Field [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = Utf8 'TrImportTrails#execute( fileName: %1 )' 
.const [24] = Utf8 'TrImportTrails#trImportTrailsResult( %1, %2 )' 
.const [25] = Utf8 NavSegmentIDs 
.const [26] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [27] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [30] = Utf8 de/audi/tghu/command/ICommandList 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [56] = Utf8 fileName 
.const [57] = Utf8 Ljava/lang/String; 
.const [58] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [59] = Utf8 logger 
.const [60] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [65] = Utf8 getDSINavigation 
.const [66] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [70] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [71] = Utf8 getCommandList 
.const [72] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [73] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [77] = Utf8 fileName 
.const [78] = Utf8 Ljava/lang/String; 
.const [79] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [80] = Utf8 trImportTrails 
.const [81] = Utf8 (Ljava/lang/String;)V 
.const [82] = Utf8 de/audi/tghu/command/ICommandList 
.const [83] = Utf8 commandAborted 
.const [84] = Utf8 (J)V 
.const [85] = Utf8 de/audi/tghu/command/ICommandList 
.const [86] = Utf8 put 
.const [87] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)V 
.const [88] = Utf8 de/audi/tghu/command/ICommandList 
.const [89] = Utf8 commandFinished 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/audi/tghu/navi/app/command/TrImportTrails 
.const [92] = Class [91] 
.const [93] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [94] = Class [93] 
.const [95] = Utf8 fileName 
.const [96] = Utf8 Ljava/lang/String; 
.const [97] = Utf8 NAV_SEGMENT_IDS 
.const [98] = Utf8 Ljava/lang/String; 
.const [99] = Utf8 Code 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (Ljava/lang/String;)V 
.const [102] = Utf8 execute 
.const [103] = Utf8 ()V 
.const [104] = Utf8 trImportTrailsResult 
.const [105] = Utf8 ([Lorg/dsi/ifc/global/NavSegmentID;I)V 
.end class 

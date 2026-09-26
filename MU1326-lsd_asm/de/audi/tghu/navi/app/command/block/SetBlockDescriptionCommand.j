.version 50 0 
.class public super [136] 
.super [138] 
.field private [139] [140] 
.field private [141] [142] 

.method public [144] : [145] 
    .attribute [143] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [28] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [143] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [18] 
L16:    aload_0 
L17:    getfield [14] 
L20:    aload_0 
L21:    getfield [15] 
L24:    invokeinterface [29] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [143] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    iload_2 
L13:    ifne L28 
L16:    aload_0 
L17:    invokevirtual [19] 
L20:    invokeinterface [30] 0 
L25:    goto L54 
L28:    aload_0 
L29:    getfield [16] 
L32:    sipush 10000 
L35:    ldc [5] 
L37:    iload_2 
L38:    i2l 
L39:    invokevirtual [20] 
L42:    pop 
L43:    aload_0 
L44:    invokevirtual [19] 
L47:    iload_2 
L48:    i2l 
L49:    invokeinterface [31] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [150] : [151] 
    .attribute [143] .code stack 13 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokevirtual [22] 
L7:     iconst_1 
L8:     anewarray [6] 
L11:    dup 
L12:    iconst_0 
L13:    new [32] 
L16:    dup 
L17:    aload_0 
L18:    getfield [14] 
L21:    iconst_0 
L22:    laload 
L23:    iconst_3 
L24:    iconst_0 
L25:    iconst_1 
L26:    iconst_0 
L27:    aload_0 
L28:    getfield [15] 
L31:    invokespecial [26] 
L34:    aastore 
L35:    invokevirtual [23] 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [14] 
L43:    iconst_0 
L44:    invokevirtual [24] 
L47:    return 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = Class [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Field [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = Class [80] 
.const [33] = Utf8 'PersistBlockCommand#execute() - calling setBlockDescription()' 
.const [34] = Utf8 'BlockRouteBasedOnLengthCommand#setBlockDescriptionResult()' 
.const [35] = Utf8 'BlockRouteBasedOnLengthCommand#setBlockDescriptionResult() - got error code %1 !' 
.const [36] = Utf8 org/dsi/ifc/navigation/BlockElement 
.const [37] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [38] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [41] = Utf8 de/audi/tghu/command/ICommandList 
.const [42] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [43] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Class [96] 
.const [55] = NameAndType [97] [98] 
.const [56] = Class [99] 
.const [57] = NameAndType [100] [101] 
.const [58] = Class [102] 
.const [59] = NameAndType [103] [104] 
.const [60] = Class [105] 
.const [61] = NameAndType [106] [107] 
.const [62] = Class [108] 
.const [63] = NameAndType [109] [110] 
.const [64] = Class [111] 
.const [65] = NameAndType [112] [113] 
.const [66] = Class [114] 
.const [67] = NameAndType [115] [116] 
.const [68] = Class [117] 
.const [69] = NameAndType [118] [119] 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Utf8 org/dsi/ifc/navigation/BlockElement 
.const [81] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [82] = Utf8 uid 
.const [83] = Utf8 [J 
.const [84] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [85] = Utf8 description 
.const [86] = Utf8 Ljava/lang/String; 
.const [87] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [88] = Utf8 logger 
.const [89] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;)Z 
.const [93] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [94] = Utf8 getDSIBlocking 
.const [95] = Utf8 ()Lorg/dsi/ifc/navigation/DSIBlocking; 
.const [96] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [97] = Utf8 getCommandList 
.const [98] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;J)Z 
.const [102] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [103] = Utf8 navigation 
.const [104] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [105] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [106] = Utf8 getSimpleDetourHandler 
.const [107] = Utf8 ()Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [108] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [109] = Utf8 updateListOfBlocks 
.const [110] = Utf8 ([Lorg/dsi/ifc/navigation/BlockElement;)V 
.const [111] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [112] = Utf8 setBlockDescriptionResult 
.const [113] = Utf8 ([JI)V 
.const [114] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 org/dsi/ifc/navigation/BlockElement 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (JIIZZLjava/lang/String;)V 
.const [120] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [121] = Utf8 uid 
.const [122] = Utf8 [J 
.const [123] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [124] = Utf8 description 
.const [125] = Utf8 Ljava/lang/String; 
.const [126] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [127] = Utf8 setBlockDescription 
.const [128] = Utf8 ([JLjava/lang/String;)V 
.const [129] = Utf8 de/audi/tghu/command/ICommandList 
.const [130] = Utf8 commandFinished 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/audi/tghu/command/ICommandList 
.const [133] = Utf8 commandAborted 
.const [134] = Utf8 (J)V 
.const [135] = Utf8 de/audi/tghu/navi/app/command/block/SetBlockDescriptionCommand 
.const [136] = Class [135] 
.const [137] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [138] = Class [137] 
.const [139] = Utf8 uid 
.const [140] = Utf8 [J 
.const [141] = Utf8 description 
.const [142] = Utf8 Ljava/lang/String; 
.const [143] = Utf8 Code 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ([JLjava/lang/String;)V 
.const [146] = Utf8 execute 
.const [147] = Utf8 ()V 
.const [148] = Utf8 setBlockDescriptionResult 
.const [149] = Utf8 ([JI)V 
.const [150] = Utf8 dummyResults 
.const [151] = Utf8 ()V 
.end class 

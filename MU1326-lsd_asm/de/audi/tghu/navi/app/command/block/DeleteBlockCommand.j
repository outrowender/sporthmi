.version 50 0 
.class public super [120] 
.super [122] 
.field private final [123] [124] 
.field private final [125] [126] 

.method public [128] : [129] 
    .attribute [127] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    lload_2 
L11:    putfield [25] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [127] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [14] 
L8:     invokevirtual [15] 
L11:    ifeq L48 
L14:    aload_0 
L15:    getfield [16] 
L18:    ldc [2] 
L20:    ldc [3] 
L22:    invokevirtual [17] 
L25:    pop 
L26:    aload_0 
L27:    invokevirtual [18] 
L30:    iconst_1 
L31:    newarray long 
L33:    dup 
L34:    iconst_0 
L35:    aload_0 
L36:    getfield [14] 
L39:    lastore 
L40:    invokeinterface [26] 0 
L45:    goto L69 
L48:    aload_0 
L49:    getfield [16] 
L52:    ldc [2] 
L54:    ldc [4] 
L56:    invokevirtual [17] 
L59:    pop 
L60:    aload_0 
L61:    invokevirtual [19] 
L64:    invokeinterface [27] 0 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [127] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     iload_2 
L9:     i2l 
L10:    invokevirtual [20] 
L13:    pop 
L14:    iload_2 
L15:    ifne L30 
L18:    aload_0 
L19:    invokevirtual [19] 
L22:    invokeinterface [27] 0 
L27:    goto L56 
L30:    aload_0 
L31:    getfield [16] 
L34:    sipush 10000 
L37:    ldc [6] 
L39:    iload_2 
L40:    i2l 
L41:    invokevirtual [20] 
L44:    pop 
L45:    aload_0 
L46:    invokevirtual [19] 
L49:    iload_2 
L50:    i2l 
L51:    invokeinterface [28] 0 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [134] : [135] 
    .attribute [127] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aconst_null 
L5:     invokevirtual [21] 
L8:     aload_0 
L9:     iconst_1 
L10:    newarray long 
L12:    dup 
L13:    iconst_0 
L14:    aload_0 
L15:    getfield [14] 
L18:    lastore 
L19:    iconst_0 
L20:    invokevirtual [22] 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [29] 
.const [4] = String [30] 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Field [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Field [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = Utf8 'DeleteBlockCommand#execute() - calling deleteBlock()' 
.const [30] = Utf8 'DeleteBlockCommand#execute() - blocking already vanished, do nothing' 
.const [31] = Utf8 'DeleteBlockCommand#deleteBlockResult() resultCode = %1' 
.const [32] = Utf8 'DeleteBlockCommand#deleteBlockResult() - got error code %1 !' 
.const [33] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [34] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [35] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [36] = Utf8 de/audi/atip/log/LogChannel 
.const [37] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [38] = Utf8 de/audi/tghu/command/ICommandList 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [72] = Utf8 simpleDetourHandler 
.const [73] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [74] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [75] = Utf8 uid 
.const [76] = Utf8 J 
.const [77] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [78] = Utf8 isBlockUidAvailable 
.const [79] = Utf8 (J)Z 
.const [80] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [81] = Utf8 logger 
.const [82] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [83] = Utf8 de/audi/atip/log/LogChannel 
.const [84] = Utf8 log 
.const [85] = Utf8 (ILjava/lang/String;)Z 
.const [86] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [87] = Utf8 getDSIBlocking 
.const [88] = Utf8 ()Lorg/dsi/ifc/navigation/DSIBlocking; 
.const [89] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [90] = Utf8 getCommandList 
.const [91] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 log 
.const [94] = Utf8 (ILjava/lang/String;J)Z 
.const [95] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [96] = Utf8 updateListOfBlocks 
.const [97] = Utf8 ([Lorg/dsi/ifc/navigation/BlockElement;)V 
.const [98] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [99] = Utf8 deleteBlockResult 
.const [100] = Utf8 ([JI)V 
.const [101] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [105] = Utf8 simpleDetourHandler 
.const [106] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [107] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [108] = Utf8 uid 
.const [109] = Utf8 J 
.const [110] = Utf8 org/dsi/ifc/navigation/DSIBlocking 
.const [111] = Utf8 deleteBlock 
.const [112] = Utf8 ([J)V 
.const [113] = Utf8 de/audi/tghu/command/ICommandList 
.const [114] = Utf8 commandFinished 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/tghu/command/ICommandList 
.const [117] = Utf8 commandAborted 
.const [118] = Utf8 (J)V 
.const [119] = Utf8 de/audi/tghu/navi/app/command/block/DeleteBlockCommand 
.const [120] = Class [119] 
.const [121] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [122] = Class [121] 
.const [123] = Utf8 simpleDetourHandler 
.const [124] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [125] = Utf8 uid 
.const [126] = Utf8 J 
.const [127] = Utf8 Code 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler;J)V 
.const [130] = Utf8 execute 
.const [131] = Utf8 ()V 
.const [132] = Utf8 deleteBlockResult 
.const [133] = Utf8 ([JI)V 
.const [134] = Utf8 dummyResult 
.const [135] = Utf8 ()V 
.end class 

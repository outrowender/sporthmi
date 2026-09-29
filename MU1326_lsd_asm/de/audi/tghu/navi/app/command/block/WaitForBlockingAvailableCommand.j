.version 50 0 
.class public super [124] 
.super [126] 
.implements [128] 
.field private final [129] [130] 
.field private final [131] [132] 

.method public [134] : [135] 
    .attribute [133] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [28] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [29] 
L14:    aload_1 
L15:    aload_0 
L16:    invokevirtual [17] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [133] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [19] 
L11:    pop 
L12:    aload_0 
L13:    getfield [16] 
L16:    ifeq L48 
L19:    aload_0 
L20:    getfield [20] 
L23:    invokevirtual [21] 
L26:    ifne L48 
L29:    aload_0 
L30:    getfield [18] 
L33:    ldc [2] 
L35:    ldc [4] 
L37:    invokevirtual [19] 
L40:    pop 
L41:    aload_0 
L42:    invokespecial [27] 
L45:    goto L89 
L48:    aload_0 
L49:    getfield [15] 
L52:    invokevirtual [22] 
L55:    ifeq L77 
L58:    aload_0 
L59:    getfield [18] 
L62:    ldc [2] 
L64:    ldc [5] 
L66:    invokevirtual [19] 
L69:    pop 
L70:    aload_0 
L71:    invokespecial [27] 
L74:    goto L89 
L77:    aload_0 
L78:    getfield [18] 
L81:    ldc [2] 
L83:    ldc [6] 
L85:    invokevirtual [19] 
L88:    pop 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method private [138] : [139] 
    .attribute [133] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     invokevirtual [23] 
L8:     aload_0 
L9:     invokevirtual [24] 
L12:    invokeinterface [30] 0 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [133] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     iload_1 
L9:     invokevirtual [25] 
L12:    pop 
L13:    aload_0 
L14:    getfield [15] 
L17:    invokevirtual [22] 
L20:    ifeq L39 
L23:    aload_0 
L24:    getfield [18] 
L27:    ldc [2] 
L29:    ldc [8] 
L31:    invokevirtual [19] 
L34:    pop 
L35:    aload_0 
L36:    invokespecial [27] 
L39:    return 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Field [43] [44] 
.const [16] = Field [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = Utf8 'WaitForBlockingAvailableCommand#execute()' 
.const [32] = Utf8 'WaitForBlockingAvailableCommand#execute() - route guidance not active, ignore current navigation status' 
.const [33] = Utf8 'WaitForBlockingAvailableCommand#execute() - blocking enabled' 
.const [34] = Utf8 'WaitForBlockingAvailableCommand#execute() - blocking disabled, wait for re-enable' 
.const [35] = Utf8 'WaitForBlockingAvailableCommand#updateBlockingAvailable( %1 )' 
.const [36] = Utf8 'WaitForBlockingAvailableCommand#updateBlockingAvailable() - blocking re-enabled' 
.const [37] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [38] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [42] = Utf8 de/audi/tghu/command/ICommandList 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [76] = Utf8 simpleDetourHandler 
.const [77] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [78] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [79] = Utf8 forceNoWait 
.const [80] = Utf8 Z 
.const [81] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [82] = Utf8 registerAsListener 
.const [83] = Utf8 (Lde/audi/tghu/navi/app/command/block/IWaitForBlockingAvailableListener;)V 
.const [84] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [85] = Utf8 logger 
.const [86] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;)Z 
.const [90] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [91] = Utf8 dsiResponseContainer 
.const [92] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [93] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [94] = Utf8 isRgActive 
.const [95] = Utf8 ()Z 
.const [96] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [97] = Utf8 isBlockingPossible 
.const [98] = Utf8 ()Z 
.const [99] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [100] = Utf8 derigisterAsListener 
.const [101] = Utf8 (Lde/audi/tghu/navi/app/command/block/IWaitForBlockingAvailableListener;)V 
.const [102] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [103] = Utf8 getCommandList 
.const [104] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [105] = Utf8 de/audi/atip/log/LogChannel 
.const [106] = Utf8 log 
.const [107] = Utf8 (ILjava/lang/String;Z)Z 
.const [108] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [112] = Utf8 finishCommand 
.const [113] = Utf8 ()V 
.const [114] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [115] = Utf8 simpleDetourHandler 
.const [116] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [117] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [118] = Utf8 forceNoWait 
.const [119] = Utf8 Z 
.const [120] = Utf8 de/audi/tghu/command/ICommandList 
.const [121] = Utf8 commandFinished 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/audi/tghu/navi/app/command/block/WaitForBlockingAvailableCommand 
.const [124] = Class [123] 
.const [125] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/tghu/navi/app/command/block/IWaitForBlockingAvailableListener 
.const [128] = Class [127] 
.const [129] = Utf8 simpleDetourHandler 
.const [130] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [131] = Utf8 forceNoWait 
.const [132] = Utf8 Z 
.const [133] = Utf8 Code 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler;Z)V 
.const [136] = Utf8 execute 
.const [137] = Utf8 ()V 
.const [138] = Utf8 finishCommand 
.const [139] = Utf8 ()V 
.const [140] = Utf8 updateBlockingAvailable 
.const [141] = Utf8 (Z)V 
.end class 

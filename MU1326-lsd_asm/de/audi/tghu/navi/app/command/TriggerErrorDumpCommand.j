.version 50 0 
.class public super [126] 
.super [128] 

.method public annotation [130] : [131] 
    .attribute [129] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [129] .code stack 6 locals 5 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [15] 
L7:     invokeinterface [25] 0 
L12:    lstore_1 
L13:    aload_0 
L14:    invokevirtual [16] 
L17:    ldc [2] 
L19:    invokeinterface [26] 0 
L24:    checkcast [3] 
L27:    astore_3 
L28:    lload_1 
L29:    aload_3 
L30:    invokevirtual [17] 
L33:    lsub 
L34:    lstore 4 
L36:    lload 4 
L38:    ldc_w [1] 
L41:    lcmp 
L42:    ifle L101 
L45:    aload_0 
L46:    getfield [18] 
L49:    sipush 10000 
L52:    ldc [4] 
L54:    lload 4 
L56:    invokevirtual [19] 
L59:    pop 
L60:    aload_0 
L61:    getfield [14] 
L64:    invokevirtual [15] 
L67:    invokeinterface [27] 0 
L72:    aconst_null 
L73:    new [28] 
L76:    dup 
L77:    invokespecial [24] 
L80:    ldc [6] 
L82:    invokevirtual [20] 
L85:    lload 4 
L87:    invokevirtual [21] 
L90:    invokevirtual [22] 
L93:    iconst_1 
L94:    iconst_0 
L95:    iconst_0 
L96:    invokeinterface [29] 0 
L101:   aload_0 
L102:   invokevirtual [16] 
L105:   invokeinterface [30] 0 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [32] 
.const [3] = Class [33] 
.const [4] = String [34] 
.const [5] = Class [35] 
.const [6] = String [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = InterfaceMethod [66] [67] 
.const [26] = InterfaceMethod [68] [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = Class [72] 
.const [29] = InterfaceMethod [73] [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = Int 1625948160 
.const [32] = Utf8 STARTING_TIME_KEY 
.const [33] = Utf8 java/lang/Long 
.const [34] = Utf8 'TriggerErrorDumpCommand#CommandList was running for too long: %1' 
.const [35] = Utf8 java/lang/StringBuffer 
.const [36] = Utf8 'CommandList was running for too long: ' 
.const [37] = Utf8 de/audi/tghu/navi/app/command/TriggerErrorDumpCommand 
.const [38] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [40] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [41] = Utf8 de/audi/tghu/command/ICommandList 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/atip/error/IErrorManager 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Utf8 de/audi/tghu/navi/app/command/TriggerErrorDumpCommand 
.const [78] = Utf8 env 
.const [79] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [80] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [81] = Utf8 getFramework 
.const [82] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [83] = Utf8 de/audi/tghu/navi/app/command/TriggerErrorDumpCommand 
.const [84] = Utf8 getCommandList 
.const [85] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [86] = Utf8 java/lang/Long 
.const [87] = Utf8 longValue 
.const [88] = Utf8 ()J 
.const [89] = Utf8 de/audi/tghu/navi/app/command/TriggerErrorDumpCommand 
.const [90] = Utf8 logger 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 log 
.const [94] = Utf8 (ILjava/lang/String;J)Z 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 append 
.const [100] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 toString 
.const [103] = Utf8 ()Ljava/lang/String; 
.const [104] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [111] = Utf8 getKombiTime 
.const [112] = Utf8 ()J 
.const [113] = Utf8 de/audi/tghu/command/ICommandList 
.const [114] = Utf8 get 
.const [115] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [116] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [117] = Utf8 getErrorMgr 
.const [118] = Utf8 ()Lde/audi/atip/error/IErrorManager; 
.const [119] = Utf8 de/audi/atip/error/IErrorManager 
.const [120] = Utf8 handleError 
.const [121] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;III)V 
.const [122] = Utf8 de/audi/tghu/command/ICommandList 
.const [123] = Utf8 commandFinished 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/tghu/navi/app/command/TriggerErrorDumpCommand 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [128] = Class [127] 
.const [129] = Utf8 Code 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 execute 
.const [133] = Utf8 ()V 
.end class 

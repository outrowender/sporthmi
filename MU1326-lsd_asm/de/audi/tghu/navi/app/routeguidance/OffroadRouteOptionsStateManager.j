.version 50 0 
.class public super [114] 
.super [116] 
.field private [117] [118] 
.field private [119] [120] 

.method public [122] : [123] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [13] 
L14:    putfield [25] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [124] : [125] 
    .attribute [121] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [15] 
L7:     invokeinterface [26] 0 
L12:    ifnull L63 
L15:    aload_0 
L16:    getfield [14] 
L19:    ldc [2] 
L21:    ldc [3] 
L23:    iload_1 
L24:    i2l 
L25:    invokevirtual [16] 
L28:    pop 
L29:    new [27] 
L32:    dup 
L33:    aload_0 
L34:    aload_0 
L35:    getfield [12] 
L38:    invokevirtual [15] 
L41:    invokeinterface [26] 0 
L46:    aload_0 
L47:    getfield [14] 
L50:    invokespecial [23] 
L53:    astore_2 
L54:    aload_2 
L55:    iload_1 
L56:    invokevirtual [17] 
L59:    aload_2 
L60:    invokevirtual [18] 
L63:    return 
L64:    
    .end code 
.end method 

.method public [126] : [127] 
    .attribute [121] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [15] 
L7:     invokeinterface [26] 0 
L12:    astore_1 
L13:    aload_1 
L14:    ifnull L56 
L17:    new [27] 
L20:    dup 
L21:    aload_0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [14] 
L27:    invokespecial [23] 
L30:    astore_2 
L31:    aload_2 
L32:    invokevirtual [19] 
L35:    aload_2 
L36:    invokevirtual [20] 
L39:    istore_3 
L40:    aload_0 
L41:    getfield [14] 
L44:    ldc [2] 
L46:    ldc [5] 
L48:    iload_3 
L49:    i2l 
L50:    invokevirtual [16] 
L53:    pop 
L54:    iload_3 
L55:    areturn 
L56:    aload_0 
L57:    getfield [14] 
L60:    sipush 10000 
L63:    ldc [6] 
L65:    invokevirtual [21] 
L68:    pop 
L69:    iconst_1 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [28] 
.const [4] = Class [29] 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Field [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
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
.const [27] = Class [67] 
.const [28] = Utf8 'OffroadRouteOptionsStatemanager#saveDsiRouteOptionOffRoad() %1' 
.const [29] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [30] = Utf8 'OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() %1' 
.const [31] = Utf8 'OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() - no storage manager available!!! ' 
.const [32] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [35] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [36] = Utf8 de/audi/atip/log/LogChannel 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
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
.const [67] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [68] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [69] = Utf8 env 
.const [70] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [71] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [72] = Utf8 getLogChannel 
.const [73] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [74] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [75] = Utf8 logChannel 
.const [76] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [77] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [78] = Utf8 getFramework 
.const [79] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [80] = Utf8 de/audi/atip/log/LogChannel 
.const [81] = Utf8 log 
.const [82] = Utf8 (ILjava/lang/String;J)Z 
.const [83] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [84] = Utf8 setDsiRouteOptionOffRoad 
.const [85] = Utf8 (I)V 
.const [86] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [87] = Utf8 serializeAndWrite 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [90] = Utf8 readAndDeserialize 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [93] = Utf8 getDsiRouteOptionOffRoad 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;)Z 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager$OffroadRouteOptionsState 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager;Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [104] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [105] = Utf8 env 
.const [106] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [107] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [108] = Utf8 logChannel 
.const [109] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [110] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [111] = Utf8 getStorageMgr 
.const [112] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [113] = Utf8 de/audi/tghu/navi/app/routeguidance/OffroadRouteOptionsStateManager 
.const [114] = Class [113] 
.const [115] = Utf8 java/lang/Object 
.const [116] = Class [115] 
.const [117] = Utf8 env 
.const [118] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [119] = Utf8 logChannel 
.const [120] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [121] = Utf8 Code 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [124] = Utf8 saveDsiRouteOptionOffRoad 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 loadLastPersistetDsiRouteOptionOffRoad 
.const [127] = Utf8 ()I 
.end class 

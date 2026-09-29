.version 50 0 
.class public super [86] 
.super [88] 
.field private final [89] [90] 
.field private final [91] [92] 
.field private final [93] [94] 

.method public [96] : [97] 
    .attribute [95] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [17] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [18] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [19] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [95] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    iload_3 
L12:    i2l 
L13:    invokevirtual [14] 
L16:    pop 
L17:    iload_3 
L18:    iconst_1 
L19:    if_icmpeq L23 
L22:    return 
L23:    iload_1 
L24:    ifeq L32 
L27:    iload_1 
L28:    iconst_2 
L29:    if_icmpne L33 
L32:    return 
L33:    iload_1 
L34:    iconst_1 
L35:    if_icmpne L84 
L38:    aload_0 
L39:    getfield [13] 
L42:    sipush 392 
L45:    invokevirtual [15] 
L48:    invokeinterface [20] 0 
L53:    ifne L84 
L56:    aload_0 
L57:    getfield [12] 
L60:    ldc [2] 
L62:    ldc [4] 
L64:    aload_2 
L65:    iload_1 
L66:    i2l 
L67:    iload_3 
L68:    i2l 
L69:    invokevirtual [14] 
L72:    pop 
L73:    aload_0 
L74:    getfield [11] 
L77:    iload_1 
L78:    aload_2 
L79:    invokeinterface [21] 0 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = String [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = InterfaceMethod [48] [49] 
.const [21] = InterfaceMethod [50] [51] 
.const [22] = Utf8 'DBIncompleteController#updateNavDbRegionsState(%1,%2,%3)' 
.const [23] = Utf8 'DBIncompleteController#updateNavDbRegionsState(%1,%2,%3) - update was not OK.' 
.const [24] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [28] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [29] = Utf8 de/audi/tghu/navi/app/IDBIncompleteModelAccess 
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
.const [52] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [53] = Utf8 dbIncompleteModelAccess 
.const [54] = Utf8 Lde/audi/tghu/navi/app/IDBIncompleteModelAccess; 
.const [55] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [56] = Utf8 logChannel 
.const [57] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [58] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [59] = Utf8 env 
.const [60] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [65] = Utf8 getChoiceModel 
.const [66] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [71] = Utf8 dbIncompleteModelAccess 
.const [72] = Utf8 Lde/audi/tghu/navi/app/IDBIncompleteModelAccess; 
.const [73] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [74] = Utf8 logChannel 
.const [75] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [76] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [77] = Utf8 env 
.const [78] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [79] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [80] = Utf8 getValue 
.const [81] = Utf8 ()I 
.const [82] = Utf8 de/audi/tghu/navi/app/IDBIncompleteModelAccess 
.const [83] = Utf8 onUpdateNavDbRegionsState 
.const [84] = Utf8 (I[Ljava/lang/String;)V 
.const [85] = Utf8 de/audi/tghu/navi/app/DBIncompleteController 
.const [86] = Class [85] 
.const [87] = Utf8 java/lang/Object 
.const [88] = Class [87] 
.const [89] = Utf8 dbIncompleteModelAccess 
.const [90] = Utf8 Lde/audi/tghu/navi/app/IDBIncompleteModelAccess; 
.const [91] = Utf8 logChannel 
.const [92] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [93] = Utf8 env 
.const [94] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [95] = Utf8 Code 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/tghu/navi/app/IDBIncompleteModelAccess;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [98] = Utf8 updateNavDbRegionsState 
.const [99] = Utf8 (I[Ljava/lang/String;I)V 
.end class 

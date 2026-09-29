.version 50 0 
.class public super [108] 
.super [110] 
.field private final [111] [112] 
.field private final [113] [114] 

.method public [116] : [117] 
    .attribute [115] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     iload_2 
L6:     putfield [23] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [115] .code stack 5 locals 2 
L0:     aload_1 
L1:     arraylength 
L2:     sipush 6000 
L5:     if_icmple L25 
L8:     aload_0 
L9:     getfield [13] 
L12:    invokevirtual [14] 
L15:    sipush 10000 
L18:    ldc [2] 
L20:    invokevirtual [15] 
L23:    pop 
L24:    return 
L25:    aload_0 
L26:    getfield [13] 
L29:    invokevirtual [14] 
L32:    ldc [3] 
L34:    ldc [4] 
L36:    invokevirtual [15] 
L39:    pop 
L40:    aload_0 
L41:    getfield [13] 
L44:    invokevirtual [16] 
L47:    invokeinterface [25] 0 
L52:    astore_2 
L53:    new [26] 
L56:    dup 
L57:    aload_2 
L58:    aload_0 
L59:    getfield [13] 
L62:    invokevirtual [14] 
L65:    aload_0 
L66:    getfield [12] 
L69:    invokespecial [22] 
L72:    astore_3 
L73:    aload_3 
L74:    aload_1 
L75:    invokevirtual [17] 
L78:    aload_3 
L79:    invokevirtual [18] 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [115] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokevirtual [14] 
L7:     ldc [3] 
L9:     ldc [6] 
L11:    invokevirtual [15] 
L14:    pop 
L15:    aload_0 
L16:    getfield [13] 
L19:    invokevirtual [16] 
L22:    invokeinterface [25] 0 
L27:    astore_1 
L28:    aload_1 
L29:    ifnonnull L40 
L32:    iconst_1 
L33:    newarray byte 
L35:    dup 
L36:    iconst_0 
L37:    iconst_0 
L38:    bastore 
L39:    areturn 
L40:    new [26] 
L43:    dup 
L44:    aload_1 
L45:    aload_0 
L46:    getfield [13] 
L49:    invokevirtual [14] 
L52:    aload_0 
L53:    getfield [12] 
L56:    invokespecial [22] 
L59:    astore_2 
L60:    aload_2 
L61:    invokevirtual [19] 
L64:    aload_2 
L65:    invokevirtual [20] 
L68:    ifnull L76 
L71:    aload_2 
L72:    invokevirtual [20] 
L75:    areturn 
L76:    iconst_1 
L77:    newarray byte 
L79:    dup 
L80:    iconst_0 
L81:    iconst_0 
L82:    bastore 
L83:    areturn 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [27] 
.const [3] = Int -2137614336 
.const [4] = String [28] 
.const [5] = Class [29] 
.const [6] = String [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Field [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Field [60] [61] 
.const [25] = InterfaceMethod [62] [63] 
.const [26] = Class [64] 
.const [27] = Utf8 'LocalPersistNavLocationHelper#savePersistentState() --> NavLocation is too big for the persistence. DONT STORE IT because it would effect the whole HMI (Not only NAVI)' 
.const [28] = Utf8 'LocalPersistNavLocationHelper#savePersistentState()' 
.const [29] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [30] = Utf8 'LocalPersistNavLocationHelper#loadPersistentState()' 
.const [31] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [34] = Utf8 de/audi/atip/log/LogChannel 
.const [35] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Class [68] 
.const [39] = NameAndType [69] [70] 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
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
.const [64] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [65] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [66] = Utf8 key 
.const [67] = Utf8 I 
.const [68] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [69] = Utf8 navEnv 
.const [70] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [71] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [72] = Utf8 getLogChannel 
.const [73] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;)Z 
.const [77] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [78] = Utf8 getFramework 
.const [79] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [80] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [81] = Utf8 setNavLocation 
.const [82] = Utf8 ([B)V 
.const [83] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [84] = Utf8 serializeAndWrite 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [87] = Utf8 readAndDeserialize 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [90] = Utf8 getNavLocation 
.const [91] = Utf8 ()[B 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper$NavLocationState 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;I)V 
.const [98] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [99] = Utf8 key 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [102] = Utf8 navEnv 
.const [103] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [104] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [105] = Utf8 getStorageMgr 
.const [106] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [107] = Utf8 de/audi/tghu/navi/app/util/LocalPersistNavLocationHelper 
.const [108] = Class [107] 
.const [109] = Utf8 java/lang/Object 
.const [110] = Class [109] 
.const [111] = Utf8 navEnv 
.const [112] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [113] = Utf8 key 
.const [114] = Utf8 I 
.const [115] = Utf8 Code 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;I)V 
.const [118] = Utf8 savePersistentState 
.const [119] = Utf8 ([B)V 
.const [120] = Utf8 loadPersistentState 
.const [121] = Utf8 ()[B 
.end class 

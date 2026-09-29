.version 50 0 
.class public final super [126] 
.super [128] 
.field private static final [129] [130] 
.field private final [131] [132] 
.field private final [133] [134] 
.field private volatile [135] [136] 
.field private volatile [137] [138] 
.field private volatile [139] [140] 

.method public [142] : [143] 
    .attribute [141] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     new [21] 
L8:     dup 
L9:     invokespecial [19] 
L12:    putfield [22] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [23] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [24] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [25] 
L30:    aload_0 
L31:    aload_1 
L32:    putfield [26] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [141] .code stack 5 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [25] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [24] 
L10:    aload_0 
L11:    getfield [11] 
L14:    new [27] 
L17:    dup 
L18:    iload_2 
L19:    invokespecial [20] 
L22:    new [27] 
L25:    dup 
L26:    iload_1 
L27:    invokespecial [20] 
L30:    invokeinterface [28] 0 
L35:    pop 
L36:    iload_1 
L37:    bipush 67 
L39:    if_icmpne L67 
L42:    aload_0 
L43:    getfield [15] 
L46:    ldc [4] 
L48:    ldc [5] 
L50:    invokevirtual [16] 
L53:    pop 
L54:    aload_0 
L55:    iconst_1 
L56:    putfield [23] 
L59:    aload_0 
L60:    iconst_1 
L61:    putfield [24] 
L64:    goto L96 
L67:    aload_0 
L68:    getfield [12] 
L71:    ifeq L96 
L74:    aload_0 
L75:    getfield [15] 
L78:    ldc [4] 
L80:    ldc [6] 
L82:    invokevirtual [16] 
L85:    pop 
L86:    aload_0 
L87:    iconst_0 
L88:    putfield [23] 
L91:    aload_0 
L92:    iconst_1 
L93:    putfield [24] 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [141] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L22 
L7:     aload_0 
L8:     getfield [12] 
L11:    ifeq L22 
L14:    aload_0 
L15:    bipush 67 
L17:    putfield [25] 
L20:    iconst_1 
L21:    areturn 
L22:    aload_0 
L23:    getfield [13] 
L26:    ifeq L84 
L29:    aload_0 
L30:    getfield [12] 
L33:    ifne L84 
L36:    iload_1 
L37:    iconst_1 
L38:    if_icmpeq L84 
L41:    aload_0 
L42:    getfield [11] 
L45:    new [27] 
L48:    dup 
L49:    iload_1 
L50:    invokespecial [20] 
L53:    invokeinterface [29] 0 
L58:    checkcast [3] 
L61:    astore_2 
L62:    aload_2 
L63:    ifnull L77 
L66:    aload_0 
L67:    aload_2 
L68:    invokevirtual [17] 
L71:    putfield [25] 
L74:    goto L82 
L77:    aload_0 
L78:    iconst_0 
L79:    putfield [25] 
L82:    iconst_1 
L83:    areturn 
L84:    iconst_0 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public interface [148] : [149] 
    .attribute [141] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Class [31] 
.const [4] = Int -2137614336 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Class [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = Class [69] 
.const [28] = InterfaceMethod [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [31] = Utf8 java/lang/Integer 
.const [32] = Utf8 '[BoardBookVideoLogic#receivedInfoStateFromApp] On' 
.const [33] = Utf8 '[BoardBookVideoLogic#receivedInfoStateFromApp] Off' 
.const [34] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/util/Map 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Utf8 java/lang/Integer 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [75] = Utf8 infoStatesForApps 
.const [76] = Utf8 Ljava/util/Map; 
.const [77] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [78] = Utf8 boardBookVideoRunning 
.const [79] = Utf8 Z 
.const [80] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [81] = Utf8 boardBookVideoRunningChanged 
.const [82] = Utf8 Z 
.const [83] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [84] = Utf8 infoStatesToSend 
.const [85] = Utf8 I 
.const [86] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [87] = Utf8 logChannel 
.const [88] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [89] = Utf8 de/audi/atip/log/LogChannel 
.const [90] = Utf8 log 
.const [91] = Utf8 (ILjava/lang/String;)Z 
.const [92] = Utf8 java/lang/Integer 
.const [93] = Utf8 intValue 
.const [94] = Utf8 ()I 
.const [95] = Utf8 java/lang/Object 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentHashMap 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/Integer 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (I)V 
.const [104] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [105] = Utf8 infoStatesForApps 
.const [106] = Utf8 Ljava/util/Map; 
.const [107] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [108] = Utf8 boardBookVideoRunning 
.const [109] = Utf8 Z 
.const [110] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [111] = Utf8 boardBookVideoRunningChanged 
.const [112] = Utf8 Z 
.const [113] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [114] = Utf8 infoStatesToSend 
.const [115] = Utf8 I 
.const [116] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [117] = Utf8 logChannel 
.const [118] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [119] = Utf8 java/util/Map 
.const [120] = Utf8 put 
.const [121] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [122] = Utf8 java/util/Map 
.const [123] = Utf8 get 
.const [124] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [125] = Utf8 de/audi/app/combi/bap/app/audio/BoardBookVideoLogic 
.const [126] = Class [125] 
.const [127] = Utf8 java/lang/Object 
.const [128] = Class [127] 
.const [129] = Utf8 DEFAULT_INFO_STATE 
.const [130] = Utf8 I 
.const [131] = Utf8 logChannel 
.const [132] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [133] = Utf8 infoStatesForApps 
.const [134] = Utf8 Ljava/util/Map; 
.const [135] = Utf8 boardBookVideoRunning 
.const [136] = Utf8 Z 
.const [137] = Utf8 boardBookVideoRunningChanged 
.const [138] = Utf8 Z 
.const [139] = Utf8 infoStatesToSend 
.const [140] = Utf8 I 
.const [141] = Utf8 Code 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [144] = Utf8 receivedInfoStateFromApp 
.const [145] = Utf8 (II)V 
.const [146] = Utf8 isThereAnInfoStateToSend 
.const [147] = Utf8 (I)Z 
.const [148] = Utf8 getInfoStateToSend 
.const [149] = Utf8 ()I 
.end class 

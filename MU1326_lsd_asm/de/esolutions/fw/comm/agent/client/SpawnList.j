.version 50 0 
.class public super [197] 
.super [199] 
.field private final [200] [201] 
.field private final [202] [203] 
.field private final [204] [205] 

.method public [207] : [208] 
    .attribute [206] .code stack 4 locals 4 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [35] 
L9:     aload_0 
L10:    aload_3 
L11:    putfield [36] 
L14:    aload_0 
L15:    new [37] 
L18:    dup 
L19:    invokespecial [32] 
L22:    putfield [38] 
L25:    aload_1 
L26:    invokeinterface [39] 0 
L31:    astore 4 
L33:    aload 4 
L35:    ifnull L111 
L38:    iconst_0 
L39:    istore 5 
L41:    iload 5 
L43:    aload 4 
L45:    arraylength 
L46:    if_icmpge L111 
L49:    aload 4 
L51:    iload 5 
L53:    aaload 
L54:    astore 6 
L56:    aload_0 
L57:    aload 6 
L59:    invokespecial [33] 
L62:    astore 7 
L64:    aload 7 
L66:    ifnull L105 
L69:    aload_0 
L70:    aload 7 
L72:    invokespecial [34] 
L75:    ifne L105 
L78:    aload_0 
L79:    getfield [23] 
L82:    aload 7 
L84:    invokevirtual [24] 
L87:    pop 
L88:    getstatic [3] 
L91:    iconst_2 
L92:    ldc [4] 
L94:    aload 7 
L96:    invokeinterface [40] 0 
L101:   invokevirtual [25] 
L104:   pop 
L105:   iinc 5 1 
L108:   goto L41 
L111:   return 
L112:   
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [206] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [26] 
L7:     astore_1 
L8:     aload_1 
L9:     invokeinterface [41] 0 
L14:    ifeq L57 
L17:    aload_1 
L18:    invokeinterface [42] 0 
L23:    checkcast [5] 
L26:    astore_2 
        .catch [6] from L27 to L33 using L36 
L27:    aload_2 
L28:    invokeinterface [43] 0 
L33:    goto L54 
L36:    astore_3 
L37:    getstatic [3] 
L40:    iconst_4 
L41:    ldc [7] 
L43:    aload_2 
L44:    invokeinterface [40] 0 
L49:    aload_3 
L50:    invokevirtual [27] 
L53:    pop 
L54:    goto L8 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [206] .code stack 1 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [26] 
L7:     astore_1 
L8:     aload_1 
L9:     invokeinterface [41] 0 
L14:    ifeq L36 
L17:    aload_1 
L18:    invokeinterface [42] 0 
L23:    checkcast [5] 
L26:    astore_2 
L27:    aload_2 
L28:    invokeinterface [44] 0 
L33:    goto L8 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [213] : [214] 
    .attribute [206] .code stack 2 locals 3 
L0:     aload_1 
L1:     invokeinterface [40] 0 
L6:     astore_2 
L7:     iconst_0 
L8:     istore_3 
L9:     iload_3 
L10:    aload_0 
L11:    getfield [23] 
L14:    invokevirtual [28] 
L17:    if_icmpge L55 
L20:    aload_0 
L21:    getfield [23] 
L24:    iload_3 
L25:    invokevirtual [29] 
L28:    checkcast [5] 
L31:    astore 4 
L33:    aload 4 
L35:    invokeinterface [40] 0 
L40:    aload_2 
L41:    invokevirtual [30] 
L44:    ifeq L49 
L47:    iconst_1 
L48:    areturn 
L49:    iinc 3 1 
L52:    goto L9 
L55:    iconst_0 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [215] : [216] 
    .attribute [206] .code stack 5 locals 1 
        .catch [11] from L0 to L52 using L53 
L0:     getstatic [3] 
L3:     iconst_2 
L4:     ldc [8] 
L6:     aload_1 
L7:     invokevirtual [25] 
L10:    pop 
L11:    aload_0 
L12:    getfield [21] 
L15:    ldc [9] 
L17:    aload_1 
L18:    invokeinterface [45] 0 
L23:    astore_2 
L24:    aload_2 
L25:    aload_0 
L26:    getfield [22] 
L29:    invokeinterface [46] 0 
L34:    getstatic [3] 
L37:    iconst_2 
L38:    ldc [10] 
L40:    aload_1 
L41:    aload_2 
L42:    invokeinterface [40] 0 
L47:    invokevirtual [27] 
L50:    pop 
L51:    aload_2 
L52:    areturn 
L53:    astore_2 
L54:    getstatic [3] 
L57:    iconst_2 
L58:    ldc [12] 
L60:    aload_1 
L61:    aload_2 
L62:    invokevirtual [27] 
L65:    pop 
L66:    aconst_null 
L67:    areturn 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [47] 
.const [3] = Field [48] [49] 
.const [4] = String [50] 
.const [5] = Class [51] 
.const [6] = Class [52] 
.const [7] = String [53] 
.const [8] = String [54] 
.const [9] = String [55] 
.const [10] = String [56] 
.const [11] = Class [57] 
.const [12] = String [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Class [61] 
.const [16] = Class [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Class [65] 
.const [20] = Class [66] 
.const [21] = Field [67] [68] 
.const [22] = Field [69] [70] 
.const [23] = Field [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Field [95] [96] 
.const [36] = Field [97] [98] 
.const [37] = Class [99] 
.const [38] = Field [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = InterfaceMethod [116] [117] 
.const [47] = Utf8 java/util/ArrayList 
.const [48] = Class [118] 
.const [49] = NameAndType [119] [120] 
.const [50] = Utf8 'added spawn factory %1' 
.const [51] = Utf8 de/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory 
.const [52] = Utf8 java/io/IOException 
.const [53] = Utf8 'error enabling spawning: %1: %2' 
.const [54] = Utf8 "creating spawn connection factory for 'comm:%1'" 
.const [55] = Utf8 comm 
.const [56] = Utf8 "factory for 'comm:%1' is %2" 
.const [57] = Utf8 de/esolutions/fw/util/serializer/connection/ConnectionFactoryException 
.const [58] = Utf8 "no spawn factory found for 'comm:%1'. Disabling spawning: %2" 
.const [59] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/esolutions/fw/comm/agent/naming/INameService 
.const [62] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [63] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [64] = Utf8 java/util/ListIterator 
.const [65] = Utf8 java/lang/String 
.const [66] = Utf8 de/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Class [157] 
.const [92] = NameAndType [158] [159] 
.const [93] = Class [160] 
.const [94] = NameAndType [161] [162] 
.const [95] = Class [163] 
.const [96] = NameAndType [164] [165] 
.const [97] = Class [166] 
.const [98] = NameAndType [167] [168] 
.const [99] = Utf8 java/util/ArrayList 
.const [100] = Class [169] 
.const [101] = NameAndType [170] [171] 
.const [102] = Class [172] 
.const [103] = NameAndType [173] [174] 
.const [104] = Class [175] 
.const [105] = NameAndType [176] [177] 
.const [106] = Class [178] 
.const [107] = NameAndType [179] [180] 
.const [108] = Class [181] 
.const [109] = NameAndType [182] [183] 
.const [110] = Class [184] 
.const [111] = NameAndType [185] [186] 
.const [112] = Class [187] 
.const [113] = NameAndType [188] [189] 
.const [114] = Class [190] 
.const [115] = NameAndType [191] [192] 
.const [116] = Class [193] 
.const [117] = NameAndType [194] [195] 
.const [118] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [119] = Utf8 AGENT 
.const [120] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [121] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [122] = Utf8 provider 
.const [123] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider; 
.const [124] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [125] = Utf8 listener 
.const [126] = Utf8 Lde/esolutions/fw/util/serializer/connection/ISpawnedConnectionListener; 
.const [127] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [128] = Utf8 factories 
.const [129] = Utf8 Ljava/util/ArrayList; 
.const [130] = Utf8 java/util/ArrayList 
.const [131] = Utf8 add 
.const [132] = Utf8 (Ljava/lang/Object;)Z 
.const [133] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 java/util/ArrayList 
.const [137] = Utf8 listIterator 
.const [138] = Utf8 ()Ljava/util/ListIterator; 
.const [139] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [140] = Utf8 log 
.const [141] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [142] = Utf8 java/util/ArrayList 
.const [143] = Utf8 size 
.const [144] = Utf8 ()I 
.const [145] = Utf8 java/util/ArrayList 
.const [146] = Utf8 get 
.const [147] = Utf8 (I)Ljava/lang/Object; 
.const [148] = Utf8 java/lang/String 
.const [149] = Utf8 equals 
.const [150] = Utf8 (Ljava/lang/Object;)Z 
.const [151] = Utf8 java/lang/Object 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 java/util/ArrayList 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [158] = Utf8 createFactoryForNode 
.const [159] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory; 
.const [160] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [161] = Utf8 isFactoryAvailable 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory;)Z 
.const [163] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [164] = Utf8 provider 
.const [165] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider; 
.const [166] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [167] = Utf8 listener 
.const [168] = Utf8 Lde/esolutions/fw/util/serializer/connection/ISpawnedConnectionListener; 
.const [169] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [170] = Utf8 factories 
.const [171] = Utf8 Ljava/util/ArrayList; 
.const [172] = Utf8 de/esolutions/fw/comm/agent/naming/INameService 
.const [173] = Utf8 getNodeNames 
.const [174] = Utf8 ()[Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory 
.const [176] = Utf8 getDescription 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 java/util/ListIterator 
.const [179] = Utf8 hasNext 
.const [180] = Utf8 ()Z 
.const [181] = Utf8 java/util/ListIterator 
.const [182] = Utf8 next 
.const [183] = Utf8 ()Ljava/lang/Object; 
.const [184] = Utf8 de/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory 
.const [185] = Utf8 enableSpawning 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory 
.const [188] = Utf8 disableSpawning 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider 
.const [191] = Utf8 createSpawnConnectionFactory 
.const [192] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lde/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory; 
.const [193] = Utf8 de/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory 
.const [194] = Utf8 setListener 
.const [195] = Utf8 (Lde/esolutions/fw/util/serializer/connection/ISpawnedConnectionListener;)V 
.const [196] = Utf8 de/esolutions/fw/comm/agent/client/SpawnList 
.const [197] = Class [196] 
.const [198] = Utf8 java/lang/Object 
.const [199] = Class [198] 
.const [200] = Utf8 provider 
.const [201] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider; 
.const [202] = Utf8 listener 
.const [203] = Utf8 Lde/esolutions/fw/util/serializer/connection/ISpawnedConnectionListener; 
.const [204] = Utf8 factories 
.const [205] = Utf8 Ljava/util/ArrayList; 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/esolutions/fw/comm/agent/naming/INameService;Lde/esolutions/fw/util/serializer/connection/IConnectionFactoryProvider;Lde/esolutions/fw/util/serializer/connection/ISpawnedConnectionListener;)V 
.const [209] = Utf8 enableSpawning 
.const [210] = Utf8 ()V 
.const [211] = Utf8 disableSpawning 
.const [212] = Utf8 ()V 
.const [213] = Utf8 isFactoryAvailable 
.const [214] = Utf8 (Lde/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory;)Z 
.const [215] = Utf8 createFactoryForNode 
.const [216] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/serializer/connection/ISpawnConnectionFactory; 
.end class 

.version 50 0 
.class public super [220] 
.super [222] 
.implements [224] 
.implements [226] 
.field private static final [227] [228] 
.field private final [229] [230] 
.field private final [231] [232] 
.field private volatile transient [233] [234] 
.field private volatile transient [235] [236] 

.method private [238] : [239] 
    .attribute [237] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L23 using L28 
L7:     aload_0 
L8:     getfield [15] 
L11:    aload_1 
L12:    if_acmpne L24 
L15:    aload_0 
L16:    aload_2 
L17:    putfield [39] 
L20:    iconst_1 
L21:    aload_3 
L22:    monitorexit 
L23:    areturn 
        .catch [0] from L24 to L27 using L28 
L24:    iconst_0 
L25:    aload_3 
L26:    monitorexit 
L27:    areturn 
        .catch [0] from L28 to L32 using L28 
L28:    astore 4 
L30:    aload_3 
L31:    monitorexit 
L32:    aload 4 
L34:    athrow 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [240] : [241] 
    .attribute [237] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L23 using L28 
L7:     aload_0 
L8:     getfield [17] 
L11:    aload_1 
L12:    if_acmpne L24 
L15:    aload_0 
L16:    aload_2 
L17:    putfield [41] 
L20:    iconst_1 
L21:    aload_3 
L22:    monitorexit 
L23:    areturn 
        .catch [0] from L24 to L27 using L28 
L24:    iconst_0 
L25:    aload_3 
L26:    monitorexit 
L27:    areturn 
        .catch [0] from L28 to L32 using L28 
L28:    astore 4 
L30:    aload_3 
L31:    monitorexit 
L32:    aload 4 
L34:    athrow 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [237] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     new [42] 
L8:     dup 
L9:     aconst_null 
L10:    invokespecial [32] 
L13:    putfield [40] 
L16:    aload_0 
L17:    new [42] 
L20:    dup 
L21:    aconst_null 
L22:    invokespecial [32] 
L25:    putfield [38] 
L28:    aload_0 
L29:    new [43] 
L32:    dup 
L33:    aconst_null 
L34:    aconst_null 
L35:    invokespecial [33] 
L38:    putfield [41] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [17] 
L46:    putfield [39] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [237] .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     new [42] 
L8:     dup 
L9:     aconst_null 
L10:    invokespecial [32] 
L13:    putfield [40] 
L16:    aload_0 
L17:    new [42] 
L20:    dup 
L21:    aconst_null 
L22:    invokespecial [32] 
L25:    putfield [38] 
L28:    aload_0 
L29:    new [43] 
L32:    dup 
L33:    aconst_null 
L34:    aconst_null 
L35:    invokespecial [33] 
L38:    putfield [41] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [17] 
L46:    putfield [39] 
L49:    aload_1 
L50:    invokeinterface [44] 0 
L55:    astore_2 
L56:    aload_2 
L57:    invokeinterface [45] 0 
L62:    ifeq L79 
L65:    aload_0 
L66:    aload_2 
L67:    invokeinterface [46] 0 
L72:    invokevirtual [18] 
L75:    pop 
L76:    goto L56 
L79:    return 
L80:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [237] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [19] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [237] .code stack 4 locals 3 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [47] 
L7:     dup 
L8:     invokespecial [34] 
L11:    athrow 
L12:    new [43] 
L15:    dup 
L16:    aload_1 
L17:    aconst_null 
L18:    invokespecial [33] 
L21:    astore_2 
L22:    aload_0 
L23:    getfield [15] 
L26:    astore_3 
L27:    aload_3 
L28:    invokevirtual [20] 
L31:    astore 4 
L33:    aload_3 
L34:    aload_0 
L35:    getfield [15] 
L38:    if_acmpne L73 
L41:    aload 4 
L43:    ifnonnull L65 
L46:    aload_3 
L47:    aload 4 
L49:    aload_2 
L50:    invokevirtual [21] 
L53:    ifeq L73 
L56:    aload_0 
L57:    aload_3 
L58:    aload_2 
L59:    invokespecial [35] 
L62:    pop 
L63:    iconst_1 
L64:    areturn 
L65:    aload_0 
L66:    aload_3 
L67:    aload 4 
L69:    invokespecial [35] 
L72:    pop 
L73:    goto L22 
L76:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [237] .code stack 3 locals 4 
L0:     aload_0 
L1:     getfield [17] 
L4:     astore_1 
L5:     aload_0 
L6:     getfield [15] 
L9:     astore_2 
L10:    aload_1 
L11:    invokevirtual [20] 
L14:    astore_3 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [17] 
L20:    if_acmpne L72 
L23:    aload_1 
L24:    aload_2 
L25:    if_acmpne L44 
L28:    aload_3 
L29:    ifnonnull L34 
L32:    aconst_null 
L33:    areturn 
L34:    aload_0 
L35:    aload_2 
L36:    aload_3 
L37:    invokespecial [35] 
L40:    pop 
L41:    goto L72 
L44:    aload_0 
L45:    aload_1 
L46:    aload_3 
L47:    invokespecial [36] 
L50:    ifeq L72 
L53:    aload_3 
L54:    invokevirtual [22] 
L57:    astore 4 
L59:    aload 4 
L61:    ifnull L72 
L64:    aload_3 
L65:    aconst_null 
L66:    invokevirtual [23] 
L69:    aload 4 
L71:    areturn 
L72:    goto L0 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [237] .code stack 3 locals 4 
L0:     aload_0 
L1:     getfield [17] 
L4:     astore_1 
L5:     aload_0 
L6:     getfield [15] 
L9:     astore_2 
L10:    aload_1 
L11:    invokevirtual [20] 
L14:    astore_3 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [17] 
L20:    if_acmpne L65 
L23:    aload_1 
L24:    aload_2 
L25:    if_acmpne L44 
L28:    aload_3 
L29:    ifnonnull L34 
L32:    aconst_null 
L33:    areturn 
L34:    aload_0 
L35:    aload_2 
L36:    aload_3 
L37:    invokespecial [35] 
L40:    pop 
L41:    goto L65 
L44:    aload_3 
L45:    invokevirtual [22] 
L48:    astore 4 
L50:    aload 4 
L52:    ifnull L58 
L55:    aload 4 
L57:    areturn 
L58:    aload_0 
L59:    aload_1 
L60:    aload_3 
L61:    invokespecial [36] 
L64:    pop 
L65:    goto L0 
L68:    
    .end code 
.end method 

.method [254] : [255] 
    .attribute [237] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [17] 
L4:     astore_1 
L5:     aload_0 
L6:     getfield [15] 
L9:     astore_2 
L10:    aload_1 
L11:    invokevirtual [20] 
L14:    astore_3 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [17] 
L20:    if_acmpne L60 
L23:    aload_1 
L24:    aload_2 
L25:    if_acmpne L44 
L28:    aload_3 
L29:    ifnonnull L34 
L32:    aconst_null 
L33:    areturn 
L34:    aload_0 
L35:    aload_2 
L36:    aload_3 
L37:    invokespecial [35] 
L40:    pop 
L41:    goto L60 
L44:    aload_3 
L45:    invokevirtual [22] 
L48:    ifnull L53 
L51:    aload_3 
L52:    areturn 
L53:    aload_0 
L54:    aload_1 
L55:    aload_3 
L56:    invokespecial [36] 
L59:    pop 
L60:    goto L0 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [237] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [24] 
L4:     ifnonnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [237] .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual [24] 
L6:     astore_2 
L7:     aload_2 
L8:     ifnull L38 
L11:    aload_2 
L12:    invokevirtual [22] 
L15:    ifnull L30 
L18:    iinc 1 1 
L21:    iload_1 
L22:    ldc [5] 
L24:    if_icmpne L30 
L27:    goto L38 
L30:    aload_2 
L31:    invokevirtual [20] 
L34:    astore_2 
L35:    goto L7 
L38:    iload_1 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [237] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [24] 
L10:    astore_2 
L11:    aload_2 
L12:    ifnull L42 
L15:    aload_2 
L16:    invokevirtual [22] 
L19:    astore_3 
L20:    aload_3 
L21:    ifnull L34 
L24:    aload_1 
L25:    aload_3 
L26:    invokevirtual [25] 
L29:    ifeq L34 
L32:    iconst_1 
L33:    areturn 
L34:    aload_2 
L35:    invokevirtual [20] 
L38:    astore_2 
L39:    goto L11 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [237] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [24] 
L10:    astore_2 
L11:    aload_2 
L12:    ifnull L51 
L15:    aload_2 
L16:    invokevirtual [22] 
L19:    astore_3 
L20:    aload_3 
L21:    ifnull L43 
L24:    aload_1 
L25:    aload_3 
L26:    invokevirtual [25] 
L29:    ifeq L43 
L32:    aload_2 
L33:    aload_3 
L34:    aconst_null 
L35:    invokevirtual [26] 
L38:    ifeq L43 
L41:    iconst_1 
L42:    areturn 
L43:    aload_2 
L44:    invokevirtual [20] 
L47:    astore_2 
L48:    goto L11 
L51:    iconst_0 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [264] : [265] 
    .attribute [237] .code stack 3 locals 0 
L0:     new [48] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [37] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [266] : [267] 
    .attribute [237] .code stack 2 locals 2 
L0:     aload_1 
L1:     invokevirtual [27] 
L4:     aload_0 
L5:     invokevirtual [24] 
L8:     astore_2 
L9:     aload_2 
L10:    ifnull L35 
L13:    aload_2 
L14:    invokevirtual [22] 
L17:    astore_3 
L18:    aload_3 
L19:    ifnull L27 
L22:    aload_1 
L23:    aload_3 
L24:    invokevirtual [28] 
L27:    aload_2 
L28:    invokevirtual [20] 
L31:    astore_2 
L32:    goto L9 
L35:    aload_1 
L36:    aconst_null 
L37:    invokevirtual [28] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [268] : [269] 
    .attribute [237] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [29] 
L4:     aload_0 
L5:     new [43] 
L8:     dup 
L9:     aconst_null 
L10:    aconst_null 
L11:    invokespecial [33] 
L14:    putfield [41] 
L17:    aload_0 
L18:    aload_0 
L19:    getfield [17] 
L22:    putfield [39] 
L25:    aload_1 
L26:    invokevirtual [30] 
L29:    astore_2 
L30:    aload_2 
L31:    ifnonnull L37 
L34:    goto L46 
L37:    aload_0 
L38:    aload_2 
L39:    invokevirtual [19] 
L42:    pop 
L43:    goto L25 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = Class [50] 
.const [4] = Class [51] 
.const [5] = Int -129 
.const [6] = Class [52] 
.const [7] = Class [53] 
.const [8] = Class [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Class [57] 
.const [12] = Class [58] 
.const [13] = Class [59] 
.const [14] = Field [60] [61] 
.const [15] = Field [62] [63] 
.const [16] = Field [64] [65] 
.const [17] = Field [66] [67] 
.const [18] = Method [68] [69] 
.const [19] = Method [70] [71] 
.const [20] = Method [72] [73] 
.const [21] = Method [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Field [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Field [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Class [116] 
.const [43] = Class [117] 
.const [44] = InterfaceMethod [118] [119] 
.const [45] = InterfaceMethod [120] [121] 
.const [46] = InterfaceMethod [122] [123] 
.const [47] = Class [124] 
.const [48] = Class [125] 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$SerializableLock 
.const [50] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [51] = Utf8 java/lang/NullPointerException 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [53] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [54] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [55] = Utf8 java/util/Collection 
.const [56] = Utf8 java/util/Iterator 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 java/io/ObjectOutputStream 
.const [59] = Utf8 java/io/ObjectInputStream 
.const [60] = Class [126] 
.const [61] = NameAndType [127] [128] 
.const [62] = Class [129] 
.const [63] = NameAndType [130] [131] 
.const [64] = Class [132] 
.const [65] = NameAndType [133] [134] 
.const [66] = Class [135] 
.const [67] = NameAndType [136] [137] 
.const [68] = Class [138] 
.const [69] = NameAndType [139] [140] 
.const [70] = Class [141] 
.const [71] = NameAndType [142] [143] 
.const [72] = Class [144] 
.const [73] = NameAndType [145] [146] 
.const [74] = Class [147] 
.const [75] = NameAndType [148] [149] 
.const [76] = Class [150] 
.const [77] = NameAndType [151] [152] 
.const [78] = Class [153] 
.const [79] = NameAndType [154] [155] 
.const [80] = Class [156] 
.const [81] = NameAndType [157] [158] 
.const [82] = Class [159] 
.const [83] = NameAndType [160] [161] 
.const [84] = Class [162] 
.const [85] = NameAndType [163] [164] 
.const [86] = Class [165] 
.const [87] = NameAndType [166] [167] 
.const [88] = Class [168] 
.const [89] = NameAndType [169] [170] 
.const [90] = Class [171] 
.const [91] = NameAndType [172] [173] 
.const [92] = Class [174] 
.const [93] = NameAndType [175] [176] 
.const [94] = Class [177] 
.const [95] = NameAndType [178] [179] 
.const [96] = Class [180] 
.const [97] = NameAndType [181] [182] 
.const [98] = Class [183] 
.const [99] = NameAndType [184] [185] 
.const [100] = Class [186] 
.const [101] = NameAndType [187] [188] 
.const [102] = Class [189] 
.const [103] = NameAndType [190] [191] 
.const [104] = Class [192] 
.const [105] = NameAndType [193] [194] 
.const [106] = Class [195] 
.const [107] = NameAndType [196] [197] 
.const [108] = Class [198] 
.const [109] = NameAndType [199] [200] 
.const [110] = Class [201] 
.const [111] = NameAndType [202] [203] 
.const [112] = Class [204] 
.const [113] = NameAndType [205] [206] 
.const [114] = Class [207] 
.const [115] = NameAndType [208] [209] 
.const [116] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$SerializableLock 
.const [117] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [118] = Class [210] 
.const [119] = NameAndType [211] [212] 
.const [120] = Class [213] 
.const [121] = NameAndType [214] [215] 
.const [122] = Class [216] 
.const [123] = NameAndType [217] [218] 
.const [124] = Utf8 java/lang/NullPointerException 
.const [125] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [126] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [127] = Utf8 tailLock 
.const [128] = Utf8 Ljava/lang/Object; 
.const [129] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [130] = Utf8 tail 
.const [131] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [132] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [133] = Utf8 headLock 
.const [134] = Utf8 Ljava/lang/Object; 
.const [135] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [136] = Utf8 head 
.const [137] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [138] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [139] = Utf8 add 
.const [140] = Utf8 (Ljava/lang/Object;)Z 
.const [141] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [142] = Utf8 offer 
.const [143] = Utf8 (Ljava/lang/Object;)Z 
.const [144] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [145] = Utf8 getNext 
.const [146] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [147] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [148] = Utf8 casNext 
.const [149] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [150] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [151] = Utf8 getItem 
.const [152] = Utf8 ()Ljava/lang/Object; 
.const [153] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [154] = Utf8 setItem 
.const [155] = Utf8 (Ljava/lang/Object;)V 
.const [156] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [157] = Utf8 first 
.const [158] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [159] = Utf8 java/lang/Object 
.const [160] = Utf8 equals 
.const [161] = Utf8 (Ljava/lang/Object;)Z 
.const [162] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [163] = Utf8 casItem 
.const [164] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [165] = Utf8 java/io/ObjectOutputStream 
.const [166] = Utf8 defaultWriteObject 
.const [167] = Utf8 ()V 
.const [168] = Utf8 java/io/ObjectOutputStream 
.const [169] = Utf8 writeObject 
.const [170] = Utf8 (Ljava/lang/Object;)V 
.const [171] = Utf8 java/io/ObjectInputStream 
.const [172] = Utf8 defaultReadObject 
.const [173] = Utf8 ()V 
.const [174] = Utf8 java/io/ObjectInputStream 
.const [175] = Utf8 readObject 
.const [176] = Utf8 ()Ljava/lang/Object; 
.const [177] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [178] = Utf8 <init> 
.const [179] = Utf8 ()V 
.const [180] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$SerializableLock 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$1;)V 
.const [183] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Ljava/lang/Object;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)V 
.const [186] = Utf8 java/lang/NullPointerException 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [190] = Utf8 casTail 
.const [191] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [192] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [193] = Utf8 casHead 
.const [194] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [195] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue;)V 
.const [198] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [199] = Utf8 tailLock 
.const [200] = Utf8 Ljava/lang/Object; 
.const [201] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [202] = Utf8 tail 
.const [203] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [204] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [205] = Utf8 headLock 
.const [206] = Utf8 Ljava/lang/Object; 
.const [207] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [208] = Utf8 head 
.const [209] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [210] = Utf8 java/util/Collection 
.const [211] = Utf8 iterator 
.const [212] = Utf8 ()Ljava/util/Iterator; 
.const [213] = Utf8 java/util/Iterator 
.const [214] = Utf8 hasNext 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 java/util/Iterator 
.const [217] = Utf8 next 
.const [218] = Utf8 ()Ljava/lang/Object; 
.const [219] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [220] = Class [219] 
.const [221] = Utf8 edu/emory/mathcs/backport/java/util/AbstractQueue 
.const [222] = Class [221] 
.const [223] = Utf8 edu/emory/mathcs/backport/java/util/Queue 
.const [224] = Class [223] 
.const [225] = Utf8 java/io/Serializable 
.const [226] = Class [225] 
.const [227] = Utf8 serialVersionUID 
.const [228] = Utf8 J 
.const [229] = Utf8 headLock 
.const [230] = Utf8 Ljava/lang/Object; 
.const [231] = Utf8 tailLock 
.const [232] = Utf8 Ljava/lang/Object; 
.const [233] = Utf8 head 
.const [234] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [235] = Utf8 tail 
.const [236] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [237] = Utf8 Code 
.const [238] = Utf8 casTail 
.const [239] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [240] = Utf8 casHead 
.const [241] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node;)Z 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (Ljava/util/Collection;)V 
.const [246] = Utf8 add 
.const [247] = Utf8 (Ljava/lang/Object;)Z 
.const [248] = Utf8 offer 
.const [249] = Utf8 (Ljava/lang/Object;)Z 
.const [250] = Utf8 poll 
.const [251] = Utf8 ()Ljava/lang/Object; 
.const [252] = Utf8 peek 
.const [253] = Utf8 ()Ljava/lang/Object; 
.const [254] = Utf8 first 
.const [255] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [256] = Utf8 isEmpty 
.const [257] = Utf8 ()Z 
.const [258] = Utf8 size 
.const [259] = Utf8 ()I 
.const [260] = Utf8 contains 
.const [261] = Utf8 (Ljava/lang/Object;)Z 
.const [262] = Utf8 remove 
.const [263] = Utf8 (Ljava/lang/Object;)Z 
.const [264] = Utf8 iterator 
.const [265] = Utf8 ()Ljava/util/Iterator; 
.const [266] = Utf8 writeObject 
.const [267] = Utf8 (Ljava/io/ObjectOutputStream;)V 
.const [268] = Utf8 readObject 
.const [269] = Utf8 (Ljava/io/ObjectInputStream;)V 
.end class 

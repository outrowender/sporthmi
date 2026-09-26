.version 50 0 
.class public super abstract [194] 
.super [196] 
.field private final [197] [198] 
.field private [199] [200] 
.field protected final [201] [202] 
.field public static final [203] [204] 

.method protected [206] : [207] 
    .attribute [205] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [27] 
L9:     aload_0 
L10:    new [28] 
L13:    dup 
L14:    invokespecial [26] 
L17:    putfield [29] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [30] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [205] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [18] 
L11:    aload_1 
L12:    monitorexit 
L13:    areturn 
        .catch [0] from L14 to L17 using L14 
L14:    astore_2 
L15:    aload_1 
L16:    monitorexit 
L17:    aload_2 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [205] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L18 using L19 
L7:     aload_0 
L8:     getfield [19] 
L11:    invokeinterface [31] 0 
L16:    aload_1 
L17:    monitorexit 
L18:    areturn 
        .catch [0] from L19 to L22 using L19 
L19:    astore_2 
L20:    aload_1 
L21:    monitorexit 
L22:    aload_2 
L23:    athrow 
L24:    
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [205] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L23 using L26 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [27] 
L12:    aload_0 
L13:    getfield [19] 
L16:    invokeinterface [32] 0 
L21:    aload_1 
L22:    monitorexit 
L23:    goto L31 
        .catch [0] from L26 to L29 using L26 
L26:    astore_2 
L27:    aload_1 
L28:    monitorexit 
L29:    aload_2 
L30:    athrow 
L31:    return 
L32:    
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [205] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L32 using L33 
L7:     aload_1 
L8:     invokeinterface [33] 0 
L13:    aload_0 
L14:    getfield [19] 
L17:    invokeinterface [31] 0 
L22:    if_icmple L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    aload_2 
L31:    monitorexit 
L32:    areturn 
        .catch [0] from L33 to L36 using L33 
L33:    astore_3 
L34:    aload_2 
L35:    monitorexit 
L36:    aload_3 
L37:    athrow 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public abstract [216] : [217] 
    .attribute [205] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static [218] : [219] 
    .attribute [205] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     invokeinterface [31] 0 
L9:     if_icmpge L39 
L12:    aload_0 
L13:    iload_2 
L14:    invokeinterface [34] 0 
L19:    checkcast [3] 
L22:    invokeinterface [35] 0 
L27:    iload_1 
L28:    if_icmpne L33 
L31:    iload_2 
L32:    areturn 
L33:    iinc 2 1 
L36:    goto L2 
L39:    iconst_m1 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [205] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [21] 
L5:     ifeq L22 
L8:     aload_0 
L9:     getfield [19] 
L12:    iload_2 
L13:    invokeinterface [36] 0 
L18:    pop 
L19:    goto L34 
L22:    aload_0 
L23:    getfield [19] 
L26:    iload_2 
L27:    aload_1 
L28:    invokeinterface [37] 0 
L33:    pop 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [205] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L27 using L160 
L7:     aload_1 
L8:     invokeinterface [33] 0 
L13:    ifne L28 
L16:    aload_0 
L17:    getfield [19] 
L20:    invokeinterface [32] 0 
L25:    aload_2 
L26:    monitorexit 
L27:    return 
        .catch [0] from L28 to L157 using L160 
L28:    aload_1 
L29:    invokeinterface [38] 0 
L34:    invokevirtual [22] 
L37:    astore_3 
L38:    aload_3 
L39:    invokeinterface [39] 0 
L44:    ifeq L132 
L47:    aload_3 
L48:    invokeinterface [40] 0 
L53:    checkcast [3] 
L56:    astore 4 
L58:    aload_0 
L59:    getfield [19] 
L62:    aload 4 
L64:    invokeinterface [35] 0 
L69:    invokestatic [4] 
L72:    istore 5 
L74:    iload 5 
L76:    iconst_m1 
L77:    if_icmpne L121 
L80:    aload_0 
L81:    aload 4 
L83:    invokevirtual [21] 
L86:    ifne L104 
L89:    aload_0 
L90:    getfield [19] 
L93:    aload 4 
L95:    invokeinterface [41] 0 
L100:   pop 
L101:   goto L129 
L104:   aload_0 
L105:   getfield [20] 
L108:   ldc [5] 
L110:   ldc [6] 
L112:   aload 4 
L114:   invokevirtual [23] 
L117:   pop 
L118:   goto L129 
L121:   aload_0 
L122:   aload 4 
L124:   iload 5 
L126:   invokevirtual [24] 
L129:   goto L38 
L132:   aload_0 
L133:   getfield [19] 
L136:   invokeinterface [31] 0 
L141:   aload_1 
L142:   invokeinterface [33] 0 
L147:   if_icmpne L155 
L150:   aload_0 
L151:   iconst_1 
L152:   putfield [27] 
L155:   aload_2 
L156:   monitorexit 
L157:   goto L167 
        .catch [0] from L160 to L164 using L160 
L160:   astore 6 
L162:   aload_2 
L163:   monitorexit 
L164:   aload 6 
L166:   athrow 
L167:   return 
L168:   
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [205] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L83 using L84 
L7:     aload_1 
L8:     aload_0 
L9:     getfield [19] 
L12:    invokeinterface [31] 0 
L17:    invokestatic [7] 
L20:    checkcast [8] 
L23:    checkcast [8] 
L26:    astore 4 
L28:    aload_0 
L29:    getfield [19] 
L32:    invokeinterface [42] 0 
L37:    astore 5 
L39:    iconst_0 
L40:    istore 6 
L42:    aload 5 
L44:    invokeinterface [39] 0 
L49:    ifeq L79 
L52:    aload 4 
L54:    iload 6 
L56:    aload_2 
L57:    aload 5 
L59:    invokeinterface [40] 0 
L64:    checkcast [3] 
L67:    invokeinterface [43] 0 
L72:    aastore 
L73:    iinc 6 1 
L76:    goto L42 
L79:    aload 4 
L81:    aload_3 
L82:    monitorexit 
L83:    areturn 
        .catch [0] from L84 to L88 using L84 
L84:    astore 7 
L86:    aload_3 
L87:    monitorexit 
L88:    aload 7 
L90:    athrow 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = Class [45] 
.const [4] = Method [46] [47] 
.const [5] = Int -1601830656 
.const [6] = String [48] 
.const [7] = Method [49] [50] 
.const [8] = Class [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = Class [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Field [61] [62] 
.const [19] = Field [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Class [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = InterfaceMethod [86] [87] 
.const [32] = InterfaceMethod [88] [89] 
.const [33] = InterfaceMethod [90] [91] 
.const [34] = InterfaceMethod [92] [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = InterfaceMethod [96] [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = Utf8 java/util/ArrayList 
.const [45] = Utf8 de/vw/mib/bap/datatypes/BAPArrayElement 
.const [46] = Class [112] 
.const [47] = NameAndType [113] [114] 
.const [48] = Utf8 '[BAPArrayElementList#mergeElementsInList] new element marked as deleted. Ignoring:\n%1' 
.const [49] = Class [115] 
.const [50] = NameAndType [116] [117] 
.const [51] = Utf8 [Ljava/lang/Object; 
.const [52] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG$BAPElementConverter 
.const [55] = Utf8 java/util/List 
.const [56] = Utf8 de/vw/mib/bap/requests/StatusArray 
.const [57] = Utf8 de/vw/mib/bap/datatypes/BAPArrayData 
.const [58] = Utf8 java/util/Iterator 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 java/lang/reflect/Array 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Class [136] 
.const [74] = NameAndType [137] [138] 
.const [75] = Class [139] 
.const [76] = NameAndType [140] [141] 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Utf8 java/util/ArrayList 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Class [154] 
.const [87] = NameAndType [155] [156] 
.const [88] = Class [157] 
.const [89] = NameAndType [158] [159] 
.const [90] = Class [160] 
.const [91] = NameAndType [161] [162] 
.const [92] = Class [163] 
.const [93] = NameAndType [164] [165] 
.const [94] = Class [166] 
.const [95] = NameAndType [167] [168] 
.const [96] = Class [169] 
.const [97] = NameAndType [170] [171] 
.const [98] = Class [172] 
.const [99] = NameAndType [173] [174] 
.const [100] = Class [175] 
.const [101] = NameAndType [176] [177] 
.const [102] = Class [178] 
.const [103] = NameAndType [179] [180] 
.const [104] = Class [181] 
.const [105] = NameAndType [182] [183] 
.const [106] = Class [184] 
.const [107] = NameAndType [185] [186] 
.const [108] = Class [187] 
.const [109] = NameAndType [188] [189] 
.const [110] = Class [190] 
.const [111] = NameAndType [191] [192] 
.const [112] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [113] = Utf8 indexOfElementWithPosId 
.const [114] = Utf8 (Ljava/util/List;I)I 
.const [115] = Utf8 java/lang/reflect/Array 
.const [116] = Utf8 newInstance 
.const [117] = Utf8 (Ljava/lang/Class;I)Ljava/lang/Object; 
.const [118] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [119] = Utf8 upToDate 
.const [120] = Utf8 Z 
.const [121] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [122] = Utf8 list 
.const [123] = Utf8 Ljava/util/List; 
.const [124] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [125] = Utf8 logChannel 
.const [126] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [127] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [128] = Utf8 isDeleted 
.const [129] = Utf8 (Lde/vw/mib/bap/datatypes/BAPArrayElement;)Z 
.const [130] = Utf8 de/vw/mib/bap/datatypes/BAPArrayData 
.const [131] = Utf8 getIterator 
.const [132] = Utf8 ()Ljava/util/Iterator; 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [137] = Utf8 handleFoundElement 
.const [138] = Utf8 (Lde/vw/mib/bap/datatypes/BAPArrayElement;I)V 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 java/util/ArrayList 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [146] = Utf8 upToDate 
.const [147] = Utf8 Z 
.const [148] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [149] = Utf8 list 
.const [150] = Utf8 Ljava/util/List; 
.const [151] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [152] = Utf8 logChannel 
.const [153] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 java/util/List 
.const [155] = Utf8 size 
.const [156] = Utf8 ()I 
.const [157] = Utf8 java/util/List 
.const [158] = Utf8 clear 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/vw/mib/bap/requests/StatusArray 
.const [161] = Utf8 getNumberOfElements 
.const [162] = Utf8 ()I 
.const [163] = Utf8 java/util/List 
.const [164] = Utf8 get 
.const [165] = Utf8 (I)Ljava/lang/Object; 
.const [166] = Utf8 de/vw/mib/bap/datatypes/BAPArrayElement 
.const [167] = Utf8 getPos 
.const [168] = Utf8 ()I 
.const [169] = Utf8 java/util/List 
.const [170] = Utf8 remove 
.const [171] = Utf8 (I)Ljava/lang/Object; 
.const [172] = Utf8 java/util/List 
.const [173] = Utf8 set 
.const [174] = Utf8 (ILjava/lang/Object;)Ljava/lang/Object; 
.const [175] = Utf8 de/vw/mib/bap/requests/StatusArray 
.const [176] = Utf8 getArrayData 
.const [177] = Utf8 ()Lde/vw/mib/bap/datatypes/BAPArrayData; 
.const [178] = Utf8 java/util/Iterator 
.const [179] = Utf8 hasNext 
.const [180] = Utf8 ()Z 
.const [181] = Utf8 java/util/Iterator 
.const [182] = Utf8 next 
.const [183] = Utf8 ()Ljava/lang/Object; 
.const [184] = Utf8 java/util/List 
.const [185] = Utf8 add 
.const [186] = Utf8 (Ljava/lang/Object;)Z 
.const [187] = Utf8 java/util/List 
.const [188] = Utf8 iterator 
.const [189] = Utf8 ()Ljava/util/Iterator; 
.const [190] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG$BAPElementConverter 
.const [191] = Utf8 convert 
.const [192] = Utf8 (Lde/vw/mib/bap/datatypes/BAPArrayElement;)Ljava/lang/Object; 
.const [193] = Utf8 de/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG 
.const [194] = Class [193] 
.const [195] = Utf8 java/lang/Object 
.const [196] = Class [195] 
.const [197] = Utf8 logChannel 
.const [198] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [199] = Utf8 upToDate 
.const [200] = Utf8 Z 
.const [201] = Utf8 list 
.const [202] = Utf8 Ljava/util/List; 
.const [203] = Utf8 NOT_FOUND 
.const [204] = Utf8 I 
.const [205] = Utf8 Code 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [208] = Utf8 isUpToDate 
.const [209] = Utf8 ()Z 
.const [210] = Utf8 size 
.const [211] = Utf8 ()I 
.const [212] = Utf8 clear 
.const [213] = Utf8 ()V 
.const [214] = Utf8 hasMoreElementsToRequest 
.const [215] = Utf8 (Lde/vw/mib/bap/requests/StatusArray;)Z 
.const [216] = Utf8 isDeleted 
.const [217] = Utf8 (Lde/vw/mib/bap/datatypes/BAPArrayElement;)Z 
.const [218] = Utf8 indexOfElementWithPosId 
.const [219] = Utf8 (Ljava/util/List;I)I 
.const [220] = Utf8 handleFoundElement 
.const [221] = Utf8 (Lde/vw/mib/bap/datatypes/BAPArrayElement;I)V 
.const [222] = Utf8 mergeElementsInList 
.const [223] = Utf8 (Lde/vw/mib/bap/requests/StatusArray;)V 
.const [224] = Utf8 toArray 
.const [225] = Utf8 (Ljava/lang/Class;Lde/audi/app/bap/fw/functiontypes/AbstractBAPArrayElementListASG$BAPElementConverter;)[Ljava/lang/Object; 
.end class 

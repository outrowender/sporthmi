.version 50 0 
.class public super abstract [191] 
.super [193] 
.field private static final [194] [195] 
.field protected volatile [196] [197] 

.method public [199] : [200] 
    .attribute [198] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [31] 
L6:     aload_0 
L7:     iconst_0 
L8:     anewarray [2] 
L11:    putfield [37] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [198] .code stack 6 locals 1 
L0:     aload_1 
L1:     ifnonnull L22 
L4:     aload_0 
L5:     getfield [22] 
L8:     sipush 10000 
L11:    ldc [3] 
L13:    aload_0 
L14:    getfield [23] 
L17:    invokevirtual [24] 
L20:    pop 
L21:    return 
L22:    aload_0 
L23:    getfield [22] 
L26:    ldc [4] 
L28:    ldc [5] 
L30:    aload_0 
L31:    getfield [23] 
L34:    aload_1 
L35:    arraylength 
L36:    i2l 
L37:    invokevirtual [25] 
L40:    pop 
L41:    aload_0 
L42:    getfield [21] 
L45:    arraylength 
L46:    ifne L73 
L49:    aload_1 
L50:    arraylength 
L51:    ifne L73 
L54:    aload_0 
L55:    getfield [22] 
L58:    ldc [4] 
L60:    ldc [6] 
L62:    aload_0 
L63:    getfield [23] 
L66:    invokevirtual [24] 
L69:    pop 
L70:    goto L93 
L73:    aload_0 
L74:    getfield [21] 
L77:    aload_1 
L78:    invokestatic [7] 
L81:    astore_2 
L82:    aload_0 
L83:    aload_1 
L84:    putfield [37] 
L87:    aload_0 
L88:    aload_2 
L89:    invokevirtual [26] 
L92:    pop 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [198] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [32] 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [33] 
L10:    astore_2 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [27] 
L16:    aload_2 
L17:    invokevirtual [28] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public annotation [205] : [206] 
    .attribute [198] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     invokespecial [34] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [207] : [208] 
    .attribute [198] .code stack 6 locals 2 
L0:     aload_1 
L1:     invokevirtual [29] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     aload_0 
L10:    getfield [21] 
L13:    aload_2 
L14:    invokeinterface [38] 0 
L19:    aload_2 
L20:    invokeinterface [39] 0 
L25:    aload_2 
L26:    invokeinterface [40] 0 
L31:    aload_2 
L32:    invokeinterface [41] 0 
L37:    invokestatic [8] 
L40:    astore_3 
L41:    aload_3 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [198] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     arraylength 
L5:     anewarray [2] 
L8:     astore_1 
L9:     aload_0 
L10:    getfield [21] 
L13:    iconst_0 
L14:    aload_1 
L15:    iconst_0 
L16:    aload_1 
L17:    arraylength 
L18:    invokestatic [9] 
L21:    aload_0 
L22:    getfield [21] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [198] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L46 
L7:     iconst_0 
L8:     istore_2 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [21] 
L14:    arraylength 
L15:    if_icmpge L46 
L18:    aload_0 
L19:    getfield [21] 
L22:    iload_2 
L23:    aaload 
L24:    invokeinterface [42] 0 
L29:    iload_1 
L30:    if_icmpne L40 
L33:    aload_0 
L34:    getfield [21] 
L37:    iload_2 
L38:    aaload 
L39:    areturn 
L40:    iinc 2 1 
L43:    goto L9 
L46:    aconst_null 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [198] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     arraylength 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [215] : [216] 
    .attribute [198] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected final [217] : [218] 
    .attribute [198] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [21] 
L4:     iload_1 
L5:     invokestatic [10] 
L8:     istore_3 
L9:     iload_3 
L10:    iconst_m1 
L11:    if_icmpne L20 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [35] 
L19:    return 
L20:    iload_3 
L21:    iload_2 
L22:    iadd 
L23:    istore 4 
L25:    iload 4 
L27:    ifge L36 
L30:    aload_0 
L31:    iload_1 
L32:    invokespecial [35] 
L35:    return 
L36:    iload 4 
L38:    aload_0 
L39:    getfield [21] 
L42:    arraylength 
L43:    if_icmplt L52 
L46:    aload_0 
L47:    iload_1 
L48:    invokespecial [35] 
L51:    return 
L52:    aload_0 
L53:    getfield [21] 
L56:    iload 4 
L58:    invokestatic [11] 
L61:    istore 5 
L63:    iload 5 
L65:    iconst_m1 
L66:    if_icmpne L75 
L69:    aload_0 
L70:    iload_1 
L71:    invokespecial [35] 
L74:    return 
L75:    iload 4 
L77:    iconst_1 
L78:    iadd 
L79:    istore 6 
L81:    aload_0 
L82:    iload_1 
L83:    iload 5 
L85:    iload 6 
L87:    invokespecial [36] 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 

.method protected final [219] : [220] 
    .attribute [198] .code stack 4 locals 2 
L0:     iload_1 
L1:     iload_2 
L2:     iadd 
L3:     istore_3 
L4:     iload_3 
L5:     ifge L14 
L8:     aload_0 
L9:     iload_1 
L10:    invokespecial [35] 
L13:    return 
L14:    iload_3 
L15:    aload_0 
L16:    getfield [21] 
L19:    arraylength 
L20:    if_icmplt L29 
L23:    aload_0 
L24:    iload_1 
L25:    invokespecial [35] 
L28:    return 
L29:    iload_3 
L30:    iconst_1 
L31:    iadd 
L32:    istore 4 
L34:    aload_0 
L35:    iload_1 
L36:    iload_3 
L37:    iload 4 
L39:    invokespecial [36] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [221] : [222] 
    .attribute [198] .code stack 5 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     iload_2 
L4:     iload_3 
L5:     invokevirtual [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [223] : [224] 
    .attribute [198] .code stack 5 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     iload_1 
L3:     ldc [12] 
L5:     ldc [12] 
L7:     invokevirtual [30] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [198] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L61 
L7:     iconst_0 
L8:     istore_2 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [21] 
L14:    arraylength 
L15:    if_icmpge L61 
L18:    aload_0 
L19:    getfield [21] 
L22:    iload_2 
L23:    aaload 
L24:    invokeinterface [42] 0 
L29:    iload_1 
L30:    if_icmpne L55 
L33:    iload_2 
L34:    ifne L41 
L37:    iconst_0 
L38:    goto L54 
L41:    aload_0 
L42:    getfield [21] 
L45:    iload_2 
L46:    iconst_1 
L47:    isub 
L48:    aaload 
L49:    invokeinterface [42] 0 
L54:    areturn 
L55:    iinc 2 1 
L58:    goto L9 
L61:    iconst_0 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [198] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L68 
L7:     iconst_0 
L8:     istore_2 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [21] 
L14:    arraylength 
L15:    if_icmpge L68 
L18:    aload_0 
L19:    getfield [21] 
L22:    iload_2 
L23:    aaload 
L24:    invokeinterface [42] 0 
L29:    iload_1 
L30:    if_icmpne L62 
L33:    iload_2 
L34:    aload_0 
L35:    getfield [21] 
L38:    arraylength 
L39:    iconst_1 
L40:    isub 
L41:    if_icmpne L48 
L44:    iconst_0 
L45:    goto L61 
L48:    aload_0 
L49:    getfield [21] 
L52:    iload_2 
L53:    iconst_1 
L54:    iadd 
L55:    aaload 
L56:    invokeinterface [42] 0 
L61:    areturn 
L62:    iinc 2 1 
L65:    goto L9 
L68:    iconst_0 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = String [44] 
.const [4] = Int -2137614336 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = Method [47] [48] 
.const [8] = Method [49] [50] 
.const [9] = Method [51] [52] 
.const [10] = Method [53] [54] 
.const [11] = Method [55] [56] 
.const [12] = Int -65536 
.const [13] = Class [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Field [65] [66] 
.const [22] = Field [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = Utf8 de/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement 
.const [44] = Utf8 '[%1#updateList] invalid list update: newList is null' 
.const [45] = Utf8 '[%1#updateList] listSize=%2' 
.const [46] = Utf8 "[%1#updateList] list is still empty -> don't send ChangedArray" 
.const [47] = Class [109] 
.const [48] = NameAndType [110] [111] 
.const [49] = Class [112] 
.const [50] = NameAndType [113] [114] 
.const [51] = Class [115] 
.const [52] = NameAndType [116] [117] 
.const [53] = Class [118] 
.const [54] = NameAndType [119] [120] 
.const [55] = Class [121] 
.const [56] = NameAndType [122] [123] 
.const [57] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [58] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 de/audi/app/bap/fw/arrays/ListDelta 
.const [61] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [62] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [63] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [64] = Utf8 java/lang/System 
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
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Class [151] 
.const [84] = NameAndType [152] [153] 
.const [85] = Class [154] 
.const [86] = NameAndType [155] [156] 
.const [87] = Class [157] 
.const [88] = NameAndType [158] [159] 
.const [89] = Class [160] 
.const [90] = NameAndType [161] [162] 
.const [91] = Class [163] 
.const [92] = NameAndType [164] [165] 
.const [93] = Class [166] 
.const [94] = NameAndType [167] [168] 
.const [95] = Class [169] 
.const [96] = NameAndType [170] [171] 
.const [97] = Class [172] 
.const [98] = NameAndType [173] [174] 
.const [99] = Class [175] 
.const [100] = NameAndType [176] [177] 
.const [101] = Class [178] 
.const [102] = NameAndType [179] [180] 
.const [103] = Class [181] 
.const [104] = NameAndType [182] [183] 
.const [105] = Class [184] 
.const [106] = NameAndType [185] [186] 
.const [107] = Class [187] 
.const [108] = NameAndType [188] [189] 
.const [109] = Utf8 de/audi/app/bap/fw/arrays/ListDelta 
.const [110] = Utf8 compare 
.const [111] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Lde/audi/app/bap/fw/arrays/ListDelta; 
.const [112] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [113] = Utf8 getListSection 
.const [114] = Utf8 (Lde/audi/atip/log/LogChannel;[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;IIZZ)[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [115] = Utf8 java/lang/System 
.const [116] = Utf8 arraycopy 
.const [117] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [118] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [119] = Utf8 getIndexInList 
.const [120] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;I)I 
.const [121] = Utf8 de/audi/app/bap/fw/arrays/ArrayUtils 
.const [122] = Utf8 getPosID 
.const [123] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;I)I 
.const [124] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [125] = Utf8 list 
.const [126] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [127] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [128] = Utf8 logChannel 
.const [129] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [130] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [131] = Utf8 className 
.const [132] = Utf8 Ljava/lang/String; 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 de/audi/atip/log/LogChannel 
.const [137] = Utf8 log 
.const [138] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [139] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [140] = Utf8 sendChangedArrayRequest 
.const [141] = Utf8 (Lde/audi/app/bap/fw/arrays/ListDelta;)Z 
.const [142] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [143] = Utf8 getTaID 
.const [144] = Utf8 ()I 
.const [145] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [146] = Utf8 responseListElements 
.const [147] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [148] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [149] = Utf8 getArrayHeader 
.const [150] = Utf8 ()Lde/audi/app/bap/fw/arrays/IArrayHeader; 
.const [151] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [152] = Utf8 getNextListPosResult 
.const [153] = Utf8 (ZIII)V 
.const [154] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [157] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [158] = Utf8 requestListElements 
.const [159] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)V 
.const [160] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [161] = Utf8 getListSectionForRequest 
.const [162] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [163] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [164] = Utf8 responseListElements 
.const [165] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [166] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [167] = Utf8 getNextListPosFailed 
.const [168] = Utf8 (I)V 
.const [169] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [170] = Utf8 getNextListPosSucceeded 
.const [171] = Utf8 (III)V 
.const [172] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [173] = Utf8 list 
.const [174] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [175] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [176] = Utf8 getStart 
.const [177] = Utf8 ()I 
.const [178] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [179] = Utf8 getNumberOfElements 
.const [180] = Utf8 ()I 
.const [181] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [182] = Utf8 isModeShift 
.const [183] = Utf8 ()Z 
.const [184] = Utf8 de/audi/app/bap/fw/arrays/IArrayHeader 
.const [185] = Utf8 isModeArrayDirectionBackward 
.const [186] = Utf8 ()Z 
.const [187] = Utf8 de/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement 
.const [188] = Utf8 getPosID 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [191] = Class [190] 
.const [192] = Utf8 de/audi/app/bap/fw/arrays/AbstractArrayHandler 
.const [193] = Class [192] 
.const [194] = Utf8 UNKNOWN_ENTRY_ID 
.const [195] = Utf8 I 
.const [196] = Utf8 list 
.const [197] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [201] = Utf8 updateList 
.const [202] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [203] = Utf8 requestListElements 
.const [204] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)V 
.const [205] = Utf8 responseListElements 
.const [206] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [207] = Utf8 getListSectionForRequest 
.const [208] = Utf8 (Lde/audi/app/bap/fw/arrays/GetArrayIndication;)[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [209] = Utf8 getManagedList 
.const [210] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [211] = Utf8 getArrayElement 
.const [212] = Utf8 (I)Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [213] = Utf8 getCurrentListSize 
.const [214] = Utf8 ()I 
.const [215] = Utf8 getNextListPos 
.const [216] = Utf8 (II)V 
.const [217] = Utf8 getNextListPosForArbitraryIds 
.const [218] = Utf8 (II)V 
.const [219] = Utf8 getNextListPosForConsecutiveIds 
.const [220] = Utf8 (II)V 
.const [221] = Utf8 getNextListPosSucceeded 
.const [222] = Utf8 (III)V 
.const [223] = Utf8 getNextListPosFailed 
.const [224] = Utf8 (I)V 
.const [225] = Utf8 getPredecessorID 
.const [226] = Utf8 (I)I 
.const [227] = Utf8 getSuccessorID 
.const [228] = Utf8 (I)I 
.end class 

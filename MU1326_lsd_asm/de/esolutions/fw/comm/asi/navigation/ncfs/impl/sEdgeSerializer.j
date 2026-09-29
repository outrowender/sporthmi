.version 50 0 
.class public super [187] 
.super [189] 

.method public annotation [191] : [192] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [190] .code stack 3 locals 7 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [22] 0 
L17:    iload_2 
L18:    ifne L85 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [23] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    astore 5 
L39:    aload_0 
L40:    aload 5 
L42:    invokestatic [2] 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    astore 6 
L51:    aload_0 
L52:    aload 6 
L54:    invokestatic [3] 
L57:    aload_1 
L58:    invokevirtual [18] 
L61:    astore 7 
L63:    aload_0 
L64:    aload 7 
L66:    invokeinterface [24] 0 
L71:    aload_1 
L72:    invokevirtual [19] 
L75:    istore 8 
L77:    aload_0 
L78:    iload 8 
L80:    invokeinterface [25] 0 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public static [195] : [196] 
    .attribute [190] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [22] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [26] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [197] : [198] 
    .attribute [190] .code stack 3 locals 8 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L85 
L13:    new [28] 
L16:    dup 
L17:    invokespecial [21] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [29] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [30] 
L33:    aload_0 
L34:    invokestatic [6] 
L37:    astore 5 
L39:    aload_1 
L40:    aload 5 
L42:    putfield [31] 
L45:    aload_0 
L46:    invokestatic [7] 
L49:    astore 6 
L51:    aload_1 
L52:    aload 6 
L54:    putfield [32] 
L57:    aload_0 
L58:    invokeinterface [33] 0 
L63:    astore 7 
L65:    aload_1 
L66:    aload 7 
L68:    putfield [34] 
L71:    aload_0 
L72:    invokeinterface [35] 0 
L77:    istore 8 
L79:    aload_1 
L80:    iload 8 
L82:    putfield [36] 
L85:    aload_1 
L86:    areturn 
L87:    nop 
L88:    
    .end code 
.end method 

.method public static [199] : [200] 
    .attribute [190] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [37] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [5] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [8] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [38] [39] 
.const [3] = Method [40] [41] 
.const [4] = Method [42] [43] 
.const [5] = Class [44] 
.const [6] = Method [45] [46] 
.const [7] = Method [47] [48] 
.const [8] = Method [49] [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Method [57] [58] 
.const [16] = Method [59] [60] 
.const [17] = Method [61] [62] 
.const [18] = Method [63] [64] 
.const [19] = Method [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Method [69] [70] 
.const [22] = InterfaceMethod [71] [72] 
.const [23] = InterfaceMethod [73] [74] 
.const [24] = InterfaceMethod [75] [76] 
.const [25] = InterfaceMethod [77] [78] 
.const [26] = InterfaceMethod [79] [80] 
.const [27] = InterfaceMethod [81] [82] 
.const [28] = Class [83] 
.const [29] = InterfaceMethod [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = InterfaceMethod [92] [93] 
.const [34] = Field [94] [95] 
.const [35] = InterfaceMethod [96] [97] 
.const [36] = Field [98] [99] 
.const [37] = InterfaceMethod [100] [101] 
.const [38] = Class [102] 
.const [39] = NameAndType [103] [104] 
.const [40] = Class [105] 
.const [41] = NameAndType [106] [107] 
.const [42] = Class [108] 
.const [43] = NameAndType [109] [110] 
.const [44] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [45] = Class [111] 
.const [46] = NameAndType [112] [113] 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Class [117] 
.const [50] = NameAndType [118] [119] 
.const [51] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [54] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLineLocationReferenceContainerSerializer 
.const [55] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [56] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [57] = Class [120] 
.const [58] = NameAndType [121] [122] 
.const [59] = Class [123] 
.const [60] = NameAndType [124] [125] 
.const [61] = Class [126] 
.const [62] = NameAndType [127] [128] 
.const [63] = Class [129] 
.const [64] = NameAndType [130] [131] 
.const [65] = Class [132] 
.const [66] = NameAndType [133] [134] 
.const [67] = Class [135] 
.const [68] = NameAndType [136] [137] 
.const [69] = Class [138] 
.const [70] = NameAndType [139] [140] 
.const [71] = Class [141] 
.const [72] = NameAndType [142] [143] 
.const [73] = Class [144] 
.const [74] = NameAndType [145] [146] 
.const [75] = Class [147] 
.const [76] = NameAndType [148] [149] 
.const [77] = Class [150] 
.const [78] = NameAndType [151] [152] 
.const [79] = Class [153] 
.const [80] = NameAndType [154] [155] 
.const [81] = Class [156] 
.const [82] = NameAndType [157] [158] 
.const [83] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [84] = Class [159] 
.const [85] = NameAndType [160] [161] 
.const [86] = Class [162] 
.const [87] = NameAndType [163] [164] 
.const [88] = Class [165] 
.const [89] = NameAndType [166] [167] 
.const [90] = Class [168] 
.const [91] = NameAndType [169] [170] 
.const [92] = Class [171] 
.const [93] = NameAndType [172] [173] 
.const [94] = Class [174] 
.const [95] = NameAndType [175] [176] 
.const [96] = Class [177] 
.const [97] = NameAndType [178] [179] 
.const [98] = Class [180] 
.const [99] = NameAndType [181] [182] 
.const [100] = Class [183] 
.const [101] = NameAndType [184] [185] 
.const [102] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLineLocationReferenceContainerSerializer 
.const [103] = Utf8 putOptionalsLineLocationReferenceContainer 
.const [104] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sLineLocationReferenceContainer;)V 
.const [105] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [106] = Utf8 putOptionalsBoundingBox 
.const [107] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox;)V 
.const [108] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [109] = Utf8 putOptionalsEdge 
.const [110] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge;)V 
.const [111] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sLineLocationReferenceContainerSerializer 
.const [112] = Utf8 getOptionalsLineLocationReferenceContainer 
.const [113] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sLineLocationReferenceContainer; 
.const [114] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sBoundingBoxSerializer 
.const [115] = Utf8 getOptionalsBoundingBox 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [117] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [118] = Utf8 getOptionalsEdge 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge; 
.const [120] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [121] = Utf8 getId 
.const [122] = Utf8 ()J 
.const [123] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [124] = Utf8 getLocation 
.const [125] = Utf8 ()Lde/esolutions/fw/comm/asi/navigation/ncfs/sLineLocationReferenceContainer; 
.const [126] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [127] = Utf8 getBoundaries 
.const [128] = Utf8 ()Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [129] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [130] = Utf8 getTileIds 
.const [131] = Utf8 ()[I 
.const [132] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [133] = Utf8 getRoadClass 
.const [134] = Utf8 ()I 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [142] = Utf8 putBool 
.const [143] = Utf8 (Z)V 
.const [144] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [145] = Utf8 putInt64 
.const [146] = Utf8 (J)V 
.const [147] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [148] = Utf8 putOptionalInt32VarArray 
.const [149] = Utf8 ([I)V 
.const [150] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [151] = Utf8 putEnum 
.const [152] = Utf8 (I)V 
.const [153] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [154] = Utf8 putInt32 
.const [155] = Utf8 (I)V 
.const [156] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [157] = Utf8 getBool 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [160] = Utf8 getInt64 
.const [161] = Utf8 ()J 
.const [162] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [163] = Utf8 id 
.const [164] = Utf8 J 
.const [165] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [166] = Utf8 location 
.const [167] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/sLineLocationReferenceContainer; 
.const [168] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [169] = Utf8 boundaries 
.const [170] = Utf8 Lde/esolutions/fw/comm/asi/navigation/ncfs/sBoundingBox; 
.const [171] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [172] = Utf8 getOptionalInt32VarArray 
.const [173] = Utf8 ()[I 
.const [174] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [175] = Utf8 tileIds 
.const [176] = Utf8 [I 
.const [177] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [178] = Utf8 getEnum 
.const [179] = Utf8 ()I 
.const [180] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/sEdge 
.const [181] = Utf8 roadClass 
.const [182] = Utf8 I 
.const [183] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [184] = Utf8 getInt32 
.const [185] = Utf8 ()I 
.const [186] = Utf8 de/esolutions/fw/comm/asi/navigation/ncfs/impl/sEdgeSerializer 
.const [187] = Class [186] 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [188] 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 putOptionalsEdge 
.const [194] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge;)V 
.const [195] = Utf8 putOptionalsEdgeVarArray 
.const [196] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge;)V 
.const [197] = Utf8 getOptionalsEdge 
.const [198] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge; 
.const [199] = Utf8 getOptionalsEdgeVarArray 
.const [200] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/ncfs/sEdge; 
.end class 

.version 50 0 
.class public super [197] 
.super [199] 

.method public annotation [201] : [202] 
    .attribute [200] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [203] : [204] 
    .attribute [200] .code stack 3 locals 10 
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
L18:    ifne L129 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokeinterface [23] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokestatic [2] 
L45:    aload_1 
L46:    invokevirtual [14] 
L49:    istore 5 
L51:    aload_0 
L52:    iload 5 
L54:    invokeinterface [24] 0 
L59:    aload_1 
L60:    invokevirtual [15] 
L63:    istore 6 
L65:    aload_0 
L66:    iload 6 
L68:    invokeinterface [24] 0 
L73:    aload_1 
L74:    invokevirtual [16] 
L77:    istore 7 
L79:    aload_0 
L80:    iload 7 
L82:    invokeinterface [24] 0 
L87:    aload_1 
L88:    invokevirtual [17] 
L91:    istore 8 
L93:    aload_0 
L94:    iload 8 
L96:    invokeinterface [24] 0 
L101:   aload_1 
L102:   invokevirtual [18] 
L105:   lstore 9 
L107:   aload_0 
L108:   lload 9 
L110:   invokeinterface [25] 0 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   istore 11 
L121:   aload_0 
L122:   iload 11 
L124:   invokeinterface [24] 0 
L129:   return 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public static [205] : [206] 
    .attribute [200] .code stack 3 locals 2 
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
L24:    invokeinterface [24] 0 
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
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [207] : [208] 
    .attribute [200] .code stack 3 locals 11 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [26] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L129 
L13:    new [27] 
L16:    dup 
L17:    invokespecial [21] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [28] 0 
L27:    astore_3 
L28:    aload_1 
L29:    aload_3 
L30:    putfield [29] 
L33:    aload_0 
L34:    invokestatic [5] 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [30] 
L45:    aload_0 
L46:    invokeinterface [31] 0 
L51:    istore 5 
L53:    aload_1 
L54:    iload 5 
L56:    putfield [32] 
L59:    aload_0 
L60:    invokeinterface [31] 0 
L65:    istore 6 
L67:    aload_1 
L68:    iload 6 
L70:    putfield [33] 
L73:    aload_0 
L74:    invokeinterface [31] 0 
L79:    istore 7 
L81:    aload_1 
L82:    iload 7 
L84:    putfield [34] 
L87:    aload_0 
L88:    invokeinterface [31] 0 
L93:    istore 8 
L95:    aload_1 
L96:    iload 8 
L98:    putfield [35] 
L101:   aload_0 
L102:   invokeinterface [36] 0 
L107:   lstore 9 
L109:   aload_1 
L110:   lload 9 
L112:   putfield [37] 
L115:   aload_0 
L116:   invokeinterface [31] 0 
L121:   istore 11 
L123:   aload_1 
L124:   iload 11 
L126:   putfield [38] 
L129:   aload_1 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 

.method public static [209] : [210] 
    .attribute [200] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [26] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [31] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
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
.const [2] = Method [39] [40] 
.const [3] = Method [41] [42] 
.const [4] = Class [43] 
.const [5] = Method [44] [45] 
.const [6] = Method [46] [47] 
.const [7] = Class [48] 
.const [8] = Class [49] 
.const [9] = Class [50] 
.const [10] = Class [51] 
.const [11] = Class [52] 
.const [12] = Method [53] [54] 
.const [13] = Method [55] [56] 
.const [14] = Method [57] [58] 
.const [15] = Method [59] [60] 
.const [16] = Method [61] [62] 
.const [17] = Method [63] [64] 
.const [18] = Method [65] [66] 
.const [19] = Method [67] [68] 
.const [20] = Method [69] [70] 
.const [21] = Method [71] [72] 
.const [22] = InterfaceMethod [73] [74] 
.const [23] = InterfaceMethod [75] [76] 
.const [24] = InterfaceMethod [77] [78] 
.const [25] = InterfaceMethod [79] [80] 
.const [26] = InterfaceMethod [81] [82] 
.const [27] = Class [83] 
.const [28] = InterfaceMethod [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = Field [88] [89] 
.const [31] = InterfaceMethod [90] [91] 
.const [32] = Field [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = Field [98] [99] 
.const [36] = InterfaceMethod [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Class [106] 
.const [40] = NameAndType [107] [108] 
.const [41] = Class [109] 
.const [42] = NameAndType [110] [111] 
.const [43] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [44] = Class [112] 
.const [45] = NameAndType [113] [114] 
.const [46] = Class [115] 
.const [47] = NameAndType [116] [117] 
.const [48] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavTraceListDataSerializer 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [51] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavSegmentIDSerializer 
.const [52] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [53] = Class [118] 
.const [54] = NameAndType [119] [120] 
.const [55] = Class [121] 
.const [56] = NameAndType [122] [123] 
.const [57] = Class [124] 
.const [58] = NameAndType [125] [126] 
.const [59] = Class [127] 
.const [60] = NameAndType [128] [129] 
.const [61] = Class [130] 
.const [62] = NameAndType [131] [132] 
.const [63] = Class [133] 
.const [64] = NameAndType [134] [135] 
.const [65] = Class [136] 
.const [66] = NameAndType [137] [138] 
.const [67] = Class [139] 
.const [68] = NameAndType [140] [141] 
.const [69] = Class [142] 
.const [70] = NameAndType [143] [144] 
.const [71] = Class [145] 
.const [72] = NameAndType [146] [147] 
.const [73] = Class [148] 
.const [74] = NameAndType [149] [150] 
.const [75] = Class [151] 
.const [76] = NameAndType [152] [153] 
.const [77] = Class [154] 
.const [78] = NameAndType [155] [156] 
.const [79] = Class [157] 
.const [80] = NameAndType [158] [159] 
.const [81] = Class [160] 
.const [82] = NameAndType [161] [162] 
.const [83] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [84] = Class [163] 
.const [85] = NameAndType [164] [165] 
.const [86] = Class [166] 
.const [87] = NameAndType [167] [168] 
.const [88] = Class [169] 
.const [89] = NameAndType [170] [171] 
.const [90] = Class [172] 
.const [91] = NameAndType [173] [174] 
.const [92] = Class [175] 
.const [93] = NameAndType [176] [177] 
.const [94] = Class [178] 
.const [95] = NameAndType [179] [180] 
.const [96] = Class [181] 
.const [97] = NameAndType [182] [183] 
.const [98] = Class [184] 
.const [99] = NameAndType [185] [186] 
.const [100] = Class [187] 
.const [101] = NameAndType [188] [189] 
.const [102] = Class [190] 
.const [103] = NameAndType [191] [192] 
.const [104] = Class [193] 
.const [105] = NameAndType [194] [195] 
.const [106] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavSegmentIDSerializer 
.const [107] = Utf8 putOptionalNavSegmentID 
.const [108] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavSegmentID;)V 
.const [109] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavTraceListDataSerializer 
.const [110] = Utf8 putOptionalNavTraceListData 
.const [111] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/NavTraceListData;)V 
.const [112] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavSegmentIDSerializer 
.const [113] = Utf8 getOptionalNavSegmentID 
.const [114] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavSegmentID; 
.const [115] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavTraceListDataSerializer 
.const [116] = Utf8 getOptionalNavTraceListData 
.const [117] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/NavTraceListData; 
.const [118] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [119] = Utf8 getName 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [122] = Utf8 getTraceID 
.const [123] = Utf8 ()Lorg/dsi/ifc/global/NavSegmentID; 
.const [124] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [125] = Utf8 getStartLongitude 
.const [126] = Utf8 ()I 
.const [127] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [128] = Utf8 getStartLatitude 
.const [129] = Utf8 ()I 
.const [130] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [131] = Utf8 getEndLongitude 
.const [132] = Utf8 ()I 
.const [133] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [134] = Utf8 getEndLatitude 
.const [135] = Utf8 ()I 
.const [136] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [137] = Utf8 getLength 
.const [138] = Utf8 ()J 
.const [139] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [140] = Utf8 getNumberOfTrackPoints 
.const [141] = Utf8 ()I 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [149] = Utf8 putBool 
.const [150] = Utf8 (Z)V 
.const [151] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [152] = Utf8 putOptionalString 
.const [153] = Utf8 (Ljava/lang/String;)V 
.const [154] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [155] = Utf8 putInt32 
.const [156] = Utf8 (I)V 
.const [157] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [158] = Utf8 putInt64 
.const [159] = Utf8 (J)V 
.const [160] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [161] = Utf8 getBool 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [164] = Utf8 getOptionalString 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [167] = Utf8 name 
.const [168] = Utf8 Ljava/lang/String; 
.const [169] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [170] = Utf8 traceID 
.const [171] = Utf8 Lorg/dsi/ifc/global/NavSegmentID; 
.const [172] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [173] = Utf8 getInt32 
.const [174] = Utf8 ()I 
.const [175] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [176] = Utf8 startLongitude 
.const [177] = Utf8 I 
.const [178] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [179] = Utf8 startLatitude 
.const [180] = Utf8 I 
.const [181] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [182] = Utf8 endLongitude 
.const [183] = Utf8 I 
.const [184] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [185] = Utf8 endLatitude 
.const [186] = Utf8 I 
.const [187] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [188] = Utf8 getInt64 
.const [189] = Utf8 ()J 
.const [190] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [191] = Utf8 length 
.const [192] = Utf8 J 
.const [193] = Utf8 org/dsi/ifc/navigation/NavTraceListData 
.const [194] = Utf8 numberOfTrackPoints 
.const [195] = Utf8 I 
.const [196] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/NavTraceListDataSerializer 
.const [197] = Class [196] 
.const [198] = Utf8 java/lang/Object 
.const [199] = Class [198] 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 putOptionalNavTraceListData 
.const [204] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/NavTraceListData;)V 
.const [205] = Utf8 putOptionalNavTraceListDataVarArray 
.const [206] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/NavTraceListData;)V 
.const [207] = Utf8 getOptionalNavTraceListData 
.const [208] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/NavTraceListData; 
.const [209] = Utf8 getOptionalNavTraceListDataVarArray 
.const [210] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/NavTraceListData; 
.end class 

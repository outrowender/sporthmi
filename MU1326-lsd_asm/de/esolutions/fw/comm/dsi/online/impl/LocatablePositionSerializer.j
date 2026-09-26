.version 50 0 
.class public super [207] 
.super [209] 

.method public annotation [211] : [212] 
    .attribute [210] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [213] : [214] 
    .attribute [210] .code stack 3 locals 12 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [20] 0 
L17:    iload_2 
L18:    ifne L145 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [21] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    lstore 5 
L39:    aload_0 
L40:    lload 5 
L42:    invokeinterface [21] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    astore 7 
L53:    aload_0 
L54:    aload 7 
L56:    invokeinterface [22] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    istore 8 
L67:    aload_0 
L68:    iload 8 
L70:    invokeinterface [23] 0 
L75:    aload_1 
L76:    invokevirtual [13] 
L79:    astore 9 
L81:    aload_0 
L82:    aload 9 
L84:    invokeinterface [22] 0 
L89:    aload_1 
L90:    invokevirtual [14] 
L93:    istore 10 
L95:    aload_0 
L96:    iload 10 
L98:    invokeinterface [23] 0 
L103:   aload_1 
L104:   invokevirtual [15] 
L107:   istore 11 
L109:   aload_0 
L110:   iload 11 
L112:   invokeinterface [23] 0 
L117:   aload_1 
L118:   invokevirtual [16] 
L121:   istore 12 
L123:   aload_0 
L124:   iload 12 
L126:   invokeinterface [20] 0 
L131:   aload_1 
L132:   invokevirtual [17] 
L135:   astore 13 
L137:   aload_0 
L138:   aload 13 
L140:   invokeinterface [24] 0 
L145:   return 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public static [215] : [216] 
    .attribute [210] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [20] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [23] 0 
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
L41:    invokestatic [2] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [217] : [218] 
    .attribute [210] .code stack 3 locals 13 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [25] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L145 
L13:    new [26] 
L16:    dup 
L17:    invokespecial [19] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [27] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [28] 
L33:    aload_0 
L34:    invokeinterface [27] 0 
L39:    lstore 5 
L41:    aload_1 
L42:    lload 5 
L44:    putfield [29] 
L47:    aload_0 
L48:    invokeinterface [30] 0 
L53:    astore 7 
L55:    aload_1 
L56:    aload 7 
L58:    putfield [31] 
L61:    aload_0 
L62:    invokeinterface [32] 0 
L67:    istore 8 
L69:    aload_1 
L70:    iload 8 
L72:    putfield [33] 
L75:    aload_0 
L76:    invokeinterface [30] 0 
L81:    astore 9 
L83:    aload_1 
L84:    aload 9 
L86:    putfield [34] 
L89:    aload_0 
L90:    invokeinterface [32] 0 
L95:    istore 10 
L97:    aload_1 
L98:    iload 10 
L100:   putfield [35] 
L103:   aload_0 
L104:   invokeinterface [32] 0 
L109:   istore 11 
L111:   aload_1 
L112:   iload 11 
L114:   putfield [36] 
L117:   aload_0 
L118:   invokeinterface [25] 0 
L123:   istore 12 
L125:   aload_1 
L126:   iload 12 
L128:   putfield [37] 
L131:   aload_0 
L132:   invokeinterface [38] 0 
L137:   astore 13 
L139:   aload_1 
L140:   aload 13 
L142:   putfield [39] 
L145:   aload_1 
L146:   areturn 
L147:   nop 
L148:   
    .end code 
.end method 

.method public static [219] : [220] 
    .attribute [210] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [25] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [32] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [3] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [4] 
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
.const [2] = Method [40] [41] 
.const [3] = Class [42] 
.const [4] = Method [43] [44] 
.const [5] = Class [45] 
.const [6] = Class [46] 
.const [7] = Class [47] 
.const [8] = Class [48] 
.const [9] = Method [49] [50] 
.const [10] = Method [51] [52] 
.const [11] = Method [53] [54] 
.const [12] = Method [55] [56] 
.const [13] = Method [57] [58] 
.const [14] = Method [59] [60] 
.const [15] = Method [61] [62] 
.const [16] = Method [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Method [67] [68] 
.const [19] = Method [69] [70] 
.const [20] = InterfaceMethod [71] [72] 
.const [21] = InterfaceMethod [73] [74] 
.const [22] = InterfaceMethod [75] [76] 
.const [23] = InterfaceMethod [77] [78] 
.const [24] = InterfaceMethod [79] [80] 
.const [25] = InterfaceMethod [81] [82] 
.const [26] = Class [83] 
.const [27] = InterfaceMethod [84] [85] 
.const [28] = Field [86] [87] 
.const [29] = Field [88] [89] 
.const [30] = InterfaceMethod [90] [91] 
.const [31] = Field [92] [93] 
.const [32] = InterfaceMethod [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Field [104] [105] 
.const [38] = InterfaceMethod [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Class [110] 
.const [41] = NameAndType [111] [112] 
.const [42] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [43] = Class [113] 
.const [44] = NameAndType [114] [115] 
.const [45] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [48] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [49] = Class [116] 
.const [50] = NameAndType [117] [118] 
.const [51] = Class [119] 
.const [52] = NameAndType [120] [121] 
.const [53] = Class [122] 
.const [54] = NameAndType [123] [124] 
.const [55] = Class [125] 
.const [56] = NameAndType [126] [127] 
.const [57] = Class [128] 
.const [58] = NameAndType [129] [130] 
.const [59] = Class [131] 
.const [60] = NameAndType [132] [133] 
.const [61] = Class [134] 
.const [62] = NameAndType [135] [136] 
.const [63] = Class [137] 
.const [64] = NameAndType [138] [139] 
.const [65] = Class [140] 
.const [66] = NameAndType [141] [142] 
.const [67] = Class [143] 
.const [68] = NameAndType [144] [145] 
.const [69] = Class [146] 
.const [70] = NameAndType [147] [148] 
.const [71] = Class [149] 
.const [72] = NameAndType [150] [151] 
.const [73] = Class [152] 
.const [74] = NameAndType [153] [154] 
.const [75] = Class [155] 
.const [76] = NameAndType [156] [157] 
.const [77] = Class [158] 
.const [78] = NameAndType [159] [160] 
.const [79] = Class [161] 
.const [80] = NameAndType [162] [163] 
.const [81] = Class [164] 
.const [82] = NameAndType [165] [166] 
.const [83] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [84] = Class [167] 
.const [85] = NameAndType [168] [169] 
.const [86] = Class [170] 
.const [87] = NameAndType [171] [172] 
.const [88] = Class [173] 
.const [89] = NameAndType [174] [175] 
.const [90] = Class [176] 
.const [91] = NameAndType [177] [178] 
.const [92] = Class [179] 
.const [93] = NameAndType [180] [181] 
.const [94] = Class [182] 
.const [95] = NameAndType [183] [184] 
.const [96] = Class [185] 
.const [97] = NameAndType [186] [187] 
.const [98] = Class [188] 
.const [99] = NameAndType [189] [190] 
.const [100] = Class [191] 
.const [101] = NameAndType [192] [193] 
.const [102] = Class [194] 
.const [103] = NameAndType [195] [196] 
.const [104] = Class [197] 
.const [105] = NameAndType [198] [199] 
.const [106] = Class [200] 
.const [107] = NameAndType [201] [202] 
.const [108] = Class [203] 
.const [109] = NameAndType [204] [205] 
.const [110] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [111] = Utf8 putOptionalLocatablePosition 
.const [112] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/LocatablePosition;)V 
.const [113] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [114] = Utf8 getOptionalLocatablePosition 
.const [115] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/LocatablePosition; 
.const [116] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [117] = Utf8 getLongitude 
.const [118] = Utf8 ()J 
.const [119] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [120] = Utf8 getLatitude 
.const [121] = Utf8 ()J 
.const [122] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [123] = Utf8 getCountry 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [126] = Utf8 getBearing 
.const [127] = Utf8 ()I 
.const [128] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [129] = Utf8 getRoadNumber 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [132] = Utf8 getFunctionalRoadClass 
.const [133] = Utf8 ()I 
.const [134] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [135] = Utf8 getFormOfWay 
.const [136] = Utf8 ()I 
.const [137] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [138] = Utf8 isIsStopOver 
.const [139] = Utf8 ()Z 
.const [140] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [141] = Utf8 getRouteCriteria 
.const [142] = Utf8 ()[Ljava/lang/String; 
.const [143] = Utf8 java/lang/Object 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [150] = Utf8 putBool 
.const [151] = Utf8 (Z)V 
.const [152] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [153] = Utf8 putInt64 
.const [154] = Utf8 (J)V 
.const [155] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [156] = Utf8 putOptionalString 
.const [157] = Utf8 (Ljava/lang/String;)V 
.const [158] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [159] = Utf8 putInt32 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [162] = Utf8 putOptionalStringVarArray 
.const [163] = Utf8 ([Ljava/lang/String;)V 
.const [164] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [165] = Utf8 getBool 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [168] = Utf8 getInt64 
.const [169] = Utf8 ()J 
.const [170] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [171] = Utf8 longitude 
.const [172] = Utf8 J 
.const [173] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [174] = Utf8 latitude 
.const [175] = Utf8 J 
.const [176] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [177] = Utf8 getOptionalString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [180] = Utf8 country 
.const [181] = Utf8 Ljava/lang/String; 
.const [182] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [183] = Utf8 getInt32 
.const [184] = Utf8 ()I 
.const [185] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [186] = Utf8 bearing 
.const [187] = Utf8 I 
.const [188] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [189] = Utf8 roadNumber 
.const [190] = Utf8 Ljava/lang/String; 
.const [191] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [192] = Utf8 functionalRoadClass 
.const [193] = Utf8 I 
.const [194] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [195] = Utf8 formOfWay 
.const [196] = Utf8 I 
.const [197] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [198] = Utf8 isStopOver 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [201] = Utf8 getOptionalStringVarArray 
.const [202] = Utf8 ()[Ljava/lang/String; 
.const [203] = Utf8 org/dsi/ifc/online/LocatablePosition 
.const [204] = Utf8 routeCriteria 
.const [205] = Utf8 [Ljava/lang/String; 
.const [206] = Utf8 de/esolutions/fw/comm/dsi/online/impl/LocatablePositionSerializer 
.const [207] = Class [206] 
.const [208] = Utf8 java/lang/Object 
.const [209] = Class [208] 
.const [210] = Utf8 Code 
.const [211] = Utf8 <init> 
.const [212] = Utf8 ()V 
.const [213] = Utf8 putOptionalLocatablePosition 
.const [214] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/LocatablePosition;)V 
.const [215] = Utf8 putOptionalLocatablePositionVarArray 
.const [216] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/LocatablePosition;)V 
.const [217] = Utf8 getOptionalLocatablePosition 
.const [218] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/LocatablePosition; 
.const [219] = Utf8 getOptionalLocatablePositionVarArray 
.const [220] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/LocatablePosition; 
.end class 

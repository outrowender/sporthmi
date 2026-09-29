.version 50 0 
.class public super [195] 
.super [197] 

.method public annotation [199] : [200] 
    .attribute [198] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [201] : [202] 
    .attribute [198] .code stack 3 locals 14 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [19] 0 
L17:    iload_2 
L18:    ifne L131 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [20] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    lstore 4 
L39:    aload_0 
L40:    lload 4 
L42:    invokeinterface [21] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    dstore 6 
L53:    aload_0 
L54:    dload 6 
L56:    invokeinterface [22] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    dstore 8 
L67:    aload_0 
L68:    dload 8 
L70:    invokeinterface [22] 0 
L75:    aload_1 
L76:    invokevirtual [13] 
L79:    dstore 10 
L81:    aload_0 
L82:    dload 10 
L84:    invokeinterface [22] 0 
L89:    aload_1 
L90:    invokevirtual [14] 
L93:    dstore 12 
L95:    aload_0 
L96:    dload 12 
L98:    invokeinterface [22] 0 
L103:   aload_1 
L104:   invokevirtual [15] 
L107:   istore 14 
L109:   aload_0 
L110:   iload 14 
L112:   invokeinterface [23] 0 
L117:   aload_1 
L118:   invokevirtual [16] 
L121:   istore 15 
L123:   aload_0 
L124:   iload 15 
L126:   invokeinterface [23] 0 
L131:   return 
L132:   
    .end code 
.end method 

.method public static [203] : [204] 
    .attribute [198] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [19] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [20] 0 
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

.method public static [205] : [206] 
    .attribute [198] .code stack 3 locals 15 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [24] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L131 
L13:    new [25] 
L16:    dup 
L17:    invokespecial [18] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [26] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [27] 
L33:    aload_0 
L34:    invokeinterface [28] 0 
L39:    lstore 4 
L41:    aload_1 
L42:    lload 4 
L44:    putfield [29] 
L47:    aload_0 
L48:    invokeinterface [30] 0 
L53:    dstore 6 
L55:    aload_1 
L56:    dload 6 
L58:    putfield [31] 
L61:    aload_0 
L62:    invokeinterface [30] 0 
L67:    dstore 8 
L69:    aload_1 
L70:    dload 8 
L72:    putfield [32] 
L75:    aload_0 
L76:    invokeinterface [30] 0 
L81:    dstore 10 
L83:    aload_1 
L84:    dload 10 
L86:    putfield [33] 
L89:    aload_0 
L90:    invokeinterface [30] 0 
L95:    dstore 12 
L97:    aload_1 
L98:    dload 12 
L100:   putfield [34] 
L103:   aload_0 
L104:   invokeinterface [35] 0 
L109:   istore 14 
L111:   aload_1 
L112:   iload 14 
L114:   putfield [36] 
L117:   aload_0 
L118:   invokeinterface [35] 0 
L123:   istore 15 
L125:   aload_1 
L126:   iload 15 
L128:   putfield [37] 
L131:   aload_1 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public static [207] : [208] 
    .attribute [198] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [24] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [26] 0 
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
.const [2] = Method [38] [39] 
.const [3] = Class [40] 
.const [4] = Method [41] [42] 
.const [5] = Class [43] 
.const [6] = Class [44] 
.const [7] = Class [45] 
.const [8] = Class [46] 
.const [9] = Method [47] [48] 
.const [10] = Method [49] [50] 
.const [11] = Method [51] [52] 
.const [12] = Method [53] [54] 
.const [13] = Method [55] [56] 
.const [14] = Method [57] [58] 
.const [15] = Method [59] [60] 
.const [16] = Method [61] [62] 
.const [17] = Method [63] [64] 
.const [18] = Method [65] [66] 
.const [19] = InterfaceMethod [67] [68] 
.const [20] = InterfaceMethod [69] [70] 
.const [21] = InterfaceMethod [71] [72] 
.const [22] = InterfaceMethod [73] [74] 
.const [23] = InterfaceMethod [75] [76] 
.const [24] = InterfaceMethod [77] [78] 
.const [25] = Class [79] 
.const [26] = InterfaceMethod [80] [81] 
.const [27] = Field [82] [83] 
.const [28] = InterfaceMethod [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = InterfaceMethod [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = Field [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = InterfaceMethod [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Class [104] 
.const [39] = NameAndType [105] [106] 
.const [40] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [41] = Class [107] 
.const [42] = NameAndType [108] [109] 
.const [43] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [46] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [47] = Class [110] 
.const [48] = NameAndType [111] [112] 
.const [49] = Class [113] 
.const [50] = NameAndType [114] [115] 
.const [51] = Class [116] 
.const [52] = NameAndType [117] [118] 
.const [53] = Class [119] 
.const [54] = NameAndType [120] [121] 
.const [55] = Class [122] 
.const [56] = NameAndType [123] [124] 
.const [57] = Class [125] 
.const [58] = NameAndType [126] [127] 
.const [59] = Class [128] 
.const [60] = NameAndType [129] [130] 
.const [61] = Class [131] 
.const [62] = NameAndType [132] [133] 
.const [63] = Class [134] 
.const [64] = NameAndType [135] [136] 
.const [65] = Class [137] 
.const [66] = NameAndType [138] [139] 
.const [67] = Class [140] 
.const [68] = NameAndType [141] [142] 
.const [69] = Class [143] 
.const [70] = NameAndType [144] [145] 
.const [71] = Class [146] 
.const [72] = NameAndType [147] [148] 
.const [73] = Class [149] 
.const [74] = NameAndType [150] [151] 
.const [75] = Class [152] 
.const [76] = NameAndType [153] [154] 
.const [77] = Class [155] 
.const [78] = NameAndType [156] [157] 
.const [79] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [80] = Class [158] 
.const [81] = NameAndType [159] [160] 
.const [82] = Class [161] 
.const [83] = NameAndType [162] [163] 
.const [84] = Class [164] 
.const [85] = NameAndType [165] [166] 
.const [86] = Class [167] 
.const [87] = NameAndType [168] [169] 
.const [88] = Class [170] 
.const [89] = NameAndType [171] [172] 
.const [90] = Class [173] 
.const [91] = NameAndType [174] [175] 
.const [92] = Class [176] 
.const [93] = NameAndType [177] [178] 
.const [94] = Class [179] 
.const [95] = NameAndType [180] [181] 
.const [96] = Class [182] 
.const [97] = NameAndType [183] [184] 
.const [98] = Class [185] 
.const [99] = NameAndType [186] [187] 
.const [100] = Class [188] 
.const [101] = NameAndType [189] [190] 
.const [102] = Class [191] 
.const [103] = NameAndType [192] [193] 
.const [104] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [105] = Utf8 putOptionalsPosition 
.const [106] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition;)V 
.const [107] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [108] = Utf8 getOptionalsPosition 
.const [109] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [110] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [111] = Utf8 getTimeStamp 
.const [112] = Utf8 ()I 
.const [113] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [114] = Utf8 getUtcTimestamp 
.const [115] = Utf8 ()J 
.const [116] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [117] = Utf8 getLatitude 
.const [118] = Utf8 ()D 
.const [119] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [120] = Utf8 getLongitude 
.const [121] = Utf8 ()D 
.const [122] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [123] = Utf8 getMercatorX 
.const [124] = Utf8 ()D 
.const [125] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [126] = Utf8 getMercatorY 
.const [127] = Utf8 ()D 
.const [128] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [129] = Utf8 getHeading 
.const [130] = Utf8 ()S 
.const [131] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [132] = Utf8 getBearing 
.const [133] = Utf8 ()S 
.const [134] = Utf8 java/lang/Object 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [141] = Utf8 putBool 
.const [142] = Utf8 (Z)V 
.const [143] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [144] = Utf8 putInt32 
.const [145] = Utf8 (I)V 
.const [146] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [147] = Utf8 putInt64 
.const [148] = Utf8 (J)V 
.const [149] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [150] = Utf8 putDouble 
.const [151] = Utf8 (D)V 
.const [152] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [153] = Utf8 putInt16 
.const [154] = Utf8 (S)V 
.const [155] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [156] = Utf8 getBool 
.const [157] = Utf8 ()Z 
.const [158] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [159] = Utf8 getInt32 
.const [160] = Utf8 ()I 
.const [161] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [162] = Utf8 timeStamp 
.const [163] = Utf8 I 
.const [164] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [165] = Utf8 getInt64 
.const [166] = Utf8 ()J 
.const [167] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [168] = Utf8 utcTimestamp 
.const [169] = Utf8 J 
.const [170] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [171] = Utf8 getDouble 
.const [172] = Utf8 ()D 
.const [173] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [174] = Utf8 latitude 
.const [175] = Utf8 D 
.const [176] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [177] = Utf8 longitude 
.const [178] = Utf8 D 
.const [179] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [180] = Utf8 mercatorX 
.const [181] = Utf8 D 
.const [182] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [183] = Utf8 mercatorY 
.const [184] = Utf8 D 
.const [185] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [186] = Utf8 getInt16 
.const [187] = Utf8 ()S 
.const [188] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [189] = Utf8 heading 
.const [190] = Utf8 S 
.const [191] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition 
.const [192] = Utf8 bearing 
.const [193] = Utf8 S 
.const [194] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/sPositionSerializer 
.const [195] = Class [194] 
.const [196] = Utf8 java/lang/Object 
.const [197] = Class [196] 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 putOptionalsPosition 
.const [202] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition;)V 
.const [203] = Utf8 putOptionalsPositionVarArray 
.const [204] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition;)V 
.const [205] = Utf8 getOptionalsPosition 
.const [206] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.const [207] = Utf8 getOptionalsPositionVarArray 
.const [208] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/sPosition; 
.end class 

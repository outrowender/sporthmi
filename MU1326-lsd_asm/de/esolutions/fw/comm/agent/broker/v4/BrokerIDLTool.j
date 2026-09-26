.version 50 0 
.class public super [203] 
.super [205] 

.method public annotation [207] : [208] 
    .attribute [206] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [209] : [210] 
    .attribute [206] .code stack 6 locals 9 
L0:     aload_0 
L1:     invokevirtual [21] 
L4:     invokevirtual [22] 
L7:     invokevirtual [23] 
L10:    astore_1 
L11:    aload_0 
L12:    invokevirtual [24] 
L15:    invokevirtual [22] 
L18:    invokevirtual [23] 
L21:    astore_2 
L22:    aload_1 
L23:    arraylength 
L24:    newarray short 
L26:    astore_3 
L27:    aload_2 
L28:    arraylength 
L29:    newarray short 
L31:    astore 4 
L33:    iconst_0 
L34:    istore 5 
L36:    iload 5 
L38:    aload_1 
L39:    arraylength 
L40:    if_icmpge L62 
L43:    aload_3 
L44:    iload 5 
L46:    aload_1 
L47:    iload 5 
L49:    baload 
L50:    sipush 255 
L53:    iand 
L54:    i2s 
L55:    sastore 
L56:    iinc 5 1 
L59:    goto L36 
L62:    iconst_0 
L63:    istore 5 
L65:    iload 5 
L67:    aload_2 
L68:    arraylength 
L69:    if_icmpge L92 
L72:    aload 4 
L74:    iload 5 
L76:    aload_2 
L77:    iload 5 
L79:    baload 
L80:    sipush 255 
L83:    iand 
L84:    i2s 
L85:    sastore 
L86:    iinc 5 1 
L89:    goto L65 
L92:    aload_0 
L93:    invokevirtual [25] 
L96:    istore 5 
L98:    iload 5 
L100:   i2l 
L101:   ldc_w [1] 
L104:   land 
L105:   lstore 6 
L107:   new [43] 
L110:   dup 
L111:   aload_3 
L112:   invokespecial [36] 
L115:   astore 8 
L117:   new [43] 
L120:   dup 
L121:   aload 4 
L123:   invokespecial [36] 
L126:   astore 9 
L128:   new [44] 
L131:   dup 
L132:   aload 8 
L134:   lload 6 
L136:   aload 9 
L138:   invokespecial [37] 
L141:   areturn 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public static [211] : [212] 
    .attribute [206] .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield [26] 
L4:     getfield [27] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [28] 
L12:    getfield [27] 
L15:    astore_2 
L16:    aload_1 
L17:    arraylength 
L18:    newarray byte 
L20:    astore_3 
L21:    aload_2 
L22:    arraylength 
L23:    newarray byte 
L25:    astore 4 
L27:    iconst_0 
L28:    istore 5 
L30:    iload 5 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L56 
L37:    aload_3 
L38:    iload 5 
L40:    aload_1 
L41:    iload 5 
L43:    saload 
L44:    sipush 255 
L47:    iand 
L48:    i2b 
L49:    bastore 
L50:    iinc 5 1 
L53:    goto L30 
L56:    iconst_0 
L57:    istore 5 
L59:    iload 5 
L61:    aload_2 
L62:    arraylength 
L63:    if_icmpge L86 
L66:    aload 4 
L68:    iload 5 
L70:    aload_2 
L71:    iload 5 
L73:    saload 
L74:    sipush 255 
L77:    iand 
L78:    i2b 
L79:    bastore 
L80:    iinc 5 1 
L83:    goto L59 
L86:    aload_0 
L87:    getfield [29] 
L90:    ldc2_w [50] 
L93:    land 
L94:    l2i 
L95:    istore 5 
L97:    new [45] 
L100:   dup 
L101:   new [46] 
L104:   dup 
L105:   aload_3 
L106:   invokespecial [38] 
L109:   invokespecial [39] 
L112:   astore 6 
L114:   new [45] 
L117:   dup 
L118:   new [46] 
L121:   dup 
L122:   aload 4 
L124:   invokespecial [38] 
L127:   invokespecial [39] 
L130:   astore 7 
L132:   new [47] 
L135:   dup 
L136:   aload 6 
L138:   iload 5 
L140:   aload 7 
L142:   invokespecial [40] 
L145:   areturn 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public static [213] : [214] 
    .attribute [206] .code stack 7 locals 4 
L0:     ldc [7] 
L2:     istore_1 
L3:     new [47] 
L6:     dup 
L7:     new [45] 
L10:    dup 
L11:    ldc [8] 
L13:    invokespecial [41] 
L16:    iload_1 
L17:    new [45] 
L20:    dup 
L21:    ldc [9] 
L23:    invokespecial [41] 
L26:    invokespecial [40] 
L29:    astore_2 
L30:    getstatic [10] 
L33:    aload_2 
L34:    invokevirtual [30] 
L37:    aload_2 
L38:    invokestatic [11] 
L41:    astore_3 
L42:    getstatic [10] 
L45:    new [48] 
L48:    dup 
L49:    invokespecial [42] 
L52:    ldc [13] 
L54:    invokevirtual [31] 
L57:    aload_3 
L58:    invokevirtual [32] 
L61:    invokestatic [14] 
L64:    invokevirtual [31] 
L67:    invokevirtual [33] 
L70:    invokevirtual [34] 
L73:    aload_3 
L74:    invokestatic [15] 
L77:    astore 4 
L79:    getstatic [10] 
L82:    aload 4 
L84:    invokevirtual [30] 
L87:    return 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [52] 
.const [3] = Class [53] 
.const [4] = Class [54] 
.const [5] = Class [55] 
.const [6] = Class [56] 
.const [7] = Int 41943424 
.const [8] = String [57] 
.const [9] = String [58] 
.const [10] = Field [59] [60] 
.const [11] = Method [61] [62] 
.const [12] = Class [63] 
.const [13] = String [64] 
.const [14] = Method [65] [66] 
.const [15] = Method [67] [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Method [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Field [84] [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Field [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Class [118] 
.const [44] = Class [119] 
.const [45] = Class [120] 
.const [46] = Class [121] 
.const [47] = Class [122] 
.const [48] = Class [123] 
.const [49] = Int -1 
.const [50] = Long -1L 
.const [52] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UUID844412Blob 
.const [53] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [54] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [55] = Utf8 de/esolutions/fw/comm/core/UUID 
.const [56] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [57] = Utf8 '8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847' 
.const [58] = Utf8 '8935d19b-313a-5d23-bf1f-64bc869ad545' 
.const [59] = Class [124] 
.const [60] = NameAndType [125] [126] 
.const [61] = Class [127] 
.const [62] = NameAndType [128] [129] 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'handle ' 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Class [133] 
.const [68] = NameAndType [134] [135] 
.const [69] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 java/lang/System 
.const [72] = Utf8 java/io/PrintStream 
.const [73] = Utf8 java/lang/Long 
.const [74] = Class [136] 
.const [75] = NameAndType [137] [138] 
.const [76] = Class [139] 
.const [77] = NameAndType [140] [141] 
.const [78] = Class [142] 
.const [79] = NameAndType [143] [144] 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
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
.const [112] = Class [193] 
.const [113] = NameAndType [194] [195] 
.const [114] = Class [196] 
.const [115] = NameAndType [197] [198] 
.const [116] = Class [199] 
.const [117] = NameAndType [200] [201] 
.const [118] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UUID844412Blob 
.const [119] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [120] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [121] = Utf8 de/esolutions/fw/comm/core/UUID 
.const [122] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 java/lang/System 
.const [125] = Utf8 out 
.const [126] = Utf8 Ljava/io/PrintStream; 
.const [127] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [128] = Utf8 convertInstanceIDToIDL 
.const [129] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)Lde/esolutions/fw/comm/comm/broker/v4/InstanceID; 
.const [130] = Utf8 java/lang/Long 
.const [131] = Utf8 toHexString 
.const [132] = Utf8 (J)Ljava/lang/String; 
.const [133] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [134] = Utf8 convertInstanceIDFromIDL 
.const [135] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;)Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [136] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [137] = Utf8 getServiceUUID 
.const [138] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceUUID; 
.const [139] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [140] = Utf8 getUUID 
.const [141] = Utf8 ()Lde/esolutions/fw/comm/core/UUID; 
.const [142] = Utf8 de/esolutions/fw/comm/core/UUID 
.const [143] = Utf8 getRawBytes 
.const [144] = Utf8 ()[B 
.const [145] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [146] = Utf8 getInterfaceKey 
.const [147] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceUUID; 
.const [148] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [149] = Utf8 getHandle 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [152] = Utf8 id 
.const [153] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/UUID844412Blob; 
.const [154] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UUID844412Blob 
.const [155] = Utf8 bytes 
.const [156] = Utf8 [S 
.const [157] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [158] = Utf8 key 
.const [159] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/UUID844412Blob; 
.const [160] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [161] = Utf8 handle 
.const [162] = Utf8 J 
.const [163] = Utf8 java/io/PrintStream 
.const [164] = Utf8 println 
.const [165] = Utf8 (Ljava/lang/Object;)V 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [169] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [170] = Utf8 getHandle 
.const [171] = Utf8 ()J 
.const [172] = Utf8 java/lang/StringBuffer 
.const [173] = Utf8 toString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 java/io/PrintStream 
.const [176] = Utf8 println 
.const [177] = Utf8 (Ljava/lang/String;)V 
.const [178] = Utf8 java/lang/Object 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UUID844412Blob 
.const [182] = Utf8 <init> 
.const [183] = Utf8 ([S)V 
.const [184] = Utf8 de/esolutions/fw/comm/comm/broker/v4/InstanceID 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/UUID844412Blob;JLde/esolutions/fw/comm/comm/broker/v4/UUID844412Blob;)V 
.const [187] = Utf8 de/esolutions/fw/comm/core/UUID 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ([B)V 
.const [190] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/esolutions/fw/comm/core/UUID;)V 
.const [193] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lde/esolutions/fw/comm/core/ServiceUUID;ILde/esolutions/fw/comm/core/ServiceUUID;)V 
.const [196] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/lang/String;)V 
.const [199] = Utf8 java/lang/StringBuffer 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [203] = Class [202] 
.const [204] = Utf8 java/lang/Object 
.const [205] = Class [204] 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 ()V 
.const [209] = Utf8 convertInstanceIDToIDL 
.const [210] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)Lde/esolutions/fw/comm/comm/broker/v4/InstanceID; 
.const [211] = Utf8 convertInstanceIDFromIDL 
.const [212] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;)Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [213] = Utf8 main 
.const [214] = Utf8 ([Ljava/lang/String;)V 
.end class 

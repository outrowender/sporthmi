.version 50 0 
.class public super [227] 
.super [229] 

.method private static [231] : [232] 
    .attribute [230] .code stack 2 locals 0 
L0:     iload_1 
L1:     iload_0 
L2:     iand 
L3:     iload_0 
L4:     if_icmpne L11 
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

.method private static [233] : [234] 
    .attribute [230] .code stack 2 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            0 : L119 
            1 : L104 
            2 : L107 
            4 : L113 
            8 : L116 
            16 : L95 
            32 : L101 
            64 : L92 
            128 : L98 
            256 : L110 
            default : L122 

L92:    ldc [2] 
L94:    areturn 
L95:    ldc [3] 
L97:    areturn 
L98:    ldc [4] 
L100:   areturn 
L101:   ldc [5] 
L103:   areturn 
L104:   ldc [6] 
L106:   areturn 
L107:   ldc [7] 
L109:   areturn 
L110:   ldc [8] 
L112:   areturn 
L113:   ldc [9] 
L115:   areturn 
L116:   ldc [10] 
L118:   areturn 
L119:   ldc [11] 
L121:   areturn 
L122:   new [49] 
L125:   dup 
L126:   invokespecial [45] 
L129:   ldc [13] 
L131:   invokevirtual [28] 
L134:   iload_0 
L135:   invokevirtual [29] 
L138:   invokevirtual [30] 
L141:   areturn 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method private static [235] : [236] 
    .attribute [230] .code stack 2 locals 4 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [46] 
L7:     astore_1 
L8:     aload_1 
L9:     iload_0 
L10:    invokevirtual [31] 
L13:    pop 
L14:    aload_1 
L15:    ldc [15] 
L17:    invokevirtual [32] 
L20:    pop 
L21:    iload_0 
L22:    ifne L37 
L25:    aload_1 
L26:    iload_0 
L27:    invokestatic [16] 
L30:    invokevirtual [32] 
L33:    pop 
L34:    goto L101 
L37:    iconst_0 
L38:    istore_2 
L39:    iconst_0 
L40:    istore_3 
L41:    iconst_0 
L42:    istore 4 
L44:    iload 4 
L46:    bipush 32 
L48:    if_icmpge L101 
L51:    iload_2 
L52:    ifne L60 
L55:    iconst_1 
L56:    istore_2 
L57:    goto L64 
L60:    iload_2 
L61:    iconst_1 
L62:    ishl 
L63:    istore_2 
L64:    iload_2 
L65:    iload_0 
L66:    invokestatic [17] 
L69:    ifeq L95 
L72:    iload_3 
L73:    ifle L83 
L76:    aload_1 
L77:    bipush 124 
L79:    invokevirtual [33] 
L82:    pop 
L83:    aload_1 
L84:    iload_2 
L85:    invokestatic [16] 
L88:    invokevirtual [32] 
L91:    pop 
L92:    iinc 3 1 
L95:    iinc 4 1 
L98:    goto L44 
L101:   aload_1 
L102:   ldc [18] 
L104:   invokevirtual [32] 
L107:   pop 
L108:   aload_1 
L109:   invokevirtual [34] 
L112:   areturn 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_1 
L5:     ifnull L48 
L8:     aload_0 
L9:     aload_1 
L10:    getfield [35] 
L13:    putfield [51] 
L16:    aload_0 
L17:    aload_1 
L18:    getfield [37] 
L21:    putfield [52] 
L24:    aload_0 
L25:    aload_1 
L26:    getfield [39] 
L29:    putfield [53] 
L32:    aload_0 
L33:    aload_1 
L34:    getfield [41] 
L37:    putfield [54] 
L40:    aload_0 
L41:    aload_1 
L42:    getfield [43] 
L45:    putfield [55] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public annotation [239] : [240] 
    .attribute [230] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iload 4 
L6:     aload 5 
L8:     invokespecial [48] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [230] .code stack 2 locals 1 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [46] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [19] 
L11:    invokevirtual [32] 
L14:    pop 
L15:    aload_1 
L16:    bipush 40 
L18:    invokevirtual [33] 
L21:    pop 
L22:    aload_1 
L23:    ldc [20] 
L25:    invokevirtual [32] 
L28:    pop 
L29:    aload_1 
L30:    bipush 61 
L32:    invokevirtual [33] 
L35:    pop 
L36:    aload_1 
L37:    aload_0 
L38:    getfield [36] 
L41:    invokevirtual [31] 
L44:    pop 
L45:    aload_1 
L46:    bipush 44 
L48:    invokevirtual [33] 
L51:    pop 
L52:    aload_1 
L53:    ldc [21] 
L55:    invokevirtual [32] 
L58:    pop 
L59:    aload_1 
L60:    bipush 61 
L62:    invokevirtual [33] 
L65:    pop 
L66:    aload_1 
L67:    aload_0 
L68:    getfield [44] 
L71:    invokevirtual [31] 
L74:    pop 
L75:    aload_1 
L76:    bipush 44 
L78:    invokevirtual [33] 
L81:    pop 
L82:    aload_1 
L83:    ldc [22] 
L85:    invokevirtual [32] 
L88:    pop 
L89:    aload_1 
L90:    bipush 61 
L92:    invokevirtual [33] 
L95:    pop 
L96:    aload_1 
L97:    aload_0 
L98:    getfield [42] 
L101:   invokevirtual [31] 
L104:   pop 
L105:   aload_1 
L106:   bipush 44 
L108:   invokevirtual [33] 
L111:   pop 
L112:   aload_1 
L113:   ldc [23] 
L115:   invokevirtual [32] 
L118:   pop 
L119:   aload_1 
L120:   bipush 61 
L122:   invokevirtual [33] 
L125:   pop 
L126:   aload_1 
L127:   aload_0 
L128:   getfield [38] 
L131:   invokestatic [24] 
L134:   invokevirtual [32] 
L137:   pop 
L138:   aload_1 
L139:   bipush 44 
L141:   invokevirtual [33] 
L144:   pop 
L145:   aload_1 
L146:   ldc [25] 
L148:   invokevirtual [32] 
L151:   pop 
L152:   aload_1 
L153:   bipush 61 
L155:   invokevirtual [33] 
L158:   pop 
L159:   aload_1 
L160:   bipush 34 
L162:   invokevirtual [33] 
L165:   pop 
L166:   aload_1 
L167:   aload_0 
L168:   getfield [40] 
L171:   invokevirtual [32] 
L174:   pop 
L175:   aload_1 
L176:   bipush 34 
L178:   invokevirtual [33] 
L181:   pop 
L182:   aload_1 
L183:   bipush 41 
L185:   invokevirtual [33] 
L188:   pop 
L189:   aload_1 
L190:   invokevirtual [34] 
L193:   areturn 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [56] 
.const [3] = String [57] 
.const [4] = String [58] 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = String [61] 
.const [8] = String [62] 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = Class [66] 
.const [13] = String [67] 
.const [14] = Class [68] 
.const [15] = String [69] 
.const [16] = Method [70] [71] 
.const [17] = Method [72] [73] 
.const [18] = String [74] 
.const [19] = String [75] 
.const [20] = String [76] 
.const [21] = String [77] 
.const [22] = String [78] 
.const [23] = String [79] 
.const [24] = Method [80] [81] 
.const [25] = String [82] 
.const [26] = Class [83] 
.const [27] = Class [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Field [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Field [103] [104] 
.const [38] = Field [105] [106] 
.const [39] = Field [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Field [115] [116] 
.const [44] = Field [117] [118] 
.const [45] = Method [119] [120] 
.const [46] = Method [121] [122] 
.const [47] = Method [123] [124] 
.const [48] = Method [125] [126] 
.const [49] = Class [127] 
.const [50] = Class [128] 
.const [51] = Field [129] [130] 
.const [52] = Field [131] [132] 
.const [53] = Field [133] [134] 
.const [54] = Field [135] [136] 
.const [55] = Field [137] [138] 
.const [56] = Utf8 ADD_TO_CONFERENCE 
.const [57] = Utf8 ENHCALL 
.const [58] = Utf8 ENHCONFERENCE_TRANSFER 
.const [59] = Utf8 ENHSTAT 
.const [60] = Utf8 INBAND 
.const [61] = Utf8 REJECTCALL 
.const [62] = Utf8 REJECTMOBILE 
.const [63] = Utf8 RESPHOLD 
.const [64] = Utf8 THREEWAY 
.const [65] = Utf8 UNKNOWN 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 'Unknown telFeat ' 
.const [68] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [69] = Utf8 ( 
.const [70] = Class [139] 
.const [71] = NameAndType [140] [141] 
.const [72] = Class [142] 
.const [73] = NameAndType [143] [144] 
.const [74] = Utf8 ')' 
.const [75] = Utf8 ActivationStateStruct 
.const [76] = Utf8 telActivationState 
.const [77] = Utf8 telPhoneModuleState 
.const [78] = Utf8 telMode 
.const [79] = Utf8 telFeat 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Utf8 telHFPVersion 
.const [83] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [84] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
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
.const [99] = Class [169] 
.const [100] = NameAndType [170] [171] 
.const [101] = Class [172] 
.const [102] = NameAndType [173] [174] 
.const [103] = Class [175] 
.const [104] = NameAndType [176] [177] 
.const [105] = Class [178] 
.const [106] = NameAndType [179] [180] 
.const [107] = Class [181] 
.const [108] = NameAndType [182] [183] 
.const [109] = Class [184] 
.const [110] = NameAndType [185] [186] 
.const [111] = Class [187] 
.const [112] = NameAndType [188] [189] 
.const [113] = Class [190] 
.const [114] = NameAndType [191] [192] 
.const [115] = Class [193] 
.const [116] = NameAndType [194] [195] 
.const [117] = Class [196] 
.const [118] = NameAndType [197] [198] 
.const [119] = Class [199] 
.const [120] = NameAndType [200] [201] 
.const [121] = Class [202] 
.const [122] = NameAndType [203] [204] 
.const [123] = Class [205] 
.const [124] = NameAndType [206] [207] 
.const [125] = Class [208] 
.const [126] = NameAndType [209] [210] 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [129] = Class [211] 
.const [130] = NameAndType [212] [213] 
.const [131] = Class [214] 
.const [132] = NameAndType [215] [216] 
.const [133] = Class [217] 
.const [134] = NameAndType [218] [219] 
.const [135] = Class [220] 
.const [136] = NameAndType [221] [222] 
.const [137] = Class [223] 
.const [138] = NameAndType [224] [225] 
.const [139] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [140] = Utf8 getTelFeatName 
.const [141] = Utf8 (I)Ljava/lang/String; 
.const [142] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [143] = Utf8 containsFeature 
.const [144] = Utf8 (II)Z 
.const [145] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [146] = Utf8 getTelFeatures 
.const [147] = Utf8 (I)Ljava/lang/String; 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 append 
.const [153] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 toString 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [158] = Utf8 append 
.const [159] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [160] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [161] = Utf8 append 
.const [162] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [163] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [166] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [167] = Utf8 toString 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [170] = Utf8 telActivationState 
.const [171] = Utf8 I 
.const [172] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [173] = Utf8 telActivationState 
.const [174] = Utf8 I 
.const [175] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [176] = Utf8 telFeat 
.const [177] = Utf8 S 
.const [178] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [179] = Utf8 telFeat 
.const [180] = Utf8 S 
.const [181] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [182] = Utf8 telHFPVersion 
.const [183] = Utf8 Ljava/lang/String; 
.const [184] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [185] = Utf8 telHFPVersion 
.const [186] = Utf8 Ljava/lang/String; 
.const [187] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [188] = Utf8 telMode 
.const [189] = Utf8 I 
.const [190] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [191] = Utf8 telMode 
.const [192] = Utf8 I 
.const [193] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [194] = Utf8 telPhoneModuleState 
.const [195] = Utf8 I 
.const [196] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [197] = Utf8 telPhoneModuleState 
.const [198] = Utf8 I 
.const [199] = Utf8 java/lang/StringBuffer 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [203] = Utf8 <init> 
.const [204] = Utf8 ()V 
.const [205] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (IIISLjava/lang/String;)V 
.const [211] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [212] = Utf8 telActivationState 
.const [213] = Utf8 I 
.const [214] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [215] = Utf8 telFeat 
.const [216] = Utf8 S 
.const [217] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [218] = Utf8 telHFPVersion 
.const [219] = Utf8 Ljava/lang/String; 
.const [220] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [221] = Utf8 telMode 
.const [222] = Utf8 I 
.const [223] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [224] = Utf8 telPhoneModuleState 
.const [225] = Utf8 I 
.const [226] = Utf8 de/audi/app/phone/core/dsi/TelActivationStateStruct 
.const [227] = Class [226] 
.const [228] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [229] = Class [228] 
.const [230] = Utf8 Code 
.const [231] = Utf8 containsFeature 
.const [232] = Utf8 (II)Z 
.const [233] = Utf8 getTelFeatName 
.const [234] = Utf8 (I)Ljava/lang/String; 
.const [235] = Utf8 getTelFeatures 
.const [236] = Utf8 (I)Ljava/lang/String; 
.const [237] = Utf8 <init> 
.const [238] = Utf8 (Lorg/dsi/ifc/telephoneng/ActivationStateStruct;)V 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (IIISLjava/lang/String;)V 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.end class 

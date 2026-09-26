.version 50 0 
.class public super [291] 
.super [293] 

.method public annotation [295] : [296] 
    .attribute [294] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [297] : [298] 
    .attribute [294] .code stack 2 locals 20 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [30] 0 
L17:    iload_2 
L18:    ifne L285 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [30] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [30] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [30] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [30] 0 
L75:    aload_1 
L76:    invokevirtual [13] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [30] 0 
L89:    aload_1 
L90:    invokevirtual [14] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [30] 0 
L103:   aload_1 
L104:   invokevirtual [15] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [30] 0 
L117:   aload_1 
L118:   invokevirtual [16] 
L121:   istore 10 
L123:   aload_0 
L124:   iload 10 
L126:   invokeinterface [30] 0 
L131:   aload_1 
L132:   invokevirtual [17] 
L135:   istore 11 
L137:   aload_0 
L138:   iload 11 
L140:   invokeinterface [30] 0 
L145:   aload_1 
L146:   invokevirtual [18] 
L149:   istore 12 
L151:   aload_0 
L152:   iload 12 
L154:   invokeinterface [30] 0 
L159:   aload_1 
L160:   invokevirtual [19] 
L163:   istore 13 
L165:   aload_0 
L166:   iload 13 
L168:   invokeinterface [30] 0 
L173:   aload_1 
L174:   invokevirtual [20] 
L177:   istore 14 
L179:   aload_0 
L180:   iload 14 
L182:   invokeinterface [30] 0 
L187:   aload_1 
L188:   invokevirtual [21] 
L191:   istore 15 
L193:   aload_0 
L194:   iload 15 
L196:   invokeinterface [30] 0 
L201:   aload_1 
L202:   invokevirtual [22] 
L205:   istore 16 
L207:   aload_0 
L208:   iload 16 
L210:   invokeinterface [30] 0 
L215:   aload_1 
L216:   invokevirtual [23] 
L219:   istore 17 
L221:   aload_0 
L222:   iload 17 
L224:   invokeinterface [30] 0 
L229:   aload_1 
L230:   invokevirtual [24] 
L233:   istore 18 
L235:   aload_0 
L236:   iload 18 
L238:   invokeinterface [30] 0 
L243:   aload_1 
L244:   invokevirtual [25] 
L247:   istore 19 
L249:   aload_0 
L250:   iload 19 
L252:   invokeinterface [30] 0 
L257:   aload_1 
L258:   invokevirtual [26] 
L261:   istore 20 
L263:   aload_0 
L264:   iload 20 
L266:   invokeinterface [30] 0 
L271:   aload_1 
L272:   invokevirtual [27] 
L275:   istore 21 
L277:   aload_0 
L278:   iload 21 
L280:   invokeinterface [30] 0 
L285:   return 
L286:   nop 
L287:   nop 
L288:   
    .end code 
.end method 

.method public static [299] : [300] 
    .attribute [294] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [30] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [31] 0 
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

.method public static [301] : [302] 
    .attribute [294] .code stack 2 locals 21 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [32] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L285 
L13:    new [33] 
L16:    dup 
L17:    invokespecial [29] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [32] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [34] 
L33:    aload_0 
L34:    invokeinterface [32] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [35] 
L47:    aload_0 
L48:    invokeinterface [32] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [36] 
L61:    aload_0 
L62:    invokeinterface [32] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [37] 
L75:    aload_0 
L76:    invokeinterface [32] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [38] 
L89:    aload_0 
L90:    invokeinterface [32] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [39] 
L103:   aload_0 
L104:   invokeinterface [32] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [40] 
L117:   aload_0 
L118:   invokeinterface [32] 0 
L123:   istore 10 
L125:   aload_1 
L126:   iload 10 
L128:   putfield [41] 
L131:   aload_0 
L132:   invokeinterface [32] 0 
L137:   istore 11 
L139:   aload_1 
L140:   iload 11 
L142:   putfield [42] 
L145:   aload_0 
L146:   invokeinterface [32] 0 
L151:   istore 12 
L153:   aload_1 
L154:   iload 12 
L156:   putfield [43] 
L159:   aload_0 
L160:   invokeinterface [32] 0 
L165:   istore 13 
L167:   aload_1 
L168:   iload 13 
L170:   putfield [44] 
L173:   aload_0 
L174:   invokeinterface [32] 0 
L179:   istore 14 
L181:   aload_1 
L182:   iload 14 
L184:   putfield [45] 
L187:   aload_0 
L188:   invokeinterface [32] 0 
L193:   istore 15 
L195:   aload_1 
L196:   iload 15 
L198:   putfield [46] 
L201:   aload_0 
L202:   invokeinterface [32] 0 
L207:   istore 16 
L209:   aload_1 
L210:   iload 16 
L212:   putfield [47] 
L215:   aload_0 
L216:   invokeinterface [32] 0 
L221:   istore 17 
L223:   aload_1 
L224:   iload 17 
L226:   putfield [48] 
L229:   aload_0 
L230:   invokeinterface [32] 0 
L235:   istore 18 
L237:   aload_1 
L238:   iload 18 
L240:   putfield [49] 
L243:   aload_0 
L244:   invokeinterface [32] 0 
L249:   istore 19 
L251:   aload_1 
L252:   iload 19 
L254:   putfield [50] 
L257:   aload_0 
L258:   invokeinterface [32] 0 
L263:   istore 20 
L265:   aload_1 
L266:   iload 20 
L268:   putfield [51] 
L271:   aload_0 
L272:   invokeinterface [32] 0 
L277:   istore 21 
L279:   aload_1 
L280:   iload 21 
L282:   putfield [52] 
L285:   aload_1 
L286:   areturn 
L287:   nop 
L288:   
    .end code 
.end method 

.method public static [303] : [304] 
    .attribute [294] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [32] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [53] 0 
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
.const [2] = Method [54] [55] 
.const [3] = Class [56] 
.const [4] = Method [57] [58] 
.const [5] = Class [59] 
.const [6] = Class [60] 
.const [7] = Class [61] 
.const [8] = Class [62] 
.const [9] = Method [63] [64] 
.const [10] = Method [65] [66] 
.const [11] = Method [67] [68] 
.const [12] = Method [69] [70] 
.const [13] = Method [71] [72] 
.const [14] = Method [73] [74] 
.const [15] = Method [75] [76] 
.const [16] = Method [77] [78] 
.const [17] = Method [79] [80] 
.const [18] = Method [81] [82] 
.const [19] = Method [83] [84] 
.const [20] = Method [85] [86] 
.const [21] = Method [87] [88] 
.const [22] = Method [89] [90] 
.const [23] = Method [91] [92] 
.const [24] = Method [93] [94] 
.const [25] = Method [95] [96] 
.const [26] = Method [97] [98] 
.const [27] = Method [99] [100] 
.const [28] = Method [101] [102] 
.const [29] = Method [103] [104] 
.const [30] = InterfaceMethod [105] [106] 
.const [31] = InterfaceMethod [107] [108] 
.const [32] = InterfaceMethod [109] [110] 
.const [33] = Class [111] 
.const [34] = Field [112] [113] 
.const [35] = Field [114] [115] 
.const [36] = Field [116] [117] 
.const [37] = Field [118] [119] 
.const [38] = Field [120] [121] 
.const [39] = Field [122] [123] 
.const [40] = Field [124] [125] 
.const [41] = Field [126] [127] 
.const [42] = Field [128] [129] 
.const [43] = Field [130] [131] 
.const [44] = Field [132] [133] 
.const [45] = Field [134] [135] 
.const [46] = Field [136] [137] 
.const [47] = Field [138] [139] 
.const [48] = Field [140] [141] 
.const [49] = Field [142] [143] 
.const [50] = Field [144] [145] 
.const [51] = Field [146] [147] 
.const [52] = Field [148] [149] 
.const [53] = InterfaceMethod [150] [151] 
.const [54] = Class [152] 
.const [55] = NameAndType [153] [154] 
.const [56] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [57] = Class [155] 
.const [58] = NameAndType [156] [157] 
.const [59] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCFISAdditionalConfigurationSerializer 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [62] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [63] = Class [158] 
.const [64] = NameAndType [159] [160] 
.const [65] = Class [161] 
.const [66] = NameAndType [162] [163] 
.const [67] = Class [164] 
.const [68] = NameAndType [165] [166] 
.const [69] = Class [167] 
.const [70] = NameAndType [168] [169] 
.const [71] = Class [170] 
.const [72] = NameAndType [171] [172] 
.const [73] = Class [173] 
.const [74] = NameAndType [174] [175] 
.const [75] = Class [176] 
.const [76] = NameAndType [177] [178] 
.const [77] = Class [179] 
.const [78] = NameAndType [180] [181] 
.const [79] = Class [182] 
.const [80] = NameAndType [183] [184] 
.const [81] = Class [185] 
.const [82] = NameAndType [186] [187] 
.const [83] = Class [188] 
.const [84] = NameAndType [189] [190] 
.const [85] = Class [191] 
.const [86] = NameAndType [192] [193] 
.const [87] = Class [194] 
.const [88] = NameAndType [195] [196] 
.const [89] = Class [197] 
.const [90] = NameAndType [198] [199] 
.const [91] = Class [200] 
.const [92] = NameAndType [201] [202] 
.const [93] = Class [203] 
.const [94] = NameAndType [204] [205] 
.const [95] = Class [206] 
.const [96] = NameAndType [207] [208] 
.const [97] = Class [209] 
.const [98] = NameAndType [210] [211] 
.const [99] = Class [212] 
.const [100] = NameAndType [213] [214] 
.const [101] = Class [215] 
.const [102] = NameAndType [216] [217] 
.const [103] = Class [218] 
.const [104] = NameAndType [219] [220] 
.const [105] = Class [221] 
.const [106] = NameAndType [222] [223] 
.const [107] = Class [224] 
.const [108] = NameAndType [225] [226] 
.const [109] = Class [227] 
.const [110] = NameAndType [228] [229] 
.const [111] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [112] = Class [230] 
.const [113] = NameAndType [231] [232] 
.const [114] = Class [233] 
.const [115] = NameAndType [234] [235] 
.const [116] = Class [236] 
.const [117] = NameAndType [237] [238] 
.const [118] = Class [239] 
.const [119] = NameAndType [240] [241] 
.const [120] = Class [242] 
.const [121] = NameAndType [243] [244] 
.const [122] = Class [245] 
.const [123] = NameAndType [246] [247] 
.const [124] = Class [248] 
.const [125] = NameAndType [249] [250] 
.const [126] = Class [251] 
.const [127] = NameAndType [252] [253] 
.const [128] = Class [254] 
.const [129] = NameAndType [255] [256] 
.const [130] = Class [257] 
.const [131] = NameAndType [258] [259] 
.const [132] = Class [260] 
.const [133] = NameAndType [261] [262] 
.const [134] = Class [263] 
.const [135] = NameAndType [264] [265] 
.const [136] = Class [266] 
.const [137] = NameAndType [267] [268] 
.const [138] = Class [269] 
.const [139] = NameAndType [270] [271] 
.const [140] = Class [272] 
.const [141] = NameAndType [273] [274] 
.const [142] = Class [275] 
.const [143] = NameAndType [276] [277] 
.const [144] = Class [278] 
.const [145] = NameAndType [279] [280] 
.const [146] = Class [281] 
.const [147] = NameAndType [282] [283] 
.const [148] = Class [284] 
.const [149] = NameAndType [285] [286] 
.const [150] = Class [287] 
.const [151] = NameAndType [288] [289] 
.const [152] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCFISAdditionalConfigurationSerializer 
.const [153] = Utf8 putOptionalBCFISAdditionalConfiguration 
.const [154] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration;)V 
.const [155] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCFISAdditionalConfigurationSerializer 
.const [156] = Utf8 getOptionalBCFISAdditionalConfiguration 
.const [157] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration; 
.const [158] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [159] = Utf8 isFis1 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [162] = Utf8 isFis2 
.const [163] = Utf8 ()Z 
.const [164] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [165] = Utf8 isFis3 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [168] = Utf8 isStopWatch 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [171] = Utf8 isOilTemp 
.const [172] = Utf8 ()Z 
.const [173] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [174] = Utf8 isDigitalSpeed 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [177] = Utf8 isRefuelVolume 
.const [178] = Utf8 ()Z 
.const [179] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [180] = Utf8 isSpeedWarning 
.const [181] = Utf8 ()Z 
.const [182] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [183] = Utf8 isCoolantTemp 
.const [184] = Utf8 ()Z 
.const [185] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [186] = Utf8 isSecondarySpeed 
.const [187] = Utf8 ()Z 
.const [188] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [189] = Utf8 isVza 
.const [190] = Utf8 ()Z 
.const [191] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [192] = Utf8 isResetTime 
.const [193] = Utf8 ()Z 
.const [194] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [195] = Utf8 isComfortPowerConsumption 
.const [196] = Utf8 ()Z 
.const [197] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [198] = Utf8 isZeroEmissionTime 
.const [199] = Utf8 ()Z 
.const [200] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [201] = Utf8 isZeroEmissionDistance 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [204] = Utf8 isVzaMfa 
.const [205] = Utf8 ()Z 
.const [206] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [207] = Utf8 isBcmeConsumerList 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [210] = Utf8 isBcmeLiveTips 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [213] = Utf8 isAstaMfa 
.const [214] = Utf8 ()Z 
.const [215] = Utf8 java/lang/Object 
.const [216] = Utf8 <init> 
.const [217] = Utf8 ()V 
.const [218] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [222] = Utf8 putBool 
.const [223] = Utf8 (Z)V 
.const [224] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [225] = Utf8 putInt32 
.const [226] = Utf8 (I)V 
.const [227] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [228] = Utf8 getBool 
.const [229] = Utf8 ()Z 
.const [230] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [231] = Utf8 fis1 
.const [232] = Utf8 Z 
.const [233] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [234] = Utf8 fis2 
.const [235] = Utf8 Z 
.const [236] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [237] = Utf8 fis3 
.const [238] = Utf8 Z 
.const [239] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [240] = Utf8 stopWatch 
.const [241] = Utf8 Z 
.const [242] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [243] = Utf8 oilTemp 
.const [244] = Utf8 Z 
.const [245] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [246] = Utf8 digitalSpeed 
.const [247] = Utf8 Z 
.const [248] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [249] = Utf8 refuelVolume 
.const [250] = Utf8 Z 
.const [251] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [252] = Utf8 speedWarning 
.const [253] = Utf8 Z 
.const [254] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [255] = Utf8 coolantTemp 
.const [256] = Utf8 Z 
.const [257] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [258] = Utf8 secondarySpeed 
.const [259] = Utf8 Z 
.const [260] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [261] = Utf8 vza 
.const [262] = Utf8 Z 
.const [263] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [264] = Utf8 resetTime 
.const [265] = Utf8 Z 
.const [266] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [267] = Utf8 comfortPowerConsumption 
.const [268] = Utf8 Z 
.const [269] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [270] = Utf8 zeroEmissionTime 
.const [271] = Utf8 Z 
.const [272] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [273] = Utf8 zeroEmissionDistance 
.const [274] = Utf8 Z 
.const [275] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [276] = Utf8 vzaMfa 
.const [277] = Utf8 Z 
.const [278] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [279] = Utf8 bcmeConsumerList 
.const [280] = Utf8 Z 
.const [281] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [282] = Utf8 bcmeLiveTips 
.const [283] = Utf8 Z 
.const [284] = Utf8 org/dsi/ifc/carkombi/BCFISAdditionalConfiguration 
.const [285] = Utf8 astaMfa 
.const [286] = Utf8 Z 
.const [287] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [288] = Utf8 getInt32 
.const [289] = Utf8 ()I 
.const [290] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCFISAdditionalConfigurationSerializer 
.const [291] = Class [290] 
.const [292] = Utf8 java/lang/Object 
.const [293] = Class [292] 
.const [294] = Utf8 Code 
.const [295] = Utf8 <init> 
.const [296] = Utf8 ()V 
.const [297] = Utf8 putOptionalBCFISAdditionalConfiguration 
.const [298] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration;)V 
.const [299] = Utf8 putOptionalBCFISAdditionalConfigurationVarArray 
.const [300] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration;)V 
.const [301] = Utf8 getOptionalBCFISAdditionalConfiguration 
.const [302] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration; 
.const [303] = Utf8 getOptionalBCFISAdditionalConfigurationVarArray 
.const [304] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/carkombi/BCFISAdditionalConfiguration; 
.end class 

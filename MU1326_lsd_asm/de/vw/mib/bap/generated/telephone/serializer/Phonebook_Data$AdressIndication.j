.version 50 0 
.class public final super [215] 
.super [217] 
.implements [219] 
.field public [220] [221] 
.field public [222] [223] 
.field public [224] [225] 
.field public [226] [227] 
.field public [228] [229] 
.field public [230] [231] 
.field public [232] [233] 
.field public [234] [235] 
.field private static final [236] [237] 

.method public [239] : [240] 
    .attribute [238] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     invokespecial [41] 
L8:     aload_0 
L9:     invokespecial [42] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [238] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [29] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [243] : [244] 
    .attribute [238] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [45] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [46] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [47] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [48] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [49] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [50] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [51] 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield [52] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [238] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [238] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [30] 
L9:     aload_2 
L10:    getfield [30] 
L13:    if_icmpne L97 
L16:    aload_0 
L17:    getfield [31] 
L20:    aload_2 
L21:    getfield [31] 
L24:    if_icmpne L97 
L27:    aload_0 
L28:    getfield [32] 
L31:    aload_2 
L32:    getfield [32] 
L35:    if_icmpne L97 
L38:    aload_0 
L39:    getfield [33] 
L42:    aload_2 
L43:    getfield [33] 
L46:    if_icmpne L97 
L49:    aload_0 
L50:    getfield [34] 
L53:    aload_2 
L54:    getfield [34] 
L57:    if_icmpne L97 
L60:    aload_0 
L61:    getfield [35] 
L64:    aload_2 
L65:    getfield [35] 
L68:    if_icmpne L97 
L71:    aload_0 
L72:    getfield [36] 
L75:    aload_2 
L76:    getfield [36] 
L79:    if_icmpne L97 
L82:    aload_0 
L83:    getfield [37] 
L86:    aload_2 
L87:    getfield [37] 
L90:    if_icmpne L97 
L93:    iconst_1 
L94:    goto L98 
L97:    iconst_0 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method private enum [249] : [250] 
    .attribute [238] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [238] .code stack 2 locals 1 
L0:     new [53] 
L3:     dup 
L4:     invokespecial [44] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [38] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [38] 
L21:    pop 
L22:    aload_0 
L23:    getfield [30] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [38] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [38] 
L45:    pop 
L46:    aload_1 
L47:    ldc [8] 
L49:    invokevirtual [38] 
L52:    pop 
L53:    aload_0 
L54:    getfield [31] 
L57:    ifeq L70 
L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [38] 
L66:    pop 
L67:    goto L77 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [38] 
L76:    pop 
L77:    aload_1 
L78:    ldc [9] 
L80:    invokevirtual [38] 
L83:    pop 
L84:    aload_0 
L85:    getfield [32] 
L88:    ifeq L101 
L91:    aload_1 
L92:    ldc [10] 
L94:    invokevirtual [38] 
L97:    pop 
L98:    goto L108 
L101:   aload_1 
L102:   ldc [11] 
L104:   invokevirtual [38] 
L107:   pop 
L108:   aload_1 
L109:   ldc [12] 
L111:   invokevirtual [38] 
L114:   pop 
L115:   aload_0 
L116:   getfield [33] 
L119:   ifeq L132 
L122:   aload_1 
L123:   ldc [13] 
L125:   invokevirtual [38] 
L128:   pop 
L129:   goto L139 
L132:   aload_1 
L133:   ldc [14] 
L135:   invokevirtual [38] 
L138:   pop 
L139:   aload_1 
L140:   ldc [15] 
L142:   invokevirtual [38] 
L145:   pop 
L146:   aload_0 
L147:   getfield [34] 
L150:   ifeq L163 
L153:   aload_1 
L154:   ldc [16] 
L156:   invokevirtual [38] 
L159:   pop 
L160:   goto L170 
L163:   aload_1 
L164:   ldc [17] 
L166:   invokevirtual [38] 
L169:   pop 
L170:   aload_1 
L171:   ldc [18] 
L173:   invokevirtual [38] 
L176:   pop 
L177:   aload_0 
L178:   getfield [35] 
L181:   ifeq L194 
L184:   aload_1 
L185:   ldc [19] 
L187:   invokevirtual [38] 
L190:   pop 
L191:   goto L201 
L194:   aload_1 
L195:   ldc [20] 
L197:   invokevirtual [38] 
L200:   pop 
L201:   aload_1 
L202:   ldc [21] 
L204:   invokevirtual [38] 
L207:   pop 
L208:   aload_0 
L209:   getfield [36] 
L212:   ifeq L225 
L215:   aload_1 
L216:   ldc [22] 
L218:   invokevirtual [38] 
L221:   pop 
L222:   goto L232 
L225:   aload_1 
L226:   ldc [23] 
L228:   invokevirtual [38] 
L231:   pop 
L232:   aload_1 
L233:   ldc [24] 
L235:   invokevirtual [38] 
L238:   pop 
L239:   aload_0 
L240:   getfield [37] 
L243:   ifeq L256 
L246:   aload_1 
L247:   ldc [25] 
L249:   invokevirtual [38] 
L252:   pop 
L253:   goto L263 
L256:   aload_1 
L257:   ldc [26] 
L259:   invokevirtual [38] 
L262:   pop 
L263:   aload_1 
L264:   invokevirtual [39] 
L267:   areturn 
L268:   
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [238] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [238] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [30] 
L5:     invokeinterface [54] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [31] 
L15:    invokeinterface [54] 0 
L20:    aload_1 
L21:    aload_0 
L22:    getfield [32] 
L25:    invokeinterface [54] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [33] 
L35:    invokeinterface [54] 0 
L40:    aload_1 
L41:    aload_0 
L42:    getfield [34] 
L45:    invokeinterface [54] 0 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [35] 
L55:    invokeinterface [54] 0 
L60:    aload_1 
L61:    aload_0 
L62:    getfield [36] 
L65:    invokeinterface [54] 0 
L70:    aload_1 
L71:    aload_0 
L72:    getfield [37] 
L75:    invokeinterface [54] 0 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [238] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [55] 0 
L7:     putfield [45] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [55] 0 
L17:    putfield [46] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [55] 0 
L27:    putfield [47] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [55] 0 
L37:    putfield [48] 
L40:    aload_0 
L41:    aload_1 
L42:    invokeinterface [55] 0 
L47:    putfield [49] 
L50:    aload_0 
L51:    aload_1 
L52:    invokeinterface [55] 0 
L57:    putfield [50] 
L60:    aload_0 
L61:    aload_1 
L62:    invokeinterface [55] 0 
L67:    putfield [51] 
L70:    aload_0 
L71:    aload_1 
L72:    invokeinterface [55] 0 
L77:    putfield [52] 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Class [57] 
.const [4] = String [58] 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = String [61] 
.const [8] = String [62] 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = String [66] 
.const [13] = String [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = String [72] 
.const [19] = String [73] 
.const [20] = String [74] 
.const [21] = String [75] 
.const [22] = String [76] 
.const [23] = String [77] 
.const [24] = String [78] 
.const [25] = String [79] 
.const [26] = String [80] 
.const [27] = Class [81] 
.const [28] = Class [82] 
.const [29] = Method [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = Field [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Field [95] [96] 
.const [36] = Field [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Method [111] [112] 
.const [44] = Method [113] [114] 
.const [45] = Field [115] [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Field [121] [122] 
.const [49] = Field [123] [124] 
.const [50] = Field [125] [126] 
.const [51] = Field [127] [128] 
.const [52] = Field [129] [130] 
.const [53] = Class [131] 
.const [54] = InterfaceMethod [132] [133] 
.const [55] = InterfaceMethod [134] [135] 
.const [56] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [57] = Utf8 java/lang/StringBuffer 
.const [58] = Utf8 'AdressIndication:' 
.const [59] = Utf8 '\n - Bit 7: ' 
.const [60] = Utf8 'true  (reserved' 
.const [61] = Utf8 'false  (reserved' 
.const [62] = Utf8 '\n - Bit 6: ' 
.const [63] = Utf8 '\n - Bit 5: ' 
.const [64] = Utf8 'true  (business address is suited as navigation destaination' 
.const [65] = Utf8 'false  (business address is NOT suited as navigation destaination' 
.const [66] = Utf8 '\n - Bit 4: ' 
.const [67] = Utf8 'true  (business address available' 
.const [68] = Utf8 'false  (business address NOT available' 
.const [69] = Utf8 '\n - Bit 3: ' 
.const [70] = Utf8 'true  (private (home) address is suited as navigation destaination' 
.const [71] = Utf8 'false  (private (home) address is NOT suited as navigation destaination' 
.const [72] = Utf8 '\n - Bit 2: ' 
.const [73] = Utf8 'true  (private (home) address available' 
.const [74] = Utf8 'false  (private (home) address NOT available' 
.const [75] = Utf8 '\n - Bit 1: ' 
.const [76] = Utf8 'true  (default address is suited as navigation destaination' 
.const [77] = Utf8 'false  (default address is NOT suited as navigation destaination' 
.const [78] = Utf8 '\n - Bit 0: ' 
.const [79] = Utf8 'true  (default address available' 
.const [80] = Utf8 'false  (default address NOT available' 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Class [139] 
.const [86] = NameAndType [140] [141] 
.const [87] = Class [142] 
.const [88] = NameAndType [143] [144] 
.const [89] = Class [145] 
.const [90] = NameAndType [146] [147] 
.const [91] = Class [148] 
.const [92] = NameAndType [149] [150] 
.const [93] = Class [151] 
.const [94] = NameAndType [152] [153] 
.const [95] = Class [154] 
.const [96] = NameAndType [155] [156] 
.const [97] = Class [157] 
.const [98] = NameAndType [158] [159] 
.const [99] = Class [160] 
.const [100] = NameAndType [161] [162] 
.const [101] = Class [163] 
.const [102] = NameAndType [164] [165] 
.const [103] = Class [166] 
.const [104] = NameAndType [167] [168] 
.const [105] = Class [169] 
.const [106] = NameAndType [170] [171] 
.const [107] = Class [172] 
.const [108] = NameAndType [173] [174] 
.const [109] = Class [175] 
.const [110] = NameAndType [176] [177] 
.const [111] = Class [178] 
.const [112] = NameAndType [179] [180] 
.const [113] = Class [181] 
.const [114] = NameAndType [182] [183] 
.const [115] = Class [184] 
.const [116] = NameAndType [185] [186] 
.const [117] = Class [187] 
.const [118] = NameAndType [188] [189] 
.const [119] = Class [190] 
.const [120] = NameAndType [191] [192] 
.const [121] = Class [193] 
.const [122] = NameAndType [194] [195] 
.const [123] = Class [196] 
.const [124] = NameAndType [197] [198] 
.const [125] = Class [199] 
.const [126] = NameAndType [200] [201] 
.const [127] = Class [202] 
.const [128] = NameAndType [203] [204] 
.const [129] = Class [205] 
.const [130] = NameAndType [206] [207] 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Class [208] 
.const [133] = NameAndType [209] [210] 
.const [134] = Class [211] 
.const [135] = NameAndType [212] [213] 
.const [136] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [137] = Utf8 deserialize 
.const [138] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [139] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [140] = Utf8 reserved_bit_7 
.const [141] = Utf8 Z 
.const [142] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [143] = Utf8 reserved_bit_6 
.const [144] = Utf8 Z 
.const [145] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [146] = Utf8 businessAddressIsSuitedAsNavigationDestaination 
.const [147] = Utf8 Z 
.const [148] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [149] = Utf8 businessAddressAvailable 
.const [150] = Utf8 Z 
.const [151] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [152] = Utf8 privateAddressIsSuitedAsNavigationDestaination 
.const [153] = Utf8 Z 
.const [154] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [155] = Utf8 privateAddressAvailable 
.const [156] = Utf8 Z 
.const [157] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [158] = Utf8 defaultAddressIsSuitedAsNavigationDestaination 
.const [159] = Utf8 Z 
.const [160] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [161] = Utf8 defaultAddressAvailable 
.const [162] = Utf8 Z 
.const [163] = Utf8 java/lang/StringBuffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 toString 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 java/lang/Object 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [173] = Utf8 internalReset 
.const [174] = Utf8 ()V 
.const [175] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [176] = Utf8 customInitialization 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 java/lang/StringBuffer 
.const [182] = Utf8 <init> 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [185] = Utf8 reserved_bit_7 
.const [186] = Utf8 Z 
.const [187] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [188] = Utf8 reserved_bit_6 
.const [189] = Utf8 Z 
.const [190] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [191] = Utf8 businessAddressIsSuitedAsNavigationDestaination 
.const [192] = Utf8 Z 
.const [193] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [194] = Utf8 businessAddressAvailable 
.const [195] = Utf8 Z 
.const [196] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [197] = Utf8 privateAddressIsSuitedAsNavigationDestaination 
.const [198] = Utf8 Z 
.const [199] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [200] = Utf8 privateAddressAvailable 
.const [201] = Utf8 Z 
.const [202] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [203] = Utf8 defaultAddressIsSuitedAsNavigationDestaination 
.const [204] = Utf8 Z 
.const [205] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [206] = Utf8 defaultAddressAvailable 
.const [207] = Utf8 Z 
.const [208] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [209] = Utf8 pushBoolean 
.const [210] = Utf8 (Z)V 
.const [211] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [212] = Utf8 popFrontBoolean 
.const [213] = Utf8 ()Z 
.const [214] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AdressIndication 
.const [215] = Class [214] 
.const [216] = Utf8 java/lang/Object 
.const [217] = Class [216] 
.const [218] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [219] = Class [218] 
.const [220] = Utf8 reserved_bit_7 
.const [221] = Utf8 Z 
.const [222] = Utf8 reserved_bit_6 
.const [223] = Utf8 Z 
.const [224] = Utf8 businessAddressIsSuitedAsNavigationDestaination 
.const [225] = Utf8 Z 
.const [226] = Utf8 businessAddressAvailable 
.const [227] = Utf8 Z 
.const [228] = Utf8 privateAddressIsSuitedAsNavigationDestaination 
.const [229] = Utf8 Z 
.const [230] = Utf8 privateAddressAvailable 
.const [231] = Utf8 Z 
.const [232] = Utf8 defaultAddressIsSuitedAsNavigationDestaination 
.const [233] = Utf8 Z 
.const [234] = Utf8 defaultAddressAvailable 
.const [235] = Utf8 Z 
.const [236] = Utf8 ADRESS_INDICATION_BITSIZE 
.const [237] = Utf8 I 
.const [238] = Utf8 Code 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [243] = Utf8 internalReset 
.const [244] = Utf8 ()V 
.const [245] = Utf8 reset 
.const [246] = Utf8 ()V 
.const [247] = Utf8 equalTo 
.const [248] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [249] = Utf8 customInitialization 
.const [250] = Utf8 ()V 
.const [251] = Utf8 toString 
.const [252] = Utf8 ()Ljava/lang/String; 
.const [253] = Utf8 bitSize 
.const [254] = Utf8 ()I 
.const [255] = Utf8 serialize 
.const [256] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [257] = Utf8 deserialize 
.const [258] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 

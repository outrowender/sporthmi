.version 50 0 
.class public super [229] 
.super [231] 
.implements [233] 
.field protected [234] [235] 
.field protected [236] [237] 
.field protected [238] [239] 
.field protected [240] [241] 
.field private final [242] [243] 
.field private final [244] [245] 
.field protected final [246] [247] 

.method public [249] : [250] 
    .attribute [248] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [37] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [38] 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [39] 
L17:    aload_0 
L18:    iconst_0 
L19:    putfield [40] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [41] 
L27:    aload_0 
L28:    aload 5 
L30:    putfield [42] 
L33:    aload_0 
L34:    aload 4 
L36:    iconst_0 
L37:    invokestatic [2] 
L40:    putfield [43] 
L43:    aload_0 
L44:    aload 6 
L46:    putfield [44] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [248] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [28] 
L12:    aload_0 
L13:    getfield [25] 
L16:    i2l 
L17:    invokevirtual [29] 
L20:    pop 
L21:    aload_0 
L22:    getfield [24] 
L25:    aload_0 
L26:    getfield [25] 
L29:    invokeinterface [45] 0 
L34:    lstore_1 
L35:    lload_1 
L36:    lconst_0 
L37:    lcmp 
L38:    ifne L65 
L41:    aload_0 
L42:    getfield [27] 
L45:    ldc [5] 
L47:    ldc [6] 
L49:    aload_0 
L50:    invokevirtual [28] 
L53:    invokevirtual [30] 
L56:    pop 
L57:    aload_0 
L58:    sipush 3001 
L61:    invokevirtual [31] 
L64:    return 
L65:    aload_0 
L66:    getfield [24] 
L69:    lload_1 
L70:    invokeinterface [46] 0 
L75:    aload_0 
L76:    getfield [27] 
L79:    ldc [3] 
L81:    ldc [7] 
L83:    aload_0 
L84:    invokevirtual [28] 
L87:    lload_1 
L88:    aload_0 
L89:    getfield [24] 
L92:    invokeinterface [47] 0 
L97:    i2l 
L98:    invokevirtual [32] 
L101:   pop 
L102:   aload_0 
L103:   getfield [26] 
L106:   lload_1 
L107:   aload_0 
L108:   getfield [24] 
L111:   invokeinterface [47] 0 
L116:   invokeinterface [48] 0 
L121:   return 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [248] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     aload_0 
L9:     invokevirtual [28] 
L12:    aload_2 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [33] 
L18:    iload_1 
L19:    ifeq L48 
L22:    aload_0 
L23:    getfield [27] 
L26:    ldc [5] 
L28:    ldc [9] 
L30:    aload_0 
L31:    invokevirtual [28] 
L34:    iload_1 
L35:    i2l 
L36:    invokevirtual [29] 
L39:    pop 
L40:    aload_0 
L41:    sipush 3001 
L44:    invokevirtual [31] 
L47:    return 
L48:    aload_0 
L49:    aload 5 
L51:    invokevirtual [34] 
L54:    aload_2 
L55:    invokestatic [10] 
L58:    aload_0 
L59:    getfield [24] 
L62:    aload 5 
L64:    arraylength 
L65:    iload_3 
L66:    aload 4 
L68:    invokeinterface [49] 0 
L73:    aload_0 
L74:    sipush 3000 
L77:    invokevirtual [31] 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method protected [255] : [256] 
    .attribute [248] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [35] 
L5:     aload_0 
L6:     getfield [20] 
L9:     aload_0 
L10:    getfield [21] 
L13:    aload_0 
L14:    getfield [22] 
L17:    aload_0 
L18:    getfield [23] 
L21:    invokestatic [11] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [257] : [258] 
    .attribute [248] .code stack 6 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L308 
L8:     aload_1 
L9:     iload_2 
L10:    iaload 
L11:    istore_3 
L12:    iload_3 
L13:    tableswitch 0 
            L76 
            L89 
            L112 
            L135 
            L148 
            L171 
            L194 
            L207 
            L230 
            L253 
            L256 
            L269 
            default : L282 

L76:    aload_0 
L77:    dup 
L78:    getfield [23] 
L81:    iconst_1 
L82:    iadd 
L83:    putfield [41] 
L86:    goto L302 
L89:    aload_0 
L90:    dup 
L91:    getfield [23] 
L94:    iconst_1 
L95:    iadd 
L96:    putfield [41] 
L99:    aload_0 
L100:   dup 
L101:   getfield [20] 
L104:   iconst_1 
L105:   iadd 
L106:   putfield [38] 
L109:   goto L302 
L112:   aload_0 
L113:   dup 
L114:   getfield [23] 
L117:   iconst_1 
L118:   iadd 
L119:   putfield [41] 
L122:   aload_0 
L123:   dup 
L124:   getfield [21] 
L127:   iconst_1 
L128:   iadd 
L129:   putfield [39] 
L132:   goto L302 
L135:   aload_0 
L136:   dup 
L137:   getfield [22] 
L140:   iconst_1 
L141:   iadd 
L142:   putfield [40] 
L145:   goto L302 
L148:   aload_0 
L149:   dup 
L150:   getfield [22] 
L153:   iconst_1 
L154:   iadd 
L155:   putfield [40] 
L158:   aload_0 
L159:   dup 
L160:   getfield [20] 
L163:   iconst_1 
L164:   iadd 
L165:   putfield [38] 
L168:   goto L302 
L171:   aload_0 
L172:   dup 
L173:   getfield [22] 
L176:   iconst_1 
L177:   iadd 
L178:   putfield [40] 
L181:   aload_0 
L182:   dup 
L183:   getfield [21] 
L186:   iconst_1 
L187:   iadd 
L188:   putfield [39] 
L191:   goto L302 
L194:   aload_0 
L195:   dup 
L196:   getfield [23] 
L199:   iconst_1 
L200:   iadd 
L201:   putfield [41] 
L204:   goto L302 
L207:   aload_0 
L208:   dup 
L209:   getfield [23] 
L212:   iconst_1 
L213:   iadd 
L214:   putfield [41] 
L217:   aload_0 
L218:   dup 
L219:   getfield [20] 
L222:   iconst_1 
L223:   iadd 
L224:   putfield [38] 
L227:   goto L302 
L230:   aload_0 
L231:   dup 
L232:   getfield [23] 
L235:   iconst_1 
L236:   iadd 
L237:   putfield [41] 
L240:   aload_0 
L241:   dup 
L242:   getfield [21] 
L245:   iconst_1 
L246:   iadd 
L247:   putfield [39] 
L250:   goto L302 
L253:   goto L302 
L256:   aload_0 
L257:   dup 
L258:   getfield [20] 
L261:   iconst_1 
L262:   iadd 
L263:   putfield [38] 
L266:   goto L302 
L269:   aload_0 
L270:   dup 
L271:   getfield [21] 
L274:   iconst_1 
L275:   iadd 
L276:   putfield [39] 
L279:   goto L302 
L282:   aload_0 
L283:   getfield [36] 
L286:   ldc [5] 
L288:   ldc [12] 
L290:   aload_0 
L291:   invokevirtual [28] 
L294:   aload_1 
L295:   iload_2 
L296:   iaload 
L297:   i2l 
L298:   invokevirtual [29] 
L301:   pop 
L302:   iinc 2 1 
L305:   goto L2 
L308:   return 
L309:   nop 
L310:   nop 
L311:   nop 
L312:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [50] [51] 
.const [3] = Int -2137614336 
.const [4] = String [52] 
.const [5] = Int -1601830656 
.const [6] = String [53] 
.const [7] = String [54] 
.const [8] = String [55] 
.const [9] = String [56] 
.const [10] = Method [57] [58] 
.const [11] = Method [59] [60] 
.const [12] = String [61] 
.const [13] = Class [62] 
.const [14] = Class [63] 
.const [15] = Class [64] 
.const [16] = Class [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Field [69] [70] 
.const [21] = Field [71] [72] 
.const [22] = Field [73] [74] 
.const [23] = Field [75] [76] 
.const [24] = Field [77] [78] 
.const [25] = Field [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Field [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Field [105] [106] 
.const [39] = Field [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Field [115] [116] 
.const [44] = Field [117] [118] 
.const [45] = InterfaceMethod [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = Class [129] 
.const [51] = NameAndType [130] [131] 
.const [52] = Utf8 '%1#execute: entryIDSource=%2!' 
.const [53] = Utf8 '%1#execute: No adbID found, returning ERROR!' 
.const [54] = Utf8 '%1#execute: adbID=%2, phoneNumberTypes=%3!' 
.const [55] = Utf8 '%1#responseFillTelNumberList: resultCode=%3, combinedName=%2!' 
.const [56] = Utf8 '%1#responseFillTelNumberList: Unhandled resultCode %2, sending ERROR!' 
.const [57] = Class [132] 
.const [58] = NameAndType [133] [134] 
.const [59] = Class [135] 
.const [60] = NameAndType [136] [137] 
.const [61] = Utf8 '%1#setChoiceModelValue: unknown number type %2' 
.const [62] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [63] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [64] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [67] = Utf8 de/audi/atip/interapp/ADBSDSService 
.const [68] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
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
.const [83] = Class [159] 
.const [84] = NameAndType [160] [161] 
.const [85] = Class [162] 
.const [86] = NameAndType [163] [164] 
.const [87] = Class [165] 
.const [88] = NameAndType [166] [167] 
.const [89] = Class [168] 
.const [90] = NameAndType [169] [170] 
.const [91] = Class [171] 
.const [92] = NameAndType [172] [173] 
.const [93] = Class [174] 
.const [94] = NameAndType [175] [176] 
.const [95] = Class [177] 
.const [96] = NameAndType [178] [179] 
.const [97] = Class [180] 
.const [98] = NameAndType [181] [182] 
.const [99] = Class [183] 
.const [100] = NameAndType [184] [185] 
.const [101] = Class [186] 
.const [102] = NameAndType [187] [188] 
.const [103] = Class [189] 
.const [104] = NameAndType [190] [191] 
.const [105] = Class [192] 
.const [106] = NameAndType [193] [194] 
.const [107] = Class [195] 
.const [108] = NameAndType [196] [197] 
.const [109] = Class [198] 
.const [110] = NameAndType [199] [200] 
.const [111] = Class [201] 
.const [112] = NameAndType [202] [203] 
.const [113] = Class [204] 
.const [114] = NameAndType [205] [206] 
.const [115] = Class [207] 
.const [116] = NameAndType [208] [209] 
.const [117] = Class [210] 
.const [118] = NameAndType [211] [212] 
.const [119] = Class [213] 
.const [120] = NameAndType [214] [215] 
.const [121] = Class [216] 
.const [122] = NameAndType [217] [218] 
.const [123] = Class [219] 
.const [124] = NameAndType [220] [221] 
.const [125] = Class [222] 
.const [126] = NameAndType [223] [224] 
.const [127] = Class [225] 
.const [128] = NameAndType [226] [227] 
.const [129] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [130] = Utf8 retrieveInteger 
.const [131] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [132] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [133] = Utf8 setADBEntryNameModel 
.const [134] = Utf8 (Ljava/lang/String;)V 
.const [135] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [136] = Utf8 setADBCategoryPhoneCountModel 
.const [137] = Utf8 (IIII)V 
.const [138] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [139] = Utf8 privateCount 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [142] = Utf8 businessCount 
.const [143] = Utf8 I 
.const [144] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [145] = Utf8 mobileCount 
.const [146] = Utf8 I 
.const [147] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [148] = Utf8 generalCount 
.const [149] = Utf8 I 
.const [150] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [151] = Utf8 adbHandler 
.const [152] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [153] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [154] = Utf8 entryIDSource 
.const [155] = Utf8 I 
.const [156] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [157] = Utf8 adbService 
.const [158] = Utf8 Lde/audi/atip/interapp/ADBSDSService; 
.const [159] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [160] = Utf8 logger 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [163] = Utf8 getName 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [171] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [172] = Utf8 sendResult 
.const [173] = Utf8 (I)V 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 log 
.const [179] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [180] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [181] = Utf8 setChoiceModelValues 
.const [182] = Utf8 ([I)V 
.const [183] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [184] = Utf8 countPhonenumberTypes 
.const [185] = Utf8 ([I)V 
.const [186] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [187] = Utf8 logger 
.const [188] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [189] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [192] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [193] = Utf8 privateCount 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [196] = Utf8 businessCount 
.const [197] = Utf8 I 
.const [198] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [199] = Utf8 mobileCount 
.const [200] = Utf8 I 
.const [201] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [202] = Utf8 generalCount 
.const [203] = Utf8 I 
.const [204] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [205] = Utf8 adbHandler 
.const [206] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [207] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [208] = Utf8 entryIDSource 
.const [209] = Utf8 I 
.const [210] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [211] = Utf8 adbService 
.const [212] = Utf8 Lde/audi/atip/interapp/ADBSDSService; 
.const [213] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [214] = Utf8 getADBID 
.const [215] = Utf8 (I)J 
.const [216] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [217] = Utf8 setCurrentEntryID 
.const [218] = Utf8 (J)V 
.const [219] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [220] = Utf8 getPhoneNumberTypes 
.const [221] = Utf8 ()I 
.const [222] = Utf8 de/audi/atip/interapp/ADBSDSService 
.const [223] = Utf8 fillTelNumberList 
.const [224] = Utf8 (JI)V 
.const [225] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [226] = Utf8 updateTelNumberInfo 
.const [227] = Utf8 (IILjava/lang/String;)V 
.const [228] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBNumberByIDOpenCommand 
.const [229] = Class [228] 
.const [230] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [231] = Class [230] 
.const [232] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/IADBNumberCommand 
.const [233] = Class [232] 
.const [234] = Utf8 privateCount 
.const [235] = Utf8 I 
.const [236] = Utf8 businessCount 
.const [237] = Utf8 I 
.const [238] = Utf8 mobileCount 
.const [239] = Utf8 I 
.const [240] = Utf8 generalCount 
.const [241] = Utf8 I 
.const [242] = Utf8 entryIDSource 
.const [243] = Utf8 I 
.const [244] = Utf8 adbService 
.const [245] = Utf8 Lde/audi/atip/interapp/ADBSDSService; 
.const [246] = Utf8 adbHandler 
.const [247] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [248] = Utf8 Code 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler;Lde/audi/atip/interapp/ADBSDSService;)V 
.const [251] = Utf8 execute 
.const [252] = Utf8 ()V 
.const [253] = Utf8 responseFillTelNumberList 
.const [254] = Utf8 (ILjava/lang/String;ILjava/lang/String;[I)V 
.const [255] = Utf8 setChoiceModelValues 
.const [256] = Utf8 ([I)V 
.const [257] = Utf8 countPhonenumberTypes 
.const [258] = Utf8 ([I)V 
.end class 

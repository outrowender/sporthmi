.version 50 0 
.class public final super [249] 
.super [251] 

.method public annotation [253] : [254] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [45] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [255] : [256] 
    .attribute [252] .code stack 4 locals 5 
L0:     ldc [2] 
L2:     astore_1 
L3:     aload_0 
L4:     ifnull L108 
L7:     aload_0 
L8:     invokevirtual [29] 
L11:    invokevirtual [30] 
L14:    astore_2 
L15:    aload_0 
L16:    invokevirtual [31] 
L19:    astore_3 
L20:    aload_2 
L21:    invokestatic [3] 
L24:    ifne L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    istore 4 
L34:    new [48] 
L37:    dup 
L38:    aload_2 
L39:    invokevirtual [32] 
L42:    aload_3 
L43:    invokevirtual [32] 
L46:    iadd 
L47:    iconst_3 
L48:    iadd 
L49:    invokespecial [46] 
L52:    astore 5 
L54:    iload 4 
L56:    ifeq L82 
L59:    aload 5 
L61:    aload_2 
L62:    invokevirtual [33] 
L65:    pop 
L66:    aload 5 
L68:    bipush 32 
L70:    invokevirtual [34] 
L73:    pop 
L74:    aload 5 
L76:    bipush 40 
L78:    invokevirtual [34] 
L81:    pop 
L82:    aload 5 
L84:    aload_3 
L85:    invokevirtual [33] 
L88:    pop 
L89:    iload 4 
L91:    ifeq L102 
L94:    aload 5 
L96:    bipush 41 
L98:    invokevirtual [34] 
L101:   pop 
L102:   aload 5 
L104:   invokevirtual [35] 
L107:   astore_1 
L108:   aload_1 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public static [257] : [258] 
    .attribute [252] .code stack 7 locals 4 
L0:     ldc [5] 
L2:     astore_1 
L3:     ldc [5] 
L5:     astore_2 
L6:     aload_0 
L7:     bipush 40 
L9:     invokevirtual [36] 
L12:    istore_3 
L13:    iconst_m1 
L14:    istore 4 
L16:    iload_3 
L17:    iconst_m1 
L18:    if_icmpeq L32 
L21:    aload_0 
L22:    bipush 41 
L24:    iload_3 
L25:    iconst_1 
L26:    iadd 
L27:    invokevirtual [37] 
L30:    istore 4 
L32:    iload_3 
L33:    iload 4 
L35:    if_icmplt L46 
L38:    aload_0 
L39:    invokevirtual [30] 
L42:    astore_1 
L43:    goto L69 
L46:    aload_0 
L47:    iconst_0 
L48:    iload_3 
L49:    invokevirtual [38] 
L52:    invokevirtual [30] 
L55:    astore_2 
L56:    aload_0 
L57:    iload_3 
L58:    iconst_1 
L59:    iadd 
L60:    iload 4 
L62:    invokevirtual [38] 
L65:    invokevirtual [30] 
L68:    astore_1 
L69:    new [49] 
L72:    dup 
L73:    aload_1 
L74:    aload_2 
L75:    lconst_0 
L76:    aconst_null 
L77:    checkcast [7] 
L80:    invokespecial [47] 
L83:    areturn 
L84:    
    .end code 
.end method 

.method public static [259] : [260] 
    .attribute [252] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     ifnull L24 
L6:     aload_0 
L7:     invokevirtual [39] 
L10:    astore_2 
L11:    aload_2 
L12:    ifnull L24 
L15:    aload_2 
L16:    arraylength 
L17:    ifle L24 
L20:    aload_2 
L21:    iconst_0 
L22:    aaload 
L23:    astore_1 
L24:    aload_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public static [261] : [262] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [8] 
L4:     ifnull L11 
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

.method public static [263] : [264] 
    .attribute [252] .code stack 1 locals 1 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     ifnull L26 
L6:     aload_0 
L7:     invokestatic [9] 
L10:    ifeq L21 
L13:    aload_0 
L14:    invokestatic [10] 
L17:    astore_1 
L18:    goto L26 
L21:    aload_0 
L22:    invokevirtual [40] 
L25:    astore_1 
L26:    aload_1 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public static [265] : [266] 
    .attribute [252] .code stack 1 locals 3 
L0:     ldc [5] 
L2:     astore_1 
L3:     aload_0 
L4:     ifnonnull L9 
L7:     aload_1 
L8:     areturn 
L9:     aload_0 
L10:    invokevirtual [41] 
L13:    astore_2 
L14:    aload_2 
L15:    invokevirtual [29] 
L18:    astore_3 
L19:    aload_3 
L20:    invokestatic [3] 
L23:    ifne L31 
L26:    aload_3 
L27:    astore_1 
L28:    goto L36 
L31:    aload_2 
L32:    invokevirtual [31] 
L35:    astore_1 
L36:    aload_1 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [267] : [268] 
    .attribute [252] .code stack 1 locals 1 
L0:     aload_0 
L1:     invokestatic [11] 
L4:     astore_2 
L5:     aload_2 
L6:     invokestatic [3] 
L9:     ifeq L35 
L12:    aload_0 
L13:    invokestatic [12] 
L16:    ifeq L28 
L19:    aload_1 
L20:    invokeinterface [50] 0 
L25:    goto L34 
L28:    aload_1 
L29:    invokeinterface [51] 0 
L34:    astore_2 
L35:    aload_2 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [269] : [270] 
    .attribute [252] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokeinterface [52] 0 
L6:     anewarray [13] 
L9:     astore_1 
L10:    aload_0 
L11:    invokeinterface [53] 0 
L16:    astore_2 
L17:    iconst_0 
L18:    istore_3 
L19:    iload_3 
L20:    aload_0 
L21:    invokeinterface [52] 0 
L26:    if_icmpge L50 
L29:    aload_1 
L30:    iload_3 
L31:    aload_2 
L32:    invokeinterface [54] 0 
L37:    checkcast [6] 
L40:    invokevirtual [31] 
L43:    aastore 
L44:    iinc 3 1 
L47:    goto L19 
L50:    aload_1 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public static [271] : [272] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [14] 
L4:     invokestatic [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [273] : [274] 
    .attribute [252] .code stack 2 locals 1 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     ifnull L30 
L6:     aload_0 
L7:     invokeinterface [55] 0 
L12:    anewarray [6] 
L15:    astore_1 
L16:    aload_0 
L17:    aload_1 
L18:    invokeinterface [56] 0 
L23:    checkcast [16] 
L26:    checkcast [16] 
L29:    astore_1 
L30:    aload_1 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public static [275] : [276] 
    .attribute [252] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     ifnull L51 
L6:     aload_0 
L7:     invokevirtual [42] 
L10:    ifnull L21 
L13:    iload_1 
L14:    aload_0 
L15:    invokevirtual [42] 
L18:    arraylength 
L19:    iadd 
L20:    istore_1 
L21:    aload_0 
L22:    invokevirtual [43] 
L25:    ifnull L36 
L28:    iload_1 
L29:    aload_0 
L30:    invokevirtual [43] 
L33:    arraylength 
L34:    iadd 
L35:    istore_1 
L36:    aload_0 
L37:    invokevirtual [44] 
L40:    ifnull L51 
L43:    iload_1 
L44:    aload_0 
L45:    invokevirtual [44] 
L48:    arraylength 
L49:    iadd 
L50:    istore_1 
L51:    iload_1 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [57] 
.const [3] = Method [58] [59] 
.const [4] = Class [60] 
.const [5] = String [61] 
.const [6] = Class [62] 
.const [7] = Class [63] 
.const [8] = Method [64] [65] 
.const [9] = Method [66] [67] 
.const [10] = Method [68] [69] 
.const [11] = Method [70] [71] 
.const [12] = Method [72] [73] 
.const [13] = Class [74] 
.const [14] = Method [75] [76] 
.const [15] = Method [77] [78] 
.const [16] = Class [79] 
.const [17] = Class [80] 
.const [18] = Class [81] 
.const [19] = Class [82] 
.const [20] = Class [83] 
.const [21] = Class [84] 
.const [22] = Class [85] 
.const [23] = Class [86] 
.const [24] = Class [87] 
.const [25] = Class [88] 
.const [26] = Class [89] 
.const [27] = Class [90] 
.const [28] = Class [91] 
.const [29] = Method [92] [93] 
.const [30] = Method [94] [95] 
.const [31] = Method [96] [97] 
.const [32] = Method [98] [99] 
.const [33] = Method [100] [101] 
.const [34] = Method [102] [103] 
.const [35] = Method [104] [105] 
.const [36] = Method [106] [107] 
.const [37] = Method [108] [109] 
.const [38] = Method [110] [111] 
.const [39] = Method [112] [113] 
.const [40] = Method [114] [115] 
.const [41] = Method [116] [117] 
.const [42] = Method [118] [119] 
.const [43] = Method [120] [121] 
.const [44] = Method [122] [123] 
.const [45] = Method [124] [125] 
.const [46] = Method [126] [127] 
.const [47] = Method [128] [129] 
.const [48] = Class [130] 
.const [49] = Class [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = InterfaceMethod [136] [137] 
.const [53] = InterfaceMethod [138] [139] 
.const [54] = InterfaceMethod [140] [141] 
.const [55] = InterfaceMethod [142] [143] 
.const [56] = InterfaceMethod [144] [145] 
.const [57] = Utf8 null 
.const [58] = Class [146] 
.const [59] = NameAndType [147] [148] 
.const [60] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [61] = Utf8 '' 
.const [62] = Utf8 org/dsi/ifc/messaging/MatchedAddress 
.const [63] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [64] = Class [149] 
.const [65] = NameAndType [150] [151] 
.const [66] = Class [152] 
.const [67] = NameAndType [153] [154] 
.const [68] = Class [155] 
.const [69] = NameAndType [156] [157] 
.const [70] = Class [158] 
.const [71] = NameAndType [159] [160] 
.const [72] = Class [161] 
.const [73] = NameAndType [162] [163] 
.const [74] = Utf8 java/lang/String 
.const [75] = Class [164] 
.const [76] = NameAndType [165] [166] 
.const [77] = Class [167] 
.const [78] = NameAndType [168] [169] 
.const [79] = Utf8 [Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [80] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [83] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [84] = Utf8 de/audi/app/messaging/core/util/Messages 
.const [85] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [86] = Utf8 de/audi/app/messaging/core/guide/ITextLookup 
.const [87] = Utf8 java/util/List 
.const [88] = Utf8 java/util/Iterator 
.const [89] = Utf8 java/util/Arrays 
.const [90] = Utf8 java/util/Collection 
.const [91] = Utf8 org/dsi/ifc/messaging/RecipientList 
.const [92] = Class [170] 
.const [93] = NameAndType [171] [172] 
.const [94] = Class [173] 
.const [95] = NameAndType [174] [175] 
.const [96] = Class [176] 
.const [97] = NameAndType [177] [178] 
.const [98] = Class [179] 
.const [99] = NameAndType [180] [181] 
.const [100] = Class [182] 
.const [101] = NameAndType [183] [184] 
.const [102] = Class [185] 
.const [103] = NameAndType [186] [187] 
.const [104] = Class [188] 
.const [105] = NameAndType [189] [190] 
.const [106] = Class [191] 
.const [107] = NameAndType [192] [193] 
.const [108] = Class [194] 
.const [109] = NameAndType [195] [196] 
.const [110] = Class [197] 
.const [111] = NameAndType [198] [199] 
.const [112] = Class [200] 
.const [113] = NameAndType [201] [202] 
.const [114] = Class [203] 
.const [115] = NameAndType [204] [205] 
.const [116] = Class [206] 
.const [117] = NameAndType [207] [208] 
.const [118] = Class [209] 
.const [119] = NameAndType [210] [211] 
.const [120] = Class [212] 
.const [121] = NameAndType [213] [214] 
.const [122] = Class [215] 
.const [123] = NameAndType [216] [217] 
.const [124] = Class [218] 
.const [125] = NameAndType [219] [220] 
.const [126] = Class [221] 
.const [127] = NameAndType [222] [223] 
.const [128] = Class [224] 
.const [129] = NameAndType [225] [226] 
.const [130] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [131] = Utf8 org/dsi/ifc/messaging/MatchedAddress 
.const [132] = Class [227] 
.const [133] = NameAndType [228] [229] 
.const [134] = Class [230] 
.const [135] = NameAndType [231] [232] 
.const [136] = Class [233] 
.const [137] = NameAndType [234] [235] 
.const [138] = Class [236] 
.const [139] = NameAndType [237] [238] 
.const [140] = Class [239] 
.const [141] = NameAndType [240] [241] 
.const [142] = Class [242] 
.const [143] = NameAndType [243] [244] 
.const [144] = Class [245] 
.const [145] = NameAndType [246] [247] 
.const [146] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [147] = Utf8 isNullOrEmpty 
.const [148] = Utf8 (Ljava/lang/String;)Z 
.const [149] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [150] = Utf8 getPrimaryContact 
.const [151] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [152] = Utf8 de/audi/app/messaging/core/util/Messages 
.const [153] = Utf8 isOutbound 
.const [154] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Z 
.const [155] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [156] = Utf8 getFirstRecipient 
.const [157] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [158] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [159] = Utf8 getPrimaryContactText 
.const [160] = Utf8 (Lorg/dsi/ifc/messaging/MessageListEntry;)Ljava/lang/String; 
.const [161] = Utf8 de/audi/app/messaging/core/util/Messages 
.const [162] = Utf8 isOutbound 
.const [163] = Utf8 (Lorg/dsi/ifc/messaging/MessageListEntry;)Z 
.const [164] = Utf8 java/util/Arrays 
.const [165] = Utf8 asList 
.const [166] = Utf8 ([Ljava/lang/Object;)Ljava/util/List; 
.const [167] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [168] = Utf8 getRawAddresses 
.const [169] = Utf8 (Ljava/util/List;)[Ljava/lang/String; 
.const [170] = Utf8 org/dsi/ifc/messaging/MatchedAddress 
.const [171] = Utf8 getName 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 java/lang/String 
.const [174] = Utf8 trim 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 org/dsi/ifc/messaging/MatchedAddress 
.const [177] = Utf8 getAddress 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 java/lang/String 
.const [180] = Utf8 length 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [183] = Utf8 append 
.const [184] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [185] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [186] = Utf8 append 
.const [187] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 toString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 java/lang/String 
.const [192] = Utf8 indexOf 
.const [193] = Utf8 (I)I 
.const [194] = Utf8 java/lang/String 
.const [195] = Utf8 indexOf 
.const [196] = Utf8 (II)I 
.const [197] = Utf8 java/lang/String 
.const [198] = Utf8 substring 
.const [199] = Utf8 (II)Ljava/lang/String; 
.const [200] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [201] = Utf8 getRecipientsTo 
.const [202] = Utf8 ()[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [203] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [204] = Utf8 getSender 
.const [205] = Utf8 ()Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [206] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [207] = Utf8 getMatchedAddress 
.const [208] = Utf8 ()Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [209] = Utf8 org/dsi/ifc/messaging/RecipientList 
.const [210] = Utf8 getTo 
.const [211] = Utf8 ()[Ljava/lang/String; 
.const [212] = Utf8 org/dsi/ifc/messaging/RecipientList 
.const [213] = Utf8 getCc 
.const [214] = Utf8 ()[Ljava/lang/String; 
.const [215] = Utf8 org/dsi/ifc/messaging/RecipientList 
.const [216] = Utf8 getBcc 
.const [217] = Utf8 ()[Ljava/lang/String; 
.const [218] = Utf8 java/lang/Object 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (I)V 
.const [224] = Utf8 org/dsi/ifc/messaging/MatchedAddress 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Ljava/lang/String;Ljava/lang/String;JLorg/dsi/ifc/global/ResourceLocator;)V 
.const [227] = Utf8 de/audi/app/messaging/core/guide/ITextLookup 
.const [228] = Utf8 getRecipientNone 
.const [229] = Utf8 ()Ljava/lang/String; 
.const [230] = Utf8 de/audi/app/messaging/core/guide/ITextLookup 
.const [231] = Utf8 getSenderNone 
.const [232] = Utf8 ()Ljava/lang/String; 
.const [233] = Utf8 java/util/List 
.const [234] = Utf8 size 
.const [235] = Utf8 ()I 
.const [236] = Utf8 java/util/List 
.const [237] = Utf8 iterator 
.const [238] = Utf8 ()Ljava/util/Iterator; 
.const [239] = Utf8 java/util/Iterator 
.const [240] = Utf8 next 
.const [241] = Utf8 ()Ljava/lang/Object; 
.const [242] = Utf8 java/util/Collection 
.const [243] = Utf8 size 
.const [244] = Utf8 ()I 
.const [245] = Utf8 java/util/Collection 
.const [246] = Utf8 toArray 
.const [247] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [248] = Utf8 de/audi/app/messaging/core/util/MessageContacts 
.const [249] = Class [248] 
.const [250] = Utf8 java/lang/Object 
.const [251] = Class [250] 
.const [252] = Utf8 Code 
.const [253] = Utf8 <init> 
.const [254] = Utf8 ()V 
.const [255] = Utf8 toString 
.const [256] = Utf8 (Lorg/dsi/ifc/messaging/MatchedAddress;)Ljava/lang/String; 
.const [257] = Utf8 toMatchedAddress 
.const [258] = Utf8 (Ljava/lang/String;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [259] = Utf8 getFirstRecipient 
.const [260] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [261] = Utf8 hasPrimaryContact 
.const [262] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Z 
.const [263] = Utf8 getPrimaryContact 
.const [264] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;)Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [265] = Utf8 getPrimaryContactText 
.const [266] = Utf8 (Lorg/dsi/ifc/messaging/MessageListEntry;)Ljava/lang/String; 
.const [267] = Utf8 getPrimaryContactInfo 
.const [268] = Utf8 (Lorg/dsi/ifc/messaging/MessageListEntry;Lde/audi/app/messaging/core/guide/ITextLookup;)Ljava/lang/String; 
.const [269] = Utf8 getRawAddresses 
.const [270] = Utf8 (Ljava/util/List;)[Ljava/lang/String; 
.const [271] = Utf8 getRawAddresses 
.const [272] = Utf8 ([Lorg/dsi/ifc/messaging/MatchedAddress;)[Ljava/lang/String; 
.const [273] = Utf8 toArray 
.const [274] = Utf8 (Ljava/util/Collection;)[Lorg/dsi/ifc/messaging/MatchedAddress; 
.const [275] = Utf8 getRecipientCount 
.const [276] = Utf8 (Lorg/dsi/ifc/messaging/RecipientList;)I 
.end class 

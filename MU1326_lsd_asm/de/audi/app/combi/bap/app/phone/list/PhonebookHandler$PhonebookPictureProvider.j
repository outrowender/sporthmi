.version 50 0 
.class super [206] 
.super [208] 
.implements [210] 
.implements [212] 
.field private final [213] [214] 
.field private final synthetic [215] [216] 

.method private [218] : [219] 
    .attribute [217] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [40] 
L5:     aload_0 
L6:     invokespecial [35] 
L9:     aload_0 
L10:    new [41] 
L13:    dup 
L14:    invokespecial [36] 
L17:    putfield [42] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [217] .code stack 6 locals 2 
L0:     new [43] 
L3:     dup 
L4:     lload_1 
L5:     invokespecial [37] 
L8:     astore 4 
L10:    aload_0 
L11:    getfield [25] 
L14:    aload 4 
L16:    invokeinterface [44] 0 
L21:    ifeq L62 
L24:    aload_0 
L25:    getfield [25] 
L28:    aload 4 
L30:    invokeinterface [45] 0 
L35:    checkcast [4] 
L38:    astore_3 
L39:    aload_3 
L40:    ifnonnull L80 
L43:    aload_0 
L44:    getfield [24] 
L47:    invokestatic [5] 
L50:    ldc [6] 
L52:    ldc [7] 
L54:    lload_1 
L55:    invokevirtual [26] 
L58:    pop 
L59:    goto L80 
L62:    aconst_null 
L63:    astore_3 
L64:    aload_0 
L65:    getfield [24] 
L68:    invokestatic [8] 
L71:    ldc [6] 
L73:    ldc [9] 
L75:    lload_1 
L76:    invokevirtual [26] 
L79:    pop 
L80:    aload_0 
L81:    getfield [24] 
L84:    invokestatic [10] 
L87:    checkcast [11] 
L90:    invokevirtual [27] 
L93:    lload_1 
L94:    aload_3 
L95:    ifnonnull L108 
L98:    new [46] 
L101:   dup 
L102:   invokespecial [38] 
L105:   goto L116 
L108:   new [46] 
L111:   dup 
L112:   aload_3 
L113:   invokespecial [39] 
L116:   invokeinterface [47] 0 
L121:   return 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [217] .code stack 3 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokevirtual [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [224] : [225] 
    .attribute [217] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [217] .code stack 2 locals 1 
L0:     iload_1 
L1:     bipush 51 
L3:     if_icmpne L40 
L6:     aload_0 
L7:     getfield [24] 
L10:    invokestatic [13] 
L13:    iload_1 
L14:    invokevirtual [29] 
L17:    invokevirtual [30] 
L20:    checkcast [14] 
L23:    astore_2 
L24:    aload_2 
L25:    getfield [31] 
L28:    ifne L40 
L31:    aload_0 
L32:    getfield [25] 
L35:    invokeinterface [48] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public enum [228] : [229] 
    .attribute [217] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [217] .code stack 5 locals 2 
L0:     aload_1 
L1:     arraylength 
L2:     istore_2 
L3:     iconst_0 
L4:     istore_3 
L5:     iload_3 
L6:     iload_2 
L7:     if_icmpge L46 
L10:    aload_0 
L11:    getfield [25] 
L14:    new [43] 
L17:    dup 
L18:    aload_1 
L19:    iload_3 
L20:    aaload 
L21:    invokevirtual [32] 
L24:    i2l 
L25:    invokespecial [37] 
L28:    aload_1 
L29:    iload_3 
L30:    aaload 
L31:    invokevirtual [33] 
L34:    invokeinterface [49] 0 
L39:    pop 
L40:    iinc 3 1 
L43:    goto L5 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method synthetic [232] : [233] 
    .attribute [217] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [34] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = Class [51] 
.const [4] = Class [52] 
.const [5] = Method [53] [54] 
.const [6] = Int -1601830656 
.const [7] = String [55] 
.const [8] = Method [56] [57] 
.const [9] = String [58] 
.const [10] = Method [59] [60] 
.const [11] = Class [61] 
.const [12] = Class [62] 
.const [13] = Method [63] [64] 
.const [14] = Class [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Field [75] [76] 
.const [25] = Field [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Field [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Field [107] [108] 
.const [41] = Class [109] 
.const [42] = Field [110] [111] 
.const [43] = Class [112] 
.const [44] = InterfaceMethod [113] [114] 
.const [45] = InterfaceMethod [115] [116] 
.const [46] = Class [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = InterfaceMethod [120] [121] 
.const [49] = InterfaceMethod [122] [123] 
.const [50] = Utf8 java/util/HashMap 
.const [51] = Utf8 java/lang/Long 
.const [52] = Utf8 java/lang/String 
.const [53] = Class [124] 
.const [54] = NameAndType [125] [126] 
.const [55] = Utf8 '[PhonebookHandler.PhonebookPictureProvider#requestPicture] no pictureURL available for entryID=%1' 
.const [56] = Class [127] 
.const [57] = NameAndType [128] [129] 
.const [58] = Utf8 '[PhonebookHandler.PhonebookPictureProvider#requestPicture] entry with ID=%1 unknown' 
.const [59] = Class [130] 
.const [60] = NameAndType [131] [132] 
.const [61] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [62] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [63] = Class [133] 
.const [64] = NameAndType [134] [135] 
.const [65] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [66] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 java/util/Map 
.const [69] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [72] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [73] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [74] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Utf8 java/util/HashMap 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Utf8 java/lang/Long 
.const [113] = Class [190] 
.const [114] = NameAndType [191] [192] 
.const [115] = Class [193] 
.const [116] = NameAndType [194] [195] 
.const [117] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [118] = Class [196] 
.const [119] = NameAndType [197] [198] 
.const [120] = Class [199] 
.const [121] = NameAndType [200] [201] 
.const [122] = Class [202] 
.const [123] = NameAndType [203] [204] 
.const [124] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [125] = Utf8 access$000 
.const [126] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/atip/log/LogChannel; 
.const [127] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [128] = Utf8 access$100 
.const [129] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/atip/log/LogChannel; 
.const [130] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [131] = Utf8 access$200 
.const [132] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [133] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [134] = Utf8 access$300 
.const [135] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [136] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [137] = Utf8 this$0 
.const [138] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler; 
.const [139] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [140] = Utf8 id2pictureURL 
.const [141] = Utf8 Ljava/util/Map; 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;J)Z 
.const [145] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [146] = Utf8 getPictureManager 
.const [147] = Utf8 ()Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [148] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [149] = Utf8 requestPicture 
.const [150] = Utf8 (J)V 
.const [151] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [152] = Utf8 getBAPFunctionPropertyFSG 
.const [153] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [154] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [155] = Utf8 getLastStatus 
.const [156] = Utf8 ()Lde/vw/mib/bap/requests/StatusProperty; 
.const [157] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [158] = Utf8 downloadState 
.const [159] = Utf8 I 
.const [160] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [161] = Utf8 getPosID 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry 
.const [164] = Utf8 getPictureURL 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)V 
.const [169] = Utf8 java/lang/Object 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 java/util/HashMap 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 java/lang/Long 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (J)V 
.const [178] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Ljava/lang/String;)V 
.const [184] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [185] = Utf8 this$0 
.const [186] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler; 
.const [187] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [188] = Utf8 id2pictureURL 
.const [189] = Utf8 Ljava/util/Map; 
.const [190] = Utf8 java/util/Map 
.const [191] = Utf8 containsKey 
.const [192] = Utf8 (Ljava/lang/Object;)Z 
.const [193] = Utf8 java/util/Map 
.const [194] = Utf8 get 
.const [195] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [196] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [197] = Utf8 responseAdbContactPicture 
.const [198] = Utf8 (JLorg/dsi/ifc/global/ResourceLocator;)V 
.const [199] = Utf8 java/util/Map 
.const [200] = Utf8 clear 
.const [201] = Utf8 ()V 
.const [202] = Utf8 java/util/Map 
.const [203] = Utf8 put 
.const [204] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [205] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler$PhonebookPictureProvider 
.const [206] = Class [205] 
.const [207] = Utf8 java/lang/Object 
.const [208] = Class [207] 
.const [209] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureProvider 
.const [210] = Class [209] 
.const [211] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionDataListener 
.const [212] = Class [211] 
.const [213] = Utf8 id2pictureURL 
.const [214] = Utf8 Ljava/util/Map; 
.const [215] = Utf8 this$0 
.const [216] = Utf8 Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler; 
.const [217] = Utf8 Code 
.const [218] = Utf8 <init> 
.const [219] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;)V 
.const [220] = Utf8 requestPicture 
.const [221] = Utf8 (J)V 
.const [222] = Utf8 requestPicture 
.const [223] = Utf8 (JI)V 
.const [224] = Utf8 notifyDataValidChanged 
.const [225] = Utf8 (IZ)V 
.const [226] = Utf8 notifyDataChanged 
.const [227] = Utf8 (I)V 
.const [228] = Utf8 notifyDataUpdatedNoChange 
.const [229] = Utf8 (I)V 
.const [230] = Utf8 addToMapping 
.const [231] = Utf8 ([Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry;)V 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler;Lde/audi/app/combi/bap/app/phone/list/PhonebookHandler$1;)V 
.end class 

.version 50 0 
.class public super [140] 
.super [142] 
.field public static final [143] [144] 
.field public static final [145] [146] 
.field public static final [147] [148] 
.field public static final [149] [150] 
.field public static final [151] [152] 
.field public static final [153] [154] 
.field public static final [155] [156] 
.field private [157] [158] 
.field private [159] [160] 

.method public [162] : [163] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [34] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [33] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [34] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     iand 
L6:     ifeq L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_4 
L2:     invokevirtual [20] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [172] : [173] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 16 
L3:     invokevirtual [20] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_2 
L2:     invokevirtual [20] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [20] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     sipush 256 
L4:     invokevirtual [20] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokevirtual [20] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [182] : [183] 
    .attribute [161] .code stack 2 locals 1 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [31] 
L7:     astore_1 
L8:     aload_0 
L9:     iconst_1 
L10:    invokevirtual [20] 
L13:    ifeq L23 
L16:    aload_1 
L17:    ldc [4] 
L19:    invokevirtual [21] 
L22:    pop 
L23:    aload_0 
L24:    iconst_2 
L25:    invokevirtual [20] 
L28:    ifeq L52 
L31:    aload_1 
L32:    invokevirtual [22] 
L35:    ifeq L45 
L38:    aload_1 
L39:    ldc [5] 
L41:    invokevirtual [21] 
L44:    pop 
L45:    aload_1 
L46:    ldc [6] 
L48:    invokevirtual [21] 
L51:    pop 
L52:    aload_0 
L53:    iconst_4 
L54:    invokevirtual [20] 
L57:    ifeq L81 
L60:    aload_1 
L61:    invokevirtual [22] 
L64:    ifeq L74 
L67:    aload_1 
L68:    ldc [5] 
L70:    invokevirtual [21] 
L73:    pop 
L74:    aload_1 
L75:    ldc [7] 
L77:    invokevirtual [21] 
L80:    pop 
L81:    aload_0 
L82:    bipush 16 
L84:    invokevirtual [20] 
L87:    ifeq L111 
L90:    aload_1 
L91:    invokevirtual [22] 
L94:    ifeq L104 
L97:    aload_1 
L98:    ldc [5] 
L100:   invokevirtual [21] 
L103:   pop 
L104:   aload_1 
L105:   ldc [8] 
L107:   invokevirtual [21] 
L110:   pop 
L111:   aload_0 
L112:   ldc [2] 
L114:   invokevirtual [20] 
L117:   ifeq L141 
L120:   aload_1 
L121:   invokevirtual [22] 
L124:   ifeq L134 
L127:   aload_1 
L128:   ldc [5] 
L130:   invokevirtual [21] 
L133:   pop 
L134:   aload_1 
L135:   ldc [9] 
L137:   invokevirtual [21] 
L140:   pop 
L141:   aload_0 
L142:   sipush 256 
L145:   invokevirtual [20] 
L148:   ifeq L172 
L151:   aload_1 
L152:   invokevirtual [22] 
L155:   ifeq L165 
L158:   aload_1 
L159:   ldc [5] 
L161:   invokevirtual [21] 
L164:   pop 
L165:   aload_1 
L166:   ldc [10] 
L168:   invokevirtual [21] 
L171:   pop 
L172:   aload_1 
L173:   invokevirtual [23] 
L176:   areturn 
L177:   nop 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [161] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [32] 
L7:     ldc [12] 
L9:     invokevirtual [24] 
L12:    aload_0 
L13:    invokevirtual [25] 
L16:    invokevirtual [24] 
L19:    ldc [13] 
L21:    invokevirtual [24] 
L24:    aload_0 
L25:    invokevirtual [26] 
L28:    invokevirtual [27] 
L31:    ldc [14] 
L33:    invokevirtual [24] 
L36:    aload_0 
L37:    getfield [19] 
L40:    invokevirtual [28] 
L43:    ldc [15] 
L45:    invokevirtual [24] 
L48:    invokevirtual [29] 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_1 
L1:     getfield [18] 
L4:     aload_0 
L5:     getfield [18] 
L8:     if_icmpne L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [161] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [20] 
L5:     aload_1 
L6:     iconst_1 
L7:     invokevirtual [20] 
L10:    if_icmpne L43 
L13:    aload_0 
L14:    iconst_2 
L15:    invokevirtual [20] 
L18:    aload_1 
L19:    iconst_2 
L20:    invokevirtual [20] 
L23:    if_icmpne L43 
L26:    aload_0 
L27:    iconst_4 
L28:    invokevirtual [20] 
L31:    aload_1 
L32:    iconst_4 
L33:    invokevirtual [20] 
L36:    if_icmpne L43 
L39:    iconst_1 
L40:    goto L44 
L43:    iconst_0 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 256 
.const [3] = Class [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = String [44] 
.const [11] = Class [45] 
.const [12] = String [46] 
.const [13] = String [47] 
.const [14] = String [48] 
.const [15] = String [49] 
.const [16] = Class [50] 
.const [17] = Class [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Method [78] [79] 
.const [32] = Method [80] [81] 
.const [33] = Field [82] [83] 
.const [34] = Field [84] [85] 
.const [35] = Class [86] 
.const [36] = Class [87] 
.const [37] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [38] = Utf8 CONNECTIVITY 
.const [39] = Utf8 ', ' 
.const [40] = Utf8 SL_OFFLINE 
.const [41] = Utf8 SL_ONLINE 
.const [42] = Utf8 SL_PENDING 
.const [43] = Utf8 OWNERVERIFICATION_AVAILABLE 
.const [44] = Utf8 OWNERVERIFICATION_OK 
.const [45] = Utf8 java/lang/StringBuffer 
.const [46] = Utf8 'OnlineServiceListState [serviceState=' 
.const [47] = Utf8 ', isValid=' 
.const [48] = Utf8 '( ' 
.const [49] = Utf8 ' )]' 
.const [50] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [51] = Utf8 java/lang/Object 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Class [124] 
.const [77] = NameAndType [125] [126] 
.const [78] = Class [127] 
.const [79] = NameAndType [128] [129] 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Class [133] 
.const [83] = NameAndType [134] [135] 
.const [84] = Class [136] 
.const [85] = NameAndType [137] [138] 
.const [86] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [87] = Utf8 java/lang/StringBuffer 
.const [88] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [89] = Utf8 serviceState 
.const [90] = Utf8 I 
.const [91] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [92] = Utf8 validFlag 
.const [93] = Utf8 I 
.const [94] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [95] = Utf8 checkServiceStateBit 
.const [96] = Utf8 (I)Z 
.const [97] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [100] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [101] = Utf8 length 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [104] = Utf8 toString 
.const [105] = Utf8 ()Ljava/lang/String; 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 append 
.const [108] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [109] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [110] = Utf8 getCurrentServiceStateAsText 
.const [111] = Utf8 ()Ljava/lang/String; 
.const [112] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [113] = Utf8 isValid 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 toString 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [134] = Utf8 serviceState 
.const [135] = Utf8 I 
.const [136] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [137] = Utf8 validFlag 
.const [138] = Utf8 I 
.const [139] = Utf8 de/audi/atip/interapp/online/OnlineServiceListState 
.const [140] = Class [139] 
.const [141] = Utf8 java/lang/Object 
.const [142] = Class [141] 
.const [143] = Utf8 BIT_MASK_SERVICELIST_PENDING 
.const [144] = Utf8 I 
.const [145] = Utf8 BIT_MASK_CONNECTIVITY_AVAILABLE 
.const [146] = Utf8 I 
.const [147] = Utf8 BIT_MASK_SERVICELIST_ONLINE 
.const [148] = Utf8 I 
.const [149] = Utf8 BIT_MASK_SERVICELIST_OFFLINE 
.const [150] = Utf8 I 
.const [151] = Utf8 BIT_MASK_OWNERVERIFICATION_OK 
.const [152] = Utf8 I 
.const [153] = Utf8 BIT_MASK_OWNERVERIFICATION_AVAILABLE 
.const [154] = Utf8 I 
.const [155] = Utf8 EMPTY_SERVICE_STATE 
.const [156] = Utf8 I 
.const [157] = Utf8 serviceState 
.const [158] = Utf8 I 
.const [159] = Utf8 validFlag 
.const [160] = Utf8 I 
.const [161] = Utf8 Code 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (II)V 
.const [164] = Utf8 setValues 
.const [165] = Utf8 (II)V 
.const [166] = Utf8 checkServiceStateBit 
.const [167] = Utf8 (I)Z 
.const [168] = Utf8 isValid 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 isOnline 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 isPending 
.const [173] = Utf8 ()Z 
.const [174] = Utf8 isOffline 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 isConnectivityAvailable 
.const [177] = Utf8 ()Z 
.const [178] = Utf8 isOwnerVerificationOK 
.const [179] = Utf8 ()Z 
.const [180] = Utf8 isOwnerVerificationAvailable 
.const [181] = Utf8 ()Z 
.const [182] = Utf8 getCurrentServiceStateAsText 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 toString 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 equals 
.const [187] = Utf8 (Lde/audi/atip/interapp/online/OnlineServiceListState;)Z 
.const [188] = Utf8 equalsIgnorePending 
.const [189] = Utf8 (Lde/audi/atip/interapp/online/OnlineServiceListState;)Z 
.end class 

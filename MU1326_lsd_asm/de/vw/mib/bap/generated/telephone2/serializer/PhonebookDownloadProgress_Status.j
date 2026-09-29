.version 50 0 
.class public final super [167] 
.super [169] 
.implements [171] 
.field public [172] [173] 
.field private static final [174] [175] 
.field public static final [176] [177] 
.field public static final [178] [179] 
.field public static final [180] [181] 
.field public static final [182] [183] 
.field public static final [184] [185] 
.field public [186] [187] 
.field private static final [188] [189] 
.field public [190] [191] 
.field private static final [192] [193] 
.field public [194] [195] 
.field private static final [196] [197] 

.method public [199] : [200] 
    .attribute [198] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     invokespecial [27] 
L8:     aload_0 
L9:     invokespecial [28] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [198] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [203] : [204] 
    .attribute [198] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [31] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [32] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [33] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [34] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [198] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [198] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [19] 
L9:     aload_2 
L10:    getfield [19] 
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [20] 
L20:    aload_2 
L21:    getfield [20] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [21] 
L31:    aload_2 
L32:    getfield [21] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [22] 
L42:    aload_2 
L43:    getfield [22] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private enum [209] : [210] 
    .attribute [198] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [198] .code stack 2 locals 1 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [30] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [23] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [23] 
L21:    pop 
L22:    aload_0 
L23:    getfield [19] 
L26:    tableswitch 0 
            L60 
            L70 
            L80 
            L90 
            L100 
            default : L110 

L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [23] 
L66:    pop 
L67:    goto L117 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [23] 
L76:    pop 
L77:    goto L117 
L80:    aload_1 
L81:    ldc [8] 
L83:    invokevirtual [23] 
L86:    pop 
L87:    goto L117 
L90:    aload_1 
L91:    ldc [9] 
L93:    invokevirtual [23] 
L96:    pop 
L97:    goto L117 
L100:   aload_1 
L101:   ldc [10] 
L103:   invokevirtual [23] 
L106:   pop 
L107:   goto L117 
L110:   aload_1 
L111:   ldc [11] 
L113:   invokevirtual [23] 
L116:   pop 
L117:   aload_1 
L118:   ldc [12] 
L120:   invokevirtual [23] 
L123:   pop 
L124:   aload_1 
L125:   aload_0 
L126:   getfield [20] 
L129:   invokevirtual [24] 
L132:   pop 
L133:   aload_1 
L134:   ldc [13] 
L136:   invokevirtual [23] 
L139:   pop 
L140:   aload_1 
L141:   aload_0 
L142:   getfield [21] 
L145:   invokevirtual [24] 
L148:   pop 
L149:   aload_1 
L150:   ldc [14] 
L152:   invokevirtual [23] 
L155:   pop 
L156:   aload_1 
L157:   aload_0 
L158:   getfield [22] 
L161:   invokevirtual [24] 
L164:   pop 
L165:   aload_1 
L166:   invokevirtual [25] 
L169:   areturn 
L170:   nop 
L171:   nop 
L172:   
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [198] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iinc 1 16 
L11:    iinc 1 16 
L14:    iload_1 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [198] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [19] 
L5:     i2b 
L6:     invokeinterface [36] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [20] 
L16:    i2b 
L17:    invokeinterface [36] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [21] 
L27:    i2s 
L28:    invokeinterface [37] 0 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [22] 
L38:    i2s 
L39:    invokeinterface [37] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [198] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [38] 0 
L7:     putfield [31] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [38] 0 
L17:    putfield [32] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [39] 0 
L27:    putfield [33] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [39] 0 
L37:    putfield [34] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [219] : [220] 
    .attribute [198] .code stack 1 locals 0 
L0:     bipush 26 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [198] .code stack 1 locals 0 
L0:     invokestatic [15] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = Class [41] 
.const [4] = String [42] 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = String [45] 
.const [8] = String [46] 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = String [49] 
.const [12] = String [50] 
.const [13] = String [51] 
.const [14] = String [52] 
.const [15] = Method [53] [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Method [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Field [61] [62] 
.const [21] = Field [63] [64] 
.const [22] = Field [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Field [87] [88] 
.const [34] = Field [89] [90] 
.const [35] = Class [91] 
.const [36] = InterfaceMethod [92] [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = InterfaceMethod [96] [97] 
.const [39] = InterfaceMethod [98] [99] 
.const [40] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Utf8 'PhonebookDownloadProgress_Status:' 
.const [43] = Utf8 '\n - DownloadState: ' 
.const [44] = Utf8 '0x00 (no phone book available)' 
.const [45] = Utf8 '0x01 (currently being loaded)' 
.const [46] = Utf8 '0x02 (completely loaded (from mobile to FSG))' 
.const [47] = Utf8 '0x03 (incompletely loaded (from mobile to FSG), downloaded entries available)' 
.const [48] = Utf8 '0x04 (download aborted (last known phone book will be used, if available), only temporary indication (will be reset by FSG after 1000ms))' 
.const [49] = Utf8 'UNKNOWN ENUM' 
.const [50] = Utf8 '\n - ProgressPhonebookDownload - ' 
.const [51] = Utf8 '\n - TotalPbEntries - ' 
.const [52] = Utf8 '\n - CurrentlyLoadedPbEntries - ' 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Class [133] 
.const [78] = NameAndType [134] [135] 
.const [79] = Class [136] 
.const [80] = NameAndType [137] [138] 
.const [81] = Class [139] 
.const [82] = NameAndType [140] [141] 
.const [83] = Class [142] 
.const [84] = NameAndType [143] [144] 
.const [85] = Class [145] 
.const [86] = NameAndType [146] [147] 
.const [87] = Class [148] 
.const [88] = NameAndType [149] [150] 
.const [89] = Class [151] 
.const [90] = NameAndType [152] [153] 
.const [91] = Utf8 java/lang/StringBuffer 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Class [160] 
.const [97] = NameAndType [161] [162] 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [101] = Utf8 functionId 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [104] = Utf8 deserialize 
.const [105] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [106] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [107] = Utf8 downloadState 
.const [108] = Utf8 I 
.const [109] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [110] = Utf8 progressPhonebookDownload 
.const [111] = Utf8 I 
.const [112] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [113] = Utf8 totalPbEntries 
.const [114] = Utf8 I 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [116] = Utf8 currentlyLoadedPbEntries 
.const [117] = Utf8 I 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 java/lang/Object 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [131] = Utf8 internalReset 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [134] = Utf8 customInitialization 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ()V 
.const [139] = Utf8 java/lang/StringBuffer 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [143] = Utf8 downloadState 
.const [144] = Utf8 I 
.const [145] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [146] = Utf8 progressPhonebookDownload 
.const [147] = Utf8 I 
.const [148] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [149] = Utf8 totalPbEntries 
.const [150] = Utf8 I 
.const [151] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [152] = Utf8 currentlyLoadedPbEntries 
.const [153] = Utf8 I 
.const [154] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [155] = Utf8 pushByte 
.const [156] = Utf8 (B)V 
.const [157] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [158] = Utf8 pushShort 
.const [159] = Utf8 (S)V 
.const [160] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [161] = Utf8 popFrontByte 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [164] = Utf8 popFrontShort 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [167] = Class [166] 
.const [168] = Utf8 java/lang/Object 
.const [169] = Class [168] 
.const [170] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [171] = Class [170] 
.const [172] = Utf8 downloadState 
.const [173] = Utf8 I 
.const [174] = Utf8 DOWNLOAD_STATE_BITSIZE 
.const [175] = Utf8 I 
.const [176] = Utf8 DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE 
.const [177] = Utf8 I 
.const [178] = Utf8 DOWNLOAD_STATE_CURRENTLY_BEING_LOADED 
.const [179] = Utf8 I 
.const [180] = Utf8 DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_FSG 
.const [181] = Utf8 I 
.const [182] = Utf8 DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE 
.const [183] = Utf8 I 
.const [184] = Utf8 DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION 
.const [185] = Utf8 I 
.const [186] = Utf8 progressPhonebookDownload 
.const [187] = Utf8 I 
.const [188] = Utf8 PROGRESS_PHONEBOOK_DOWNLOAD_BITSIZE 
.const [189] = Utf8 I 
.const [190] = Utf8 totalPbEntries 
.const [191] = Utf8 I 
.const [192] = Utf8 TOTAL_PB_ENTRIES_BITSIZE 
.const [193] = Utf8 I 
.const [194] = Utf8 currentlyLoadedPbEntries 
.const [195] = Utf8 I 
.const [196] = Utf8 CURRENTLY_LOADED_PB_ENTRIES_BITSIZE 
.const [197] = Utf8 I 
.const [198] = Utf8 Code 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [203] = Utf8 internalReset 
.const [204] = Utf8 ()V 
.const [205] = Utf8 reset 
.const [206] = Utf8 ()V 
.const [207] = Utf8 equalTo 
.const [208] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [209] = Utf8 customInitialization 
.const [210] = Utf8 ()V 
.const [211] = Utf8 toString 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 bitSize 
.const [214] = Utf8 ()I 
.const [215] = Utf8 serialize 
.const [216] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [217] = Utf8 deserialize 
.const [218] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [219] = Utf8 functionId 
.const [220] = Utf8 ()I 
.const [221] = Utf8 getFunctionId 
.const [222] = Utf8 ()I 
.end class 

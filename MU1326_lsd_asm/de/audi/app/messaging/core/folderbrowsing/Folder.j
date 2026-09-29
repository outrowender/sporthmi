.version 50 0 
.class public final super [191] 
.super [193] 
.field public static final [194] [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 
.field public static final [200] [201] 
.field public static final [202] [203] 
.field public static final [204] [205] 
.field public static final [206] [207] 
.field public static final [208] [209] 
.field public static final [210] [211] 
.field public static final [212] [213] 
.field private final [214] [215] 
.field private final [216] [217] 
.field private final [218] [219] 
.field private final [220] [221] 
.field private final [222] [223] 

.method private [225] : [226] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [35] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [36] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [37] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [38] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [39] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [224] .code stack 6 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     aload_1 
L3:     iload_2 
L4:     iload_3 
L5:     iload 4 
L7:     invokespecial [32] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [229] : [230] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [231] : [232] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [233] : [234] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [235] : [236] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [237] : [238] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [224] .code stack 2 locals 1 
L0:     new [40] 
L3:     dup 
L4:     invokespecial [33] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [3] 
L11:    invokevirtual [19] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [14] 
L20:    invokevirtual [20] 
L23:    pop 
L24:    aload_1 
L25:    ldc [4] 
L27:    invokevirtual [19] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [15] 
L36:    invokevirtual [21] 
L39:    pop 
L40:    aload_1 
L41:    ldc [5] 
L43:    invokevirtual [19] 
L46:    pop 
L47:    aload_1 
L48:    aload_0 
L49:    getfield [16] 
L52:    invokevirtual [22] 
L55:    pop 
L56:    aload_1 
L57:    ldc [6] 
L59:    invokevirtual [19] 
L62:    pop 
L63:    aload_1 
L64:    aload_0 
L65:    getfield [17] 
L68:    invokevirtual [22] 
L71:    pop 
L72:    aload_1 
L73:    ldc [7] 
L75:    invokevirtual [19] 
L78:    pop 
L79:    aload_1 
L80:    aload_0 
L81:    getfield [18] 
L84:    invokevirtual [22] 
L87:    pop 
L88:    aload_1 
L89:    bipush 125 
L91:    invokevirtual [23] 
L94:    pop 
L95:    aload_1 
L96:    invokevirtual [24] 
L99:    areturn 
L100:   
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [224] .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_2 
        .catch [10] from L2 to L90 using L93 
L2:     aload_1 
L3:     checkcast [8] 
L6:     astore_3 
L7:     aload_0 
L8:     invokevirtual [25] 
L11:    ifne L26 
L14:    aload_3 
L15:    invokevirtual [25] 
L18:    ifne L26 
L21:    iconst_1 
L22:    istore_2 
L23:    goto L90 
L26:    aload_0 
L27:    invokevirtual [25] 
L30:    aload_3 
L31:    invokevirtual [25] 
L34:    if_icmpne L88 
L37:    aload_0 
L38:    invokevirtual [26] 
L41:    aload_3 
L42:    invokevirtual [26] 
L45:    invokestatic [9] 
L48:    ifeq L88 
L51:    aload_0 
L52:    invokevirtual [27] 
L55:    aload_3 
L56:    invokevirtual [27] 
L59:    if_icmpne L88 
L62:    aload_0 
L63:    invokevirtual [28] 
L66:    aload_3 
L67:    invokevirtual [28] 
L70:    if_icmpne L88 
L73:    aload_0 
L74:    invokevirtual [29] 
L77:    aload_3 
L78:    invokevirtual [29] 
L81:    if_icmpne L88 
L84:    iconst_1 
L85:    goto L89 
L88:    iconst_0 
L89:    istore_2 
L90:    goto L96 
L93:    astore_3 
L94:    iconst_0 
L95:    istore_2 
L96:    iload_2 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [224] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual [25] 
L6:     ifeq L17 
L9:     aload_0 
L10:    invokevirtual [26] 
L13:    invokevirtual [30] 
L16:    areturn 
L17:    iload_1 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [245] : [246] 
    .attribute [224] .code stack 7 locals 0 
L0:     new [41] 
L3:     dup 
L4:     iconst_0 
L5:     aconst_null 
L6:     iconst_m1 
L7:     iconst_0 
L8:     iconst_m1 
L9:     invokespecial [32] 
L12:    putstatic [34] 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = Class [48] 
.const [9] = Method [49] [50] 
.const [10] = Class [51] 
.const [11] = Class [52] 
.const [12] = Class [53] 
.const [13] = Class [54] 
.const [14] = Field [55] [56] 
.const [15] = Field [57] [58] 
.const [16] = Field [59] [60] 
.const [17] = Field [61] [62] 
.const [18] = Field [63] [64] 
.const [19] = Method [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Method [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Field [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Field [99] [100] 
.const [37] = Field [101] [102] 
.const [38] = Field [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Class [107] 
.const [41] = Class [108] 
.const [42] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [43] = Utf8 'Folder {isValid = ' 
.const [44] = Utf8 ', folderEntry = ' 
.const [45] = Utf8 ', level = ' 
.const [46] = Utf8 ', hmiFolderType = ' 
.const [47] = Utf8 ', requestFolderId = ' 
.const [48] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [49] = Class [109] 
.const [50] = NameAndType [110] [111] 
.const [51] = Utf8 java/lang/Exception 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [54] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [55] = Class [112] 
.const [56] = NameAndType [113] [114] 
.const [57] = Class [115] 
.const [58] = NameAndType [116] [117] 
.const [59] = Class [118] 
.const [60] = NameAndType [119] [120] 
.const [61] = Class [121] 
.const [62] = NameAndType [122] [123] 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Class [127] 
.const [66] = NameAndType [128] [129] 
.const [67] = Class [130] 
.const [68] = NameAndType [131] [132] 
.const [69] = Class [133] 
.const [70] = NameAndType [134] [135] 
.const [71] = Class [136] 
.const [72] = NameAndType [137] [138] 
.const [73] = Class [139] 
.const [74] = NameAndType [140] [141] 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Class [184] 
.const [104] = NameAndType [185] [186] 
.const [105] = Class [187] 
.const [106] = NameAndType [188] [189] 
.const [107] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [108] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [109] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [110] = Utf8 equals 
.const [111] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;Lorg/dsi/ifc/messaging/FolderEntry;)Z 
.const [112] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [113] = Utf8 isValid 
.const [114] = Utf8 Z 
.const [115] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [116] = Utf8 folderEntry 
.const [117] = Utf8 Lorg/dsi/ifc/messaging/FolderEntry; 
.const [118] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [119] = Utf8 level 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [122] = Utf8 hmiFolderType 
.const [123] = Utf8 I 
.const [124] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [125] = Utf8 requestFolderId 
.const [126] = Utf8 I 
.const [127] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [128] = Utf8 append 
.const [129] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [130] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [131] = Utf8 append 
.const [132] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [140] = Utf8 append 
.const [141] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 toString 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [146] = Utf8 isValid 
.const [147] = Utf8 ()Z 
.const [148] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [149] = Utf8 getFolderEntry 
.const [150] = Utf8 ()Lorg/dsi/ifc/messaging/FolderEntry; 
.const [151] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [152] = Utf8 getHmiFolderType 
.const [153] = Utf8 ()I 
.const [154] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [155] = Utf8 getLevel 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [158] = Utf8 getRequestFolderId 
.const [159] = Utf8 ()I 
.const [160] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [161] = Utf8 getFolderID 
.const [162] = Utf8 ()I 
.const [163] = Utf8 java/lang/Object 
.const [164] = Utf8 <init> 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (ZLorg/dsi/ifc/messaging/FolderEntry;III)V 
.const [169] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [170] = Utf8 <init> 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [173] = Utf8 FOLDER_NONE 
.const [174] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [175] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [176] = Utf8 isValid 
.const [177] = Utf8 Z 
.const [178] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [179] = Utf8 folderEntry 
.const [180] = Utf8 Lorg/dsi/ifc/messaging/FolderEntry; 
.const [181] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [182] = Utf8 level 
.const [183] = Utf8 I 
.const [184] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [185] = Utf8 hmiFolderType 
.const [186] = Utf8 I 
.const [187] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [188] = Utf8 requestFolderId 
.const [189] = Utf8 I 
.const [190] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [191] = Class [190] 
.const [192] = Utf8 java/lang/Object 
.const [193] = Class [192] 
.const [194] = Utf8 HMI_FOLDERTYPE_NONE 
.const [195] = Utf8 I 
.const [196] = Utf8 HMI_FOLDERTYPE_ROOT 
.const [197] = Utf8 I 
.const [198] = Utf8 HMI_FOLDERTYPE_DELETED 
.const [199] = Utf8 I 
.const [200] = Utf8 HMI_FOLDERTYPE_DRAFT 
.const [201] = Utf8 I 
.const [202] = Utf8 HMI_FOLDERTYPE_INBOX 
.const [203] = Utf8 I 
.const [204] = Utf8 HMI_FOLDERTYPE_OUTBOX 
.const [205] = Utf8 I 
.const [206] = Utf8 HMI_FOLDERTYPE_SENT 
.const [207] = Utf8 I 
.const [208] = Utf8 HMI_FOLDERTYPE_USER 
.const [209] = Utf8 I 
.const [210] = Utf8 FOLDER_LEVEL_NONE 
.const [211] = Utf8 I 
.const [212] = Utf8 FOLDER_NONE 
.const [213] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [214] = Utf8 isValid 
.const [215] = Utf8 Z 
.const [216] = Utf8 folderEntry 
.const [217] = Utf8 Lorg/dsi/ifc/messaging/FolderEntry; 
.const [218] = Utf8 level 
.const [219] = Utf8 I 
.const [220] = Utf8 hmiFolderType 
.const [221] = Utf8 I 
.const [222] = Utf8 requestFolderId 
.const [223] = Utf8 I 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (ZLorg/dsi/ifc/messaging/FolderEntry;III)V 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;III)V 
.const [229] = Utf8 isValid 
.const [230] = Utf8 ()Z 
.const [231] = Utf8 getFolderEntry 
.const [232] = Utf8 ()Lorg/dsi/ifc/messaging/FolderEntry; 
.const [233] = Utf8 getLevel 
.const [234] = Utf8 ()I 
.const [235] = Utf8 getHmiFolderType 
.const [236] = Utf8 ()I 
.const [237] = Utf8 getRequestFolderId 
.const [238] = Utf8 ()I 
.const [239] = Utf8 toString 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 equals 
.const [242] = Utf8 (Ljava/lang/Object;)Z 
.const [243] = Utf8 hashCode 
.const [244] = Utf8 ()I 
.const [245] = Utf8 <clinit> 
.const [246] = Utf8 ()V 
.end class 

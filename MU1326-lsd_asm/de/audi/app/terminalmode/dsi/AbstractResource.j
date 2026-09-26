.version 50 0 
.class public super abstract [159] 
.super [161] 
.implements [163] 
.field private final [164] [165] 
.field private final [166] [167] 
.field private final [168] [169] 

.method public [171] : [172] 
    .attribute [170] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [38] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [39] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [40] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [170] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     getstatic [2] 
L6:     invokespecial [33] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [175] : [176] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [177] : [178] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [179] : [180] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [170] .code stack 3 locals 1 
L0:     new [41] 
L3:     dup 
L4:     bipush 100 
L6:     invokespecial [34] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [4] 
L13:    invokevirtual [26] 
L16:    pop 
L17:    aload_1 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [23] 
L23:    invokespecial [35] 
L26:    invokevirtual [26] 
L29:    pop 
L30:    aload_1 
L31:    ldc [5] 
L33:    invokevirtual [26] 
L36:    pop 
L37:    aload_1 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [24] 
L43:    invokespecial [36] 
L46:    invokevirtual [26] 
L49:    pop 
L50:    aload_0 
L51:    getfield [25] 
L54:    getstatic [2] 
L57:    invokevirtual [27] 
L60:    ifeq L85 
L63:    aload_1 
L64:    ldc [6] 
L66:    invokevirtual [26] 
L69:    aload_0 
L70:    getfield [25] 
L73:    invokevirtual [28] 
L76:    invokevirtual [26] 
L79:    ldc [7] 
L81:    invokevirtual [26] 
L84:    pop 
L85:    aload_1 
L86:    ldc [8] 
L88:    invokevirtual [26] 
L91:    pop 
L92:    aload_1 
L93:    invokevirtual [29] 
L96:    areturn 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method private [183] : [184] 
    .attribute [170] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L31 
            2 : L28 
            default : L34 

L28:    ldc [9] 
L30:    areturn 
L31:    ldc [10] 
L33:    areturn 
L34:    ldc [11] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [185] : [186] 
    .attribute [170] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 1 
            L60 
            L57 
            L48 
            L51 
            L54 
            L63 
            L66 
            L69 
            default : L72 

L48:    ldc [12] 
L50:    areturn 
L51:    ldc [13] 
L53:    areturn 
L54:    ldc [14] 
L56:    areturn 
L57:    ldc [15] 
L59:    areturn 
L60:    ldc [16] 
L62:    areturn 
L63:    ldc [17] 
L65:    areturn 
L66:    ldc [18] 
L68:    areturn 
L69:    ldc [19] 
L71:    areturn 
L72:    ldc [11] 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [170] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [24] 
L10:    iadd 
L11:    istore_2 
L12:    bipush 31 
L14:    iload_2 
L15:    imul 
L16:    aload_0 
L17:    getfield [25] 
L20:    ifnonnull L27 
L23:    iconst_0 
L24:    goto L34 
L27:    aload_0 
L28:    getfield [25] 
L31:    invokevirtual [30] 
L34:    iadd 
L35:    istore_2 
L36:    bipush 31 
L38:    iload_2 
L39:    imul 
L40:    aload_0 
L41:    getfield [23] 
L44:    iadd 
L45:    istore_2 
L46:    iload_2 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [170] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    invokespecial [37] 
L17:    aload_1 
L18:    invokespecial [37] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [20] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [24] 
L35:    aload_2 
L36:    getfield [24] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [25] 
L48:    ifnonnull L60 
L51:    aload_2 
L52:    getfield [25] 
L55:    ifnull L76 
L58:    iconst_0 
L59:    areturn 
L60:    aload_0 
L61:    getfield [25] 
L64:    aload_2 
L65:    getfield [25] 
L68:    invokevirtual [31] 
L71:    ifne L76 
L74:    iconst_0 
L75:    areturn 
L76:    aload_0 
L77:    getfield [23] 
L80:    aload_2 
L81:    getfield [23] 
L84:    if_icmpeq L89 
L87:    iconst_0 
L88:    areturn 
L89:    iconst_1 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [42] [43] 
.const [3] = Class [44] 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = String [48] 
.const [8] = String [49] 
.const [9] = String [50] 
.const [10] = String [51] 
.const [11] = String [52] 
.const [12] = String [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = String [56] 
.const [16] = String [57] 
.const [17] = String [58] 
.const [18] = String [59] 
.const [19] = String [60] 
.const [20] = Class [61] 
.const [21] = Class [62] 
.const [22] = Class [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Method [82] [83] 
.const [33] = Method [84] [85] 
.const [34] = Method [86] [87] 
.const [35] = Method [88] [89] 
.const [36] = Method [90] [91] 
.const [37] = Method [92] [93] 
.const [38] = Field [94] [95] 
.const [39] = Field [96] [97] 
.const [40] = Field [98] [99] 
.const [41] = Class [100] 
.const [42] = Class [101] 
.const [43] = NameAndType [102] [103] 
.const [44] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [45] = Utf8 'Resource [resourceId=' 
.const [46] = Utf8 ', owner=' 
.const [47] = Utf8 ( 
.const [48] = Utf8 ')' 
.const [49] = Utf8 ']' 
.const [50] = Utf8 DEVICE 
.const [51] = Utf8 MAINUNIT 
.const [52] = Utf8 UNKNOWN 
.const [53] = Utf8 AUDIO_MEDIA 
.const [54] = Utf8 AUDIO_PHONE 
.const [55] = Utf8 AUDIO_SPEECH 
.const [56] = Utf8 MAIN_AUDIO 
.const [57] = Utf8 SCREEN 
.const [58] = Utf8 AUDIO_GUIDANCE 
.const [59] = Utf8 RESOURCE_AUDIO_RINGTONE 
.const [60] = Utf8 RESOURCE_NOTIFICATION 
.const [61] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [64] = Class [104] 
.const [65] = NameAndType [105] [106] 
.const [66] = Class [107] 
.const [67] = NameAndType [108] [109] 
.const [68] = Class [110] 
.const [69] = NameAndType [111] [112] 
.const [70] = Class [113] 
.const [71] = NameAndType [114] [115] 
.const [72] = Class [116] 
.const [73] = NameAndType [117] [118] 
.const [74] = Class [119] 
.const [75] = NameAndType [120] [121] 
.const [76] = Class [122] 
.const [77] = NameAndType [123] [124] 
.const [78] = Class [125] 
.const [79] = NameAndType [126] [127] 
.const [80] = Class [128] 
.const [81] = NameAndType [129] [130] 
.const [82] = Class [131] 
.const [83] = NameAndType [132] [133] 
.const [84] = Class [134] 
.const [85] = NameAndType [135] [136] 
.const [86] = Class [137] 
.const [87] = NameAndType [138] [139] 
.const [88] = Class [140] 
.const [89] = NameAndType [141] [142] 
.const [90] = Class [143] 
.const [91] = NameAndType [144] [145] 
.const [92] = Class [146] 
.const [93] = NameAndType [147] [148] 
.const [94] = Class [149] 
.const [95] = NameAndType [150] [151] 
.const [96] = Class [152] 
.const [97] = NameAndType [153] [154] 
.const [98] = Class [155] 
.const [99] = NameAndType [156] [157] 
.const [100] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [101] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [102] = Utf8 UNSPECIFIED 
.const [103] = Utf8 Lde/audi/app/terminalmode/dsi/IResource$OwnershipType; 
.const [104] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [105] = Utf8 resourceId 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [108] = Utf8 owner 
.const [109] = Utf8 I 
.const [110] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [111] = Utf8 ownershipType 
.const [112] = Utf8 Lde/audi/app/terminalmode/dsi/IResource$OwnershipType; 
.const [113] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [116] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [117] = Utf8 isNot 
.const [118] = Utf8 (Ljava/lang/Object;)Z 
.const [119] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [120] = Utf8 name 
.const [121] = Utf8 ()Ljava/lang/String; 
.const [122] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [123] = Utf8 toString 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [126] = Utf8 hashCode 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/audi/app/terminalmode/dsi/IResource$OwnershipType 
.const [129] = Utf8 equals 
.const [130] = Utf8 (Ljava/lang/Object;)Z 
.const [131] = Utf8 java/lang/Object 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (IILde/audi/app/terminalmode/dsi/IResource$OwnershipType;)V 
.const [137] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [141] = Utf8 getResourceString 
.const [142] = Utf8 (I)Ljava/lang/String; 
.const [143] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [144] = Utf8 getOwnerString 
.const [145] = Utf8 (I)Ljava/lang/String; 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 getClass 
.const [148] = Utf8 ()Ljava/lang/Class; 
.const [149] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [150] = Utf8 resourceId 
.const [151] = Utf8 I 
.const [152] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [153] = Utf8 owner 
.const [154] = Utf8 I 
.const [155] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [156] = Utf8 ownershipType 
.const [157] = Utf8 Lde/audi/app/terminalmode/dsi/IResource$OwnershipType; 
.const [158] = Utf8 de/audi/app/terminalmode/dsi/AbstractResource 
.const [159] = Class [158] 
.const [160] = Utf8 java/lang/Object 
.const [161] = Class [160] 
.const [162] = Utf8 de/audi/app/terminalmode/dsi/IResource 
.const [163] = Class [162] 
.const [164] = Utf8 resourceId 
.const [165] = Utf8 I 
.const [166] = Utf8 owner 
.const [167] = Utf8 I 
.const [168] = Utf8 ownershipType 
.const [169] = Utf8 Lde/audi/app/terminalmode/dsi/IResource$OwnershipType; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (IILde/audi/app/terminalmode/dsi/IResource$OwnershipType;)V 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (II)V 
.const [175] = Utf8 getResourceId 
.const [176] = Utf8 ()I 
.const [177] = Utf8 getOwner 
.const [178] = Utf8 ()I 
.const [179] = Utf8 getOwnershipType 
.const [180] = Utf8 ()Lde/audi/app/terminalmode/dsi/IResource$OwnershipType; 
.const [181] = Utf8 toString 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 getOwnerString 
.const [184] = Utf8 (I)Ljava/lang/String; 
.const [185] = Utf8 getResourceString 
.const [186] = Utf8 (I)Ljava/lang/String; 
.const [187] = Utf8 hashCode 
.const [188] = Utf8 ()I 
.const [189] = Utf8 equals 
.const [190] = Utf8 (Ljava/lang/Object;)Z 
.end class 

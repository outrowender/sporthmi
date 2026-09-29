.version 50 0 
.class public super [186] 
.super [188] 
.field private static final [189] [190] 
.field private final [191] [192] 

.method public [194] : [195] 
    .attribute [193] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [41] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method [196] : [197] 
    .attribute [193] .code stack 6 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            2 : L32 
            default : L36 

L28:    getstatic [2] 
L31:    areturn 
L32:    getstatic [3] 
L35:    areturn 
L36:    aload_0 
L37:    getfield [30] 
L40:    ldc [4] 
L42:    ldc [5] 
L44:    ldc [6] 
L46:    iload_1 
L47:    i2l 
L48:    invokevirtual [31] 
L51:    pop 
L52:    getstatic [7] 
L55:    areturn 
L56:    
    .end code 
.end method 

.method [198] : [199] 
    .attribute [193] .code stack 6 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L32 
            2 : L28 
            default : L36 

L28:    getstatic [8] 
L31:    areturn 
L32:    getstatic [9] 
L35:    areturn 
L36:    aload_0 
L37:    getfield [30] 
L40:    ldc [4] 
L42:    ldc [10] 
L44:    ldc [6] 
L46:    iload_1 
L47:    i2l 
L48:    invokevirtual [31] 
L51:    pop 
L52:    getstatic [9] 
L55:    areturn 
L56:    
    .end code 
.end method 

.method [200] : [201] 
    .attribute [193] .code stack 6 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L52 
            L48 
            L40 
            L36 
            L44 
            default : L56 

L36:    getstatic [11] 
L39:    areturn 
L40:    getstatic [12] 
L43:    areturn 
L44:    getstatic [13] 
L47:    areturn 
L48:    getstatic [14] 
L51:    areturn 
L52:    getstatic [15] 
L55:    areturn 
L56:    aload_0 
L57:    getfield [30] 
L60:    ldc [4] 
L62:    ldc [16] 
L64:    ldc [6] 
L66:    iload_1 
L67:    i2l 
L68:    invokevirtual [31] 
L71:    pop 
L72:    getstatic [15] 
L75:    areturn 
L76:    
    .end code 
.end method 

.method [202] : [203] 
    .attribute [193] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L36 
            L32 
            L28 
            default : L36 

L28:    getstatic [17] 
L31:    areturn 
L32:    getstatic [18] 
L35:    areturn 
L36:    getstatic [19] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method [204] : [205] 
    .attribute [193] .code stack 8 locals 1 
L0:     iconst_4 
L1:     anewarray [20] 
L4:     astore_2 
L5:     aload_2 
L6:     iconst_0 
L7:     new [42] 
L10:    dup 
L11:    iconst_1 
L12:    aload_0 
L13:    aload_1 
L14:    getstatic [14] 
L17:    invokevirtual [32] 
L20:    invokevirtual [33] 
L23:    invokespecial [39] 
L26:    aastore 
L27:    aload_2 
L28:    iconst_1 
L29:    new [42] 
L32:    dup 
L33:    iconst_2 
L34:    aload_0 
L35:    aload_1 
L36:    getstatic [12] 
L39:    invokevirtual [32] 
L42:    invokevirtual [33] 
L45:    invokespecial [39] 
L48:    aastore 
L49:    aload_2 
L50:    iconst_2 
L51:    new [42] 
L54:    dup 
L55:    iconst_3 
L56:    aload_0 
L57:    aload_1 
L58:    getstatic [11] 
L61:    invokevirtual [32] 
L64:    invokevirtual [33] 
L67:    invokespecial [39] 
L70:    aastore 
L71:    aload_2 
L72:    iconst_3 
L73:    new [42] 
L76:    dup 
L77:    iconst_4 
L78:    aload_0 
L79:    aload_1 
L80:    getstatic [13] 
L83:    invokevirtual [32] 
L86:    invokevirtual [33] 
L89:    invokespecial [39] 
L92:    aastore 
L93:    aload_2 
L94:    areturn 
L95:    nop 
L96:    
    .end code 
.end method 

.method [206] : [207] 
    .attribute [193] .code stack 2 locals 0 
L0:     getstatic [8] 
L3:     aload_1 
L4:     invokevirtual [34] 
L7:     ifeq L12 
L10:    iconst_2 
L11:    areturn 
L12:    iconst_1 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [208] : [209] 
    .attribute [193] .code stack 8 locals 1 
L0:     iconst_2 
L1:     anewarray [21] 
L4:     astore_2 
L5:     aload_2 
L6:     iconst_0 
L7:     new [43] 
L10:    dup 
L11:    iconst_1 
L12:    aload_0 
L13:    aload_1 
L14:    getstatic [2] 
L17:    invokevirtual [35] 
L20:    invokevirtual [36] 
L23:    invokespecial [40] 
L26:    aastore 
L27:    aload_2 
L28:    iconst_1 
L29:    new [43] 
L32:    dup 
L33:    iconst_2 
L34:    aload_0 
L35:    aload_1 
L36:    getstatic [3] 
L39:    invokevirtual [35] 
L42:    invokevirtual [36] 
L45:    invokespecial [40] 
L48:    aastore 
L49:    aload_2 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method [210] : [211] 
    .attribute [193] .code stack 2 locals 0 
L0:     getstatic [17] 
L3:     aload_1 
L4:     invokevirtual [37] 
L7:     ifeq L12 
L10:    iconst_2 
L11:    areturn 
L12:    getstatic [18] 
L15:    aload_1 
L16:    invokevirtual [37] 
L19:    ifeq L24 
L22:    iconst_1 
L23:    areturn 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [44] [45] 
.const [3] = Field [46] [47] 
.const [4] = Int -1601830656 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = Field [50] [51] 
.const [8] = Field [52] [53] 
.const [9] = Field [54] [55] 
.const [10] = String [56] 
.const [11] = Field [57] [58] 
.const [12] = Field [59] [60] 
.const [13] = Field [61] [62] 
.const [14] = Field [63] [64] 
.const [15] = Field [65] [66] 
.const [16] = String [67] 
.const [17] = Field [68] [69] 
.const [18] = Field [70] [71] 
.const [19] = Field [72] [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Class [79] 
.const [26] = Class [80] 
.const [27] = Class [81] 
.const [28] = Class [82] 
.const [29] = Class [83] 
.const [30] = Field [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Method [104] [105] 
.const [41] = Field [106] [107] 
.const [42] = Class [108] 
.const [43] = Class [109] 
.const [44] = Class [110] 
.const [45] = NameAndType [111] [112] 
.const [46] = Class [113] 
.const [47] = NameAndType [114] [115] 
.const [48] = Utf8 '[%1.mapApplication] Unknown application id %2' 
.const [49] = Utf8 DSIMHIConstantsMapper 
.const [50] = Class [116] 
.const [51] = NameAndType [117] [118] 
.const [52] = Class [119] 
.const [53] = NameAndType [120] [121] 
.const [54] = Class [122] 
.const [55] = NameAndType [123] [124] 
.const [56] = Utf8 '[%1.mapResourceOwner] Unknown resource owner %1' 
.const [57] = Class [125] 
.const [58] = NameAndType [126] [127] 
.const [59] = Class [128] 
.const [60] = NameAndType [129] [130] 
.const [61] = Class [131] 
.const [62] = NameAndType [132] [133] 
.const [63] = Class [134] 
.const [64] = NameAndType [135] [136] 
.const [65] = Class [137] 
.const [66] = NameAndType [138] [139] 
.const [67] = Utf8 '[%1.mapResourceOwner] Unknown resource %1' 
.const [68] = Class [140] 
.const [69] = NameAndType [141] [142] 
.const [70] = Class [143] 
.const [71] = NameAndType [144] [145] 
.const [72] = Class [146] 
.const [73] = NameAndType [147] [148] 
.const [74] = Utf8 org/dsi/ifc/carlife/Resource 
.const [75] = Utf8 org/dsi/ifc/carlife/AppState 
.const [76] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [81] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [82] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [83] = Utf8 de/audi/app/terminalmode/statemachine/TMState 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Class [155] 
.const [89] = NameAndType [156] [157] 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Utf8 org/dsi/ifc/carlife/Resource 
.const [109] = Utf8 org/dsi/ifc/carlife/AppState 
.const [110] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [111] = Utf8 NAVI 
.const [112] = Utf8 Lde/audi/app/terminalmode/statemachine/Application; 
.const [113] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [114] = Utf8 SPEECH 
.const [115] = Utf8 Lde/audi/app/terminalmode/statemachine/Application; 
.const [116] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [117] = Utf8 PHONE 
.const [118] = Utf8 Lde/audi/app/terminalmode/statemachine/Application; 
.const [119] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [120] = Utf8 DEVICE 
.const [121] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [122] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [123] = Utf8 MAINUNIT 
.const [124] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [125] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [126] = Utf8 AUDIO_MEDIA 
.const [127] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [128] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [129] = Utf8 AUDIO_SPEECH 
.const [130] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [131] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [132] = Utf8 AUDIO_GUIDANCE 
.const [133] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [134] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [135] = Utf8 SCREEN 
.const [136] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [137] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [138] = Utf8 NOTIFICATION 
.const [139] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [140] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [141] = Utf8 DEVICE 
.const [142] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [143] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [144] = Utf8 MAINUNIT 
.const [145] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [146] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [147] = Utf8 NOBODY 
.const [148] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [149] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [150] = Utf8 logger 
.const [151] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [152] = Utf8 de/audi/atip/log/LogChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [155] = Utf8 de/audi/app/terminalmode/statemachine/TMState 
.const [156] = Utf8 getOwnerForResource 
.const [157] = Utf8 (Lde/audi/app/terminalmode/statemachine/Resource;)Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [158] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [159] = Utf8 mapResourceOwner 
.const [160] = Utf8 (Lde/audi/app/terminalmode/statemachine/ResourceOwner;)I 
.const [161] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [162] = Utf8 is 
.const [163] = Utf8 (Ljava/lang/Object;)Z 
.const [164] = Utf8 de/audi/app/terminalmode/statemachine/TMState 
.const [165] = Utf8 getOwnerForApplication 
.const [166] = Utf8 (Lde/audi/app/terminalmode/statemachine/Application;)Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [167] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [168] = Utf8 mapAppStateOwner 
.const [169] = Utf8 (Lde/audi/app/terminalmode/statemachine/ApplicationOwner;)I 
.const [170] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [171] = Utf8 is 
.const [172] = Utf8 (Ljava/lang/Object;)Z 
.const [173] = Utf8 java/lang/Object 
.const [174] = Utf8 <init> 
.const [175] = Utf8 ()V 
.const [176] = Utf8 org/dsi/ifc/carlife/Resource 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (II)V 
.const [179] = Utf8 org/dsi/ifc/carlife/AppState 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (II)V 
.const [182] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [183] = Utf8 logger 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/audi/app/terminalmode/smartphone/carlife/DSIMHIConstantsMapper 
.const [186] = Class [185] 
.const [187] = Utf8 java/lang/Object 
.const [188] = Class [187] 
.const [189] = Utf8 LOGCLASS 
.const [190] = Utf8 Ljava/lang/String; 
.const [191] = Utf8 logger 
.const [192] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [193] = Utf8 Code 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [196] = Utf8 mapApplication 
.const [197] = Utf8 (I)Lde/audi/app/terminalmode/statemachine/Application; 
.const [198] = Utf8 mapResourceOwner 
.const [199] = Utf8 (I)Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [200] = Utf8 mapResource 
.const [201] = Utf8 (I)Lde/audi/app/terminalmode/statemachine/Resource; 
.const [202] = Utf8 mapAppOwner 
.const [203] = Utf8 (I)Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [204] = Utf8 createResources 
.const [205] = Utf8 (Lde/audi/app/terminalmode/statemachine/TMState;)[Lorg/dsi/ifc/carlife/Resource; 
.const [206] = Utf8 mapResourceOwner 
.const [207] = Utf8 (Lde/audi/app/terminalmode/statemachine/ResourceOwner;)I 
.const [208] = Utf8 createAppStates 
.const [209] = Utf8 (Lde/audi/app/terminalmode/statemachine/TMState;)[Lorg/dsi/ifc/carlife/AppState; 
.const [210] = Utf8 mapAppStateOwner 
.const [211] = Utf8 (Lde/audi/app/terminalmode/statemachine/ApplicationOwner;)I 
.end class 

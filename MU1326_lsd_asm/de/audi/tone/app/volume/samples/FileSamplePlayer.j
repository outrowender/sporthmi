.version 50 0 
.class public super [124] 
.super [126] 
.implements [128] 
.field private final [129] [130] 
.field private [131] [132] 
.field private volatile [133] [134] 
.field private volatile [135] [136] 

.method public [138] : [139] 
    .attribute [137] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [24] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [23] 
L14:    aload_0 
L15:    new [25] 
L18:    dup 
L19:    aload_1 
L20:    getfield [15] 
L23:    invokespecial [21] 
L26:    putfield [26] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [137] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [137] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L24 
L7:     aload_0 
L8:     getfield [13] 
L11:    getfield [15] 
L14:    sipush 10000 
L17:    ldc [3] 
L19:    invokevirtual [17] 
L22:    pop 
L23:    return 
L24:    aload_0 
L25:    getfield [13] 
L28:    getfield [15] 
L31:    ldc [4] 
L33:    ldc [5] 
L35:    aload_0 
L36:    getfield [14] 
L39:    invokevirtual [18] 
L42:    pop 
L43:    aload_0 
L44:    getfield [19] 
L47:    ifnull L63 
L50:    aload_0 
L51:    getfield [16] 
L54:    aload_0 
L55:    getfield [19] 
L58:    invokeinterface [28] 0 
L63:    aload_0 
L64:    new [29] 
L67:    dup 
L68:    aload_0 
L69:    bipush 91 
L71:    aload_0 
L72:    getfield [14] 
L75:    invokespecial [22] 
L78:    putfield [27] 
L81:    aload_0 
L82:    getfield [16] 
L85:    aload_0 
L86:    getfield [19] 
L89:    invokeinterface [30] 0 
L94:    return 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [137] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     getfield [15] 
L7:     ldc [4] 
L9:     ldc [7] 
L11:    invokevirtual [17] 
L14:    pop 
L15:    aload_0 
L16:    getfield [16] 
L19:    aload_0 
L20:    getfield [19] 
L23:    invokeinterface [28] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [137] .code stack 2 locals 0 
L0:     aload_1 
L1:     instanceof [8] 
L4:     ifeq L15 
L7:     aload_0 
L8:     aload_1 
L9:     checkcast [8] 
L12:    putfield [26] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [137] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [8] 
L4:     ifeq L25 
L7:     aload_0 
L8:     new [25] 
L11:    dup 
L12:    aload_0 
L13:    getfield [13] 
L16:    getfield [15] 
L19:    invokespecial [21] 
L22:    putfield [26] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [150] : [151] 
    .attribute [137] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = Int -2137614336 
.const [5] = String [33] 
.const [6] = Class [34] 
.const [7] = String [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Class [65] 
.const [26] = Field [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = InterfaceMethod [70] [71] 
.const [29] = Class [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = Utf8 de/audi/atip/interapp/def/NullMediaFilePlayerService 
.const [32] = Utf8 '[FileSamplePlayer.play] URL is null!' 
.const [33] = Utf8 '[FileSamplePlayer.play] url:%1' 
.const [34] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer$RingtoneMediaSession 
.const [35] = Utf8 '[FileSamplePlayer.stop]' 
.const [36] = Utf8 de/audi/atip/interapp/media/IMediaFilePlayerService 
.const [37] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/audi/tone/app/ToneEnv 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Utf8 de/audi/atip/interapp/def/NullMediaFilePlayerService 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer$RingtoneMediaSession 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [76] = Utf8 env 
.const [77] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [78] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [79] = Utf8 url 
.const [80] = Utf8 Ljava/lang/String; 
.const [81] = Utf8 de/audi/tone/app/ToneEnv 
.const [82] = Utf8 lcMain 
.const [83] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [85] = Utf8 mediaService 
.const [86] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerService; 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;)Z 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [93] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [94] = Utf8 mediaFilePlayerSession 
.const [95] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerSession; 
.const [96] = Utf8 java/lang/Object 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/audi/atip/interapp/def/NullMediaFilePlayerService 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [102] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer$RingtoneMediaSession 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/tone/app/volume/samples/FileSamplePlayer;ILjava/lang/String;)V 
.const [105] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [106] = Utf8 env 
.const [107] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [108] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [109] = Utf8 url 
.const [110] = Utf8 Ljava/lang/String; 
.const [111] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [112] = Utf8 mediaService 
.const [113] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerService; 
.const [114] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [115] = Utf8 mediaFilePlayerSession 
.const [116] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerSession; 
.const [117] = Utf8 de/audi/atip/interapp/media/IMediaFilePlayerService 
.const [118] = Utf8 close 
.const [119] = Utf8 (Lde/audi/atip/interapp/media/IMediaFilePlayerSession;)V 
.const [120] = Utf8 de/audi/atip/interapp/media/IMediaFilePlayerService 
.const [121] = Utf8 'open' 
.const [122] = Utf8 (Lde/audi/atip/interapp/media/IMediaFilePlayerSession;)V 
.const [123] = Utf8 de/audi/tone/app/volume/samples/FileSamplePlayer 
.const [124] = Class [123] 
.const [125] = Utf8 java/lang/Object 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/tone/app/volume/samples/ISamplePlayer 
.const [128] = Class [127] 
.const [129] = Utf8 env 
.const [130] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [131] = Utf8 mediaService 
.const [132] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerService; 
.const [133] = Utf8 mediaFilePlayerSession 
.const [134] = Utf8 Lde/audi/atip/interapp/media/IMediaFilePlayerSession; 
.const [135] = Utf8 url 
.const [136] = Utf8 Ljava/lang/String; 
.const [137] = Utf8 Code 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Lde/audi/tone/app/ToneEnv;)V 
.const [140] = Utf8 setUserDefinedRingtone 
.const [141] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [142] = Utf8 play 
.const [143] = Utf8 ()V 
.const [144] = Utf8 stop 
.const [145] = Utf8 ()V 
.const [146] = Utf8 registerService 
.const [147] = Utf8 (Ljava/lang/Object;)V 
.const [148] = Utf8 deregisterService 
.const [149] = Utf8 (Ljava/lang/Object;)V 
.const [150] = Utf8 access$000 
.const [151] = Utf8 (Lde/audi/tone/app/volume/samples/FileSamplePlayer;)Lde/audi/tone/app/ToneEnv; 
.end class 

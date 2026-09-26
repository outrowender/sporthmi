.version 50 0 
.class public super [119] 
.super [121] 
.field public static final [122] [123] 
.field public static final [124] [125] 
.field private final [126] [127] 
.field private final [128] [129] 

.method public [131] : [132] 
    .attribute [130] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_3 
L5:     ifnonnull L18 
L8:     new [25] 
L11:    dup 
L12:    ldc [3] 
L14:    invokespecial [22] 
L17:    athrow 
L18:    aload_0 
L19:    lload_1 
L20:    putfield [26] 
L23:    aload_0 
L24:    aload_3 
L25:    putfield [27] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [130] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     ldc2_w [29] 
L8:     putfield [26] 
L11:    aload_0 
L12:    getstatic [4] 
L15:    putfield [27] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [137] : [138] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [130] .code stack 3 locals 1 
        .catch [5] from L0 to L15 using L16 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [14] 
L8:     arraylength 
L9:     iconst_1 
L10:    isub 
L11:    aaload 
L12:    invokevirtual [15] 
L15:    areturn 
L16:    astore_1 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [130] .code stack 3 locals 1 
L0:     new [28] 
L3:     dup 
L4:     invokespecial [24] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [16] 
L14:    aload_0 
L15:    getfield [13] 
L18:    invokevirtual [17] 
L21:    ldc [8] 
L23:    invokevirtual [16] 
L26:    aload_0 
L27:    invokevirtual [18] 
L30:    invokevirtual [19] 
L33:    ldc [9] 
L35:    invokevirtual [16] 
L38:    pop 
L39:    aload_1 
L40:    invokevirtual [20] 
L43:    areturn 
L44:    
    .end code 
.end method 

.method static [143] : [144] 
    .attribute [130] .code stack 1 locals 0 
L0:     iconst_0 
L1:     anewarray [10] 
L4:     putstatic [23] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = Field [33] [34] 
.const [5] = Class [35] 
.const [6] = Class [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Class [67] 
.const [26] = Field [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Class [72] 
.const [29] = Long -1L 
.const [31] = Utf8 java/lang/IllegalArgumentException 
.const [32] = Utf8 'playback folder cannot be null' 
.const [33] = Class [73] 
.const [34] = NameAndType [74] [75] 
.const [35] = Utf8 java/lang/Exception 
.const [36] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [37] = Utf8 "[PlayingTrack: entryID='" 
.const [38] = Utf8 "',playlist='" 
.const [39] = Utf8 "']" 
.const [40] = Utf8 de/audi/app/media/dsi/media/MediaListEntry 
.const [41] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Utf8 java/lang/IllegalArgumentException 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [73] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [74] = Utf8 EMPTY_PLAYBACK_FOLDER 
.const [75] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [76] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [77] = Utf8 entryID 
.const [78] = Utf8 J 
.const [79] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [80] = Utf8 playbackFolder 
.const [81] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [82] = Utf8 de/audi/app/media/dsi/media/MediaListEntry 
.const [83] = Utf8 isPlaylist 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Utf8 append 
.const [87] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 append 
.const [90] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [91] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [92] = Utf8 isPlaylistTrack 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [97] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [98] = Utf8 toString 
.const [99] = Utf8 ()Ljava/lang/String; 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 java/lang/IllegalArgumentException 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Ljava/lang/String;)V 
.const [106] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [107] = Utf8 EMPTY_PLAYBACK_FOLDER 
.const [108] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [109] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [113] = Utf8 entryID 
.const [114] = Utf8 J 
.const [115] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [116] = Utf8 playbackFolder 
.const [117] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [118] = Utf8 de/audi/app/media/content/media/PlayingTrack 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 INVALID_ENTRYID 
.const [123] = Utf8 J 
.const [124] = Utf8 EMPTY_PLAYBACK_FOLDER 
.const [125] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [126] = Utf8 entryID 
.const [127] = Utf8 J 
.const [128] = Utf8 playbackFolder 
.const [129] = Utf8 [Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (J[Lde/audi/app/media/dsi/media/MediaListEntry;)V 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 getEntryID 
.const [136] = Utf8 ()J 
.const [137] = Utf8 getPlaybackFolder 
.const [138] = Utf8 ()[Lde/audi/app/media/dsi/media/MediaListEntry; 
.const [139] = Utf8 isPlaylistTrack 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 <clinit> 
.const [144] = Utf8 ()V 
.end class 

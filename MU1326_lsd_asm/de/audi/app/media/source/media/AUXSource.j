.version 50 0 
.class public super [59] 
.super [61] 
.field private final [62] [63] 
.field private final [64] [65] 

.method public [67] : [68] 
    .attribute [66] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     aload 4 
L6:     invokespecial [9] 
L9:     aload_0 
L10:    invokevirtual [6] 
L13:    invokeinterface [10] 0 
L18:    lookupswitch 
            3 : L44 
            4 : L44 
            default : L57 

L44:    aload_0 
L45:    iconst_0 
L46:    putfield [11] 
L49:    aload_0 
L50:    iconst_0 
L51:    putfield [12] 
L54:    goto L69 
L57:    aload_0 
L58:    bipush 16 
L60:    putfield [11] 
L63:    aload_0 
L64:    bipush 17 
L66:    putfield [12] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokeinterface [13] 0 
L6:     lookupswitch 
            1 : L24 
            default : L29 

L24:    aload_0 
L25:    getfield [8] 
L28:    areturn 
L29:    aload_0 
L30:    getfield [7] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Method [18] [19] 
.const [7] = Field [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = InterfaceMethod [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = InterfaceMethod [32] [33] 
.const [14] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [15] = Utf8 de/audi/app/media/source/media/AbstractMediaSource 
.const [16] = Utf8 de/audi/app/media/IMediaTerminal 
.const [17] = Utf8 de/audi/app/media/source/ISourceSlot 
.const [18] = Class [34] 
.const [19] = NameAndType [35] [36] 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [35] = Utf8 getTerminal 
.const [36] = Utf8 ()Lde/audi/app/media/IMediaTerminal; 
.const [37] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [38] = Utf8 AUDIO_CONNECTION_GENERIC 
.const [39] = Utf8 I 
.const [40] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [41] = Utf8 AUDIO_CONNECTION_DATA 
.const [42] = Utf8 I 
.const [43] = Utf8 de/audi/app/media/source/media/AbstractMediaSource 
.const [44] = Utf8 <init> 
.const [45] = Utf8 (Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;ILjava/lang/String;)V 
.const [46] = Utf8 de/audi/app/media/IMediaTerminal 
.const [47] = Utf8 getTerminalID 
.const [48] = Utf8 ()I 
.const [49] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [50] = Utf8 AUDIO_CONNECTION_GENERIC 
.const [51] = Utf8 I 
.const [52] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [53] = Utf8 AUDIO_CONNECTION_DATA 
.const [54] = Utf8 I 
.const [55] = Utf8 de/audi/app/media/source/ISourceSlot 
.const [56] = Utf8 getContentType 
.const [57] = Utf8 ()I 
.const [58] = Utf8 de/audi/app/media/source/media/AUXSource 
.const [59] = Class [58] 
.const [60] = Utf8 de/audi/app/media/source/media/AbstractMediaSource 
.const [61] = Class [60] 
.const [62] = Utf8 AUDIO_CONNECTION_GENERIC 
.const [63] = Utf8 I 
.const [64] = Utf8 AUDIO_CONNECTION_DATA 
.const [65] = Utf8 I 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;ILjava/lang/String;)V 
.const [69] = Utf8 getAudioConnection 
.const [70] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)I 
.end class 

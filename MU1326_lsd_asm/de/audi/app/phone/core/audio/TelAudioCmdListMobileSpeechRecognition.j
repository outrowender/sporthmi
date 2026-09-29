.version 50 0 
.class public super [65] 
.super [67] 
.field static final [68] [69] 
.field static final [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [10] 
L5:     iload 4 
L7:     ifeq L49 
L10:    aload_0 
L11:    new [15] 
L14:    dup 
L15:    aload_2 
L16:    sipush 137 
L19:    aload_3 
L20:    iconst_0 
L21:    invokespecial [11] 
L24:    invokevirtual [9] 
L27:    pop 
L28:    aload_0 
L29:    new [15] 
L32:    dup 
L33:    aload_2 
L34:    sipush 136 
L37:    aload_3 
L38:    iconst_2 
L39:    invokespecial [11] 
L42:    invokevirtual [9] 
L45:    pop 
L46:    goto L83 
L49:    aload_0 
L50:    new [16] 
L53:    dup 
L54:    aload_2 
L55:    sipush 137 
L58:    aload_3 
L59:    invokespecial [12] 
L62:    invokevirtual [9] 
L65:    pop 
L66:    aload_0 
L67:    new [16] 
L70:    dup 
L71:    aload_2 
L72:    sipush 136 
L75:    aload_3 
L76:    invokespecial [12] 
L79:    invokevirtual [9] 
L82:    pop 
L83:    return 
L84:    
    .end code 
.end method 

.method static [75] : [76] 
    .attribute [72] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     sipush 136 
L8:     iastore 
L9:     dup 
L10:    iconst_1 
L11:    sipush 137 
L14:    iastore 
L15:    putstatic [13] 
L18:    getstatic [4] 
L21:    invokestatic [5] 
L24:    putstatic [14] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Field [19] [20] 
.const [5] = Method [21] [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Class [38] 
.const [16] = Class [39] 
.const [17] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [18] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [19] = Class [40] 
.const [20] = NameAndType [41] [42] 
.const [21] = Class [43] 
.const [22] = NameAndType [44] [45] 
.const [23] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [24] = Utf8 de/audi/tghu/command/CommandList 
.const [25] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [39] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [40] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [41] = Utf8 requiredConnections 
.const [42] = Utf8 [I 
.const [43] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [44] = Utf8 getAudioConnectionsToRelease 
.const [45] = Utf8 ([I)[I 
.const [46] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [47] = Utf8 add 
.const [48] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [49] = Utf8 de/audi/tghu/command/CommandList 
.const [50] = Utf8 <init> 
.const [51] = Utf8 (Lde/audi/tghu/command/CommandListManager;)V 
.const [52] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;I)V 
.const [55] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [56] = Utf8 <init> 
.const [57] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;)V 
.const [58] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [59] = Utf8 requiredConnections 
.const [60] = Utf8 [I 
.const [61] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [62] = Utf8 connectionsToRelease 
.const [63] = Utf8 [I 
.const [64] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdListMobileSpeechRecognition 
.const [65] = Class [64] 
.const [66] = Utf8 de/audi/tghu/command/CommandList 
.const [67] = Class [66] 
.const [68] = Utf8 requiredConnections 
.const [69] = Utf8 [I 
.const [70] = Utf8 connectionsToRelease 
.const [71] = Utf8 [I 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;Z)V 
.const [75] = Utf8 <clinit> 
.const [76] = Utf8 ()V 
.end class 

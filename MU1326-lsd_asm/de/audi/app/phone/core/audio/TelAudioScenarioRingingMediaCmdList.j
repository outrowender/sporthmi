.version 50 0 
.class public super [75] 
.super [77] 
.field static final [78] [79] 
.field static final [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [11] 
L7:     aload_0 
L8:     new [16] 
L11:    dup 
L12:    aload_2 
L13:    bipush 100 
L15:    aload_3 
L16:    iconst_0 
L17:    invokespecial [12] 
L20:    invokevirtual [9] 
L23:    pop 
L24:    aload_0 
L25:    new [16] 
L28:    dup 
L29:    aload_2 
L30:    bipush 102 
L32:    aload_3 
L33:    iconst_0 
L34:    invokespecial [12] 
L37:    invokevirtual [9] 
L40:    pop 
L41:    aload_0 
L42:    getstatic [3] 
L45:    invokevirtual [10] 
L48:    aload_0 
L49:    new [17] 
L52:    dup 
L53:    aload_2 
L54:    aload_3 
L55:    aload 4 
L57:    aload 5 
L59:    invokespecial [14] 
L62:    invokevirtual [9] 
L65:    pop 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method static [85] : [86] 
    .attribute [82] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 100 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 102 
L12:    iastore 
L13:    putstatic [15] 
L16:    getstatic [5] 
L19:    invokestatic [6] 
L22:    putstatic [13] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = Field [19] [20] 
.const [4] = Class [21] 
.const [5] = Field [22] [23] 
.const [6] = Method [24] [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Method [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Class [42] 
.const [17] = Class [43] 
.const [18] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [19] = Class [44] 
.const [20] = NameAndType [45] [46] 
.const [21] = Utf8 de/audi/app/phone/core/audio/TelRequestMediaRingtonePlaybackCmd 
.const [22] = Class [47] 
.const [23] = NameAndType [48] [49] 
.const [24] = Class [50] 
.const [25] = NameAndType [51] [52] 
.const [26] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [27] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [28] = Class [53] 
.const [29] = NameAndType [54] [55] 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Class [68] 
.const [39] = NameAndType [69] [70] 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [43] = Utf8 de/audi/app/phone/core/audio/TelRequestMediaRingtonePlaybackCmd 
.const [44] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [45] = Utf8 connectionsToRelease 
.const [46] = Utf8 [I 
.const [47] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [48] = Utf8 requiredConnections 
.const [49] = Utf8 [I 
.const [50] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [51] = Utf8 getAudioConnectionsToRelease 
.const [52] = Utf8 ([I)[I 
.const [53] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [54] = Utf8 add 
.const [55] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [56] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [57] = Utf8 addReleaseConnectionCommands 
.const [58] = Utf8 ([I)V 
.const [59] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [60] = Utf8 <init> 
.const [61] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [62] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;I)V 
.const [65] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [66] = Utf8 connectionsToRelease 
.const [67] = Utf8 [I 
.const [68] = Utf8 de/audi/app/phone/core/audio/TelRequestMediaRingtonePlaybackCmd 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;Lde/audi/atip/interapp/media/IMediaFilePlayerService;Lde/audi/atip/interapp/media/IMediaFilePlayerSession;)V 
.const [71] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [72] = Utf8 requiredConnections 
.const [73] = Utf8 [I 
.const [74] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioRingingMediaCmdList 
.const [75] = Class [74] 
.const [76] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [77] = Class [76] 
.const [78] = Utf8 requiredConnections 
.const [79] = Utf8 [I 
.const [80] = Utf8 connectionsToRelease 
.const [81] = Utf8 [I 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;Lde/audi/atip/interapp/media/IMediaFilePlayerService;Lde/audi/atip/interapp/media/IMediaFilePlayerSession;)V 
.const [85] = Utf8 <clinit> 
.const [86] = Utf8 ()V 
.end class 

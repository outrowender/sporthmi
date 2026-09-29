.version 50 0 
.class public super [65] 
.super [67] 
.field static final [68] [69] 
.field static final [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [10] 
L7:     aload_0 
L8:     new [14] 
L11:    dup 
L12:    aload_2 
L13:    bipush 100 
L15:    aload_3 
L16:    iconst_0 
L17:    invokespecial [11] 
L20:    invokevirtual [8] 
L23:    pop 
L24:    aload_0 
L25:    new [14] 
L28:    dup 
L29:    aload_2 
L30:    bipush 102 
L32:    aload_3 
L33:    iconst_0 
L34:    invokespecial [11] 
L37:    invokevirtual [8] 
L40:    pop 
L41:    aload_0 
L42:    getstatic [3] 
L45:    invokevirtual [9] 
L48:    aload_0 
L49:    new [14] 
L52:    dup 
L53:    aload_2 
L54:    bipush 99 
L56:    aload_3 
L57:    iconst_0 
L58:    invokespecial [11] 
L61:    invokevirtual [8] 
L64:    pop 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method static [75] : [76] 
    .attribute [72] .code stack 4 locals 0 
L0:     iconst_3 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 100 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 99 
L12:    iastore 
L13:    dup 
L14:    iconst_2 
L15:    bipush 102 
L17:    iastore 
L18:    putstatic [13] 
L21:    getstatic [4] 
L24:    invokestatic [5] 
L27:    putstatic [12] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Field [16] [17] 
.const [4] = Field [18] [19] 
.const [5] = Method [20] [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Class [36] 
.const [15] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [16] = Class [37] 
.const [17] = NameAndType [38] [39] 
.const [18] = Class [40] 
.const [19] = NameAndType [41] [42] 
.const [20] = Class [43] 
.const [21] = NameAndType [44] [45] 
.const [22] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [23] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [24] = Class [46] 
.const [25] = NameAndType [47] [48] 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [37] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [38] = Utf8 connectionsToRelease 
.const [39] = Utf8 [I 
.const [40] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [41] = Utf8 requiredConnections 
.const [42] = Utf8 [I 
.const [43] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [44] = Utf8 getAudioConnectionsToRelease 
.const [45] = Utf8 ([I)[I 
.const [46] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [47] = Utf8 add 
.const [48] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [49] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [50] = Utf8 addReleaseConnectionCommands 
.const [51] = Utf8 ([I)V 
.const [52] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [55] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [56] = Utf8 <init> 
.const [57] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;I)V 
.const [58] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [59] = Utf8 connectionsToRelease 
.const [60] = Utf8 [I 
.const [61] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [62] = Utf8 requiredConnections 
.const [63] = Utf8 [I 
.const [64] = Utf8 de/audi/app/phone/core/audio/TelAudioScenarioSIMHandsfreeMuteCmdList 
.const [65] = Class [64] 
.const [66] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmdList 
.const [67] = Class [66] 
.const [68] = Utf8 requiredConnections 
.const [69] = Utf8 [I 
.const [70] = Utf8 connectionsToRelease 
.const [71] = Utf8 [I 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [75] = Utf8 <clinit> 
.const [76] = Utf8 ()V 
.end class 

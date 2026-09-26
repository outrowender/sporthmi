.version 50 0 
.class public super [58] 
.super [60] 
.implements [62] 

.method public [64] : [65] 
    .attribute [63] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [11] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [66] : [67] 
    .attribute [63] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [9] 
L15:    pop 
L16:    new [13] 
L19:    dup 
L20:    invokespecial [12] 
L23:    astore_3 
L24:    aload_3 
L25:    iload_1 
L26:    putfield [14] 
L29:    aload_3 
L30:    iload_2 
L31:    putfield [15] 
L34:    aload_0 
L35:    bipush 48 
L37:    aload_3 
L38:    invokevirtual [10] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Class [31] 
.const [14] = Field [32] [33] 
.const [15] = Field [34] [35] 
.const [16] = Utf8 '[AppConnectorSystem#updateCustomerDownloadState] called (state=%1, progress=%2)' 
.const [17] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/CustomerDownloadState_Status 
.const [18] = Utf8 de/audi/app/combi/bap/app/audio/system/AppConnectorSystem 
.const [19] = Utf8 de/audi/app/combi/bap/AbstractCombiConnector 
.const [20] = Utf8 de/audi/atip/log/LogChannel 
.const [21] = Class [36] 
.const [22] = NameAndType [37] [38] 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/CustomerDownloadState_Status 
.const [32] = Class [51] 
.const [33] = NameAndType [52] [53] 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Utf8 de/audi/app/combi/bap/app/audio/system/AppConnectorSystem 
.const [37] = Utf8 logChannel 
.const [38] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 log 
.const [41] = Utf8 (ILjava/lang/String;JJ)Z 
.const [42] = Utf8 de/audi/app/combi/bap/app/audio/system/AppConnectorSystem 
.const [43] = Utf8 sendPropertyStatus 
.const [44] = Utf8 (ILde/vw/mib/bap/requests/StatusProperty;)V 
.const [45] = Utf8 de/audi/app/combi/bap/AbstractCombiConnector 
.const [46] = Utf8 <init> 
.const [47] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;)V 
.const [48] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/CustomerDownloadState_Status 
.const [49] = Utf8 <init> 
.const [50] = Utf8 ()V 
.const [51] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/CustomerDownloadState_Status 
.const [52] = Utf8 customerDownloadState 
.const [53] = Utf8 I 
.const [54] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/CustomerDownloadState_Status 
.const [55] = Utf8 progressCustomerDownload 
.const [56] = Utf8 I 
.const [57] = Utf8 de/audi/app/combi/bap/app/audio/system/AppConnectorSystem 
.const [58] = Class [57] 
.const [59] = Utf8 de/audi/app/combi/bap/AbstractCombiConnector 
.const [60] = Class [59] 
.const [61] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceSystem 
.const [62] = Class [61] 
.const [63] = Utf8 Code 
.const [64] = Utf8 <init> 
.const [65] = Utf8 (Lde/audi/app/combi/bap/app/audio/CombiModuleAudio;)V 
.const [66] = Utf8 updateCustomerDownloadState 
.const [67] = Utf8 (II)V 
.end class 

.version 50 0 
.class public super [113] 
.super [115] 

.method public annotation [117] : [118] 
    .attribute [116] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [18] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [116] .code stack 3 locals 2 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [19] 
L5:     aload_0 
L6:     getfield [14] 
L9:     invokevirtual [15] 
L12:    astore_2 
L13:    aload_2 
L14:    ifnull L39 
L17:    aload_0 
L18:    invokevirtual [16] 
L21:    iload_1 
L22:    invokevirtual [17] 
L25:    invokeinterface [23] 0 
L30:    astore_3 
L31:    aload_2 
L32:    iload_1 
L33:    aload_3 
L34:    invokeinterface [24] 0 
L39:    return 
L40:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [116] .code stack 12 locals 0 
L0:     getstatic [2] 
L3:     invokeinterface [25] 0 
L8:     new [26] 
L11:    dup 
L12:    iconst_0 
L13:    new [27] 
L16:    dup 
L17:    aload_0 
L18:    aload_1 
L19:    iload_2 
L20:    aload_3 
L21:    aload 4 
L23:    iload 5 
L25:    invokespecial [20] 
L28:    invokespecial [21] 
L31:    invokeinterface [28] 0 
L36:    pop 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [123] : [124] 
    .attribute [116] .code stack 6 locals 0 
L0:     iload 5 
L2:     iconst_1 
L3:     if_icmpeq L8 
L6:     iconst_2 
L7:     istore_2 
L8:     aload_0 
L9:     aload_1 
L10:    iload_2 
L11:    aload_3 
L12:    aload 4 
L14:    iload 5 
L16:    invokespecial [22] 
L19:    return 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [29] [30] 
.const [3] = Class [31] 
.const [4] = Class [32] 
.const [5] = Class [33] 
.const [6] = Class [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = InterfaceMethod [60] [61] 
.const [24] = InterfaceMethod [62] [63] 
.const [25] = InterfaceMethod [64] [65] 
.const [26] = Class [66] 
.const [27] = Class [67] 
.const [28] = InterfaceMethod [68] [69] 
.const [29] = Class [70] 
.const [30] = NameAndType [71] [72] 
.const [31] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [32] = Utf8 de/eso/widgets/preset/PresetManagerNAR$1 
.const [33] = Utf8 de/eso/widgets/preset/PresetManagerNAR 
.const [34] = Utf8 de/eso/widgets/preset/PresetManager 
.const [35] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [36] = Utf8 de/eso/widgets/preset/PresetStorageProvider 
.const [37] = Utf8 de/audi/tghu/hmi/evo/IPresetPopupData 
.const [38] = Utf8 de/audi/atip/preset/ITunerNARHandler 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [40] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [41] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [67] = Utf8 de/eso/widgets/preset/PresetManagerNAR$1 
.const [68] = Class [109] 
.const [69] = NameAndType [110] [111] 
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [71] = Utf8 hmiService 
.const [72] = Utf8 Lde/audi/tghu/hmi/evo/IHMIServiceEvo; 
.const [73] = Utf8 de/eso/widgets/preset/PresetManagerNAR 
.const [74] = Utf8 presetDefinitionReg 
.const [75] = Utf8 Lde/eso/widgets/preset/PresetDefinitionHandlerRegistry; 
.const [76] = Utf8 de/eso/widgets/preset/PresetDefinitionHandlerRegistry 
.const [77] = Utf8 getTunerNARHandler 
.const [78] = Utf8 ()Lde/audi/atip/preset/ITunerNARHandler; 
.const [79] = Utf8 de/eso/widgets/preset/PresetManagerNAR 
.const [80] = Utf8 getPresetStorageProvider 
.const [81] = Utf8 ()Lde/eso/widgets/preset/PresetStorageProvider; 
.const [82] = Utf8 de/eso/widgets/preset/PresetStorageProvider 
.const [83] = Utf8 getPersistedPresetPopupData 
.const [84] = Utf8 (I)Lde/audi/tghu/hmi/evo/IPresetPopupData; 
.const [85] = Utf8 de/eso/widgets/preset/PresetManager 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Lde/audi/tghu/hmi/evo/HMITerminalEvo;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [88] = Utf8 de/eso/widgets/preset/PresetManager 
.const [89] = Utf8 saveToPersistence 
.const [90] = Utf8 (I)V 
.const [91] = Utf8 de/eso/widgets/preset/PresetManagerNAR$1 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/eso/widgets/preset/PresetManagerNAR;Lde/audi/atip/preset/DefinitionRequest;ILjava/io/Serializable;Lde/audi/atip/hmi/model/PresetListRow;I)V 
.const [94] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (ZLjava/lang/Runnable;)V 
.const [97] = Utf8 de/eso/widgets/preset/PresetManager 
.const [98] = Utf8 responseDefineEvent 
.const [99] = Utf8 (Lde/audi/atip/preset/DefinitionRequest;ILjava/io/Serializable;Lde/audi/atip/hmi/model/PresetListRow;I)V 
.const [100] = Utf8 de/audi/tghu/hmi/evo/IPresetPopupData 
.const [101] = Utf8 getPreset 
.const [102] = Utf8 ()Lde/audi/atip/preset/Preset; 
.const [103] = Utf8 de/audi/atip/preset/ITunerNARHandler 
.const [104] = Utf8 presetSavedByPresetPopup 
.const [105] = Utf8 (ILde/audi/atip/preset/Preset;)V 
.const [106] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [107] = Utf8 getEventDispatcher 
.const [108] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [109] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [110] = Utf8 postEvent 
.const [111] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)Lde/esolutions/fw/util/commons/job/Job; 
.const [112] = Utf8 de/eso/widgets/preset/PresetManagerNAR 
.const [113] = Class [112] 
.const [114] = Utf8 de/eso/widgets/preset/PresetManager 
.const [115] = Class [114] 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/audi/tghu/hmi/evo/HMITerminalEvo;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [119] = Utf8 saveToPersistence 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 favoriteDefinitionChanged 
.const [122] = Utf8 (Lde/audi/atip/preset/DefinitionRequest;ILjava/io/Serializable;Lde/audi/atip/hmi/model/PresetListRow;I)V 
.const [123] = Utf8 responseDefineEvent 
.const [124] = Utf8 (Lde/audi/atip/preset/DefinitionRequest;ILjava/io/Serializable;Lde/audi/atip/hmi/model/PresetListRow;I)V 
.end class 

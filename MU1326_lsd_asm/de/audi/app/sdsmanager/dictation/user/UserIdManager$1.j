.version 50 0 
.class super [61] 
.super [63] 
.field private final synthetic [64] [65] 

.method [67] : [68] 
    .attribute [66] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     aload_2 
L7:     aload_3 
L8:     invokespecial [9] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 6 locals 0 
L0:     aload_2 
L1:     ifnull L60 
L4:     aload_2 
L5:     instanceof [2] 
L8:     ifeq L37 
L11:    aload_2 
L12:    checkcast [2] 
L15:    bipush 6 
L17:    new [13] 
L20:    dup 
L21:    aload_0 
L22:    getfield [8] 
L25:    aconst_null 
L26:    invokespecial [10] 
L29:    invokeinterface [14] 0 
L34:    goto L60 
L37:    aload_2 
L38:    checkcast [4] 
L41:    bipush 20 
L43:    new [15] 
L46:    dup 
L47:    aload_0 
L48:    getfield [8] 
L51:    aconst_null 
L52:    invokespecial [11] 
L55:    invokeinterface [16] 0 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public enum [71] : [72] 
    .attribute [66] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Field [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Class [33] 
.const [14] = InterfaceMethod [34] [35] 
.const [15] = Class [36] 
.const [16] = InterfaceMethod [37] [38] 
.const [17] = Utf8 org/dsi/ifc/bluetooth/DSIBluetooth 
.const [18] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiBluetoothListener 
.const [19] = Utf8 org/dsi/ifc/telephone/DSITelephone 
.const [20] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiTelephoneListener 
.const [21] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [22] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiBluetoothListener 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiTelephoneListener 
.const [37] = Class [57] 
.const [38] = NameAndType [58] [59] 
.const [39] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [40] = Utf8 this$0 
.const [41] = Utf8 Lde/audi/app/sdsmanager/dictation/user/UserIdManager; 
.const [42] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [43] = Utf8 <init> 
.const [44] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [45] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiBluetoothListener 
.const [46] = Utf8 <init> 
.const [47] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Lde/audi/app/sdsmanager/dictation/user/UserIdManager$1;)V 
.const [48] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$DsiTelephoneListener 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Lde/audi/app/sdsmanager/dictation/user/UserIdManager$1;)V 
.const [51] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [52] = Utf8 this$0 
.const [53] = Utf8 Lde/audi/app/sdsmanager/dictation/user/UserIdManager; 
.const [54] = Utf8 org/dsi/ifc/bluetooth/DSIBluetooth 
.const [55] = Utf8 setNotification 
.const [56] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [57] = Utf8 org/dsi/ifc/telephone/DSITelephone 
.const [58] = Utf8 setNotification 
.const [59] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [60] = Utf8 de/audi/app/sdsmanager/dictation/user/UserIdManager$1 
.const [61] = Class [60] 
.const [62] = Utf8 de/audi/app/sdsmanager/dictation/osgi/AbstractTrackerCustomizer 
.const [63] = Class [62] 
.const [64] = Utf8 this$0 
.const [65] = Utf8 Lde/audi/app/sdsmanager/dictation/user/UserIdManager; 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (Lde/audi/app/sdsmanager/dictation/user/UserIdManager;Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [69] = Utf8 addService 
.const [70] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [71] = Utf8 removeService 
.const [72] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 

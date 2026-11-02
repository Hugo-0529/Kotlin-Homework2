# Kotlin Homework2 心得報告素材

學號：113360112｜姓名：鄭世昕。此檔是報告素材，尚非正式 PDF。讀書會組員、時間、地點、照片與 GitHub 頁面截圖待本人提供或補拍。

## 功能與實作摘要

- **Lab4 Activity 點餐系統**：主畫面用 `ActivityResultLauncher` 開啟 `SecActivity`。第二頁輸入飲料名稱、選甜度與冰塊，以 `Bundle`／`Intent` 回傳；主畫面顯示點餐結果。空白飲料名稱會提示使用者。
- **Lab5 Fragment 生命週期觀測**：`ViewPager2` 與 `FragmentStateAdapter` 顯示三頁 Fragment。Activity 與 Fragment 的生命週期回呼使用 `Log.e` 記錄，滑動頁面時可在 Logcat 對照事件順序。
- **Lab6 訊息提示與互動**：五個按鈕分別觸發 Toast、含操作按鈕的 Snackbar、三按鈕 AlertDialog、列表 AlertDialog、單選 AlertDialog。

## Lab6 主要程式碼

檔案：`Lab6/app/src/main/java/com/example/lab6/MainActivity.kt`。

- `onCreate` 透過 `findViewById<Button>` 取得五個 UI 按鈕並設定 `setOnClickListener`；對應 ID 位於 `activity_main.xml`。
- Toast：`showToast("預設 Toast")` 呼叫 `Toast.makeText(..., Toast.LENGTH_SHORT).show()`。
- Snackbar：`Snackbar.make(...).setAction("按鈕") { showToast("已回應") }.show()`，操作按鈕有實際回應。
- 三按鈕對話框：`setNeutralButton`、`setNegativeButton`、`setPositiveButton` 各顯示相應結果。
- 列表對話框：`setItems(item)` 以選取索引取得項目文字並回傳 Toast。
- 單選對話框：`setSingleChoiceItems(item, 0)` 記錄 `position`，按「確定」後顯示選取項目；重新開啟時預設第一項。

Lab6 的主程式、XML 與 Manifest 沿用老師 Kotlin 範例；相容性修改集中在 Gradle 版本與測試相依套件。

## 程式碼優化心得

老師的 Lab6 已將重複的 Toast 建立程序收進 `showToast(msg: String)`，讓五種互動共用同一個顯示方式。對話框選項集中在 `arrayOf(...)`，列表與單選對話框使用相同資料，修改選項時比較不容易漏改。此次整理時先備份與比對來源，再調整 Gradle，使功能程式碼保持清楚，也能分辨是程式錯誤或建置工具版本問題。Lab5 使用 ViewPager2 的 adapter 集中決定三個 Fragment，生命週期記錄則各留在對應類別，方便查看 Logcat。

## Java 與 Kotlin 語法差異實例

| 用途 | Java 寫法 | 本次 Kotlin 寫法 |
| --- | --- | --- |
| 取得元件 | `Button button = findViewById(R.id.btnToast);` | `val btnToast = findViewById<Button>(R.id.btnToast)` |
| 點擊事件 | `button.setOnClickListener(v -> { ... });` | `btnToast.setOnClickListener { ... }` |
| 字串陣列 | `String[] items = {"選項 1", "選項 2"};` | `val item = arrayOf("選項 1", "選項 2")` |
| 字串插值 | `"你選的是" + items[i]` | `"你選的是${item[i]}"` |
| 空值處理 | `if (intent != null) intent.getStringExtra("drink")` | `intent?.getStringExtra("drink")` |

Kotlin 的 `val` 表示參照不能重新賦值，lambda 可簡化點擊監聽器，`?.` 可在物件為空時安全地回傳 null。這些例子分別出現在 Lab4、Lab6 的程式中。

## 建置、測試與畫面

- 三個 Lab 的 `:app:assembleDebug`：成功，包含 Kotlin 編譯與 AndroidManifest 處理。
- Lab4 模擬器測試：2/2 通過，含完整點餐資料回傳。
- Lab5 模擬器測試：2/2 通過，含三個 Fragment 頁面滑動。生命週期回呼已在程式碼中確認；如需報告展示，可另擷取 Logcat 畫面。
- Lab6 模擬器測試：9/9 通過，涵蓋 Toast、Snackbar 操作、三個對話框按鈕、五個列表選項及單選結果；`lintDebug` 成功。
- 模擬器：Pixel 7 Pro，Android 17。執行畫面保存在 [`screenshots/`](screenshots/)；測試 XML 報告由各 Lab 的 `app/build/outputs/androidTest-results/connected/debug/` 產生，屬本機建置產物，不上傳。

老師原始碼：<https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin>。作業 GitHub 目標：<https://github.com/Hugo-0529/Kotlin-Homework2>；請在遠端成功上傳後擷取 GitHub 頁面供 PDF 報告使用。

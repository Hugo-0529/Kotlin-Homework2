# 心得報告素材（非正式 PDF）

學號：113360112；姓名：鄭世昕。讀書會成員、日期、地點、照片待本人提供。

## 功能與實作摘要

- Lab4 現有版本：兩個 Activity 以 `ActivityResultLauncher` 與 `Intent`／`Bundle` 傳遞飲料、甜度、冰塊；目前程式是 Java，Kotlin 版尚待取得。
- Lab5 現有版本：Java 主畫面的按鈕可開啟三按鈕對話框、自訂 Toast 和列表對話框；它與本次要求的 Fragment 生命週期觀測不同，正確檔案尚待取得。
- Lab6：沿用老師的 Kotlin 範例。`MainActivity.kt` 在 `onCreate` 綁定五個按鈕；Toast 顯示短訊息；Snackbar 的 `setAction` 回應點擊；按鈕式 AlertDialog 的三個操作分別回傳 Toast；列表式用選項索引回傳文字；單選式以 `position` 記住選項，按確定後回傳。`activity_main.xml` 的五個 ID 均對應監聽器。

## 程式碼與優化心得

主要檔案：`Lab6/app/src/main/java/com/example/lab6/MainActivity.kt` 第 24–93 行。共用的 `showToast(msg: String)` 減少重複的 Toast 建立程式；`arrayOf` 集中保存五個對話框選項。這些寫法本來就在老師的範例中。這次只調整 Gradle／測試套件相容性，主功能程式碼、XML、Manifest 與老師下載版本相同。

實作心得：版本相容問題應先從建置設定與測試工具診斷，避免為了處理工具錯誤而重寫 UI。舊版 Espresso 在 Android 17 模擬器因 `InputManager.getInstance` 反射失敗；更新 Espresso 至 3.7.0 後，互動測試通過。原始檔案先做備份與雜湊比對，再整理副本，可確認課堂內容沒有遺失。

## Java 與 Kotlin 實際語法差異

現有 Lab5 Java 使用 `Button btn = findViewById(R.id.button);`，Lab6 Kotlin 使用 `val btnToast = findViewById<Button>(R.id.btnToast)`：Kotlin 以 `val` 宣告唯讀參照，型別可由泛型與右側推斷。Java 的 `new View.OnClickListener() { ... }`，Lab6 Kotlin 寫成 `setOnClickListener { ... }`，用 lambda 簡化單一方法介面的事件處理。現有 Lab5 Java 用 `final String[] list = {...}`；Lab6 Kotlin 用 `val item = arrayOf(...)`。

## 建置、測試與畫面

- Lab4、Lab5、Lab6 的 `:app:assembleDebug`：成功。
- Lab6 的 Android Studio Gradle Sync 與 `:app:lintDebug`：成功；Lint 留有過時相依套件與 XML 硬編碼文字等警告，無錯誤。
- Lab6 在 Pixel 7 Pro Android 17 模擬器上執行 9 項 instrumentation 測試：9 通過、0 失敗。覆蓋 Toast、Snackbar 操作、三種對話框操作與選擇結果。
- Lab4、Lab5 已啟動並截圖；功能互動尚未驗證，且來源與作業要求不一致。
- 截圖保存在 [`screenshots/`](screenshots/) 與本機 `C:\Users\hugoy\AndroidStudioProjects\Homework2-work\screenshots`，包括三個現有專案的主畫面與 Lab6 對話框。

預定 GitHub Repository：<https://github.com/Hugo-0529/Kotlin-Homework2>。建立與推送狀態須待 Lab4／Lab5 正確來源確認後更新。

# Kotlin Homework2

應用軟體實習作業｜學號：113360112｜姓名：鄭世昕

## 專案內容

- `Lab4/`：Kotlin Activity 點餐系統。輸入飲料並選擇甜度、冰塊，使用 `ActivityResultLauncher` 將結果回傳主畫面。
- `Lab5/`：Kotlin Fragment 生命週期觀測。以 ViewPager2 切換三個 Fragment，並將 Activity、Fragment 生命週期事件記錄到 Logcat。
- `Lab6/`：Kotlin 訊息提示與互動。包含 Toast、附操作按鈕的 Snackbar、三按鈕對話框、列表對話框及單選對話框。

三個資料夾各是獨立的 Android Studio 專案。使用 Android Studio 的 **Open** 分別開啟 `Lab4`、`Lab5` 或 `Lab6`，等待 Gradle Sync 後執行 `app`。也可在各資料夾執行 `gradlew.bat :app:assembleDebug`。

## 開發環境與驗證

Windows 11、Android Studio、JDK 21／Android Studio JBR、Android SDK API 37、Gradle 9.6、Android Gradle Plugin 9.4.1、Kotlin、AndroidX、Material Components。

三個 Lab 的 `:app:assembleDebug` 均成功。Pixel 7 Pro（Android 17）模擬器上，Lab4 點餐流程測試 2/2、Lab5 三頁滑動測試 2/2、Lab6 訊息元件測試 9/9 通過。Lab6 的 `:app:lintDebug` 也成功。測試涵蓋畫面互動；Lab5 的生命週期訊息可在 Logcat 以 `MainActivity`、`FirstFragment`、`SecondFragment`、`ThirdFragment` 篩選觀察。截圖位於 [`screenshots/`](screenshots/)，心得報告素材見 [`REPORT_MATERIALS.md`](REPORT_MATERIALS.md)。

Lab4 與 Lab5 使用老師提供的 Kotlin 範例，僅調整建置版本與加入驗證測試。Lab5 的安裝套件 ID 改為 `com.example.lab5.homework2`，避免覆蓋本機舊版 Java App。Lab6 保留老師的主程式、版面及 Manifest，調整 Gradle 與測試相依版本以支援目前環境。

老師原始碼：[MMSLAB-Android-Kotlin](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin)（[Lab4](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin/tree/master/Lab4)／[Lab5](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin/tree/master/Lab5)／[Lab6](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin/tree/master/Lab6)）。

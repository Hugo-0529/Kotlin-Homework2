# Kotlin Homework2

應用軟體實習作業。學號：113360112，姓名：鄭世昕。

## 專案

- `Lab4/`：Activity 點餐系統，可選擇飲料、甜度與冰塊，並把資料回傳主畫面。**目前找到的課堂版本使用 Java；Kotlin 版本尚待確認。**
- `Lab5/`：目前找到的課堂版本是 Java 的 Toast 與 AlertDialog 示範。**此版本並非題目要求的 Kotlin Fragment 生命週期觀測；正確的課堂專案尚待確認。**
- `Lab6/`：Kotlin 訊息提示元件，包含 Toast、可操作的 Snackbar、三按鈕／列表／單選 AlertDialog。沿用老師的主程式、版面與 Manifest。

各資料夾皆為可獨立開啟的 Android Studio 專案。使用 Android Studio 的 **Open** 分別選取 `Lab4`、`Lab5` 或 `Lab6`，等待 Gradle Sync，再執行 app。Windows 命令列可在各資料夾執行 `gradlew.bat :app:assembleDebug`。

## 環境與驗證

Windows 11、Android Studio 2026.1.4、JDK 21（Gradle Daemon 使用 Android Studio JBR 25）、Android SDK API 37、Gradle 9.6、Android Gradle Plugin 9.4.x、Kotlin、AndroidX、Material Components。

- 三個現有專案的 `assembleDebug` 均成功；這只證明目前檔案可建置，不能證明 Lab4／Lab5 已符合 Kotlin 作業要求。
- Lab6 的 Android Studio Gradle Sync、`assembleDebug`、`lintDebug` 成功。Pixel 7 Pro Android 17 模擬器的 9 項 instrumentation 測試全部通過（包含 8 項元件互動測試）。
- Lab4、Lab5 已在模擬器啟動畫面；課堂原始碼均完整保留。Lab4 點餐流程與 Lab5 的原始功能尚未做互動測試。

執行畫面保存在 [`screenshots/`](screenshots/)；Lab4、Lab5 的檔名標示了目前找到的 Java 版本。

老師範例：[MMSLAB-Android-Kotlin](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin)，本次 Lab6 參考其 [`Lab6/`](https://github.com/taipeitechmmslab/MMSLAB-Android-Kotlin/tree/master/Lab6)。

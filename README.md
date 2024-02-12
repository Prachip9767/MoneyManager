# Budgeter

![budgeter](https://user-images.githubusercontent.com/81345503/143840959-de951a01-ad5d-4379-b1c3-8bcfea32a64e.png)

# Links 
  <code>
    <a href="https://play.google.com/store/apps/details?id=com.application.budgeter" title="Playstore Profile"><img height="140" width="412" src="https://user-images.githubusercontent.com/81345503/143836980-d80acce1-1a5b-4d74-bd27-f479b3de0bd5.png"></a></code>

# 🔗Open-Source Library

* [MVVM-Architecture](https://developer.android.com/jetpack/guide)
* [Viewmodel-LiveData](https://developer.android.com/codelabs/basic-android-kotlin-training-livedata#0)
* [Room Database](https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase)
* [Dependency Injection-Hilt](https://developer.android.com/training/dependency-injection)
* [Coroutines](https://developer.android.com/kotlin/coroutines)


# Things we used while making this application
* MVVM-Architecture
* Room Database
* GitHub
* Recycler View
* Dependency Injection-Hilt

# Tech Stack ✨

* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)
* [MVVM-Architecture](https://developer.android.com/jetpack/guide)

# Clone this Repo To Your System Using Android Studio✨

* Step 1: Open your Android Studio then go to the File > New > Project from Version Control as shown in the below image.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise like below. In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.

# Clone this Repo To Your System Using GitBash✨

* Open Git Bash

* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.

* Go to the current directory where you want the cloned directory to be added.

* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.

* Go to the page of the repository that you want to clone

* Click on “Clone or download” and copy the URL.

* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/chekeAditya/Budgeter.git

* Press Enter. $ git clone https://github.com/chekeAditya/Budgeter.git Cloning into Git … remote: Counting objects: 13, done. remote: Compressing objects: 100% (13/13), done. remove: Total 13 (delta 1), reused 0 (delta 1) Unpacking objects: 100% (13/13), done.

Congratulations, you have created your first local clone from your remote Github repository.

Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.

# Dependencies 

      //Room
    implementation 'androidx.room:room-ktx:2.1.0'
    kapt 'androidx.room:room-compiler:2.1.0'

    //Coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'

    //LiveData
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0-alpha03'

    // ViewModel
    def arch_version = '2.2.0-alpha01'

    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //hilt
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-android-compiler:2.38.1"
    implementation 'androidx.fragment:fragment-ktx:1.2.5'
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.2.0"
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    implementation 'com.google.dagger:hilt-android:2.28-alpha'
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha01'
    kapt 'com.google.dagger:hilt-android-compiler:2.28-alpha'

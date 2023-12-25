# ReelsApp
a simple single screen app which shows list of Reels like Instagram.

Android Kottlin Application that build in clean archticture and best practisies


## summary
 In this Application we have 1 screen

Reels screen : that display a list of reels and can scroll between them.

In this branch you'll find:
*   User Interface built with **[Jetpack Compose](https://developer.android.com/jetpack/compose)** 
*   A presentation layer that contains a Compose screen (View) and a **ViewModel** per screen (or feature).
*   Reactive UIs using **[Flow](https://developer.android.com/kotlin/flow)** and **[coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** for asynchronous operations.
*   A **data layer** with a repository and one data sources (remote API).
*   A TDD unit tests by Mockk.
*   Dependency injection using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).


## Archticture
 We follow the [onion architicture](https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011)
 
 So we have 3 layers:
 
●	Domain layer: Would execute business logic which is independent of any layer and is just a pure kotlin package with no android specific dependency.

●	Data layer: Would dispense the required data for the application to the domain layer by implementing interface exposed by the domain

●	App layer:
Would include both domain and data layer and is android specific which executes the UI logic.

<img src="https://user-images.githubusercontent.com/8076006/232272370-c7f80389-d612-4bbb-a077-5cc2550e962e.jpg" width= "900">



## How much time it really took

|     Task     | Time |
| ------------- | ------------- |
| onion architicture | 1h |
| Reels Player | 1h |
| business Logic | 1h |
| UI | 2h|
| Unit Testing (TDD) | 1h |

## Screenshots

<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/5638f95c-ff9f-44f5-9432-02b8633f3467" width= "200">
<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/fcb6cb8d-c7ce-4f0c-be4e-33ac490d5146" width= "200">
<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/86ed2474-44b9-48b7-a703-28506a13dcda" width= "200">
<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/84c1e03e-157e-47a3-8bfc-09381e169a7b" width= "200">
<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/8686cb82-84b0-49d0-9e40-6b50e70e0c8a" width= "200">
<img src="https://github.com/ahmedshady68/ReelsApp/assets/8076006/ee6b0958-0544-474e-bade-efc8b0633efa" width= "200">


## API 

●	 [API url](https://api.usestoryteller.com/api/app/clips/clipssample/clips?ClientPlatform=Android&ClientVersion=9.2.0&x-storyteller-api-key=[get_your_api_key])

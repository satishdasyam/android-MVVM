# android-MVVM
This is an example to demonstrate MVVM

MVVM has mainly the following layers:

## Model
Model represents the data and business logic of the app. One of the recommended implementation strategies of this layer, is to expose its data through observables to be decoupled completely from ViewModel or any other observer/consumer (This will be illustrated in our MVVM sample app below).

## ViewModel
ViewModel interacts with model and also prepares observable(s) that can be observed by a View. ViewModel can optionally provide hooks for the view to pass events to the model. 
One of the important implementation strategies of this layer is to decouple it from the View, i.e, ViewModel should not be aware about the view who is interacting with.

## View
Finally, the view role in this pattern is to observe (or subscribe to) a ViewModel observable to get data in order to update UI elements accordingly.

# Android Helpful Links


https://blog.aritraroy.in/20-awesome-open-source-android-apps-to-boost-your-development-skills-b62832cf0fa4

https://blog.aritraroy.in/30-kickass-tools-to-develop-android-apps-like-a-pro-191e52b9419b

https://blog.aritraroy.in/15-tools-for-bulletproof-android-app-security-516bb8b1a8d5

https://blog.aritraroy.in/30-bite-sized-pro-tips-to-become-a-better-android-developer-b311fd641089

https://android-arsenal.com/



# RxJava/RxAndroid Helpful Links

https://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/

https://blog.aritraroy.in/the-missing-rxjava-2-guide-to-supercharge-your-android-development-part-1-624ef326bff4

https://www.androidhive.info/RxJava/rxjava-operators-introduction/

https://blog.gojekengineering.com/multi-threading-like-a-boss-in-android-with-rxjava-2-b8b7cf6eb5e2

http://upday.github.io/blog/mvvm_rx_common_mistakes/



# Git branching

https://nvie.com/posts/a-successful-git-branching-model/


## used libraries

android architecture components

Dagger2

RxJava, RxAndroid

Retrofit

Glide

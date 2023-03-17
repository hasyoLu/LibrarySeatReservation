package com.example.libraryseatreservation.repository



//// https://api.muxiaoguo.cn/api/sjbz?method=pc&type=sina
////随机壁纸
//fun retrofitPostImage(diaryLiveData : MutableLiveData<DailyData>){
//    val single: Single<ImageData> =
//        Retrofit.Builder()
//            .baseUrl("https://api.muxiaoguo.cn/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .client(getOkHttpClient())
//            .build()
//            .create(ApiService::class.java)
//            .apiPostImage()
//
//    single.subscribeOn(Schedulers.newThread())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(object  : SingleObserver<ImageData>{
//            override fun onSubscribe(d: Disposable?) {
//
//            }
//            override fun onSuccess(t: ImageData?) {
//                printLog("image  ${t?.imageData?.imgurl} " )
//                if(t != null){
//                    val dailyData = DailyData()
//                    dailyData.photo.set(t.imageData.imgurl)
//                    diaryLiveData.value = dailyData
//                }
//            }
//            override fun onError(e: Throwable?) {
//                printLog("error: ${e?.localizedMessage}")
//            }
//        })
//
//}
////https://api.muxiaoguo.cn/api/tianqi?city=西安&type=1
////天气
//fun retrofitPostWeather(diaryLiveData : MutableLiveData<DailyData>){
//    val single: Single<Weather> =
//        Retrofit.Builder()
//            .baseUrl("https://api.muxiaoguo.cn/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .client(getOkHttpClient())
//            .build()
//            .create(ApiService::class.java)
//            .apiPostWeather()
//
//    single.subscribeOn(Schedulers.newThread())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(object : SingleObserver<Weather>{
//            override fun onSubscribe(d: Disposable?) {
//
//            }
//
//            override fun onSuccess(t: Weather?) {
//                printLog("weather   ${t?.data?.weather}")
////                if(t != null){
////                    val dailyData = DailyData()
////                    dailyData.pm25.set(t.data.pm25)
////                    dailyData.sd.set(t.data.SD)
////                    dailyData.temp.set(t.data.temp)
////                    dailyData.weather.set(t.data.weather)
////                    dailyData.ws.set(t.data.WS)
////                    diaryLiveData.value = dailyData
////                }
//            }
//            override fun onError(e: Throwable?) {
//                printLog("weather   ${e?.localizedMessage}")
//            }
//        })
//}
////https://api.muxiaoguo.cn/api/lishijr
//fun retrofitPostLiShIjr(diaryLiveData : MutableLiveData<DailyData>){
//    val single: Single<Lishijr> =
//        Retrofit.Builder()
//            .baseUrl("https://api.muxiaoguo.cn/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .client(getOkHttpClient())
//            .build()
//            .create(ApiService::class.java)
//            .apiGetLiSh()
//
//    single.subscribeOn(Schedulers.newThread())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(object : SingleObserver<Lishijr>{
//            override fun onSubscribe(d: Disposable?) {
//
//            }
//            override fun onSuccess(t: Lishijr?) {
////                if(t != null){
////                    val dailyData = DailyData()
////                    dailyData.historyArray.addAll(t.data)
////                    diaryLiveData.value = dailyData
////                }
//            }
//            override fun onError(e: Throwable?) {
//
//            }
//        })
//}
//
//private fun getOkHttpClient(): OkHttpClient {
//    return OkHttpClient.Builder()
//        .connectTimeout(10, TimeUnit.SECONDS)
//        .readTimeout(10, TimeUnit.SECONDS)
//        .writeTimeout(10, TimeUnit.SECONDS)
//        .build()
//}
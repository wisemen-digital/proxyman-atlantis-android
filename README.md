# proxyman-atlantis-android
With this library calls made by an Android app can be logged to Proxyman on your mac.

## How does it work?

The following classes will manage the messages that need to be send to Proxyman.
### 1. ProxymanNetworkDiscoveryManager
This class will discover and connect to devices that are sending _proxyman.tcp over the network.

### 2. ProxymanInterceptor
This class inherits from the Okhttp3 interceptor class and will get request/response data of calls.
It will convert this data to the appropriate Proxyman Message type and will ask the ProxymanNetworkDiscoveryManager to send this package to the connected devices.

## Setup

### Register the ProxymanNetworkDiscoveryManager

You can register the ProxymanNetworkDiscoveryManager by adding the following code in your App class.

```kotlin
 ProxymanNetworkDiscoveryManager.registerService(
    context, // <-- App context
    deviceName,// <-- This string will be used as the name for your device in Proxyman. If you don't override it , it will try to create a name from your bluetooth name. You can check the logic in the Packages class.
    allowedServices,// <-- A list of strings. You can use this list to limit to which devices the ProxymanNetworkDiscoveryManager will connect. Something like "Mac book name.local".
    isLoggingEnabled// <-- Enabled/disables all loggers in the ProxymanNetworkDiscoveryManager.
)
```

**Note**: If you want to limit allowed services/devices, you can find the name of your Mac in Proxyman
Open Proxyman on your macbook and navigate to </br>
`Certificate > Install certificate on ios > With Atlantis… > Click on "how to start atlantis?" >  If you only want to connect to your Mac rather than colleague's Mac`


### Adding the ProxymanInterceptor to Retrofit/OkhttpClient

You will need to add the ProxymanInterceptor to your OkhttpClient.
After you do this don't forget to add your client to your Retrofit.

```kotlin
val builder = OkHttpClient.Builder()
builder.addInterceptor(ProxyManInterceptor())

val builder = Retrofit.Builder()
    .baseUrl("baseurl")
    .client(getHttpClient)
```







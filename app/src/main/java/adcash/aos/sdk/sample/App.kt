package adcash.aos.sdk.sample

import android.app.Application
import com.avatye.cashblock.unit.adcash.ADCashSDK

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ADCashSDK.initialize(
            context = this,
            appId = [YOUR_APP_ID],
            appSecret = [YOUR_APP_SECRET],
            storeUrl = [YOUR_APP_STORE_URL]
        )
    }

}
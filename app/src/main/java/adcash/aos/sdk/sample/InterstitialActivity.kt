package adcash.aos.sdk.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.avatye.cashblock.unit.adcash.AdError
import com.avatye.cashblock.unit.adcash.InterstitialAdType
import com.avatye.cashblock.unit.adcash.loader.InterstitialAdLoader


class InterstitialActivity : AppCompatActivity() {

    private var interstitialAdLoader: InterstitialAdLoader? = null
    var index = 0

    private var placementId = [YOUR_INTERSTITIAL_PLACEMENT_ID]

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)
        findViewById<Button>(R.id.buttonLoad).setOnClickListener {
            index++
            it.isEnabled = false
            findViewById<TextView>(R.id.pid).text = placementId
            findViewById<TextView>(R.id.interstitial_log).text = "#$index: Request...\n"
            interstitialAdLoader = InterstitialAdLoader(
                ownerActivity = this@InterstitialActivity,
                placementId = placementId,
                listener = object : InterstitialAdLoader.InterstitialListener {
                    override fun onLoaded(executor: InterstitialAdLoader.InterstitialExecutor, adType: InterstitialAdType) {
                        val interstitialLog = findViewById<TextView>(R.id.interstitial_log)
                        interstitialLog.text = interstitialLog.text.toString() + "#$index: onLoaded...\n"
                        executor.show()
                    }

                    override fun onOpened() {
                        val interstitialLog = findViewById<TextView>(R.id.interstitial_log)
                        interstitialLog.text = interstitialLog.text.toString() + "#$index: onOpened...\n"
                    }

                    override fun onClosed(completed: Boolean) {
                        it.isEnabled = true
                        val interstitialLog = findViewById<TextView>(R.id.interstitial_log)
                        interstitialLog.text = interstitialLog.text.toString() + "#$index: onClosed { complete: $completed }...\n"
                    }

                    override fun onFailed(error: AdError) {
                        it.isEnabled = true

                        val interstitialLog = findViewById<TextView>(R.id.interstitial_log)
                        interstitialLog.text = interstitialLog.text.toString() + "#$index: ondFailed: $error\n"
                    }

                    override fun onClicked() {
                        val interstitialLog = findViewById<TextView>(R.id.interstitial_log)
                        interstitialLog.text = interstitialLog.text.toString() + "#$index: onClicked...\n"
                    }
                }
            )
            interstitialAdLoader?.requestAd()
        }
    }

    override fun onResume() {
        super.onResume()
        interstitialAdLoader?.onResume()
    }

    override fun onPause() {
        super.onPause()
        interstitialAdLoader?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        interstitialAdLoader?.onDestroy()
    }
}
package adcash.aos.sdk.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.avatye.cashblock.unit.adcash.AdError
import com.avatye.cashblock.unit.adcash.BannerAdSize
import com.avatye.cashblock.unit.adcash.loader.BannerAdLoader

class BannerActivity : AppCompatActivity() {

    private var bannerAdLoader: BannerAdLoader? = null

    private var placementId = [YOUR_BANNER_PLACEMENT_ID]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID = R.layout.activity_banner)

        findViewById<TextView>(R.id.pid).text = placementId
        findViewById<TextView>(R.id.textFormLoader).text = "...."
        findViewById<Button>(R.id.buttonLoad).setOnClickListener {
            it.isEnabled = false
            findViewById<TextView>(R.id.textFormLoader).text = "...."
            bannerAdLoader = BannerAdLoader(
                context = this@BannerActivity,
                placementId = placementId,
                bannerAdSize = BannerAdSize.W320XH50,
                listener = object : BannerAdLoader.BannerListener {
                    override fun onLoaded(adView: View, size: BannerAdSize) {
                        findViewById<FrameLayout>(R.id.viewFormLoader).removeAllViews()
                        findViewById<FrameLayout>(R.id.viewFormLoader).addView(adView)
                        findViewById<TextView>(R.id.textFormLoader).text = "onLoaded"
                        Toast.makeText(this@BannerActivity, "Loader::onLoaded", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailed(error: AdError) {
                        it.isEnabled = true
                        findViewById<TextView>(R.id.textFormLoader).text = "onFailed(${error.errorMessage})"
                        Toast.makeText(this@BannerActivity, "onFailed::${error.errorMessage}", Toast.LENGTH_SHORT).show()
                    }

                    override fun onClicked() {
                        Toast.makeText(this@BannerActivity, "onClicked", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            bannerAdLoader?.requestAd()
        }
    }

    override fun onResume() {
        super.onResume()
        bannerAdLoader?.onResume()
    }

    override fun onPause() {
        super.onPause()
        bannerAdLoader?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        bannerAdLoader?.onDestroy()
    }
}
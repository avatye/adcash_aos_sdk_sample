package adcash.aos.sdk.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID = R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, BannerActivity::class.java))
        }
        findViewById<Button>(R.id.Interstitial).setOnClickListener {
            startActivity(Intent(this, InterstitialActivity::class.java))
        }

    }

}
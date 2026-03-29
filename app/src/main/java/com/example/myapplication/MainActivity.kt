package com.example.myapplication

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Mendeklarasikan variabel untuk setiap elemen UI
    private lateinit var btnSapa: Button
    private lateinit var btnReset: Button
    private lateinit var tvPesan: TextView
    private lateinit var tvNama: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Menghubungkan ke file XML

        // Menghubungkan variabel ke elemen di XML (pakai id yang sama)
        btnSapa  = findViewById(R.id.btnSapa)
        btnReset = findViewById(R.id.btnReset)
        tvPesan  = findViewById(R.id.tvPesan)
        tvNama   = findViewById(R.id.tvNama)

        // Aksi ketika tombol "Sapa Saya!" ditekan
        btnSapa.setOnClickListener {
            val nama = tvNama.text.toString() // Ambil teks nama

            // Tampilkan pesan sapaan
            tvPesan.text = "Halo, $nama! Semangat kuliah! 🎉"
            tvPesan.visibility = android.view.View.VISIBLE // Tampilkan teks

            // Animasi fade-in agar muncul dengan halus
            val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
            tvPesan.startAnimation(fadeIn)
        }

        // Aksi ketika tombol "Reset" ditekan
        btnReset.setOnClickListener {
            // Sembunyikan pesan kembali dengan animasi fade-out
            val fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
            tvPesan.startAnimation(fadeOut)
            tvPesan.visibility = android.view.View.INVISIBLE
        }
    }
}
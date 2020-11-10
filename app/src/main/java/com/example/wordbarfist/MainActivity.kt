package com.example.wordbarfist

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView2: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManage2 = GridLayoutManager(this@MainActivity, 5)
        mRecyclerView2 = findViewById(R.id.recyclerview2)
        mRecyclerView2.layoutManager = layoutManage2
        mRecyclerView2.adapter = RhymeAdapter(this@MainActivity)
    }
}



class RhymeAdapter(var context: Context) : RecyclerView.Adapter<RhymeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RhymeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.voice_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RhymeAdapter.ViewHolder, position: Int) {
        var array: Array<String> = context.resources.getStringArray(R.array.rhyme_array)


        holder.voicebutton.setText(array[position])

        holder.voicebutton.setOnClickListener{

            Toast.makeText(context,array[position],Toast.LENGTH_LONG).show()
            when(position)
            {
                0-> {
                     showDialog(array[0],0)
                }


            }
        }

    }

    private fun showDialog(title:String,position:Int) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_voice_whole_layout)
        val label = dialog.findViewById(R.id.title) as TextView
        label.text= title
        var mSoundPool: SoundPool?
        var audioAttributes: AudioAttributes? = null
        audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build()
        mSoundPool = SoundPool.Builder()
            .setMaxStreams(8)
            .setAudioAttributes(audioAttributes)
            .build()
        val backpin = dialog.findViewById(R.id.back_pin) as Button
        val backchi = dialog.findViewById(R.id.back_chi) as Button
        val backru = dialog.findViewById(R.id.back_ri) as Button
        val forwardpin = dialog.findViewById(R.id.forward_pin) as Button
        val forwardru = dialog.findViewById(R.id.forward_ri) as Button
        val forwardchi = dialog.findViewById(R.id.forward_chi) as Button
        val backshuan = dialog.findViewById(R.id.back_shun) as Button
        val forwardshuan = dialog.findViewById(R.id.forward_shun) as Button

        var intent = Intent(context, SingleWordActivity::class.java)


        backpin.setOnClickListener {
            intent.putExtra("position",1)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }
        backshuan.setOnClickListener {
            intent.putExtra("position",2)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }

        backchi.setOnClickListener {
            intent.putExtra("position",3)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }
        backru.setOnClickListener {
            intent.putExtra("position",4)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }
        forwardpin.setOnClickListener {
            intent.putExtra("position",5)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }

        forwardshuan.setOnClickListener {
            intent.putExtra("position",2)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }

        forwardchi.setOnClickListener {
            intent.putExtra("position",6)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }
        forwardru.setOnClickListener {
            intent.putExtra("position",7)
            intent.putExtra("rhyme",title)
            intent.putExtra("rhyme_array_position",position)
            ContextCompat.startActivity(context, intent,null)
        }
         dialog.show()

    }

    override fun getItemCount(): Int {
        return  context.resources.getStringArray(R.array.rhyme_array).size
    }

    class ViewHolder(val view: View) :  RecyclerView.ViewHolder(view) {

        val voicebutton = view.findViewById<Button>(R.id.voice_button)

    }

}



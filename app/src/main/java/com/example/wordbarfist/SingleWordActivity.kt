package com.example.wordbarfist

import android.app.Dialog
import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordbarfist.`interface`.voiceInterface

class SingleWordActivity : AppCompatActivity(),voiceInterface {
    private lateinit var title:TextView
    private lateinit var submsg:TextView
    private lateinit var voicetxt:TextView
    private lateinit var mRecyclerView: RecyclerView
    private var rhymepos:Int=0
    private var diaopos:Int=0
    lateinit var rhyme_eight_array:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singlewordactivity)
        title = findViewById(R.id.title)
        submsg = findViewById(R.id.submsg)
        voicetxt = findViewById(R.id.voice)
        rhymepos=intent.getIntExtra("rhyme_array_position",0)

        when(rhymepos)
        {
            0->{
                rhyme_eight_array=resources.getStringArray(R.array.rhyme_eight_un)
            }
        }


        diaopos= intent.getIntExtra("position",-1)
        when( intent.getIntExtra("position",-1))
        {
            1->{submsg.text=resources.getString(R.string.rhyme1)
                title.text=rhyme_eight_array[0]+diaopos}
            2->{submsg.text=resources.getString(R.string.rhyme2)
                title.text=rhyme_eight_array[0]+diaopos}
            3->{submsg.text=resources.getString(R.string.rhyme3)
                title.text=rhyme_eight_array[0]+diaopos}
            4->{submsg.text=resources.getString(R.string.rhyme4)
                title.text=rhyme_eight_array[0]+diaopos}
            5->{submsg.text=resources.getString(R.string.rhyme5)
                title.text=rhyme_eight_array[0]+diaopos}
            6->{submsg.text=resources.getString(R.string.rhyme6)
                title.text=rhyme_eight_array[0]+diaopos}
            7->{submsg.text=resources.getString(R.string.rhyme7)
                title.text=rhyme_eight_array[0]+diaopos}

        }
        mRecyclerView = findViewById(R.id.recyclerview)
        val layoutManage = GridLayoutManager(this@SingleWordActivity, 5)
        mRecyclerView.layoutManager = layoutManage
       val adapter = MainAdapter(this@SingleWordActivity)
        adapter.setvoicecallbck(this)
        mRecyclerView.adapter = adapter



    }

    class MainAdapter(var context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        var voiceinterface: voiceInterface? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.voice_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
            var mSoundPool: SoundPool? = null
            var audioAttributes: AudioAttributes? = null
            val array: Array<String> = context.resources.getStringArray(R.array.voice_array)


            audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()

            mSoundPool = SoundPool.Builder()
                .setMaxStreams(8)
                .setAudioAttributes(audioAttributes)
                .build()



            holder.voicebutton.setText(array[position])

            holder.voicebutton.setOnClickListener{

                Toast.makeText(context,array[position], Toast.LENGTH_LONG).show()
                when(position)
                {
                    0->{
                        voiceinterface!!.voicecallback(array[0],position)
                    }

                    1->{
                        voiceinterface!!.voicecallback(array[1],position)
                    }

                    2->{
                        voiceinterface!!.voicecallback(array[2],position)
                    }

                    3->{
                        voiceinterface!!.voicecallback(array[3],position)
                    }

                    4->{
                        voiceinterface!!.voicecallback(array[4],position)
                    }

                    5->{
                        voiceinterface!!.voicecallback(array[5],position)
                    }

                    6->{
                        voiceinterface!!.voicecallback(array[6],position)
                    }

                    7->{
                        voiceinterface!!.voicecallback(array[7],position)
                    }

                    8->{
                        voiceinterface!!.voicecallback(array[8],position)
                    }

                    9->{
                        voiceinterface!!.voicecallback(array[9],position)
                    }

                    10->{
                        voiceinterface!!.voicecallback(array[10],position)
                    }

                    11->{
                        voiceinterface!!.voicecallback(array[11],position)
                    }

                    12->{
                        voiceinterface!!.voicecallback(array[12],position)
                    }

                    13->{
                        voiceinterface!!.voicecallback(array[13],position)
                    }

                    14->{
                        voiceinterface!!.voicecallback(array[14],position)
                    }




                }
            }

        }

        fun setvoicecallbck(voice:voiceInterface)
        {
            this.voiceinterface=voice
        }

        override fun getItemCount(): Int {
            return 15
        }

        class ViewHolder(val view: View) :  RecyclerView.ViewHolder(view) {

            val voicebutton = view.findViewById<Button>(R.id.voice_button)

        }

        private fun showDialog(title:String) {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.dialog_voice_whole_layout)
            val label = dialog.findViewById(R.id.title) as TextView
            label.text= title
            dialog.show()

        }

    }

    class SubAdapter(var context: Context,rhymepos:Int,voicepos: Int,diaopos:Int) : RecyclerView.Adapter<SubAdapter.ViewHolder>() {
        var rhymepos=rhymepos
        var diaopos=diaopos
        var voicepos=voicepos
        var RhymeId =0
        var mSoundPool: SoundPool? = null
        var audioAttributes: AudioAttributes? = null


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rhyme_item, parent, false)

            return ViewHolder(view)
         }

        override fun getItemCount(): Int {
         return 1
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
            mSoundPool = SoundPool.Builder()
                .setMaxStreams(8)
                .setAudioAttributes(audioAttributes)
                .build()

            Log.d("pos",""+rhymepos)
            Log.d("pos",""+diaopos)
            Log.d("pos",""+voicepos)
            when(rhymepos)
            {
                0->{
                    when(voicepos)
                    {

                        0->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun1liu1,1)
                            holder.explain.text=context.resources.getString(R.string.lun)
                            holder.content.text=context.resources.getString(R.string.content_lun)
                        }

                        1->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun2ben1,1)
                            holder.explain.text=context.resources.getString(R.string.pun)
                            holder.content.text=context.resources.getString(R.string.content_pun)
                        }

                        2->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun3giu1,1)
                            holder.explain.text=context.resources.getString(R.string.kun)
                            holder.content.text=context.resources.getString(R.string.content_kun)
                        }

                        3->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun4ki1,1)
                            holder.explain.text=context.resources.getString(R.string.khun)
                            holder.content.text=context.resources.getString(R.string.content_khun)
                        }

                        4->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun5de1,1)
                            holder.explain.text=context.resources.getString(R.string.tun)
                            holder.content.text=context.resources.getString(R.string.content_tun)
                        }

                        5->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun6po1,1)
                            holder.explain.text=context.resources.getString(R.string.phun)
                            holder.content.text=context.resources.getString(R.string.content_phun)
                        }

                        6->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun7ta1,1)
                            holder.explain.text=context.resources.getString(R.string.thun)
                            holder.content.text=context.resources.getString(R.string.content_thun)
                        }

                        7->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun8tsin1,1)
                            holder.explain.text=context.resources.getString(R.string.tsun)
                            holder.content.text=context.resources.getString(R.string.content_tsun)

                        }

                        8->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun9dzip1,1)
                            holder.explain.text=context.resources.getString(R.string.jun)
                            holder.content.text=context.resources.getString(R.string.content_jun)

                        }

                        9->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun10si1,1)
                            holder.explain.text=context.resources.getString(R.string.siun)
                            holder.content.text=context.resources.getString(R.string.content_siun)


                        }

                        10->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun11in1,1)
                            holder.explain.text=context.resources.getString(R.string.uun)
                            holder.content.text=context.resources.getString(R.string.content_uun)


                        }

                        11->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun12bun1,1)
                            holder.explain.text=context.resources.getString(R.string.bun)
                            holder.content.text=context.resources.getString(R.string.content_bun)

                        }

                        12->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun13gi1,1)
                            holder.explain.text=context.resources.getString(R.string.gun)
                            holder.content.text=context.resources.getString(R.string.content_gun)

                        }

                        13->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun14tsut1,1)
                            holder.explain.text=context.resources.getString(R.string.cihun)
                            holder.content.text=context.resources.getString(R.string.content_cihun)
                        }

                        14->{

                            RhymeId = mSoundPool!!.load(context,R.raw.kun15hi1,1)
                            holder.explain.text=context.resources.getString(R.string.hun)
                            holder.content.text=context.resources.getString(R.string.content_hun)
                        }

                    }
                }
            }

            holder.soundButton.setOnClickListener {

                mSoundPool!!.play(RhymeId, 1F,1F,0,0,1F)


            }

        }


        class ViewHolder(val view: View) :  RecyclerView.ViewHolder(view) {

            val soundButton = view.findViewById<Button>(R.id.soundbtn)
            val explain = view.findViewById<TextView>(R.id.explain_txt)
            val content = view.findViewById<TextView>(R.id.content_txt)

        }



    }

    override fun voicecallback(voice: String,voicepos:Int) {

       title.text=title.text.toString()+voice
        voicetxt.visibility=View.GONE
        val adapter = SubAdapter(this@SingleWordActivity,rhymepos,voicepos,diaopos)
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter=adapter

     }

}
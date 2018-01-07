package com.arover.diffdemo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_item_conversation.view.*
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author arover
 * created at 06/01/2018 15:57
 */


class DemoDataAdapter(context: Context) : RecyclerView.Adapter<DemoDataAdapter.ViewHolder>() {

    var conversations: ArrayList<Conversation> = ArrayList(6)
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private lateinit var activity: Activity

    fun setActivity(activity: Activity) {
        this.activity = activity
    }

    fun genDemoData(): ArrayList<Conversation> {

        for (n in 0..6) {
            conversations.add(Conversation(n.toLong(),
                    DemoDataFactory.genRandomName(),
                    DemoDataFactory.genRandomAvatar(),
                    DemoDataFactory.genRandomTitle(),
                    ""))
        }
        return conversations
    }

    fun genNewDemoData(): ArrayList<Conversation> {
        var list = ArrayList<Conversation>()
        (0..6).mapTo(list) {
            Conversation(it.toLong(),
                    DemoDataFactory.genRandomName(),
                    DemoDataFactory.genRandomAvatar(),
                    DemoDataFactory.genRandomTitle(),
                    "")
        }
        return list
    }

    fun updateDemoData(oldList: ArrayList<Conversation>): ArrayList<Conversation> {
        var newList: ArrayList<Conversation> = ArrayList()

        for (n in 0 until oldList.size) {
            newList.add(oldList[n].clone() as Conversation)
//            newList[n].avatarUrl = DemoDataFactory.genRandomAvatar()
//            newList[n].contentPreview = DemoDataFactory.genRandomTitle()
        }
        return newList
    }

    fun changeDemoData(list: ArrayList<Conversation>){
        val random = Random()
//        val x = random.nextInt(list.size)
//        val y = random.nextInt(list.size)
//        Log.d(TAG,"changeDemoData x=$x , y= $y")
        list.add(0,Conversation(random.nextLong(),
                        DemoDataFactory.genRandomName(),
                        DemoDataFactory.genRandomAvatar(),
                        DemoDataFactory.genRandomTitle(),
                        ""))
//        list[y] =
//                Conversation(x.toLong(),
//                        DemoDataFactory.genRandomName(),
//                        DemoDataFactory.genRandomAvatar(),
//                        DemoDataFactory.genRandomTitle(),
//                        "")
    }

    fun swapDemoData(list: ArrayList<Conversation>){

        val random = Random()
        val x = random.nextInt(list.size)
        val y = random.nextInt(list.size)
        Log.d(TAG,"changeDemoData x=$x , y= $y")

        list[x]=Conversation(y.toLong(),
                DemoDataFactory.genRandomName(),
                DemoDataFactory.genRandomAvatar(),
                DemoDataFactory.genRandomTitle(),
                "")

        list[y] =Conversation(x.toLong(),
                DemoDataFactory.genRandomName(),
                DemoDataFactory.genRandomAvatar(),
                DemoDataFactory.genRandomTitle(),
                "")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = conversations[position]
        holder.bind(item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.list_item_conversation, parent, false))
    }

    companion object {

        private val TAG: String = "DDA"
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        Log.d(TAG, "onBindViewHolder")
        if(payloads.isEmpty()){
            onBindViewHolder(holder, position)
            return
        }

        val diff: Bundle = payloads[0] as Bundle
        for(key:String in diff.keySet()){
            when(key){
                ConversationCallback.KEY_AVATAR_URL ->
                    Glide.with(activity)
                            .load(diff.getString(ConversationCallback.KEY_AVATAR_URL))
                            .apply(RequestOptions.centerCropTransform())
                            .into(holder.itemView.avatar)

                ConversationCallback.KEY_CONTENT_PREVIEW ->
                    holder.itemView.message_content_preview.text = diff.getString(ConversationCallback.KEY_CONTENT_PREVIEW)

                ConversationCallback.KEY_USERNAME ->
                    holder.itemView.username.text = diff.getString(ConversationCallback.KEY_USERNAME)

                else ->{
                    Log.w(TAG,"unknown key")
                }
            }

        }


    }

    override fun getItemCount(): Int {
        return conversations.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Conversation) {
            itemView.username.text = item.username
            itemView.message_content_preview.text = item.contentPreview
            Glide.with(activity)
                    .load(item.avatarUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(itemView.avatar)
        }
    }

    fun setData(cons: ArrayList<Conversation>) {
        conversations = cons
    }

}


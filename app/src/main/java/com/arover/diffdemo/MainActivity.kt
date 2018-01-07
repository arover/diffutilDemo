package com.arover.diffdemo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DemoDataAdapter

    @SuppressWarnings("HandlerLeak")
    val handler: Handler = object:Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager=LinearLayoutManager(this)
        adapter = DemoDataAdapter(this)
        adapter.setActivity(this)
        list.adapter = adapter
        list.setHasFixedSize(true)
        list.itemAnimator = null
//        if(list.itemAnimator is SimpleItemAnimator){
//            (list.itemAnimator as SimpleItemAnimator).supportsChangeAnimations=false
//        }

        refreshBtn.setOnClickListener({
            val newList = adapter.updateDemoData(adapter.conversations)
            adapter.changeDemoData(newList)
            adapter.conversations = newList
            adapter.notifyDataSetChanged()
        })

        updateBtn.setOnClickListener({
            Thread{
                val newList = adapter.updateDemoData(adapter.conversations)
                val ran =  Random()
//                if(ran.nextBoolean()) {
//                    adapter.changeDemoData(newList)
//                }else{
                    adapter.swapDemoData(newList)
//                }
                Log.d("DDA","old list"+adapter.conversations)
                Log.d("DDA","new list"+newList)
                val result = DiffUtil.calculateDiff(ConversationCallback(adapter.conversations, newList),true)
                handler.post({
                    adapter.conversations.clear()
                    adapter.conversations.addAll(newList)
                    result.dispatchUpdatesTo(adapter)
                    list.scrollToPosition(0)
                })
            }.start()
        })
        swipeRefreshLayout.setOnRefreshListener {
            var cons = adapter.genNewDemoData()
            adapter.setData(cons)
            adapter.notifyDataSetChanged()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    fun refreshList(){
        adapter.conversations = adapter.genDemoData()
        list.adapter.notifyDataSetChanged()
    }
}


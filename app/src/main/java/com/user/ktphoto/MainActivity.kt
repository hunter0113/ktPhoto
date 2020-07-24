package com.user.ktphoto

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter:MainAdapter
    var items: MutableList<Photo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initData()
        mainfun ()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.add -> {
                var addname:String=""
                var addurl:String=""
                var addcontent:String=""
                //跳出新增視窗
                val ad = AlertDialog.Builder(this)
                ad.setTitle("新增日誌")
                ad.setMessage("輸入景點名稱")
                val input = EditText(this)
                ad.setView(input)
                ad.setPositiveButton("下一步") { _, _ ->
                    //儲存name
                    addname = input.text.toString()

                    val ad = AlertDialog.Builder(this)
                    ad.setTitle("新增日誌")
                    ad.setMessage("輸入url")
                    val input = EditText(this)
                    ad.setView(input)
                    ad .setPositiveButton("下一步") { _, _ ->
                        //儲存url
                        addurl = input.text.toString()
                        val ad = AlertDialog.Builder(this)
                        ad.setTitle("新增日誌")
                        ad.setMessage("輸入內容")
                        val input = EditText(this)
                        ad.setView(input)
                        ad .setPositiveButton("確認") { _, _ ->
                            //儲存內容
                            addcontent = input.text.toString()

                            if (addname!=null && addurl!=null && addcontent!=null) {
                                items.add(Photo().apply {
                                    title = addname
                                    url = addurl; width = 640f;height = 400f;
                                    introduction = addcontent
                                })
                                recyclerView.adapter!!.notifyDataSetChanged()
                            }
                        }
                        ad.show()
                    }
                    ad.show()
                }
                ad.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initData(){

        items.add(Photo().apply {
            title = getString(R.string.Title_1)
            url = "http://3.bp.blogspot.com/-02uTAvxiPkk/VpZPotFdKCI/AAAAAAAAenQ/vuO2KPDvdI0/s1600/01.jpg";width=1024f;height=490f;
            introduction = getString(R.string.Introduction_1)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_2)
            url = "http://4.bp.blogspot.com/-N2tzPp2-9fU/VpZPpc5e37I/AAAAAAAAenY/tWvx6NZ5BkY/s1600/02.jpg";width=1024f;height=682f;
            introduction = getString(R.string.Introduction_2)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_3)
            url = "http://2.bp.blogspot.com/-PfEF5w7YZ5Q/VpZPpoujmEI/AAAAAAAAenc/q9HuTko5wLU/s1600/03.jpg";width=720f;height=540f;
            introduction = getString(R.string.Introduction_3)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_4)
            url = "http://1.bp.blogspot.com/-ZzMkQ_k1n-s/VpZPqWhrmVI/AAAAAAAAeno/KSUM9PryrzA/s1600/05.jpg";width=861f;height=330f;
            introduction = getString(R.string.Introduction_4)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_5)
            url = "http://1.bp.blogspot.com/-4VRf8hMq9V4/VpZPqgSA_5I/AAAAAAAAenw/biwG16rjVeM/s1600/06.jpg";width=600f;height=400f;
            introduction = getString(R.string.Introduction_5)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_6)
            url = "http://4.bp.blogspot.com/-KEMojNwwxec/VpZPsDuSO4I/AAAAAAAAeoY/hnV9TNC6Z8E/s1600/11.jpg";width=1024f;height=679f;
            introduction = getString(R.string.Introduction_6)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_7)
            url = "http://2.bp.blogspot.com/-eSfZRKZlrhY/VpZPsryI8yI/AAAAAAAAeog/IFaaYKNPK2s/s1600/13.jpg";width=787f;height=588f;
            introduction = getString(R.string.Introduction_7)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_8)
            url = "http://3.bp.blogspot.com/-8VNfrR83p8I/VpZPuSuHCsI/AAAAAAAAepI/tHXevvhH72s/s1600/16.jpg";width=610f;height=947f;
            introduction = getString(R.string.Introduction_8)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_9)
            url = "http://4.bp.blogspot.com/-rGdqc7_IQzY/VpZPuovJ8qI/AAAAAAAAepM/Z5CAPrqqV4o/s1600/18.jpg";width=700f;height=468f;
            introduction = getString(R.string.Introduction_9)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_10)
            url = "http://3.bp.blogspot.com/-0pqdn6fv2e4/VpZPvtaRV5I/AAAAAAAAepk/2VgmM_vfgjA/s1600/21.jpg";width=693f;height=460f;
            introduction = getString(R.string.Introduction_10)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_11)
            url = "http://3.bp.blogspot.com/-qiU5JRM75DM/VpZPyGiytAI/AAAAAAAAeqo/5qEvvFUV7RU/s1600/30.jpg";width=500f;height=375f;
            introduction = getString(R.string.Introduction_11)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_12)
            url = "http://3.bp.blogspot.com/--YNyZEPSFmQ/VpZPz-Rt79I/AAAAAAAAerA/SvfCoUXGG4M/s1600/35.jpg";width=800f;height=450f;
            introduction = getString(R.string.Introduction_12)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_13)
            url = "http://3.bp.blogspot.com/-BnOqu_Ycq68/VpZPrLyfPRI/AAAAAAAAen8/S_R2ZfKimaQ/s1600/07.jpg";width=1024f;height=682f;
            introduction = getString(R.string.Introduction_13)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_14)
            url = "http://3.bp.blogspot.com/-UcXw0YErg-0/VpZP0USOHSI/AAAAAAAAerI/-79hYqlQ_SA/s1600/36.jpg";width=630f;height=422f;
            introduction = getString(R.string.Introduction_14)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_15)
            url = "http://1.bp.blogspot.com/-iVMO8qiuKfU/VpZPzTnaKrI/AAAAAAAAeq8/1COLBSFkRqs/s1600/33.jpg";width=1024f;height=683f;
            introduction = getString(R.string.Introduction_15)
        })
        items.add(Photo().apply {
            title = getString(R.string.Title_16)
            url = "http://3.bp.blogspot.com/-NVupids4dPM/VpZP3WX48uI/AAAAAAAAesM/j-ESVgHk2uo/s1600/44.jpg";width=630f;height=422f;
            introduction = getString(R.string.Introduction_16)
        })
    }
    private fun mainfun (){
        mainAdapter = MainAdapter(items,this)
        recyclerView.adapter = mainAdapter
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager

        val decoration = CustomDecoration()
        recyclerView.addItemDecoration(decoration)
    }
}
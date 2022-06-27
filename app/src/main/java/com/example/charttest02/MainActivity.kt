package com.example.charttest02

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener


class MainActivity : AppCompatActivity(), OnChartValueSelectedListener {

    private lateinit var chart: BarChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chart = findViewById(R.id.chart1)
        chart.apply {
            setOnChartValueSelectedListener(this@MainActivity)
            description.text = "Title"
            setNoDataText("No Data")
            setDrawValueAboveBar(true)

            setPinchZoom(true)

            setDrawBarShadow(false)
            setScaleEnabled(false)
            isDoubleTapToZoomEnabled = true
//            getAxis()
        }

    }

    fun setData(num: Int) {
        val xVals = ArrayList<IBarDataSet>()

//        BarDataSet()

//        for (i in 0 until num) {
//            xVals.add("小谢$i")
//        }

        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(4f, 0f))
        entries.add(BarEntry(8f, 1f))
        entries.add(BarEntry(6f, 2f))
        entries.add(BarEntry(12f, 3f))
        entries.add(BarEntry(18f, 4f))
        entries.add(BarEntry(9f, 5f))

        val depenses = BarDataSet(entries, "depenses")


        val yVals1 = ArrayList<BarEntry>()
        val yVals2 = ArrayList<BarEntry>()
        val yVals3 = ArrayList<BarEntry>()
        for (i in 0 until num) {
            val `val` = (Math.random() * num).toFloat()
            yVals1.add(BarEntry(`val`, i.toFloat()))
        }
        for (i in 0 until num) {
            val `val` = (Math.random() * num).toFloat()
            yVals2.add(BarEntry(`val`, i.toFloat()))
        }
        for (i in 0 until num) {
            val `val` = (Math.random() * num).toFloat()
            yVals3.add(BarEntry(`val`, i.toFloat()))
        }

//        // create 3 datasets with different types
//        val set1 = BarDataSet(yVals1, "一季度")
//        // set1.setColors(ColorTemplate.createColors(getApplicationContext(),
//        // ColorTemplate.FRESH_COLORS));
//        set1.color = Color.rgb(104, 241, 175)
//        val set2 = BarDataSet(yVals2, "二季度")
//        set2.color = Color.rgb(164, 228, 251)
//        val set3 = BarDataSet(yVals3, "三季度")
//        set3.color = Color.rgb(242, 247, 158)
//        val dataSets = ArrayList<IBarDataSet>()
//        dataSets.add(set1)
//        dataSets.add(set2)
//        dataSets.add(set3)
//        val data = BarData(xVals, dataSets)
//        // data.setValueFormatter(new LargeValueFormatter());
//
//        // add space between the dataset groups in percent of bar-width
//        data.setValueFormatter(CustomerValueFormatter())
//        data.setDrawValues(true)
//        data.setValueTextColor(Color.BLACK)
//        data.setValueTextSize(13f)
//        data.setGroupSpace(80f) //设置组数据间距
//        //data.setValueTypeface(tf);
//        mChart.setData(data)
//        mChart.animateXY(800, 800) //图表数据显示动画
//        mChart.setVisibleXRangeMaximum(15) //设置屏幕显示条数
//        mChart.invalidate()
    }


    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }
}
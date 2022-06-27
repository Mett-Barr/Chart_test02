package com.example.charttest02

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlin.random.Random


class MainActivity : AppCompatActivity(), OnChartValueSelectedListener {

    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart
    private lateinit var pieChart: PieChart
    private lateinit var bt: Button
    var chartState = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiInit()
    }

    private fun uiInit() {
        setBarChart()
        setLineChart()
        setPieChart()

        bt = findViewById(R.id.button2)
        bt.setOnClickListener {
            chartState = when (chartState) {
                0 -> {
                    barChart.visibility = View.INVISIBLE
                    lineChart.visibility = View.VISIBLE
                    1
                }
                1 -> {
                    lineChart.visibility = View.INVISIBLE
                    pieChart.visibility = View.VISIBLE
                    2
                }
                else -> {
                    pieChart.visibility = View.INVISIBLE
                    barChart.visibility = View.VISIBLE
                    0
                }
            }
        }
    }

    private fun setBarChart() {
        barChart = findViewById(R.id.bar_chart)
        barChart.apply {
            setOnChartValueSelectedListener(this@MainActivity)
            description.text = "Title"
            setNoDataText("No Data")
            setDrawValueAboveBar(true)

            setPinchZoom(true)

            setBackgroundColor(Color.WHITE)
            setDrawBarShadow(false)
            setScaleEnabled(false)
            isDoubleTapToZoomEnabled = true
//            getAxis()


            // 获取 X 轴
            barChart.xAxis.enableGridDashedLine(10f, 10f, 0f)

            barChart.axisLeft.apply {
                enableGridDashedLine(10f, 10f, 0f)
                axisMaximum = 200f
                axisMaximum = -50f
            }

            axisRight.isEnabled = false
        }

        setBarData()
    }

    private fun setBarData() {
        val entries: ArrayList<BarEntry> = ArrayList()

        entries.add(BarEntry(0f, 30f))
        entries.add(BarEntry(1f, 80f))
        entries.add(BarEntry(2f, 60f))
        entries.add(BarEntry(3f, 50f))
        entries.add(BarEntry(4f, 70f))
        entries.add(BarEntry(5f, 60f))

        val set = BarDataSet(entries, "")
        set.color = Color.rgb(155, 155, 155)
        set.valueTextColor = Color.rgb(155, 155, 155)

        barChart.data = BarData(set)
    }


    /**  Line   */
    private fun setLineChart() {
        lineChart = findViewById(R.id.line_chart)
        lineChart.apply {

        }

        setLineData()
    }

    private fun setLineData() {
        val entries: MutableList<Entry> = ArrayList()
        for (i in 0..11) entries.add(Entry(i.toFloat(), (10..100).random().toFloat()))

        val dataSet = LineDataSet(entries, "Line Chart")
        val lineData = LineData(dataSet)

        lineChart.data = lineData
    }



    /**  Pie   */
    private fun setPieChart() {
        pieChart = findViewById(R.id.pie_chart)

        setPieData()
    }

    private fun setPieData() {
        val entries: MutableList<PieEntry> = ArrayList()
        entries.apply {
            add(PieEntry(56f, "boy"))
            add(PieEntry(44f, "girl"))
        }

        val dataSet = PieDataSet(entries, "Label")
        dataSet.setColors(Color.BLUE, Color.RED)


        val pieData = PieData(dataSet)

        pieChart.data = pieData
    }


    override fun onValueSelected(e: Entry?, h: Highlight?) {
    }

    override fun onNothingSelected() {
    }
}
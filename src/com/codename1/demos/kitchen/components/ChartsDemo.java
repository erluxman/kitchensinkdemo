package com.codename1.demos.kitchen.components;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.models.XYSeries;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.BarChart;

import java.util.ArrayList;

public class ChartsDemo {
    public static  ChartComponent getBarChartDemo(){
        ArrayList<XYSeries> barChartSeries = new ArrayList<>();

        barChartSeries.add(new XYSeries("Laxman", 10));
        barChartSeries.add(new XYSeries("Shai", 20));
        barChartSeries.add(new XYSeries("Steve", 30));
        barChartSeries.add(new XYSeries("Zuke", 40));


        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addAllSeries(barChartSeries);

        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        //DefaultRenderer renderer = new DefaultRenderer();
        renderer.setXAxisMin(0);

        SimpleSeriesRenderer r1 = new SimpleSeriesRenderer();
        r1.setColor(ColorUtil.MAGENTA);
        renderer.addSeriesRenderer(r1);

        BarChart barChart = new BarChart(dataset, renderer, BarChart.Type.DEFAULT);
        return new ChartComponent(barChart);
    }
}

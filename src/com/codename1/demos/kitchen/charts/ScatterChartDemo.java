package com.codename1.demos.kitchen.charts;

import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PointStyle;
import com.codename1.charts.views.ScatterChart;
import com.codename1.ui.Component;

import java.util.Random;

public class ScatterChartDemo extends AbstractDemoChart {

    public Component execute() {
        XYMultipleSeriesDataset dataSet;
        Random r = new Random();
        double[] xValues = new double[20];
        double[] yValues = new double[20];
        for (int i = 0; i < 20; i++) {
            xValues[i] = i + r.nextInt() % 10;
            yValues[i] = i * 2 + r.nextInt() % 10;
        }
        dataSet = buildDataset("Average Score", xValues, yValues);
        XYMultipleSeriesRenderer renderer = buildRenderer(ColorUtil.BLUE, PointStyle.X);
        initRendererer(renderer);
        return newChart(new ScatterChart(dataSet, renderer));
    }
}

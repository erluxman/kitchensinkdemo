package com.codename1.demos.kitchen.componentdemos.charts;

import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.LineChart;
import com.codename1.charts.views.PointStyle;
import com.codename1.ui.Component;

import java.util.Arrays;
import java.util.List;

public class LineChartDemo extends AbstractDemoChart {

    @Override
    public Component execute() {
        List<double[]> x = Arrays.asList(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        List<double[]> values = Arrays.asList(new double[]{12.3, 12, 13, 16.8, 20.4, 24.4, 26.4, 11, 23.6, 20.3, 17, 13.9});
        XYMultipleSeriesDataset dataSet = buildDataset(new String[]{"Air temperature"}, x, values);

        int[] colors = new int[]{ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE};
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(1);
        renderer.setYTitle("Avg Temperature", 0);
        renderer.setXTitle("Month");
        setRenderer(renderer, colors, styles);
        initRendererer(renderer);
        return newChart(new LineChart(dataSet, renderer));
    }
}

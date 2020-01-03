package com.codename1.demos.kitchen.charts;

import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.BarChart;
import com.codename1.ui.Component;

import java.util.Arrays;
import java.util.List;

public class BarChartDemo extends AbstractDemoChart {
    public Component execute() {
        List<double[]> values = Arrays.asList(new double[]{5230, 7300, 9240, 10540, 7900, 9200, 12030, 11200, 9500, 10500,
                11600, 13500});

        XYMultipleSeriesRenderer renderer = buildBarRenderer(new int[]{ColorUtil.CYAN});
        setChartSettings(renderer, "Monthly sales last year", "Month", "Units sold", 0.5,
                12.5, 0, 24000, ColorUtil.GRAY, ColorUtil.LTGRAY);
        renderer.setXLabels(12);
        renderer.setBarSpacing(0.5f);
        renderer.setYLabels(10);
        initRendererer(renderer);

        BarChart chart = new BarChart(buildBarDataset(new String[]{"Sales"}, values), renderer, BarChart.Type.DEFAULT);
        return newChart(chart);
    }
}

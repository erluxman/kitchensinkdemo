package com.codename1.demos.kitchen.charts;

import com.codename1.charts.models.MultipleCategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.DoughnutChart;
import com.codename1.ui.Component;

public class DonutChartDemo extends AbstractDemoChart {

    public Component execute() {
        double[] values = new double[]{10, 9, 14, 20, 11};
        String[] titles = new String[]{"P1", "P2", "P3", "P4", "P5"};
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        initRendererer(renderer);

        MultipleCategorySeries series = new MultipleCategorySeries("Project Budget");
        series.add("Project Budget", titles, values);
        return newChart(new DoughnutChart(series, renderer));
    }
}
